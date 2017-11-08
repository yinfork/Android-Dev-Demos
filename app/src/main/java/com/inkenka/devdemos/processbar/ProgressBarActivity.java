package com.inkenka.devdemos.processbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.inkenka.devdemos.R;

public class ProgressBarActivity extends AppCompatActivity {

    private Handler mUiHandler = new  Handler(Looper.getMainLooper());
    protected int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_demo);


        final RoundCornerProgressBar customPathProgressBar = (RoundCornerProgressBar) findViewById(R.id.progress);
        customPathProgressBar.setProgress(0);


        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    mUiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (progress == 100) {
                                progress = 0;
                            }
                            progress += 1;
                            customPathProgressBar.setProgress(progress);
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

}
