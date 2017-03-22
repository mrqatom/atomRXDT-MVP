package com.example.comtesting.atomtry.request;

/**
 * Created by atom on 2017/2/24.
 * 请求返回
 */

public interface mCallBack<T> {
    void success(T response);

    void fail(String message);
}
