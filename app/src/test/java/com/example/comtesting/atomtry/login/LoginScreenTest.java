package com.example.comtesting.atomtry.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.example.comtesting.atomtry.BuildConfig;
import com.example.comtesting.atomtry.R;
import com.example.comtesting.atomtry.home.homeActivity;
import com.example.comtesting.atomtry.myRobolectricTestRunner;
import com.example.comtesting.atomtry.register.RegisterActivity;
import com.example.comtesting.atomtry.utils.RxjavaFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;


/**
 * Created by atom on 2017/4/14.
 */
@RunWith(myRobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoginScreenTest {
    @Before
    public void setUp(){
        //将rx异步转同步
        RxjavaFactory.asyncToSync();
    }
    @Test
    public void RegisterTest() {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        //activity可以直接找到fragment里的控件
//        Fragment fragment = loginActivity.getSupportFragmentManager().findFragmentById(R.id.login_content);
        Button btn_register = (Button) loginActivity.findViewById(R.id.login_btn_register);
        btn_register.performClick();
        Intent expectedIntent = new Intent(loginActivity, RegisterActivity.class);
        ShadowActivity shadowActivity = Shadows.shadowOf(loginActivity);
        Intent realIntent = shadowActivity.getNextStartedActivity();
        //Robolectric3.1后不支持assertEquals(intent, intent)格式;
        assertEquals(expectedIntent.getComponent(), realIntent.getComponent());
    }

    @Test
    public void LoginSuccessTest(){
        LoginActivity loginActivity=Robolectric.setupActivity(LoginActivity.class);
        EditText etUser= (EditText) loginActivity.findViewById(R.id.login_et_user);
        EditText etPassword= (EditText) loginActivity.findViewById(R.id.login_et_password);
        Button btn_login = (Button) loginActivity.findViewById(R.id.login_btn_login);
        etUser.setText("18781625052");
        etPassword.setText("123456");
        btn_login.performClick();
        Intent exceptedIntent=new Intent(loginActivity, homeActivity.class);
        ShadowActivity shadowActivity=Shadows.shadowOf(loginActivity);
        Intent realIntent=shadowActivity.getNextStartedActivity();
        //最开始很傻很天真的等待请求结束
//        while (realIntent==null){
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            realIntent=shadowActivity.getNextStartedActivity();
//        }
        assertEquals(exceptedIntent.getComponent(),realIntent.getComponent());
    }

}
