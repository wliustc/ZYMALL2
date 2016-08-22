package com.zy.app.mall.category;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import com.jingdong.app.mall.color.CameraActivity;
import com.jingdong.app.mall.more.VoiceSearchActivity;
import com.jingdong.app.mall.more.VoiceSearchLayout;
import com.jingdong.app.mall.navigationbar.NavigationOptHelper;
import com.jingdong.app.mall.personel.MyMessageBox;
import com.jingdong.app.mall.personel.a.a.PersonalMessageManager;
import com.jingdong.app.mall.search.CameraPurchaseActivity;
import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.app.mall.utils.LoginUser;
import com.jingdong.common.BaseActivity;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.login.LoginUserBase;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.JDFrescoUtils;

import com.jingdong.lib.zxing.client.android.CaptureActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.basic.JDTaskModule;

import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.b.RightListColumn;
import com.zy.app.mall.category.c.CatelogyUtil;
import com.zy.app.mall.navigationbar.JDTabFragment;
import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;
import com.zy.app.mall.searchRefactor.view.Activity.SearchActivity;
import com.zy.common.e.ConfigUtil;
import com.zy.common.entity.SourceEntity;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.FileUtils;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;
import com.zy.common.utils.StatisticsReportUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 2016/5/19.
 */
public class JDNewCategoryFragment extends JDTabFragment implements PersonalMessageObserver {

    private static JDNewCategoryFragment instance;
    private static final String TAG = JDNewCategoryFragment.class.getSimpleName();

