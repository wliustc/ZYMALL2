package com.jingdong.common;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.ui.JDDialogFactory;
import com.jingdong.common.utils.BitmapkitUtils;
import com.zy.common.frame.IMainActivity;
import com.zy.common.frame.IMyActivity;
import com.zy.common.res.StringUtil;
import com.zy.common.ui.JDDialog;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.Properties;
import java.util.Timer;

/**
 * Created by Robin on 2016/4/14.
 */
public abstract class BaseApplication extends Application {

    private static int APP_DOWNLOAD_NOTIFICATION = 1000;
    private static String APP_UPDATE_FAILED = "jd_app_update_failed";
    private static final String TAG = BaseApplication.class.getSimpleName();
    private static boolean canExitInToastTime = false;
    protected static BaseApplication instance;
    public static boolean isShowActivity;
    private static _N killSatage;
    private static BitmapkitUtils mBitmapkitUtils;
    public static long startRealTime;
    public static long startTime;
    private IMyActivity activity;
    private Handler handler = new Handler() {//f
        @Override
        public void dispatchMessage(Message msg) {
            try {
                super.dispatchMessage(msg);
            } catch (java.lang.Throwable paramMessage) {
            }
        }
    };
    private d helper;
    private IMyActivity homeMainActivity;
    protected IMainActivity mainFrameActivity;
    public int networkInitializationState = 0;
    private Thread uiThread;
    private PowerManager.WakeLock wakeLock;

    public static void exit(IMyActivity paramIMyActivity)
    {
        if (Log.D)
            Log.d("MyApplication", "MyApplication exit() -->> ");
        if (paramIMyActivity != null)
            paramIMyActivity.finish();
        Log.unInstall();
        getInstance().handler.postDelayed(new m(), 100L);
    }

    public static void exitAll()
    {
        if (Log.D)
            Log.d("MyApplication", "MyApplication exitAll() -->> ");
        cb.d();
        com.jingdong.common.network.k localk = com.jingdong.common.network.k.a();
        if (Log.D)
            Log.d("httpDns", "unRegisterEventBus");
        EventBus.getDefault().unregister(localk);
        killStage();
    }

    public static void exitControl()
    {
        Object localObject = CommonUtil.getExitType();
        if (TextUtils.equals((CharSequence)localObject, "3"))
        {
            exitDialog();
            return;
        }
        if (TextUtils.equals((CharSequence)localObject, "2"))
        {
            exitToast();
            return;
        }
        localObject = getInstance().getMainFrameActivity();
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.setFlags(268435456);
        localIntent.addCategory("android.intent.category.HOME");
        try
        {
            ((c)localObject).startActivity(localIntent);
            return;
        }
        catch (Exception localException)
        {
            exitDialog();
        }
    }

    public static void exitDialog()
    {
        exitDialog(null);
    }

    public static void exitDialog(IMyActivity paramIMyActivity)
    {
        if (Log.D)
            Log.d("MyApplication", "exitDialog() -->> ");
        Activity localActivity = (Activity)paramIMyActivity;
        Object localObject = localActivity;
        if (localActivity == null);
        try
        {
            localObject = getInstance().getMainFrameActivity().getThisActivity();
            if (Configuration.getBooleanProperty("isCoolMart", Boolean.valueOf(false)).booleanValue())
            {
                exit(paramIMyActivity);
                return;
            }
        }
        catch (Exception localException)
        {
            while (true)
            {
                exitAll();
                localObject = localActivity;
                if (!Log.D)
                    continue;
                localException.printStackTrace();
                localObject = localActivity;
            }
            localObject = JDDialogFactory.getInstance().createJdDialogWithStyle2((Context)localObject, StringUtil.pg_home_exit_confrim_string, StringUtil.cancel, StringUtil.exit);
            ((JDDialog)localObject).setOnRightButtonClickListener(new l(paramIMyActivity));
            try
            {
                ((JDDialog)localObject).show();
                return;
            }
            catch (Throwable localThrowable)
            {
                if (Log.E)
                    localThrowable.printStackTrace();
                exit(paramIMyActivity);
            }
        }
    }

    public static void exitToast()
    {
        if (canExitInToastTime)
        {
            exit(null);
            return;
        }
        Toast.makeText(getInstance(), StringUtil.exit_toast_message, 0).show();
        canExitInToastTime = true;
        new Timer().schedule(new k(), 2000L);
    }

