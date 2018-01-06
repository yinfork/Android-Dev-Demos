package com.inkenka.devdemos.cpuinfo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
        tvInfo.setText(getCPUModel());
    }

    public static String getCPUModel() {
        String cpuModel = null;

        // 通过读取cpuinfo文件获取CPU型号
        try {
            FileReader fr = new FileReader("/proc/cpuinfo");
            BufferedReader br = new BufferedReader(fr);
            String line;
            do {
                line = br.readLine();
                // 找到Hardware这一行
                if (!TextUtils.isEmpty(line) && line.contains("Hardware")){
                    String[] array = line.split(" ");
                    // 这一行最后显示的就是CPU型号
                    if (array != null && array.length > 0){
                        cpuModel = array[array.length -1].trim().toUpperCase();
                    }
                    break;
                }
            } while (line != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 部分手机无法通过cpuinfo获取芯片名，则返回Build.BOARD
        if (TextUtils.isEmpty(cpuModel)){
            cpuModel = Build.BOARD;
        }
        return cpuModel;
    }

}
