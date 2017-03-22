package com.example.comtesting.atomtry;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.example.comtesting.atomtry.request.retrofitHttpRequest;


/**
 * Created by atom on 2017/2/24.
 */

public class mApplication extends Application {
    private static mAppComponent mAppComponent;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        retrofitHttpRequest.init();
        mAppComponent = DaggermAppComponent.builder()
                .mAppModule(new mAppModule()).build();
    }

    public static Context getmContext() {
        return mContext;
    }

    public static mAppComponent getAppComponent() {
        return mAppComponent;
    }
}
