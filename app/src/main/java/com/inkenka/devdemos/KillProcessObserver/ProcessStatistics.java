package com.inkenka.devdemos.KillProcessObserver;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.util.Printer;


import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yinjianhua on 2017/11/24.
 */

public class ProcessStatistics {

    private static final String TAG = "ProcessStatistics";

    private static void updateLooperTime(Context context, String tag) {
        RandomAccessFile accessFile = null;
        MappedByteBuffer out;
        try {
            File file = new File(context.getCacheDir(), tag);
            accessFile = new RandomAccessFile(file, "rw");
            out = accessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 256);
            out.putLong(123L);
            Log.i(TAG, tag + " saveUnBindTime");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void startStatistic(Context context, String tag){
        Looper.getMainLooper().setMessageLogging(new ProcessPrinter(context, tag));
    }


    public static class ProcessPrinter implements Printer {
        private String tag;
        private Context context;

        public ProcessPrinter(Context context, String tag){
            this.context = context;
            this.tag = tag;
        }

        @Override
        public void println(String s) {
            ProcessStatistics.updateLooperTime(context, tag);
        }
    }
}
