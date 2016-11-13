package com.jingdong.app.mall.utils;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.login.SafetyManager;
import com.jingdong.common.ui.JDToast;
import com.jingdong.common.utils.GlobalInitialization;
import com.jingdong.common.utils.HttpGroup;
import com.zy.common.frame.IMyActivity;
import com.zy.common.res.StringUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;
import com.zy.common.utils.NetUtils;
import com.zy.jdma.common.secure.DesUtil;

import java.util.Arrays;
import java.util.Timer;

/**
 * Created by Robin on 2016/11/11.
 */
public class UpdateInitialization {
    private static final String TAG = "JDGlobalInit";
    private static final int UPDATE_COUPON = 10;
    private static GlobalInitialization globalInitialization;
    private static UpdateInitialization updateInitialization;
//    public com.jingdong.common.utils.bx mIDialogShow;

    private void autoCheckSVersion()
    {
        //TODO: 未实现
//        HttpGroup.HttpSetting localHttpSetting = requestVersionAuto(new by(this));
//        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private boolean canDoVersion()
    {
        String str = CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance());
        long l1 = CommonUtil.getJdSharedPreferences().getLong(str + "keyLastUpdate", -1L);
        int i = CommonUtil.getJdSharedPreferences().getInt(str + "keyUpdateInterval", -1);
        if ((l1 != -1L) && (i != -1)){
            long l2 = System.currentTimeMillis();
            if (Log.D) {
                Log.d("JDGlobalInit", "FunctionAccessUtil lastAccess-->> " + l1);
                Log.d("JDGlobalInit", "FunctionAccessUtil interval-->> " + i);
                Log.d("JDGlobalInit", "FunctionAccessUtil now-->> " + l2);
            }
            if (l1 + i * 3600000L > l2)
                return false;
        }
        return true;
    }

