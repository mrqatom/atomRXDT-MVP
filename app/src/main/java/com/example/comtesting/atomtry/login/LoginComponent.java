package com.example.comtesting.atomtry.login;

import dagger.Component;

/**
 * Created by atom on 2017/2/24.
 * dagger的登录component
 */

@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
