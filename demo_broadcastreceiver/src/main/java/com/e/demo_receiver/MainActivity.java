package com.e.demo_receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/***
 * 1.静态注册的广播 只需要在manifest清完文件中注册
 *
 * 2.动态注册
 *
 */
public class MainActivity extends AppCompatActivity {

    public static final String MY_ACTION         = "RegisterReceiver2";
    public static final String BROADCAST_CONTENT = "broadcast_content";

    private static final String      TAG = "MainActivity";
    private              MyReceiver2 myReceiver2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myReceiver2 = new MyReceiver2((TextView) findViewById(R.id.tvhello));
        RegisterReceiver();
    }

    /**
     * 注册自定义广播
     */
    private void onSendBroadcastreceiver() {
        Intent intent = new Intent(MY_ACTION);
        intent.putExtra(BROADCAST_CONTENT, "被接收的自定义广播内容。。。");
        sendBroadcast(intent);
    }


    //注册系统广播
    private void RegisterReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MY_ACTION);
        //  intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        //    intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        //    intentFilter.addDataScheme("package");
        registerReceiver(myReceiver2, intentFilter);
    }

    //反注册系统广播
    private void UnregisterReceiver() {
        if (myReceiver2 != null) unregisterReceiver(myReceiver2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UnregisterReceiver();
    }

    public void onSendreceiver(View view) {
        onSendBroadcastreceiver();
        Toast.makeText(this, "发送广播", Toast.LENGTH_SHORT).show();

    }
}
