package com.example.demo_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;

import androidx.appcompat.app.AppCompatActivity;

public class Main0Activity extends AppCompatActivity {
    private static final String    TAG = "majin";
    private              MyApp     myApp;
    private              EventData mEventData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main0Activity");

        // Log.d(TAG, "onCreate  " + getApplication());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mEventData == null) {
            Log.d(TAG, "第一个页面注册");
            BusProvider.getInstance().register(this);//订阅事件
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "第一个页面反注册");
        BusProvider.getInstance().unregister(this);//注销订阅
    }

    /**
     * 接受数据
     *
     * @param data
     */
    @Subscribe
    public void subscribeEvent(EventData data) {
        Log.d(TAG, "Main0Activity  第一个页面 接受数据   " + data.toString());
    }

    /**
     * register 后就触发@Produce的方法
     * 发送数据
     */
    @Produce
    public EventData MainActivitySend() {
        if (mEventData == null) {
            mEventData = new EventData();
            mEventData.setContent("第一个页面 传入数据1");
            mEventData.setFlag("1");
            Log.d(TAG, "Main0Activity   MainActivitySend()");
        }
        return mEventData;
    }

    /**
     * 跳转 TestOtto1Activity
     *
     * @param view
     */
    public void onGotoOtto1(View view) {
        mEventData.setContent("第一个页面  传入数据2");
        mEventData.setFlag("2");
        BusProvider.getInstance().post(MainActivitySend());//发布事件
        jumpToTestOtto1Activity(this);
    }

    public void onSetting(View view) {
        myApp = (MyApp) getApplication();
        Toast.makeText(this, "设置前 " + myApp.getUserName(), Toast.LENGTH_SHORT).show();
        myApp.setUserName("设置用户名------马晋");
    }

    public void onGetting(View view) {
        Toast.makeText(this, myApp.getUserName(), Toast.LENGTH_SHORT).show();
    }

    public static void jumpToTestOtto1Activity(Context context) {
        context.startActivity(new Intent(context, TestOtto1Activity.class));

    }


}
