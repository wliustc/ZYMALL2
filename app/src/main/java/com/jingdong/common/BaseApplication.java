package com.jingdong.common;

import android.app.Activity;
import android.app.ActivityManager;
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
import android.support.multidex.MultiDex;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.network.JDDnsUtil;
import com.jingdong.common.ui.JDDialogFactory;
import com.jingdong.common.utils.BitmapkitUtils;
import com.jingdong.common.utils.JDFrescoUtils;
import com.jingdong.common.utils.MyUncaughtExceptionHandler;
import com.jingdong.common.utils.UserUtil;
import com.zy.common.broadcastReceiver.StorageReceiver;
import com.zy.common.frame.IMainActivity;
import com.zy.common.frame.IMyActivity;
import com.zy.common.res.StringUtil;
import com.zy.common.ui.JDDialog;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;
import com.zy.common.utils.ProcessUtil;
import com.zy.common.utils.TimerUntil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import jd.wjlogin_sdk.a.WJLoginHelper;

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
    private Handler handler = ;
    private WJLoginHelper helper;
    private IMyActivity homeMainActivity;
    protected IMainActivity mainFrameActivity;
    public int networkInitializationState = 0;
    private Thread uiThread;
    private PowerManager.WakeLock wakeLock;

    public static void exit(IMyActivity paramIMyActivity) {
        if (Log.D)
            Log.d("MyApplication", "MyApplication exit() -->> ");
        if (paramIMyActivity != null)
            paramIMyActivity.finish();
        Log.unInstall();
        getInstance().handler.postDelayed(new Runnable() {//m()
            @Override
            public void run() {
                try {
                    BaseApplication.submitTime();
                    BaseApplication.exitAll();
                    return;
                } catch (Throwable localThrowable) {
                    if (Log.E)
                        localThrowable.printStackTrace();
                    Process.killProcess(Process.myPid());
                }
            }
        }, 100L);
    }

    public static void exitAll() {
        if (Log.D)
            Log.d("MyApplication", "MyApplication exitAll() -->> ");
        JDFrescoUtils.d();
        JDDnsUtil localk = JDDnsUtil.getInstance();
        if (Log.D)
            Log.d("httpDns", "unRegisterEventBus");
        EventBus.getDefault().unregister(localk);
        killStage();
    }

    public static void exitControl() {
        String localObject = CommonUtil.getExitType();
        if (TextUtils.equals((CharSequence) localObject, "3")) {
            exitDialog();
        } else if (TextUtils.equals((CharSequence) localObject, "2")) {
            exitToast();
        } else {
            IMainActivity activity = getInstance().getMainFrameActivity();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//268435456
            intent.addCategory("android.intent.category.HOME");
            try {
                ((IMainActivity) activity).startActivity(intent);
                return;
            } catch (Exception localException) {
                exitDialog();
            }
        }
    }

    public static void exitDialog() {
        exitDialog(null);
    }

    public static void exitDialog(final IMyActivity paramIMyActivity) {
        if (Log.D)
            Log.d("MyApplication", "exitDialog() -->> ");
        Activity localActivity = (Activity) paramIMyActivity;
        Object localObject = localActivity;
        if (localActivity == null) {//if-nez v0, :cond_1
            try {
                localObject = getInstance().getMainFrameActivity().getThisActivity();
            } catch (Exception localException) {
                exitAll();
                localObject = localActivity;
                if (Log.D)
                    localException.printStackTrace();
            }
        }

        if (Configuration.getBooleanProperty("isCoolMart", Boolean.valueOf(false)).booleanValue()) {
            exit(paramIMyActivity);
        } else {
            localObject = JDDialogFactory.getInstance().createJdDialogWithStyle2((Context) localObject, StringUtil.pg_home_exit_confrim_string, StringUtil.cancel, StringUtil.exit);
            ((JDDialog) localObject).setOnRightButtonClickListener(new View.OnClickListener() {//l(paramIMyActivity)
                @Override
                public void onClick(View v) {
                    BaseApplication.exit(paramIMyActivity);
                }
            });
            try {
                ((JDDialog) localObject).show();
            } catch (Throwable localThrowable) {
                if (Log.E)
                    localThrowable.printStackTrace();
                exit(paramIMyActivity);
            }
        }
    }

    public static void exitToast() {
        if (canExitInToastTime) {
            exit(null);
        } else {
            Toast.makeText(getInstance(), StringUtil.exit_toast_message, Toast.LENGTH_SHORT).show();
            canExitInToastTime = true;
            new Timer().schedule(new TimerTask() {//k()
                @Override
                public void run() {
                    BaseApplication.canExitInToastTime = false;
                }
            }, 2000L);
        }
    }

    public static String getAId() {
        return Settings.System.getString(instance.getContentResolver(), "android_id");
    }

    public static BitmapkitUtils getBitmapkitUtils() {
        return mBitmapkitUtils;
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    private void initApp() {
        StorageReceiver.a(instance.getApplicationContext());
        handler = new Handler() {//f
                @Override
                public void dispatchMessage(Message msg) {
                    try {
                        super.dispatchMessage(msg);
                    } catch (java.lang.Throwable paramMessage) {
                    }
                }
            };
        uiThread = Thread.currentThread();
        helper = UserUtil.b();
        handler.postDelayed(new com.jingdong.common.i(this), 0x1388);
        BitmapkitUtils.a = this;
        a handler = new com.jd.framework.a.a(new String[] {"m.jd.com", "m.360buy.com", "jd.com", "360buy.com"}, "GeoTrust_Global_CA.cer");
        handler.a = com.jingdong.common.e.a.a(0x9, false);
        boolean localj1 = com.jingdong.common.e.a.a(0x14, false);
        com.jd.framework.a.e.a(new com.jd.framework.a.e.b(getApplicationContext(), handler, false, true));
        try {
            boolean localboolean2 = com/jingdong/common/utils/b/e.a().a("base_conf", com/jingdong/common/utils/b/e.b());
        } catch(Exception Log.D) {(Log.D);
            Log.d(Log.D, "base_conf");
        }
        try {
            boolean localboolean3 = e.a().a("information", e.b());
        } catch(Exception Log.D) {(Log.D);
            Log.d(Log.D, "information");
        }
        this.handler.postDelayed(new j(this), 0xea60);
    }

    private static void initCBT() {
        if (Configuration.getBooleanProperty("CBTMode", Boolean.valueOf(false)).booleanValue()) {
            if (Log.D)
                Log.d("MyApplication", "initCBT()-->do");
            Properties localProperties = Configuration.getProperties();
            if (localProperties != null) {
                SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();
                String str = localSharedPreferences.getString("host", "");
                if (!TextUtils.isEmpty(str)) {
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
                if (Boolean.valueOf(localSharedPreferences.getBoolean("testMode", false)).booleanValue()) {
                    localProperties.setProperty("testMode", "true");
                } else {
                    localProperties.setProperty("testMode", "false");
                }
            }
        }
    }

    public static void killStage() {
        if (Log.D)
            Log.d("MyApplication", "MyApplication killStage() -->> ");
        CommonUtil.putBooleanToPreference(APP_UPDATE_FAILED, Boolean.valueOf(false));
        NotificationManager localNotificationManager = (NotificationManager) getInstance().getSystemService(Context.NOTIFICATION_SERVICE/*"notification"*/);
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

    public static synchronized void killStageNoUI() {
        if (Log.D)
            Log.d("MyApplication", "MyApplication killStageNoUI() -->> ");
        if (getInstance().getMainFrameActivity() == null) {
            if (Log.D)
                Log.d("MyApplication", " killSelfMethod -->> kell!");
            instance.setMainFrameActivity(null);
            instance.networkInitializationState = 0;
            try {
                ((ActivityManager) instance.getSystemService(Context.ACTIVITY_SERVICE/*"activity"*/)).restartPackage(instance.getPackageName());
            } catch (Throwable localThrowable) {
                if (Log.E)
                    Log.e("MyApplication", " -->> " + localThrowable.getMessage());
            }
        }
    }

    public static synchronized void networkSetting() {
        if (BaseApplication.mBitmapkitUtils == null) {
            java.lang.System.loadLibrary("jd-jni");
            BaseApplication.mBitmapkitUtils = new BitmapkitUtils();
            com.jingdong.common.utils.JniUtils.getSHN();
            com.jingdong.common.login.SafetyManager.compatibleOldVersion();
        }
        return;
    }

    public static void setKillSatage(_N killSatage) {
        BaseApplication.killSatage = killSatage;
    }

    public static void submitTime() {
        long appUseTime = 0L;
        if (Log.D)
            Log.d("MyApplication", "MyApplication setEndTime() -->> ");
        TimerUntil.endTime = System.currentTimeMillis();
        if (Log.D)
            System.out.println("TimerUntil.endTime=" + TimerUntil.endTime);
        SharedPreferences.Editor localEditor = CommonUtil.getJdSharedPreferences().edit();
        if (Log.D)
            System.out.println("TimerUntil startTime=" + TimerUntil.startTime + "\tendTime=" + TimerUntil.endTime);
        if ((TimerUntil.endTime - TimerUntil.startTime) / 1000L > 0L)
            appUseTime = (TimerUntil.endTime - TimerUntil.startTime) / 1000L;
        localEditor.putLong("appUseTime", appUseTime).commit();
    }

    @Override
    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        if (ProcessUtil.a())
            openWakeLock();
        MultiDex.install(this);
        instance = this;
    }

    public void closeWakeLock() {
        if (this.wakeLock != null) {
            this.wakeLock.release();
            this.wakeLock = null;
        }
    }

    public IMyActivity getCurrentMyActivity() {
        if (Log.D) {
            if (this.mainFrameActivity == null)
                Log.d("MyApplication", "xxx mainFrameActivity -->>  mainFrameActivity is null");
            else {
                Log.d("MyApplication", "xxx mainFrameActivity -->> " + this.mainFrameActivity);
            }
        }
        if (this.activity != null) {
            return this.activity;
        } else if (this.mainFrameActivity != null) {
            Activity localActivity = this.mainFrameActivity.getThisActivity();
            if (Log.D)
                Log.d("MyApplication", "xxx activity -->> " + localActivity);
            if ((localActivity instanceof IMyActivity))
                return (IMyActivity) localActivity;
        }
        return null;
    }

    public abstract Drawable getDefalutDrawble();

    public abstract Class<?> getErrorActivityClass();

    public Handler getHandler() {
        return this.handler;
    }

    public IMyActivity getHomeMainActivity() {
        return this.homeMainActivity;
    }

    public abstract ProgressBar getLoadingProgressBar();

    public abstract Class<?> getMainActivityClass();

    public IMainActivity getMainFrameActivity() {
        return this.mainFrameActivity;
    }

    public Thread getUiThread() {
        return this.uiThread;
    }

    protected void initDelay() {
        if (!Configuration.getProperty("partner").equals("jingdong"))
            return;
        if (this.helper == null)
            this.helper = UserUtil.b();
        this.helper.a(1);
    }

    public boolean isBackstage() {
        String str = getPackageName();
        List localList = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE/*"activity"*/)).getRunningTasks(1);
        if ((localList != null) && (localList.size() > 0)) {
            if (Log.D)
                Log.d(getClass().getSimpleName(), " -->> 当前堆栈顶层应用：" + ((ActivityManager.RunningTaskInfo) localList.get(0)).topActivity.getPackageName());
            if (str.equals(((ActivityManager.RunningTaskInfo) localList.get(0)).topActivity.getPackageName()))
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
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler(this));
        CommonUtil.getJdSharedPreferences().edit().putInt("runStage", 0).commit();
        startTime = SystemClock.uptimeMillis();
        startRealTime = SystemClock.elapsedRealtime();
        JDJSON.init(false);
        try {
            DPIUtil.setDensity(getResources().getDisplayMetrics().density);
        } catch (Throwable localThrowable) {
            if (Log.E)
                localThrowable.printStackTrace();
        }
        if (!ProcessUtil.a()) {//if-nez v0, :cond_2
            String str = ProcessUtil.a(Process.myPid()).trim();
            int i = 0;
            if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, "com.jingdong.app.mall:error")))
                i = 1;
            if (i != 0)
                initApp();
        } else
            initApp();

        if ((!Configuration.getBooleanProperty("beforeInitTip").booleanValue()) || (CommonUtil.getJdSharedPreferences().getBoolean("hasInitTip", false)))
            Log.install();
        return;
    }

    public void openWakeLock() {
        try {
            this.wakeLock = ((PowerManager) getSystemService(Context.POWER_SERVICE/*"power"*/)).newWakeLock(1, "MyWakelockTag");
            this.wakeLock.acquire();
            return;
        } catch (Exception localException) {
            if (Log.D)
                Log.d(TAG, localException.getLocalizedMessage());
        }
    }

    public void setCurrentMyActivity(IMyActivity paramIMyActivity) {
        this.activity = paramIMyActivity;
    }

    public void setHomeMainActivity(IMyActivity paramIMyActivity) {
        this.homeMainActivity = paramIMyActivity;
    }

    public void setMainFrameActivity(IMainActivity paramc) {
        this.mainFrameActivity = paramc;
    }

    public abstract void startMainFrameActivity(Context paramContext);

    public abstract void watchLeakFragment(Fragment paramFragment);

    public interface _N {
        public void a();
    }

}
