package com.zy.app.mall;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.SplashFragment;
import com.jingdong.app.mall.aura.AuraBlackList;
import com.jingdong.app.mall.aura.AuraUpdate;
import com.jingdong.app.mall.aura.internal.AuraSwitchOfNetwork;
import com.jingdong.app.mall.basic.ActivityJumpController;
import com.jingdong.app.mall.basic.ApplicationManager;
import com.jingdong.app.mall.basic.ErrorActivity;
import com.jingdong.app.mall.basic.JDUntil;
import com.jingdong.app.mall.faxian.JDFaxianFragment;
import com.jingdong.app.mall.home.HomePageObserver;
import com.jingdong.app.mall.more.AboutActivity;
import com.jingdong.app.mall.more.FeedbackActivity;
import com.jingdong.app.mall.more.HistoryListActivity;
import com.jingdong.app.mall.more.MoreActivity;
import com.jingdong.app.mall.navigationbar.NavigationFragment;
import com.jingdong.app.mall.navigationbar.NavigationOptHelper;
import com.jingdong.app.mall.open.OpenAppJumpController;
import com.jingdong.app.mall.personel.home.JDPersonalFragment;
import com.jingdong.app.mall.search.CameraPurchaseActivity;
import com.jingdong.app.mall.searchRefactor.view.Activity.ProductListActivity;
import com.jingdong.app.mall.settlement.ShoppingController;
import com.jingdong.app.mall.shopping.JDShoppingCartFragment;
import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.app.mall.utils.LoginUser;
import com.jingdong.app.mall.utils.ReActivationUserManager;
import com.jingdong.app.mall.utils.StartActivityUtils;
import com.jingdong.app.mall.utils.UpdateInitialization;
import com.jingdong.app.mall.utils.ui.NightModeDialog;
import com.jingdong.common.ActivityNumController;
import com.jingdong.common.BaseApplication;
import com.jingdong.common.c.LocManager;
import com.jingdong.common.hybrid.HybridUpdate;
import com.jingdong.common.login.SafetyManager;
import com.jingdong.common.reactnative.download.ReactNativeUpdate;
import com.jingdong.common.ui.JDDialogFactory;
import com.jingdong.common.utils.CacheTimeUtil;
import com.jingdong.common.utils.CommonBase;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.FileService;
import com.jingdong.common.utils.GlobalInitialization;
import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.HttpGroupUtils;
import com.jingdong.common.utils.JSONObjectProxy;
import com.jingdong.common.utils.MessageUtil;
import com.jingdong.common.utils.ShortCutUtils;
import com.jingdong.jdma.common.utils.Md5Encrypt;
import com.zy.app.mall.R;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.navigationbar.TabFragment;
import com.zy.app.mall.searchRefactor.view.Activity.SearchActivity;
import com.zy.app.mall.utils.MyActivity;
import com.zy.app.mall.utils.frame.TabBarButton;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.app.util.image.listener.JDSimpleImageLoadingListener;
import com.zy.cleanmvp.ui.BaseFragment;
import com.zy.common.BaseActivity;
import com.zy.common.ScrollableTabActivity;
import com.zy.common.entity.SourceEntity;
import com.zy.common.frame.IMainActivity;
import com.zy.common.frame.IMyActivity;
import com.zy.common.res.StringUtil;
import com.zy.common.ui.JDDialog;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDImageUtils;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;
import com.zy.common.utils.TimerUntil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Robin on 2016/4/14.
 */
public class MainFrameActivity extends MyActivity implements IMainActivity, ScrollableTabActivity._Q {
    private final static String TAG = MainFrameActivity.class.getSimpleName();

    private static TabBarButton.StateController J;//J
    private static TabBarButton.RedPoint P;//P
    private static TabBarButton.RedPoint Q;//Q
    private static ArrayList<String> fragmentList = new ArrayList();//R
    private static Menu S;//S
    public static boolean a = true;//a
    public static boolean c;//c
    private String mSourceValue = "";//A
    private int mShowTime = 0;//B
    private int mRedirect = 0;//C
    private int mSkip = 0;//D
    private int mType = 0;//E
    private int mCountdown = 0;//F
    private Intent mGalleryData;//G
    private Integer H;//H
    private Handler handler;
    private boolean K;//K
    private boolean L;//L
    private boolean M;//M
    private ViewGroup N;//N
    private RelativeLayout O;//O
    private boolean T = false;
    private BaseFragment U;//U
    private int lastIndex;//V
    private TabFragment W;//W
    private boolean X;//X
    private int Y;//Y
    private MenuItem Z;//Z
    private MenuItem aa;//aa
    private MenuItem ab;//ab
    private int ac;//ac
    public NavigationFragment b;//b
    final int d = 272;//d
    private final String f = MainFrameActivity.class.getSimpleName();
    private final Set<String> g = new HashSet();
    private final int h = 30000;
    private final String i = "startimage.image";
    private final int j = 1;//j
    private final int k = 2;//k
    private final int l = 3;//l
    private final int m = 30000;
    private Runnable n = null;//n
    private boolean o = false;//o
    private Date p;//p
    private int q = 0;//q
    private Map r = new HashMap();
    private String s = "";//s
    private String mOnlineTime = "";//t
    private String mReferralsTime = "";//u
    private String mUrl = "";//v
    private String mShareUrl = "";//w
    private String mShareTitle = "";//x
    private String mShareContent = "";//y
    private String mShareAvatar = "";//z

    static {
        fragmentList.add(JDNewCategoryFragment.class.getName());
        fragmentList.add(JDShoppingCartFragment.class.getName());
        fragmentList.add(JDPersonalFragment.class.getName());
        fragmentList.add(JDFaxianFragment.class.getName());
        c = true;
    }

