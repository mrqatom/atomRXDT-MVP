package com.example.comtesting.atomtry.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.comtesting.atomtry.R;
import com.example.comtesting.atomtry.base.BaseActivity;
import com.example.comtesting.atomtry.utils.ActivityUtils;

import javax.inject.Inject;

/**
 * @author atom
 * 登录activity
 */
public class LoginActivity extends BaseActivity {
    @Inject
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.login_title);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.login);

        LoginFragment fragment=
                (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_content);
        if (fragment==null){
            fragment=LoginFragment.newInstance();
            ActivityUtils.addFragment(getSupportFragmentManager(),fragment,R.id.login_content);
        }
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(fragment)).build().inject(this);
    }
}
