package com.example.comtesting.atomtry.login;

import com.example.comtesting.atomtry.base.BasePresenter;
import com.example.comtesting.atomtry.base.BaseView;
import com.example.comtesting.atomtry.data.bean.UserLoginBean;
import com.example.comtesting.atomtry.data.greendao.userLogin;

/**
 * Created by atom on 2017/2/24.
 * login的view、presenter接口
 */

public interface LoginContract {
    interface View extends BaseView<LoginPresenter> {
        void showLoginDialog();

        void showLoginSuccess(UserLoginBean bean);

        void showLoginFail(String message);

        boolean isActive();

        boolean isRemember();

        void initUser(userLogin user);
    }

    interface presenter extends BasePresenter {
        void login(String userName, String password);
    }
}
