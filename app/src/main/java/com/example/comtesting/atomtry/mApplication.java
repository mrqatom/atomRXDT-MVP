package com.example.comtesting.atomtry;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.example.comtesting.atomtry.greendao.gen.DaoMaster;
import com.example.comtesting.atomtry.greendao.gen.DaoSession;
import com.example.comtesting.atomtry.request.retrofitHttpRequest;

import org.greenrobot.greendao.database.Database;


/**
 * Created by atom on 2017/2/24.
 */

public class mApplication extends Application {
    private static mAppComponent mAppComponent;

    private DaoSession daoSession;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        initGreenDao();
        retrofitHttpRequest.init();
        mAppComponent = DaggermAppComponent.builder()
                .mAppModule(new mAppModule(mContext)).build();
    }

    public static Context getmContext() {
        return mContext;
    }

    public static mAppComponent getAppComponent() {
        return mAppComponent;
    }

    private void initGreenDao(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "atom_db" );
        Database db = helper.getReadableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
