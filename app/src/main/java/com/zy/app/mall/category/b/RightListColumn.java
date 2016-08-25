package com.zy.app.mall.category.b;

import com.zy.common.entity.Catelogy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 16-8-19.
 */
//c
public class RightListColumn extends RightColumnBase{
    private List<Catelogy> b = new ArrayList();
    private int c = 3;

    public final Catelogy a(int paramInt)
    {
        if (this.b.size() > paramInt)
            return (Catelogy)this.b.get(paramInt);
        return null;
    }

    public final List<Catelogy> a()
    {
        return this.b;
    }

    public final void a(Catelogy paramCatelogy)
    {
        this.b.add(paramCatelogy);
    }

    public final int b()
    {
        return this.c;
    }

    public final void b(int paramInt)
    {
        this.c = 1;
    }

    public final int c()
    {
        return this.b.size();
    }
}
