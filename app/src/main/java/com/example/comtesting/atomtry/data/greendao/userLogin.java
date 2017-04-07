package com.example.comtesting.atomtry.data.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by atom on 2017/4/6.
 */
@Entity
public class userLogin {
    @Id(autoincrement = true)
    private Long id;
    private String userName;
    private String password;
    private boolean isRemember;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsRemember() {
        return this.isRemember;
    }

    public void setIsRemember(boolean isRemember) {
        this.isRemember = isRemember;
    }

    @Generated(hash = 1270635441)
    public userLogin(Long id, String userName, String password, boolean isRemember) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isRemember = isRemember;
    }

    @Generated(hash = 1680734102)
    public userLogin() {
    }
}
