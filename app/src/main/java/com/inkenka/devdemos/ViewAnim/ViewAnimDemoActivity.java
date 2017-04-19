package com.inkenka.devdemos.ViewAnim;

import com.inkenka.devdemos.R;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class ViewAnimDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewanim_demo);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.item_img1));


        Animation animation = AnimationUtils.loadAnimation(this,
            R.anim.anim_live_video_record_loading);
        LinearInterpolator interpolator = new LinearInterpolator();
        animation.setInterpolator(interpolator);
        imageView.startAnimation(animation);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
