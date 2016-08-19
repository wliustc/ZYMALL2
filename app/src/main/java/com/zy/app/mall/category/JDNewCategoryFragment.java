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
import com.jingdong.common.login.LoginUserBase;
import com.jingdong.lib.zxing.client.android.CaptureActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.category.adapter.ILeftAdapterListener;
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
import com.zy.common.utils.FileUtils;
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
        if (FileUtils.b("/sdcard/jd_test_merged_category"))
        {
            if (this.w == 0)
            {
                ArrayList localObject1 = new ArrayList();
                for (int i1 = 0; i1 < 5; i1++)
                {
                    localObject2 = new Catelogy.MergedCatelogy();
                    Catelogy localCatelogy = (Catelogy)this.A.get(i1);
                    ((Catelogy.MergedCatelogy)localObject2).setId(localCatelogy.getcId());
                    ((Catelogy.MergedCatelogy)localObject2).setName(localCatelogy.getName());
                    ((Catelogy.MergedCatelogy)localObject2).setOrder(i1);
                    ((List)localObject1).add(localObject2);

                }
            }
        }
        if (localObject2 != null)
        {
            ConjoinedCategoryFragment conjoinedCategoryFragment = new ConjoinedCategoryFragment();
            conjoinedCategoryFragment.a(this.L);
            conjoinedCategoryFragment.a(this.I, this.K);
            conjoinedCategoryFragment.a(this.H, this.D, this.w);
            conjoinedCategoryFragment.a(this.P);
            conjoinedCategoryFragment.a((List)localObject2);
            a(conjoinedCategoryFragment);
            return;
        }else {
            OrdinaryL2CategoryFragment ordinaryL2CategoryFragment = OrdinaryL2CategoryFragment.b(paramString, this.D, this.w);
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).a(this.L);
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).a(this.I, this.K);
            ((L2CategoryFragment) ordinaryL2CategoryFragment).thisActivity = this.P;
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).a(new e(this));
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).d(paramString);
            a(ordinaryL2CategoryFragment);
        }
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
        else
        {
            localRecommendL2CategoryFragment.b(this.p, this.q);
        }
        localRecommendL2CategoryFragment.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        a(localRecommendL2CategoryFragment);
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
            Log.d("navigation-click", n + "   old-->" + paramInt1 + " now-->" + paramInt2);
    }

    @SuppressLint({"InflateParams"})
    public final void b()
    {
        if ((!this.r1) && (isAdded()))
        {
            LeftListAdapter.LeftListViewHolder locald = new LeftListAdapter.LeftListViewHolder();
            View localView = LayoutInflater.from(this.P).inflate(R.layout.category_new_text_item, null);//2130903256
            locald.mText = ((TextView)localView.findViewById(R.id.text));//2131166233
            locald.mText.setText("推荐分类");
            locald.mText.setTextColor(getFragmentTextColor(R.color.category_new_red_font));//2131099877
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

    public String getPageParam() {
        int i3 = 0;
        String str;

        if (TextUtils.isEmpty(this.E))
            str = "0";
        else
            str = "1";
        if (this.A != null) {//if-nez v0, :cond_2
            //v2
            //:goto_3
            for (int i2 = 0; i2 < this.A.size(); i2++) {
                List<Catelogy.MergedCatelogy> localObject = this.A.get(i2).getMergeCatalogs();
                if ((localObject != null) && (((List) localObject).size() > 0)) {
                    i3 = 1;
                    break;
                }
            }
        }

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
        this.Q.findViewById(R.id.category_saoasao_button).setOnClickListener(new View.OnClickListener(){//o(this)
            @Override
            public void onClick(View view) {
                if (CatelogyUtil.a(JDNewCategoryFragment.b(this.a)))
                    this.a.startActivity(new Intent(JDNewCategoryFragment.b(this.a), CaptureActivity.class));
                JDMtaUtils.sendCommonData(JDNewCategoryFragment.b(this.a), "Search_Scan", "", "", this.a, "", JDNewCategoryFragment.b(this.a).getClass(), "");

            }
        });//2131165803
        this.c.setOnClickListener(new View.OnClickListener(){//b(this)
            @Override
            public void onClick(View view) {
                if (JDNewCategoryFragment.q(this.a))
                    return;
                JDMtaUtils.sendCommonData(JDNewCategoryFragment.b(this.a), "Classification_MyMessage", "", "", this.a, "", "", "");
                this.a.e.setVisibility(8);
                this.a.d.setVisibility(8);
                com.jingdong.app.mall.personel.a.a.b.a(LoginUserBase.getLoginUserName());
                com.jingdong.app.mall.personel.a.a.b.a("message", System.currentTimeMillis(), JDNewCategoryFragment.b(this.a).getHttpGroupWithNPSGroup());
                //paramView = new c(this);
                LoginUser.getInstance().executeLoginRunnable(JDNewCategoryFragment.b(this.a), new Runnable(){
                    @Override
                    public void run() {
                        Intent localIntent = new Intent(JDNewCategoryFragment.b(this.a.a), MyMessageBox.class);
                        localIntent.putExtra("title", this.a.a.getFragmentString(2131231239));
                        localIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
                        JDNewCategoryFragment.b(this.a.a).startActivity(localIntent);
                    }
                });
            }
        });
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
        this.h = new BroadcastReceiver(){//p(this, 0);
            @Override
            public void onReceive(Context context, Intent intent) {
                if ((intent != null) && ("refresh_recommedData".equals(intent.getAction())))
                {
                    JDNewCategoryFragment.a(this.a, UserInfoModel.getEncryptLoginUserName(LoginUserBase.getLoginUserName()));
                    if (JDNewCategoryFragment.a(this.a) == null)
                        JDNewCategoryFragment.a(this.a, "");
                    JDNewCategoryFragment.b(this.a, StatisticsReportUtil.genarateDeviceUUID(JDNewCategoryFragment.b(this.a)));
                    if ((JDNewCategoryFragment.c(this.a) == -1) && (this.a.getActivity() != null) && (!this.a.getActivity().isFinishing()))
                    {
                        if (Log.D)
                            Log.d(JDNewCategoryFragment.c(), "ActivityHasNotFinished");
                        JDNewCategoryFragment.a(this.a, false, false, true, false);
                    }
                }
            }
        };
        getActivity().getApplicationContext().registerReceiver(this.h, intentFilter);
        a(false, true, true, false);
        this.s.setDivider(null);
        this.t = new LeftListAdapter(this.A, this.P);
        this.t.a(new ILeftAdapterListener(){//f(this)
            @Override
            public void a(View paramView) {
                JDNewCategoryFragment.a(this.a, paramView);
            }
        });
        this.s.setAdapter(this.t);
        this.s.setOnItemClickListener(new AdapterView.OnItemClickListener(){//g(this)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (((JDNewCategoryFragment.d(this.a)) && (JDNewCategoryFragment.c(this.a) == paramInt - 1)) || ((!JDNewCategoryFragment.d(this.a)) && (JDNewCategoryFragment.c(this.a) == paramInt)))
                    return;
                cb.a(JDNewCategoryFragment.e(this.a));
                if (JDNewCategoryFragment.f(this.a))
                {
                    JDNewCategoryFragment.a(this.a, JDNewCategoryFragment.g(this.a).getChildAt(0));
                    JDNewCategoryFragment.a(this.a, false);
                }
                if ((JDNewCategoryFragment.h(this.a) != null) && (this.a.isAdded()))
                {
                    JDNewCategoryFragment.h(this.a).setBackgroundResource(2130838454);
                    ((d)JDNewCategoryFragment.h(this.a).getTag()).a.setTextColor(this.a.getFragmentTextColor(2131099873));
                }
                if (this.a.isAdded())
                {
                    paramView.setBackgroundResource(2130838453);
                    ((d)paramView.getTag()).a.setTextColor(this.a.getFragmentTextColor(2131099877));
                }
                if ((JDNewCategoryFragment.d(this.a)) && (paramInt != 0))
                {
                    paramAdapterView = (Catelogy)JDNewCategoryFragment.i(this.a).get(paramInt - 1);
                    JDNewCategoryFragment.a(this.a, paramInt - 1);
                    JDNewCategoryFragment.c(this.a, paramAdapterView.getcId());
                    JDNewCategoryFragment.d(this.a, JDNewCategoryFragment.j(this.a));
                    JDNewCategoryFragment.e(this.a, JDNewCategoryFragment.j(this.a));
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.b(this.a), "Classification_BCategory", JDNewCategoryFragment.j(this.a) + "_" + JDNewCategoryFragment.k(this.a) + "_" + paramInt, "", this.a, "", JDNewCategoryFragment.b(this.a).getClass(), "");
                }
                if ((JDNewCategoryFragment.d(this.a)) && (paramInt == 0))
                {
                    this.a.post(new h(this));
                    JDNewCategoryFragment.a(this.a, false, false, true, false);
                    JDNewCategoryFragment.a(this.a, -1);
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.b(this.a), "Classification_CateCustomize", "", "", this.a, "", JDNewCategoryFragment.b(this.a).getClass(), "");
                    JDNewCategoryFragment.e(this.a).clear();
                    JDNewCategoryFragment.a(this.a, JDNewCategoryFragment.b(this.a, JDNewCategoryFragment.n(this.a)));
                }
                if (!JDNewCategoryFragment.d(this.a))
                {
                    paramAdapterView = (Catelogy)JDNewCategoryFragment.i(this.a).get(paramInt);
                    JDNewCategoryFragment.a(this.a, paramInt);
                    JDNewCategoryFragment.c(this.a, paramAdapterView.getcId());
                    JDNewCategoryFragment.d(this.a, JDNewCategoryFragment.j(this.a));
                    JDNewCategoryFragment.e(this.a, JDNewCategoryFragment.j(this.a));
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.b(this.a), "Classification_BCategory", JDNewCategoryFragment.j(this.a) + "_" + JDNewCategoryFragment.k(this.a) + "_" + (paramInt + 1), "", this.a, "", JDNewCategoryFragment.b(this.a).getClass(), "");
                }
                if (JDNewCategoryFragment.o(this.a) != null)
                    JDNewCategoryFragment.o(this.a).a(JDNewCategoryFragment.c(this.a));
                this.a.post(new i(this, paramView));
                JDNewCategoryFragment.a(this.a, paramView);
            }
        });
        this.J.setOnClickListener(new View.OnClickListener(){//j(this)
            @Override
            public void onClick(View view) {
                JDNewCategoryFragment.this.a(JDNewCategoryFragment.this.o);
            }
        });
        this.N.setOnClickListener(new View.OnClickListener(){//k(this)
            @Override
            public void onClick(View view) {
                JDNewCategoryFragment.this.U = true;
                JDNewCategoryFragment.this.a(false, true, true, false);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener(){//l(this)
            @Override
            public void onClick(View view) {

            }
        });
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
        if ((this.b != null) && (!isAdded())){
            if (!LoginUserBase.hasLogin())
            {
                this.e.setVisibility(View.GONE);//8;//8
                this.d.setVisibility(View.GONE);//8;//8
            }
            this.b.setHint(R.string.homeActivity_autoComplete);//2131231773
            this.V = CommonUtil.getJdSharedPreferences().getString("hintKeyWord", "");
            if (!TextUtils.isEmpty(this.V))
                this.b.setHint(this.V);
            NavigationOptHelper.getInstance();
            NavigationOptHelper.c(1);
            if ((this.v) && (!this.r1) && (this.s.getHeaderViewsCount() == 0))
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
