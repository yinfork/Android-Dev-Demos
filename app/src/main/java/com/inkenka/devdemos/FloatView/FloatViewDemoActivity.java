package com.inkenka.devdemos.FloatView;

import com.inkenka.devdemos.R;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class FloatViewDemoActivity extends AppCompatActivity implements View.OnClickListener{

    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mWmParams;
    private ImageView mFloatView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floatview_demo);

        init();
    }

//    private void init(){
//        wManager = (WindowManager) getApplicationContext().getSystemService(
//            Context.WINDOW_SERVICE);
//        mParams = new WindowManager.LayoutParams();
//        mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;// 系统提示window
////        mParams.format = PixelFormat.TRANSLUCENT;// 支持透明
//        mParams.format = PixelFormat.RGBA_8888;
//        mParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;// 焦点
//        mParams.width = 490;//窗口的宽和高
//        mParams.height = 160;
//        mParams.x = 0;//窗口位置的偏移量
//        mParams.y = 0;
//        //mParams.alpha = 0.1f;//窗口的透明度
//        mFloatView = new ImageView(this);
//        mFloatView.setImageResource(R.drawable.item_img1);
//        mFloatView.setOnClickListener(this);
//    }
//
//
//    private void init(){
//        // 获取Service
//        WindowManager mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//
//        ImageView imageView = new ImageView(this);
//        imageView.setImageResource(R.drawable.ic_video_delete_normal);
//
//        mParams = new WindowManager.LayoutParams();
//        // 设置窗口类型，一共有三种Application windows, Sub-windows, System windows
//        // API中以TYPE_开头的常量有23个
//        mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT ;
//        // 设置期望的bitmap格式
//        mParams.format = PixelFormat.RGBA_8888;
//
//        // 以下属性在Layout Params中常见重力、坐标，宽高
//        mParams.gravity = Gravity.LEFT | Gravity. TOP;
//        mParams.x = 100;
//        mParams.y = 100;
//
//        mParams .width = WindowManager.LayoutParams. WRAP_CONTENT;
//        mParams .height = WindowManager.LayoutParams. WRAP_CONTENT;
//
//        // 添加指定视图
//        mWindowManager.addView(imageView, mParams);
//    }

    private void init(){
        mWmParams = new WindowManager.LayoutParams();
        mWmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
        mWmParams.format = PixelFormat.RGBA_8888;
        mWmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mWmParams.gravity = Gravity.RIGHT | Gravity.BOTTOM;

        //设置悬浮窗口长宽数据
        mWmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mWmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindowManager = (WindowManager)getSystemService(WINDOW_SERVICE);

        mFloatView = new ImageView(this);
        mFloatView.setImageResource(R.drawable.item_img1);

        try {
            mWindowManager.addView(mFloatView, mWmParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) mFloatView.getLayoutParams();
        layoutParams.x = layoutParams.x + 10;

        // 使参数生效
        mWindowManager.updateViewLayout(mFloatView, layoutParams);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mWindowManager.removeView(mFloatView);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e("yinjianhua","dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }
}
