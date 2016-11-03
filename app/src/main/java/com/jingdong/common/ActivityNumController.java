package com.jingdong.common;

import android.app.Activity;
import android.text.TextUtils;

import com.zy.common.JDSoftReference;
import com.zy.common.utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by robin on 16-10-31.
 */
//a
public class ActivityNumController {
    public static int a;
    public static boolean b;
    private static final String c = ActivityNumController.class.getSimpleName();
    private static final ArrayList<JDSoftReference<Activity>> d = new ArrayList();
    private static final ArrayList<String> e = new ArrayList();
    private static final HashMap<String, Integer> f = new HashMap();
    private static final HashMap<String, ArrayList<JDSoftReference<Activity>>> g = new HashMap();
    private static final HashMap<String, Integer> h = new HashMap();

    static
    {
        a = 10;
        b = true;
    }

//    public static void a()
//    {
//        boolean bool;
//        int i;
//        if (!com.jingdong.common.e.a.a(7, false))
//        {
//            bool = true;
//            b = bool;
//            if (bool)
//            {
//                i = Integer.parseInt(com.jingdong.common.e.a.a("shared_max_stack_clientConfig", "0"));
//                if (i != 0)
//                    break label261;
//                e.add("com.jingdong.app.mall.MainFrameActivity");
//                f.put("com.jingdong.app.mall.product.ProductDetailActivity", Integer.valueOf(3));
//                f.put("com.jingdong.app.mall.searchRefactor.view.Activity.ProductListActivity", Integer.valueOf(3));
//                f.put("com.jingdong.common.sample.jshop.JshopMainShopActivity", Integer.valueOf(2));
//            }
//        }
//        while (true)
//        {
//            if (!e.contains("com.jingdong.app.mall.MainFrameActivity"))
//                e.add("com.jingdong.app.mall.MainFrameActivity");
//            f.put("com.jingdong.app.mall.settlement.CompleteOrderActivity", Integer.valueOf(1));
//            Object localObject1 = f.entrySet().iterator();
//            Object localObject2;
//            while (((Iterator)localObject1).hasNext())
//            {
//                localObject2 = (Map.Entry)((Iterator)localObject1).next();
//                String str = (String)((Map.Entry)localObject2).getKey();
//                i = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
//                if ((str == null) || (str.length() < 3) || (i <= 0))
//                    continue;
//                g.put(str, new ArrayList());
//                h.put(str, Integer.valueOf(i));
//                if (!Log.D)
//                    continue;
//                Log.d(c, "init--->" + str + "---->" + i);
//            }
//            bool = false;
//            break;
//            label261: a = i;
//            localObject1 = com.jingdong.common.e.a.a("shared_not_statck_activity_clientConfig", null);
//            if ((localObject1 != null) && (((String)localObject1).length() > 3))
//            {
//                localObject1 = ((String)localObject1).trim().split(";");
//                j = localObject1.length;
//                i = 0;
//                while (i < j)
//                {
//                    localObject2 = localObject1[i];
//                    if ((localObject2 != null) && (((String)localObject2).length() >= 3))
//                        e.add(localObject2);
//                    i += 1;
//                }
//            }
//            localObject1 = com.jingdong.common.e.a.a("shared_control_activity_clientConfig", null);
//            if ((localObject1 == null) || (((String)localObject1).length() <= 3))
//                continue;
//            localObject1 = ((String)localObject1).trim().split(";");
//            int j = localObject1.length;
//            i = 0;
//            while (i < j)
//            {
//                localObject2 = localObject1[i].trim().split(":");
//                if ((localObject2[0] != null) && (localObject2[0].length() >= 3) && (localObject2[1] != null) && (!"".equals(localObject2[1])))
//                    f.put(localObject2[0], Integer.valueOf(Integer.parseInt(localObject2[1])));
//                i += 1;
//            }
//        }
//    }

