package com.jingdong.common.utils;

/**
 * Created by Robin on 2016/11/6.
 */
public class HttpGroupUtils {
    public static HttpGroup getHttpGroupaAsynPool()
    {
        return getHttpGroupaAsynPool(1000);
    }

    public static HttpGroup getHttpGroupaAsynPool(int paramInt)
    {
        HttpGroup.HttpGroupSetting localHttpGroupSetting = new HttpGroup.HttpGroupSetting();
        localHttpGroupSetting.setType(paramInt);
        return getHttpGroupaAsynPool(localHttpGroupSetting);
    }

    public static HttpGroup getHttpGroupaAsynPool(HttpGroup.HttpGroupSetting paramHttpGroupSetting)
    {
        return HttpGroup.getHttpGroup(paramHttpGroupSetting);
    }
}