    private void a(Bundle bundle) {
        try {
            if (this.b == null)
                return;
            int to = NavigationOptHelper.getInstance().lastIndex;
            if (bundle != null) {//if-eqz p1, :cond_3
                to = bundle.getInt("to", -1);
                if (Log.D)
                    Log.d(this.f, "1.goAction() to = " + to + " bundle = " + bundle);
                bundle.remove("to");
                if (to == -1) {//if-eq v0, v4, :cond_0
                    return;
                }
            }//:cond_3
            if (to == 65793) {//if-ne v0, v1, :cond_4
                b((Bundle) null);//MainFrameActivity;->b(Landroid/os/Bundle;)V
                to = 0;
            }
            this.b.b(to);
            if (Log.D) {
                Log.d(this.f, "goAction() to = " + to + " bundle = " + bundle);
            }
        } catch (Exception e) {
            if (Log.D)
                e.printStackTrace();
        }
    }

    public static void a(TabBarButton.StateController paramb) {
        J = paramb;
    }


    public static void a(TabBarButton.RedPoint paramc) {
        P = paramc;
    }

    private void a(String paramString) {
        this.g.remove(paramString);
    }

    public static void a(boolean paramBoolean) {
        final TabBarButton.RedPoint localc = Q;
        if (localc != null
                && (BaseApplication.getInstance().getMainFrameActivity() != null)
                && (BaseApplication.getInstance().getMainFrameActivity().getHandler() != null))
            BaseApplication.getInstance().getMainFrameActivity().getHandler().post(new Runnable() {//af(true, localc)
                @Override
                public void run() {
                    if (true) {
                        CommonUtil.putIntToPreference("shared_faxian_redpoint_flag", 1);
                        if (CommonBase.getJdFaxianNewFlag()) {
                            localc.a(Boolean.valueOf(false));
                            localc.b(Boolean.valueOf(true));
                            CommonBase.setJdFaxianNewFlag(false);
                            return;
                        }
                        localc.b(Boolean.valueOf(true));
                        localc.a(Boolean.valueOf(false));
                        return;
                    }
                    localc.a(Boolean.valueOf(false));
                    localc.b(Boolean.valueOf(false));
                }
            });
    }

    public static boolean a() {
        String localObject2 = CommonUtil.getJdSharedPreferences().getString("endTime", "");
        if (!localObject2.equals("")) {//if-eqz v1, :cond_1
            Date now = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date endTime = null;
            try {
                endTime = simpleDateFormat.parse((String) localObject2);
            } catch (ParseException localParseException) {
                localParseException.printStackTrace();
            }
            if ((endTime != null) && (!now.after(endTime)))
                return false;
        }
        return true;

    }

    public static void b() {
        SharedPreferences.Editor localEditor = CommonUtil.getJdSharedPreferences().edit();
        localEditor.putString("start_image_md5", "");
        localEditor.putString("forwardUrl", "");
        localEditor.putString("imagepath", "");
        localEditor.putString("beginTime", "");
        localEditor.putString("endTime", "");
        localEditor.putString("startSrcVal", "");
        localEditor.putInt("showTime", 0);
        localEditor.putInt("redirect", 0);
        localEditor.putInt("skip", 0);
        localEditor.putInt("start_ad_type", 0);
        localEditor.putInt("start_countdown", 0);
        localEditor.commit();
    }

    private void b(Bundle paramBundle) {
        if (Log.D)
            Log.d(this.f, "showSearchActivity() -->> ");
        if (((BaseActivity) BaseApplication.getInstance().getCurrentMyActivity() instanceof SearchActivity))
            return;
        startActivityForResult(new Intent(this, SearchActivity.class), 272);
    }

    public static void b(TabBarButton.RedPoint paramc) {
        Q = paramc;
    }

    public static void d() {
        if (Log.D)
            Log.d("Temp", "MainFrameActivity clearCache() -->> ");
        new Thread() {//ac()
            @Override
            public void run() {
                setName("MainFrameActivity_clearCache");
                android.os.Process.setThreadPriority(19);
                FileService.d();
                FileService.e();
            }
        }.start();
    }

    public static TabBarButton.RedPoint f() {
        return P;
    }

    public static TabBarButton.RedPoint g() {
        return Q;
    }

    public static void h() {
    }

