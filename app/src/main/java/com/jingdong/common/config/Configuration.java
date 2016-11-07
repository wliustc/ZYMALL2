package com.jingdong.common.config;

/**
 * Created by Robin on 2016/4/14.
 */
public class Configuration {
    public static final String PARTNER = "partner";
    private static String ngwHost;

    public static String getProperty(String partner) {
        return (String)null;
    }

    public static Boolean getBooleanProperty(String paramString) {
        //TODO: 该方法未实现

        return false;

    }

    public static String getPortalHost() {
        throw new RuntimeException("Not Find getPortalHost()");
    }

    public static String getPayUrl()
    {
        throw new RuntimeException("getPayUrl()");
    }

    public static String getProperty(String client, String s) {
        //TODO: 该方法未实现
        return s;
    }

    public static String getNgwHost() {
        return ngwHost;
    }

    public static String getCommentHost()
    {
        return HostConfig.getInstance().getHost(HostConstants.COMMENT_HOST);
    }

    public static Integer getIntegerProperty(String paramString)
    {
        return getIntegerProperty(paramString, null);
    }

    public static Integer getIntegerProperty(String paramString, Integer paramInteger)
    {
        paramString = getProperty(paramString);
        if (paramString == null)
            return paramInteger;
        try
        {
            return Integer.valueOf(paramString);
        }
        catch (java.lang.Exception e)
        {
        }
        return paramInteger;
    }
}
