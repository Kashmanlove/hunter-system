package com.hunter.system;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.Calendar;

final class Reminders {
    // Same start times as the missions in the app: hour, minute.
    static final int[][] TIMES = {{7, 0}, {11, 0}, {15, 0}, {17, 0}, {18, 30}, {20, 30}, {22, 0}};
    static final String[] NAMES = {
            "Dawn Protocol", "Sunlight Patrol", "Study Dungeon", "Home Training",
            "Skill Forge", "Mind Log", "Sleep Gate"};
    static final String[] TEXT = {
            "Drink water, open the curtains and stretch for 5 minutes.",
            "Walk outside for 15 minutes.",
            "One 25-minute study block is open.",
            "Your training mission is open.",
            "15 minutes on today's skill.",
            "Log a check-in in the Mind tab.",
            "Screens down. Time to wind down for bed."};

    private Reminders() { }

    static void scheduleAll(Context c) {
        for (int i = 0; i < TIMES.length; i++) schedule(c, i);
    }

    static void schedule(Context c, int i) {
        AlarmManager am = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        if (am == null) return;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, TIMES[i][0]);
        cal.set(Calendar.MINUTE, TIMES[i][1]);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        if (cal.getTimeInMillis() <= System.currentTimeMillis() + 1000) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
        Intent in = new Intent(c, AlarmReceiver.class);
        in.putExtra("i", i);
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= 23) flags |= PendingIntent.FLAG_IMMUTABLE;
        PendingIntent pi = PendingIntent.getBroadcast(c, 100 + i, in, flags);
        am.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
    }
}
