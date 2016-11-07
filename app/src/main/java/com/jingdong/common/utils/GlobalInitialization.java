package com.jingdong.common.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.config.Configuration;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/11/7.
 */
public class GlobalInitialization implements CPAUtils{
    private static final String TAG = "JDGlobalInit";
    static final int TASK_TOKEN_REGISTER_DEVICE = 2;
    public static final int TASK_TOKEN_SERVER_CONFIG = 1;
    private static GlobalInitialization globalInitialization;
    public static bx mIDialogShow;
    public boolean alreadyConfig = false;
    public boolean alreadyDevice = false;
    private ArrayList<bu> configListenerList = new ArrayList();
    private HttpGroup httpGroup;
    int runningTaskFlags = 0;

    public static boolean canDoABTest()
    {
        return bq.a("keyLastAccessAbTestBackFunctionId", "keyAbTestBackFunctionIdAccessThresholdMS");
    }

    public static boolean canDoDevice()
    {
        return bq.a("keyLastAccessDevice", "keyDeviceAccessThresholdMS");
    }

    static boolean canDoServerConfig()
    {
        return bq.a("keyLastAccessServerConfig", "keyServerConfigAccessThresholdMS");
    }

    public static void checkDialogIsShowing(bx parambx)
    {
        if (parambx == null)
            return;
        mIDialogShow = parambx;
        parambx.a(false);
    }

    public static void cleanDialog()
    {
        mIDialogShow = null;
    }

    public synchronized static GlobalInitialization getGlobalInitializationInstance()
    {
            if (globalInitialization == null)
                globalInitialization = new GlobalInitialization();
            GlobalInitialization localGlobalInitialization = globalInitialization;
            return localGlobalInitialization;
    }

    public static boolean isDeviceFirstCalled()
    {
        return CommonUtil.getJdSharedPreferences().getLong("keyLastAccessDevice", -1L) == -1L;
    }

    private synchronized void networkInitializationEnd()
    {
            if (Log.D)
                Log.d("JDGlobalInit", "GlobalInitialization networkInitializationEnd() -->> ");
            BaseApplication localBaseApplication = BaseApplication.getInstance();
            if ((this.alreadyDevice) && (this.alreadyConfig));
            for (localBaseApplication.networkInitializationState = 2; ; localBaseApplication.networkInitializationState = 0)
            {
                if (Log.D)
                    Log.d("JDGlobalInit", "GlobalInitialization networkInitializationEnd() with " + localBaseApplication.networkInitializationState);
                return;
            }
    }

    public static void regDevice()
    {
        if ((canDoDevice()) && (BaseApplication.getInstance().getCurrentMyActivity() != null))
            getGlobalInitializationInstance().registerDevice(false);
    }

    public static void requestConfig()
    {
        int i = 0;
        if (Log.D)
            Log.d("JDGlobalInit", "------request--Config--");
        long l;
        if (TextUtils.isEmpty("shared_data_version_clientConfig"))
        {
            if (!TextUtils.isEmpty("shared_cache_time_clientConfig"))
                break label69;
            l = 0L;
        }
        while (true)
        {
            Object localObject;
            if ((l != 0L) && (l > System.currentTimeMillis()))
            {
                return;
                localObject = CommonUtil.getJdSharedPreferences();
                if (localObject == null)
                    break;
                i = ((SharedPreferences)localObject).getInt("shared_data_version_clientConfig", 0);
                break;
                label69: localObject = CommonUtil.getJdSharedPreferences();
                if (localObject != null)
                {
                    l = ((SharedPreferences)localObject).getLong("shared_cache_time_clientConfig", 0L);
                    continue;
                }
            }
            else
            {
                localObject = new HttpGroup.HttpSetting();
                ((HttpGroup.HttpSetting)localObject).setFunctionId("clientConfig");
                ((HttpGroup.HttpSetting)localObject).setCacheMode(2);
                ((HttpGroup.HttpSetting)localObject).setAttempts(2);
                ((HttpGroup.HttpSetting)localObject).setHost(HostConfig.getInstance().getHost(HostConstants.PERSONAL_HOME_HOST));
                ((HttpGroup.HttpSetting)localObject).putJsonParam("dataVersion", Integer.valueOf(i));
                ((HttpGroup.HttpSetting)localObject).setListener(new bs(i));
                HttpGroupUtils.getHttpGroupaAsynPool().add((HttpGroup.HttpSetting)localObject);
                return;
            }
            l = 0L;
        }
    }

    public synchronized void addConfigLoadedListener(bu parambu)
    {

            if ((this.configListenerList != null) && (parambu != null))
                this.configListenerList.add(parambu);
            return;
    }

    public void exit()
    {
    }

    public HttpGroup getHttpGroup()
    {
        if (this.httpGroup == null)
        {
            IMyActivity localIMyActivity = BaseApplication.getInstance().getCurrentMyActivity();
            if (localIMyActivity != null)
            {
                HttpGroup.HttpGroupSetting localHttpGroupSetting = new HttpGroup.HttpGroupSetting();
                localHttpGroupSetting.setType(1000);
                localHttpGroupSetting.setMyActivity(localIMyActivity);
                this.httpGroup = HttpGroup.getHttpGroup(localHttpGroupSetting);
            }
        }
        return this.httpGroup;
    }

    public void registerDevice(boolean paramBoolean)
    {
        if (BaseApplication.getInstance().getCurrentMyActivity() == null)
            return;
        Object localObject1 = new w(this);
        if ((paramBoolean) && (((w)localObject1).a()))
        {
            Log.d("JDGlobalInit", "GlobalInitialization registerDevice() skip for CPA ");
            return;
        }
        if (Log.D)
            Log.d("JDGlobalInit", "GlobalInitialization registerDevice() BEING with isFirst= " + paramBoolean);
        setTaskBeginFlag(2);
        try
        {
            localObject1 = new JSONObject(StatisticsReportUtil.getDeviceInfoStr());
            bt localbt = new bt(this);
            HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
            localHttpSetting.setJsonParams((JSONObject)localObject1);
            localHttpSetting.setFunctionId("device");
            localHttpSetting.setHost(Configuration.getNgwHost());
            localHttpSetting.setListener(localbt);
            localHttpSetting.setNeedGlobalInitialization(false);
            localHttpSetting.setTopPriority(true);
            getHttpGroup().add(localHttpSetting);
            return;
        }
        catch (JSONException e)
        {
                e.printStackTrace();
        }
    }

    public synchronized void removeConfigLoadedListener(bu parambu)
    {
            if ((this.configListenerList != null) && (parambu != null))
                this.configListenerList.remove(parambu);
            return;
    }

    public void serverConfig(bv parambv)
    {
        if (Log.D)
            Log.d("JDGlobalInit", "GlobalInitialization serverConfig() BEGIN-->> ");
        setTaskBeginFlag(1);
        parambv = new br(this, parambv);
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setFunctionId("serverConfig");
        localHttpSetting.setHost(Configuration.getNgwHost());
        localHttpSetting.setListener(parambv);
        localHttpSetting.setNeedGlobalInitialization(false);
        localHttpSetting.setTopPriority(true);
        getHttpGroup().add(localHttpSetting);
    }

    public void setTaskBeginFlag(int paramInt)
    {
        this.runningTaskFlags |= paramInt;
    }

    void setTaskEndFlag(int paramInt)
    {
        this.runningTaskFlags &= (paramInt ^ 0xFFFFFFFF);
        if (this.runningTaskFlags == 0)
            networkInitializationEnd();
    }
}
