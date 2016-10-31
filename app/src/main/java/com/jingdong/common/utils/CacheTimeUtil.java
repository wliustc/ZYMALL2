package com.jingdong.common.utils;

import com.jingdong.common.config.Configuration;

/**
 * Created by robin on 16-10-31.
 */
//y
public class CacheTimeUtil {
    public static void a()
    {
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setFunctionId("getCacheTime");
        localHttpSetting.setEffect(0);
        localHttpSetting.setCacheMode(2);
        localHttpSetting.setHost(Configuration.getPortalHost());
        localHttpSetting.setListener(new z());
        localHttpSetting.setNotifyUser(false);
        HttpGroupUtils.getHttpGroupaAsynPool().add(localHttpSetting);
    }
}