    private List<RightColumnBase> B = new ArrayList();
    private JSONArrayProxy C = null;
    private String D = null;
    private String E = null;
    private int F;
    private String G = null;
    private String H;
    private View sublist_loading_error_tips; //I
    private Button jd_tip_button;   //J
    private ImageView jd_tip_image;    //K
    private View L; //L
    private View M; //M
    private Button N;   //N
    private ImageView O;    //O
    private BaseActivity P; //P
    private View mCategoryFragmentLayout;
    private boolean r1 = false;
    private boolean S = false;
    private List<String> T = new ArrayList();
    private boolean U = false;
    private String V;
    private boolean W = false;
    private boolean X;
    private boolean Y;
    private boolean Z;
    View a;
    private boolean aa;
    private Fragment ab = null;
    private String ac = null;
    AutoCompleteTextView search_text; //b
    RelativeLayout c;   //c
    TextView d; //d
    SimpleDraweeView e; //e
    ImageView f;    //f
    HashMap<String, ArrayList<com.zy.app.mall.category.b.RightColumnBase>> g;
    BroadcastReceiver h;
    protected String i = "";
    protected String j = "";
    protected boolean k = true;
    View.OnTouchListener l = new View.OnTouchListener(){//new n(this);
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                //invoke-direct {p0, v0, v0}, Lcom/jingdong/app/mall/category/JDNewCategoryFragment;->a(Ljava/lang/String;Ljava/lang/String;)V
                JDNewCategoryFragment.this.a((String)null);
                return true;
            }
            return false;
        }
    };
    private String o = "-1";
    private String p;
    private String q;
    private View r;
    private ListView left_list;

    private View u;
    private boolean v = false;
    private int w = 0;
    private long x = 0L;
    private PopupWindow y;
    private View.OnClickListener z = new View.OnClickListener(){//q(this, 0);
        @Override
        public void onClick(View view) {

        }
    };

    public static JDNewCategoryFragment getInstance() {
        if (instance == null)
            synchronized (JDNewCategoryFragment.class) {
                if (instance == null)
                    instance = new JDNewCategoryFragment();
            }
        return instance;
    }


    private static List<String> a(List<RightColumnBase> paramList)
    {
        ArrayList<String> localArrayList = new ArrayList();
        Iterator iterator = paramList.iterator();

        return localArrayList;
    }

    private void a(Fragment paramFragment)
    {
        if ((paramFragment != null) && (isAdded()))
        {
            FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
            if (localFragmentTransaction != null)
            {
                localFragmentTransaction.replace(R.id.id_content, paramFragment);//2131166228
                localFragmentTransaction.commitAllowingStateLoss();
                this.ab = paramFragment;
            }
        }
    }

    private void a(String paramString)
    {

    }

    private void a(String paramString1, String paramString2)
    {
        try
        {
            if ((VoiceSearchLayout.isUseJdCustomerVoiceService()) && ("type".equals(paramString1)) && ("voice".equals(paramString2)))
            {
                Context context = this.P.getBaseContext();
                Intent intent = new Intent(context, VoiceSearchActivity.class);
                intent.putExtra("isFromHome", true);
                intent.putExtra("source", new SourceEntity("Classification_VSearch", ""));
                intent.setFlags(268435456);
                context.startActivity(intent);
                JDMtaUtils.sendCommonData(this.P.getBaseContext(), "Classification_VSearch", "", "onClick", this, JDNewCategoryFragment.class.getSimpleName(), VoiceSearchActivity.class, "");
                return;
            }else {
                Context localContext = this.P.getBaseContext();
                Intent localIntent = new Intent(localContext, SearchActivity.class);
                if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
                    localIntent.putExtra(paramString1, paramString2);
                localIntent.putExtra("isFromHome", true);
                localIntent.addFlags(65536);
                localIntent.putExtra("isNoAnimation", true);
                localIntent.setFlags(268435456);
                localContext.startActivity(localIntent);
                JDMtaUtils.sendCommonData(this.P, "Search_Search", "", "", this, "", SearchActivity.class, "");
                return;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {

        return;
    }

    private boolean a(boolean paramBoolean, View paramView)
    {
        if (paramBoolean)
        {
            paramView.setVisibility(View.VISIBLE);//0
            paramView.setOnClickListener(this.z);
        }else
            paramView.setVisibility(View.GONE);//8;
        return true;
    }

    @Override
    public final void a(int paramInt1, int paramInt2)
    {
        if (Log.D)
            Log.d("navigation-click", TAG + "   old-->" + paramInt1 + " now-->" + paramInt2);
    }

    @SuppressLint({"InflateParams"})
    public final void b()
    {

    }

    public String getPageParam() {
        int i3 = 0;
        String str;

        if (TextUtils.isEmpty(this.E))
            str = "0";
        else
            str = "1";


        String localObject = "1";
        if (i3 == 0)
            localObject = "0";

        return str + "_" +  localObject;
    }

    public void onAttach(Activity paramActivity)
    {
        this.P = ((BaseActivity)paramActivity);
        super.onAttach(paramActivity);
    }

    @Override
    public View onCreateViews(LayoutInflater paramLayoutInflater, Bundle paramBundle)
    {

        return this.mCategoryFragmentLayout;
    }

    public void onDetach()
    {
        super.onDetach();
    }

    @Override
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        return false;
    }

    public void onPause()
    {
        this.W = true;
        super.onPause();
        PersonalMessageManager.a(LoginUserBase.getLoginUserName());
        PersonalMessageManager.b(this);
    }

    @Override
    public void onPersonalMessageReceived(final Map<String, PersonalMessageChannel> paramMap)
    {
        post(new Runnable(){//a(this, paramMap)
            @Override
            public void run() {
                PersonalMessageChannel localObject;
                if ((paramMap != null) && (paramMap.containsKey("message")))
                {
                    localObject = (PersonalMessageChannel)paramMap.get("message");
                    if (localObject != null){
                        if (((PersonalMessageChannel)localObject).a())
                        {//if-eqz v1, :cond_4
                            int i = ((PersonalMessageChannel)localObject).num;
                            if (i <= 0)
                            {
                                JDNewCategoryFragment.this.e.setVisibility(View.GONE);
                                JDNewCategoryFragment.this.d.setVisibility(View.GONE);
                                return;
                            }else {
                                String str = "99+";
                                if (i <= 99)
                                    str = i + "";
                                JDNewCategoryFragment.this.e.setVisibility(View.GONE);
                                JDNewCategoryFragment.this.d.setText((CharSequence) localObject);
                                JDNewCategoryFragment.this.d.setVisibility(View.VISIBLE);
                                return;
                            }
                        }else if (((PersonalMessageChannel)localObject).b()){
                            JDNewCategoryFragment.this.e.setVisibility(View.VISIBLE);
                            JDNewCategoryFragment.this.d.setVisibility(View.GONE);
                            return;
                        }else {
                            JDNewCategoryFragment.this.d.setVisibility(View.GONE);
                            JDNewCategoryFragment.this.e.setVisibility(View.GONE);
                        }
                    }
                }
                return;
            }
        });
    }

    public void onResume()
    {
        super.onResume();
        PersonalMessageManager.a(LoginUserBase.getLoginUserName());
        PersonalMessageManager.a(this);
        if (LoginUser.hasLogin())
        {
            PersonalMessageManager.a(LoginUserBase.getLoginUserName());
            PersonalMessageManager.a(this.P.getHttpGroupWithNPSGroup());
        }
        if ((this.search_text != null) && (!isAdded())){
            if (!LoginUserBase.hasLogin())
            {
                this.e.setVisibility(View.GONE);//8;//8
                this.d.setVisibility(View.GONE);//8;//8
            }
            this.search_text.setHint(R.string.homeActivity_autoComplete);//2131231773
            this.V = CommonUtil.getJdSharedPreferences().getString("hintKeyWord", "");
            if (!TextUtils.isEmpty(this.V))
                this.search_text.setHint(this.V);
            NavigationOptHelper.getInstance();
            NavigationOptHelper.c(1);
            if ((this.v) && (!this.r1) && (this.left_list.getHeaderViewsCount() == 0))
                b();
            if (this.W) {
                a(this.ab);
                this.W = false;
            }
        }
        return;
    }

    protected void setPageId(String paramString)
    {
        this.i = paramString;
    }

    protected void setShopId(String paramString)
    {
        this.j = paramString;
    }

    static void synthetic_a(final JDNewCategoryFragment paramJDNewCategoryFragment, boolean paramBoolean1, boolean paramBoolean2)
    {

    }

    static boolean synthetic_q(JDNewCategoryFragment paramJDNewCategoryFragment)
    {
        long l1 = System.currentTimeMillis();
        if (l1 - paramJDNewCategoryFragment.x < 800L)
            return true;
        paramJDNewCategoryFragment.x = l1;
        return false;
    }

    public static class JDNewCategoryTM extends JDTaskModule
    {
        private JDNewCategoryFragment category;

        public void doInit()
        {
            this.category = JDNewCategoryFragment.getInstance();
            if (this.category.getArguments() == null)
            {
                getBundle().putInt("com.360buy:navigationFlag", 1);
                this.category.setArguments(getBundle());
            }
        }

        public void doShow()
        {
            replaceAndCommit(this.category, Integer.valueOf(1));
        }
    }
}
