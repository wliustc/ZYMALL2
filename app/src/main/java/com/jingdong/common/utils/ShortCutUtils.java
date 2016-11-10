package com.jingdong.common.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;

import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/11/10.
 */
//fp
public class ShortCutUtils {
    public static void a(Activity paramActivity)
    {
        Object localObject2 = CommonUtil.getJdSharedPreferences();
        Object localObject1 = paramActivity.getPackageName();
        String str1 = paramActivity.getLocalClassName();
        a(paramActivity, (String)localObject1, null, false, 2);
        a(paramActivity, (String)localObject1, null, false, 1);
        ((SharedPreferences)localObject2).edit().putBoolean("add_short_cut_flag_500", true).commit();
        try
        {
            localObject2 = new Intent();
            Object localObject3 = paramActivity.getPackageManager();
            try
            {
                ApplicationInfo localApplicationInfo = ((PackageManager)localObject3).getApplicationInfo((String)localObject1, 8320);
                String str2 = ((PackageManager)localObject3).getApplicationLabel(localApplicationInfo).toString();
                localObject3 = (BitmapDrawable)((PackageManager)localObject3).getApplicationIcon(localApplicationInfo);
                ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", str2);
                ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON", ((BitmapDrawable)localObject3).getBitmap());
                localObject1 = new ComponentName((String)localObject1, str1);
                ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", new Intent("android.intent.action.MAIN").setComponent((ComponentName)localObject1));
                paramActivity.setResult(-1, (Intent)localObject2);
                return;
            }
            catch (PackageManager.NameNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            if (Log.E)
                e.printStackTrace();
        }
    }

    private static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
    {
        paramString2 = new Intent("android.intent.action.MAIN");
        paramString2.setClassName(paramActivity, paramString1 + ".MainActivity");
        paramString2.addCategory("android.intent.category.LAUNCHER");
        paramString2.addFlags(268435456);
        paramString2.addFlags(2097152);
        Object localObject = paramActivity.getPackageManager();
        while (true)
        {
            try
            {
                paramString1 = ((PackageManager)localObject).getApplicationInfo(paramString1, 8320);
                localObject = ((PackageManager)localObject).getApplicationLabel(paramString1).toString();
                int i = paramString1.icon;
                paramString1 = new Intent();
                paramString1.putExtra("android.intent.extra.shortcut.INTENT", paramString2);
                paramString1.putExtra("android.intent.extra.shortcut.NAME", (String)localObject);
                paramString1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramActivity, i));
                paramString1.putExtra("duplicate", false);
                switch (paramInt)
                {
                    default:
                        paramActivity.sendBroadcast(paramString1);
                        return;
                    case 1:
                    case 2:
                }
            }
            catch (PackageManager.NameNotFoundException paramActivity)
            {
                paramActivity.printStackTrace();
                return;
            }
            paramString1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            continue;
            paramString1.putExtra("android.intent.extra.shortcut.NAME", "京东");
            paramString1.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        }
    }
}
