package com.jingdong.common.login;

/**
 * Created by Robin on 2016/5/4.
 */
public abstract class LoginUserBase {
    public static final String CERTKEY = "cert";
    public static final String LOGIN_NAME = "loginName";
    public static final short LOGIN_TYPE_AUTO = 2;
    public static final short LOGIN_TYPE_MANUAL = 1;
    private static final String TAG  = LoginUserBase.class.getSimpleName();
    private static int UserState = 0;
    private static boolean isAlreadySyncCart = false;
    public static boolean isAutoRetryLogin = true;

    public static String getLoginUserName() {
        return "";
    }

    //private static JSONObject jbUserInfo;

    public static void init() {

    }

    public interface _D
    {
        public  void e();
    }
}
