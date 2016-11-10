package com.jingdong.app.mall.utils;

/**
 * Created by Robin on 2016/11/11.
 */
public class UpdateInitialization {
    private static final String TAG = "JDGlobalInit";
    private static final int UPDATE_COUPON = 10;
    private static GlobalInitialization globalInitialization;
    private static UpdateInitialization updateInitialization;
    public com.jingdong.common.utils.bx mIDialogShow;

    private void autoCheckSVersion()
    {
        HttpGroup.HttpSetting localHttpSetting = requestVersionAuto(new by(this));
        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private boolean canDoVersion()
    {
        String str = CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance());
        long l1 = CommonUtil.getJdSharedPreferences().getLong(str + "keyLastUpdate", -1L);
        int i = CommonUtil.getJdSharedPreferences().getInt(str + "keyUpdateInterval", -1);
        if ((l1 == -1L) || (i == -1));
        long l2;
        do
        {
            return true;
            l2 = System.currentTimeMillis();
            if (!Log.D)
                continue;
            Log.d("JDGlobalInit", "FunctionAccessUtil lastAccess-->> " + l1);
            Log.d("JDGlobalInit", "FunctionAccessUtil interval-->> " + i);
            Log.d("JDGlobalInit", "FunctionAccessUtil now-->> " + l2);
        }
        while (l1 + i * 3600000L <= l2);
        return false;
    }

