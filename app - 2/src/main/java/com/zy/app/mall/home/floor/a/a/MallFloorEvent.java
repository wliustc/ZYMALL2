package com.zy.app.mall.home.floor.a.a;

import com.zy.cleanmvp.common.BaseEvent;

/**
 * Created by Robin on 2016/5/8.
 */
//public final class b extends BaseEvent
public class MallFloorEvent  extends BaseEvent {
    protected Object a = null;
    private int b;
    private int c;

    public MallFloorEvent(String paramString)
    {
        super(paramString);
    }

    public MallFloorEvent(String paramString, int paramInt1, int paramInt2)
    {
        super(paramString);
        this.b = paramInt1;
        this.c = paramInt2;
    }

    public MallFloorEvent(String paramString, Object paramObject)
    {
        super(paramString);
        this.a = paramObject;
    }

    public final Object a()
    {
        return this.a;
    }

    public final int b()
    {
        return this.b;
    }

    public final int c()
    {
        return this.c;
    }
}
