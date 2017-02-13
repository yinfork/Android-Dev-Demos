package com.inkenka.devdemos.SingleImageView;

import com.inkenka.devdemos.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SingleImageDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_demo);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.item_img1));
    }

}
