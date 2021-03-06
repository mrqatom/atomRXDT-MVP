package com.example.comtesting.atomtry.request;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 *
 * @author atom
 * @date 2017/3/14
 * Retrofit API
 */

public interface RetrofitApi {

    @POST
    Observable<HttpResult> getResponse(@Url String url, @Body Map<String, String> parameter);

    //这里踩坑记录：retrofit不支持：<T>type泛型
    @POST
    Observable<HttpResult> getResponse(@Url String url);
}
