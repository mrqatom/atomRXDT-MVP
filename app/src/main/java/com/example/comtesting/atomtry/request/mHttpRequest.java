package com.example.comtesting.atomtry.request;

import com.example.comtesting.atomtry.request.parameter.HttpParameter;
import com.example.comtesting.atomtry.request.parameter.userParameter;

/**
 * Created by atom on 2017/2/24.
 * 网络请求
 */

public interface mHttpRequest {
    <T>void request(String url,mCallBack<T> callBack);
    <T>void request(String url, HttpParameter param, mCallBack<T> callBack);

}
