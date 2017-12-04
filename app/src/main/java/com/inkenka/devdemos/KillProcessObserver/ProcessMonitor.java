package com.inkenka.devdemos.KillProcessObserver;

import android.content.Context;
import android.util.Log;
import android.util.Printer;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yinjianhua on 2017/11/24.
 */

public class ProcessMonitor implements Runnable, Printer {



    @Override
    public void println(String x) {

    }

    @Override
    public void run() {

    }

    private static void updateLooperTime(Context context, String tag) {
        RandomAccessFile accessFile = null;
        MappedByteBuffer out;
        try {
            File file = new File(context.getCacheDir(), tag);
            accessFile = new RandomAccessFile(file, "rw");
            out = accessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 10);
            out.put((byte) 1);
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
}
