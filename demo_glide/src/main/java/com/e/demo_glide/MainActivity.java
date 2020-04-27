package com.e.demo_glide;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG     = "majin6666";
    private static final String imgUrl1 = "https://img2.mukewang.com/5b037fb30001534202000199-140-140.jpg";
    private static final String imgUrl2 = "http://res.lgdsunday.club/big_img.jpg";
    private static final String imgUrl3 = "https://www.imooc.com/static/img/index/logo.png";

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Glide加载图片");
        initView();
    }

    private void initView() {
        img = findViewById(R.id.iv);
    }


    public void onLoadImageClick(View view) {
        ImageLoaderManager.loadImage(this, imgUrl1, img);
    }
}
