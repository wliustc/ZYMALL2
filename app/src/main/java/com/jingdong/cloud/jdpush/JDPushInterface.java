package com.jingdong.cloud.jdpush;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

/**
 * Created by Robin on 2016/11/10.
 */
//a
public class JDPushInterface {
    private static final String a = a.class.getSimpleName();

    public static void a(Context paramContext)
    {
        if (paramContext == null)
        {
            Toast.makeText(paramContext, "传参可能为空", 0).show();
            return;
        }
        com.jingdong.cloud.jdpush.f.a.a(Environment.getExternalStorageDirectory() + "/jmp_log.txt");
        b.a(paramContext);
        com.jingdong.cloud.jdpush.connect.a.a = true;
        com.jingdong.cloud.jdpush.connect.a.a(paramContext);
    }

    public static void a(Context paramContext, boolean paramBoolean)
    {
        if (paramContext == null)
            Toast.makeText(paramContext, "传参可能为空", 0).show();
        do
        {
            return;
            if (!paramBoolean)
                continue;
            i.a(paramContext, "jd_cloud_push_enable", "Y");
            return;
        }
        while (paramBoolean);
        i.a(paramContext, "jd_cloud_push_enable", "N");
    }
}
