package com.jingdong.common.reactnative.download;

import android.content.Context;
import android.os.Build;

import com.zy.app.mall.utils.MyActivity;
import com.zy.common.utils.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 2016/11/7.
 */
public class ReactNativeUpdate {
    private static final String TAG = "ReactNativeUpdate";
    private static ReactNativeUpdate helper = null;
    private Map<String, String> hashPluginLists = new HashMap();
    private Context mContext;

    private ReactNativeUpdate(Context paramContext)
    {
        this.mContext = paramContext;
    }

    private void check(long paramLong)
    {
        if (!ReactSharedPreferenceUtils.getLastCheckCompleteFlag())
        {
            this.hashPluginLists = getReactNativeConfig();
            if ((this.hashPluginLists == null) || ((this.hashPluginLists != null) && (this.hashPluginLists.size() == 0)))
                Log.d("ReactNativeUpdate", "Plugin list is null, just do nothing and return, you should check about it");
        }
        long l1;
        long l2;
        do
        {
            return;
            ReactSharedPreferenceUtils.putLastCheckCompleteFlag(true);
            Log.d("ReactNativeUpdate", "Send check request for LastCheckComplete is false");
            ReactNativeUpdateRequest.getInstance(this.mContext).sendReactUpdateRequest(this.hashPluginLists);
            ReactSharedPreferenceUtils.putLastCheckTime();
            return;
            l1 = new Date().getTime();
            l2 = ReactSharedPreferenceUtils.getLastCheckTime();
            if (l1 - l2 <= paramLong)
                continue;
            this.hashPluginLists = getReactNativeConfig();
            if ((this.hashPluginLists == null) || ((this.hashPluginLists != null) && (this.hashPluginLists.size() == 0)))
            {
                Log.d("ReactNativeUpdate", "Plugin list is null, just do nothing and return, you should check about it");
                return;
            }
            Log.d("ReactNativeUpdate", "Reach 1h threshold, Send check request");
            ReactNativeUpdateRequest.getInstance(this.mContext).sendReactUpdateRequest(this.hashPluginLists);
            ReactSharedPreferenceUtils.putLastCheckTime();
            return;
        }
        while (l1 - l2 >= 0L);
        this.hashPluginLists = getReactNativeConfig();
        if ((this.hashPluginLists == null) || ((this.hashPluginLists != null) && (this.hashPluginLists.size() == 0)))
        {
            Log.d("ReactNativeUpdate", "Plugin list is null, just do nothing and return, you should check about it");
            return;
        }
        Log.d("ReactNativeUpdate", "Time illegally modified! Send check request");
        ReactNativeUpdateRequest.getInstance(this.mContext).sendReactUpdateRequest(this.hashPluginLists);
        ReactSharedPreferenceUtils.putLastCheckTime();
    }

    private void checkModuleAvailability(long paramLong)
    {
        if (Build.VERSION.SDK_INT >= 16);
        for (boolean bool = true; ; bool = false)
        {
            long l1 = new Date().getTime();
            long l2 = ReactModuleAvailabilityUtils.getLastCheckAvailabilityTime();
            if ((!ReactModuleAvailabilityUtils.getLastAvailabilityResult()) || (l1 - l2 > paramLong))
            {
                ReactModuleAvailabilityUtils.saveLastCheckAvailabilityTime();
                ReactMetadataValidator.getReactMetaData((MyActivity)this.mContext, new ReactNativeUpdate.1(this, bool));
            }
            return;
        }
    }

    public static ReactNativeUpdate getInstance(Context paramContext)
    {
        if (helper != null)
            return helper;
        monitorenter;
        try
        {
            paramContext = new ReactNativeUpdate(paramContext);
            helper = paramContext;
            return paramContext;
        }
        finally
        {
            monitorexit;
        }
        throw paramContext;
    }

    public void checkUpdate()
    {
        check(3600000L);
        try
        {
            Class.forName("com.facebook.react.ReactInstanceManager");
            checkModuleAvailability(600000L);
            return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
            ReactModuleAvailabilityUtils.saveModuleAvailability("RankList", false);
            ReactModuleAvailabilityUtils.saveModuleAvailability("MovieHomePage", false);
            ReactModuleAvailabilityUtils.saveModuleAvailability("PaySuccess", false);
        }
    }

    public Map<String, String> getReactNativeConfig()
    {
        return ReactVersionUtils.getMergedPluginVersionLists();
    }
}
