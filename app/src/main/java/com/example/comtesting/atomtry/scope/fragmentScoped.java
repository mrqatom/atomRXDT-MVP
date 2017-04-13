package com.example.comtesting.atomtry.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by atom on 2017/4/13.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface fragmentScoped {
}
