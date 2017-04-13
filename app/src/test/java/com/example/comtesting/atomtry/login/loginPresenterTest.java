package com.example.comtesting.atomtry.login;

import com.example.comtesting.atomtry.data.bean.UserLoginBean;
import com.example.comtesting.atomtry.data.greendao.userLogin;
import com.example.comtesting.atomtry.data.repository.UserRepository;
import com.example.comtesting.atomtry.request.mCallBack;
import com.example.comtesting.atomtry.request.mHttpRequest;
import com.example.comtesting.atomtry.request.parameter.HttpParameter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by atom on 2017/4/8.
 * 测试
 */

public class loginPresenterTest {
    @Mock
    private LoginContract.View mView;
    @Mock
    private UserRepository mUserRepository;
    @Mock
    private mHttpRequest mHttpRequest;

    @Captor
    private ArgumentCaptor<mCallBack> mCallbackCaptor;

    private LoginPresenter mLoginPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mLoginPresenter = new LoginPresenter(mView, mUserRepository, mHttpRequest);
        when(mView.isActive()).thenReturn(true);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLogin() {
        when(mUserRepository.queryUser(anyLong())).thenReturn(new userLogin());
//        doNothing().when(mHttpRequest)
//                .request(anyString(),any(HttpParameter.class),mCallbackCaptor.capture());
        mLoginPresenter.login("233", "2333");
        verify(mView).showLoginDialog();
        verify(mHttpRequest).request(anyString(), any(HttpParameter.class), mCallbackCaptor.capture());
        mCallbackCaptor.getValue().success(any(UserLoginBean.class));
        verify(mView).showLoginSuccess(any(UserLoginBean.class));
        verify(mUserRepository).queryUser(anyLong());
        ArgumentCaptor<userLogin> userLoginCaptor = ArgumentCaptor.forClass(userLogin.class);
        verify(mUserRepository).upDataUser(userLoginCaptor.capture(), anyLong());
        assertEquals("233", userLoginCaptor.getValue().getUserName());
    }
}
