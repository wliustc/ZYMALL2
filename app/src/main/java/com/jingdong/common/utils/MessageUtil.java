package com.jingdong.common.utils;

import com.jingdong.cloud.jdpush.JDPushInterface;
import com.jingdong.common.BaseApplication;
import com.jingdong.common.config.Configuration;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/11/10.
 */
//dd
public class MessageUtil {
    private static Boolean a;

    public static void a(boolean paramBoolean)
    {
        if (!a())
            return;
        if (Log.D)
        {
            Log.d("MessageUtil", "setMsgServiceEnabled : " + paramBoolean);
            Log.d("MessageUtil", "call method JDPushInterface.setPushEnabled(MyApplication.getInstance().getApplicationContext(), enable) : " + paramBoolean);
        }
        JDPushInterface.a(BaseApplication.getInstance().getApplicationContext(), paramBoolean);
    }

    public static boolean a()
    {
        if (a == null)
            a = Configuration.getBooleanProperty("msgMode", Boolean.valueOf(false));
        return a.booleanValue();
    }
}
