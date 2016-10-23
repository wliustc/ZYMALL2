package com.jingdong.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.jingdong.common.BaseApplication;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.HttpGroupWithNPS;
import com.jingdong.common.utils.JDFrescoUtils;
import com.jingdong.common.utils.cache.GlobalImageCache;
import com.zy.app.mall.R;
import com.zy.common.JDSoftReference;
import com.zy.common.frame.IDestroyListener;
import com.zy.common.frame.ILogoutListener;
import com.zy.common.frame.IMyActivity;
import com.zy.common.frame.IPauseListener;
import com.zy.common.frame.IResumeListener;
import com.zy.common.frame.JDHandler;
import com.zy.common.frame.Record;
import com.zy.common.res.StringUtil;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;
import com.zy.common.utils.NetUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Robin on 2016/4/14.
 */
@SuppressLint({"NewApi"})
public class BaseActivity  extends FragmentActivity implements IMyActivity {
    public static final String ISFROMNF = "isFromNF";
    private static AlertDialog.Builder hintDialogBuilder;
    public static final String[] mIgnoreModels = { "MI-ONE Plus" };
    private final String TAG = BaseActivity.class.getSimpleName();
    private LocalActivityManager activityManager;
    private AssetManager assetManager;
    private int counter;
    private ArrayList<IDestroyListener> destroyListenerList = new ArrayList();
    private int guideResourceId = 0;
    private JDHandler handler = new JDHandler();
    private FrameLayout imageViewLayout;
    private boolean isCanResend = true;
    protected boolean isFromNF = false;
    protected boolean isOnNetwork = true;
    private boolean isPrevNotInRecord;
    protected boolean isSpecial = false;
    protected boolean isUseBasePV = true;
    private boolean jump;
    private RelativeLayout layout;
    protected ArrayList<ILogoutListener> logoutListenerList = new ArrayList();
    private Intent mData = new Intent();
    protected HttpGroupWithNPS mHttpGroupWithNPS;
    private ImageView mTitleBack;
    private Thread mUiThread;
    private View model;
    public boolean needCheckNet = true;
    private boolean needResetResourceConfig;
    protected String page_id = "";
    private ArrayList<IPauseListener> pauseListenerList = new ArrayList();
    private HashMap<String, Integer> recordIdAndRadioId = new HashMap();
    protected ArrayList<Record> recordList = new ArrayList();
    private Resources resources;
    private ArrayList<IResumeListener> resumeListenerList = new ArrayList();
    private ViewGroup rootFrameLayout;
    private ViewGroup rootView;
    private SharedPreferences sharedPreferences;
    protected String shop_id = "";
    private ArrayList<Record> singleInstanceRecordList = new ArrayList();
    private JDSoftReference<Activity> softReference;
    private long stopTime;
    private ViewGroup subRootView;
    private Resources.Theme theme;
    protected int type = 1;
    protected int yDistance;


    private static void catchToastTip(Activity paramActivity, Intent paramIntent)
    {
        Object localObject = StringUtil.not_find_other;
        if (TextUtils.equals(paramIntent.getAction(), "android.intent.action.VIEW"))
        {
            String str = paramIntent.getScheme();
            paramIntent = (Intent)localObject;
            if (str != null)
                if (!str.equals("http"))
                {
                    paramIntent = (Intent)localObject;
                    if (!str.equals("https"));
                }
                else
                {
                    paramIntent = StringUtil.not_find_browser;
                }
        }
        while (true)
        {
            localObject = (BaseActivity)BaseApplication.getInstance().getCurrentMyActivity();
            if (localObject != null)
                ((BaseActivity)localObject).post(new g(paramActivity, paramIntent));
            return;
            if (TextUtils.equals(paramIntent.getAction(), "android.intent.action.GET_CONTENT"))
            {
                paramIntent = StringUtil.not_find_gallery;
                continue;
            }
            if (TextUtils.equals(paramIntent.getAction(), "android.media.action.IMAGE_CAPTURE"))
            {
                paramIntent = StringUtil.not_find_camera;
                continue;
            }
            paramIntent = (Intent)localObject;
        }
    }

    private void clearHistoryRecord(Intent paramIntent)
    {
        Record localg = new Record();
        localg.a(paramIntent);
        while (this.recordList.remove(localg))
        {
            if (!Log.D)
                continue;
            Log.d("MyActivity", "clearHistoryRecord() r -->> " + localg);
        }
    }

    private void doJump()
    {
        this.jump = false;
        removeRecordTop();
    }

    private Integer findRadioId(String paramString)
    {
        return (Integer)this.recordIdAndRadioId.get(paramString);
    }

