package com.example.comtesting.atomtry.request.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by atom on 2017/3/15.
 */

public class HttpParameter {
    public Map<String,String> parameters;
    public Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public HttpParameter() {
        parameters = new HashMap<>();
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
    public void addParameter(String key,String parameter){
        parameters.put(key,parameter);
    }
//    public abstract void setParameterToField();
}
