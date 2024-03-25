package com.example.project;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class NotificationReminder extends Service {

    public static final String CHANNEL_ID = "NOTIFICATION_REMINDER";
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Create Notification channel for Oreo and above
        createNotificationChannel();
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,10, notificationIntent, PendingIntent.FLAG_MUTABLE);

        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Calad - The Healthy Calendar App")
                .setContentText("Don't forget to place your deliveries!")
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        startForeground(1, notification);
        return START_NOT_STICKY;
    }
    private void createNotificationChannel() {
        // Check if the Android version is Oreo or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationManager manager = getSystemService(NotificationManager.class);

            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(serviceChannel);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
