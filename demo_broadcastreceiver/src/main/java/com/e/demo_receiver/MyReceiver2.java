package com.e.demo_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import static com.e.demo_receiver.MainActivity.BROADCAST_CONTENT;
import static com.e.demo_receiver.MainActivity.MY_ACTION;

/***
 *动态注册
 *
 */
public class MyReceiver2 extends BroadcastReceiver {
    private static final String   TAG = "MyReceiver2";
    private              TextView textView;

    public MyReceiver2(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Log.d(TAG, " MyReceiver2  onReceive");

        // an Intent broadcast.
        if (intent != null) {
            String action = intent.getAction();
            //获取卸载路径-*-
            String data = intent.getDataString();
            Log.d(TAG, " 动态注册自定义广播  action: " + action);
            if (TextUtils.equals(MY_ACTION, intent.getAction())) {
                String stringExtra = intent.getStringExtra(BROADCAST_CONTENT);
                Log.d(TAG, " 动态接收 stringExtra: " + stringExtra);
                textView.setText(stringExtra);
            }
        }
    }
}
