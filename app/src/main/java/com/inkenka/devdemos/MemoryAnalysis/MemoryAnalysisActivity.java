package com.inkenka.devdemos.MemoryAnalysis;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.inkenka.devdemos.R;

/**
 * Created by yinjianhua on 2017/9/6.
 */

public class MemoryAnalysisActivity extends AppCompatActivity {


    Class[] SERVICE_LIST = new Class[]{
            BigMemoryService1.class,
            BigMemoryService2.class,
            BigMemoryService3.class,
            BigMemoryService4.class,
            BigMemoryService5.class,
            BigMemoryService6.class,
            BigMemoryService7.class,
            BigMemoryService8.class,
            BigMemoryService9.class,
            BigMemoryService10.class,
            BigMemoryService11.class,
            BigMemoryService12.class,
            BigMemoryService13.class,
            BigMemoryService14.class,
            BigMemoryService15.class,
            BigMemoryService16.class,
            BigMemoryService17.class,
            BigMemoryService18.class,
            BigMemoryService19.class,
            BigMemoryService20.class,

    };

    int index = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_analysis);
        Button btnAddMemory = (Button) findViewById(R.id.btn_add_memory);
        btnAddMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index < SERVICE_LIST.length){
                    Intent intent = new Intent(MemoryAnalysisActivity.this, SERVICE_LIST[index]);
                    startService(intent);
                    index++;
                }
            }
        });
    }
}