package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button notif_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notif_btn = findViewById(R.id.button_show);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        notif_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.notif);
                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(MainActivity.this,"My Notification")
                        .setStyle(new NotificationCompat.InboxStyle()
                                .addLine("Gerric Message You")
                                .addLine("Jorge Message You")
                                .addLine("Aljane Message You")
                                .addLine("Maria Message You")
                                .addLine("Jerson Message You")
                                .addLine("Rezeil Message You")
                                .addLine("Rey Message You")
                                .setBigContentTitle("BigTextStyle")
                                .setSummaryText("Summary Text"))
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(picture)
                                .bigLargeIcon(null))
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .setSmallIcon(R.drawable.ic_notifications)
                        .setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify( 1,mbuilder.build());
            }
        });


    }
}
