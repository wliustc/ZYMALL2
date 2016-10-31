package com.jingdong.common.utils;

import android.app.Activity;

import com.zy.common.utils.CommonUtil;

/**
 * Created by robin on 16-10-31.
 */
//el
public class NightModeUtil {
    public static void a(Activity paramActivity)
    {
        float f = -1.0F;
        if (CommonUtil.getBooleanFromPreference("nightModeSwitch", Boolean.valueOf(false)).booleanValue() == true)
            f = CommonUtil.getJdSharedPreferences().getFloat("nightModeAlpha", -1.0F);
        Activity localActivity2 = paramActivity.getParent();
        Activity localActivity1 = paramActivity;
        for (paramActivity = localActivity2; paramActivity != null; paramActivity = localActivity2)
        {
            localActivity2 = paramActivity.getParent();
            localActivity1 = paramActivity;
        }
        paramActivity = localActivity1.getWindow().getAttributes();
        paramActivity.screenBrightness = f;
        localActivity1.getWindow().setAttributes(paramActivity);
    }

    public static void a(Activity paramActivity, float paramFloat, boolean paramBoolean)
    {
        if ((CommonUtil.getBooleanFromPreference("nightModeSwitch", Boolean.valueOf(false)).booleanValue()) || (paramBoolean))
        {
            Activity localActivity2 = paramActivity.getParent();
            Activity localActivity1 = paramActivity;
            for (paramActivity = localActivity2; paramActivity != null; paramActivity = localActivity2)
            {
                localActivity2 = paramActivity.getParent();
                localActivity1 = paramActivity;
            }
            paramActivity = localActivity1.getWindow().getAttributes();
            paramActivity.screenBrightness = paramFloat;
            localActivity1.getWindow().setAttributes(paramActivity);
        }
    }
}
