package com.zy.app.mall.home.floor.c;

import android.content.Context;

import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.c.FloorMainDianData;
import com.zy.common.utils.JDMtaUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Robin on 2016/5/17.
 */
//a
public class FloorMaiDianCtrl {
    private static FloorMaiDianCtrl instance;
    private HashMap<String, FloorMainDianData> b = new HashMap();

    public static FloorMaiDianCtrl getInstance()
    {
        if (instance == null){
            synchronized (FloorMaiDianCtrl.class){
                if (instance == null)
                    instance = new FloorMaiDianCtrl();
            }
        }
            return instance;
    }

    public final void a(String paramString, FloorMainDianData paramb)
    {
        if (this.b.get(paramString) == null)
            this.b.put(paramString, paramb);
    }

    public final void a(String paramString1, String paramString2)
    {
        FloorMainDianData data = (FloorMainDianData)this.b.get(paramString1);
        if (data != null)
        {
            if (data.e.get(paramString2) != null)
                data.e.put(paramString2, Integer.valueOf(((Integer)data.e.get(paramString2)).intValue() + 1));
        }
        else
            return;
        data.e.put(paramString2, Integer.valueOf(1));
    }

    public final void b()
    {
        Iterator localIterator1 = this.b.entrySet().iterator();
        while (localIterator1.hasNext())
        {
            FloorMainDianData localb = (FloorMainDianData)((Map.Entry)localIterator1.next()).getValue();
            if (localb.e.size() == 0)
                continue;
            Context localContext = localb.a;
            String str2 = localb.b;
            Iterator localIterator2 = localb.e.entrySet().iterator();
            Map.Entry localEntry;
            String str1 = "{";
            for( ; localIterator2.hasNext(); str1 = str1 + "'" + localEntry.getValue() + "',")
            {
                localEntry = (Map.Entry)localIterator2.next();
                str1 = str1 + "'" + localEntry.getKey() + "':";
            }
            str1 = str1.substring(0, str1.lastIndexOf(","));
            JDMtaUtils.sendCommonData(localContext, str2, str1 + "}", "", localb.d, "", "", "", Constants.b);
        }
    }

    public final void c()
    {
        Iterator localIterator = this.b.entrySet().iterator();
        while (localIterator.hasNext())
        {
            FloorMainDianData localb = (FloorMainDianData)((Map.Entry)localIterator.next()).getValue();
            if (localb.e.size() == 0)
                continue;
            localb.e.clear();
        }
    }
}
