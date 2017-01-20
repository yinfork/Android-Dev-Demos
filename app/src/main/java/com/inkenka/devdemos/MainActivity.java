package com.inkenka.devdemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final static String TAG = "MainActivity";

    private final static String DEMO_LISTVIEW = "ListView Demo";
    private final static String DEMO_RECYCLEVIEW = "RecycleView Demo";
    private final static String DEMO_VIEWPAGER = "Viewpager Demo";

    String[] mDemos = new String[]{
        DEMO_LISTVIEW,
        DEMO_RECYCLEVIEW,
        DEMO_VIEWPAGER
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, mDemos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if(position >= mDemos.length) return;

        Intent intent = new Intent();
        String demoName = mDemos[position];
        switch (demoName) {
            case DEMO_LISTVIEW:
                intent.setClass(MainActivity.this, ListViewDemoActivity.class);
                break;
            case DEMO_RECYCLEVIEW:
                intent.setClass(MainActivity.this, ListViewDemoActivity.class);
                break;
            case DEMO_VIEWPAGER:
                intent.setClass(MainActivity.this, ListViewDemoActivity.class);
                break;
        }

        // 判断该Intent是否能被解析再启动
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Log.i(TAG, "Open " + demoName);
    }
}
