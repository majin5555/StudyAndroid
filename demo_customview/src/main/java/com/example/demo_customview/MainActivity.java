package com.example.demo_customview;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("demo_customview");

        final View view = findViewById(R.id.id_pb);
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ObjectAnimator.ofInt(view, "progress", 0, 100).setDuration(3000).start();
            }
        });

    }
}
