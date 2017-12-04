package com.inkenka.devdemos.KillProcessObserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yinjianhua on 2017/11/24.
 */

public class SimulatedWorkerService extends Service{

    private final static String TAG = "SimulatedWorkerService";

    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
        super.onCreate();
        ProcessStatistics.startStatistic(this,TAG);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return null;
    }


}
