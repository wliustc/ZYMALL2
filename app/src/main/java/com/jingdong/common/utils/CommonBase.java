package com.jingdong.common.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.c.LocManager;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.c.PayMD5Util;
import com.zy.common.e.ConfigUtil;
import com.zy.common.frame.IMainActivity;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.ICommon;
import com.zy.common.utils.Log;
import com.zy.common.utils.NetUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Robin on 2016/4/19.
 */
//ab
public abstract class CommonBase implements ICommon {
    public static final String KEY_FAVO_PRICE_LOWER_NOTIFY_TIP = "favo_price_notify_tip";
    public static final String KEY_FAVO_PRODUCT_SORT_RECORD = "favo_product_sort_record";
    private static final String KEY_GUIDE_ACTIVITY = "guide_activity";
    public static final String KEY_GUIDE_COMMENT_EDIT = "guide_coo_comment_edit";
    public static final String KEY_GUIDE_COMMENT_LIST = "guide_coo_comment_list";
    public static final String KEY_GUIDE_SEARCH_FILTER = "guide_search_filter";
    public static final String KEY_ORIENTATION = "orientation";
    private static final String KEY_SHAKE_SKIN = "shake_switch_skin";
    public static final String KEy_FROM_GAME = "isFromGame";
    private static final String TAG = "CommonBase";
    public static final String VALUE_ORIENTATION = "screen_land";
    private static int build;
    public static boolean isOpenLastOne;
    private static boolean marketPriceFlag = false;
    public static String miaoShaKey;
    private static String pay_appId;
    public static SharedPreferences sharedPreferences;
    private boolean canShowInToastTime = true;

    static
    {
        build = -1;
        isOpenLastOne = true;
    }


