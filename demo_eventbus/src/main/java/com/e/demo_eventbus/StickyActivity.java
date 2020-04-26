package com.e.demo_eventbus;


import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.appcompat.app.AppCompatActivity;

public class StickyActivity extends AppCompatActivity {
    private static final String TAG = "StickyActivity";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart ----------------1");

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true)
    public void onStickyMessageEvent(StickyMessageEvent event) {
        Log.d(TAG, "onStickyMessageEvent ----------------2");

        setTitle(event.message);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky);
        Log.d(TAG, "onCreate ----------------3");

    }
}
