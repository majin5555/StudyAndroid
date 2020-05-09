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
        Log.d("majin", "连接    " + name.toString());
        iservice = (Iservice) service;
        iservice.downLoad("1111");
        try {
            iservice.showProgress("com.e.demo_service 的传值");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        iservice.playMusic("");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("majin", "断开连接");
    }

}


