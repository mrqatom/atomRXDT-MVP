package com.example.comtesting.atomtry.login;

import com.example.comtesting.atomtry.mAppComponent;
import com.example.comtesting.atomtry.scope.fragmentScoped;

import dagger.Component;

/**
 * Created by atom on 2017/2/24.
 * dagger的登录component
 */
@fragmentScoped
@Component(dependencies = mAppComponent.class,modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
