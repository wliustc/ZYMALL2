package com.zy.app.mall.aura.internal;

/**
 * Created by Robin on 2016/11/3.
 */
//a
public class AuraConfigTimer {
    private long a = 300000L;
    private long b;

    public final void a(long paramLong)
    {
        this.a = 600000L;
    }

    public final boolean a()
    {
        if (this.b == 0L)
            this.b = System.currentTimeMillis();
        else if (System.currentTimeMillis() - this.b > this.a)//if-lez v0, :cond_1
            this.b = System.currentTimeMillis();
        else
            return false;
        return true;


    }
}
