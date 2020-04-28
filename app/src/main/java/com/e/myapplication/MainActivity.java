package com.e.myapplication;

import android.os.Bundle;
import android.os.Environment;
import android.text.format.Formatter;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, " MainActivity");

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "SD卡挂载", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "SD卡不存在", Toast.LENGTH_SHORT).show();
        }

        File ext = Environment.getExternalStorageDirectory();
        long usableSpace = ext.getUsableSpace();
        long totalSpace = ext.getTotalSpace();
        String us = Formatter.formatFileSize(this, usableSpace);
        String ts = Formatter.formatFileSize(this, totalSpace);
        Log.d("majin", "us:" + us + "     ts:" + ts);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuliehua();
                Toast.makeText(MainActivity.this, "序列化完毕", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void xuliehua() {
        List list = new ArrayList();
        list.add("00");
        list.add("11");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        Log.d("majin", list.toString());
        XmlSerializer serializer = Xml.newSerializer();
        File file = new File(this.getFilesDir(), "book.xml");

        try {
            OutputStream out = new FileOutputStream(file);
            serializer.setOutput(out, "utf-8");
            serializer.startDocument("utf-8", true);
            serializer.startTag(null, "books");
            for (int i = 0; i < list.size(); i++) {
                serializer.startTag(null, "book");
                serializer.text(list.get(i).toString());
                Log.d("majin", list.get(i).toString());
                serializer.endTag(null, "book");
            }
            serializer.endTag(null, "books");
            serializer.endDocument();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
