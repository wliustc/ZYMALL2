package com.jingdong.app.mall.aura;

import android.content.Context;


import com.zy.app.mall.aura.internal.AuraConfigTimer;
import com.zy.app.mall.aura.internal.SequenceExecutor;
import com.zy.common.utils.Log;

import java.util.Iterator;

/**
 * Created by Robin on 2016/11/3.
 */
//j
public class AuraUpdate {
    private static SequenceExecutor a = new SequenceExecutor("AuraControl");//new d("AuraControl");
    private static AuraConfigTimer b; //com.jingdong.app.mall.aura.internal.a

    static
    {
        AuraConfigTimer b = new AuraConfigTimer();
        b.a(600000L);
    }

//    public static void a()
//    {
//        if (b.a())
//            ApkDownloadController.a().a(null, null, null);//c.a().a(null, null, null);
//    }

    public static void a(Context paramContext)
    {
//        if (!ev.a())
//            return;
//        Iterator localIterator = AuraBundleInfos.getUpdateIDKeySet().iterator();
//        while (localIterator.hasNext())
//            b(paramContext, com.jingdong.common.a.a.a((String)localIterator.next(), null));
//        c.a().a(null, null);
    }

//    static void b(Context paramContext)
//    {
//        paramContext = new k(paramContext);
//        Iterator localIterator = AuraBundleInfos.getUpdateIDKeySet().iterator();
//        while (localIterator.hasNext())
//            com.jingdong.common.a.a.b((String)localIterator.next(), paramContext);
//    }
//
//    private static void b(Context paramContext, h paramh)
//    {
//        Log.d("updateAura", "updateAura called. apkResult =  " + paramh);
//        if (paramh == null);
//        do
//            return;
//        while ((paramh.k() == null) || (!paramh.k().equals(StatisticsReportUtil.getSoftwareVersionName())) || (TextUtils.isEmpty(paramh.g())));
//        paramContext = new l(paramContext, paramh);
//        a.a(paramContext);
//    }
}