    public static boolean CheckNetWork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE/*"connectivity"*/);
        if (connectivityManager == null)
            return false;
        NetworkInfo[] info = null;
        try {
            info = connectivityManager.getAllNetworkInfo();
        } catch (Exception localException) {
            if (Log.E)
                localException.printStackTrace();
        }
        for (int i = 0; info != null && i < info.length; i++) {
            if (info[i].isConnected())
                return true;
        }
        return false;

    }

    public static boolean activityIsGuided(String paramString)
    {
        if (!TextUtils.isEmpty(paramString)) {
            String[] arrayOfString = getJdSharedPreferences().getString("guide_activity", "").split("\\|");
            for (int i = 0; i < arrayOfString.length; i++) {
                String str = arrayOfString[i];
                if (Log.D)
                    Log.d("CommonBase", "activityIsGuided string -->> " + str);
                if (paramString.equalsIgnoreCase(str))
                    return true;
            }
        }
        return false;
    }

    public static void backToMain(Context paramContext)
    {
        ActivityInfo localActivityInfo = paramContext.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"), 0).activityInfo;
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.setComponent(new ComponentName(localActivityInfo.packageName, localActivityInfo.name));
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try
        {
            paramContext.startActivity(localIntent);
        }
        catch (android.content.ActivityNotFoundException e)
        {
        }
        catch (java.lang.SecurityException e)
        {
        }
        return;
    }

    public static boolean checkAddrWithSpace(String paramString)
    {
        return startCheck("[\\w\u4e00-\u9fa5\\-\\x20]+", paramString);
    }

    public static boolean checkEmailWithSuffix(String paramString)
    {
        return startCheck("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", paramString);
    }

    public static boolean checkIllegalChars(String paramString)
    {
        return startCheck("[*/+'\"\\$^.;<>={}@%~&]+", paramString);
    }

    public static int checkNetWorkType()
    {
        if (Proxy.getDefaultHost() != null)
            return 2;
        return 1;
    }

    public static boolean checkPassword(String paramString, int paramInt1, int paramInt2)
    {
        return startCheck("[a-zA-Z_0-9\\-]{" + paramInt1 + "," + paramInt2 + "}", paramString);
    }

    public static boolean checkPhone(String paramString)
    {
        return startCheck("[()\\-0-9]+", paramString);
    }

    public static boolean checkPhoneNumber(String paramString)
    {
        return startCheck("[*()\\-0-9]+", paramString);
    }

    public static boolean checkReceiveName(String paramString)
    {
        return startCheck("^([a-zA-Z\\u4E00-\\u9FA5]+(·?[a-zA-Z\\u4E00-\\u9FA5]+)+)$", paramString);
    }

    public static boolean checkSDcard()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean checkUsername(String paramString)
    {
        return startCheck("[\\\\w\\u4e00-\\u9fa5\\\\-a-zA-Z0-9_]+", paramString);
    }

    public static boolean checkUsername(String paramString, int paramInt)
    {
        return startCheck("[\\\\w\\u4e00-\\u9fa5\\\\-a-zA-Z0-9_]{" + paramInt + ",}", paramString);
    }

    public static boolean checkUsername(String paramString, int paramInt1, int paramInt2)
    {
        return startCheck("[\\\\w\\u4e00-\\u9fa5\\\\-a-zA-Z0-9_]{" + paramInt1 + "," + paramInt2 + "}", paramString);
    }

    public static void fixBackBroundRepeat(View paramView)
    {
        Drawable drawable = paramView.getBackground();
        if ((drawable != null) && ((drawable instanceof BitmapDrawable)))
        {
            ((BitmapDrawable)drawable).mutate();
            ((BitmapDrawable)drawable).setTileModeX(Shader.TileMode.REPEAT);
        }
    }

    public static final String formatForMoney(String paramString)
    {
        DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
        if (TextUtils.isEmpty(paramString))
            return "0.00";
        try
        {
            paramString = localDecimalFormat.format(Float.valueOf(paramString));
            return paramString;
        }
        catch (java.lang.NumberFormatException e)
        {
        }
        return "0.00";
    }

    public static boolean getAllShakeSwichState(String paramString)
    {
        if (TextUtils.isEmpty(paramString))
            return true;
        String[] arrayOfString = getJdSharedPreferences().getString("shake_switch_skin", "").split("\\|");

        for (int i = 0; i < arrayOfString.length; i++)
        {
            String str = arrayOfString[i];
            if (Log.D)
                Log.d("CommonBase", "getAllShakeSwichState string -->> " + str);
            if (paramString.equalsIgnoreCase(str))
                return true;

        }
        return false;
    }

    public static Boolean getBooleanFromPreference(String paramString, Boolean paramBoolean)
    {
        return Boolean.valueOf(getJdSharedPreferences().getBoolean(paramString, paramBoolean.booleanValue()));
    }

    public static String getCityIDFromSharedPreferences()
    {
        return getJdSharedPreferences().getString("globalCityID", null);
    }

    public static String getCityNameFromSharedPreferences()
    {
        return getJdSharedPreferences().getString("globalCityName", null);
    }

    public static String getDate(Date paramDate)
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(paramDate);
    }

    public static String getDeviceId()
    {
        return getDeviceId(BaseApplication.getInstance());
    }

    public static String getDeviceId(Context paramContext)
    {
        return ((TelephonyManager)paramContext.getSystemService(Context.TELEPHONY_SERVICE/*"phone"*/)).getDeviceId();
    }

    public static String getDistrictIdFromSharedPreferences()
    {
        return getJdSharedPreferences().getString("globalDistrictID", null);
    }

    public static String getExitType()
    {
        String str = ConfigUtil.a("exitType", "1");
        if (!TextUtils.isEmpty(str))
            return str;
        return "1";
    }

    public static String getFavoPriceLowerTip()
    {
        return getJdSharedPreferences().getString("favo_price_notify_tip", "");
    }

    public static int getFavoProductSortRecord()
    {
        return getJdSharedPreferences().getInt("favo_product_sort_record", 1);
    }

    public static boolean getHasShowFilterGuide()
    {
        return getJdSharedPreferences().getBoolean("guide_search_filter", false);
    }

    public static boolean getHasShowGuide(String paramString)
    {
        return getJdSharedPreferences().getBoolean(paramString, false);
    }

    public static boolean getHasShowSearchFavGuide()
    {
        return getJdSharedPreferences().getBoolean("search_result_fav_guide", false);
    }

    public static long getHomeActivityStoppedPeriod()
    {
        return getJdSharedPreferences().getLong("homeActivityStoppedTime", 0L);
    }

    public static int getIntFromPreference(String paramString, int paramInt)
    {
        return getJdSharedPreferences().getInt(paramString, paramInt);
    }

    public static boolean getIsJustShowHaveProduct()
    {
        return getJdSharedPreferences().getBoolean("justshowhaveproduct", true);
    }

    public static boolean getJdFaxianNewFlag()
    {
        return getJdSharedPreferences().getBoolean("jdFaxianNewFlag", true);
    }

    public static synchronized SharedPreferences getJdSharedPreferences()
    {

            if (sharedPreferences == null)
            {
                if (Log.D)
                    Log.d("CommonUtil", " -->> sharedPreferences:" + sharedPreferences);
                sharedPreferences = BaseApplication.getInstance().getSharedPreferences("jdAndroidClient", 0);
            }
            SharedPreferences localSharedPreferences = sharedPreferences;
            return localSharedPreferences;

    }

    public static boolean getJdStoryNewFlag()
    {
        return getJdSharedPreferences().getBoolean("jdStoryNewFlag", true);
    }

    public static synchronized SharedPreferences getJdStorySharedPreferences()
    {
            SharedPreferences localSharedPreferences = BaseApplication.getInstance().getSharedPreferences("lib_story_prefrence", 0);
            return localSharedPreferences;
    }

    public static int getLength(String paramString)
    {

        char[] c = paramString.toCharArray();
        int i = 0;
        for (int j = 0; j < c.length; j++)
        {
            if (isChinese(c[j]))
                i += 2;
            else
                i += 1;

        }
        return i;
    }

    public static synchronized void getLocalMacAddress(_AK paramak)
    {
            getLocalMacAddress(paramak, BaseApplication.getInstance());
            return;
    }

    public static synchronized void getLocalMacAddress(final _AK paramak, Context paramContext)
    {

            try
            {
                if (Log.D)
                    Log.d("CommonBase", "getMacAddress() -->> ");
                final WifiManager wifiManager = (WifiManager)paramContext.getSystemService(Context.WIFI_SERVICE/*"wifi"*/);
                if (wifiManager == null)
                paramak.a(null);
                else{
                    String str = wifiManager.getConnectionInfo().getMacAddress();
                    if (Log.D)
                        Log.d("CommonBase", "getMacAddress() macAddress without open -->> " + str);
                    if ((str != null) || (Configuration.getBooleanProperty("mustUseWifiMac").booleanValue()))
                        paramak.a(str);
                    else
                        new Thread(){//ag(wifiManager, new Object(), paramak)
                            private Object b;
                            @Override
                            public void run(){
                                if (Log.D)
                                    Log.d("CommonBase", "run() -->> ");
                                if (Log.D)
                                    Log.d("CommonBase", "run() setWifiEnabled -->> true");
                                int i = 0;
                                //:goto_0
                                String address = wifiManager.getConnectionInfo().getMacAddress();
                                while ((address == null) && (i < 5))
                                {
                                    i += 1;
                                    try
                                    {
                                        synchronized (this.b)
                                        {
                                            if (Log.D)
                                                Log.d("CommonBase", "getMacAddress() wait start 500 -->> ");
                                            this.b.wait(500L);
                                            if (Log.D)
                                                Log.d("CommonBase", "getMacAddress() wait end 500 -->> ");
                                        }
                                    }
                                    catch (InterruptedException e)
                                    {
                                            e.printStackTrace();
                                    }
                                }
                                if (Log.D)
                                    Log.d("CommonBase", "run() setWifiEnabled -->> false");
                                if (Log.D)
                                    Log.d("CommonBase", "getMacAddress() macAddress with open -->> " + (String)address);
                                paramak.a((String)address);
                            }
                        }.start();

                }
                return;

            }
            catch (Exception e)
            {
                paramak.a(null);
                e.printStackTrace();
                if (Log.D)
                Log.d("CommonBase", "getLocalMacAddress exception -->>" + e.getMessage());

            }


    }

    public static long getLongFromPreference(String paramString, long paramLong)
    {
        return getJdSharedPreferences().getLong(paramString, paramLong);
    }

    public static boolean getMarketPriceFlag()
    {
        boolean bool = ConfigUtil.a(11, false);
        marketPriceFlag = bool;
        return bool;
    }

    public static long getMiaoShaCountTime()
    {
        return getJdSharedPreferences().getLong("miaosha_count_time", 0L);
    }

    public static String getMiaoShaKey()
    {
        //return JniUtils.dMK(miaoShaKey);
        throw new RuntimeException("Not Find getMiaoShaKey()");
    }

    public static long getMiaoShaLeaveTime()
    {
        return getJdSharedPreferences().getLong("miaosha_leave_time", 0L);
    }

    public static PackageInfo getPackageInfo(Context paramContext, String paramString)
    {
        if (paramContext != null) {
            try {
                PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
                return packageInfo;
            } catch (Exception e) {
                if (Log.E)
                    e.printStackTrace();
            }
        }
        return null;
    }

    public static String getPayAppID(String paramString)
    {
//        if (HostConfig.getInstance().isUseBeta(HostConstants.PAY_URL))
//            return "android_app_beta";
//        return "jd_android_app4";
        throw new RuntimeException("Not Find getPayAppID(String paramString)");
    }

    public static String getPayAppKey()
    {
//        if (HostConfig.getInstance().isUseBeta(HostConstants.PAY_URL))
//            return "6fg7weDfF6gh";
//        return "e53jfgRgd7Hk";
        throw new RuntimeException("Not Find getPayAppKey()");
    }

    public static String getPhoneNumber(String paramString)
    {
        if (paramString != null && paramString.trim().length() != 0){
            try
            {
                paramString = paramString.replace(" ", "").replace("-", "").replace("\u2014", "").replace("+86", "");
                StringBuffer localStringBuffer = new StringBuffer();
                //:goto_1

                char c;
                for (int i = 0; i < paramString.length(); i++){
                    c = paramString.charAt(i);
                    if (((c < '0') || (c > '9')) && (c == '*')){//if-le v4, v5, :cond_4
                            continue;
                    }//:cond_4
                    localStringBuffer.append(c);
                }

                if (localStringBuffer.length() > 11)//if-le v1, v2, :cond_7
                    paramString = localStringBuffer.substring(localStringBuffer.length() - 11, localStringBuffer.length());
                else
                    paramString = localStringBuffer.toString();
                return paramString;

            }
            catch (Exception E)
            {
                if (Log.D)
                {
                    E.printStackTrace();
                }
            }
        }
        return "";
    }

    public static boolean getPlugCenterFlag()
    {
        return getJdSharedPreferences().getBoolean("plugCenterFlag", true);
    }

    public static long getPlugCenterRequestTime()
    {
        return getJdSharedPreferences().getLong("plugCenterRequestTime", 0L);
    }

    public static boolean getPlugOn()
    {
        return getJdSharedPreferences().getBoolean("plug_on_off", true);
    }

    public static boolean getPlugPersonelNew()
    {
        return getJdSharedPreferences().getBoolean("plugPersonelNew", false);
    }

    public static long getPlugRequestPeriod()
    {
        return getJdSharedPreferences().getLong("plugrequestperiod", 0L);
    }

    public static long getPlugRequestTime()
    {
        return getJdSharedPreferences().getLong("plugrequesttime", 0L);
    }

    public static String getProvinceIDFromSharedPreferences()
    {
        return getJdSharedPreferences().getString("globalProvinceID", null);
    }

    public static String getProvinceNameFromSharedPreferences()
    {
        return getJdSharedPreferences().getString("provinceName", "");
    }

    public static long getReActivationIntervalDays(long paramLong)
    {
        String str = ConfigUtil.a("remindertime", null);
        if (!TextUtils.isEmpty(str))
        try
        {
            return Long.parseLong(str);
        }
        catch (Exception localException)
        {

            if (Log.D)
            Log.d("CommonBase", " -->> getReActivationIntervalDays" + localException.getMessage());
        }
        return paramLong;
    }

    public static String getRegionNameSharedPreferences()
    {
        return getJdSharedPreferences().getString("regionName", "");
    }

    public static Boolean getRememberStateSharedPreferences()
    {
        return Boolean.valueOf(getJdSharedPreferences().getBoolean("rememberRegion", false));
    }

    public static int getSDKInt()
    {
        try
        {
            return Integer.parseInt(Build.VERSION.SDK);
        }
        catch (Exception e)
        {
        }
        return 3;
    }

    public static int getSelectedOrderSharedPreferences()
    {
        return getJdSharedPreferences().getInt("selectOrder", 0);
    }

    public static String getShakeShareText(String paramString)
    {
        return getJdSharedPreferences().getString(paramString, "");
    }

    public static String getSoftwareVersionCode(Context paramContext)
    {
        if (build == -1) {//if-eq v0, v3, :cond_0
            build = -1;
            if (paramContext != null) {  //if-nez p0, :cond_1
                try {
                    build = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
                } catch (Exception e) {
                    if (Log.V)
                        Log.v("CommonBase", "Package name not found", e);
                    build = -1;
                }
            }
        }
            return build+"";
    }

    public static String getString(String paramString)
    {
        String localObject1 = null;
        if (paramString != null)
        {
            if (getJdStorySharedPreferences().contains(paramString))
                localObject1 = getJdStorySharedPreferences().getString(paramString, null);
        }
        return (String)localObject1;
    }

    public static String getStringFromPreference(String paramString1, String paramString2)
    {
        return getJdSharedPreferences().getString(paramString1, paramString2);
    }

    public static String getThirdAddressIds()
    {
        return getJdSharedPreferences().getString("globalThirdAddressIds", null);
    }

    public static String getThirdAddressNames()
    {
        return getJdSharedPreferences().getString("globalThirdAddressNames", null);
    }

    public static String getTownIdFromSharedPreferences()
    {
        return getJdSharedPreferences().getString("globalTownID", null);
    }

    public static long getTriggerAtTime()
    {
        return getJdSharedPreferences().getLong("reActivationTriggerAtTime", -1L);
    }

    public static void handleHomeConnectReadTimeByNetType(HttpGroup.HttpSetting paramHttpSetting) {
        String str = NetUtils.getNetworkType();
        if ("2g".equals(str)) {
            paramHttpSetting.setConnectTimeout(15000);
            paramHttpSetting.setReadTimeout(15000);
        } else if ("3g".equals(str)) {
            paramHttpSetting.setConnectTimeout(10000);
            paramHttpSetting.setReadTimeout(10000);
        } else if("wifi".equals(str)) {
            paramHttpSetting.setConnectTimeout(7500);
            paramHttpSetting.setReadTimeout(7500);
        }

    }

    public static boolean isChinese(char paramChar)
    {
        Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
        return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
    }

    public static boolean isEncrypt(String paramString)
    {
        return (!TextUtils.isEmpty(paramString)) && (!paramString.contains("*"));
    }

    public static boolean isIntentAvailable(Intent paramIntent)
    {
        List<ResolveInfo> list = BaseApplication.getInstance().getPackageManager().queryIntentActivities(paramIntent, PackageManager.MATCH_DEFAULT_ONLY/*65536*/);
        return (list != null) && (list.size() > 0);
    }

    public static boolean isMyStreetNew()
    {
        return getJdSharedPreferences().getBoolean("MyJD_MyStreet_new", true);
    }

    public static boolean isOrderDetailGuideImageLoaded()
    {
        return getJdSharedPreferences().getBoolean("orderDetailGuideImage", false);
    }

    public static boolean isOrderTraceGuideImageLoaded()
    {
        return getJdSharedPreferences().getBoolean("orderTraceGuideImage", false);
    }

    public static boolean isPlugCenterInited()
    {
        return getJdSharedPreferences().getBoolean("plugCenterInited", false);
    }

    public static Intent newBrowserIntent(Uri paramUri, boolean paramBoolean)
    {
        Intent intent = new Intent("android.intent.action.VIEW", paramUri);
        if (paramBoolean)
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        return intent;
    }

    public static boolean putBooleanToPreference(String paramString, Boolean paramBoolean)
    {
        return getJdSharedPreferences().edit().putBoolean(paramString, paramBoolean.booleanValue()).commit();
    }

    public static boolean putIntToPreference(String paramString, int paramInt)
    {
        return getJdSharedPreferences().edit().putInt(paramString, paramInt).commit();
    }

    public static boolean putLongToPreference(String paramString, long paramLong)
    {
        return getJdSharedPreferences().edit().putLong(paramString, paramLong).commit();
    }

    public static boolean putStringToPreference(String paramString1, String paramString2)
    {
        return getJdSharedPreferences().edit().putString(paramString1, paramString2).commit();
    }

    public static void putTriggerAtTime(long paramLong)
    {
        getJdSharedPreferences().edit().putLong("reActivationTriggerAtTime", paramLong).commit();
    }

    public static void queryBrowserUrl(String paramString, URLParamMap paramURLParamMap, _AJ paramaj)
    {
        queryBrowserUrl(paramString, paramURLParamMap, paramaj, false);
    }

    public static void queryBrowserUrl(final String paramString, final URLParamMap paramURLParamMap, final _AJ paramaj, final boolean paramBoolean)
    {
        throw new RuntimeException("queryBrowserUrl(final String paramString, final URLParamMap paramURLParamMap, final _AJ paramaj, final boolean paramBoolean)");
//        if (Log.D)
//            Log.d("CommonBase", "queryBrowserUrl action-->> " + paramString);
//        Object localObject = new HttpGroup.HttpGroupSetting();
//        ((HttpGroup.HttpGroupSetting)localObject).setType(1000);
//        ((HttpGroup.HttpGroupSetting)localObject).setMyActivity(BaseApplication.getInstance().getCurrentMyActivity());
//        localObject = HttpGroup.getHttpGroup((HttpGroup.HttpGroupSetting)localObject);
//        final HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
//        localHttpSetting.setEffect(0);
//        localHttpSetting.setNotifyUser(false);
//        localHttpSetting.setHost(Configuration.getProperty("tokenHost"));
//        localHttpSetting.setFunctionId("genToken");
//        localHttpSetting.setListener(new HttpGroup.OnCommonListener(){//af(paramaj, paramString, paramURLParamMap, paramBoolean)
//            @Override
//            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {
//                if ((paramaj != null) && ((paramaj instanceof _AH)))
//                    ((_AH)paramaj).onReady();
//                paramHttpSettingParams.putJsonParam("action", paramString);
//                if (paramURLParamMap.get("to") != null)
//                    paramHttpSettingParams.putJsonParam("to", paramURLParamMap.get("to"));
//            }
//
//            @Override
//            public void onError(HttpGroup.HttpError paramHttpError) {
//                if ((paramBoolean) && ((paramaj instanceof _AI)))
//                    ((_AI)paramaj).onError(paramHttpError);
//            }
//
//            @Override
//            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
//                JSONObjectProxy jsonObject = paramHttpResponse.getJSONObject();
//                Object localObject = jsonObject.getStringOrNull("tokenKey");
//                if ((TextUtils.isEmpty((CharSequence) localObject)) || ("xxx".equals(localObject))) {
//                    onError(null);
//                    return;
//                }
//                String url = jsonObject.getStringOrNull("url");
//                if (url == null) {
//                    onError(null);
//                    return;
//                }
//                if (Log.D) {
//                    Log.d("CommonBase", "fun:genToken onEnd() -->> token = " + (String) localObject);
//                    Log.d("CommonBase", "fun:genToken onEnd() -->> url = " + url);
//                }
//                paramURLParamMap.put("tokenKey", (String) localObject);
//                if ((LocManager.b != 0.0D) || (LocManager.c != 0.0D)) {//if-eqz v0, :cond_d
//                    //:cond_4
//                    localObject = new JSONObject();
//                    try {
//                        if (LocManager.b != 0.0D)
//                            ((JSONObject) localObject).put("lat", LocManager.b);
//                        if (LocManager.c != 0.0D)
//                            ((JSONObject) localObject).put("lng", LocManager.c);
//                        if (LocManager.d != 0)
//                            ((JSONObject) localObject).put("provinceId", LocManager.d);
//                        if (LocManager.e != 0)
//                            ((JSONObject) localObject).put("cityId", LocManager.e);
//                        if (LocManager.f != 0)
//                            ((JSONObject) localObject).put("districtId", LocManager.f);
//                        if (LocManager.g != null)
//                            ((JSONObject) localObject).put("provinceName", LocManager.g);
//                        if (LocManager.h != null)
//                            ((JSONObject) localObject).put("cityName", LocManager.h);
//                        if (LocManager.i != null)
//                            ((JSONObject) localObject).put("districtName", LocManager.i);
//                    } catch (JSONException localNumberFormatException) {
//                    }
//                }
//                //:cond_c
//                //:goto_1
//
//                paramURLParamMap.put("lbs", ((JSONObject) localObject).toString());
//                //:cond_d
//                String mergerUrl = HttpGroup.mergerUrlAndParams(url, paramURLParamMap);
//                String str = Configuration.getProperty("mHost");
//                String v0 = null;
//                if (str != null) {//if-eqz v1, :cond_f
//                    if (!TextUtils.isEmpty(str.trim())) {//if-nez v2, :cond_f
//
//                        String[] arrayOfString;
//                        arrayOfString = str.split(":");
//                        //paramHttpResponse = str;
//                        int i = 80;
//                        String host = null;
//                        if (arrayOfString.length > 1) {//if-le v4, v8, :cond_e
//                            host = arrayOfString[0];
//                            try {
//                                i = Integer.parseInt(arrayOfString[1]);
//                            } catch (NumberFormatException localNumberFormatException) {
//
//                            }
//                        }//:cond_e
//                        //:goto_2
//                        try {
//                            v0 = URIUtils.rewriteURI(new URI((String) mergerUrl), new HttpHost(host, i)).toString();
//                        } catch (URISyntaxException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                //:cond_f
//                //:goto_3
//
//                if (Log.D)
//                    Log.d("Temp", "queryBrowserUrl() mergerUrl -->> " + v0);
//                paramaj.onComplete(v0);
//                return;
//
//            }
//        });
//        ((HttpGroup) localObject).add(localHttpSetting);
    }

    public static void queryNewPayBrowserUrl(URLParamMap paramURLParamMap, final _AI paramai) {
        Object localObject = new HttpGroup.HttpGroupSetting();
        ((HttpGroup.HttpGroupSetting) localObject).setType(HttpGroup.HttpGroupSetting.TYPE_JSON);
        ((HttpGroup.HttpGroupSetting) localObject).setMyActivity(BaseApplication.getInstance().getCurrentMyActivity());
        localObject = HttpGroup.getHttpGroup((HttpGroup.HttpGroupSetting) localObject);
        final String str1 = getPayAppID("PAY_APPID");
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setNotifyUser(true);
        localHttpSetting.setFunctionId("genAppPayId");
        String str2 = paramURLParamMap.get("orderId");
        localHttpSetting.putJsonParam("appId", str1);
        localHttpSetting.putJsonParam("orderId", str2);
        String str3 = paramURLParamMap.get("payablePrice");
        localHttpSetting.putJsonParam("payablePrice", str3);
        localHttpSetting.putJsonParam("orderTypeCode", paramURLParamMap.get("orderTypeCode"));
        String str4 = paramURLParamMap.get("orderType");
        localHttpSetting.putJsonParam("orderType", str4);
        str2 = PayMD5Util.a(str1 + ";" + str2 + ";" + str4 + ";" + str3 + ";" + getPayAppKey(), "GBK");
        localHttpSetting.putJsonParam("back_url", paramURLParamMap.get("back_url"));
        localHttpSetting.putJsonParam("paysign", str2);
        localHttpSetting.setUrl(Configuration.getPayUrl());
        localHttpSetting.setListener(new HttpGroup.OnCommonListener() {//ad(paramai, str1)
            @Override
            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {

            }

            @Override
            public void onError(HttpGroup.HttpError paramHttpError) {
                if (paramai != null)
                    paramai.onError(paramHttpError);
            }

            @Override
            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                Object localObject = paramHttpResponse.getJSONObject();
                if (!"0".equals(((JSONObjectProxy) localObject).getStringOrNull("code")))//if-nez v1, :cond_1
                    paramai.onError(null);
                else {
                    //:cond_1
                    String payId = ((JSONObjectProxy) localObject).getStringOrNull("payId");
                    String str = ((JSONObjectProxy) localObject).getStringOrNull("url");

                    if (!(TextUtils.isEmpty(payId)) && !(TextUtils.isEmpty(str))) {
                        localObject = new URLParamMap();
                        ((URLParamMap) localObject).put("payId", payId);
                        ((URLParamMap) localObject).put("appId", str1);
                        try {
                            String str1 = URLDecoder.decode(str, "GBK");
                            String urlAndParams = HttpGroup.mergerUrlAndParams(str1, (Map) localObject);
                            if (Log.I)
                                Log.i("CommonBase", "queryNewPayBrowserUrl-->> mergerUrl:" + urlAndParams);
                            paramai.onComplete(urlAndParams);
                            return;
                        } catch (UnsupportedEncodingException e) {
                            if (Log.I)
                                e.printStackTrace();
                        }
                    }

                }
                return;
            }
        });
        ((HttpGroup) localObject).add(localHttpSetting);
    }

    public static void queryNewPayBrowserUrl(JSONObject paramJSONObject, final _AI paramai)
            throws JSONException {
        Object localObject = new HttpGroup.HttpGroupSetting();
        ((HttpGroup.HttpGroupSetting) localObject).setType(HttpGroup.HttpGroupSetting.TYPE_JSON);
        ((HttpGroup.HttpGroupSetting) localObject).setMyActivity(BaseApplication.getInstance().getCurrentMyActivity());
        localObject = HttpGroup.getHttpGroup((HttpGroup.HttpGroupSetting) localObject);
        final String str1 = getPayAppID("pay_appid");
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setNotifyUser(true);
        localHttpSetting.setFunctionId("genAppPayId");
        String str2 = paramJSONObject.optString("orderId");
        String str3 = paramJSONObject.optString("payablePrice");
        String str4 = paramJSONObject.optString("orderType");
        paramJSONObject.put("paysign", PayMD5Util.a(str1 + ";" + str2 + ";" + str4 + ";" + str3 + ";" + getPayAppKey(), "GBK"));
        paramJSONObject.put("appId", str1);
        localHttpSetting.setJsonParams(paramJSONObject);
        localHttpSetting.setUrl(Configuration.getPayUrl());
        localHttpSetting.setListener(new HttpGroup.OnCommonListener() {//ae(paramai, str1)
            @Override
            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {

            }

            @Override
            public void onError(HttpGroup.HttpError paramHttpError) {
                if (paramai != null)
                    paramai.onError(paramHttpError);
            }

            @Override
            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                Object localObject = paramHttpResponse.getJSONObject();
                if (!"0".equals(((JSONObjectProxy) localObject).getStringOrNull("code")))//if-nez v1, :cond_1
                    paramai.onError(null);
                else {
                    //:cond_1
                    String payId = ((JSONObjectProxy) localObject).getStringOrNull("payId");
                    String str = ((JSONObjectProxy) localObject).getStringOrNull("url");

                    if ((!TextUtils.isEmpty(payId)) && (!TextUtils.isEmpty(str))) {
                        localObject = new URLParamMap();
                        ((URLParamMap) localObject).put("payId", payId);
                        ((URLParamMap) localObject).put("appId", str1);
                        try {
                            String str1 = URLDecoder.decode(str, "GBK");
                            String urlAndParams = HttpGroup.mergerUrlAndParams(str1, (Map) localObject);
                            if (Log.I)
                                Log.i("CommonBase", "queryNewPayBrowserUrl-->> mergerUrl:" + urlAndParams);
                            paramai.onComplete(urlAndParams);
                            return;
                        } catch (UnsupportedEncodingException e) {
                            if (Log.I)
                                e.printStackTrace();
                        }
                    }

                }
                return;
            }
        });
        ((HttpGroup) localObject).add(localHttpSetting);
    }

    public static void removeTriggerAtTime()
    {
        getJdSharedPreferences().edit().remove("reActivationTriggerAtTime").commit();
    }

    public static void saveThirdAddressIds(String paramString)
    {
        if (Log.D)
            Log.d("CommonBase", "thirdAddressIds = " + paramString);
        getJdSharedPreferences().edit().putString("globalThirdAddressIds", paramString).commit();
    }

    public static void saveThirdAddressNames(String paramString)
    {
        if (Log.D)
            Log.d("CommonBase", "thirdAddressNames = " + paramString);
        getJdSharedPreferences().edit().putString("globalThirdAddressNames", paramString).commit();
    }

    public static void setCityIDToSharedPreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("globalCityID", paramString).commit();
    }

    public static void setCityNameToSharedPreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("globalCityName", paramString).commit();
    }

    public static void setDistrictIdToSharedPreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("globalDistrictID", paramString).commit();
    }

    public static void setFavoPriceLowerTip(String paramString)
    {
        getJdSharedPreferences().edit().putString("favo_price_notify_tip", paramString).commit();
    }

    public static void setFavoProductSortRecord(int paramInt)
    {
        getJdSharedPreferences().edit().putInt("favo_product_sort_record", paramInt).commit();
    }

    public static boolean setHasShowFilterGuide(boolean paramBoolean)
    {
        try
        {
            paramBoolean = getJdSharedPreferences().edit().putBoolean("guide_search_filter", paramBoolean).commit();
            return paramBoolean;
        }
        catch (Exception e)
        {
        }
        return false;
    }

    public static boolean setHasShowGuide(String paramString, boolean paramBoolean)
    {
        try
        {
            paramBoolean = getJdSharedPreferences().edit().putBoolean(paramString, paramBoolean).commit();
            return paramBoolean;
        }
        catch (Exception e)
        {
        }
        return false;
    }

    public static boolean setHasShowSearchFavGuide(boolean paramBoolean)
    {
        try
        {
            paramBoolean = getJdSharedPreferences().edit().putBoolean("search_result_fav_guide", paramBoolean).commit();
            return paramBoolean;
        }
        catch (Exception e)
        {
        }
        return false;
    }

    public static void setHomeActivityStoppedPeriod(long paramLong)
    {
        try
        {
            getJdSharedPreferences().edit().putLong("homeActivityStoppedTime", paramLong).commit();
        }
        catch (Exception e)
        {
            if (Log.D)
            e.printStackTrace();
        }
    }

    public static void setIsGuided(String paramString)
    {
        if (!TextUtils.isEmpty(paramString)) {
            StringBuilder sb = new StringBuilder(getJdSharedPreferences().getString("guide_activity", "")).append("|").append(paramString);
            getJdSharedPreferences().edit().putString("guide_activity", sb.toString()).commit();
        }
    }

    public static void setIsJustShowHaveProduct(boolean paramBoolean)
    {
        getJdSharedPreferences().edit().putBoolean("justshowhaveproduct", paramBoolean).commit();
    }

    public static void setJdFaxianNewFlag(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("jdFaxianNewFlag", paramBoolean).commit();
        }
        catch (Exception localException)
        {
        }
    }

    public static void setJdStoryNewFlag(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("jdStoryNewFlag", paramBoolean).commit();
        }
        catch (Exception localException)
        {
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView paramListView)
    {
        ListAdapter localListAdapter = paramListView.getAdapter();
        if (localListAdapter == null)
            return;
        int i = 0;
        int j = 0;
        while (i < localListAdapter.getCount())
        {
            View localObject = localListAdapter.getView(i, null, paramListView);
            ((View)localObject).measure(0, 0);
            j += ((View)localObject).getMeasuredHeight();
            i += 1;
        }
        ViewGroup.LayoutParams layoutParams = paramListView.getLayoutParams();
        layoutParams.height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
        paramListView.setLayoutParams(layoutParams);
    }

    public static void setMiaoShaCountTime(long paramLong)
    {
        try
        {
            getJdSharedPreferences().edit().putLong("miaosha_count_time", paramLong).commit();
        }
        catch (Exception e)
        {
            if (Log.D)
            e.printStackTrace();
        }
    }

    public static void setMiaoShaLeaveTime(long paramLong)
    {
        try
        {
            getJdSharedPreferences().edit().putLong("miaosha_leave_time", paramLong).commit();
        }
        catch (Exception e)
        {
            if (Log.D)
                e.printStackTrace();
        }
    }

    public static void setMyStreetNew(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("MyJD_MyStreet_new", paramBoolean).commit();
        }
        catch (Exception e)
        {
            if (Log.D)
                e.printStackTrace();
        }
    }

    public static void setOrderDetaliGuideImageLoaded(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("orderDetailGuideImage", paramBoolean).commit();
        }
        catch (Exception e)
        {
            if (Log.D)
                e.printStackTrace();
        }
    }

    public static void setOrderTraceGuideImageLoaded(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("orderTraceGuideImage", paramBoolean).commit();
        }
        catch (Exception e)
        {
            if (Log.D)
                e.printStackTrace();
        }
    }

    public static void setPlugCenterFlag(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("plugCenterFlag", paramBoolean).commit();
        }
        catch (Exception localException)
        {
        }
    }

    public static void setPlugCenterInited(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("plugCenterInited", paramBoolean).commit();
        }
        catch (Exception localException)
        {
        }
    }

    public static void setPlugCenterRequestTime(long paramLong)
    {
        try
        {
            getJdSharedPreferences().edit().putLong("plugCenterRequestTime", paramLong).commit();
        }
        catch (Exception localException)
        {
        }
    }

    public static void setPlugOn(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("plug_on_off", paramBoolean).commit();
        }
        catch (Exception localException)
        {
            if (Log.D)
            Log.d("CommonBase", "data存储空间不足啦！！ 连SharedPreference里都存不进去 ！！！！！");
        }
    }

    public static void setPlugPersonelNew(boolean paramBoolean)
    {
        try
        {
            getJdSharedPreferences().edit().putBoolean("plugPersonelNew", paramBoolean).commit();
        }
        catch (Exception localException)
        {
            if (Log.D)
            Log.d("CommonBase", "data存储空间不足啦！！ 连SharedPreference里都存不进去 ！！！！！");
        }
    }

    public static void setPlugRequestPeriod(long paramLong)
    {
        try
        {
            getJdSharedPreferences().edit().putLong("plugrequestperiod", paramLong).commit();
        }
        catch (Exception localException)
        {
        }
    }

    public static void setPlugRequestTime(long paramLong)
    {
        try
        {
            getJdSharedPreferences().edit().putLong("plugrequesttime", paramLong).commit();
        }
        catch (Exception localException)
        {
        }
    }

    public static void setProvinceIDToSharedPreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("globalProvinceID", paramString).commit();
    }

    public static void setProvinceNameToSharedPreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("provinceName", paramString).commit();
    }

    public static void setRegionNamePreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("regionName", paramString).commit();
    }

    public static void setRegionSharedPreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("region", paramString).commit();
    }

    public static void setRememberStateSharedPreferences(Boolean paramBoolean)
    {
        getJdSharedPreferences().edit().putBoolean("rememberRegion", paramBoolean.booleanValue()).commit();
    }

    public static void setSelectedOrderSharedPreferences(int paramInt)
    {
        getJdSharedPreferences().edit().putInt("selectOrder", paramInt).commit();
    }

    public static void setShakeShareText(String paramString1, String paramString2)
    {
        getJdSharedPreferences().edit().putString(paramString1, paramString2).commit();
    }

    public static void setShakeSwitchSkinState(String paramString)
    {
        if (TextUtils.isEmpty(paramString))
            return;
        StringBuilder sb = new StringBuilder(getJdSharedPreferences().getString("shake_switch_skin", "")).append("|").append(paramString);
        getJdSharedPreferences().edit().putString("shake_switch_skin", sb.toString()).commit();
    }

    public static void setTownIdToSharedPreferences(String paramString)
    {
        getJdSharedPreferences().edit().putString("globalTownID", paramString).commit();
    }

    public static void startActivity(Context paramContext, Class<?> paramClass)
    {
    }

    public static boolean startCheck(String paramString1, String paramString2)
    {
        return Pattern.compile(paramString1).matcher(paramString2).matches();
    }

    public static double string2Double(String paramString)
    {
        if (!TextUtils.isEmpty(paramString)) {
            try {
                return Double.parseDouble(paramString);
            } catch (Exception e) {
            }
        }
        return 0.0D;
    }

    public static JSONArray string2JSONArray(String paramString)
    {
        if (!TextUtils.isEmpty(paramString))
            try
            {
                return new JSONArray(paramString);
            }
            catch (Exception localException)
            {
                if (Log.D)
                localException.printStackTrace();
                return new JSONArray();
            }
        return new JSONArray();
    }

    public static JSONObject string2JSONObject(String paramString)
    {
        if (!TextUtils.isEmpty(paramString))
            try
            {
                return new JSONObject(paramString);
            }
            catch (Exception localException)
            {
                JSONObject localJSONObject;
                if (Log.D)
                localException.printStackTrace();
                return new JSONObject();
            }
        return new JSONObject();
    }

    public static long string2Long(String paramString) {
        if (!TextUtils.isEmpty(paramString))
            try {
                return Long.parseLong(paramString);
            } catch (Exception e) {
            }
        return 0L;
    }

    public static void toBrowser(Uri paramUri)
    {
        Intent localIntent = newBrowserIntent(paramUri, true);
        try
        {
            if (isIntentAvailable(localIntent))
                BaseApplication.getInstance().getCurrentMyActivity().startActivityNoException(localIntent);
            else
                BaseApplication.getInstance().getCurrentMyActivity().startActivityNoException(newBrowserIntent(paramUri, false));
        }
        catch (Throwable e)
        {
            if (Log.E)
                e.printStackTrace();
        }
    }

    public static void toBrowser(String paramString, URLParamMap paramURLParamMap)
    {
        queryBrowserUrl(paramString, paramURLParamMap, new _AJ(){//ac()
            @Override
            public void onComplete(String paramString) {
                CommonBase.toBrowser(Uri.parse(paramString));
            }
        });
    }

    public boolean MainIsRun()
    {
        return BaseApplication.getInstance().getMainFrameActivity() != null;
    }

    public LayoutInflater getLayoutInflater()
    {
        return LayoutInflater.from(BaseApplication.getInstance());
    }

    public String getLocalIpAddress() {
        try {
            Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
            //:cond_0
            while (enumeration.hasMoreElements()) {//if-eqz v0, :cond_2
                Enumeration localEnumeration = ((NetworkInterface) ((Enumeration) enumeration).nextElement()).getInetAddresses();
                //:cond_1
                while (localEnumeration.hasMoreElements()) {//if-eqz v0, :cond_0
                    InetAddress localInetAddress = (InetAddress) localEnumeration.nextElement();
                    if (localInetAddress.isLoopbackAddress()) {//if-nez v3, :cond_1
                        return localInetAddress.getHostAddress().toString();
                    }
                }
            }

        } catch (SocketException localSocketException) {
            if (Log.V)
                Log.v("WifiPreference IpAddress", localSocketException.toString());
        }
        return null;
    }

    public IMainActivity goToMainFrameActivity(Context paramContext, Class<?> paramClass)
    {
        Intent intent = new Intent(paramContext, paramClass);
        IMainActivity localc = BaseApplication.getInstance().getMainFrameActivity();
        if (localc == null)
        {
            if (Log.D)
                Log.d("CommonBase", "Commutils goToMainFrameActivity() -->> not run");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            paramContext.startActivity(intent);
        }else{
            if (Log.D)
                Log.d("CommonBase", "Commutils goToMainFrameActivity() -->> run");
            if (localc.l()) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                paramContext.startActivity(intent);
            }
        }
        return localc;
    }

    public boolean isCanClick()
    {
        return NetUtils.isNetworkAvailable();
    }

    public void putSelectedCatsStr(String paramString)
    {
        getJdSharedPreferences().edit().putString("color_buy_selected_categories", paramString).commit();
    }
    public abstract interface _AH extends _AI
    {
        public abstract void onReady();
    }

    public abstract interface _AI extends _AJ
    {
        public abstract void onError(HttpGroup.HttpError paramHttpError);
    }

    public abstract interface _AJ
    {
        public abstract void onComplete(String paramString);
    }

    public abstract interface _AK
    {
        public abstract void a(String paramString);
    }

}
