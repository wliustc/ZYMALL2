package com.zy.app.mall.home.floor.a.b;

import android.text.TextUtils;

import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/5/23.
 */
//i
public class MallFloorTypeUtil {
    //public final static int a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8, i = 9, j = 10, k = 11, l = 12, m = 13,   n = 14,       o = 15,           p = 16,    q = 17, r = 18, s = 19, t = 20, u = 21, v = 22, w = 23, x = 24;
    //                        05003, 05004, 05005, 05006, 05007, 12,    13,    15,    19,    banner, 05001,  05002, appcenter, announcement, indexTopicStreet, recommend, float,  hybrid, 05008,  05009,  01003,  01004,  01005,  null
    public final static int E_05003 = 1, E_05004 = 2, E_05005 = 3, E_05006 = 4, E_05007 = 5, E_12 = 6, E_13 = 7, E_15 = 8, E_19 = 9, BANNER = 10,
                            E_05001 = 11, E_05002 = 12, APPCENTER = 13, ANNOUNCEMENT = 14, INDEX_TOPIC_STREET = 15, RECOMMEND = 16, FLOAT = 17, HYBRID = 18,
                            E_05008 = 19, E_05009 = 20, E_01003 = 21, E_01004 = 22, E_01005 = 23, NULL = 24;

    //public static int a(HomeFloorNewElements homeFloorNewElements)
    public static int getFloorTypeByFloorElements(HomeFloorNewElements homeFloorNewElements) {
        if (homeFloorNewElements == null) {
            Log.i("FloorType", "getFloorTypeByFloorModel-error type-element is null");
            return NULL;
        }
        String tpl = homeFloorNewElements.getTpl();
        tpl.equals("11");
        if (tpl.equals("15"))
            return E_15;
        else if (tpl.equals("12"))
            return E_12;
        else if (tpl.equals("13"))
            return E_13;
        else if (tpl.equals("19"))
            return E_19;
            ////else if(tpl.equals("14"))

        else if (tpl.equals("05001"))
            return E_05001;
        else if (tpl.equals("05002"))
            return E_05002;
        else if (tpl.equals("05003"))
            return E_05003;
        else if (tpl.equals("05004"))
            return E_05004;
        else if (tpl.equals("05005"))
            return E_05005;
        else if (tpl.equals("05006"))
            return E_05006;
        else if (tpl.equals("05007"))
            return E_05007;
        else if (tpl.equals("05008"))
            return E_05008;
        else if (tpl.equals("05009"))
            return E_05009;
        else if (tpl.equals("01003"))
            return E_01003;
        else if (tpl.equals("01004"))
            return E_01004;
        else if (tpl.equals("01005"))
            return E_01005;
        else
            Log.i("FloorType", "getFloorTypeByFloorModel-error type-element type:" + tpl);
        return NULL;
    }

    //public static int a(HomeFloorNewModel homeFloorNewModel)
    public static int getFloorTypeByFloorModel(HomeFloorNewModel homeFloorNewModel) {
        if (homeFloorNewModel == null)
            return NULL;
        String type = homeFloorNewModel.getType();
        if (TextUtils.isEmpty(type))
            return NULL;
        else if ("banner".equals(type))
            return BANNER;
        else if ("appcenter".equals(type))
            return APPCENTER;
        else if ("announcement".equals(type))
            return ANNOUNCEMENT;
        else if ("indexTopicStreet".equals(type))
            return INDEX_TOPIC_STREET;
        else if ("recommend".equals(type))
            return RECOMMEND;
        else if ("float".equals(type))
            return FLOAT;
        else if ("hybrid".equals(type))
            return HYBRID;
        else
            Log.i("FloorType", "getFloorTypeByFloorModel-error type:" + type);
        return NULL;
    }
}


