package com.example.comtesting.atomtry.request.parameter;

/**
 * Created by atom on 2017/3/19.
 */
@Deprecated
public class userParameter{
    private String phone;
    private String psw;

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    @Override
//    public void setParameterToField() {
//        phone = parameters.get("phone");
//        psw = parameters.get("psw");
//    }
}
