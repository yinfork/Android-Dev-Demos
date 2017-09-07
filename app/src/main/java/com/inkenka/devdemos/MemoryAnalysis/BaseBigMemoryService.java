package com.inkenka.devdemos.MemoryAnalysis;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.inkenka.devdemos.R;

import java.util.HashSet;

/**
 * Created by yinjianhua on 2017/9/6.
 */

public class BaseBigMemoryService extends Service {

    HashSet<Bitmap> mBitmapSet = new HashSet<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.item_img1);
        mBitmapSet.add(bitmap1);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.big_pic1);
        mBitmapSet.add(bitmap2);

        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.big_pic2);
        mBitmapSet.add(bitmap3);

        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.big_pic3);
        mBitmapSet.add(bitmap4);

        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.big_pic4);
        mBitmapSet.add(bitmap5);

    }
}
