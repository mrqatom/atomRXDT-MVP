package com.example.comtesting.atomtry.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.comtesting.atomtry.R;
import com.example.comtesting.atomtry.base.baseFragment;
import com.example.comtesting.atomtry.data.bean.UserLoginBean;
import com.example.comtesting.atomtry.home.homeActivity;
import com.example.comtesting.atomtry.register.RegisterActivity;

/**
 * Created by atom on 2017/2/24.
 * 登录fragment
 */

public class LoginFragment extends baseFragment implements LoginContract.View, View.OnClickListener {
    private LoginPresenter mPresenter;
    private EditText etUser;
    private EditText etPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        etUser = (EditText) v.findViewById(R.id.login_et_user);
        etPassword = (EditText) v.findViewById(R.id.login_et_password);
        v.findViewById(R.id.login_btn_login).setOnClickListener(this);
        v.findViewById(R.id.login_btn_register).setOnClickListener(this);
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void showLoginDialog() {
        showProgressDialog("登录中....");
    }

    @Override
    public void showLoginSuccess(UserLoginBean bean) {
        if (progressDialog.isShowing()) disMissProgressDialog();
        Intent intent = new Intent(getActivity(), homeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoginFail(String message) {
        if (progressDialog.isShowing()) disMissProgressDialog();
        showToast(message);
    }

    private void showRegisterUi() {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn_login:
                mPresenter.login(etUser.getText().toString()
                        , etPassword.getText().toString());
                break;
            case R.id.login_btn_register:
                showRegisterUi();
                break;
        }
    }
}
