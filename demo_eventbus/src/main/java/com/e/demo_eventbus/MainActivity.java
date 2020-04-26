package com.e.demo_eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Eventbus 是依赖反射机制的
 * 请配置好混淆
 *
 *
 * 1.接口回调方式更新数据
 * <p>
 * 2020年4月26日14:44:22发布方和订阅方耦合在一起
 * <p>
 * 2.使用本地广播实现通信
 * <p>
 * 3.Eventbus 发布信息
 * <p>
 * 模式：
 * 1.POSTING  期待发布线程与订阅线程在同一线程
 * 2.MAIN    发布方无论运行在哪个线程  订阅方都运行在主线程  事件发布方发布消息后北事件订阅方阻塞了
 * 3.MAIN_ORDERED    发布方无论运行在哪个线程  订阅方都运行在主线程  事件发布方发布消息后不被事件订阅方阻塞
 * 4.BACKAGROUND    a.发布方运行在非UI线程 订阅方跟发布方在同一线程 b.发布方在主线程   订阅方hi新开一个订阅线程
 * 5.ASYNC  耗时操作 是按处理函数运行在新开的独立运行 发布防御订阅方是独立的 不相互阻塞的
 *
 * 6.Sticky粘性事件  先发布 后订阅
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onButton(View view) {
        // Display dialog fragment (publisher)
        final PublisherDialogFragment fragment = new PublisherDialogFragment();
        fragment.show(getFragmentManager(), "publisher");
    }

    @Subscribe
    public void onSuccessEvent(SuccessEvent event) {
        setImageSrc(R.drawable.ic_happy);
    }

    @Subscribe
    public void onFailureEvent(FailureEvent event) {
        setImageSrc(R.drawable.ic_sad);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onPositingEvent(final PostingEvent event) {
        final String threadInfo = Thread.currentThread().toString();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setPublisherThreadInfo(event.threadInfo);
                setSubscriberThreadInfo(threadInfo);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(MainEvent event) {
        setPublisherThreadInfo(event.threadInfo);
        setSubscriberThreadInfo(Thread.currentThread().toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onMainOrderedEvent(MainOrderedEvent event) {
        Log.d(TAG, "onMainOrderedEvent: enter @" + SystemClock.uptimeMillis());
        setPublisherThreadInfo(event.threadInfo);
        setSubscriberThreadInfo(Thread.currentThread().toString());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onMainOrderedEvent: exit @" + SystemClock.uptimeMillis());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBackgroundEvent(final BackgroundEvent event) {
        final String threadInfo = Thread.currentThread().toString();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setPublisherThreadInfo(event.threadInfo);
                setSubscriberThreadInfo(threadInfo);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onAsyncEvent(final AsyncEvent event) {
        final String threadInfo = Thread.currentThread().toString();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setPublisherThreadInfo(event.threadInfo);
                setSubscriberThreadInfo(threadInfo);
            }
        });
    }

    private void setPublisherThreadInfo(String threadInfo) {
        setTextView(R.id.publisherThreadTextView, threadInfo);
    }

    private void setSubscriberThreadInfo(String threadInfo) {
        setTextView(R.id.subscriberThreadTextView, threadInfo);
    }

    /**
     * Should run in UI thread.
     *
     * @param resId
     * @param text
     */
    private void setTextView(int resId, String text) {
        final TextView textView = (TextView) findViewById(resId);
        textView.setText(text);
        textView.setAlpha(.5f);
        textView.animate().alpha(1).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Subscriber");
    }

    /**
     * Update image resource
     *
     * @param resId
     */
    private void setImageSrc(int resId) {
        final ImageView imageView = (ImageView) findViewById(R.id.emotionImageView);
        imageView.setImageResource(resId);
    }

    public void onSticky(View view) {
        final Intent intent = new Intent(this, StickyActivity.class);
        EventBus.getDefault().postSticky(new StickyMessageEvent("sticky-message-content"));
        startActivity(intent);
    }
}
