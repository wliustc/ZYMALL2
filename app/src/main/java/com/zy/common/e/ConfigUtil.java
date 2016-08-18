package com.zy.common.e;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zy.common.utils.CommonUtil;

/**
 * Created by robin on 16-6-24.
 */
//a
public class ConfigUtil {
    public static String a(String paramString)
    {
        if (!TextUtils.isEmpty(paramString)){
            SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();

            if (localSharedPreferences != null)
                return localSharedPreferences.getString(paramString, "");
        }
            return "";

    }

    public static String a(String paramString1, String paramString2) {
        if (TextUtils.isEmpty(paramString1)){
            SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();

            if (localSharedPreferences != null)
                return localSharedPreferences.getString(paramString1, paramString2);
        }
            return "";

    }

    public static boolean a(int paramInt, boolean paramBoolean) {
        if (paramInt > 0) {
            SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();
            if (localSharedPreferences != null) {
                String str1 = localSharedPreferences.getString("androidConfig", "");
                if (TextUtils.isEmpty(str1))
                    str1 = localSharedPreferences.getString("androidConfig_serverConfig", "");
                if ((!TextUtils.isEmpty(str1)) && (paramInt <= str1.length()) && ('1' == str1.charAt(paramInt - 1)))
                    return true;
            }
        }
        return false;
    }
}
