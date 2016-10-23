package com.zy.common;

import com.zy.common.utils.Log;

import java.lang.ref.SoftReference;

/**
 * Created by Robin on 2016/10/23.
 */
public class JDSoftReference<T> extends SoftReference<T> {
    private final String a = getClass().getSimpleName();
    private Object b;

    public JDSoftReference(T paramT)
    {
        super(paramT);
    }

    public final Object a()
    {
        if (Log.D)
            Log.d(this.a, "getTag() = " + this.b);
        return this.b;
    }

    public final void a(Object paramObject)
    {
        if (Log.D)
            Log.d(this.a, "setTag() = " + paramObject);
        this.b = paramObject;
    }
}
