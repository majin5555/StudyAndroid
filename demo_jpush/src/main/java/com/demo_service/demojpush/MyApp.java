package com.demo_service.demojpush;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * @author: mj
 * @date: 2020/4/28$
 * @desc:
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }
}
