package com.demo_service.demo_retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    String url = "http://192.168.1.13:8080";
    private Retrofit  retrofit;

    private TextView  tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .build();

        setOnclick();


    }

    private void setOnclick() {
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpService service = retrofit.create(HttpService.class);
                Call<ResponseBody> call = service.getString();

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            final String res = response.body().string();

                            Log.d("majin", "1网络请求成功   response---- code:" + response.code() + "    " + res);

                            Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(res);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d("majin", "网络请求异常    :" + e.getMessage());

                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("majin", "网络请求失败   ----" + t.toString());

                    }
                });
            }
        });

    }

    public void downLoad(View view) {
    }

   }