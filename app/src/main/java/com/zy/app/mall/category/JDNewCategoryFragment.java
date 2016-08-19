package com.zy.app.mall.category;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.jingdong.app.mall.search.CameraPurchaseActivity;
import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.app.mall.utils.LoginUser;
import com.jingdong.common.BaseActivity;
import com.jingdong.common.login.LoginUserBase;
import com.jingdong.lib.zxing.client.android.CaptureActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.category.adapter.LeftListAdapter;
import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.b.RightListColumn;
import com.zy.app.mall.category.c.CatelogyUtil;
import com.zy.app.mall.navigationbar.JDTabFragment;
import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;
import com.zy.app.mall.searchRefactor.view.Activity.SearchActivity;
import com.zy.common.entity.Catelogy;
import com.zy.common.entity.SourceEntity;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

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
    private static final String n = JDNewCategoryFragment.class.getSimpleName();
    private ArrayList<Catelogy> A = new ArrayList();
    private List<RightColumnBase> B = new ArrayList();
    private JSONArrayProxy C = null;
    private String D = null;
    private String E = null;
    private int F;
    private String G = null;
    private String H;
    private View I;
    private Button J;
    private ImageView K;
    private View L;
    private View M;
    private Button N;
    private ImageView O;
    private BaseActivity P;
    private View Q;
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
    AutoCompleteTextView b;
    RelativeLayout c;
    TextView d;
    SimpleDraweeView e;
    ImageView f;
    HashMap<String, ArrayList<com.zy.app.mall.category.b.RightColumnBase>> g;
    p h;
    protected String i = "";
    protected String j = "";
    protected boolean k = true;
    View.OnTouchListener l = new View.OnTouchListener(){//new n(this);
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                //invoke-direct {p0, v0, v0}, Lcom/jingdong/app/mall/category/JDNewCategoryFragment;->a(Ljava/lang/String;Ljava/lang/String;)V
                JDNewCategoryFragment.this.a(null);
                return true;
            }
            return false;
        }
    }:
    private String o = "-1";
    private String p;
    private String q;
    private View r;
    private ListView s;
    private LeftListAdapter t;
    private View u;
    private boolean v = false;
    private int w = 0;
    private long x = 0L;
    private PopupWindow y;
    private View.OnClickListener z = new View.OnClickListener(){//q(this, 0);
        @Override
        public void onClick(View view) {
            Context context = null;
            view.setPressed(false);
            switch (view.getId())
            {
                default:
                    return;
                case R.id.search_voice:    //2131168592 7F070D50    sswitch_0
                    JDNewCategoryFragment.this.a("type", "voice");
                    return;
                case R.id.search_barcode_btn:    //2131165520   7F070150    sswitch_1
                    //JDNewCategoryFragment.r(this.a);
                    if(JDNewCategoryFragment.this.y != null && JDNewCategoryFragment.this.y.isShowing())
                        JDNewCategoryFragment.this.y.dismiss();
                    context = JDNewCategoryFragment.this.P.getBaseContext();
                    if (CatelogyUtil.a(context))
                        context.startActivity(new Intent(context, CaptureActivity.class));
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.P, "Scan_Scan", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.P.getClass(), "");
                    return;
                case R.id.search_camera_btn:    //2131165521    7F070151    sswitch_2
                    //JDNewCategoryFragment.r(this.a);
                    if(JDNewCategoryFragment.this.y != null && JDNewCategoryFragment.this.y.isShowing())
                        JDNewCategoryFragment.this.y.dismiss();
                    context = JDNewCategoryFragment.this.P.getBaseContext();
                    if (CatelogyUtil.a(context))
                        context.startActivity(new Intent(context, CameraPurchaseActivity.class));
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.P, "Scan_PhotoBuy", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.P.getClass(), "");
                    return;
                case R.id.color_shopping_btn:    //2131165523   7F070153    sswitch_3
                    //JDNewCategoryFragment.r(this.a);
                    if(JDNewCategoryFragment.this.y != null && JDNewCategoryFragment.this.y.isShowing())
                        JDNewCategoryFragment.this.y.dismiss();
                    context = JDNewCategoryFragment.this.P.getBaseContext();
                    if (CatelogyUtil.a(context))
                    {
                        Intent localIntent = new Intent(context, CameraActivity.class);
                        localIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
                        context.startActivity(localIntent);
                    }
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.P, "Scan_ColorBuy", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.P.getClass(), "");
                    return;
            }

        }
    }:

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
        while (iterator.hasNext())
        {
            RightListColumn localObject = (RightListColumn)iterator.next();
            if (localObject.a != 1)
                continue;

            for (int i1 = 0; i1 < localObject.c(); i1++)
            {
                String str = localObject.a(i1).getImgUrl();
                if (!TextUtils.isEmpty(str))
                    localArrayList.add(str);
            }
        }
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
        if (this.w < 0)
        {
            Log.e(n, "Current Item is -1!!!");
            return;
        }
        this.ac = paramString;
        Object localObject2 = ((Catelogy)this.A.get(this.w)).getMergeCatalogs();
        Object localObject1 = localObject2;
        if (bp.b("/sdcard/jd_test_merged_category"))
        {
            localObject1 = localObject2;
            if (this.w == 0)
            {
                localObject1 = new ArrayList();
                int i1 = 0;
                while (i1 < 5)
                {
                    localObject2 = new Catelogy.MergedCatelogy();
                    Catelogy localCatelogy = (Catelogy)this.A.get(i1);
                    ((Catelogy.MergedCatelogy)localObject2).setId(localCatelogy.getcId());
                    ((Catelogy.MergedCatelogy)localObject2).setName(localCatelogy.getName());
                    ((Catelogy.MergedCatelogy)localObject2).setOrder(i1);
                    ((List)localObject1).add(localObject2);
                    i1 += 1;
                }
            }
        }
        if (localObject1 != null)
        {
            paramString = new ConjoinedCategoryFragment();
            paramString.a(this.L);
            paramString.a(this.I, this.K);
            paramString.a(this.H, this.D, this.w);
            paramString.a(this.P);
            paramString.a((List)localObject1);
            a(paramString);
            return;
        }
        localObject1 = (OrdinaryL2CategoryFragment)OrdinaryL2CategoryFragment.b(paramString, this.D, this.w);
        ((OrdinaryL2CategoryFragment)localObject1).a(this.L);
        ((OrdinaryL2CategoryFragment)localObject1).a(this.I, this.K);
        ((L2CategoryFragment)localObject1).thisActivity = this.P;
        ((OrdinaryL2CategoryFragment)localObject1).a(new e(this));
        ((OrdinaryL2CategoryFragment)localObject1).d(paramString);
        a((Fragment)localObject1);
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
            }
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
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
        this.X = paramBoolean1;
        this.Y = paramBoolean2;
        this.Z = paramBoolean3;
        this.aa = paramBoolean4;
        RecommendL2CategoryFragment localRecommendL2CategoryFragment = null;
        if ((this.ab instanceof RecommendL2CategoryFragment))
            localRecommendL2CategoryFragment = (RecommendL2CategoryFragment)this.ab;
        if (localRecommendL2CategoryFragment == null)
        {
            localRecommendL2CategoryFragment = (RecommendL2CategoryFragment)RecommendL2CategoryFragment.a(this.p, this.q);
            localRecommendL2CategoryFragment.a(this.L);
            localRecommendL2CategoryFragment.a(this.I, this.K);
            localRecommendL2CategoryFragment.thisActivity = this.P;
            localRecommendL2CategoryFragment.a(new m(this));
        }
        while (true)
        {
            localRecommendL2CategoryFragment.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
            a(localRecommendL2CategoryFragment);
            return;
            localRecommendL2CategoryFragment.b(this.p, this.q);
        }
    }

    private boolean a(boolean paramBoolean, View paramView)
    {
        if (paramBoolean)
        {
            paramView.setVisibility(View.VISIBLE);//0
            paramView.setOnClickListener(this.z);
        }
        while (true)
        {
            return true;
            paramView.setVisibility(View.GONE);//8;//8
        }
    }

    @Override
    public final void a(int paramInt1, int paramInt2)
    {
        if (Log.D)
            Log.d("navigation-click", n + "   old-->" + paramInt1 + " now-->" + paramInt2);
    }

    @SuppressLint({"InflateParams"})
    public final void b()
    {
        if ((!this.r1) && (isAdded()))
        {
            d locald = new d();
            View localView = LayoutInflater.from(this.P).inflate(R.layout.category_new_text_item, null);//2130903256
            locald.a = ((TextView)localView.findViewById(R.id.text));//2131166233
            locald.a.setText("推荐分类");
            locald.a.setTextColor(getFragmentTextColor(R.color.category_new_red_font));//2131099877
            localView.setTag(locald);
            localView.setBackgroundResource(R.drawable.category_new_left_facous);//2130838453
            this.s.setAdapter(null);
            this.s.addHeaderView(localView);
            this.s.setAdapter(this.t);
            this.u = localView;
            this.r1 = true;
        }
        this.w = -1;
        if (this.t != null)
            this.t.a(-1);
        this.T.clear();
        this.T = a(this.B);
    }

    public String getPageParam()
    {
        int i3 = 0;
        String str;
        int i1;
        if (TextUtils.isEmpty(this.E))
        {
            str = "0";
            if (this.A != null)
                break label67;
            i1 = i3;
            if (i1 == 0)
                break label128;
        }
        label128: for (Object localObject = "1"; ; localObject = "0")
        {
            return str + "_" + (String)localObject;
            str = "1";
            break;
            label67: int i2 = 0;
            while (true)
            {
                i1 = i3;
                if (i2 >= this.A.size())
                    break;
                localObject = ((Catelogy)this.A.get(i2)).getMergeCatalogs();
                if ((localObject != null) && (((List)localObject).size() > 0))
                {
                    i1 = 1;
                    break;
                }
                i2 += 1;
            }
        }
    }

    public void onAttach(Activity paramActivity)
    {
        this.P = ((BaseActivity)paramActivity);
        super.onAttach(paramActivity);
    }

    @Override
    public View onCreateViews(LayoutInflater paramLayoutInflater, Bundle paramBundle)
    {
        this.Q = paramLayoutInflater.inflate(R.layout.category_new_activity, null);//2130903255
        //paramLayoutInflater = this.Q;
        this.s = ((ListView)this.Q.findViewById(R.id.left_list));//2131166227
        this.I = this.Q.findViewById(R.id.sublist_loading_error_tips);//2131166230
        this.J = ((Button)this.I.findViewById(R.id.jd_tip_button));//2131165236
        this.J.setText(R.string.loading_error_again);//2131232396
        this.K = ((ImageView)this.I.findViewById(R.id.jd_tip_image));//2131165239
        this.K.setBackgroundResource(R.drawable.y_03);//2130837707
        ((TextView)this.I.findViewById(R.id.jd_tip_tv1)).setText(R.string.cart_error_fail);//2131165240//2131231071
        ((TextView)this.I.findViewById(R.id.jd_tip_tv2)).setText(R.string.cart_error_fail_check);//2131165241//2131231073
        this.c = ((RelativeLayout)this.Q.findViewById(R.id.category_message));//2131165804
        this.d = ((TextView)this.Q.findViewById(R.id.home_message_number));//2131165807
        this.e = ((SimpleDraweeView)this.Q.findViewById(R.id.home_message_red_dot));//2131165806
        this.r = this.Q.findViewById(R.id.mainlayout);//2131165737
        this.L = this.Q.findViewById(R.id.progress_bar);//2131166231
        this.M = this.Q.findViewById(R.id.main_loading_error_tips);//2131166232
        this.N = ((Button)this.M.findViewById(R.id.jd_tip_button));//2131165236
        this.N.setText(R.string.loading_error_again);//2131232396
        this.O = ((ImageView)this.M.findViewById(R.id.jd_tip_image));//2131165239
        this.O.setBackgroundResource(R.drawable.y_03);//2130837707
        this.f = ((ImageView)this.Q.findViewById(R.id.catagory_list_to_top));//2131166229
        ((TextView)this.M.findViewById(R.id.jd_tip_tv1)).setText(R.string.cart_error_fail);//2131165240//2131231071
        ((TextView)this.M.findViewById(R.id.jd_tip_tv2)).setText(R.string.cart_error_fail_check);//2131165241//2131231073
        this.g = new HashMap();
        this.p = UserInfoModel.getEncryptLoginUserName(LoginUserBase.getLoginUserName());
        if (this.p == null)
            this.p = "";
        this.q = StatisticsReportUtil.genarateDeviceUUID(this.P);
        //paramLayoutInflater = this.Q;
        this.a = this.Q.findViewById(R.id.common_title_2);//2131166226
        this.a.setVisibility(View.VISIBLE);//0
        this.b = ((AutoCompleteTextView)this.Q.findViewById(R.id.search_text));//2131166399
        this.b.setFocusable(false);
        this.b.setOnTouchListener(this.l);
        this.Q.findViewById(R.id.search_box_layout).setOnTouchListener(this.l);//2131166397
        this.Q.findViewById(R.id.category_saoasao_button).setOnClickListener(new o(this));//2131165803
        this.c.setOnClickListener(new b(this));
        if (this.y == null)
        {
            Context context = this.P.getBaseContext();
            int i1 = DPIUtil.getHeight() * 140 / 1280;
            PopupWindow popupWindow = new PopupWindow(context);
            popupWindow.setWidth(-1);
            popupWindow.setHeight(i1);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0xCC3E3F4C));//-868335796
            popupWindow.setFocusable(true);
            popupWindow.setAnimationStyle(2131296588);//2131296588
            popupWindow.update();
            this.y = popupWindow;
        }
        View view = ImageUtil.inflate(R.layout.app_search_toolbar_button, null);//2130903176
        if (view != null)
        {
            a(com.jingdong.common.e.a.a(14, false), view.findViewById(R.id.search_camera_btn));//2131165521
            view.findViewById(R.id.search_barcode_btn).setOnClickListener(this.z);//2131165520
            view.findViewById(R.id.color_shopping_btn).setOnClickListener(this.z);//2131165523
            this.Q.findViewById(R.id.search_voice).setOnClickListener(this.z);//2131168592
            this.y.setContentView(view);
        }
        IntentFilter intentFilter = new IntentFilter("refresh_recommedData");
        this.h = new p(this, 0);
        getActivity().getApplicationContext().registerReceiver(this.h, intentFilter);
        a(false, true, true, false);
        this.s.setDivider(null);
        this.t = new com.jingdong.app.mall.category.adapter.c(this.A, this.P);
        this.t.a(new f(this));
        this.s.setAdapter(this.t);
        this.s.setOnItemClickListener(new g(this));
        this.J.setOnClickListener(new j(this));
        this.N.setOnClickListener(new k(this));
        this.f.setOnClickListener(new l(this));
        return this.Q;
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
        com.jingdong.app.mall.personel.a.a.b.a(LoginUserBase.getLoginUserName());
        com.jingdong.app.mall.personel.a.a.b.b(this);
    }

    @Override
    public void onPersonalMessageReceived(Map<String, com.jingdong.app.mall.personel.a.a.a> paramMap)
    {
        post(new a(this, paramMap));
    }

    public void onResume()
    {
        super.onResume();
        com.jingdong.app.mall.personel.a.a.b.a(LoginUserBase.getLoginUserName());
        com.jingdong.app.mall.personel.a.a.b.a(this);
        if (LoginUser.hasLogin())
        {
            com.jingdong.app.mall.personel.a.a.b.a(LoginUserBase.getLoginUserName());
            com.jingdong.app.mall.personel.a.a.b.a(this.P.getHttpGroupWithNPSGroup());
        }
        if ((this.b == null) || (!isAdded()));
        do
        {
            return;
            if (!LoginUserBase.hasLogin())
            {
                this.e.setVisibility(View.GONE);//8;//8
                this.d.setVisibility(View.GONE);//8;//8
            }
            this.b.setHint(2131231773);
            this.V = CommonUtil.getJdSharedPreferences().getString("hintKeyWord", "");
            if (!TextUtils.isEmpty(this.V))
                this.b.setHint(this.V);
            com.jingdong.app.mall.navigationbar.j.a();
            com.jingdong.app.mall.navigationbar.j.c(1);
            if ((!this.v) || (this.r1) || (this.s.getHeaderViewsCount() != 0))
                continue;
            b();
        }
        while (!this.W);
        a(this.ab);
        this.W = false;
    }

    protected void setPageId(String paramString)
    {
        this.i = paramString;
    }

    protected void setShopId(String paramString)
    {
        this.j = paramString;
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
