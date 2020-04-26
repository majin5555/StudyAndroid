package com.e.demo_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MainActivity.myServiceConn myServiceConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);

    }

    public void click2(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    public void click3(View view) {
        Intent intent = new Intent(this, MyService.class);
        myServiceConn = new myServiceConn();
        bindService(intent, myServiceConn, Context.BIND_AUTO_CREATE);
    }
    public void click4(View view) {
        myServiceConn.iservice.stop();
        unbindService(myServiceConn);
    }
    private class myServiceConn implements ServiceConnection {

        private Iservice iservice;

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("majin", "连接");
            //            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            //            MyService sevice = myBinder.getSevice();
            //            sevice.downLoad();
            iservice = (Iservice) service;
            iservice.downLoad("1111");
            //            iservice.playMusic();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("majin", "断开连接");

        }
    }


}
