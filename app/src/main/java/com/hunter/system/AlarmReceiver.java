package com.hunter.system;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String CHANNEL = "missions";

    @Override
    public void onReceive(Context c, Intent in) {
        int i = in.getIntExtra("i", 0);
        if (i < 0 || i >= Reminders.NAMES.length) i = 0;

        NotificationManager nm = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel ch = new NotificationChannel(
                        CHANNEL, "Mission alerts", NotificationManager.IMPORTANCE_HIGH);
                ch.setDescription("Alerts when a mission window opens");
                ch.enableVibration(true);
                ch.setVibrationPattern(new long[]{0, 250, 120, 250, 120, 500});
                nm.createNotificationChannel(ch);
            }

            Intent open = new Intent(c, MainActivity.class);
            open.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            int flags = PendingIntent.FLAG_UPDATE_CURRENT;
            if (Build.VERSION.SDK_INT >= 23) flags |= PendingIntent.FLAG_IMMUTABLE;
            PendingIntent pi = PendingIntent.getActivity(c, i, open, flags);

            Notification.Builder b = Build.VERSION.SDK_INT >= 26
                    ? new Notification.Builder(c, CHANNEL)
                    : new Notification.Builder(c);
            b.setSmallIcon(R.drawable.ic_stat)
                    .setContentTitle("New mission: " + Reminders.NAMES[i])
                    .setContentText(Reminders.TEXT[i])
                    .setContentIntent(pi)
                    .setAutoCancel(true)
                    .setCategory(Notification.CATEGORY_REMINDER);
            if (Build.VERSION.SDK_INT < 26) {
                b.setDefaults(Notification.DEFAULT_ALL);
                b.setPriority(Notification.PRIORITY_HIGH);
            }
            nm.notify(200 + i, b.build());
        }
        Reminders.schedule(c, i);
    }
}
