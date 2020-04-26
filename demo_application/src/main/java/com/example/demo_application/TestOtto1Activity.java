package com.example.demo_application;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.otto.Subscribe;

import androidx.appcompat.app.AppCompatActivity;

public class TestOtto1Activity extends AppCompatActivity {
    private static final String    TAG = "majin";
    private              EventData mEventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_otto1);
        setTitle("TestOtto1Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "第二个页面注册");
        BusProvider.getInstance().register(this);//订阅事件
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "第二个页面反注册");
        BusProvider.getInstance().unregister(this);//注销订阅
    }

    /**
     * 接受数据
     *
     * @param data
     */
    @Subscribe
    public void subscribeEvent(EventData data) {
        mEventData = data;
        Log.d(TAG, "TestOtto1Activity 第二个页面 接受数据 " + data.toString());
    }

    /**
     * 发送数据
     */
    public void onSendDate(View view) {
        setDate();
    }

    private void setDate() {
        mEventData.setContent("第二个页面 传入数据 ------------------- hello word!");
        mEventData.setFlag("3");
        BusProvider.getInstance().post(mEventData);//发布事件

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setDate();
    }

    public void onGtoTestOtto2Activity(View view) {
        jumpToTestOtto2Activity(this);
    }

    public static void jumpToTestOtto2Activity(Context context) {
        context.startActivity(new Intent(context, TestOtto2Activity.class));
    }

}
