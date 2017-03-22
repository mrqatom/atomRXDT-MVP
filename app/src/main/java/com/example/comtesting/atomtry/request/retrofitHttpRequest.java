package com.example.comtesting.atomtry.request;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.comtesting.atomtry.data.bean.UserLoginBean;
import com.example.comtesting.atomtry.mApplication;
import com.example.comtesting.atomtry.request.parameter.HttpParameter;
import com.example.comtesting.atomtry.request.parameter.userParameter;
import com.example.comtesting.atomtry.utils.ExceptionUtils;
import com.example.comtesting.atomtry.utils.RxjavaFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by atom on 2017/2/24.
 * retrofit请求
 */

public class retrofitHttpRequest implements mHttpRequest {

    private static final String BASE_URL = "http://139.196.54.139/";
    private static RetrofitApi api;

    private static Retrofit retrofit;

    public static void init() {
        if (retrofit == null) {
            // 指定缓存路径,缓存大小100Mb
            Cache cache = new Cache(new File(mApplication.getmContext().getCacheDir(), "HttpCache"),
                    1024 * 1024 * 100);
            OkHttpClient client = new OkHttpClient.Builder().cache(cache)
                    .connectTimeout(3, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            api = retrofit.create(RetrofitApi.class);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void request(String url, final mCallBack<T> callBack) {
        api.getResponse(url)
                .subscribeOn(Schedulers.io())
                .map(new Function<HttpResult, T>() {
                    @Override
                    public T apply(HttpResult tHttpResult) throws Exception {
                        if (tHttpResult.isStatus()) {
                            return (T) tHttpResult.getData();
                        }
                        callBack.fail(tHttpResult.getStatusCode());
                        return null;
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        callBack.success((T) o);
                    }
                });
    }

    @Override
    public <T> void request(String url, final HttpParameter param, final mCallBack<T> callBack) {
        api.getResponse(url, param.getParameters())
                .map(new Function<HttpResult, T>() {
                    @SuppressWarnings("unchecked")
                    @Override
                    public T apply(HttpResult tHttpResult) throws Exception {
                        if (tHttpResult.isStatus()) {
//                            Log.e("retrofitHttpRequest:", "request: " + tHttpResult.getData());
                            //这里因为api里没有填泛型<T>导致返回的数据不是bean，所以用gson转换一下
                            return (T) new Gson().fromJson(tHttpResult.getData().toString(), param.getClazz());
                        } else {
                            Log.e("retrofitHttpRequest", "apply: " + tHttpResult.getMessage());
                            Log.e("retrofitHttpRequest:", "request: " + tHttpResult.getStatusCode());
                            throw new Exception(tHttpResult.getMessage());
                        }
                    }
                })
                // 获取异常并进行判断，优雅的返回
                .onErrorResumeNext(new RxjavaFactory.HttpResponseFunc<T>())
                .compose(RxjavaFactory.<T>io_main_trasformer())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("retrofitHttpRequest", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(T value) {
//                        Log.e("retrofitHttpRequest", "onNext: "+value.getClass());
                        if (value != null)
                            callBack.success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fail(e.getMessage());
                        Log.e("retrofitHttpRequest", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("retrofitHttpRequest", "onComplete: ");
                    }
                });
    }

    //    private void initInject() {
// 这里有个坑，有泛型的类不能直接在component里面inject()
//        mApplication.getAppComponent().inject(this);
//    }
}
