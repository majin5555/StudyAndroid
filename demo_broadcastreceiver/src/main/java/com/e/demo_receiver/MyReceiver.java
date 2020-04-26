package com.e.demo_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/***
 * 静态注册的广播 只需要在manifest清完文件中注册
 *
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent != null) {
            String action = intent.getAction();
            Log.d(TAG, " 静态注册 应用卸载 action  " + action);
        }

    }
}
