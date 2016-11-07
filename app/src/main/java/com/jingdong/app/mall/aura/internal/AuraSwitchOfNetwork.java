package com.jingdong.app.mall.aura.internal;

import android.util.Log;

import com.jingdong.common.utils.HttpGroup;
import com.zy.common.frame.IMyActivity;

/**
 * Created by robin on 16-11-7.
 */
//b
public class AuraSwitchOfNetwork {
    private static a a = new a();
    private static ArrayList<i> b = new ArrayList();

    public static void a(i parami)
    {
        monitorenter;
        try
        {
            if (b != null)
                b.add(parami);
            monitorexit;
            return;
        }
        finally
        {
            parami = finally;
            monitorexit;
        }
        throw parami;
    }

    public static void a(IMyActivity paramIMyActivity, boolean paramBoolean)
    {
        if (paramIMyActivity == null)
            Log.v("AuraSwitchOfNetwork", "activity is null");
        do
            return;
        while ((!paramBoolean) || (!a.a()));
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setFunctionId("kvConfig");
        localHttpSetting.setHost(Configuration.getNgwHost());
        localHttpSetting.setEffect(0);
        localHttpSetting.setNotifyUser(false);
        localHttpSetting.putJsonParam("type", "auraSwitch");
        localHttpSetting.putJsonParam("buildId", CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance().getBaseContext()));
        localHttpSetting.setListener(new c());
        paramIMyActivity.getHttpGroupaAsynPool().add(localHttpSetting);
    }

    public static boolean a()
    {
        return a(1);
    }

    public static boolean a(int paramInt)
    {
        return (d() & paramInt) > 0;
    }

    public static String b()
    {
        return com.jingdong.common.e.a.a("auraSwitch");
    }

    private static int d()
    {
        String str = com.jingdong.common.e.a.a("auraSwitch");
        if ((str != null) && (!str.equals("")));
        while (true)
        {
            try
            {
                i = Integer.parseInt(str, 16);
                if (i < 0)
                    continue;
                int j = i;
                if (i <= 65535)
                    continue;
                j = 63;
                return j;
            }
            catch (Exception localException)
            {
                localException.printStackTrace();
                i = 63;
                continue;
            }
            int i = 63;
        }
    }
}
