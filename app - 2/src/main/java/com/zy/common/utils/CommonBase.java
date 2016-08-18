package com.zy.common.utils;

import android.content.SharedPreferences;

import com.zy.common.BaseApplication;

/**
 * Created by Robin on 2016/4/19.
 */
public abstract class CommonBase implements ICommon{
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

    public static long getLongFromPreference(String key, int i) {
        return getJdSharedPreferences().getLong(key, i);
    }

    public static boolean putBooleanToPreference(String key, Boolean paramBoolean)
    {
        return getJdSharedPreferences().edit().putBoolean(key, paramBoolean.booleanValue()).commit();
    }

    public static boolean putIntToPreference(String key, int paramInt)
    {
        return getJdSharedPreferences().edit().putInt(key, paramInt).commit();
    }

    public static boolean putLongToPreference(String key, long paramLong)
    {
        return getJdSharedPreferences().edit().putLong(key, paramLong).commit();
    }

    public static boolean putStringToPreference(String key, String paramString2)
    {
        return getJdSharedPreferences().edit().putString(key, paramString2).commit();
    }

    public static SharedPreferences getJdSharedPreferences() {
        if (sharedPreferences == null) {
            synchronized (CommonBase.class) {
                if (sharedPreferences == null) {
                    if (Log.D)
                        Log.d("CommonUtil", " -->> sharedPreferences:" + sharedPreferences);
                    sharedPreferences = BaseApplication.getInstance().getSharedPreferences("AndroidClient", 0);
                }
            }

        }
        return sharedPreferences;
    }
}
