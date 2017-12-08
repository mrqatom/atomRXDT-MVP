package com.example.comtesting.atomtry.base;

import com.example.comtesting.atomtry.data.repository.UserRepository;
import com.example.comtesting.atomtry.request.mHttpRequest;

import javax.inject.Inject;

/**
 * Created by atom on 2017/2/24.
 * presenter层
 */

public class BasePresenter<V extends BaseView>{
    public final V mView;
    public final UserRepository mUserRepository;
    public final mHttpRequest mHttpRequest;

    public BasePresenter(V mView, UserRepository mUserRepository, com.example.comtesting.atomtry.request.mHttpRequest mHttpRequest) {
        this.mView = mView;
        this.mUserRepository = mUserRepository;
        this.mHttpRequest = mHttpRequest;
    }

    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }

}
