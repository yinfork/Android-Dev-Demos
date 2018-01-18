package com.inkenka.devdemos.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.inkenka.devdemos.MainActivity;
import com.inkenka.devdemos.R;

public class NotificationDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);

        Button btnSend = (Button) findViewById(R.id.btc_send_notification);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationDemoActivity.this);
                builder.setSmallIcon(R.drawable.item_img1)
                        .setContentText("title")
                        .setColor(ResourcesCompat.getColor(getResources(),R.color.colorAccent,null))
                        .setContentTitle("content");
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationDemoActivity.this, 0, new Intent(NotificationDemoActivity.this, MainActivity.class),
                        PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pendingIntent);
//                builder.setOngoing(true);
                builder.setDefaults(Notification.DEFAULT_SOUND);
                Notification notification = builder.build();



                NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotifyMgr.notify("NotificationDemoActivity".hashCode(), notification);
            }
        });
    }

}
