package com.jingdong.app.mall.utils;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.zy.common.utils.Log;

import java.util.Calendar;

import static java.util.Calendar.*;

/**
 * Created by Robin on 2016/11/6.
 */
//bi
public class ReActivationUserManager {
    private static PendingIntent d;
    private Context a;
    private AlarmManager b;
    private NotificationManager c;
    private Object e = null;

    public ReActivationUserManager(Context context) {
        this.a = context;
        this.b = ((AlarmManager)this.a.getSystemService(Context.ALARM_SERVICE/*"alarm"*/));
        this.c = ((NotificationManager)this.a.getSystemService(Context.NOTIFICATION_SERVICE/*"notification"*/));
    }

    private void a(long paramLong)
    {
        Intent localIntent = new Intent("com.360buy.RE_ACTIVATION_USER");
        localIntent.setClassName(this.a.getPackageName(), ReActivationUserReceiver.class.getName());
        localIntent.setFlags(32);
        d = PendingIntent.getBroadcast(this.a, 0, localIntent, 268435456);
        this.b.set(0, paramLong, d);
    }

    private void c()
    {
        if (Log.D)
            Log.d("ReActivationUserManager", " killSelf -->>  killSelfToken" + this.e);
        if (this.e != null)
        {
            a.a(this.e);
            this.e = null;
        }
    }

    public final void a()
    {
        long l = CommonUtil.getReActivationIntervalDays(30L) * 86400000L + System.currentTimeMillis();
        Calendar localCalendar = getInstance();
        localCalendar.setTimeInMillis(l);
        int i = localCalendar.get(HOUR_OF_DAY);//11
        if (i < 9)
            localCalendar.setTimeInMillis(l + 32400000L);
        while (true)
        {
            l = localCalendar.getTimeInMillis();
            CommonUtil.putTriggerAtTime(l);
            a(l);
            return;
            if (i <= 21)
                continue;
            localCalendar.setTimeInMillis(l + 43200000L);
        }
    }

    public final void a(Object paramObject)
    {
        if (Log.D)
            Log.d("ReActivationUserManager", "setKillSelfToken killSelfToken:" + paramObject);
        this.e = paramObject;
    }

    public final void b()
    {
        long l = CommonUtil.getTriggerAtTime();
        if (l != -1L)
        {
            if (System.currentTimeMillis() <= l)
                a(l);
        }
        else
            c();
    }
}
