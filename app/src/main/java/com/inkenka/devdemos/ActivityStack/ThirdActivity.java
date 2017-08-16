package com.inkenka.devdemos.ActivityStack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.inkenka.devdemos.R;

/**
 * Created by yinjianhua on 2017/8/16.
 */

public class ThirdActivity extends AppCompatActivity {

    private Button mBtnTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        mBtnTitle = (Button) findViewById(R.id.btn_title);
        mBtnTitle.setText("ThirdActivity");
        getSupportActionBar().setTitle("ThirdActivity");
//        mBtnTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(ThirdActivity.this, FirstActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