    private boolean canShowUpdate()
    {
        String str = CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance());
        int i = CommonUtil.getJdSharedPreferences().getInt(str + "keyLastShowNum", 0);
        int j = CommonUtil.getJdSharedPreferences().getInt(str + "keyLastShowLimit", -1);
        if (j != -1 && i >= j){
                return false;
        }
        return true;

    }

    private boolean checkAPK(String paramString)
    {
        //TODO:未实现
        return false;
//        if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
//        {
//            paramString = DesUtil.decrypt(paramString, "e1Ck6jlK");
//            if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
//            {
//                paramString = Arrays.asList(paramString.split(","));
//                if ((paramString != null) && (!paramString.isEmpty()))
//                {
//                    paramString = paramString.iterator();
//                    while (paramString.hasNext())
//                    {
//                        String str = (String)paramString.next();
//                        if (r.a().a(str))
//                            return true;
//                    }
//                }
//            }
//        }
//        return false;
    }

    private void checkSoftwareUpdated(boolean paramBoolean, IMyActivity paramIMyActivity)
    {
        //TODO: 未实现
//        if (Log.D)
//            Log.d("JDGlobalInit", "GlobalInitialization checkSoftwareUpdated() BEING-->> ");
//        if ((!Configuration.getBooleanProperty("applicationUpgrade").booleanValue()) && (paramBoolean))
//            return;
//        Object localObject = new bx(this, paramIMyActivity, paramBoolean);
//        HttpGroup.HttpSetting localHttpSetting = requestVersionAuto((HttpGroup.OnAllListener)localObject);
//        if (!paramBoolean)
//        {
//            localHttpSetting = requestVersionHand(true, (HttpGroup.OnAllListener)localObject);
//            localObject = paramIMyActivity;
//            if (paramIMyActivity == null)
//                localObject = BaseApplication.getInstance().getCurrentMyActivity();
//            ((IMyActivity)localObject).getHttpGroupaAsynPool().add(localHttpSetting);
//            return;
//        }
//        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private void cleanCache()
    {
        setCouponCache("", "", -1);
    }

    public static synchronized UpdateInitialization getUpdateInitializationInstance()
    {
            if (updateInitialization == null)
            {
                updateInitialization = new UpdateInitialization();
                globalInitialization = GlobalInitialization.getGlobalInitializationInstance();
            }
            UpdateInitialization localUpdateInitialization = updateInitialization;
            return localUpdateInitialization;
    }

    private void handCheckSVersion()
    {
        //TODO: 未实现
//        HttpGroup.HttpSetting localHttpSetting = requestVersionHand(true, new bz(this));
//        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private boolean initLogin()
    {
        //TODO: 未实现
        return false;
//        try
//        {
//            String str1 = SafetyManager.getCookies();
//            String str2 = SafetyManager.getUserInfo();
//            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
//            {
//                HttpGroup.setCookies(str1);
//                HttpGroupAdapter.setCookies(str1);
//            }
//            return true;
//        }
//        catch (Exception localException)
//        {
//            if (Log.E)
//                localException.printStackTrace();
//        }
//        return false;
    }

    private boolean isFileAvailable(String paramString)
    {
        //TODO: 未实现
        return false;
//        String str = CommonUtil.getStringFromPreference("jd_app_install_file", "");
//        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)) || (!str.contains(paramString)) || (!bp.b(str)))
//            if (Log.D)
//                Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileExist  -->> false");
//        do
//        {
//            do
//                while (true)
//                {
//                    return false;
//                    if (CommonUtil.getBooleanFromPreference("jd_app_update_failed", Boolean.valueOf(false)).booleanValue())
//                        continue;
//                    if (Log.D)
//                        Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  start -->> ");
//                    try
//                    {
//                        if (Log.D)
//                            Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  loading -->> ");
//                        paramString = p.a(paramString);
//                        str = ApplicationUpgradeHelper.getFileMD5(new File(str));
//                        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)))
//                            continue;
//                        if (Log.D)
//                        {
//                            Log.d("JDGlobalInit", "oldMd5-->> " + paramString);
//                            Log.d("JDGlobalInit", "newMd5-->> " + str);
//                        }
//                        if (TextUtils.equals(paramString, str))
//                            return true;
//                        if (!Log.D)
//                            continue;
//                        Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  end -->> ");
//                        return false;
//                    }
//                    catch (Exception paramString)
//                    {
//                    }
//                }
//            while (!Log.D);
//            paramString.printStackTrace();
//        }
//        while (!Log.D);
//        Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  Exception -->> ");
//        return false;
    }

    private synchronized void networkInitialization()
    {
            if (Log.D)
                Log.d("JDGlobalInit", "GlobalInitialization networkInitialization() -->> ");
            BaseApplication localBaseApplication = BaseApplication.getInstance();
            if (Log.D)
                Log.d("JDGlobalInit", "GlobalInitialization myApplication.networkInitializationState -->> " + localBaseApplication.networkInitializationState);
            if (localBaseApplication.networkInitializationState == 0)
            {
                localBaseApplication.networkInitializationState = 1;
                globalInitialization.alreadyDevice = false;
                globalInitialization.alreadyConfig = false;
                networkInitializationStart();
                if ((globalInitialization.alreadyDevice) && (globalInitialization.alreadyConfig))
                    localBaseApplication.networkInitializationState = 2;
            }
            return;
    }

    private void networkInitializationStart()
    {
        //TODO:未实现
//        if (Log.D)
//            Log.d("JDGlobalInit", "GlobalInitialization networkInitializationStart() -->> ");
//        if (GlobalInitialization.canDoDevice())
//        {
//            if (Log.D)
//                Log.d("JDGlobalInit", "ready to do device CMD-->> ");
//            globalInitialization.registerDevice(GlobalInitialization.isDeviceFirstCalled());
//        }
//        while (true)
//        {
//            globalInitialization.setTaskBeginFlag(1);
//            globalInitialization.serverConfig(new bu(this));
//            if (GlobalInitialization.canDoABTest())
//            {
//                if (Log.D)
//                    Log.d("JDGlobalInit", "ready to ABTest CMD -->> ");
//                com.jingdong.common.utils.a.a(globalInitialization.getHttpGroup());
//            }
//            new Timer().schedule(new bv(this), Configuration.getIntegerProperty("routineCheckDelayTime").intValue());
//            return;
//            globalInitialization.alreadyDevice = true;
//        }
    }

    private void newFeatureWizard()
    {
        //TODO:未实现
//        if (Log.D)
//            Log.d("JDGlobalInit", "GlobalInitialization serverConfig() BEGIN-->> ");
//        cc localcc = new cc(this);
//        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
//        localHttpSetting.setFunctionId("newFeatureWizard");
//        localHttpSetting.setHost(Configuration.getNgwHost());
//        localHttpSetting.setEffect(0);
//        localHttpSetting.setNotifyUser(false);
//        localHttpSetting.setNeedGlobalInitialization(false);
//        localHttpSetting.setTopPriority(true);
//        localHttpSetting.setListener(localcc);
//        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private HttpGroup.HttpSetting requestVersionAuto(HttpGroup.OnAllListener paramOnAllListener)
    {
        //TODO:未实现
        return null;
//        return bn.a(paramOnAllListener);
    }

    private HttpGroup.HttpSetting requestVersionHand(boolean paramBoolean, HttpGroup.OnAllListener paramOnAllListener)
    {
        //TODO:未实现
        return null;
//        paramOnAllListener = bn.a(paramOnAllListener);
//        paramOnAllListener.setNotifyUser(true);
//        if (paramBoolean)
//        {
//            paramOnAllListener.setEffect(1);
//            return paramOnAllListener;
//        }
//        paramOnAllListener.setEffect(0);
//        return paramOnAllListener;
    }

    private void sendCommonData()
    {
        JDMtaUtils.sendCommonData(BaseApplication.getInstance(), "Startup_CacheDownload", "", "", "", "", UpdateInitialization.class, "");
    }

    private void setCouponCache(String paramString1, String paramString2, int paramInt)
    {
        CommonUtil.putStringToPreference("app_url", paramString1);
        CommonUtil.putStringToPreference("app_version", paramString2);
        CommonUtil.putIntToPreference("app_apksize", paramInt);
    }

    private void showNoUpdate(IMyActivity paramIMyActivity)
    {
        paramIMyActivity.post(new Runnable(){//cb(this)
            @Override
            public void run() {
                JDToast localJDToast = new JDToast(BaseApplication.getInstance(), 2);
                localJDToast.setText(StringUtil.alert_message_no_update);
                localJDToast.setDuration(Toast.LENGTH_SHORT);
                localJDToast.show();
            }
        });
    }

    private void tryDownLoad(IMyActivity paramIMyActivity, String paramString1, String paramString2, int paramInt)
    {
        Bundle localBundle = new Bundle();
        localBundle.putString("app_version", paramString1);
        localBundle.putString("app_upgrade", "301");
        localBundle.putString("app_url", paramString2);
        localBundle.putInt("app_apksize", paramInt);
        localBundle.putBoolean("IsAuto", false);
        localBundle.putInt("app_update_coupon", 10);
        localBundle.putString("APP_UPDATE_CLICK_TS", JDMtaUtils.getCurrentMicrosecond());
        if (NetUtils.isNetworkAvailable())
        {
            Intent intent = new Intent("com.jingdong.app.mall.service.PausableDownloadService");
            intent.putExtras(localBundle);
            paramIMyActivity.getThisActivity().startService(intent);
            JDToast jdToast = new JDToast(BaseApplication.getInstance(), 2);
            jdToast.setText(StringUtil.alert_message_install_start);
            jdToast.setDuration(Toast.LENGTH_SHORT);
            jdToast.show();
            return;
        }
        BaseApplication.getInstance().getHandler().post(new Runnable(){//ca(this)
            @Override
            public void run() {
                Toast.makeText(BaseApplication.getInstance(), StringUtil.message_no_network, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tryInstallApk(IMyActivity paramIMyActivity)
    {
        //TODO:未实现
//        if (!ApplicationUpgradeHelper.installApk(CommonUtil.getStringFromPreference("jd_app_install_file", "")))
//        {
//            paramIMyActivity = new JDToast(BaseApplication.getInstance(), 2);
//            paramIMyActivity.setText(StringUtil.alert_message_install_error);
//            paramIMyActivity.setDuration(0);
//            paramIMyActivity.show();
//        }
    }

    private void tryRequestVersion(IMyActivity paramIMyActivity)
    {
        //TODO:未实现
//        HttpGroup.HttpSetting localHttpSetting = requestVersionHand(true, new bw(this, paramIMyActivity));
//        IMyActivity localIMyActivity = paramIMyActivity;
//        if (paramIMyActivity == null)
//            localIMyActivity = BaseApplication.getInstance().getCurrentMyActivity();
//        localIMyActivity.getHttpGroupaAsynPool().add(localHttpSetting);
    }

//    public void checkDialogIsShowing(com.jingdong.common.utils.bx parambx)
//    {
    //TODO:未实现
//        if (parambx == null)
//            return;
//        this.mIDialogShow = parambx;
//        parambx.a(false);
//    }

    public void checkVersion(IMyActivity paramIMyActivity)
    {
        if (BaseApplication.getInstance().getCurrentMyActivity() != null)
            checkSoftwareUpdated(false, paramIMyActivity);
    }

    public void cleanDialog()
    {
        //TODO:未实现
        //this.mIDialogShow = null;
    }

    public void initNetwork()
    {
        if (BaseApplication.getInstance().getCurrentMyActivity() != null)
        {
            if (Log.D)
                Log.d("JDGlobalInit", "GlobalInitialization initNetwork() -->> ");
            networkInitialization();
        }
    }

//    public boolean isNoUpdate(VersionEntity paramVersionEntity)
//    {
    //TODO:未实现
//        if (paramVersionEntity == null);
//        do
//            return true;
//        while ((paramVersionEntity.upgradeCode == 0) || (paramVersionEntity.upgradeCode == 300) || (TextUtils.isEmpty(paramVersionEntity.downloadUrl)) || (TextUtils.isEmpty(paramVersionEntity.description)) || (TextUtils.isEmpty(paramVersionEntity.remoteVersion)) || (checkAPK(paramVersionEntity.packageList)) || (TextUtils.isEmpty(paramVersionEntity.md5)) || (!com.jingdong.app.mall.appcenter.a.a(paramVersionEntity.downloadUrl, paramVersionEntity.md5)));
//        return false;
//    }

    public void updateForCoupon(IMyActivity paramIMyActivity)
    {
        String str1 = CommonUtil.getStringFromPreference("app_url", "");
        String str2 = CommonUtil.getStringFromPreference("app_version", "");
        int i = CommonUtil.getIntFromPreference("app_apksize", -1);
        if ((!TextUtils.isEmpty(str2)) && (isFileAvailable(str2)))
        {
            tryInstallApk(paramIMyActivity);
        }else if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (i == -1) || (!str1.contains(str2)))
        {
            tryRequestVersion(paramIMyActivity);
        }else
        tryDownLoad(paramIMyActivity, str2, str1, i);
    }
}
