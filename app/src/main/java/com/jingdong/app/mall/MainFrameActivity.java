package com.jingdong.app.mall;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.aura.AuraUpdate;
import com.jingdong.app.mall.basic.ActivityJumpController;
import com.jingdong.app.mall.basic.ApplicationManager;
import com.jingdong.app.mall.basic.ErrorActivity;
import com.jingdong.app.mall.basic.JDUntil;
import com.jingdong.app.mall.faxian.JDFaxianFragment;
import com.jingdong.app.mall.home.HomePageObserver;
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
import com.jingdong.app.mall.utils.StartActivityUtils;
import com.jingdong.common.ActivityNumController;
import com.jingdong.common.BaseApplication;
import com.jingdong.common.c.LocManager;
import com.jingdong.common.utils.CommonBase;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.FileService;
import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.HttpGroupUtils;
import com.jingdong.common.utils.JSONObjectProxy;
import com.jingdong.jdma.common.utils.Md5Encrypt;
import com.zy.app.mall.R;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.navigationbar.TabFragment;
import com.zy.app.mall.searchRefactor.view.Activity.SearchActivity;
import com.zy.app.mall.utils.MyActivity;
import com.zy.app.mall.utils.frame.TabBarButton;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.cleanmvp.ui.BaseFragment;
import com.zy.common.BaseActivity;
import com.zy.common.ScrollableTabActivity;
import com.zy.common.entity.SourceEntity;
import com.zy.common.frame.IMainActivity;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.JDImageUtils;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;
import com.zy.common.utils.TimerUntil;