    public static String getAId()
    {
        return Settings.System.getString(instance.getContentResolver(), "android_id");
    }

    public static BitmapkitUtils getBitmapkitUtils()
    {
        return mBitmapkitUtils;
    }

    public static BaseApplication getInstance()
    {
        return instance;
    }

    private void initApp() {
        //TODO:未实现
    }

    private static void initCBT()
    {
        Properties localProperties;
        if (Configuration.getBooleanProperty("CBTMode", Boolean.valueOf(false)).booleanValue())
        {
            if (Log.D)
                Log.d("MyApplication", "initCBT()-->do");
            localProperties = Configuration.getProperties();
            if (localProperties != null);
        }
        else
        {
            return;
        }
        SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();
        String str = localSharedPreferences.getString("host", "");
        if (!TextUtils.isEmpty(str))
        {
            if (Log.D)
                Log.d("MyApplication", "initCBT()-->set Host" + str);
            localProperties.setProperty("host", str);
        }
        str = localSharedPreferences.getString("mHost", "");
        if (!TextUtils.isEmpty(str))
            localProperties.setProperty("mHost", str);
        str = localSharedPreferences.getString("paiHost", "");
        if (!TextUtils.isEmpty(str))
            localProperties.setProperty("paiHost", str);
        str = localSharedPreferences.getString("msgHost", "");
        if (!TextUtils.isEmpty(str))
            localProperties.setProperty("msgHost", str);
        str = localSharedPreferences.getString("plugHost", "");
        if (!TextUtils.isEmpty(str))
            localProperties.setProperty("plugHost", str);
        if (Boolean.valueOf(localSharedPreferences.getBoolean("testMode", false)).booleanValue())
        {
            localProperties.setProperty("testMode", "true");
            return;
        }
        localProperties.setProperty("testMode", "false");
    }

    public static void killStage()
    {
        if (Log.D)
            Log.d("MyApplication", "MyApplication killStage() -->> ");
        CommonUtil.putBooleanToPreference(APP_UPDATE_FAILED, Boolean.valueOf(false));
        NotificationManager localNotificationManager = (NotificationManager)getInstance().getSystemService("notification");
        if (localNotificationManager != null)
            localNotificationManager.cancel(APP_DOWNLOAD_NOTIFICATION);
        instance.setMainFrameActivity(null);
        instance.networkInitializationState = 0;
        JDMtaUtils.destroy();
        StorageReceiver.b(instance.getApplicationContext());
        if (killSatage != null)
            killSatage.a();
        Process.killProcess(Process.myPid());
    }

