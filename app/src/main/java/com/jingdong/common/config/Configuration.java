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
        /**
         * 该方法未实现
         */
        ////throw new RuntimeException("Not Find getBooleanProperty(String paramString)");

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
        /**
         * 该方法未实现
         */
        ////throw new RuntimeException("Not Find getBooleanProperty(String paramString)");
        return s;
    }

    public static String getNgwHost() {
        return ngwHost;
    }
}
