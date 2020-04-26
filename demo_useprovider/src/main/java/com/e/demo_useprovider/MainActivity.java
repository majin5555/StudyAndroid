package com.e.demo_useprovider;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "查询", Toast.LENGTH_SHORT).show();
                 //内容解析这
                Uri uri = Uri.parse("content://com.demo.provider");
                getContentResolver().query(uri, null, null, null, null);
            }
        });
    }


}
