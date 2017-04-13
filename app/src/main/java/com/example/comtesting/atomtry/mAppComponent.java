package com.example.comtesting.atomtry;

import android.content.Context;

import com.example.comtesting.atomtry.request.mHttpRequest;
import com.example.comtesting.atomtry.request.retrofitHttpRequest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by atom on 2017/2/24.
 * 全局component
 */
@Singleton
@Component(modules = mAppModule.class)
public interface mAppComponent {
    mHttpRequest getMHttpRequest();
}