    private Record findsingleInstanceRecord(Intent paramIntent)
    {
        Iterator localIterator = this.singleInstanceRecordList.iterator();
        while (localIterator.hasNext())
        {
            Record localg = (Record)localIterator.next();
            if (localg.b().getComponent().getClassName().equals(paramIntent.getComponent().getClassName()))
                return localg;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private View getModel()
    {
        float f;
        int i;
        if (isActivityInFrame())
        {
            f = 45.0F;
            i = DPIUtil.dip2px(f);
            if (!this.isSpecial)
                break label160;
            i = this.yDistance;
        }
        label160:
        while (true)
            while (true)
            {
                if (this.model == null);
                try
                {
                    this.model = ImageUtil.inflate(R.layout.app_network_model, null);
                    if (this.model == null)
                    {
                        return null;
                        f = 70.0F;
                    }
                }
                catch (Throwable localThrowable)
                {
                    while (true)
                    {
                        if (!Log.E)
                            continue;
                        localThrowable.printStackTrace();
                    }
                    if (this.layout == null)
                    {
                        this.layout = ((RelativeLayout)this.model.findViewById(R.id.app_network_model_layout));
                        this.layout.setOnClickListener(new b(this));
                    }
                    if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 11)
                        this.layout.setY(i);
                    while (true)
                    {
                        return this.model;
                        ((AbsoluteLayout.LayoutParams)this.layout.getLayoutParams()).y = i;
                    }
                }
            }
    }

    private Integer getNavigationId(Intent paramIntent)
    {
        if (isNavigation(paramIntent))
            return Integer.valueOf(paramIntent.getIntExtra("com.360buy:navigationId", 0));
        return null;
    }

    private ViewGroup getRootFrameLayout()
    {
        if (this.rootFrameLayout != null)
            return this.rootFrameLayout;
        this.rootFrameLayout = ((ViewGroup)getWindow().peekDecorView());
        if (this.rootFrameLayout == null);
        try
        {
            Thread.sleep(50L);
            label39: this.rootFrameLayout = getRootFrameLayout();
            return this.rootFrameLayout;
        }
        catch (InterruptedException localInterruptedException)
        {
            break label39;
        }
    }

    private HashMap<String, Object> getTaskId(Intent paramIntent)
    {
        return (HashMap)paramIntent.getSerializableExtra("com.360buy:taskIdFlag");
    }

    private void initHardAcclCheck()
    {
        Object localObject = Build.MODEL;
        String[] arrayOfString = mIgnoreModels;
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
            if (!arrayOfString[i].equalsIgnoreCase((String)localObject));
        while (true)
        {
            return;
            i += 1;
            break;
            try
            {
                localObject = getPackageManager().getActivityInfo(getComponentName(), 128);
                if (((ActivityInfo)localObject).metaData != null)
                {
                    localObject = ((ActivityInfo)localObject).metaData.get("hardwareAccelerated");
                    if (localObject != null)
                    {
                        boolean bool = ((Boolean)localObject).booleanValue();
                        if (!bool)
                        {
                            i = 1;
                            if ((i != 0) || (!com.jingdong.common.e.a.a(21, false)))
                                continue;
                            try
                            {
                                getWindow().setFlags(16777216, 16777216);
                                return;
                            }
                            catch (Exception localException1)
                            {
                                localException1.printStackTrace();
                                return;
                            }
                        }
                    }
                }
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
                while (true)
                {
                    localNameNotFoundException.printStackTrace();
                    i = 0;
                }
            }
            catch (Exception localException2)
            {
                while (true)
                {
                    localException2.printStackTrace();
                    i = 0;
                }
            }
        }
    }

    private boolean isJump()
    {
        return this.jump;
    }

    private boolean isNavigation(Intent paramIntent)
    {
        return paramIntent.getBooleanExtra("com.360buy:navigationFlag", false);
    }

    private void startActivityForResultNoExceptionForFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
    {
        if ((paramIntent == null) || (paramFragment == null));
        do
        {
            return;
            try
            {
                paramFragment.startActivityForResult(paramIntent, paramInt);
                return;
            }
            catch (ActivityNotFoundException paramFragment)
            {
                if (Log.D)
                    Log.e(this.TAG, "startActivityForResultNoException -->>  ActivityNotFoundException:" + paramFragment.getMessage());
                catchToastTip(this, paramIntent);
                return;
            }
            catch (Exception paramFragment)
            {
            }
        }
        while (!Log.D);
        Log.e(this.TAG, "startActivityForResultNoException -->> Exception:" + paramFragment.getMessage());
    }

    @Override
    public synchronized void addDestroyListener(IDestroyListener parama)
    {
            if (this.destroyListenerList != null)
                this.destroyListenerList.add(parama);
            return;
    }

    protected void addGuideImage(ViewGroup paramViewGroup)
    {
        if (Log.D)
            Log.d(this.TAG, "addGuideImage -->> ");
        this.rootView = paramViewGroup;
        if (Log.D)
            Log.d(this.TAG, "view -->> " + this.rootView);
        if (this.rootView == null);
        do
        {
            do
            {
                return;
                if (!Log.D)
                    continue;
                Log.d(this.TAG, "guideResourceId -->> " + this.guideResourceId);
            }
            while (this.guideResourceId == 0);
            this.imageViewLayout = new FrameLayout(this);
            paramViewGroup = new FrameLayout.LayoutParams(-2, -2);
            paramViewGroup.gravity = 48;
            paramViewGroup.height = DPIUtil.getHeight();
            paramViewGroup.topMargin = getResources().getDimensionPixelOffset(R.dimen.guide_image_margin);
            SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this);
            try
            {
                localSimpleDraweeView.setImageResource(this.guideResourceId);
                this.imageViewLayout.addView(localSimpleDraweeView, paramViewGroup);
                this.imageViewLayout.setBackgroundColor(getResources().getColor(R.color.slide_prompt_bg));
                this.imageViewLayout.getBackground().setAlpha(200);
                CommonUtil.setIsGuided(getClass().getName());
                this.imageViewLayout.setOnTouchListener(new d(this));
                this.rootView.addView(this.imageViewLayout, new ViewGroup.LayoutParams(-1, -1));
                this.rootView.invalidate();
                return;
            }
            catch (Throwable paramViewGroup)
            {
            }
        }
        while (!Log.E);
        paramViewGroup.printStackTrace();
    }

