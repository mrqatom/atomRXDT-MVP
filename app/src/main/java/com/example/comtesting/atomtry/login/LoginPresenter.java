package com.example.comtesting.atomtry.login;

import com.example.comtesting.atomtry.data.bean.UserLoginBean;
import com.example.comtesting.atomtry.data.repository.UserRepository;
import com.example.comtesting.atomtry.request.parameter.HttpParameter;
import com.example.comtesting.atomtry.request.mCallBack;
import com.example.comtesting.atomtry.request.parameter.userParameter;
import com.example.comtesting.atomtry.utils.ciPherUtils;

import javax.inject.Inject;

import static com.example.comtesting.atomtry.request.HttpRequestFactory.getRetrofitHttpRequest;

/**
 * Created by atom on 2017/2/24.
 *
 */

public class LoginPresenter implements LoginContract.presenter {
    private final LoginContract.View mView;
    private final UserRepository mUserRepository;
    @SuppressWarnings("FieldCanBeLocal")
    private final String loginUrl = "Home/User/login";

    @Inject
    public LoginPresenter(LoginContract.View mView, UserRepository mUserRepository) {
        this.mView = mView;
        this.mUserRepository = mUserRepository;
        mView.setPresenter(this);
    }

    @Override
    public void init() {

    }

    @Override
    public void login(String userName, String password) {
        mView.showLoginDialog();
        HttpParameter parameter = new HttpParameter();
        parameter.addParameter("phone", userName);
        parameter.addParameter("psw",ciPherUtils.Str2MD5LowCase(password));
        parameter.setClazz(UserLoginBean.class);
        getRetrofitHttpRequest().request(loginUrl, parameter, new mCallBack<UserLoginBean>() {
            @Override
            public void success(UserLoginBean response) {
                mView.showLoginSuccess(response);
            }

            @Override
            public void fail(String message) {
                mView.showLoginFail(message);
            }
        });
    }

}
