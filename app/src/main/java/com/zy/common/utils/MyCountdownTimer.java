package com.zy.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.MainThread;

import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/6/22.
 */
//di
public abstract class MyCountdownTimer {
    private long a;
    private long b;
    private long c;
    private int d;
    private Handler e;

    public MyCountdownTimer(long paramLong1, long paramLong2, int paramInt)
    {
        this.a = paramLong1;
        this.b = paramLong2;
        this.d = paramInt;
        this.e =new Handler(Looper.getMainLooper()){//dj(this);
            @Override
            public void handleMessage(Message msg) {
                int i = msg.what;
                synchronized (MyCountdownTimer.this)
                {
                    long l1 = MyCountdownTimer.this.c - SystemClock.elapsedRealtime();
                    if (l1 <= 0L)
                        MyCountdownTimer.this.a(i);
                    else  if (l1 < MyCountdownTimer.this.b)
                        sendMessageDelayed(obtainMessage(i), l1);
                    else{
                        long l2 = SystemClock.elapsedRealtime();
                        MyCountdownTimer.this.a(l1, i);
                        l1 = MyCountdownTimer.this.b + l2 - SystemClock.elapsedRealtime();
                        while (l1 < 0L)
                            l1 += MyCountdownTimer.this.b;
                        sendMessageDelayed(obtainMessage(i), l1);
                    }
                    return;
                }
            }
        };
    }

    public final synchronized MyCountdownTimer a()
    {
            if (this.a <= 0L)
                a(this.d);
            else
            {
                this.c = (SystemClock.elapsedRealtime() + this.a);
                if(this.e != null)
                    this.e.sendMessage(this.e.obtainMessage(this.d));
            }
        return this;
    }

    public abstract void a(int paramInt);

    public abstract void a(long paramLong, int paramInt);

    public final synchronized void a(long paramLong1, long paramLong2, int paramInt)
    {
            if (Log.D)
                Log.d("MyCountdownTimer", "reset(); mMillisInFuture=" + this.a + "\tmCountdownInterval=" + this.b);
            this.a = paramLong1;
            this.b = 1000L;
            this.d = paramInt;
            a();
            return;
    }

    public final void b(int paramInt)
    {
        if(this.e !=null)
            this.e.removeMessages(paramInt);
    }
}
