package com.example.comtesting.atomtry.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by atom on 2017/2/24.
 * activity工具包
 */

public class ActivityUtils {

    /**
     * 添加fragment
     */
    public static void addFragment(FragmentManager manager, Fragment fragment, int layoutId) {
        checkNotNull(manager);
        checkNotNull(fragment);
        manager.beginTransaction().add(layoutId, fragment).commit();
    }

}
