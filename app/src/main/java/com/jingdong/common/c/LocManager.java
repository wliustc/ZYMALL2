package com.jingdong.common.c;

import android.content.Context;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.utils.AddressUtil;
import com.zy.common.entity.AddressGlobal;
import com.zy.common.res.StringUtil;
import com.zy.common.utils.Log;

import java.util.Map;
import java.util.Timer;

/**
 * Created by robin on 16-6-27.
 */
//c
public class LocManager {
    public static boolean a = false;
    public static double b;
    public static double c;
    public static int d = 1;
    public static int e;
    public static int f;
    public static String g = StringUtil.product_province_beijing;
    public static String h;
    public static String i;
    public static boolean j;
    //private static a k;
    private static LocManager o;
    //private static k r;
    private static boolean s = false;
    //private l l;
    private Context m;
    private boolean n = true;
    private boolean p;
    private Timer q;

    static
    {
        j = false;
    }

    private LocManager(Context paramContext)
    {
        this.m = paramContext;
    }

    private static double a(double paramDouble)
    {
        return 3.141592653589793D * paramDouble / 180.0D;
    }

    public static synchronized LocManager a() {

        if (Log.D)
            Log.d("LocManager", " getInstance -->>  ");
        if (o == null)
            o = new LocManager(BaseApplication.getInstance().getApplicationContext());
        //TODO: 下面代码未实现
        //k = o.c();
        LocManager localc = o;
        return localc;

    }

    public static boolean a(Map<String, Double> paramMap)
    {
        double d1 = ((Double)paramMap.get("lati")).doubleValue();
        double d3 = ((Double)paramMap.get("longi")).doubleValue();
        double d2 = b;
        double d4 = c;
        d1 = a(d1);
        d2 = a(d2);
        d3 = a(d3);
        d4 = a(d4);
        double d5 = Math.pow(Math.sin((d1 - d2) / 2.0D), 2.0D);
        d1 = Math.cos(d1);
        d2 = Math.cos(d2);
        if (Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((d3 - d4) / 2.0D), 2.0D) * (d1 * d2) + d5)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D > 5.0D)
        {
            b = ((Double)paramMap.get("lati")).doubleValue();
            c = ((Double)paramMap.get("longi")).doubleValue();
            return true;
        }
        return false;
    }

/*    public static void b()
    {
        if (Log.D)
            Log.d("LocManager", " removeUpdateLocation -->> ");
        if (k != null)
            k.b();
    }*/

    public static String e()
    {
        AddressGlobal localAddressGlobal = AddressUtil.a();
        if ((localAddressGlobal != null) && (localAddressGlobal.getIdProvince() != 0))
            return localAddressGlobal.getIdProvince() + "_" + localAddressGlobal.getIdCity() + "_" + localAddressGlobal.getIdArea() + "_" + localAddressGlobal.getIdTown();
        if (a)
            return d + "_" + e + "_" + f + "_0";
        return null;
    }

    /*private void g()
    {
        monitorenter;
        try
        {
            boolean bool = s;
            if (bool);
            while (true)
            {
                return;
                s = true;
                new g(this).start();
            }
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    public final void a(k paramk)
    {
        monitorenter;
        try
        {
            if (Log.D)
                Log.d("LocManager", " queryInfoByLocation -->> ");
            this.p = false;
            r = paramk;
            this.l = new l();
            this.l.a(new d(this));
            k.a(new e(this));
            k.a();
            this.q = new Timer();
            this.q.schedule(new f(this), 60000L);
            return;
        }
        finally
        {
            monitorexit;
        }
        throw paramk;
    }

    public final void a(com.jingdong.common.frame.c paramc, String paramString)
    {
        if (Log.D)
            Log.d("LocManager", " startLocationService -->> ");
        boolean bool = CommonUtil.getBooleanFromPreference("locationTip", Boolean.valueOf(true)).booleanValue();
        if ((Configuration.getBooleanProperty("locationTip", Boolean.valueOf(false)).booleanValue()) && (bool))
        {
            i locali = new i(this);
            locali.setTitle(StringUtil.prompt);
            locali.setMessage(paramString);
            locali.setPositiveButton(StringUtil.ok);
            locali.setNegativeButton(StringUtil.cancel);
            locali.setCanceledOnTouchOutside(false);
            locali.init(paramc.getThisActivity());
            paramc.getHandler().post(new j(this, locali));
            return;
        }
        g();
    }*/

    public final void c()
    {
        //TODO: 未实现
//        if (Log.D)
//            Log.d("LocManager", " onStop -->> ");
//        a();
//        b();
//        this.n = false;
    }

    public final void d()
    {
        if (Log.D)
            Log.d("LocManager", " onResume -->> ");
        this.n = true;
    }
}
