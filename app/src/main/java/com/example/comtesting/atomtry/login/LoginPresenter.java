package com.example.comtesting.atomtry.login;

import com.example.comtesting.atomtry.data.bean.UserLoginBean;
import com.example.comtesting.atomtry.data.greendao.userLogin;
import com.example.comtesting.atomtry.data.repository.UserRepository;
import com.example.comtesting.atomtry.request.HttpRequestFactory;
import com.example.comtesting.atomtry.request.mHttpRequest;
import com.example.comtesting.atomtry.request.parameter.HttpParameter;
import com.example.comtesting.atomtry.request.mCallBack;
import com.example.comtesting.atomtry.utils.ciPherUtils;

import javax.inject.Inject;


/**
 * Created by atom on 2017/2/24.
 *
 */

public class LoginPresenter implements LoginContract.presenter {
    private final LoginContract.View mView;
    private final UserRepository mUserRepository;
    private final mHttpRequest mHttpRequest;
    @SuppressWarnings("FieldCanBeLocal")
    private final String loginUrl = "Home/User/login";

    @Inject
    public LoginPresenter(LoginContract.View mView, UserRepository mUserRepository,mHttpRequest mHttpRequest) {
        this.mView = mView;
        this.mUserRepository = mUserRepository;
        this.mHttpRequest=mHttpRequest;
    }
    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }
    @Override
    public void init() {
        userLogin user=mUserRepository.queryUser(1L);
        if (user!=null){
            mView.initUser(user);
        }
    }

    @Override
    public void login(final String userName, final String password) {
        mView.showLoginDialog();
        HttpParameter parameter = new HttpParameter();
        parameter.addParameter("phone", userName);
        parameter.addParameter("psw",ciPherUtils.Str2MD5LowCase(password));
        parameter.setClazz(UserLoginBean.class);
        mHttpRequest.request(loginUrl, parameter, new mCallBack<UserLoginBean>() {
            @Override
            public void success(UserLoginBean response) {
                mView.showLoginSuccess(response);
                if (mUserRepository.queryUser(1L)!=null){
                    mUserRepository.upDataUser(new userLogin(1L,userName,password,mView.isRemember()),null);
                }else {
                    mUserRepository.insertUser(new userLogin(1L,userName,password,mView.isRemember()));
                }
            }

            @Override
            public void fail(String message) {
                mView.showLoginFail(message);
            }
        });
    }

}
