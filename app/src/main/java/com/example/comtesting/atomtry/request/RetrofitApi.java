package com.example.comtesting.atomtry.request;



import com.example.comtesting.atomtry.request.parameter.HttpParameter;
import com.example.comtesting.atomtry.request.parameter.userParameter;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by atom on 2017/3/14.
 * Retrofit API
 */

public interface RetrofitApi {

    @POST
    Observable<HttpResult> getResponse(@Url String url, @Body Map<String, String> parameter);

    //这里踩坑记录：retrofit不支持：<T>type泛型
    @POST
    Observable<HttpResult> getResponse(@Url String url);
}