    public static void a(JDSoftReference<Activity> paramp)
    {
        Object localObject = (String)paramp.a();
        if (!b) {
            if (!((String) localObject).equals("com.jingdong.app.mall.MainFrameActivity"))
                d.add(paramp);
        }else{
            if (Log.D)
                Log.d(c, a + "------allList------" + d.size());
            if (e.contains(localObject)){
                ArrayList localArrayList = (ArrayList)g.get(localObject);
                if ((localArrayList != null) && (localArrayList.size() >= ((Integer)h.get(localObject)).intValue()))
                {
                    localObject = (JDSoftReference)localArrayList.remove(0);
                    d.remove(localObject);
                    ((Activity)((JDSoftReference)localObject).get()).finish();
                }
                if (d.size() >= a)
                {
                    localObject = (JDSoftReference)d.remove(0);
                    if (g.get(((JDSoftReference)localObject).a()) != null)
                        ((ArrayList)g.get(((JDSoftReference)localObject).a())).remove(localObject);
                    ((Activity)((JDSoftReference)localObject).get()).finish();
                }
                if (localArrayList != null)
                {
                    localArrayList.add(paramp);
                    if (Log.D)
                        Log.d(c, "------childCtrlList------" + localArrayList.size());
                }
                d.add(paramp);
                if(Log.D)
                    Log.d(c, "------add activity------" + ((Activity)paramp.get()).getClass().getSimpleName());
            }
        }
        return;
    }

    public static void a(String paramString)
    {
        ArrayList localArrayList2 = new ArrayList();
        JDSoftReference localp;

        //:goto_0
        for (int i = 0;i < d.size(); i++){//if-ge v4, v6, :cond_7
            localp = (JDSoftReference)d.get(i);
            if (localp != null){//if-eqz v0, :cond_6
                Activity localObject = null;
                try {
                    localObject = (Activity) localp.get();
                } catch (Exception e) {
                    if (Log.D)
                        e.printStackTrace();
                }
                //:cond_0
                //:goto_1
                if (localObject == null) {//if-nez v3, :cond_2
                    return;
                }
                //:cond_2
                if ((TextUtils.isEmpty(paramString)) || (!localObject.getClass().getSimpleName().equals(paramString))) {//if-nez v1, :cond_3 if-nez v1, :cond_6
                    if (Log.D)
                        Log.d(c, "exitActivityNonByClassName() finish " + localObject.getClass().getSimpleName());
                    localArrayList2.add(localp);
                    ArrayList localArrayList1 = (ArrayList) g.get(localObject.getClass().getName());
                    if (localArrayList1 != null)
                        localArrayList1.remove(localp);
                    ((Activity) localObject).finish();
                }
            }//:cond_6
        }

            for (int i = 0; i < localArrayList2.size(); i++)
            {
                d.remove(localArrayList2.get(i));
            }

    }

//    public static void b()
//    {
//        int j = 0;
//        ArrayList localArrayList2 = new ArrayList();
//        int i = 0;
//        JDSoftReference localp;
//        ArrayList localArrayList1;
//        if (i < d.size() - 1)
//        {
//            localp = (JDSoftReference)d.get(i);
//            if (localp != null)
//                localArrayList1 = null;
//        }
//        while (true)
//        {
//            try
//            {
//                localObject = (Activity)localp.get();
//                if (localObject == null)
//                    return;
//            }
//            catch (Exception localException)
//            {
//                Object localObject = localArrayList1;
//                if (!Log.D)
//                    continue;
//                localException.printStackTrace();
//                localObject = localArrayList1;
//                continue;
//                localArrayList2.add(localp);
//                localArrayList1 = (ArrayList)g.get(localObject.getClass().getName());
//                if (localArrayList1 == null)
//                    continue;
//                localArrayList1.remove(localp);
//                ((Activity)localObject).finish();
//            }
//            i += 1;
//            break;
//            int k = localArrayList2.size();
//            i = j;
//            while (i < k)
//            {
//                d.remove(localArrayList2.get(i));
//                i += 1;
//            }
//        }
//    }

    public static void b(JDSoftReference<Activity> paramp)
    {
        if (d != null)
            d.remove(paramp);
        ArrayList localArrayList = (ArrayList)g.get(paramp.a());
        if (localArrayList != null)
            localArrayList.remove(paramp);
    }

    public static void c()
    {
        int i = d.size();
        if (i > 2) {
            try {
                Activity localActivity = (Activity) ((JDSoftReference) d.remove(i - 2)).get();
                if (localActivity != null)
                    localActivity.finish();
            } catch (Exception e) {
                if (Log.D)
                    e.printStackTrace();
            }
        }
        return;
    }
}
