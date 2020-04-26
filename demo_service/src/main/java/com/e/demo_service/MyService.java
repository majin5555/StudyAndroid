package com.e.demo_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
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

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("majin", "Service onBind");
        return new MyBinder();
    }

    public class MyBinder extends Binder implements Iservice {
        Iservice getSevice() {
            //     return MyService.this;
            return this;
        }

        @Override
        public void downLoad(String url) {
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
    }

    boolean isWhile = false;

    public void downLoad(String url) {
        new  Thread(new Runnable() {
            @Override
            public void run() {
                if (isWhile == false) {
                    int i1 = 0;
                    for (int i = 0; i < 10; i++) {
                        i1 = i;
                        Log.d("majin", "service 中开始下载" + i);
                    }
                    if (i1 == 9) {
                        downLoad("111");
                    }
                }
            }
        }).start();

    }

    public void stop() {
        isWhile = true;
    }

    public void playMusic(String name) {
        Log.d("majin", "service 中开始播放音乐");
    }
}
