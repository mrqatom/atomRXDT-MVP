package com.example.comtesting.atomtry.data.repository;


import android.support.annotation.Nullable;

import com.example.comtesting.atomtry.data.greendao.userLogin;
import com.example.comtesting.atomtry.greendao.gen.userLoginDao;
import com.example.comtesting.atomtry.mApplication;

import java.util.List;

/**
 * Created by atom on 2017/2/24.
 */

public class UserRepository {
    private userLoginDao daoSession;

    public UserRepository() {
        daoSession = ((mApplication) mApplication.getmContext()).getDaoSession().getUserLoginDao();
    }

    /**
     * 数据库：增
     *
     * @param bean
     */
    public void insertUser(userLogin bean) {
        daoSession.insert(bean);
    }

    /**
     * 数据库：删
     *
     * @param id
     */
    public void deleteUser(Long id) {
        daoSession.deleteByKey(id);
    }

    public void deleteUser(userLogin bean) {
        deleteUser(bean.getId());
    }

    /**
     * 数据库：改
     *
     * @param id   修改前的ID
     * @param bean 修改后的Data
     */
    public void upDataUser(userLogin bean, @Nullable Long id) {
        if (id != null) bean.setId(id);
        daoSession.update(bean);
    }

    /**
     * 数据库：查
     *
     * @param id
     */
    public userLogin queryUser(Long id) {
        return daoSession.load(id);
    }
    public List<userLogin> queryAllUser() {
        return daoSession.loadAll();
    }
}
