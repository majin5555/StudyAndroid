package com.e.demo_service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 绑定服务后   在调用stopService 就不好使了
 * 若想停止 只能调用unbindService（）
 */
public class MainActivity extends AppCompatActivity {

    private MyServiceConn myServiceConn;

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
        intent.putExtra("call", 0);//内部调用flag
        myServiceConn = new MyServiceConn();
        bindService(intent, myServiceConn, Context.BIND_AUTO_CREATE);
    }

    public void click4(View view) {
        if (myServiceConn != null) {
            myServiceConn.iservice.stop();//停止循环（耗时操作）
            unbindService(myServiceConn);
            myServiceConn = null;
        } else {
            Log.d("majin", "内部解绑失败");
        }

    }


}
