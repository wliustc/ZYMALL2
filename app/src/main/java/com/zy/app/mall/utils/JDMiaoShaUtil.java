package com.zy.app.mall.utils;

import com.zy.common.utils.Log;
import com.zy.common.utils.MyCountdownTimer;

/**
 * Created by Robin on 2016/6/22.
 */
//au
public class JDMiaoShaUtil {
    private MyCountdownTimer a;
    private int b = 2;
    private boolean c = true;

    public static long[] a(long paramLong) {
        long l2 = 0L;
        long l1 = paramLong / 1000L / 60L / 60L;
        long l3 = (paramLong - l1 * 60L * 60L * 1000L) / 1000L / 60L;
        long l4 = paramLong / 1000L - l1 * 60L * 60L - l3 * 60L;
        paramLong = l1;
        if (l1 < 0L)
            paramLong = 0L;
        l1 = l3;
        if (l3 < 0L)
            l1 = 0L;
        if (l4 >= 0L)
            l2 = l4;
        return new long[]{paramLong, l1, l2};
    }

    public final void a() {
        if (this.a != null) {
            this.c = true;
            this.a.b(2);
            this.a.b(1);
            this.a.b(3);
        }
    }

    public final void a(long paramLong1, long paramLong2, _AW paramaw) {
        long l2 = 0L;
        long l1;
        if (paramLong1 > 0L) {
            this.b = 1;
            l1 = paramLong1;
        } else if ((paramLong2 > 0L) && (paramLong1 < 0L)) {
            this.b = 2;
            l1 = paramLong2;
        } else {
            l1 = l2;
            if (paramLong2 < 0L)
                l1 = l2;
            if (paramLong1 < 0L)
                l1 = 1L;
            this.b = 3;
        }
        Log.d("JDMiaoSha", " -->>setCountdown countdownTime=" + l1);
        if (this.a == null)
            this.a = new _AV(this, l1, 1000L, this.b, paramaw, paramLong2).a();
        else
            this.a.a(l1, 1000L, this.b);
        this.c = false;
        return;
    }

    public final boolean b() {
        return this.c;
    }

    public abstract interface _AW {
        public abstract void changed(MyCountdownTimer paramdi, long paramLong, long[] paramArrayOfLong, int paramInt);

        public abstract boolean finish(MyCountdownTimer paramdi, long paramLong, int paramInt);
    }

    final class _AV extends MyCountdownTimer {
        private _AW a;
        private long b;
        private JDMiaoShaUtil c;

        _AV(JDMiaoShaUtil paramau, long paramLong1, long paramLong2, int paramInt, _AW paramaw, long paramLong3) {
            super(paramLong1, 1000L, paramInt);
            this.a = paramaw;
            this.b = paramLong3;
            this.c = paramau;
        }

        @Override
        public final void a(int paramInt) {
            if (this.a != null)
                this.a.finish(this, this.b, paramInt);
            this.c.a();
        }

        @Override
        public final void a(long paramLong, int paramInt) {
            long[] arrayOfLong = JDMiaoShaUtil.a(paramLong);
            if (this.a != null)
                this.a.changed(this, paramLong, arrayOfLong, paramInt);
        }
    }
}