import org.json.JSONException;
import org.json.JSONObject;

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

    private static TabBarButton.StateController J;
    private static TabBarButton.RedPoint P;
    private static TabBarButton.RedPoint Q;
    private static ArrayList<String> fragmentList = new ArrayList();//R
    private static Menu S;
    public static boolean a = true;
    public static boolean c;
    private String A = "";
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private Intent G;
    private Integer H;
    private Handler handler;
    private boolean K;
    private boolean L;
    private boolean M;
    private ViewGroup N;
    private RelativeLayout O;
    private boolean T = false;
    private BaseFragment U;
    private int lastIndex;//V
    private TabFragment W;
    private boolean X;
    private int Y;
    private MenuItem Z;
    private MenuItem aa;
    private MenuItem ab;
    private int ac;
    public NavigationFragment b;
    final int d = 272;
    private final String f = MainFrameActivity.class.getSimpleName();
    private final Set<String> g = new HashSet();
    private final int h = 30000;
    private final String i = "startimage.image";
    private final int j = 1;
    private final int k = 2;
    private final int l = 3;
    private final int m = 30000;
    private Runnable n = null;
    private boolean o = false;
    private Date p;
    private int q = 0;
    private Map r = new HashMap();
    private String s = "";
    private String t = "";
    private String u = "";
    private String v = "";
    private String w = "";
    private String x = "";
    private String y = "";
    private String z = "";

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

    public static void a(TabBarButton.StateController paramb)
    {
        J = paramb;
    }


    public static void a(TabBarButton.RedPoint paramc)
    {
        P = paramc;
    }

    private void a(String paramString)
    {
        this.g.remove(paramString);
    }

    public static void a(boolean paramBoolean)
    {
        final TabBarButton.RedPoint localc = Q;
        if (localc != null
                && (BaseApplication.getInstance().getMainFrameActivity() != null)
                && (BaseApplication.getInstance().getMainFrameActivity().getHandler() != null))
            BaseApplication.getInstance().getMainFrameActivity().getHandler().post(new Runnable(){//af(true, localc)
                @Override
                public void run() {
                    if (true)
                    {
                        CommonUtil.putIntToPreference("shared_faxian_redpoint_flag", 1);
                        if (CommonBase.getJdFaxianNewFlag())
                        {
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

    public static boolean a()
    {
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

    public static void b()
    {
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

    private void b(Bundle paramBundle)
    {
        if (Log.D)
            Log.d(this.f, "showSearchActivity() -->> ");
        if (((BaseActivity)BaseApplication.getInstance().getCurrentMyActivity() instanceof SearchActivity))
            return;
        startActivityForResult(new Intent(this, SearchActivity.class), 272);
    }

    public static void b(TabBarButton.RedPoint paramc)
    {
        Q = paramc;
    }

    public static void d()
    {
        if (Log.D)
            Log.d("Temp", "MainFrameActivity clearCache() -->> ");
        new Thread(){//ac()
            @Override
            public void run() {
                setName("MainFrameActivity_clearCache");
                android.os.Process.setThreadPriority(19);
                FileService.d();
                FileService.e();
            }
        }.start();
    }

    public static TabBarButton.RedPoint f()
    {
        return P;
    }

    public static TabBarButton.RedPoint g()
    {
        return Q;
    }

    public static void h()
    {
    }

    protected static String m()
    {
        String str = "";
        try
        {
            str = BaseApplication.getInstance().getPackageManager().getPackageInfo(BaseApplication.getInstance().getPackageName(), 0).versionName;
        }
        catch (Exception localException)
        {
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
                BaseApplication.getInstance().getMainFrameActivity().getHandler().post(new Runnable(){//ae(localb, localInteger)
                    @Override
                    public void run() {
                        J.a(finalLocalInteger);
                    }
                });
            }
        }
    }

    public final void a(int paramInt)
    {
        switch (this.ac)
        {

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
        switch (paramInt)
        {
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

    public final void c()
    {
        if (Log.D)
            Log.d(this.f, "checkTargetActivity() -->> ");
        SharedPreferences sharedPreferences = CommonUtil.getJdSharedPreferences();
        Object localObject2 = ((SharedPreferences)sharedPreferences).getString("cameraFilePath", null);
        String str = ((SharedPreferences)sharedPreferences).getString("photoType", null);
        int i1 = ((SharedPreferences)sharedPreferences).getInt("photoTypeIndex", 0);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
            Intent localIntent = new Intent(this, CameraPurchaseActivity.class);
            localIntent.putExtra("cameraPath", (String)localObject2);
            localIntent.putExtra("categoryTypeArray", str);
            localIntent.putExtra("categoryTypeIndex", i1);
            startActivity(localIntent);
            SharedPreferences.Editor editor = ((SharedPreferences)sharedPreferences).edit();
            ((SharedPreferences.Editor)editor).remove("cameraFilePath");
            ((SharedPreferences.Editor)editor).remove("photoType");
            ((SharedPreferences.Editor)editor).remove("photoTypeIndex");
            ((SharedPreferences.Editor)editor).commit();
        }else if (this.H != null)
        {
            localObject2 = new Intent(this, CameraPurchaseActivity.class);
            ((Intent)localObject2).putExtra("galleryData", this.G);
            ((Intent)localObject2).putExtra("categoryTypeArray", str);
            ((Intent)localObject2).putExtra("categoryTypeIndex", i1);
            startActivity((Intent)localObject2);
            SharedPreferences.Editor editor = ((SharedPreferences)sharedPreferences).edit();
            ((SharedPreferences)editor).edit().remove("photoType").commit();
            ((SharedPreferences)editor).edit().remove("photoTypeIndex").commit();
        }else{
            Bundle extras = getIntent().getExtras();
            if (Log.D)
                Log.d(this.f, "checkTargetActivity() bundle -->> " + extras);
            if (extras != null){
                final OpenAppJumpController openAppJumpController = OpenAppJumpController.a(getIntent());
                if (Log.D)
                    Log.d(this.f, "checkTargetActivity() command -->> " + openAppJumpController);
                if (openAppJumpController != null){
                    if (Log.D)
                        Log.d(this.f, "toTargetActivity -->> ");
                    OpenAppJumpController._A.a();
                    getHandler().post(new Runnable(){//u(this, (com.jingdong.app.mall.open.d)openAppJumpController)
                        @Override
                        public void run() {
                            final int i = openAppJumpController.a();
                            final Bundle localBundle = openAppJumpController.b();
                            if (Log.D)
                                Log.d(MainFrameActivity.this.f, "toTargetActivity moduleId -->> " + i);
                            if ((Log.D) && (localBundle != null))
                            {
                                Log.d(MainFrameActivity.this.f, "bundle -->> " + localBundle);
                                Iterator localIterator = localBundle.keySet().iterator();
                                while (localIterator.hasNext())
                                {
                                    String str = (String)localIterator.next();
                                    Object localObject = localBundle.get(str);
                                    Log.d(MainFrameActivity.this.f, "bundle key value -->> " + str + "：" + localObject);
                                }
                            }
                            //:cond_1
                            if (!MainFrameActivity.this.o)
                                MainFrameActivity.this.n = new Runnable(){//v(this, localBundle, i)
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
    public void finish()
    {
        BaseActivity currentMyActivity = getCurrentMyActivity();
        if (Log.D)
            Log.d(this.f, " MainFrame -->> finish() ");
        if (currentMyActivity != null)
        {
            Class<? extends BaseActivity> activityClass = currentMyActivity.getClass();
            if (activityClass != null)
            {
                String className = ((Class) activityClass).getName();
                if ((!TextUtils.isEmpty((CharSequence)className)) && (fragmentList.contains(className)))
                {
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
    public Activity getThisActivity()
    {
        return this;
    }

    public final BaseFragment i()
    {
        return this.U;
    }

    public final TabFragment j()
    {
        return this.W;
    }

    public final void k()
    {
        this.b.b(0);
    }

    @Override
    public final boolean l()
    {
        return this.T;
    }

    @Override
    public IMyActivity n() {
        return this.getCurrentMyActivity();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (Log.D)
            Log.d(this.f, "onActivityResult() -->> " + requestCode + "```" + resultCode);
        if ((272 == requestCode) && (-1 == resultCode))
        {//if-ne v0, p1, :cond_4    if-ne v0, p2, :cond_4
            Bundle extras = data.getExtras();
            if ((data != null) && (extras.getBoolean("isShop")))
            {//if-eqz v0, :cond_2   if-eqz v1, :cond_2
                String keyWord = extras.getString("keyWord");
                StartActivityUtils.a(this, keyWord, new SourceEntity("shop_from_search", keyWord));
            }else{
                Object localObject = new Intent(this, ProductListActivity.class);
                ((Intent)localObject).putExtras(extras);
                ((Intent)localObject).putExtra("sortKey", 5);
                if (extras != null)
                    ((Intent)localObject).putExtra("source", new SourceEntity("search", extras.getString("keyWord")));
                StartActivityUtils.a(this, (Intent)localObject, false);
            }
        }else if (requestCode == 12){//if-ne p1, v0, :cond_7
            if (getCurrentMyActivity() != null){//if-eqz v0, :cond_6
                BaseActivity localObject = getCurrentMyActivity();
                if ((localObject instanceof CameraPurchaseActivity))
                {//if-eqz v1, :cond_5
                    ((CameraPurchaseActivity)localObject).onActivityResult(requestCode, resultCode, data);
                    return;
                }else{
                    if (Log.D) {
                        System.err.println("MianActivity onActivityResult() getCurrentActivity instanceof CameraPurchaseActivity is false");
                        System.err.println(localObject.getClass().toString());
                    }
                }
            }else{
                this.G = data;
                this.H = Integer.valueOf(resultCode);
            }
        }else if ((requestCode >> 16 == 0) && (this.U != null))
            this.U.onActivityResult(requestCode, resultCode, data);
        else
            super.onActivityResult(requestCode, resultCode, data);

        return;

    }

    @Override
    public void onAttachFragment(Fragment paramFragment)
    {
        if (Log.D)
            Log.d(this.f, "onAttachFragment.. -->> " + paramFragment.getClass());
        super.onAttachFragment(paramFragment);
        try
        {
            this.U = ((BaseFragment)paramFragment);
            if (paramFragment.getId() == R.id.navigation_fragment)
                this.b = ((NavigationFragment)paramFragment);
            else
                this.W = ((TabFragment)paramFragment);
        }
        catch (Exception e)
        {
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
        getHandler().postDelayed(new Runnable(){//q(this)
            @Override
            public void run() {
                //TODO: 未实现
//                MainFrameActivity.d();
//                SharedPreferences localSharedPreferences = com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences();
//                Boolean localBoolean = Configuration.getBooleanProperty("applicationShortcut");
//                Object localObject = localBoolean;
//                if (localBoolean == null)
//                    localObject = Boolean.valueOf(true);
//                if ((!localSharedPreferences.getBoolean("add_short_cut_flag_500", false)) && (((Boolean)localObject).booleanValue()))
//                    fp.a(this.a);
//                MainFrameActivity.a(this.a, com.jingdong.app.mall.utils.CommonUtil.activityIsGuided("com.jingdong.app.mall.MainActivity"));
//                BaseApplication.networkSetting();
//                SafetyManager.initEncryptKey();
//                localSharedPreferences.edit().remove("appUseTime").commit();
//                MainFrameActivity.a(this.a);
//                localObject = com.jingdong.app.mall.utils.CommonUtil.getBooleanFromPreference(this.a.getString(2131232560), Boolean.valueOf(true));
//                if (((Boolean)localObject).booleanValue())
//                {
//                    if (Log.D)
//                        Log.d(MainFrameActivity.b(this.a), " -->> msgSwitch : " + localObject);
//                    if (dd.a())
//                    {
//                        localObject = com.jingdong.common.utils.CommonUtil.getBooleanFromPreference(StringUtil.msg_auto_update_switch_key, Configuration.getBooleanProperty("msgSwitch"));
//                        if (!((Boolean)localObject).booleanValue());
//                    }
//                }
//                try
//                {
//                    if (Log.D)
//                        Log.i("MessageUtil", "openMsgService-->> startPush.msgSwitch=" + localObject);
//                    com.jingdong.cloud.jdpush.a.a(BaseApplication.getInstance().getApplicationContext());
//                    com.jingdong.jdpush.a.a(BaseApplication.getInstance().getApplicationContext());
//                    y.a();
//                    c.a().a(this.a, this.a.getString(2131232411));
//                    int i = com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences().getInt("appStartCount", 0);
//                    localObject = com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences().edit();
//                    ((SharedPreferences.Editor)localObject).putInt("appStartCount", i + 1);
//                    ((SharedPreferences.Editor)localObject).commit();
//                    return;
//                }
//                catch (Exception localException)
//                {
//                        if (Log.D)
//                        localException.printStackTrace();
//                }
            }
        }, 100L);
        int i1 = ((Intent) getIntent()).getIntExtra("moduleId", -1);
        this.lastIndex = ((Intent) getIntent()).getIntExtra("com.360buy:navigationId", 0);
        a(getIntent().getExtras());
        if (this.a) {//if-eqz v0, :cond_12
            this.a = false;
            getHandler().postDelayed(new Runnable(){//w(this)
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
                        this.O.setOnTouchListener(new View.OnTouchListener(){//ag(this)
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                switch (event.getAction())
                                {
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
                                MainFrameActivity.this.F = ((JSONObjectProxy) localObject).optInt("countdown", 0);
                                localObject = ((JSONObjectProxy) localObject).getJSONArrayOrNull("images");
                                if (localObject != null) {//if-eqz v2, :cond_3
                                    MainFrameActivity.this.q = ((JSONArrayProxy) localObject).length();

                                    for (int i = 0; i < MainFrameActivity.this.q; i++) {//if-ge v0, v3, :cond_0
                                        JSONObjectProxy jsonObjectProxy = ((JSONArrayProxy) localObject).getJSONObjectOrNull(i);
                                        if (i == 0) {///if-nez v0, :cond_2
                                            MainFrameActivity.this.v = jsonObjectProxy.optString("mUrl", "");
                                            MainFrameActivity.this.t = jsonObjectProxy.optString("onlineTime", "");
                                            MainFrameActivity.this.u = jsonObjectProxy.optString("referralsTime", "");
                                            MainFrameActivity.this.A = jsonObjectProxy.optString("sourceValue", "");
                                            MainFrameActivity.this.B = jsonObjectProxy.optInt("time", 0);
                                            MainFrameActivity.this.C = jsonObjectProxy.optInt("ynRedirect", 0);
                                            MainFrameActivity.this.D = jsonObjectProxy.optInt("ynSkip", 0);
                                            MainFrameActivity.this.E = jsonObjectProxy.optInt("type", 0);
                                            MainFrameActivity.this.x = jsonObjectProxy.optString("shareTitle", "");
                                            MainFrameActivity.this.w = jsonObjectProxy.optString("shareUrl", "");
                                            MainFrameActivity.this.y = jsonObjectProxy.optString("shareContent", "");
                                            MainFrameActivity.this.z = jsonObjectProxy.optString("shareAvatar", "");
                                        } else {
                                            MainFrameActivity.this.A += ("||" + jsonObjectProxy.optString("sourceValue", ""));
                                        }
                                        //:goto_2
                                        JDImageUtils.loadImage(jsonObjectProxy.optString("url", "")
                                                , JDDisplayImageOptions.createSimple().cacheInMemory(false).bitmapConfig(Bitmap.Config.ARGB_8888)
                                                , new JDSimpleImageLoadingListener(){//t(localMainFrameActivity, i)

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
        new bi(getApplicationContext()).a();
        new ad(this).start();
        com.jingdong.app.mall.aura.a.a(BaseApplication.getInstance().getCurrentMyActivity(), true);
        return;
    }

    private static void synthetic_u(MainFrameActivity mainFrameActivity) {
        //TODO: 1477 .method static synthetic_u(Lcom/jingdong/app/mall/MainFrameActivity;)V
    }

    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        if (n.a())
            getMenuInflater().inflate(2131689475, paramMenu);
        while (true)
        {
            try
            {
                this.Z = paramMenu.getItem(0);
                this.aa = paramMenu.getItem(1);
                this.ab = paramMenu.getItem(2);
                a(this.V);
                if (this.M)
                    continue;
                removeGuideView();
                return true;
            }
            catch (Exception paramMenu)
            {
                paramMenu.printStackTrace();
                continue;
            }
            if (this.g.size() > 0)
                continue;
            getMenuInflater().inflate(2131689473, paramMenu);
            S = paramMenu;
        }
    }

    protected void onDestroy()
    {
        com.jingdong.common.c.c.j = true;
        super.onDestroy();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        if (Log.I)
            Log.i(this.f, "onSearchRequested++++main");
        if (paramInt == 84)
        {
            paramKeyEvent = JDHomeFragment.class.getSimpleName();
            String str = JDPersonalFragment.class.getSimpleName();
            Object localObject = this.U;
            if (localObject == null)
                return true;
            localObject = localObject.getClass().getSimpleName();
            if (Log.D)
                Log.d(this.f, "currentActivity -->> " + (String)localObject);
            if ((!paramKeyEvent.equals(localObject)) && (!str.equals(localObject)))
                b(null);
            return true;
        }
        if (paramInt == 4)
        {
            if (((this.U instanceof JDHomeFragment)) && (((JDHomeFragment)this.U).onKeyDown(paramInt, paramKeyEvent)))
                return true;
            if (((this.U instanceof JDNewCategoryFragment)) && (((JDNewCategoryFragment)this.U).onKeyDown(paramInt, paramKeyEvent)))
                return true;
            if (((this.U instanceof JDShoppingCartFragment)) && (((JDShoppingCartFragment)this.U).onKeyDown(paramInt, paramKeyEvent)))
                return true;
            if (((this.U instanceof JDPersonalFragment)) && (this.U.onKeyDown(paramInt, paramKeyEvent)))
                return true;
            try
            {
                l.a(this.U);
                l.a();
            }
            catch (Exception paramKeyEvent)
            {
                try
                {
                    while (true)
                    {
                        this.b.b(0);
                        return true;
                        paramKeyEvent = paramKeyEvent;
                        if (!Log.D)
                            continue;
                        paramKeyEvent.printStackTrace();
                    }
                }
                catch (Throwable paramKeyEvent)
                {
                    while (true)
                    {
                        if (!Log.D)
                            continue;
                        paramKeyEvent.printStackTrace();
                    }
                }
            }
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    protected void onNewIntent(Intent paramIntent)
    {
        super.onNewIntent(paramIntent);
        if (paramIntent == null);
        do
            while (true)
            {
                return;
                try
                {
                    if (Log.D)
                    {
                        Log.d(this.f, "onNewIntent intent:" + paramIntent);
                        Log.d(this.f, "onNewIntent intent:" + paramIntent.getExtras());
                    }
                    Intent localIntent = getIntent();
                    com.jingdong.common.a.a(MainFrameActivity.class.getSimpleName());
                    if ((paramIntent.getExtras() != null) && (localIntent != null))
                    {
                        a(paramIntent.getExtras());
                        localIntent.putExtras(paramIntent.getExtras());
                    }
                    int i1 = paramIntent.getIntExtra("com.360buy:navigationId", 0);
                    Log.d("navigation-click", " main " + i1 + "  mc  " + this.V);
                    if (i1 == this.V)
                        continue;
                    this.V = i1;
                    this.b.b(this.V);
                    return;
                }
                catch (Exception paramIntent)
                {
                }
            }
        while (!Log.E);
        paramIntent.printStackTrace();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        if (Log.D)
            Log.d("Temp", "onOptionsItemSelected -->>id= " + paramMenuItem.getItemId());
        if (n.a())
            switch (paramMenuItem.getItemId())
            {
                default:
                case 2131173072:
                case 2131173073:
                case 2131173074:
                case 2131173076:
                case 2131173075:
            }
        int i1;
        do
        {
            return true;
            this.b.b(0);
            return true;
            this.b.b(1);
            return true;
            this.b.b(3);
            return true;
            this.b.b(4);
            return true;
            this.b.b(2);
            return true;
            i1 = paramMenuItem.getItemId();
        }
        while (this == null);
        JDMtaUtils.onClick(this, "Menu_MenuOption", MainFrameActivity.class.getName());
        switch (i1)
        {
            default:
                return true;
            case 2131165402:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case 2131165408:
                if ((this instanceof MyActivity));
                for (paramMenuItem = (BaseActivity)this; ; paramMenuItem = (BaseActivity)BaseApplication.getInstance().getCurrentMyActivity())
                {
                    paramMenuItem.startActivityForResult(new Intent(paramMenuItem, SearchActivity.class), 272);
                    return true;
                }
            case 2131165407:
                if ((this instanceof MyActivity));
                for (paramMenuItem = (BaseActivity)this; ; paramMenuItem = (BaseActivity)BaseApplication.getInstance().getCurrentMyActivity())
                {
                    ab localab = new ab(this);
                    LoginUser.getInstance().executeLoginRunnable(paramMenuItem, localab);
                    return true;
                }
            case 2131165405:
                startActivity(new Intent(this, FeedbackActivity.class));
                return true;
            case 2131165409:
                startActivity(new Intent(this, MoreActivity.class));
                return true;
            case 2131173071:
                new com.jingdong.app.mall.utils.ui.af(this, 2131296562).show();
                JDMtaUtils.onClick(this, "MenuOption_LightAdjust", MainFrameActivity.class.getName());
                return true;
            case 2131165404:
        }
        BaseApplication.exitDialog();
        return true;
    }

    protected void onPause()
    {
        this.o = false;
        this.p = new Date();
        super.onPause();
    }

    protected void onResume()
    {
        com.jingdong.app.mall.navigationbar.j.a().c();
        this.T = false;
        super.onResume();
        if (Log.D)
            Log.d("Temp", "MainFrameActivity onResume() -->> ");
        try
        {
            this.o = true;
            getHandler().postDelayed(new ah(this), 100L);
            if (this.n != null)
            {
                getHandler().post(this.n);
                this.n = null;
            }
            int i1;
            if (!this.X)
                i1 = Settings.System.getInt(getContentResolver(), "always_finish_activities", 0);
            switch (i1)
            {
                default:
                    com.jingdong.app.mall.aura.internal.b.a(BaseApplication.getInstance().getCurrentMyActivity(), true);
                    com.jingdong.app.mall.aura.j.a();
                case 1:
            }
        }
        catch (Exception localException3)
        {
            try
            {
                getHandler().postDelayed(new ai(this), 100L);
            }
            catch (Exception localException3)
            {
                try
                {
                    while (true)
                    {
                        getHandler().postDelayed(new aj(this), 5000L);
                        return;
                        JDDialog localJDDialog = JDDialogFactory.getInstance().createJdDialogWithStyle2(this, getString(2131230841), getString(2131230726), getString(2131233653));
                        localJDDialog.setOnLeftButtonClickListener(new ak(this, localJDDialog));
                        localJDDialog.setOnRightButtonClickListener(new al(this));
                        localJDDialog.show();
                        continue;
                        localException1 = localException1;
                        if (!Log.D)
                            continue;
                        Log.d("Temp", " onResume()-->> " + localException1.getMessage());
                        continue;
                        localException2 = localException2;
                        localException2.printStackTrace();
                    }
                }
                catch (Exception localException3)
                {
                    localException3.printStackTrace();
                }
            }
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle)
    {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("lastIndex", com.jingdong.app.mall.navigationbar.j.a().a);
        paramBundle.putBoolean("isFromMainFrameInstance", true);
    }

    protected void onStop()
    {
        if (Log.D)
            Log.d(this.f, " -->> onStop ");
        this.T = true;
        try
        {
            super.onStop();
            com.jingdong.common.c.c.a().c();
            return;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }

    public boolean removeGuideView()
    {
        if ((!this.M) && (this.O != null) && (this.N != null) && (this.N.isShown()))
        {
            this.N.removeView(this.O);
            this.N = null;
            this.O = null;
            this.M = true;
            return true;
        }
        return false;
    }

    /////////////////////////////////////














}
