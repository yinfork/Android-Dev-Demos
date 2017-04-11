package com.inkenka.devdemos.videoview;

import com.inkenka.devdemos.R;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.VideoView;

public class VideoViewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview_demo);

        VideoView videoView = (VideoView) findViewById(R.id.video_view);
        String videoPath = Environment.getExternalStorageDirectory().getPath()+"/demo.mp4" ;
        videoView.setVideoPath(videoPath);
        videoView.seekTo(0);
        videoView.start();
        videoView.requestFocus();

    }

}
