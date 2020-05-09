package com.demo_service.demo_application;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author: mj
 * @date: 2020/4/24$
 * @desc:
 */
public class MyApp extends Application {
    private static final String TAG = "MyApp";

    private  String  userName="majin";

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, this + "");

    }

    /**
     * 偶尔之发生变化
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(TAG, this + "   onConfigurationChanged    newConfig  " + newConfig);

    }

    /**
     * 系统内存吃紧回调
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();

        Log.d(TAG, "onLowMemory   ");

    }


}
