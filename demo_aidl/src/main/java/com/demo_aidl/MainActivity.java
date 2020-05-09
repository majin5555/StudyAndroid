package com.demo_aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.e.demo_service.IMyAidlInterface;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 学习 AIDl
 * <p>
 * AIDl接口要与被调用Service的AIDl接口完全一致
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "majin";

    public static final String ACTION  = "com.e.demo_service.control_myservice";
    public static final String PACKAGE = "com.e.demo_service";


    public static final ServiceConnection CONN = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "demo aidl   1 " + service);
            IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            Log.d(TAG, "demo aidl  2 " + iMyAidlInterface.asBinder());

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "demo aidl   onServiceDisconnected   " + name);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("demo_aidl");
    }

    public void click1(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.setPackage(PACKAGE);
        startService(intent);
    }

    public void click2(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.setPackage(PACKAGE);
        stopService(intent);
    }

    Intent bindintent;

    public void click3(View view) {
        bindintent = new Intent();
        bindintent.setAction(ACTION);
        bindintent.setPackage(PACKAGE);
        bindintent.putExtra("call", 1);//传递外部调用Flag
        bindService(bindintent, CONN, Context.BIND_AUTO_CREATE);
    }

    public void click4(View view) {
        if (bindintent != null) {
            unbindService(CONN);
            bindintent = null;
        }
    }
}
