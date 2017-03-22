package com.example.comtesting.atomtry;

import android.content.Context;

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
//    private Context mContext;
//
//    public mAppModule(Context mContext) {
//        this.mContext = mContext;
//    }

//    @Singleton
//    @Provides
//    public OkHttpClient provideOkHttpClient() {
//        return new OkHttpClient.Builder()
//                .connectTimeout(3, TimeUnit.SECONDS)
//                .build();
//    }
//
//    @Singleton
//    @Provides
//    public Retrofit provideRetrofit(OkHttpClient client) {
//        return new Retrofit.Builder()
//                .client(client)
//                .baseUrl("http://139.196.54.139/Home/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//    }

}
