package com.inkenka.devdemos.cpuinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.inkenka.devdemos.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CpuInfoDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpuinfo_demo);

        TextView tvInfo = (TextView) findViewById(R.id.tv_info);
        tvInfo.setText(getCpuName());
    }

    public static String getCpuName() {
        try {
            FileReader fr = new FileReader("/proc/cpuinfo");
            BufferedReader br = new BufferedReader(fr);
            String line;
            do {
                line = br.readLine();
                if (line.contains("Hardware")){
                    String[] array = line.split(" ");
                    if (array != null && array.length > 0){
                        return array[array.length -1].trim();
                    }
                }
            } while (line != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
