package com.zy.common.channel.common.a;

import com.zy.app.mall.home.floor.model.entity.FloorEntity;
import com.zy.cleanmvp.common.BaseEvent;

import java.util.List;

/**
 * Created by robin on 16-10-20.
 */
public class ChannelEvent extends BaseEvent {
    private List<FloorEntity> a;
    private int b;
    private int c;

    public ChannelEvent(String paramString)
    {
        super(paramString);
    }

    public ChannelEvent(String paramString1, String paramString2)
    {
        super(paramString1, paramString2);
    }

    public ChannelEvent(String paramString1, String paramString2, int paramInt)
    {
        super(paramString1, paramString2);
        this.b = paramInt;
    }

    public ChannelEvent(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
        super(paramString1, paramString2);
        this.b = paramInt1;
        this.c = paramInt2;
    }

    public ChannelEvent(String paramString1, String paramString2, List<FloorEntity> paramList)
    {
        super(paramString1, paramString2);
        this.a = paramList;
    }

    public final List<FloorEntity> a()
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
