package com.example.comtesting.atomtry.base;


/**
 * Created by atom on 2017/2/24.
 * view层基础接口
 */

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
