package com.example.comtesting.atomtry;

import android.content.Context;

import com.example.comtesting.atomtry.request.HttpRequestFactory;
import com.example.comtesting.atomtry.request.mHttpRequest;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by atom on 2017/2/24.
 * 全局module
 */
@Module
public class mAppModule {
    private Context mContext;

    public mAppModule(Context mContext) {
        this.mContext = mContext;
    }

    @Singleton
    @Provides
    public mHttpRequest provideHttpRequest() {
        return HttpRequestFactory.getRetrofitHttpRequest();
    }

}
