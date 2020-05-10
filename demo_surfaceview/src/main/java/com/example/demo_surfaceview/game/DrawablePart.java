package com.example.demo_surfaceview.game;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class DrawablePart {

    protected Context mContext;
    protected int mGameWidth;
    protected int mGameHeight;
    protected Bitmap mBitmap;

    public DrawablePart(Context context, int gameW, int gameH, Bitmap bitmap) {
        mContext = context;
        mGameWidth = gameW;
        mGameHeight = gameH;
        mBitmap = bitmap;
    }

    public abstract void draw(Canvas canvas);
}
