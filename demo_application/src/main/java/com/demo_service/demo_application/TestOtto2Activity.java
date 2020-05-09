package com.demo_service.demo_application;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.otto.Subscribe;

import androidx.appcompat.app.AppCompatActivity;

public class TestOtto2Activity extends AppCompatActivity {
    private static final String    TAG = "majin";
    private              EventData mEventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_otto2);
        setTitle("TestOtto2Activity");

    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
     BusProvider.getInstance().unregister(this);

    }

//    @Produce
//    public EventData produceEvent() {
//      //  EventData mEventData = new EventData(" TestOtto2Activity produceEvent()------初始化数据");
//      //  mEventData.setContent(" TestOtto2Activity produceEvent()------初始化数据");
//
//        return mEventData;
//    }

    /**
     * 接受数据
     *
     * @param data
     */
    @Subscribe
    public void subscribeEvent(EventData data) {
        Log.d(TAG, "TestOtto2Activity 第三个页面接受数据 "+ data.toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onSendDate(View view) {
        EventData mEventData = new EventData( );
        mEventData.setContent("第三个页面------------发送数据");
        mEventData.setFlag("3");
        BusProvider.getInstance().post(mEventData);//发布事件
    }
}
