package com.example.comtesting.atomtry.login;

import com.example.comtesting.atomtry.base.BasePresenter;
import com.example.comtesting.atomtry.base.BaseView;
import com.example.comtesting.atomtry.data.bean.UserLoginBean;

/**
 * Created by atom on 2017/2/24.
 * login的view、presenter接口
 */

public interface LoginContract {
    interface View extends BaseView<LoginPresenter> {
        void showLoginDialog();

        void showLoginSuccess(UserLoginBean bean);

        void showLoginFail(String message);

        void showLoginError();

        void showRegisterUi();

        boolean isActive();

    }

    interface presenter extends BasePresenter {
        void login(String userName, String password);
    }
}
