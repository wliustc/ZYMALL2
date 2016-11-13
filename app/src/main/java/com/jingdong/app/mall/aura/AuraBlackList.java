package com.jingdong.app.mall.aura;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.HttpGroup;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.Log;

import org.json.JSONArray;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Robin on 2016/11/6.
 */
//a
public class AuraBlackList {
    //private static com.jingdong.app.mall.aura.internal.a a = new com.jingdong.app.mall.aura.internal.a();

    static Set<String> a()
    {
        return com.zy.common.utils.CommonUtil.getJdSharedPreferences().getStringSet("add", null);
    }

    public static void a(IMyActivity paramIMyActivity, boolean paramBoolean)
    {
        //TODO:未实现

    }

    static Set<String> b()
    {
        return com.zy.common.utils.CommonUtil.getJdSharedPreferences().getStringSet("minus", null);
    }
}