    protected static String m() {
        String str = "";
        try {
            str = BaseApplication.getInstance().getPackageManager().getPackageInfo(BaseApplication.getInstance().getPackageName(), 0).versionName;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return "first_start_flag_" + str;
    }

    private static void o() {
        if (J != null) {
            int i1 = ShoppingController.getProductCount();//com.jingdong.app.mall.settlement.qi
            Integer localInteger = null;
            if (i1 != 0) {
                localInteger = Integer.valueOf(i1);
            }
            if ((BaseApplication.getInstance().getMainFrameActivity() != null) && (BaseApplication.getInstance().getMainFrameActivity().getHandler() != null)) {
                final Integer finalLocalInteger = localInteger;
                BaseApplication.getInstance().getMainFrameActivity().getHandler().post(new Runnable() {//ae(localb, localInteger)
                    @Override
                    public void run() {
                        J.a(finalLocalInteger);
                    }
                });
            }
        }
    }

    public final void a(int paramInt) {
        switch (this.ac) {

            case 0://switch_0
                if (this.Z != null)
                    this.Z.setIcon(R.drawable.navigation_home_selector);//0x7f020b93  2130840467
                break;
            case 1://:sswitch_1
            case 12://:sswitch_1
                if (this.aa != null)
                    this.aa.setIcon(R.drawable.navigation_catagory_selector);//0x7f020b92  2130840466
                break;
            case 3://sswitch_2
                if (this.ab != null)
                    this.ab.setIcon(R.drawable.navigation_car_selector);//0x7f020b91  2130840465
        }

        this.ac = paramInt;
        switch (paramInt) {
            case 0://:sswitch_3
                if (this.Z != null)
                    this.Z.setIcon(R.drawable.main_navigation_home_checked);//0x7f020a59  2130840153
                break;
            case 1://:sswitch_4
            case 12://:sswitch_4
                if (this.aa != null)
                    this.aa.setIcon(R.drawable.main_navigation_catagory_checked);//0x7f020a56  2130840150
                break;
            case 3://:sswitch_5
                if (this.ab != null)
                    this.ab.setIcon(R.drawable.main_navigation_car_checked);//0x7f020a54  2130840148
        }
        return;
    }

    public final void c() {
        if (Log.D)
            Log.d(this.f, "checkTargetActivity() -->> ");
        SharedPreferences sharedPreferences = CommonUtil.getJdSharedPreferences();
        Object localObject2 = ((SharedPreferences) sharedPreferences).getString("cameraFilePath", null);
        String str = ((SharedPreferences) sharedPreferences).getString("photoType", null);
        int i1 = ((SharedPreferences) sharedPreferences).getInt("photoTypeIndex", 0);
        if (!TextUtils.isEmpty((CharSequence) localObject2)) {
            Intent localIntent = new Intent(this, CameraPurchaseActivity.class);
            localIntent.putExtra("cameraPath", (String) localObject2);
            localIntent.putExtra("categoryTypeArray", str);
            localIntent.putExtra("categoryTypeIndex", i1);
            startActivity(localIntent);
            SharedPreferences.Editor editor = ((SharedPreferences) sharedPreferences).edit();
            ((SharedPreferences.Editor) editor).remove("cameraFilePath");
            ((SharedPreferences.Editor) editor).remove("photoType");
            ((SharedPreferences.Editor) editor).remove("photoTypeIndex");
            ((SharedPreferences.Editor) editor).commit();
        } else if (this.H != null) {
            localObject2 = new Intent(this, CameraPurchaseActivity.class);
            ((Intent) localObject2).putExtra("galleryData", this.mGalleryData);
            ((Intent) localObject2).putExtra("categoryTypeArray", str);
            ((Intent) localObject2).putExtra("categoryTypeIndex", i1);
            startActivity((Intent) localObject2);
            SharedPreferences.Editor editor = ((SharedPreferences) sharedPreferences).edit();
            ((SharedPreferences) editor).edit().remove("photoType").commit();
            ((SharedPreferences) editor).edit().remove("photoTypeIndex").commit();
        } else {
            Bundle extras = getIntent().getExtras();
            if (Log.D)
                Log.d(this.f, "checkTargetActivity() bundle -->> " + extras);
            if (extras != null) {
                final OpenAppJumpController openAppJumpController = OpenAppJumpController.a(getIntent());
                if (Log.D)
                    Log.d(this.f, "checkTargetActivity() command -->> " + openAppJumpController);
                if (openAppJumpController != null) {
                    if (Log.D)
                        Log.d(this.f, "toTargetActivity -->> ");
                    OpenAppJumpController._A.a();
                    getHandler().post(new Runnable() {//u(this, (com.jingdong.app.mall.open.d)openAppJumpController)
                        @Override
                        public void run() {
                            final int i = openAppJumpController.a();
                            final Bundle localBundle = openAppJumpController.b();
                            if (Log.D)
                                Log.d(MainFrameActivity.this.f, "toTargetActivity moduleId -->> " + i);
                            if ((Log.D) && (localBundle != null)) {
                                Log.d(MainFrameActivity.this.f, "bundle -->> " + localBundle);
                                Iterator localIterator = localBundle.keySet().iterator();
                                while (localIterator.hasNext()) {
                                    String str = (String) localIterator.next();
                                    Object localObject = localBundle.get(str);
                                    Log.d(MainFrameActivity.this.f, "bundle key value -->> " + str + "：" + localObject);
                                }
                            }
                            //:cond_1
                            if (!MainFrameActivity.this.o)
                                MainFrameActivity.this.n = new Runnable() {//v(this, localBundle, i)
                                    @Override
                                    public void run() {
                                        ActivityJumpController.a().a(MainFrameActivity.this).a(localBundle, i);
                                    }
                                };
                            else
                                ActivityJumpController.a().a(MainFrameActivity.this).a(localBundle, i);
                            MainFrameActivity.this.Y = 2;
                            return;
                        }
                    });
                }
            }
        }
        return;
    }

    @Override
    public final void e() {
        o();
    }

    @Override
    public void finish() {
        BaseActivity currentMyActivity = getCurrentMyActivity();
        if (Log.D)
            Log.d(this.f, " MainFrame -->> finish() ");
        if (currentMyActivity != null) {
            Class<? extends BaseActivity> activityClass = currentMyActivity.getClass();
            if (activityClass != null) {
                String className = ((Class) activityClass).getName();
                if ((!TextUtils.isEmpty((CharSequence) className)) && (fragmentList.contains(className))) {
                    k();
                    return;
                }
            }
        }
        super.finish();
    }

    @Override
    public Handler getHandler() {
        return this.handler;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }

    public final BaseFragment i() {
        return this.U;
    }

    public final TabFragment j() {
        return this.W;
    }

    public final void k() {
        this.b.b(0);
    }

    @Override
    public final boolean l() {
        return this.T;
    }

    @Override
    public IMyActivity n() {
        return this.getCurrentMyActivity();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Log.D)
            Log.d(this.f, "onActivityResult() -->> " + requestCode + "```" + resultCode);
        if ((272 == requestCode) && (-1 == resultCode)) {//if-ne v0, p1, :cond_4    if-ne v0, p2, :cond_4
            Bundle extras = data.getExtras();
            if ((data != null) && (extras.getBoolean("isShop"))) {//if-eqz v0, :cond_2   if-eqz v1, :cond_2
                String keyWord = extras.getString("keyWord");
                StartActivityUtils.a(this, keyWord, new SourceEntity("shop_from_search", keyWord));
            } else {
                Object localObject = new Intent(this, ProductListActivity.class);
                ((Intent) localObject).putExtras(extras);
                ((Intent) localObject).putExtra("sortKey", 5);
                if (extras != null)
                    ((Intent) localObject).putExtra("source", new SourceEntity("search", extras.getString("keyWord")));
                StartActivityUtils.a(this, (Intent) localObject, false);
            }
        } else if (requestCode == 12) {//if-ne p1, v0, :cond_7
            if (getCurrentMyActivity() != null) {//if-eqz v0, :cond_6
                BaseActivity localObject = getCurrentMyActivity();
                if ((localObject instanceof CameraPurchaseActivity)) {//if-eqz v1, :cond_5
                    ((CameraPurchaseActivity) localObject).onActivityResult(requestCode, resultCode, data);
                    return;
                } else {
                    if (Log.D) {
                        System.err.println("MianActivity onActivityResult() getCurrentActivity instanceof CameraPurchaseActivity is false");
                        System.err.println(localObject.getClass().toString());
                    }
                }
            } else {
                this.mGalleryData = data;
                this.H = Integer.valueOf(resultCode);
            }
        } else if ((requestCode >> 16 == 0) && (this.U != null))
            this.U.onActivityResult(requestCode, resultCode, data);
        else
            super.onActivityResult(requestCode, resultCode, data);

        return;

    }

