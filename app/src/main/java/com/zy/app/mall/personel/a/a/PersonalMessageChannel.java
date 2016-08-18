package com.zy.app.mall.personel.a.a;

/**
 * Created by Robin on 2016/5/5.
 */
//public final class a
public class PersonalMessageChannel {
    public String channel = "";   //a
    public int style;   //b
    public int redDot;   //c
    public long lastReadNotice;  //d
    public int num;   //e

    public final boolean a()
    {
        return (this.style == 0) && (this.redDot > 0);
    }

    public final boolean b()
    {
        return (this.style == 1) && (this.redDot > 0);
    }
}
