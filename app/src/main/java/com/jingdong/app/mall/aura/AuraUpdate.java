package com.jingdong.app.mall.aura;

import android.content.Context;

import java.util.Iterator;

/**
 * Created by Robin on 2016/11/3.
 */
//j
public class AuraUpdate {
    private static d a = new d("AuraControl");
    private static com.jingdong.app.mall.aura.internal.a b;

    static
    {
        com.jingdong.app.mall.aura.internal.a locala = new com.jingdong.app.mall.aura.internal.a();
        b = locala;
        locala.a(600000L);
    }

    public static void a()
    {
        if (b.a())
            c.a().a(null, null, null);
    }

    public static void a(Context paramContext)
    {
        if (!ev.a())
            return;
        Iterator localIterator = AuraBundleInfos.getUpdateIDKeySet().iterator();
        while (localIterator.hasNext())
            b(paramContext, com.jingdong.common.a.a.a((String)localIterator.next(), null));
        c.a().a(null, null);
    }

    static void b(Context paramContext)
    {
        paramContext = new k(paramContext);
        Iterator localIterator = AuraBundleInfos.getUpdateIDKeySet().iterator();
        while (localIterator.hasNext())
            com.jingdong.common.a.a.b((String)localIterator.next(), paramContext);
    }

    private static void b(Context paramContext, h paramh)
    {
        Log.d("updateAura", "updateAura called. apkResult =  " + paramh);
        if (paramh == null);
        do
            return;
        while ((paramh.k() == null) || (!paramh.k().equals(StatisticsReportUtil.getSoftwareVersionName())) || (TextUtils.isEmpty(paramh.g())));
        paramContext = new l(paramContext, paramh);
        a.a(paramContext);
    }
}
