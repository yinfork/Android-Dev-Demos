package com.inkenka.devdemos.ProcessWhiteList;

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
 * 添加应用进程白名单
 * Created by yinjianhua on 2017/8/16.
 */

public class ProcessWhiteListActivity extends AppCompatActivity {

    private final String TAG = "FirstActivity";

    private Button mBtnXiaomi;
    private Button mBtnOppo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_white_list);
        getSupportActionBar().setTitle(TAG);
        mBtnXiaomi = (Button) findViewById(R.id.btn_xiaomi);
        mBtnOppo = (Button) findViewById(R.id.btn_oppo);

        mBtnXiaomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 红米 4
                Intent intent = new Intent();
                intent.setClassName("com.miui.powerkeeper",
                        "com.miui.powerkeeper.ui.HiddenAppsContainerManagementActivity");
                startActivity(intent);
            }
        });


        mBtnOppo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClassName("com.coloros.oppoguardelf",
//                        "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity");
//                startActivity(intent);
//
//                Intent intent = new Intent();
//                intent.setClassName("com.coloros.safecenter",
//                        "com.coloros.safecenter.permission.startup.StartupAppListActivity");
//                startActivity(intent);

                // 跳转到最近任务
                Intent intent = new Intent();
                intent.setClassName("com.coloros.recents",
                        "com.coloros.recents.RecentsActivity");
                startActivity(intent);

            }
        });

    }
}
