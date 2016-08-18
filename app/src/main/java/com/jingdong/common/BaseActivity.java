package com.jingdong.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.jingdong.common.BaseApplication;
import com.jingdong.common.utils.JDFrescoUtils;
import com.zy.common.frame.IDestroyListener;
import com.zy.common.frame.ILogoutListener;
import com.zy.common.frame.IMyActivity;
import com.zy.common.frame.IPauseListener;
import com.zy.common.frame.IResumeListener;
import com.zy.common.frame.JDHandler;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

import java.util.Iterator;

/**
 * Created by Robin on 2016/4/14.
 */
public class BaseActivity  extends FragmentActivity implements IMyActivity {
    public static final String ISFROMNF = "isFromNF";
    private static AlertDialog.Builder hintDialogBuilder;
    public static final String[] mIgnoreModels = { "MI-ONE Plus" };
    private final String TAG = BaseActivity.class.getSimpleName();
    private JDHandler handler = new JDHandler();
    private Thread mUiThread;
    private FrameLayout imageViewLayout;
    private boolean isCanResend = true;
    protected boolean isFromNF = false;
    protected boolean isOnNetwork = true;
    private boolean isPrevNotInRecord;
    protected boolean isSpecial = false;
    protected boolean isUseBasePV = true;
    private boolean jump;
    private RelativeLayout layout;
    private ViewGroup subRootView;
    private SharedPreferences sharedPreferences;
    //private p<Activity> softReference;

    @Override
    public void addDestroyListener(IDestroyListener destroyListener) {

    }

    @Override
    public void addLogoutListener(ILogoutListener paramb) {

    }

    @Override
    public void addPauseListener(IPauseListener paramd) {

    }

    @Override
    public void addResumeListener(IResumeListener parame) {

    }

    @Override
    public Handler getHandler() {
        return null;
    }

    @Override
    public HttpGroup getHttpGroupaAsynPool() {
        return null;
    }

    @Override
    public HttpGroup getHttpGroupaAsynPool(int paramInt) {
        return null;
    }

    @Override
    public String getStringFromPreference(String paramString) {
        return null;
    }

    @Override
    public Activity getThisActivity() {
        return null;
    }

    @Override
    public void onHideModal() {

    }

    @Override
    public void onShowModal() {

    }

    @Override
    public void post(Runnable paramRunnable) {
        if (isFinishing())
            return;
        this.handler.post(paramRunnable);
    }

    @Override
    public void post(Runnable paramRunnable, int paramInt) {
        if (isFinishing())
            return;
        this.handler.postDelayed(paramRunnable, paramInt);
    }

    @Override
    public void putBooleanToPreference(String paramString, Boolean paramBoolean) {

    }

    @Override
    public void removeDestroyListener(IDestroyListener parama) {

    }

    @Override
    public void removeLogoutListener(ILogoutListener paramb) {

    }

    @Override
    public void removePauseListener(IPauseListener paramd) {

    }

    @Override
    public void removeResumeListener(IResumeListener parame) {

    }

    @Override
    public void startActivityForResultNoException(Intent paramIntent, int paramInt) {

    }

    @Override
    public void startActivityForResultNoExceptionStatic(Activity paramActivity, Intent paramIntent, int paramInt) {

    }

    @Override
    public void startActivityInFrame(Intent paramIntent) {

    }

    @Override
    public void startActivityInFrameWithNoNavigation(Intent paramIntent) {

    }

    @Override
    public void startActivityNoException(Intent paramIntent) {

    }

    public void setNetworkModel(boolean paramBoolean)
    {
        this.isOnNetwork = paramBoolean;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Log.D)
        {
            testStack();
            Log.d(this.TAG, "onCreate() -->> " + getClass().getName());
        }
        _O.getInstance(this);
        this.sharedPreferences = CommonUtil.getJdSharedPreferences();
        this.sharedPreferences.edit().putInt("runStage", 1).commit();
//        this.softReference = new p(this);
//        this.softReference.a(getClass().getName());
//        a.a(this.softReference);
//        com.jingdong.common.utils.crash.e.a(getIntent());
        BaseApplication.getInstance().setCurrentMyActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.mUiThread = Thread.currentThread();
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        super.onCreate(savedInstanceState);
        this.sharedPreferences = CommonUtil.getJdSharedPreferences();
        if (getIntent() != null)
            this.isFromNF = getIntent().getBooleanExtra("isFromNF", false);
//        initHardAcclCheck();
    }

    public void setSubRootView(ViewGroup paramViewGroup)
    {
        this.subRootView = paramViewGroup;
    }

    public HttpGroup getHttpGroupWithNPSGroup(){
        return null;
    }  public void testStack()
    {
        Iterator localIterator = ((ActivityManager)getSystemService(ACTIVITY_SERVICE)).getRunningTasks(1000).iterator();
        while (localIterator.hasNext())
        {
            String str = ((ActivityManager.RunningTaskInfo)localIterator.next()).baseActivity.getClassName();
            Log.d("activity_all_name", str);
            if ((!str.startsWith("com.jingdong")) && (!str.startsWith("com.jd")))
                continue;
            Log.d("activity_name", str);
        }
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
