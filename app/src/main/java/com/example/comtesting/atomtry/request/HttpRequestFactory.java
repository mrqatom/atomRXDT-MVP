package com.example.comtesting.atomtry.request;

/**
 * Created by atom on 2017/2/24.
 * 获得请求实例的工厂，实现可替换原则
 */

public class HttpRequestFactory {
    private static mHttpRequest mHttpRequest;

    public static mHttpRequest getRetrofitHttpRequest() {
        if (mHttpRequest == null) {
            synchronized (HttpRequestFactory.class) {
                if (mHttpRequest == null) {
                    mHttpRequest = new retrofitHttpRequest();
                }
            }
        }
        return mHttpRequest;
    }
}
