package com.inkenka.devdemos.ActivityStack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.inkenka.devdemos.R;

/**
 * Created by yinjianhua on 2017/8/16.
 */

public class FirstActivity extends AppCompatActivity {

    private final String TAG = "FirstActivity";

    private Button mBtnTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        mBtnTitle = (Button) findViewById(R.id.btn_title);
        mBtnTitle.setText(TAG);
        getSupportActionBar().setTitle(TAG);
        mBtnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.i("ActivityStack",TAG+" onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityStack",TAG+" onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityStack",TAG+" onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityStack",TAG+" onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityStack",TAG+" onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityStack",TAG+" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityStack",TAG+" onPause");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("ActivityStack",TAG+" onNewIntent");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("ActivityStack",TAG+" onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("ActivityStack",TAG+" onRestoreInstanceState");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.i("ActivityStack",TAG+" onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("ActivityStack",TAG+" onPostResume");
    }
}
