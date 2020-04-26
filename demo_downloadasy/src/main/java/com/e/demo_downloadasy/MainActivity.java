package com.e.demo_downloadasy;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    String APK_URL = "http://192.168.4.90:9999/files/IVMSMobile_dev_v4.0.1_c13-b20191119.apk";
    //读写权限
    private static String[] PERMISSIONS_STORAGE      = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};    //请求状态码
    private static int      REQUEST_EXTERNAL_STORAGE = 2;

    /**
     * 在对sd卡进行读写操作之前调用这个方法
     * Checks if the app has permission to write to device storage
     * If the app does not has permission then the user will be prompted to grant permissions
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
        //文件存储地址
        final String filePath = Environment.getExternalStorageDirectory() + File.separator + "demo_down";
        File file = new File(filePath);
        if (! file.exists()) {
            file.mkdirs();
        }
        final String saveFilePath = file.getPath() + File.separator + "temp.apk";
        Log.d("majin", "filePath  " + filePath);
        Log.d("majin", "saveFilePath  " + saveFilePath);

        findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "下载", Toast.LENGTH_SHORT).show();
                DownloadHelper.download(APK_URL, saveFilePath, new DownloadHelper.OnDownloadListener.SimpleDownloadListener() {
                    @Override
                    public void onStart() {
                        Log.d("majin", "onStart");
                    }

                    @Override
                    public void onProgress(int progress) {
                      //  Log.d("majin", "progress  " + progress);
                    }

                     @Override
                    public void onSuccess(int code, File file) {
                        Log.d("majin", "onSuccess    code" + code +"下载成功");
                    }

                    @Override
                    public void onFail(int code, File file, String message) {
                        Log.d("majin", "onFail    code" + code + "  message:" + message);
                    }
                });
            }
        });
    }

}

