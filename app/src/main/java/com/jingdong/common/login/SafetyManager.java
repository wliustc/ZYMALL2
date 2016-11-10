package com.jingdong.common.login;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/11/10.
 */
public class SafetyManager {
    private static final String OLD_NEW_COOKIES = "cookies";
    private static final String OLD_OLD_COOKIES = "oldCookies";
    private static final String OLD_REMEMBER_FLAG = "remember";
    private static final String OLD_REMEMBER_NAME = "userName";
    private static final String OLD_REMEMBER_PASSWORD = "password";
    private static final String SHARED_PREFERENCE_COOKIES = "jdPrice";
    private static final String SHARED_PREFERENCE_COOKIES_OLD = "price";
    private static final String SHARED_PREFERENCE_IS_REMEMBER = "isCollection";
    private static final String SHARED_PREFERENCE_PASSWORD = "name";
    private static final String SHARED_PREFERENCE_USERNAME = "productCode";
    private static final String SHARED_PREFERENCE_USER_INFO = "price_info";
    private static final String TAG = "SafetyManager";
    private static String cacheCookies;

    public static void clearCookies()
    {
        if (Log.D)
            Log.d("SafetyManager", " clearCookies ");
        getSharedPreferences().edit().putString("jdPrice", "").commit();
    }

    public static void clearSafety()
    {
        getSharedPreferences().edit().clear().commit();
    }

    public static void compatibleOldVersion()
    {
        SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();
        if (localSharedPreferences.getBoolean("remember", false))
        {
            saveSafety(localSharedPreferences.getString("userName", null), localSharedPreferences.getString("password", null), true);
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.remove("remember");
            localEditor.remove("userName");
            localEditor.remove("password");
            localEditor.commit();
        }
        if (localSharedPreferences.getString("cookies", null) != null)
        {
            saveCookies(localSharedPreferences.getString("cookies", null));
            localSharedPreferences.edit().remove("cookies").commit();
        }
        if (localSharedPreferences.getString("oldCookies", null) != null)
        {
            saveOldCookies(localSharedPreferences.getString("oldCookies", null));
            localSharedPreferences.edit().remove("oldCookies").commit();
        }
    }

    public static String getCookies()
    {
        String str1 = getSharedPreferences().getString("jdPrice", null);
        if (!TextUtils.isEmpty(str1))
            str1 = JniUtils.dP(str1);
        while (true)
        {
            if (Log.D)
                Log.d("SafetyManager", " getCookies -->> cookies:" + str1);
            return str1;
            String str2 = gp.b().a();
            if (TextUtils.isEmpty(str2))
                continue;
            str1 = "whwswswws=" + str2 + ";";
        }
    }

    public static String getOldCookies()
    {
        String str2 = getSharedPreferences().getString("price", null);
        String str1 = str2;
        if (str2 != null)
            str1 = JniUtils.dP(str2);
        if (Log.D)
            Log.d("SafetyManager", " getOldCookies -->> cookies:" + str1);
        return str1;
    }

    public static String getPassword()
    {
        String str2 = getSharedPreferences().getString("name", null);
        String str1 = str2;
        if (str2 != null)
        {
            if ((!JniUtils.isLoaded) && (!JniUtils.tryLoad()))
                str1 = "";
        }
        else
            return str1;
        return JniUtils.dP(str2);
    }

    private static SharedPreferences getSharedPreferences()
    {
        BaseApplication.networkSetting();
        return BaseApplication.getInstance().getApplicationContext().getSharedPreferences(getSharedPreferencesName(), 0);
    }

    private static String getSharedPreferencesName()
    {
        try
        {
            String str = JniUtils.getSHN();
            return str;
        }
        catch (Throwable localThrowable)
        {
            if (Log.E)
                Log.e("SafetyManager", " getSharedPreferencesName -->> " + localThrowable.getMessage());
            localThrowable.printStackTrace();
        }
        return null;
    }

    public static String getUserInfo()
    {
        return getSharedPreferences().getString("price_info", "");
    }

    public static String getUserName()
    {
        String str2 = getSharedPreferences().getString("productCode", null);
        String str1 = str2;
        if (str2 != null)
        {
            if ((!JniUtils.isLoaded) && (!JniUtils.tryLoad()))
                str1 = "";
        }
        else
            return str1;
        return JniUtils.dU(str2);
    }

    public static String getUserNameFromSDK()
    {
        gp.b();
        return d.c();
    }

    public static void initEncryptKey()
    {
        SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();
        String str2 = localSharedPreferences.getString("jd_key4", null);
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
            str1 = JniUtils.eMK();
            localSharedPreferences.edit().putString("jd_key4", str1).commit();
        }
        CommonUtil.miaoShaKey = str1;
    }

    public static boolean isRemember()
    {
        return getSharedPreferences().getBoolean("isCollection", false);
    }

    public static String jointCookie(String paramString1, String paramString2, String paramString3)
            throws UnsupportedEncodingException
    {
        return "pin=" + URLEncoder.encode(paramString1, "UTF-8") + "; wskey=" + paramString2 + "; whwswswws=" + paramString3 + ";";
    }

    public static void removePassword()
    {
        getSharedPreferences().edit().remove("name").commit();
    }

    public static void removeRemember()
    {
        getSharedPreferences().edit().remove("isCollection").commit();
    }

    public static void removeUsername()
    {
        getSharedPreferences().edit().remove("productCode").commit();
    }

    public static void saveCookies(String paramString)
    {
        if (Log.D)
            Log.d("SafetyManager", " saveCookies -->> cookies:" + paramString);
        if (cacheCookies == null)
            cacheCookies = getCookies();
        if (TextUtils.equals(cacheCookies, paramString))
        {
            if (Log.D)
                Log.d("SafetyManager", " saveCookies -->> cookies already saved");
            return;
        }
        cacheCookies = paramString;
        if (Log.D)
            Log.d("SafetyManager", " saveCookies -->> cookies save succeed");
        if (TextUtils.isEmpty(paramString))
        {
            getSharedPreferences().edit().remove("jdPrice").commit();
            return;
        }
        paramString = JniUtils.eP(paramString);
        getSharedPreferences().edit().putString("jdPrice", paramString).commit();
    }

    public static void saveOldCookies(String paramString)
    {
        if (Log.D)
            Log.d("SafetyManager", " saveOldCookies -->> cookies:" + paramString);
        if (TextUtils.isEmpty(paramString))
        {
            getSharedPreferences().edit().remove("price").commit();
            return;
        }
        paramString = JniUtils.eP(paramString);
        getSharedPreferences().edit().putString("price", paramString).commit();
    }

    public static void saveSafety(String paramString)
    {
        if (TextUtils.isEmpty(paramString))
            return;
        SharedPreferences.Editor localEditor = getSharedPreferences().edit();
        localEditor.putString("productCode", JniUtils.eU(paramString));
        localEditor.commit();
    }

    public static void saveSafety(String paramString1, String paramString2, boolean paramBoolean)
    {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
            return;
        SharedPreferences.Editor localEditor = getSharedPreferences().edit();
        localEditor.putString("productCode", JniUtils.eU(paramString1));
        localEditor.putString("name", JniUtils.eP(paramString2));
        localEditor.putBoolean("isCollection", paramBoolean);
        localEditor.commit();
    }

    public static void saveUserInfo(String paramString)
    {
        getSharedPreferences().edit().putString("price_info", paramString).commit();
    }

    public static void setRemember(boolean paramBoolean)
    {
        getSharedPreferences().edit().putBoolean("isCollection", paramBoolean).commit();
    }
}
