package com.example.comtesting.atomtry.login;


import com.example.comtesting.atomtry.data.repository.UserRepository;
import com.example.comtesting.atomtry.request.HttpRequestFactory;
import com.example.comtesting.atomtry.request.mHttpRequest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by atom on 2017/2/24.
 * dagger的登录module
 */
@Module
public class LoginModule {
    private LoginContract.View mView;

    public LoginModule(LoginContract.View mView) {
        this.mView = mView;
    }

    @Provides
    LoginContract.View provideView(){
        return mView;
    }
    @Provides
    UserRepository provideUserRepository(){
        return new UserRepository();
    }
//    @Provides
//    mHttpRequest provideRequest(){
//        return HttpRequestFactory.getRetrofitHttpRequest();
//    }
}
