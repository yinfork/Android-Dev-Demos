package com.inkenka.devdemos.KillProcessObserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.inkenka.devdemos.R;

/**
 * 未完成
 * 为了统计前后进程被杀的时间，假如两个相隔时间比较近，可以认为是用户手动杀进程；假如两者相隔时间比较长，可以认为系统回收进程
 *
 * 有两个想法：
 * 1.分别在UI和Service进程的主线程的Looper里面插入Printer，每次Looper执行的时候都会回调Printer，此时用mmap写文件
 *
 * 2.在UI进程onServiceDisconnected回调和 Service进程的unbind回调中，通过mmap写文件记录另外一个进程的死亡时间，然后再开定时器delay一段时间看此进程是否还存活
 *
 */
public class KillProcessObserverDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kill_process_observer_demo);

        ProcessStatistics.startStatistic(this,"KillProcessObserverDemoActivity");
        startService(new Intent(this,SimulatedWorkerService.class));
    }
}
