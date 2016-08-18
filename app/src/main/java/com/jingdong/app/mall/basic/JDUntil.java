package com.jingdong.app.mall.basic;

import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import com.jingdong.common.config.Configuration;

import java.lang.reflect.Field;

/**
 * Created by Robin on 2016/4/14.
 */
// n
public class JDUntil {
    private static Boolean a;

    static
    {
        String str = Configuration.getProperty(Configuration.PARTNER);
        if ((!TextUtils.isEmpty(str)) && (("meizu".equals(str)) || ("oem-cxmeizu".equals(str))))
        {
            a = null;
        }else
            a = new Boolean(false);

    }

    public static void a(Window paramWindow, boolean paramBoolean)
    {
        try
        {
            WindowManager.LayoutParams attributes = paramWindow.getAttributes();
            Field localField = attributes.getClass().getDeclaredField("meizuFlags");
            localField.setAccessible(true);
            localField.setInt(attributes, localField.getInt(attributes) | 0x800);
            return;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //public static boolean a()
    public static boolean hasSmartBar()
    {
        if (a == null)
            a = Boolean.valueOf(b());
        return a.booleanValue();
    }

    //private static boolean b()
    private static boolean b()
    {
        try
        {
            boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            return bool;
        }
        catch (Exception localException)
        {
            if (Build.DEVICE.equals("mx2"))
                return true;
            if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9")))
                return false;
        }
        return false;
    }
}
