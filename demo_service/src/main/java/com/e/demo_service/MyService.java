package com.e.demo_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * 外部通过AIDl绑定服务，执行逻辑运算后，马上
 */
public class MyService extends Service {
    private static int           INSIDE   = 0;//0内部连接
    private static int           EXTERNAL = 1;//1外部Aidl连接
    private        MyServiceConn mysc;

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d("majin", "正式创建 ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("majin", "onStartCommand ");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("majin", "Service销毁 ");
    }

    private Intent intent;

    @Override
    public boolean onUnbind(Intent intent) {
        if (intent.getIntExtra("call", - 1) == INSIDE) {
            Log.d("majin", "内部解绑服务");
        } else if (intent.getIntExtra("call", - 1) == EXTERNAL) {
            Log.d("majin", "外部通过AIDl解绑服务");
        }
        return super.onUnbind(intent);
    }


    @Override
    public IBinder onBind(Intent intent) {
        this.intent = intent;
        Log.d("majin", "Service onBind");
        MyBinder myBinder = new MyBinder();
        IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(myBinder);
        if (intent.getIntExtra("call", - 1) == INSIDE) {
            Log.d("majin", "内部绑定服务");
        } else if (intent.getIntExtra("call", - 1) == EXTERNAL) {
            Log.d("majin", "外部通过AIDL绑定服务----做逻辑处理");

        }
        return iMyAidlInterface.asBinder();


    }

    //实现AIDL接口
    public class MyBinder extends Binder implements Iservice {

        @Override
        public void
        downLoad(String url) {
            MyService.this.downLoad(url);
        }

        @Override
        public void playMusic(String name) {
            MyService.this.playMusic(name);

        }

        @Override
        public void stop() {
            MyService.this.stop();
        }


        @Override
        public IBinder asBinder() {
            Log.d("majin", "asBinder   ");
            return this;
        }

        @Override
        public void showProgress(String str) throws RemoteException {
            Log.d("majin", str);
        }
    }

    boolean isWhile = false;

    public void downLoad(String url) {
        //                new Thread(new Runnable() {
        //                    @Override
        //                    public void run() {
        //                        if (isWhile == false) {
        //                            int i1 = 0;
        //                            for (int i = 0; i < 10; i++) {
        //                                i1 = i;
        //                                Log.d("majin", "service 中开始下载" + i);
        //                            }
        //                            if (i1 == 9) {
        //                                downLoad("111");
        //                            }
        //                        }
        //                    }
        //                }).start();
        Log.d("majin", "service 中开始下载");

    }

    public void stop() {
        isWhile = true;
    }

    public void playMusic(String name) {
        Log.d("majin", "service 中开始播放音乐");
    }
}
