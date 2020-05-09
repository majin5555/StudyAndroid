package com.e.demo_service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * @author: mj
 * @date: 2020/5/9$
 * @desc:
 */
public class MyServiceConn implements ServiceConnection {

    public Iservice iservice;


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d("majin", "连接    name.toString()   ------" + name.toString() + "    service----" + service);

        MyService.MyBinder myBinder = (MyService.MyBinder) service;
        myBinder.downLoad("1111");
        try {
            myBinder.showProgress("内部传入的值======》1");
            String s = myBinder.returnData();
            Log.d("majin", "demo demo_service   " + s);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("majin", "断开连接");
    }

}