    private boolean canShowUpdate()
    {
        String str = CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance());
        int i = CommonUtil.getJdSharedPreferences().getInt(str + "keyLastShowNum", 0);
        int j = CommonUtil.getJdSharedPreferences().getInt(str + "keyLastShowLimit", -1);
        if (j == -1);
        do
            return true;
        while (i < j);
        return false;
    }

    private boolean checkAPK(String paramString)
    {
        if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        {
            paramString = DesUtil.decrypt(paramString, "e1Ck6jlK");
            if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
            {
                paramString = Arrays.asList(paramString.split(","));
                if ((paramString != null) && (!paramString.isEmpty()))
                {
                    paramString = paramString.iterator();
                    while (paramString.hasNext())
                    {
                        String str = (String)paramString.next();
                        if (r.a().a(str))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private void checkSoftwareUpdated(boolean paramBoolean, IMyActivity paramIMyActivity)
    {
        if (Log.D)
            Log.d("JDGlobalInit", "GlobalInitialization checkSoftwareUpdated() BEING-->> ");
        if ((!Configuration.getBooleanProperty("applicationUpgrade").booleanValue()) && (paramBoolean))
            return;
        Object localObject = new bx(this, paramIMyActivity, paramBoolean);
        HttpGroup.HttpSetting localHttpSetting = requestVersionAuto((HttpGroup.OnAllListener)localObject);
        if (!paramBoolean)
        {
            localHttpSetting = requestVersionHand(true, (HttpGroup.OnAllListener)localObject);
            localObject = paramIMyActivity;
            if (paramIMyActivity == null)
                localObject = BaseApplication.getInstance().getCurrentMyActivity();
            ((IMyActivity)localObject).getHttpGroupaAsynPool().add(localHttpSetting);
            return;
        }
        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private void cleanCache()
    {
        setCouponCache("", "", -1);
    }

    public static UpdateInitialization getUpdateInitializationInstance()
    {
        monitorenter;
        try
        {
            if (updateInitialization == null)
            {
                updateInitialization = new UpdateInitialization();
                globalInitialization = GlobalInitialization.getGlobalInitializationInstance();
            }
            UpdateInitialization localUpdateInitialization = updateInitialization;
            return localUpdateInitialization;
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    private void handCheckSVersion()
    {
        HttpGroup.HttpSetting localHttpSetting = requestVersionHand(true, new bz(this));
        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private boolean initLogin()
    {
        try
        {
            String str1 = SafetyManager.getCookies();
            String str2 = SafetyManager.getUserInfo();
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
            {
                HttpGroup.setCookies(str1);
                HttpGroupAdapter.setCookies(str1);
            }
            return true;
        }
        catch (Exception localException)
        {
            if (Log.E)
                localException.printStackTrace();
        }
        return false;
    }

    private boolean isFileAvailable(String paramString)
    {
        String str = CommonUtil.getStringFromPreference("jd_app_install_file", "");
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)) || (!str.contains(paramString)) || (!bp.b(str)))
            if (Log.D)
                Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileExist  -->> false");
        do
        {
            do
                while (true)
                {
                    return false;
                    if (CommonUtil.getBooleanFromPreference("jd_app_update_failed", Boolean.valueOf(false)).booleanValue())
                        continue;
                    if (Log.D)
                        Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  start -->> ");
                    try
                    {
                        if (Log.D)
                            Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  loading -->> ");
                        paramString = p.a(paramString);
                        str = ApplicationUpgradeHelper.getFileMD5(new File(str));
                        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)))
                            continue;
                        if (Log.D)
                        {
                            Log.d("JDGlobalInit", "oldMd5-->> " + paramString);
                            Log.d("JDGlobalInit", "newMd5-->> " + str);
                        }
                        if (TextUtils.equals(paramString, str))
                            return true;
                        if (!Log.D)
                            continue;
                        Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  end -->> ");
                        return false;
                    }
                    catch (Exception paramString)
                    {
                    }
                }
            while (!Log.D);
            paramString.printStackTrace();
        }
        while (!Log.D);
        Log.d("JDGlobalInit", "checkSoftwareUpdated() isFileEquals  Exception -->> ");
        return false;
    }

    private void networkInitialization()
    {
        monitorenter;
        try
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
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    private void networkInitializationStart()
    {
        if (Log.D)
            Log.d("JDGlobalInit", "GlobalInitialization networkInitializationStart() -->> ");
        if (GlobalInitialization.canDoDevice())
        {
            if (Log.D)
                Log.d("JDGlobalInit", "ready to do device CMD-->> ");
            globalInitialization.registerDevice(GlobalInitialization.isDeviceFirstCalled());
        }
        while (true)
        {
            globalInitialization.setTaskBeginFlag(1);
            globalInitialization.serverConfig(new bu(this));
            if (GlobalInitialization.canDoABTest())
            {
                if (Log.D)
                    Log.d("JDGlobalInit", "ready to ABTest CMD -->> ");
                com.jingdong.common.utils.a.a(globalInitialization.getHttpGroup());
            }
            new Timer().schedule(new bv(this), Configuration.getIntegerProperty("routineCheckDelayTime").intValue());
            return;
            globalInitialization.alreadyDevice = true;
        }
    }

    private void newFeatureWizard()
    {
        if (Log.D)
            Log.d("JDGlobalInit", "GlobalInitialization serverConfig() BEGIN-->> ");
        cc localcc = new cc(this);
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setFunctionId("newFeatureWizard");
        localHttpSetting.setHost(Configuration.getNgwHost());
        localHttpSetting.setEffect(0);
        localHttpSetting.setNotifyUser(false);
        localHttpSetting.setNeedGlobalInitialization(false);
        localHttpSetting.setTopPriority(true);
        localHttpSetting.setListener(localcc);
        globalInitialization.getHttpGroup().add(localHttpSetting);
    }

    private HttpGroup.HttpSetting requestVersionAuto(HttpGroup.OnAllListener paramOnAllListener)
    {
        return bn.a(paramOnAllListener);
    }

    private HttpGroup.HttpSetting requestVersionHand(boolean paramBoolean, HttpGroup.OnAllListener paramOnAllListener)
    {
        paramOnAllListener = bn.a(paramOnAllListener);
        paramOnAllListener.setNotifyUser(true);
        if (paramBoolean)
        {
            paramOnAllListener.setEffect(1);
            return paramOnAllListener;
        }
        paramOnAllListener.setEffect(0);
        return paramOnAllListener;
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
        paramIMyActivity.post(new cb(this));
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
            paramString1 = new Intent("com.jingdong.app.mall.service.PausableDownloadService");
            paramString1.putExtras(localBundle);
            paramIMyActivity.getThisActivity().startService(paramString1);
            paramIMyActivity = new JDToast(BaseApplication.getInstance(), 2);
            paramIMyActivity.setText(StringUtil.alert_message_install_start);
            paramIMyActivity.setDuration(0);
            paramIMyActivity.show();
            return;
        }
        BaseApplication.getInstance().getHandler().post(new ca(this));
    }

    private void tryInstallApk(IMyActivity paramIMyActivity)
    {
        if (!ApplicationUpgradeHelper.installApk(CommonUtil.getStringFromPreference("jd_app_install_file", "")))
        {
            paramIMyActivity = new JDToast(BaseApplication.getInstance(), 2);
            paramIMyActivity.setText(StringUtil.alert_message_install_error);
            paramIMyActivity.setDuration(0);
            paramIMyActivity.show();
        }
    }

    private void tryRequestVersion(IMyActivity paramIMyActivity)
    {
        HttpGroup.HttpSetting localHttpSetting = requestVersionHand(true, new bw(this, paramIMyActivity));
        IMyActivity localIMyActivity = paramIMyActivity;
        if (paramIMyActivity == null)
            localIMyActivity = BaseApplication.getInstance().getCurrentMyActivity();
        localIMyActivity.getHttpGroupaAsynPool().add(localHttpSetting);
    }

    public void checkDialogIsShowing(com.jingdong.common.utils.bx parambx)
    {
        if (parambx == null)
            return;
        this.mIDialogShow = parambx;
        parambx.a(false);
    }

    public void checkVersion(IMyActivity paramIMyActivity)
    {
        if (BaseApplication.getInstance().getCurrentMyActivity() != null)
            checkSoftwareUpdated(false, paramIMyActivity);
    }

    public void cleanDialog()
    {
        this.mIDialogShow = null;
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

    public boolean isNoUpdate(VersionEntity paramVersionEntity)
    {
        if (paramVersionEntity == null);
        do
            return true;
        while ((paramVersionEntity.upgradeCode == 0) || (paramVersionEntity.upgradeCode == 300) || (TextUtils.isEmpty(paramVersionEntity.downloadUrl)) || (TextUtils.isEmpty(paramVersionEntity.description)) || (TextUtils.isEmpty(paramVersionEntity.remoteVersion)) || (checkAPK(paramVersionEntity.packageList)) || (TextUtils.isEmpty(paramVersionEntity.md5)) || (!com.jingdong.app.mall.appcenter.a.a(paramVersionEntity.downloadUrl, paramVersionEntity.md5)));
        return false;
    }

    public void updateForCoupon(IMyActivity paramIMyActivity)
    {
        String str1 = CommonUtil.getStringFromPreference("app_url", "");
        String str2 = CommonUtil.getStringFromPreference("app_version", "");
        int i = CommonUtil.getIntFromPreference("app_apksize", -1);
        if ((!TextUtils.isEmpty(str2)) && (isFileAvailable(str2)))
        {
            tryInstallApk(paramIMyActivity);
            return;
        }
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (i == -1) || (!str1.contains(str2)))
        {
            tryRequestVersion(paramIMyActivity);
            return;
        }
        tryDownLoad(paramIMyActivity, str2, str1, i);
    }
}