    @Override
    public void onAttachFragment(Fragment paramFragment) {
        if (Log.D)
            Log.d(this.f, "onAttachFragment.. -->> " + paramFragment.getClass());
        super.onAttachFragment(paramFragment);
        try {
            this.U = ((BaseFragment) paramFragment);
            if (paramFragment.getId() == R.id.navigation_fragment)
                this.b = ((NavigationFragment) paramFragment);
            else
                this.W = ((TabFragment) paramFragment);
        } catch (Exception e) {
            if (Log.D)
                e.printStackTrace();
        }
    }

    public void onCreate(Bundle paramBundle) {
        AuraUpdate.a(BaseApplication.getInstance().getApplicationContext());
        if (Log.D)
            Log.d(this.f, "onCreate.. -->> ");
        HomePageObserver.getInstance(this);//x.a(this);
        this.needCheckNet = false;
        if (getIntent() == null) {
            finish();
            return;
        }
        if (JDUntil.hasSmartBar())
            setTheme(R.style.MeizuTheme);//0x7f0900a9
        else if (getIntent().getBooleanExtra("from_launch", false))
            setTheme(R.style.splashTheme);//0x7f090164

        setNetworkModel(false);
        TimerUntil.a = System.currentTimeMillis();
        BaseApplication.getInstance().setMainFrameActivity(this);
        try {
            Object localObject2 = getResources();
            Configuration localConfiguration = ((Resources) localObject2).getConfiguration();
            localConfiguration.fontScale = 1.0F;
            ((Resources) localObject2).updateConfiguration(localConfiguration, ((Resources) localObject2).getDisplayMetrics());
        } catch (Throwable e) {
            if (Log.E)
                e.printStackTrace();
        }
        // :cond_3
        //:goto_2
        this.handler = new Handler();
        ActivityNumController.a(MainFrameActivity.class.getSimpleName());
        ApplicationManager.a(getSupportFragmentManager());//l.a(getSupportFragmentManager());
        super.onCreate(paramBundle);
        setContentView(R.layout.app_jd_fragment_activity);
        if (paramBundle != null) {
            this.lastIndex = paramBundle.getInt("lastIndex");
            this.a = false;
        }
        if (JDUntil.hasSmartBar()) {//if-eqz v0, :cond_6
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            ((ViewGroup) findViewById(R.id.content_layout)).setLayoutParams((ViewGroup.LayoutParams) layoutParams);//2131165832
            JDUntil.a(getWindow(), true);
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                JDUntil.a((ActionBar) actionBar, true);
                ((ActionBar) actionBar).setDisplayOptions(0);
            }
            this.a(this.lastIndex);
        }
        if ((paramBundle == null) || (this.lastIndex != 0)) {
            NavigationFragment fragment = NavigationFragment.a(this.lastIndex);
            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment, fragment, "JDNavigationBarFragment").commit();//2131165833
        }
        if (this.a) {
            SplashFragment fragment = new SplashFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.splash_fragment, fragment, "SplashFragment").commit();//2131165834
        }
        //:cond_9
        getHandler().postDelayed(new Runnable() {//q(this)
            @Override
            public void run() {
                MainFrameActivity.d();
                SharedPreferences localSharedPreferences = com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences();
                Boolean localBoolean = com.jingdong.common.config.Configuration.getBooleanProperty("applicationShortcut");
                //Object localObject = localBoolean;
                if (localBoolean == null)
                    localBoolean = Boolean.valueOf(true);
                if ((!localSharedPreferences.getBoolean("add_short_cut_flag_500", false)) && (((Boolean) localBoolean).booleanValue()))
                    ShortCutUtils.a(MainFrameActivity.this);//com.jingdong.common.utils.fp
                MainFrameActivity.this.M = com.jingdong.app.mall.utils.CommonUtil.activityIsGuided("com.jingdong.app.mall.MainActivity");
                BaseApplication.networkSetting();
                SafetyManager.initEncryptKey();
                localSharedPreferences.edit().remove("appUseTime").commit();
                MainFrameActivity.synthetic_a(MainFrameActivity.this);
                Boolean localObject = com.jingdong.app.mall.utils.CommonUtil.getBooleanFromPreference(MainFrameActivity.this.getString(R.string.msg_auto_update_switch_key), Boolean.valueOf(true));//2131232560
                if (((Boolean) localObject).booleanValue()) {//if-eqz v1, :cond_4
                    try {
                        if (Log.D)
                            Log.d(MainFrameActivity.this.f, " -->> msgSwitch : " + localObject);
                        if (MessageUtil.a()) {
                            localObject = com.zy.common.utils.CommonUtil.getBooleanFromPreference(StringUtil.msg_auto_update_switch_key, com.jingdong.common.config.Configuration.getBooleanProperty("msgSwitch"));
                            if (((Boolean) localObject).booleanValue()) {
                                if (Log.D)
                                    Log.i("MessageUtil", "openMsgService-->> startPush.msgSwitch=" + localObject);
                                com.jingdong.cloud.jdpush.JDPushInterface.a(BaseApplication.getInstance().getApplicationContext());
                                com.jingdong.jdpush.JDPushInterface.a(BaseApplication.getInstance().getApplicationContext());
                            }
                        }
                    } catch (Exception localException) {
                        if (Log.D)
                            localException.printStackTrace();
                    }
                }
                CacheTimeUtil.getCacheTime();
                LocManager.getInstance().a(MainFrameActivity.this, MainFrameActivity.this.getString(R.string.location_tip));//2131232411
                int i = com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences().getInt("appStartCount", 0);
                SharedPreferences.Editor editor = com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences().edit();
                ((SharedPreferences.Editor) editor).putInt("appStartCount", i + 1);
                ((SharedPreferences.Editor) editor).commit();
                return;

            }
        }, 100L);
        int i1 = ((Intent) getIntent()).getIntExtra("moduleId", -1);
        this.lastIndex = ((Intent) getIntent()).getIntExtra("com.360buy:navigationId", 0);
        a(getIntent().getExtras());
        if (this.a) {//if-eqz v0, :cond_12
            this.a = false;
            getHandler().postDelayed(new Runnable() {//w(this)
                @Override
                public void run() {
                    if ((CommonUtil.getJdSharedPreferences().getBoolean("showCost", true)) && (com.jingdong.common.config.Configuration.getBooleanProperty("costHint").booleanValue())) {
                        MainFrameActivity.synthetic_u(MainFrameActivity.this);
                    }
                }
            }, 100L);
            if (Log.D)
                Log.d(this.f, "loadHomeActivity -->> ");
            o();
            a("");
            if (!this.M) {//if-nez v0, :cond_c
                if (Log.D)
                    Log.d(this.f, "addGuideImage -->> ");
                if ((this.L) && (this.K)) {//if-eqz v0, :cond_c if-nez v0, :cond_f
                    this.N = ((ViewGroup) getWindow().peekDecorView());
                    if (Log.D)
                        Log.d(this.f, "view -->> " + this.N);
                    if (this.N != null) {
                        if (Log.D)
                            Log.d(this.f, "guideResourceId -->> " + R.drawable.home_guide);//2130839330
                        this.O = new RelativeLayout(this);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.guide_home_width), getResources().getDimensionPixelOffset(R.dimen.guide_home_height));//2131035569 2131035568
                        layoutParams.addRule(13);
                        SimpleDraweeView localObject1 = new SimpleDraweeView(this);
                        ((ImageView) localObject1).setImageResource(R.drawable.home_guide);//2130839330
                        this.O.addView((View) localObject1, layoutParams);
                        this.O.setBackgroundColor(getResources().getColor(R.color.home_slide_prompt_bg));//2131100115
                        this.O.getBackground().setAlpha(200);
                        CommonUtil.setIsGuided("com.jingdong.app.mall.MainActivity");
                        this.O.setOnTouchListener(new View.OnTouchListener() {//ag(this)
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                switch (event.getAction()) {
                                    case 1:
                                        MainFrameActivity.this.removeGuideView();
                                }
                                return true;
                            }
                        });
                        this.N.addView(this.O, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                        this.N.invalidate();
                    }
                }
            }
            //:cond_c
            //:goto_3

            this.K = true;
            new Timer().schedule(new TimerTask() {//an(this)
                @Override
                public final void run() {
                    int i = 0;
                    if (CommonUtil.getJdSharedPreferences().getString("imagepath", "").trim().equals(""))
                        i = 1;
                    else if (MainFrameActivity.a()) {
                        if (Log.D)
                            Log.d("Temp", "startimage is out of dates");
                        i = 2;
                    } else {
                        if (Log.D)
                            Log.d("Temp", "startimage is not out of dates");
                        i = 3;
                    }
                    if (Log.D)
                        System.out.println("当前启动图state" + i);
                    final HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
                    localHttpSetting.setFunctionId("start");
                    localHttpSetting.setHost(com.jingdong.common.config.Configuration.getPortalHost());
                    localHttpSetting.setEffect(0);
                    JSONObject localJSONObject = new JSONObject();
                    try {
                        localJSONObject.put("lng", String.valueOf(LocManager.c));
                        localJSONObject.put("lat", String.valueOf(LocManager.b));
                        localHttpSetting.putJsonParam("geo", localJSONObject);
                        localHttpSetting.setListener(new HttpGroup.OnCommonListener() {//s(MainFrameActivity.this, new ExceptionReporter(localHttpSetting))
                            @Override
                            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {

                            }

                            @Override
                            public void onError(HttpGroup.HttpError paramHttpError) {
                                if (Log.D)
                                    Log.d("MainFrameActivity", "start image on error");
                            }

                            @Override
                            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                                MainFrameActivity.this.s = Md5Encrypt.md5(paramHttpResponse.getString());
                                if (CommonUtil.getStringFromPreference("start_image_md5", "").equals(MainFrameActivity.this.s))
                                    return;
                                Object localObject = paramHttpResponse.getJSONObject();
                                MainFrameActivity.this.mCountdown = ((JSONObjectProxy) localObject).optInt("countdown", 0);
                                localObject = ((JSONObjectProxy) localObject).getJSONArrayOrNull("images");
                                if (localObject != null) {//if-eqz v2, :cond_3
                                    MainFrameActivity.this.q = ((JSONArrayProxy) localObject).length();

                                    for (int i = 0; i < MainFrameActivity.this.q; i++) {//if-ge v0, v3, :cond_0
                                        JSONObjectProxy jsonObjectProxy = ((JSONArrayProxy) localObject).getJSONObjectOrNull(i);
                                        if (i == 0) {///if-nez v0, :cond_2
                                            MainFrameActivity.this.mUrl = jsonObjectProxy.optString("mUrl", "");
                                            MainFrameActivity.this.mOnlineTime = jsonObjectProxy.optString("onlineTime", "");
                                            MainFrameActivity.this.mReferralsTime = jsonObjectProxy.optString("referralsTime", "");
                                            MainFrameActivity.this.mSourceValue = jsonObjectProxy.optString("sourceValue", "");
                                            MainFrameActivity.this.mShowTime = jsonObjectProxy.optInt("time", 0);
                                            MainFrameActivity.this.mRedirect = jsonObjectProxy.optInt("ynRedirect", 0);
                                            MainFrameActivity.this.mSkip = jsonObjectProxy.optInt("ynSkip", 0);
                                            MainFrameActivity.this.mType = jsonObjectProxy.optInt("type", 0);
                                            MainFrameActivity.this.mShareTitle = jsonObjectProxy.optString("shareTitle", "");
                                            MainFrameActivity.this.mShareUrl = jsonObjectProxy.optString("shareUrl", "");
                                            MainFrameActivity.this.mShareContent = jsonObjectProxy.optString("shareContent", "");
                                            MainFrameActivity.this.mShareAvatar = jsonObjectProxy.optString("shareAvatar", "");
                                        } else {
                                            MainFrameActivity.this.mSourceValue += ("||" + jsonObjectProxy.optString("sourceValue", ""));
                                        }
                                        //:goto_2
                                        final int finalI = i;
                                        JDImageUtils.loadImage(jsonObjectProxy.optString("url", "")
                                                , JDDisplayImageOptions.createSimple().cacheInMemory(false).bitmapConfig(Bitmap.Config.ARGB_8888)
                                                , new JDSimpleImageLoadingListener() {//t(localMainFrameActivity, i)
                                                    private int a = finalI;

                                                    public final void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
                                                        byte[] data = null;
                                                        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                                                        if (paramBitmap != null) {//if-eqz p3, :cond_0
                                                            try {
                                                                paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                                                                paramBitmap.recycle();
                                                                data = localByteArrayOutputStream.toByteArray();

                                                            } catch (Exception e) {
                                                                if (Log.E)
                                                                    e.printStackTrace();
                                                            }
                                                        }
                                                        FileService._Bm bm = FileService.a(4);
                                                        if (paramView != null) {
                                                            String name = "startimage.image" + this.a;
                                                            MainFrameActivity.this.r.put(Integer.valueOf(this.a), bm.d() + "/" + name);
                                                            if (!Boolean.valueOf(FileService.a(bm, name, data)).booleanValue()) {
                                                                if (Log.D)
                                                                    Log.d(MainFrameActivity.this.f, "Image saved faild.");
                                                                MainFrameActivity.this.r.clear();
                                                                MainFrameActivity.b();
                                                            } else if (MainFrameActivity.this.r.size() == MainFrameActivity.this.q) {
                                                                paramString = "";
                                                                for (int i = 0; i < MainFrameActivity.this.r.size(); i++) {
                                                                    if (TextUtils.isEmpty(paramString))
                                                                        paramString = MainFrameActivity.this.r.get(Integer.valueOf(i)).toString();
                                                                    else
                                                                        paramString = paramString + "," + MainFrameActivity.this.r.get(Integer.valueOf(i)).toString();
                                                                }
                                                            }
                                                            SharedPreferences.Editor editor = CommonUtil.getJdSharedPreferences().edit();
                                                            editor.putString("start_image_md5", MainFrameActivity.this.s);
                                                            editor.putString("forwardUrl", MainFrameActivity.this.mUrl);
                                                            editor.putString("imagepath", paramString);
                                                            editor.putString("beginTime", MainFrameActivity.this.mOnlineTime);
                                                            editor.putString("endTime", MainFrameActivity.this.mReferralsTime);
                                                            editor.putString("startSrcVal", MainFrameActivity.this.mSourceValue);
                                                            editor.putInt("showTime", MainFrameActivity.this.mShowTime);
                                                            editor.putInt("redirect", MainFrameActivity.this.mRedirect);
                                                            editor.putInt("skip", MainFrameActivity.this.mSkip);
                                                            editor.putInt("start_ad_type", MainFrameActivity.this.mType);
                                                            editor.putString("shareUrl", MainFrameActivity.this.mShareUrl);
                                                            editor.putString("shareTitle", MainFrameActivity.this.mShareTitle);
                                                            editor.putString("shareContent", MainFrameActivity.this.mShareContent);
                                                            editor.putString("shareAvatar", MainFrameActivity.this.mShareAvatar);
                                                            editor.putInt("start_countdown", MainFrameActivity.this.mCountdown);
                                                            editor.commit();

                                                        }
                                                        return;
                                                    }


                                                    public final void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason) {
                                                        ExceptionReporter.reportBitmapException(paramString, paramJDFailReason);
                                                    }
                                                });
                                    }
                                } else {
                                    MainFrameActivity.b();
                                    new ExceptionReporter(localHttpSetting).reportHttpBusinessException(paramHttpResponse);
                                }
                                return;
                            }
                        });
                        HttpGroupUtils.getHttpGroupaAsynPool().add(localHttpSetting);
                        return;

                    } catch (JSONException localJSONException) {
                        localJSONException.printStackTrace();
                    }

                }
            }, 30000L);
        } else {        //:cond_12
            o();
            a("");
        }
        //:goto_4
        if (Log.D)
            Log.d(this.f, "onCreate moduleId -->> " + i1);
        new ReActivationUserManager(getApplicationContext()).a();//new bi(getApplicationContext()).a();
        new _Ad().start();
        AuraBlackList.a(BaseApplication.getInstance().getCurrentMyActivity(), true);
        return;
    }


    public boolean onCreateOptionsMenu(Menu paramMenu) {
        if (JDUntil.hasSmartBar()) {//if-eqz v0, :cond_2
            getMenuInflater().inflate(R.menu.navigation_menu, paramMenu);//2131689475
            try {
                this.Z = paramMenu.getItem(0);
                this.aa = paramMenu.getItem(1);
                this.ab = paramMenu.getItem(2);
                a(this.lastIndex);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.g.size() <= 0) {
            getMenuInflater().inflate(R.menu.main_menu, paramMenu);//2131689473
            S = paramMenu;
        }
        if (!this.M)
            removeGuideView();
        return true;

    }

    protected void onDestroy() {
        LocManager.j = true;
        super.onDestroy();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (Log.I)
            Log.i(this.f, "onSearchRequested++++main");
        if (paramInt == 84) {//if-ne p1, v0, :cond_4
            String simpleName = JDHomeFragment.class.getSimpleName();
            String str = JDPersonalFragment.class.getSimpleName();

            if (this.U != null) {//if-nez v3, :cond_1
                String currentActivitySimpleName = this.U.getClass().getSimpleName();
                if (Log.D)
                    Log.d(this.f, "currentActivity -->> " + (String) currentActivitySimpleName);
                if ((!simpleName.equals(currentActivitySimpleName)) && (!str.equals(currentActivitySimpleName)))
                    b((Bundle) null);
            }
            return true;
        } else if (paramInt == 4) {//if-ne p1, v0, :cond_b
            if (((this.U instanceof JDHomeFragment)) && (((JDHomeFragment) this.U).onKeyDown(paramInt, paramKeyEvent)))
                return true;
            else if (((this.U instanceof JDNewCategoryFragment)) && (((JDNewCategoryFragment) this.U).onKeyDown(paramInt, paramKeyEvent)))
                return true;
            else if (((this.U instanceof JDShoppingCartFragment)) && (((JDShoppingCartFragment) this.U).onKeyDown(paramInt, paramKeyEvent)))
                return true;
            else if (((this.U instanceof JDPersonalFragment)) && (this.U.onKeyDown(paramInt, paramKeyEvent)))
                return true;
            else {
                try {
                    ApplicationManager.a(this.U);
                    ApplicationManager.a();
                } catch (Exception e) {
                    if (Log.D)
                        e.printStackTrace();
                }
                try {
                    this.b.b(0);
                } catch (Throwable e) {
                    if (Log.D)
                        e.printStackTrace();
                }
                return true;
            }
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        if (paramIntent != null) {
            try {
                if (Log.D) {
                    Log.d(this.f, "onNewIntent intent:" + paramIntent);
                    Log.d(this.f, "onNewIntent intent:" + paramIntent.getExtras());
                }
                Intent localIntent = getIntent();
                ActivityNumController.a(MainFrameActivity.class.getSimpleName());
                if ((paramIntent.getExtras() != null) && (localIntent != null)) {
                    a(paramIntent.getExtras());
                    localIntent.putExtras(paramIntent.getExtras());
                }
                int i1 = paramIntent.getIntExtra("com.360buy:navigationId", 0);
                Log.d("navigation-click", " main " + i1 + "  mc  " + this.lastIndex);
                if (i1 != this.lastIndex) {
                    this.lastIndex = i1;
                    this.b.b(this.lastIndex);
                }
            } catch (Exception e) {
                if (Log.E)
                    e.printStackTrace();
            }
        }
        return;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (Log.D)
            Log.d("Temp", "onOptionsItemSelected -->>id= " + paramMenuItem.getItemId());
        if (JDUntil.hasSmartBar()) {//if-eqz v0, :cond_2
            switch (paramMenuItem.getItemId()) {
                case R.id.menu_home://pswitch_0  2131173072  7F071ED0
                    this.b.b(0);
                    return true;
                case R.id.menu_category://pswitch_1  2131173073  7F071ED1
                    this.b.b(1);
                    return true;
                case R.id.menu_car://pswitch_2  2131173074  7F071ED2
                    this.b.b(3);
                    return true;
                case R.id.menu_personal://pswitch_3  2131173076  7F071ED4
                    this.b.b(4);
                    return true;
                case R.id.menu_faxian://pswitch_4  2131173075  7F071ED3
                    this.b.b(2);
                    return true;
            }
            return true;
        } else {
            int i1 = paramMenuItem.getItemId();
            if (this != null) {
                JDMtaUtils.onClick(this, "Menu_MenuOption", MainFrameActivity.class.getName());
                BaseActivity activity = null;
                switch (i1) {
                    case R.id.menu_about://2131165402://7F0700DA  sswitch_0
                        startActivity(new Intent(this, AboutActivity.class));
                        return true;
                    case R.id.menu_search://2131165408: 7F0700E0  sswitch_1
                        activity = (BaseActivity) this;
                        if (!(this instanceof MyActivity))
                            activity = (BaseActivity) BaseApplication.getInstance().getCurrentMyActivity();
                        activity.startActivityForResult(new Intent(activity, SearchActivity.class), 272);
                        return true;
                    case R.id.menu_history://2131165407: 7F0700DF  sswitch_2
                        activity = (BaseActivity) this;
                        if (!(this instanceof MyActivity))
                            activity = (BaseActivity) BaseApplication.getInstance().getCurrentMyActivity();
                        LoginUser.getInstance().executeLoginRunnable(activity, new Runnable() {// ab(this);
                            @Override
                            public void run() {
                                MainFrameActivity.this.startActivity(new Intent(MainFrameActivity.this, HistoryListActivity.class));
                            }
                        });
                        return true;
                    case R.id.menu_feedback://2131165405: 7F0700DD  sswitch_3
                        startActivity(new Intent(this, FeedbackActivity.class));
                        return true;
                    case R.id.menu_setup://2131165409: 7F0700E1 sswitch_4
                        startActivity(new Intent(this, MoreActivity.class));
                        return true;
                    case R.id.menu_nightmode://2131173071:  7F071ECF  sswitch_5
                        new NightModeDialog(this, R.style.nightModeDialogTheme).show();//2131296562
                        JDMtaUtils.onClick(this, "MenuOption_LightAdjust", MainFrameActivity.class.getName());
                        return true;
                    case R.id.menu_exit://2131165404: 7F0700DC sswitch_6
                        BaseApplication.exitDialog();
                        break;
                }
                return true;
            }
        }
        return true;
    }

    protected void onPause() {
        this.o = false;
        this.p = new Date();
        super.onPause();
    }

    protected void onResume() {
        NavigationOptHelper.getInstance().c();
        this.T = false;
        super.onResume();
        if (Log.D)
            Log.d("Temp", "MainFrameActivity onResume() -->> ");
        try {
            this.o = true;
            getHandler().postDelayed(new Runnable() {//ah(this)
                @Override
                public void run() {
                    if ((MainFrameActivity.this.p != null)
                            && (new Date().getTime() - MainFrameActivity.this.p.getTime() > com.jingdong.common.config.Configuration.getIntegerProperty("leaveTimeGap").intValue()))
                        GlobalInitialization.regDevice();
                    LocManager.getInstance().d();
                }
            }, 100L);
            if (this.n != null) {
                getHandler().post(this.n);
                this.n = null;
            }
            int i1 = 0;
            if (!this.X)
                i1 = android.provider.Settings.System.getInt(getContentResolver(), "always_finish_activities", 0);
            switch (i1) {
                case 1:
                    final JDDialog localJDDialog = JDDialogFactory.getInstance().createJdDialogWithStyle2(this, getString(R.string.always_finish_activities), getString(R.string.cancel), getString(R.string.set_close));//2131230841 //2131230726    //2131233653
                    localJDDialog.setOnLeftButtonClickListener(new View.OnClickListener() {//ak(this, localJDDialog)
                        @Override
                        public void onClick(View v) {
                            MainFrameActivity.this.X = true;
                            localJDDialog.dismiss();
                        }
                    });
                    localJDDialog.setOnRightButtonClickListener(new View.OnClickListener() {//al(this)
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
                                MainFrameActivity.this.startActivity(intent);
                            } catch (java.lang.Exception paramView) {
                            }
                            return;
                        }
                    });
                    localJDDialog.show();
                    break;
            }
            AuraSwitchOfNetwork.a(BaseApplication.getInstance().getCurrentMyActivity(), true);
            AuraUpdate.a();
        } catch (Exception e) {
            if (Log.D)
                Log.d("Temp", " onResume()-->> " + e.getMessage());
        }
        try {
            getHandler().postDelayed(new Runnable() {//ai(this)
                @Override
                public void run() {
                    HybridUpdate.getInstance(MainFrameActivity.this, "com.jd.app.main").check();
                }
            }, 100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            getHandler().postDelayed(new Runnable() {//aj(this)
                @Override
                public void run() {
                    ReactNativeUpdate.getInstance(MainFrameActivity.this).checkUpdate();
                }
            }, 5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("lastIndex", NavigationOptHelper.getInstance().lastIndex);
        paramBundle.putBoolean("isFromMainFrameInstance", true);
    }

    protected void onStop() {
        if (Log.D)
            Log.d(this.f, " -->> onStop ");
        this.T = true;
        try {
            super.onStop();
            LocManager.getInstance().c();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return;
    }

    public boolean removeGuideView() {
        if ((!this.M) && (this.O != null) && (this.N != null) && (this.N.isShown())) {
            this.N.removeView(this.O);
            this.N = null;
            this.O = null;
            this.M = true;
            return true;
        }
        return false;
    }

    private static void synthetic_u(MainFrameActivity paramMainFrameActivity) {
        final AlertDialog localAlertDialog = new AlertDialog.Builder(paramMainFrameActivity).create();
        localAlertDialog.setTitle(R.string.prompt);//2131233421
        View localView = ImageUtil.inflate(R.layout.cost_alert, new RelativeLayout(paramMainFrameActivity));//2130903329
        CheckBox localCheckBox = (CheckBox) localView.findViewById(R.id.not_show_again);//2131166716
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//x(paramMainFrameActivity)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.not_show_again://2131166716
                        SharedPreferences sharedPreferences = CommonUtil.getJdSharedPreferences();
                        if (isChecked)
                            sharedPreferences.edit().putBoolean("showCost", false).commit();
                        else
                            sharedPreferences.edit().putBoolean("showCost", true).commit();
                }

            }
        });
        localCheckBox.setChecked(false);
        localAlertDialog.setView(localView);
        localAlertDialog.setButton(paramMainFrameActivity.getText(R.string.ok), new DialogInterface.OnClickListener() {//y(paramMainFrameActivity, localAlertDialog) //2131232844
            @Override
            public void onClick(DialogInterface dialog, int which) {
                localAlertDialog.dismiss();
            }
        });
        localAlertDialog.setButton2(paramMainFrameActivity.getText(R.string.cancel), new DialogInterface.OnClickListener() {//z(paramMainFrameActivity)  //2131230726
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BaseApplication.exitAll();
            }
        });
        localAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {//aa(paramMainFrameActivity)
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return true;
            }
        });
        localAlertDialog.show();
    }

    private static void synthetic_a(MainFrameActivity paramMainFrameActivity) {
        if (Log.D) {
            Log.d("Temp", "HomeActivity initNetwork() -->> ");
        }
        new Thread() {
            @Override
            public void run() {
                setName("MainFrameActivity_initNetwork");
                UpdateInitialization.getUpdateInitializationInstance().initNetwork();
            }
        }.start();
    }

    public class _Ad extends Thread {
        @Override
        public void run() {
            super.run();
            if (Log.D)
                Log.d("self_flowData", "url = ");
            int uid = 0;
            try {
                ApplicationInfo applicationInfo = MainFrameActivity.this.getPackageManager().getApplicationInfo("com.jingdong.app.mall", 1);//v0
                uid = applicationInfo.uid;
                if (Log.D) {
                    Log.d("self_flowData", "uid= " + uid);
                }
            } catch (PackageManager.NameNotFoundException e1) {
                if (Log.D)
                    e1.printStackTrace();
            }
            long rx = TrafficStats.getUidRxBytes(uid);
            long tx = TrafficStats.getUidTxBytes(uid);
            long v4 = rx + tx;
            if (Log.D) {
                Log.d("self_flowData", "uid=" + uid + "  ;  totalBytes=" + v4 + "     ;  rxBytes=" + tx + "     ;  txBytes=" + tx);
            }
            String v6 = "{}";
            try {
                JSONObjectProxy v8 = new JSONObjectProxy();
                v8.put("totalBytes", v4);
                v8.put("rxBytes", rx);
                v8.put("txBytes", tx);
                v6 = v8.toString();
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            if (Log.D) {
                Log.d("self_flowData", "postDataStr:   " + v6);
            }
            ExceptionReporter.reportFlowData("", v6);

        }
    }
}








