package com.example.comtesting.atomtry.request;

/**
 * Created by atom on 2017/3/15.
 * 网络请求返回
 */

public class HttpResult<T> {
    public String statusCode;
    public boolean status;
    public String message;
    public T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
