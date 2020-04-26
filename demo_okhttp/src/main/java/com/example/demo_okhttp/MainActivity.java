package com.example.demo_okhttp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "majin6666";

    private static final MediaType    MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown;charset=utf-8");
    private static final String       urlget              = "http://192.168.1.13:8080/helloGet.html";
    private static final String       urlpost             = "http://192.168.1.13:8080/helloPost.html";
    private              TextView     tvRes;
    private              OkHttpClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("OKHTTP3");
        mClient = new OkHttpClient();
        initView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                get();
                break;
            case R.id.button2:
                post();
                break;

            default:
                break;
        }

    }


    private void get() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Request.Builder builder = new Request.Builder();
                builder.url(urlget);
                Request request = builder.build();

                Call call = mClient.newCall(request);
                //                try {
                //                    //同步请求
                //                    Response response = call.execute();
                //
                //                    if (response.isSuccessful()) {
                //                        runOnUiThread(new Runnable() {
                //                            @Override
                //                            public void run() {
                //                                try {
                //                                    tvRes.setText(response.body().string().toString());
                //                                } catch (IOException e) {
                //                                    e.printStackTrace();
                //                                }
                //                            }
                //                        });
                //
                //                    }
                //                } catch (IOException e) {
                //                    e.printStackTrace();
                //                }
                //异步请求
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "情就失败");

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String str = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvRes.setText(str);
                                }
                            });
                        }
                    }
                });
            }
        });
        executorService.shutdown();
    }

    private void post() {
        Request.Builder builder = new Request.Builder();
        builder.url(urlpost);
        builder.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, ""));
        Request request = builder.build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "情就失败");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String str = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvRes.setText(str);
                        }
                    });
                }
            }
        });
    }

    private void initView() {
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        tvRes = findViewById(R.id.tv_res);
    }

}