    public static void killStageNoUI()
    {
        monitorenter;
        try
        {
            if (Log.D)
                Log.d("MyApplication", "MyApplication killStageNoUI() -->> ");
            if (getInstance().getMainFrameActivity() == null)
            {
                if (Log.D)
                    Log.d("MyApplication", " killSelfMethod -->> kell!");
                instance.setMainFrameActivity(null);
                instance.networkInitializationState = 0;
            }
            try
            {
                ((ActivityManager)instance.getSystemService("activity")).restartPackage(instance.getPackageName());
                monitorexit;
                return;
            }
            catch (Throwable localThrowable)
            {
                while (true)
                {
                    if (!Log.E)
                        continue;
                    Log.e("MyApplication", " -->> " + localThrowable.getMessage());
                }
            }
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    public static void networkSetting()
    {
        //TODO 未实现
    }

    public static void setKillSatage(_N killSatage)
    {
        BaseApplication.killSatage = killSatage;
    }

    public static void submitTime()
    {
        long l = 0L;
        if (Log.D)
            Log.d("MyApplication", "MyApplication setEndTime() -->> ");
        fz.b = System.currentTimeMillis();
        if (Log.D)
            System.out.println("TimerUntil.endTime=" + fz.b);
        SharedPreferences.Editor localEditor = CommonUtil.getJdSharedPreferences().edit();
        if (Log.D)
            System.out.println("TimerUntil startTime=" + fz.a + "\tendTime=" + fz.b);
        if ((fz.b - fz.a) / 1000L > 0L)
            l = (fz.b - fz.a) / 1000L;
        localEditor.putLong("appUseTime", l).commit();
    }

    @Override
    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        if (ev.a())
            openWakeLock();
        a.a(this);
        instance = this;
    }

    public void closeWakeLock()
    {
        if (this.wakeLock != null)
        {
            this.wakeLock.release();
            this.wakeLock = null;
        }
    }

    public IMyActivity getCurrentMyActivity()
    {
        if (Log.D)
        {
            if (this.mainFrameActivity == null)
                Log.d("MyApplication", "xxx mainFrameActivity -->>  mainFrameActivity is null");
            else{
                Log.d("MyApplication", "xxx mainFrameActivity -->> " + this.mainFrameActivity);
            }

        }
        if (this.activity != null)
        {
            return this.activity;

        }else if (this.mainFrameActivity != null)
        {
            Activity localActivity = this.mainFrameActivity.getThisActivity();
            if (Log.D)
                Log.d("MyApplication", "xxx activity -->> " + localActivity);
            if ((localActivity instanceof IMyActivity))
                return (IMyActivity)localActivity;
        }
        return null;
    }

    public abstract Drawable getDefalutDrawble();

    public abstract Class<?> getErrorActivityClass();

    public Handler getHandler()
    {
        return this.handler;
    }

    public IMyActivity getHomeMainActivity()
    {
        return this.homeMainActivity;
    }


    public abstract ProgressBar getLoadingProgressBar();

    public abstract Class<?> getMainActivityClass();

    public IMainActivity getMainFrameActivity()
    {
        return this.mainFrameActivity;
    }

    public Thread getUiThread()
    {
        return this.uiThread;
    }

    protected void initDelay()
    {
        if (!Configuration.getProperty("partner").equals("jingdong"))
            return;
        if (this.helper == null)
            this.helper = gp.b();
        this.helper.a(1);
    }

    public boolean isBackstage()
    {
        String str = getPackageName();
        List localList = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
        if ((localList != null) && (localList.size() > 0))
        {
            if (Log.D)
                Log.d(getClass().getSimpleName(), " -->> 当前堆栈顶层应用：" + ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName());
            if (str.equals(((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName()))
                return false;
        }
        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Log.D)
            Log.d("MyApplication", "MyApplication onCreate() -->> Process.myPid() " + Process.myPid());
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new do(this));
        CommonUtil.getJdSharedPreferences().edit().putInt("runStage", 0).commit();
        startTime = SystemClock.uptimeMillis();
        startRealTime = SystemClock.elapsedRealtime();
        JDJSON.init(false);
        try
        {
            DPIUtil.setDensity(getResources().getDisplayMetrics().density);
            if (!ev.a())
            {
                String str = ev.a(Process.myPid()).trim();
                if ((TextUtils.isEmpty(str)) || (!TextUtils.equals(str, "com.jingdong.app.mall:error")))
                    break label185;
                i = 1;
                if (i == 0);
            }
            else
            {
                initApp();
            }
            if ((!Configuration.getBooleanProperty("beforeInitTip").booleanValue()) || (CommonUtil.getJdSharedPreferences().getBoolean("hasInitTip", false)))
                Log.install();
            return;
        }
        catch (Throwable localThrowable)
        {
            while (true)
            {
                if (!Log.E)
                    continue;
                localThrowable.printStackTrace();
                continue;
                label185: int i = 0;
            }
        }
    }

    public void openWakeLock()
    {
        try
        {
            this.wakeLock = ((PowerManager)getSystemService(Context.POWER_SERVICE/*"power"*/)).newWakeLock(1, "MyWakelockTag");
            this.wakeLock.acquire();
            return;
        }
        catch (Exception localException)
        {
            while (!Log.D);
            Log.d(TAG, localException.getLocalizedMessage());
        }
    }





    public void setCurrentMyActivity(IMyActivity paramIMyActivity)
    {
        this.activity = paramIMyActivity;
    }


    public void setHomeMainActivity(IMyActivity paramIMyActivity)
    {
        this.homeMainActivity = paramIMyActivity;
    }

    public void setMainFrameActivity(IMainActivity paramc)
    {
        this.mainFrameActivity = paramc;
    }

    public abstract void startMainFrameActivity(Context paramContext);

    public abstract void watchLeakFragment(Fragment paramFragment);

    public interface _N{
        public void a();
    }

}