    protected void addGuideImage(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, ImageView.ScaleType paramScaleType, boolean paramBoolean)
    {
        if (Log.D)
            Log.d(this.TAG, "addGuideImage -->> ");
        this.rootView = paramViewGroup;
        if (Log.D)
            Log.d(this.TAG, "view -->> " + this.rootView);
        if (this.rootView == null);
        do
        {
            do
            {
                return;
                if (!Log.D)
                    continue;
                Log.d(this.TAG, "guideResourceId -->> " + this.guideResourceId);
            }
            while (this.guideResourceId == 0);
            this.imageViewLayout = new FrameLayout(this);
            paramViewGroup = new FrameLayout.LayoutParams(paramInt2, paramInt3);
            paramViewGroup.gravity = paramInt1;
            paramViewGroup.height = DPIUtil.getHeight();
            if (paramBoolean)
                paramViewGroup.topMargin = getStatusHeight();
            SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this);
            try
            {
                localSimpleDraweeView.setImageResource(this.guideResourceId);
                if (paramScaleType != null)
                    localSimpleDraweeView.setScaleType(paramScaleType);
                this.imageViewLayout.addView(localSimpleDraweeView, paramViewGroup);
                this.imageViewLayout.setBackgroundColor(getResources().getColor(R.color.slide_prompt_bg));
                this.imageViewLayout.getBackground().setAlpha(200);
                CommonUtil.setIsGuided(getClass().getName());
                this.imageViewLayout.setOnTouchListener(new e(this));
                this.rootView.addView(this.imageViewLayout, new ViewGroup.LayoutParams(-1, -1));
                this.rootView.invalidate();
                return;
            }
            catch (Throwable paramViewGroup)
            {
            }
        }
        while (!Log.E);
        paramViewGroup.printStackTrace();
    }

    public void addHttpGroupWithNPSSetting(HttpGroup.HttpSetting paramHttpSetting)
    {
        getHttpGroupWithNPSGroup().add(paramHttpSetting);
    }

    @Override
    public synchronized void addLogoutListener(ILogoutListener paramb)
    {
            if (this.logoutListenerList != null)
                this.logoutListenerList.add(paramb);
            return;
    }

    @Override
    public synchronized void addPauseListener(IPauseListener paramd)
    {
            if (this.pauseListenerList != null)
                this.pauseListenerList.add(paramd);
            return;
    }

    @Override
    public synchronized void addResumeListener(IResumeListener parame)
    {
            if (this.resumeListenerList != null)
                this.resumeListenerList.add(parame);
            return;
    }

    public void alert(int paramInt)
    {
        monitorenter;
        try
        {
            if (hintDialogBuilder == null)
            {
                AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
                hintDialogBuilder = localBuilder;
                localBuilder.setTitle(StringUtil.prompt);
                hintDialogBuilder.setMessage(paramInt);
                hintDialogBuilder.setPositiveButton(StringUtil.ok, new f(this));
            }
            hintDialogBuilder.show();
            return;
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    public void attemptRunOnUiThread(Runnable paramRunnable)
    {
        if (Thread.currentThread() != getUiThread())
        {
            post(paramRunnable);
            return;
        }
        paramRunnable.run();
    }

    public void canNotResend()
    {
        this.isCanResend = false;
    }

    public void checkNetwork()
    {
        if (!this.isOnNetwork)
            return;
        if (NetUtils.isNetworkAvailable())
        {
            hideModel();
            return;
        }
        showModel();
    }

    public void checkNetwork(int paramInt)
    {
        if (!this.needCheckNet)
            return;
        checkNetwork();
    }

    public void clearJump()
    {
        if (isJump())
            this.jump = false;
    }

    public HashMap<String, Object> createTaskId(Intent paramIntent)
    {
        HashMap localHashMap = new HashMap();
        localHashMap.put("className", paramIntent.getComponent().getClassName());
        return localHashMap;
    }

    public void finish()
    {
        hideSoftInput();
        super.finish();
    }

    public AssetManager getAssets()
    {
        if (CommonUtil.getPlugOn())
        {
            if (this.assetManager == null)
                return super.getAssets();
            return this.assetManager;
        }
        return super.getAssets();
    }

    public boolean getBooleanFromPreference(String paramString)
    {
        return this.sharedPreferences.getBoolean(paramString, false);
    }

    public boolean getBooleanFromPreference(String paramString, boolean paramBoolean)
    {
        return this.sharedPreferences.getBoolean(paramString, paramBoolean);
    }

    public BaseActivity getCurrentMyActivity()
    {
        return (BaseActivity)BaseApplication.getInstance().getCurrentMyActivity();
    }

    @Override
    public Handler getHandler()
    {
        return this.handler;
    }

    public HttpGroup getHttpGroupWithNPSGroup()
    {
        if (this.mHttpGroupWithNPS != null)
        {
            HttpGroup localHttpGroup = this.mHttpGroupWithNPS.getHttpGroup();
            if (localHttpGroup != null)
            {
                if (localHttpGroup.getHttpGroupSetting() != null)
                    localHttpGroup.getHttpGroupSetting().setMyActivity(this);
                return localHttpGroup;
            }
        }
        return getHttpGroupaAsynPool();
    }

    @Override
    public HttpGroup getHttpGroupaAsynPool()
    {
        return getHttpGroupaAsynPool(1000);
    }

    @Override
    public HttpGroup getHttpGroupaAsynPool(int paramInt)
    {
        HttpGroup.HttpGroupSetting localHttpGroupSetting = new HttpGroup.HttpGroupSetting();
        localHttpGroupSetting.setMyActivity(this);
        localHttpGroupSetting.setType(paramInt);
        localHttpGroupSetting.setProgressBarRootLayout(getSubRootView());
        return getHttpGroupaAsynPool(localHttpGroupSetting);
    }

    public HttpGroup getHttpGroupaAsynPool(HttpGroup.HttpGroupSetting paramHttpGroupSetting)
    {
        paramHttpGroupSetting = HttpGroup.getHttpGroup(paramHttpGroupSetting);
        addDestroyListener(paramHttpGroupSetting);
        return paramHttpGroupSetting;
    }

    public Intent getJDData()
    {
        return this.mData;
    }

    public String getPageParam()
    {
        return "";
    }

    public Map<String, String> getParams()
    {
        return null;
    }

    public String getParamsString()
    {
        Map localMap = getParams();
        if (localMap == null)
            return "";
        return localMap.toString();
    }

    public Resources getResources()
    {
        monitorenter;
        try
        {
            Resources localResources;
            if (CommonUtil.getPlugOn())
                if (this.resources == null)
                    localResources = super.getResources();
            while (true)
            {
                if (this.needResetResourceConfig)
                {
                    Configuration localConfiguration = new Configuration();
                    localConfiguration.setToDefaults();
                    localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
                    this.needResetResourceConfig = false;
                }
                return localResources;
                localResources = this.resources;
                continue;
                localResources = super.getResources();
            }
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    public int getStatusHeight()
    {
        Object localObject1 = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        int j = ((Rect)localObject1).top;
        int i = j;
        if (j == 0);
        try
        {
            localObject1 = Class.forName("com.android.internal.R$dimen");
            Object localObject2 = ((Class)localObject1).newInstance();
            i = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
            i = getResources().getDimensionPixelSize(i);
            return i;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
            localClassNotFoundException.printStackTrace();
            return j;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
            localIllegalAccessException.printStackTrace();
            return j;
        }
        catch (InstantiationException localInstantiationException)
        {
            localInstantiationException.printStackTrace();
            return j;
        }
        catch (NumberFormatException localNumberFormatException)
        {
            localNumberFormatException.printStackTrace();
            return j;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
            localIllegalArgumentException.printStackTrace();
            return j;
        }
        catch (SecurityException localSecurityException)
        {
            localSecurityException.printStackTrace();
            return j;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
            localNoSuchFieldException.printStackTrace();
        }
        return j;
    }

    @Override
    public String getStringFromPreference(String paramString)
    {
        return this.sharedPreferences.getString(paramString, "");
    }

    public String getStringFromPreference(String paramString1, String paramString2)
    {
        return this.sharedPreferences.getString(paramString1, paramString2);
    }

    public ViewGroup getSubRootView()
    {
        return this.subRootView;
    }

    public Resources.Theme getTheme()
    {
        if (CommonUtil.getPlugOn())
        {
            if (this.theme != null)
                return this.theme;
            return super.getTheme();
        }
        return super.getTheme();
    }

    @Override
    public Activity getThisActivity()
    {
        return this;
    }

    public Thread getUiThread()
    {
        return this.mUiThread;
    }

    protected void hideModel()
    {
        ViewGroup localViewGroup = getRootFrameLayout();
        View localView = getModel();
        if (localView == null);
        do
            return;
        while (localViewGroup.indexOfChild(localView) == -1);
        localViewGroup.removeView(localView);
        localViewGroup.invalidate();
    }

    public void hideSoftInput()
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    public boolean isActivityInFrame()
    {
        Activity localActivity = getParent();
        return (localActivity != null) && ((localActivity instanceof q));
    }

    public boolean isClearHistory(Intent paramIntent)
    {
        return paramIntent.getBooleanExtra("com.360buy:clearHistoryFlag", false);
    }

    public boolean isResend(Intent paramIntent)
    {
        return paramIntent.getBooleanExtra("com.360buy:resendFlag", false);
    }

    public boolean isSingleInstance(Intent paramIntent)
    {
        return paramIntent.getBooleanExtra("com.360buy:singleInstanceFlag", false);
    }

    public boolean isUseHistoryRecord(Intent paramIntent)
    {
        return paramIntent.getBooleanExtra("com.360buy:useHistoryFlag", false);
    }

    public void markJump()
    {
        this.jump = true;
    }

    public void noShowAgain()
    {
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt1 == 1001) && (paramInt2 == 0))
            BaseApplication.exitAll();
    }

    public void onBackPressed()
    {
        super.onStateNotSaved();
        super.onBackPressed();
    }

    protected void onClickEvent(String paramString)
    {
        if (Log.D)
            Log.d(this.TAG, "onClickEvent clickId-->> " + paramString);
        JDMtaUtils.onClick(getBaseContext(), paramString, getClass().getSimpleName());
    }

    protected void onClickEvent(String paramString1, String paramString2)
    {
        if (Log.D)
        {
            Log.d(this.TAG, "onClickEvent clickId-->> " + paramString1);
            Log.d(this.TAG, "onClickEvent value-->> " + paramString2);
        }
        JDMtaUtils.onClick(getBaseContext(), paramString1, getClass().getName(), paramString2);
    }

    protected void onClickEvent(String paramString1, String paramString2, String paramString3)
    {
        if (Log.D)
        {
            Log.d(this.TAG, "onClickEvent clickId-->> " + paramString1);
            Log.d(this.TAG, "onClickEvent event_param-->> " + paramString2);
            Log.d(this.TAG, "onClickEvent page_param-->> " + paramString3);
        }
        JDMtaUtils.onClick(getBaseContext(), paramString1, getClass().getName(), paramString2, paramString3);
    }

    protected void onClickEventWithPageId(String paramString1, String paramString2)
    {
        if (Log.D)
        {
            Log.d(this.TAG, "onClickEvent clickId-->> " + paramString1);
            Log.d(this.TAG, "onClickEvent pageId-->> " + paramString2);
        }
        JDMtaUtils.onClickWithPageId(getBaseContext(), paramString1, getClass().getSimpleName(), paramString2);
    }

    protected void onClickEventWithPageId(String paramString1, String paramString2, String paramString3, String paramString4)
    {
        if (Log.D)
        {
            Log.d(this.TAG, "onClickEvent clickId-->> " + paramString1);
            Log.d(this.TAG, "onClickEvent event_param-->> " + paramString2);
            Log.d(this.TAG, "onClickEvent page_param-->> " + paramString3);
            Log.d(this.TAG, "onClickEvent page_id-->> " + paramString4);
        }
        JDMtaUtils.sendCommonData(getBaseContext(), paramString1, paramString2, "onClick", getClass().getSimpleName(), paramString3, "", "", paramString4, "");
    }

    public void onConfigurationChanged(Configuration paramConfiguration)
    {
        if (paramConfiguration.fontScale > 1.0F)
        {
            paramConfiguration.setToDefaults();
            this.needResetResourceConfig = true;
        }
        super.onConfigurationChanged(paramConfiguration);
    }

    @Override
    protected void onCreate(Bundle paramBundle)
    {
        if (Log.D)
        {
            testStack();
            Log.d(this.TAG, "onCreate() -->> " + getClass().getName());
        }
        _O.getInstance(this);
        this.sharedPreferences = CommonUtil.getJdSharedPreferences();
        this.sharedPreferences.edit().putInt("runStage", 1).commit();
        this.softReference = new p(this);
        this.softReference.a(getClass().getName());
        a.a(this.softReference);
        com.jingdong.common.utils.crash.e.a(getIntent());
        BaseApplication.getInstance().setCurrentMyActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.mUiThread = Thread.currentThread();
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        super.onCreate(paramBundle);
        this.sharedPreferences = CommonUtil.getJdSharedPreferences();
        if (getIntent() != null)
            this.isFromNF = getIntent().getBooleanExtra("isFromNF", false);
        initHardAcclCheck();
    }

    @Override
    protected void onDestroy()
    {
        if (Log.D)
            Log.d("MyActivity", "onDestroy() TaskId = " + getTaskId() + " -->> " + getClass().getName());
        super.onDestroy();
        a.b(this.softReference);
        synchronized (this)
        {
            if (this.destroyListenerList != null){//if-eqz v0, :cond_2
                Iterator localIterator = this.destroyListenerList.iterator();
                while (localIterator.hasNext())
                    ((IDestroyListener)localIterator.next()).onDestroy();
                this.destroyListenerList = null;
            }
                this.pauseListenerList = null;
                this.resumeListenerList = null;

        }
        if (this.mHttpGroupWithNPS != null)
        {
            this.mHttpGroupWithNPS.destory();
            this.mHttpGroupWithNPS = null;
        }
    }

    @Override
    public void onHideModal()
    {
    }

    @Override
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        if (paramInt == 4)
        {
            if (removeGuideView())
                return true;
            if ((paramInt == 4) && (this.isFromNF))
            {
                finish();
                if (BaseApplication.getInstance().getMainFrameActivity() == null)
                {
                    BaseApplication.getInstance().startMainFrameActivity(this);
                    return true;
                }
                super.onKeyDown(paramInt, paramKeyEvent);
                return true;
            }
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    @Override
    protected synchronized void onPause()
    {
        if (Log.D)
            Log.d("MyActivity", "onPause() TaskId = " + getTaskId() + " -->> " + getClass().getName());
        super.onPause();
        synchronized (this)
        {
            if (this.pauseListenerList != null)
            {
                Iterator localIterator = this.pauseListenerList.iterator();
                while (localIterator.hasNext())
                    ((IPauseListener)localIterator.next()).onPause();
            }
        }

    }

    public void onRefresh()
    {
    }

    @Override
    protected void onRestart()
    {
        com.jingdong.common.utils.crash.e.a(getIntent());
        if (Log.D)
            Log.d("MyActivity", "onRestart() TaskId = " + getTaskId() + " -->> " + getClass().getName());
        if (System.currentTimeMillis() - this.stopTime > 86400000L)
        {
            if (Log.D)
                Log.d("MyActivity", "onRestart() -->> update cache time");
            y.a();
        }
        super.onRestart();
    }

    @Override
    protected void onResume()
    {
        if (Log.D)
            Log.d("MyActivity", "Resume() TaskId = " + getTaskId() + " -->> " + getClass().getName());
        super.onResume();
        BaseApplication.getInstance().setCurrentMyActivity(this);
        if (this.resumeListenerList == null)
            return;
        label300:
        while (true)
        {
            try
            {
                this.isCanResend = true;
                int k = this.resumeListenerList.size();
                int j = 0;
                int i = 0;
                if (j >= k)
                    continue;
                int m = this.resumeListenerList.size();
                ((IResumeListener)this.resumeListenerList.get(i)).onResume();
                int n = this.resumeListenerList.size();
                if (m != n)
                    break label300;
                i += 1;
                j += 1;
                continue;
            }
            catch (Exception localException)
            {
                if (!Log.D)
                    continue;
                Log.e(this.TAG, "myActivity onResume -->> Exception:" + localException.getMessage());
                checkNetwork(this.type);
                el.a(this);
            }
            if (!this.isUseBasePV)
                break;
            JDMtaUtils.sendPagePv(this, this, getPageParam(), this.page_id, this.shop_id);
            if (!Log.D)
                break;
            Log.d(this.TAG, "page_id==" + this.page_id);
            Log.d(this.TAG, "page_id==" + this.shop_id);
            Log.d(this.TAG, "getPageParam()==" + getPageParam());
            return;
        }
    }

    @Override
    public boolean onSearchRequested()
    {
        if (Log.I)
            Log.i("test", "onSearchRequested++++my");
        return true;
    }

    @Override
    public void onShowModal()
    {
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        if (Log.D)
            Log.d("MyActivity", "onStart() TaskId = " + getTaskId() + " -->> " + getClass().getName());
    }

    @Override
    protected void onStop()
    {
        if (Log.D)
            Log.d("MyActivity", "onStop() TaskId = " + getTaskId() + " -->> " + getClass().getName());
        this.stopTime = System.currentTimeMillis();
        super.onStop();
    }

    @SuppressLint({"NewApi"})
    public void onTitleBack()
    {
        if (Log.D)
            Log.d("MyActivity", " -->> mTitleBack onClick : ");
        if (removeGuideView());
        do
        {
            while (true)
            {
                return;
                if (!this.isFromNF)
                    break;
                if (Log.D)
                    Log.d("MyActivity", " -->>mTitleBack onClick : isBackToHome ");
                finish();
                if (BaseApplication.getInstance().getMainFrameActivity() == null)
                {
                    BaseApplication.getInstance().startMainFrameActivity(this);
                    return;
                }
                try
                {
                    onBackPressed();
                    return;
                }
                catch (Exception localException1)
                {
                }
                if (!Log.D)
                    continue;
                localException1.printStackTrace();
                return;
            }
            try
            {
                onBackPressed();
                return;
            }
            catch (Exception localException2)
            {
            }
        }
        while (!Log.D);
        localException2.printStackTrace();
    }

    @Override
    public void post(Runnable paramRunnable)
    {
        if (isFinishing())
            return;
        this.handler.post(paramRunnable);
    }

    @Override
    public void post(Runnable paramRunnable, int paramInt)
    {
        if (isFinishing())
            return;
        this.handler.postDelayed(paramRunnable, paramInt);
    }

    @Override
    public void putBooleanToPreference(String paramString, Boolean paramBoolean)
    {
        this.sharedPreferences.edit().putBoolean(paramString, paramBoolean.booleanValue()).commit();
    }

    public void putStringToPreference(String paramString1, String paramString2)
    {
        this.sharedPreferences.edit().putString(paramString1, paramString2).commit();
    }

    public void refreshProductListByFilterData(Intent paramIntent)
    {
    }

    @Override
    public  void removeDestroyListener(IDestroyListener parama)
    {
            if (this.destroyListenerList != null)
                this.destroyListenerList.remove(parama);
            return;
    }

    public boolean removeGuideView()
    {
        if ((this.imageViewLayout != null) && (this.rootView != null) && (this.rootView.isShown()))
        {
            this.rootView.removeView(this.imageViewLayout);
            this.rootView = null;
            this.imageViewLayout = null;
            return true;
        }
        return false;
    }

    @Override
    public synchronized void removeLogoutListener(ILogoutListener paramb)
    {
            if (this.logoutListenerList != null)
                this.logoutListenerList.remove(paramb);
            return;
    }

    @Override
    public synchronized void removePauseListener(IPauseListener paramd)
    {
            if (this.pauseListenerList != null)
                this.pauseListenerList.remove(paramd);
            return;
    }

    public void removeRecordTop()
    {
        if (this.isPrevNotInRecord)
            this.isPrevNotInRecord = false;
        Record localg;
        do
        {
            do
                return;
            while (this.recordList.isEmpty());
            localg = (Record)this.recordList.remove(0);
        }
        while (isSingleInstance(localg.b()));
        this.activityManager.destroyActivity(localg.a(), true);
    }

    @Override
    public synchronized void removeResumeListener(IResumeListener parame)
    {
            if (this.resumeListenerList != null)
                this.resumeListenerList.remove(parame);
            return;
    }

    protected void setBackground(View paramView, Drawable paramDrawable)
    {
        if ((paramView == null) || (paramDrawable == null))
            return;
        if (Build.VERSION.SDK_INT >= 16)
        {
            paramView.setBackground(paramDrawable);
            return;
        }
        paramView.setBackgroundDrawable(paramDrawable);
    }

    public void setContentView(int paramInt)
    {
        try
        {
            super.setContentView(paramInt);
            return;
        }
        catch (Throwable localThrowable)
        {
            GlobalImageCache.getLruBitmapCache().a();
            super.setContentView(paramInt);
        }
    }

    protected void setGuideResId(int paramInt)
    {
        this.guideResourceId = paramInt;
    }

    public void setJDData(Intent paramIntent)
    {
        this.mData = paramIntent;
    }

    public void setJDResult(int paramInt)
    {
        if (getJDData() != null)
        {
            setResult(paramInt, getJDData());
            return;
        }
        setResult(paramInt);
    }

    public void setModelYDistance(int paramInt)
    {
        paramInt = Math.abs(paramInt);
        float f;
        int i;
        if (isActivityInFrame())
        {
            f = 45.0F;
            i = DPIUtil.dip2px(f) - paramInt;
            if (!isActivityInFrame())
                break label92;
            paramInt = 0;
            label32: if (i >= paramInt)
                break label102;
        }
        while (true)
        {
            this.yDistance = paramInt;
            if (Log.D)
                Log.d(this.TAG, " view scroll from top distance == " + this.yDistance);
            this.isSpecial = true;
            checkNetwork();
            return;
            f = 70.0F;
            break;
            label92: paramInt = DPIUtil.dip2px(25.0F);
            break label32;
            label102: paramInt = i;
        }
    }

    public void setNetworkModel(boolean paramBoolean)
    {
        this.isOnNetwork = paramBoolean;
    }

    protected void setPageId(String paramString)
    {
        this.page_id = paramString;
    }

    protected void setShopId(String paramString)
    {
        this.shop_id = paramString;
    }

    public void setSubRootView(ViewGroup paramViewGroup)
    {
        this.subRootView = paramViewGroup;
    }

    public void setTitleBack(ImageView paramImageView)
    {
        setTitleBack(paramImageView, null);
    }

    public void setTitleBack(ImageView paramImageView, Runnable paramRunnable)
    {
        this.mTitleBack = paramImageView;
        this.mTitleBack.setVisibility(0);
        this.mTitleBack.setOnClickListener(new c(this, paramRunnable));
    }

    protected void setUseBasePV(boolean paramBoolean)
    {
        this.isUseBasePV = paramBoolean;
    }

    protected void showModel()
    {
        ViewGroup localViewGroup = getRootFrameLayout();
        View localView = getModel();
        if (localView == null);
        do
            return;
        while (localViewGroup.indexOfChild(localView) != -1);
        localViewGroup.addView(localView);
        localViewGroup.invalidate();
    }

    public void startActivityForResultForFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
    {
        startActivityForResultNoExceptionForFragment(paramFragment, paramIntent, paramInt);
    }

    @Override
    public void startActivityForResultNoException(Intent paramIntent, int paramInt)
    {
        startActivityForResultNoExceptionStatic(this, paramIntent, paramInt);
    }

    @Override
    public void startActivityForResultNoExceptionStatic(Activity paramActivity, Intent paramIntent, int paramInt)
    {
        if ((paramIntent == null) || (paramActivity == null));
        do
        {
            return;
            try
            {
                paramActivity.startActivityForResult(paramIntent, paramInt);
                return;
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
                if (Log.D)
                {
                    localActivityNotFoundException.printStackTrace();
                    Log.e(this.TAG, "startActivityForResultNoException -->>  ActivityNotFoundException:" + localActivityNotFoundException.getMessage());
                }
                catchToastTip(paramActivity, paramIntent);
                return;
            }
            catch (Exception paramActivity)
            {
            }
        }
        while (!Log.D);
        paramActivity.printStackTrace();
        Log.e(this.TAG, "startActivityForResultNoException -->> Exception:" + paramActivity.getMessage());
    }

    @Override
    public void startActivityInFrame(Intent paramIntent)
    {
        if (Log.D)
            Log.d("BaseActivity", "startActivityInFrame() -->> ");
        startActivity(paramIntent);
    }

    @Override
    public void startActivityInFrameWithNoNavigation(Intent paramIntent)
    {
        paramIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
        startActivityInFrame(paramIntent);
    }

    @Override
    public void startActivityNoException(Intent paramIntent)
    {
        startActivityForResultNoException(paramIntent, -1);
    }

    public void startSingleActivityInFrame(Intent paramIntent)
    {
        if (Log.D)
            Log.d("MyActivity", "startSingleActivityInFrame() -->> ");
        getCurrentMyActivity().startActivityInFrame(paramIntent);
    }

    public void startSubActivity(Intent paramIntent)
    {
        startActivity(paramIntent);
    }

    public void startTaskActivityInFrame(Intent paramIntent)
    {
        if (Log.D)
            Log.d("MyActivity", "startTaskActivityInFrame() -->> " + paramIntent);
        startTaskActivityInFrame(paramIntent, createTaskId(paramIntent));
    }

    public void startTaskActivityInFrame(Intent paramIntent, HashMap<String, Object> paramHashMap)
    {
        if (Log.D)
            Log.d("MyActivity", "startTaskActivityInFrame() -->> " + paramIntent + "|" + paramHashMap);
        paramIntent.putExtra("com.360buy:taskIdFlag", paramHashMap);
        paramIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
        startActivityInFrame(paramIntent);
    }

    public void testStack()
    {
        Iterator localIterator = ((ActivityManager)getSystemService(ACTIVITY_SERVICE)).getRunningTasks(1000).iterator();
        while (localIterator.hasNext())
        {
            String str = ((ActivityManager.RunningTaskInfo)localIterator.next()).baseActivity.getClassName();
            Log.d("activity_all_name", str);
            if ((str.startsWith("com.jingdong")) || (str.startsWith("com.jd")) || (str.startsWith("com.zy")))
                Log.d("activity_name", str);
        }
    }

    protected void updateButtonEnable(Button paramButton, boolean paramBoolean)
    {
        if (paramButton == null)
            return;
        post(new Runnable(){//h(this, paramButton, paramBoolean)
            @Override
            public void run() {
                this.a.setEnabled(this.b);
            }
        });
    }

    public static final class _O
    {
        private static _O instance = null;

        private _O(Context paramContext)
        {
            JDMtaUtils.init(paramContext.getApplicationContext());
            ImagePipelineConfig.Builder builder = ImagePipelineConfig.newBuilder(paramContext.getApplicationContext()).setBitmapsConfig(Bitmap.Config.RGB_565);

            //Fresco.initialize(paramContext.getApplicationContext(), builder.build()/*, false*/);
            JDFrescoUtils.initialize(paramContext.getApplicationContext(), builder.build(), false);
        }

        public static _O getInstance(Context paramContext)
        {
            if (instance == null){
                synchronized (_O.class){
                    if (instance == null)
                        instance = new _O(paramContext);

                }
            }
                return instance;

        }
    }
}
