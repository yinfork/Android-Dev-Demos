package com.inkenka.devdemos;

import com.inkenka.devdemos.ActivityStack.FirstActivity;
import com.inkenka.devdemos.FloatView.FloatViewDemoActivity;
import com.inkenka.devdemos.KillProcessObserver.KillProcessObserverDemoActivity;
import com.inkenka.devdemos.MemoryAnalysis.MemoryAnalysisActivity;
import com.inkenka.devdemos.MultiItemList.ListViewDemoActivity;
import com.inkenka.devdemos.ProcessWhiteList.ProcessWhiteListActivity;
import com.inkenka.devdemos.SingleImageView.SingleImageDemoActivity;
import com.inkenka.devdemos.SpannableString.SpannableStringActivity;
import com.inkenka.devdemos.ThrowException.ThrowExceptionActivity;
import com.inkenka.devdemos.ViewAnim.ViewAnimDemoActivity;
import com.inkenka.devdemos.processbar.ProgressBarActivity;
import com.inkenka.devdemos.recycleview.RecycleViewDemoActivity;
import com.inkenka.devdemos.videoview.VideoViewDemoActivity;

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

    private final static String DEMO_IMAGEVIEW = "ImageView Demo";
    private final static String DEMO_LISTVIEW = "ListView Demo";
    private final static String DEMO_VIDEOVIEW = "VideoView Demo";
    private final static String DEMO_FLOATVIEW = "悬浮窗 Demo";
    private final static String DEMO_VIEW_ANIM = "View Anim Demo";
    private final static String DEMO_RECYCLEVIEW = "RecycleView Demo";
    private final static String DEMO_ACTIVITY_STACK = "测试Activity Stack";
    private final static String DEMO_THROW_EXCEPTION = "Throw Exception Demo";
    private final static String DEMO_MEMORY_ANALYSIS = "模拟前台高内存占用";
    private final static String DEMO_PROCESS_WHITE_LIST = "添加各机型进程白名单Demo";
    private final static String DEMO_SPANNABLE_STRING = "图文显示Demo";
    private final static String DEMO_PROGRESS_BAR = "圆角矩形ProgressBar Demo";
    private final static String DEMO_KILL_PROCESS_OBSERVER = "统计进程被杀时间";

    String[] mDemos = new String[]{
            DEMO_IMAGEVIEW,
            DEMO_LISTVIEW,
            DEMO_VIDEOVIEW,
            DEMO_FLOATVIEW,
            DEMO_VIEW_ANIM,
            DEMO_RECYCLEVIEW,
            DEMO_ACTIVITY_STACK,
            DEMO_THROW_EXCEPTION,
            DEMO_MEMORY_ANALYSIS,
            DEMO_PROCESS_WHITE_LIST,
            DEMO_SPANNABLE_STRING,
            DEMO_PROGRESS_BAR,
            DEMO_KILL_PROCESS_OBSERVER
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
            case DEMO_IMAGEVIEW:
                intent.setClass(MainActivity.this, SingleImageDemoActivity.class);
                break;
            case DEMO_LISTVIEW:
                intent.setClass(MainActivity.this, ListViewDemoActivity.class);
                break;
            case DEMO_VIDEOVIEW:
                intent.setClass(MainActivity.this, VideoViewDemoActivity.class);
                break;
            case DEMO_FLOATVIEW:
                intent.setClass(MainActivity.this, FloatViewDemoActivity.class);
                break;
            case DEMO_VIEW_ANIM:
                intent.setClass(MainActivity.this, ViewAnimDemoActivity.class);
                break;
            case DEMO_RECYCLEVIEW:
                intent.setClass(MainActivity.this, RecycleViewDemoActivity.class);
                break;
            case DEMO_ACTIVITY_STACK:
                intent.setClass(MainActivity.this, FirstActivity.class);
                break;
            case DEMO_THROW_EXCEPTION:
                intent.setClass(MainActivity.this, ThrowExceptionActivity.class);
                break;
            case DEMO_MEMORY_ANALYSIS:
                intent.setClass(MainActivity.this, MemoryAnalysisActivity.class);
                break;
            case DEMO_PROCESS_WHITE_LIST:
                intent.setClass(MainActivity.this, ProcessWhiteListActivity.class);
                break;
            case DEMO_SPANNABLE_STRING:
                intent.setClass(MainActivity.this, SpannableStringActivity.class);
            case DEMO_PROGRESS_BAR:
                intent.setClass(MainActivity.this, ProgressBarActivity.class);
            case DEMO_KILL_PROCESS_OBSERVER:
                intent.setClass(MainActivity.this, KillProcessObserverDemoActivity.class);
        }

        // 判断该Intent是否能被解析再启动
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Log.i(TAG, "Open " + demoName);
    }
}
