package com.jingdong.jdpush;

import android.content.Context;

/**
 * Created by Robin on 2016/11/10.
 */
//a
public class JDPushInterface {
    private static final String a = JDPushInterface.class.getSimpleName();

    public static void a(Context paramContext)
    {
        if (paramContext == null)
        {
            com.jingdong.jdpush.e.a.d(a, "--------》Context 不能为空");
            return;
        }
        com.jingdong.jdpush.e.a.d(a, "startPush");
        c.a(Environment.getExternalStorageDirectory() + "/jmp_log.txt");
        com.jingdong.jdpush.b.b.a(paramContext);
        com.jingdong.jdpush.connect.a.a = true;
        com.jingdong.jdpush.connect.a.a(paramContext);
    }

    public static void a(Context paramContext, String paramString)
    {
        i.b(paramContext, com.jingdong.jdpush.d.b.a(paramContext, paramString), 2012);
    }

    public static void b(Context paramContext, String paramString)
    {
        i.b(paramContext, com.jingdong.jdpush.d.b.b(paramContext, paramString), 2014);
    }

    public static void c(Context paramContext, String paramString)
    {
        i.b(paramContext, com.jingdong.jdpush.d.b.c(paramContext, paramString), 2016);
    }
}
