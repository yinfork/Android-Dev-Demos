package com.inkenka.devdemos.ThrowException;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.inkenka.devdemos.ActivityStack.SecondActivity;
import com.inkenka.devdemos.R;

/**
 * 混淆Log还原工具
 * 1.打开: <Android SDK>/tools/tools/proguard/bin/proguardgui.sh
 * 2.选择: Retrace
 * 3.选择mapping.txt文件
 * 4.输入对应Log
 *
 * 正确格式
 *   FATAL EXCEPTION: main
     Process: com.inkenka.devdemos, PID: 28014
     java.lang.NullPointerException: I am Exception
         at com.inkenka.devdemos.ThrowException.a.a(Unknown Source)
         at com.inkenka.devdemos.ThrowException.ThrowExceptionActivity$1.onClick(Unknown Source)
         at android.view.View.performClick(View.java:5609)
         at android.view.View$PerformClick.run(View.java:22262)
         at android.os.Handler.handleCallback(Handler.java:751)
         at android.os.Handler.dispatchMessage(Handler.java:95)
         at android.os.Looper.loop(Looper.java:154)
         at android.app.ActivityThread.main(ActivityThread.java:6077)
         at java.lang.reflect.Method.invoke(Native Method)
         at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:865)
         at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:755)
 *
 * 错误格式
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: FATAL EXCEPTION: main
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: Process: com.inkenka.devdemos, PID: 28014
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: java.lang.NullPointerException: I am Exception
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at com.inkenka.devdemos.ThrowException.a.a(Unknown Source)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at com.inkenka.devdemos.ThrowException.ThrowExceptionActivity$1.onClick(Unknown Source)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at android.view.View.performClick(View.java:5609)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at android.view.View$PerformClick.run(View.java:22262)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at android.os.Handler.handleCallback(Handler.java:751)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at android.os.Handler.dispatchMessage(Handler.java:95)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at android.os.Looper.loop(Looper.java:154)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at android.app.ActivityThread.main(ActivityThread.java:6077)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at java.lang.reflect.Method.invoke(Native Method)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:865)
     08-26 18:18:38.005 28014 28014 E AndroidRuntime: 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:755)
 *
 *
 * Created by yinjianhua on 2017/8/16.
 */

public class ThrowExceptionActivity extends AppCompatActivity {

    private final String TAG = "ThrowExceptionActivity";

    private Button mBtnTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        mBtnTitle = (Button) findViewById(R.id.btn_title);
        mBtnTitle.setText("Throw Exception");
        getSupportActionBar().setTitle(TAG);
        mBtnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThrowExceptionUtil.throwException();
            }
        });
    }
}
