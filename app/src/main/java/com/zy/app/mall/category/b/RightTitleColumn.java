package com.zy.app.mall.category.b;

/**
 * Created by Robin on 2016/10/8.
 */
//d
public class RightTitleColumn extends RightColumnBase{
    private String b;
    private boolean c;
    private boolean d;
    private String e;
    private String f;

    public RightTitleColumn(String name, String cid, boolean rankingFlag)
    {
        this.a = 0;
        this.b = name;
        this.e = cid;
        this.c = rankingFlag;
    }

    public final void a(String paramString)
    {
        this.f = paramString;
    }

    public final void a(boolean isBook)
    {
        this.d = isBook;
    }

    public final boolean a()
    {
        return this.d;
    }

    public final String b()
    {
        return this.b;
    }

    public final boolean c()
    {
        return this.c;
    }

    public final String d()
    {
        return this.e;
    }

    public final String e()
    {
        return this.f;
    }
}
