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
import com.jingdong.common.config.Configuration;
import com.jingdong.common.login.LoginUserBase;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.JDFrescoUtils;
import com.jingdong.jdma.model.UserInfoModel;
import com.jingdong.lib.zxing.client.android.CaptureActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.category.adapter.ILeftAdapterListener;
import com.zy.app.mall.category.adapter.LeftListAdapter;
import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.b.RightListColumn;
import com.zy.app.mall.category.c.CatelogyUtil;
import com.zy.app.mall.category.fragment.ConjoinedCategoryFragment;
import com.zy.app.mall.category.fragment.L2CategoryFragment;
import com.zy.app.mall.category.fragment.OrdinaryL2CategoryFragment;
import com.zy.app.mall.category.fragment.RecommendL2CategoryFragment;
import com.zy.app.mall.navigationbar.TabFragment;
import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;
import com.zy.app.mall.searchRefactor.view.Activity.SearchActivity;
import com.zy.common.BaseActivity;
import com.zy.common.e.ConfigUtil;
import com.zy.common.entity.Catelogy;
import com.zy.common.entity.SourceEntity;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.FileUtils;
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
public class JDNewCategoryFragment extends TabFragment implements PersonalMessageObserver {

    private static JDNewCategoryFragment instance;
    private static final String TAG = JDNewCategoryFragment.class.getSimpleName();
    private ArrayList<Catelogy> mLeftCatelogList = new ArrayList();//
    private List<RightColumnBase> B = new ArrayList();
    private JSONArrayProxy catelogyList = null;    //C
    private String catalogSortEventId = null;    //D
    private String StrcatalogTopNum = null;    //E
    private int catalogTopNum;  //F
    private String G = null;
    private String H;
    private View sublist_loading_error_tips; //I
    private Button jd_tip_button;   //J
    private ImageView jd_tip_image;    //K
    private View mProgressBar; //L
    private View mMainLoadingErrorTips; //M
    private Button mJdTipButton;   //N
    private ImageView mJdTipImage;    //O
    private BaseActivity mBaseActivity; //P
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
    View mCommonTitle2;//a
    private boolean aa;
    private Fragment fragment = null;
    private String ac = null;
    AutoCompleteTextView search_text; //b
    RelativeLayout mCategoryMessage;   //c
    TextView mHomeMessageNumber; //d
    SimpleDraweeView mHomeMessageRedDot; //e
    ImageView mCatagoryListToTop;    //f
    HashMap<String, ArrayList<RightColumnBase>> g;
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
    private String mCurrentCatelogyCId = "-1";  //o
    private String p;
    private String mDeviceUUID;   //q
    private View mMainlayout;//r
    private ListView mLeftCatelogyListView;
    private LeftListAdapter mLeftListAdapter;//t
    private View u;
    private boolean v = false;
    private int mCurrentCatelogyIndex = 0;//w
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
                    context = JDNewCategoryFragment.this.mBaseActivity.getBaseContext();
                    if (CatelogyUtil.a(context))
                        context.startActivity(new Intent(context, CaptureActivity.class));
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Scan_Scan", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.mBaseActivity.getClass(), "");
                    return;
                case R.id.search_camera_btn:    //2131165521    7F070151    sswitch_2
                    //JDNewCategoryFragment.r(this.a);
                    if(JDNewCategoryFragment.this.y != null && JDNewCategoryFragment.this.y.isShowing())
                        JDNewCategoryFragment.this.y.dismiss();
                    context = JDNewCategoryFragment.this.mBaseActivity.getBaseContext();
                    if (CatelogyUtil.a(context))
                        context.startActivity(new Intent(context, CameraPurchaseActivity.class));
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Scan_PhotoBuy", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.mBaseActivity.getClass(), "");
                    return;
                case R.id.color_shopping_btn:    //2131165523   7F070153    sswitch_3
                    //JDNewCategoryFragment.r(this.a);
                    if(JDNewCategoryFragment.this.y != null && JDNewCategoryFragment.this.y.isShowing())
                        JDNewCategoryFragment.this.y.dismiss();
                    context = JDNewCategoryFragment.this.mBaseActivity.getBaseContext();
                    if (CatelogyUtil.a(context))
                    {
                        Intent localIntent = new Intent(context, CameraActivity.class);
                        localIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
                        context.startActivity(localIntent);
                    }
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Scan_ColorBuy", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.mBaseActivity.getClass(), "");
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

    //private void a(Fragment paramFragment)
    private void replaceFragment(Fragment fragment)
    {
        if ((fragment != null) && (isAdded()))
        {
            FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
            if (localFragmentTransaction != null)
            {
                localFragmentTransaction.replace(R.id.id_content, fragment);//2131166228
                localFragmentTransaction.commitAllowingStateLoss();
                this.fragment = fragment;
            }
        }
    }

    private void a(String paramString)
    {
        if (this.mCurrentCatelogyIndex < 0)
        {
            Log.e(TAG, "Current Item is -1!!!");
            return;
        }
        this.ac = paramString;
        List mergeCatalogsList = ((Catelogy)this.mLeftCatelogList.get(this.mCurrentCatelogyIndex)).getMergeCatalogs();
        if (FileUtils.b("/sdcard/jd_test_merged_category")){//exists
            if (this.mCurrentCatelogyIndex == 0)
            {
                ArrayList localObject1 = new ArrayList();
                for (int i1 = 0; i1 < 5; i1++)
                {
                    Catelogy.MergedCatelogy mergedCatelogy = new Catelogy.MergedCatelogy();
                    Catelogy localCatelogy = (Catelogy)this.mLeftCatelogList.get(i1);
                    ((Catelogy.MergedCatelogy)mergedCatelogy).setId(localCatelogy.getcId());
                    ((Catelogy.MergedCatelogy)mergedCatelogy).setName(localCatelogy.getName());
                    ((Catelogy.MergedCatelogy)mergedCatelogy).setOrder(i1);
                    ((List)localObject1).add(mergedCatelogy);

                }
            }
        }
        if (mergeCatalogsList != null) {
            //连体分类
            ConjoinedCategoryFragment conjoinedCategoryFragment = new ConjoinedCategoryFragment();
            conjoinedCategoryFragment.a(this.mProgressBar);
            conjoinedCategoryFragment.a(this.sublist_loading_error_tips, this.jd_tip_image);
            conjoinedCategoryFragment.a(this.H, this.catalogSortEventId, this.mCurrentCatelogyIndex);
            conjoinedCategoryFragment.a(this.mBaseActivity);
            conjoinedCategoryFragment.a((List)mergeCatalogsList);
            replaceFragment(conjoinedCategoryFragment);
            return;
        }else {
            //普通二级分类
            OrdinaryL2CategoryFragment ordinaryL2CategoryFragment = (OrdinaryL2CategoryFragment) OrdinaryL2CategoryFragment.b(paramString, this.catalogSortEventId, this.mCurrentCatelogyIndex);
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).a(this.mProgressBar);
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).a(this.sublist_loading_error_tips, this.jd_tip_image);
            ((L2CategoryFragment) ordinaryL2CategoryFragment).thisActivity = this.mBaseActivity;
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).a(new OrdinaryL2CategoryFragment._U(){//e(this)
                @Override
                public void a(List<String> paramList) {
                    JDNewCategoryFragment.this.T.clear();
                    JDNewCategoryFragment.this.T = paramList;
                }
            });
            ((OrdinaryL2CategoryFragment) ordinaryL2CategoryFragment).d(paramString);
            replaceFragment(ordinaryL2CategoryFragment);
        }
    }

    private void a(String paramString1, String paramString2)
    {
        try
        {
            if ((VoiceSearchLayout.isUseJdCustomerVoiceService()) && ("type".equals(paramString1)) && ("voice".equals(paramString2)))
            {
                Context context = this.mBaseActivity.getBaseContext();
                Intent intent = new Intent(context, VoiceSearchActivity.class);
                intent.putExtra("isFromHome", true);
                intent.putExtra("source", new SourceEntity("Classification_VSearch", ""));
                intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);//268435456
                context.startActivity(intent);
                JDMtaUtils.sendCommonData(this.mBaseActivity.getBaseContext(), "Classification_VSearch", "", "onClick", this, JDNewCategoryFragment.class.getSimpleName(), VoiceSearchActivity.class, "");
                return;
            }else {
                Context localContext = this.mBaseActivity.getBaseContext();
                Intent localIntent = new Intent(localContext, SearchActivity.class);
                if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
                    localIntent.putExtra(paramString1, paramString2);
                localIntent.putExtra("isFromHome", true);
                localIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);//65536
                localIntent.putExtra("isNoAnimation", true);
                localIntent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);//268435456
                localContext.startActivity(localIntent);
                JDMtaUtils.sendCommonData(this.mBaseActivity, "Search_Search", "", "", this, "", SearchActivity.class, "");
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
        RecommendL2CategoryFragment recommendL2CategoryFragment = null;
        if ((this.fragment instanceof RecommendL2CategoryFragment))
            recommendL2CategoryFragment = (RecommendL2CategoryFragment)this.fragment;
        if (recommendL2CategoryFragment == null)
        {
            recommendL2CategoryFragment = (RecommendL2CategoryFragment)RecommendL2CategoryFragment.a(this.p, this.mDeviceUUID);
            recommendL2CategoryFragment.a(this.mProgressBar);
            recommendL2CategoryFragment.a(this.sublist_loading_error_tips, this.jd_tip_image);
            recommendL2CategoryFragment.thisActivity = this.mBaseActivity;
            recommendL2CategoryFragment.a(new RecommendL2CategoryFragment._AF(){//m(this)
                @Override
                public void a(boolean paramBoolean1, boolean paramBoolean2, List<String> paramList, boolean paramBoolean3) {
                    JDNewCategoryFragment.this.v = paramBoolean2;
                    JDNewCategoryFragment.this.k = paramBoolean3;
                    if ((paramBoolean1) || (!paramBoolean3))
                        JDNewCategoryFragment.this.entranceCatalog(paramBoolean3, false);
                    JDNewCategoryFragment.this.T.clear();
                    JDNewCategoryFragment.this.T = paramList;
                }
            });
        }
        else
        {
            recommendL2CategoryFragment.b(this.p, this.mDeviceUUID);
        }
        recommendL2CategoryFragment.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        replaceFragment(recommendL2CategoryFragment);
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
        if ((!this.r1) && (isAdded()))
        {
            LeftListAdapter.LeftListViewHolder locald = new LeftListAdapter.LeftListViewHolder();
            View localView = LayoutInflater.from(this.mBaseActivity).inflate(R.layout.category_new_text_item, null);//2130903256
            locald.mText = ((TextView)localView.findViewById(R.id.text));//2131166233
            locald.mText.setText("推荐分类");
            locald.mText.setTextColor(getFragmentTextColor(R.color.category_new_red_font));//2131099877
            localView.setTag(locald);
            localView.setBackgroundResource(R.drawable.category_new_left_facous);//2130838453
            this.mLeftCatelogyListView.setAdapter(null);
            this.mLeftCatelogyListView.addHeaderView(localView);
            this.mLeftCatelogyListView.setAdapter(this.mLeftListAdapter);
            this.u = localView;
            this.r1 = true;
        }
        this.mCurrentCatelogyIndex = -1;
        if (this.mLeftListAdapter != null)
            this.mLeftListAdapter.setCurrentIndex(-1);
        this.T.clear();
        this.T = a(this.B);
    }

    public String getPageParam() {
        int i3 = 0;
        String str;

        if (TextUtils.isEmpty(this.StrcatalogTopNum))
            str = "0";
        else
            str = "1";
        if (this.mLeftCatelogList != null) {//if-nez v0, :cond_2
            //v2
            //:goto_3
            for (int i2 = 0; i2 < this.mLeftCatelogList.size(); i2++) {
                List<Catelogy.MergedCatelogy> localObject = this.mLeftCatelogList.get(i2).getMergeCatalogs();
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
        this.mBaseActivity = ((BaseActivity)paramActivity);
        super.onAttach(paramActivity);
    }

    @Override
    public View onCreateViews(LayoutInflater paramLayoutInflater, Bundle paramBundle)
    {
        this.mCategoryFragmentLayout = paramLayoutInflater.inflate(R.layout.category_new_activity, null);//2130903255
        //paramLayoutInflater = this.Q;
        this.mLeftCatelogyListView = ((ListView)this.mCategoryFragmentLayout.findViewById(R.id.left_list));//2131166227
        this.sublist_loading_error_tips = this.mCategoryFragmentLayout.findViewById(R.id.sublist_loading_error_tips);//2131166230
        this.jd_tip_button = ((Button)this.sublist_loading_error_tips.findViewById(R.id.jd_tip_button));//2131165236
        this.jd_tip_button.setText(R.string.loading_error_again);//2131232396
        this.jd_tip_image = ((ImageView)this.sublist_loading_error_tips.findViewById(R.id.jd_tip_image));//2131165239
        this.jd_tip_image.setBackgroundResource(R.drawable.y_03);//2130837707
        ((TextView)this.sublist_loading_error_tips.findViewById(R.id.jd_tip_tv1)).setText(R.string.cart_error_fail);//2131165240//2131231071
        ((TextView)this.sublist_loading_error_tips.findViewById(R.id.jd_tip_tv2)).setText(R.string.cart_error_fail_check);//2131165241//2131231073
        this.mCategoryMessage = ((RelativeLayout)this.mCategoryFragmentLayout.findViewById(R.id.category_message));//2131165804
        this.mHomeMessageNumber = ((TextView)this.mCategoryFragmentLayout.findViewById(R.id.home_message_number));//2131165807
        this.mHomeMessageRedDot = ((SimpleDraweeView)this.mCategoryFragmentLayout.findViewById(R.id.home_message_red_dot));//2131165806
        this.mMainlayout = this.mCategoryFragmentLayout.findViewById(R.id.mainlayout);//2131165737
        this.mProgressBar = this.mCategoryFragmentLayout.findViewById(R.id.progress_bar);//2131166231
        this.mMainLoadingErrorTips = this.mCategoryFragmentLayout.findViewById(R.id.main_loading_error_tips);//2131166232
        this.mJdTipButton = ((Button)this.mMainLoadingErrorTips.findViewById(R.id.jd_tip_button));//2131165236
        this.mJdTipButton.setText(R.string.loading_error_again);//2131232396
        this.mJdTipImage = ((ImageView)this.mMainLoadingErrorTips.findViewById(R.id.jd_tip_image));//2131165239
        this.mJdTipImage.setBackgroundResource(R.drawable.y_03);//2130837707
        this.mCatagoryListToTop = ((ImageView)this.mCategoryFragmentLayout.findViewById(R.id.catagory_list_to_top));//2131166229
        ((TextView)this.mMainLoadingErrorTips.findViewById(R.id.jd_tip_tv1)).setText(R.string.cart_error_fail);//2131165240//2131231071
        ((TextView)this.mMainLoadingErrorTips.findViewById(R.id.jd_tip_tv2)).setText(R.string.cart_error_fail_check);//2131165241//2131231073
        this.g = new HashMap();
        this.p = UserInfoModel.getEncryptLoginUserName(LoginUserBase.getLoginUserName());
        if (this.p == null)
            this.p = "";
        this.mDeviceUUID = StatisticsReportUtil.genarateDeviceUUID(this.mBaseActivity);
        //paramLayoutInflater = this.Q;
        this.mCommonTitle2 = this.mCategoryFragmentLayout.findViewById(R.id.common_title_2);//2131166226
        this.mCommonTitle2.setVisibility(View.VISIBLE);//0
        this.search_text = ((AutoCompleteTextView)this.mCategoryFragmentLayout.findViewById(R.id.search_text));//2131166399
        this.search_text.setFocusable(false);
        this.search_text.setOnTouchListener(this.l);
        this.mCategoryFragmentLayout.findViewById(R.id.search_box_layout).setOnTouchListener(this.l);//2131166397
        this.mCategoryFragmentLayout.findViewById(R.id.category_saoasao_button).setOnClickListener(new View.OnClickListener(){//2131165803 //o(this)
            @Override
            public void onClick(View view) {
                if (CatelogyUtil.a(JDNewCategoryFragment.this.mBaseActivity))
                    JDNewCategoryFragment.this.startActivity(new Intent(JDNewCategoryFragment.this.mBaseActivity, CaptureActivity.class));
                JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Search_Scan", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.mBaseActivity.getClass(), "");

            }
        });
        this.mCategoryMessage.setOnClickListener(new View.OnClickListener(){//b(this)
            @Override
            public void onClick(View view) {
                if (JDNewCategoryFragment.synthetic_q(JDNewCategoryFragment.this))
                    return;
                JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Classification_MyMessage", "", "", JDNewCategoryFragment.this, "", "", "");
                JDNewCategoryFragment.this.mHomeMessageRedDot.setVisibility(View.GONE);
                JDNewCategoryFragment.this.mHomeMessageNumber.setVisibility(View.GONE);
                PersonalMessageManager.a(LoginUserBase.getLoginUserName());
                PersonalMessageManager.a("message", System.currentTimeMillis(), JDNewCategoryFragment.this.mBaseActivity.getHttpGroupWithNPSGroup());
                //paramView = new c(this);
                LoginUser.getInstance().executeLoginRunnable(JDNewCategoryFragment.this.mBaseActivity, new Runnable(){
                    @Override
                    public void run() {
                        Intent localIntent = new Intent(JDNewCategoryFragment.this.mBaseActivity, MyMessageBox.class);
                        localIntent.putExtra("title", JDNewCategoryFragment.this.getFragmentString(R.string.content_message_center));
                        localIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
                        JDNewCategoryFragment.this.mBaseActivity.startActivity(localIntent);
                    }
                });
            }
        });
        if (this.y == null)
        {
            Context context = this.mBaseActivity.getBaseContext();
            int i1 = DPIUtil.getHeight() * 140 / 1280;
            PopupWindow popupWindow = new PopupWindow(context);
            popupWindow.setWidth(-1);
            popupWindow.setHeight(i1);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0xCC3E3F4C));//-868335796
            popupWindow.setFocusable(true);
            popupWindow.setAnimationStyle(R.style.popup_anim_alpha_style);//2131296588
            popupWindow.update();
            this.y = popupWindow;
        }
        View view = ImageUtil.inflate(R.layout.app_search_toolbar_button, null);//2130903176
        if (view != null)
        {
            a(ConfigUtil.a(14, false), view.findViewById(R.id.search_camera_btn));//2131165521
            view.findViewById(R.id.search_barcode_btn).setOnClickListener(this.z);//2131165520
            view.findViewById(R.id.color_shopping_btn).setOnClickListener(this.z);//2131165523
            this.mCategoryFragmentLayout.findViewById(R.id.search_voice).setOnClickListener(this.z);//2131168592
            this.y.setContentView(view);
        }
        IntentFilter intentFilter = new IntentFilter("refresh_recommedData");
        this.h = new BroadcastReceiver(){//p(this, 0);
            @Override
            public void onReceive(Context context, Intent intent) {
                if ((intent != null) && ("refresh_recommedData".equals(intent.getAction())))
                {
                    JDNewCategoryFragment.this.p = UserInfoModel.getEncryptLoginUserName(LoginUserBase.getLoginUserName());
                    if (JDNewCategoryFragment.this.p == null)
                        JDNewCategoryFragment.this.p = "";
                    JDNewCategoryFragment.this.mDeviceUUID = StatisticsReportUtil.genarateDeviceUUID(JDNewCategoryFragment.this.mBaseActivity);
                    if ((JDNewCategoryFragment.this.mCurrentCatelogyIndex == -1) && (JDNewCategoryFragment.this.getActivity() != null) && (!JDNewCategoryFragment.this.getActivity().isFinishing()))
                    {
                        if (Log.D)
                            Log.d(JDNewCategoryFragment.TAG, "ActivityHasNotFinished");
                        JDNewCategoryFragment.this.a(false, false, true, false);
                    }
                }
            }
        };
        getActivity().getApplicationContext().registerReceiver(this.h, intentFilter);
        a(false, true, true, false);
        this.mLeftCatelogyListView.setDivider(null);
        this.mLeftListAdapter = new LeftListAdapter(this.mLeftCatelogList, this.mBaseActivity);
        this.mLeftListAdapter.setmLeftAdapterListener(new ILeftAdapterListener(){//f(this)
            @Override
            public void a(View paramView) {
                JDNewCategoryFragment.this.u = paramView;
            }
        });
        this.mLeftCatelogyListView.setAdapter(this.mLeftListAdapter);
        this.mLeftCatelogyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){//g(this)
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int paramInt, long l) {
                if (((JDNewCategoryFragment.this.v) && (JDNewCategoryFragment.this.mCurrentCatelogyIndex == paramInt - 1)) || ((!JDNewCategoryFragment.this.v) && (JDNewCategoryFragment.this.mCurrentCatelogyIndex == paramInt)))
                    return;
                JDFrescoUtils.a(JDNewCategoryFragment.this.T);
                if (JDNewCategoryFragment.this.S)
                {
                    JDNewCategoryFragment.this.u = JDNewCategoryFragment.this.mLeftCatelogyListView.getChildAt(0);
                    JDNewCategoryFragment.this.S = false;
                }
                if ((JDNewCategoryFragment.this.u != null) && (JDNewCategoryFragment.this.isAdded()))
                {
                    JDNewCategoryFragment.this.u.setBackgroundResource(R.drawable.category_new_left_normal);//2130838454
                    ((LeftListAdapter.LeftListViewHolder)JDNewCategoryFragment.this.u.getTag()).mText.setTextColor(JDNewCategoryFragment.this.getFragmentTextColor(R.color.category_new__dark_font));//2131099873
                }
                if (JDNewCategoryFragment.this.isAdded())
                {
                    view.setBackgroundResource(R.drawable.category_new_left_facous);//2130838453
                    ((LeftListAdapter.LeftListViewHolder)view.getTag()).mText.setTextColor(JDNewCategoryFragment.this.getFragmentTextColor(R.color.category_new_red_font));//2131099877
                }
                if ((JDNewCategoryFragment.this.v) && (paramInt != 0))
                {
                    Catelogy catelogy = (Catelogy)JDNewCategoryFragment.this.mLeftCatelogList.get(paramInt - 1);
                    JDNewCategoryFragment.this.mCurrentCatelogyIndex = paramInt - 1;
                    JDNewCategoryFragment.this.mCurrentCatelogyCId = catelogy.getcId();
                    JDNewCategoryFragment.this.a(JDNewCategoryFragment.this.mCurrentCatelogyCId);
                    JDNewCategoryFragment.this.H = JDNewCategoryFragment.this.mCurrentCatelogyCId;
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Classification_BCategory", JDNewCategoryFragment.this.mCurrentCatelogyCId + "_" + JDNewCategoryFragment.this.catalogSortEventId + "_" + paramInt, "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.mBaseActivity.getClass(), "");
                }
                if ((JDNewCategoryFragment.this.v) && (paramInt == 0))
                {
                    JDNewCategoryFragment.this.post(new Runnable(){//h(this)
                        @Override
                        public void run() {
                            JDNewCategoryFragment.this.sublist_loading_error_tips.setVisibility(View.GONE);
                            if (JDNewCategoryFragment.this.isAdded())
                                JDNewCategoryFragment.this.jd_tip_image.setBackgroundResource(R.drawable.category_kongbai);//2130838448
                        }
                    });
                    JDNewCategoryFragment.this.a(false, false, true, false);
                    JDNewCategoryFragment.this.mCurrentCatelogyIndex = -1;
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Classification_CateCustomize", "", "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.mBaseActivity.getClass(), "");
                    JDNewCategoryFragment.this.T.clear();
                    JDNewCategoryFragment.this.T = JDNewCategoryFragment.this.a(JDNewCategoryFragment.this.B);
                }
                if (!JDNewCategoryFragment.this.v)
                {
                    Catelogy catelogy = (Catelogy)JDNewCategoryFragment.this.mLeftCatelogList.get(paramInt);
                    JDNewCategoryFragment.this.mCurrentCatelogyIndex = paramInt;
                    JDNewCategoryFragment.this.mCurrentCatelogyCId = catelogy.getcId();
                    JDNewCategoryFragment.this.a(JDNewCategoryFragment.this.mCurrentCatelogyCId);
                    JDNewCategoryFragment.this.H = JDNewCategoryFragment.this.mCurrentCatelogyCId;
                    JDMtaUtils.sendCommonData(JDNewCategoryFragment.this.mBaseActivity, "Classification_BCategory", JDNewCategoryFragment.this.mCurrentCatelogyCId + "_" + JDNewCategoryFragment.this.catalogSortEventId + "_" + (paramInt + 1), "", JDNewCategoryFragment.this, "", JDNewCategoryFragment.this.mBaseActivity.getClass(), "");
                }
                if (JDNewCategoryFragment.this.mLeftListAdapter != null)
                    JDNewCategoryFragment.this.mLeftListAdapter.setCurrentIndex(JDNewCategoryFragment.this.mCurrentCatelogyIndex);
                JDNewCategoryFragment.this.post(new Runnable(){//i(this, view)
                    @Override
                    public void run() {
                        JDNewCategoryFragment.this.mLeftCatelogyListView.smoothScrollBy(view.getTop(), 700);
                    }
                });
                JDNewCategoryFragment.this.u = view;
            }
        });
        this.jd_tip_button.setOnClickListener(new View.OnClickListener(){//j(this)
            @Override
            public void onClick(View view) {
                JDNewCategoryFragment.this.a(JDNewCategoryFragment.this.mCurrentCatelogyCId);
            }
        });
        this.mJdTipButton.setOnClickListener(new View.OnClickListener(){//k(this)
            @Override
            public void onClick(View view) {
                JDNewCategoryFragment.this.U = true;
                JDNewCategoryFragment.this.a(false, true, true, false);
            }
        });
        this.mCatagoryListToTop.setOnClickListener(new View.OnClickListener(){//l(this)
            @Override
            public void onClick(View view) {

            }
        });
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
                                JDNewCategoryFragment.this.mHomeMessageRedDot.setVisibility(View.GONE);
                                JDNewCategoryFragment.this.mHomeMessageNumber.setVisibility(View.GONE);
                                return;
                            }else {
                                String str = "99+";
                                if (i <= 99)
                                    str = i + "";
                                JDNewCategoryFragment.this.mHomeMessageRedDot.setVisibility(View.GONE);
                                JDNewCategoryFragment.this.mHomeMessageNumber.setText((CharSequence) localObject);
                                JDNewCategoryFragment.this.mHomeMessageNumber.setVisibility(View.VISIBLE);
                                return;
                            }
                        }else if (((PersonalMessageChannel)localObject).b()){
                            JDNewCategoryFragment.this.mHomeMessageRedDot.setVisibility(View.VISIBLE);
                            JDNewCategoryFragment.this.mHomeMessageNumber.setVisibility(View.GONE);
                            return;
                        }else {
                            JDNewCategoryFragment.this.mHomeMessageNumber.setVisibility(View.GONE);
                            JDNewCategoryFragment.this.mHomeMessageRedDot.setVisibility(View.GONE);
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
            PersonalMessageManager.a(this.mBaseActivity.getHttpGroupWithNPSGroup());
        }
        if ((this.search_text != null) && (!isAdded())){
            if (!LoginUserBase.hasLogin())
            {
                this.mHomeMessageRedDot.setVisibility(View.GONE);//8;//8
                this.mHomeMessageNumber.setVisibility(View.GONE);//8;//8
            }
            this.search_text.setHint(R.string.homeActivity_autoComplete);//2131231773
            this.V = CommonUtil.getJdSharedPreferences().getString("hintKeyWord", "");
            if (!TextUtils.isEmpty(this.V))
                this.search_text.setHint(this.V);
            NavigationOptHelper.getInstance();
            NavigationOptHelper.c(1);
            if ((this.v) && (!this.r1) && (this.mLeftCatelogyListView.getHeaderViewsCount() == 0))
                b();
            if (this.W) {
                replaceFragment(this.fragment);
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

    //static void synthetic_a(final JDNewCategoryFragment paramJDNewCategoryFragment, final boolean paramBoolean1, final boolean paramBoolean2)
    void entranceCatalog(final boolean paramBoolean1, final boolean paramBoolean2)
    {
        this.post(new Runnable(){//d(paramJDNewCategoryFragment)
            @Override
            public void run() {
                JDNewCategoryFragment.this.mProgressBar.setVisibility(View.GONE);
                JDNewCategoryFragment.this.mMainlayout.setVisibility(View.VISIBLE);
                JDNewCategoryFragment.this.mMainLoadingErrorTips.setVisibility(View.GONE);
                if (JDNewCategoryFragment.this.isAdded())
                    JDNewCategoryFragment.this.mJdTipImage.setBackgroundResource(R.drawable.category_kongbai);//2130838448
            }
        });
        final HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setListener(new HttpGroup.OnCommonListener(){// r(paramJDNewCategoryFragment, new ExceptionReporter(localHttpSetting), paramBoolean1, paramBoolean2)
            private void a()
            {
                JDNewCategoryFragment.this.post(new Runnable(){//t(this)
                    @Override
                    public void run() {
                        JDNewCategoryFragment.this.mMainlayout.setVisibility(View.GONE);
                        JDNewCategoryFragment.this.mMainLoadingErrorTips.setVisibility(View.VISIBLE);
                        if (JDNewCategoryFragment.this.isAdded())
                            JDNewCategoryFragment.this.mJdTipImage.setBackgroundResource(R.drawable.y_03);//2130837707
                    }
                });
            }
            @Override
            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {

            }

            @Override
            public void onError(HttpGroup.HttpError paramHttpError) {
                a();
            }

            @Override
            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                if (!paramBoolean2)//this.c //if-nez v0, :cond_2
                {
                    if (!paramBoolean1)//this.d //if-nez v0, :cond_0
                        JDNewCategoryFragment.this.entranceCatalog(true, true);
                    JDNewCategoryFragment.this.catalogSortEventId = paramHttpResponse.getJSONObject().optString("catalogSortEventId");
                    JDNewCategoryFragment.this.StrcatalogTopNum = paramHttpResponse.getJSONObject().optString("catalogTopNum");
                    JDNewCategoryFragment.this.catelogyList = paramHttpResponse.getJSONObject().getJSONArrayOrNull("catelogyList");
                    if (TextUtils.isEmpty(JDNewCategoryFragment.this.StrcatalogTopNum)) {//if-eqz v0, :cond_3
                        JDNewCategoryFragment.this.G =  "null";
                        JDNewCategoryFragment.this.catalogTopNum = 0;
                    }else{
                        JDNewCategoryFragment.this.catalogTopNum = Integer.parseInt(JDNewCategoryFragment.this.StrcatalogTopNum);
                        JDNewCategoryFragment.this.G = Catelogy.getCmsTotalCid(Catelogy.toList(JDNewCategoryFragment.this.catelogyList, 0), JDNewCategoryFragment.this.catalogTopNum);
                    }

                    if ((JDNewCategoryFragment.this.catelogyList == null) || (JDNewCategoryFragment.this.catelogyList.length() == 0))
                    {
                        new ExceptionReporter(localHttpSetting).reportHttpBusinessException(paramHttpResponse);
                        a();
                    }else{
                        JDNewCategoryFragment.this.post(new Runnable(){//s(this)
                            @Override
                            public void run() {
                                JDNewCategoryFragment.this.mLeftCatelogList.clear();
                                JDNewCategoryFragment.this.mLeftCatelogList.addAll(Catelogy.toList(JDNewCategoryFragment.this.catelogyList, 0));
                                if (!JDNewCategoryFragment.this.v)
                                {
                                    JDNewCategoryFragment.this.synthetic_z(JDNewCategoryFragment.this);
                                    JDNewCategoryFragment.this.mLeftListAdapter.notifyDataSetChanged();
                                }else {
                                    JDNewCategoryFragment.this.b();
                                    JDNewCategoryFragment.this.mLeftListAdapter.notifyDataSetChanged();
                                }
                            }
                        });
                    }

                }
                //:cond_2
                //:goto_1
                return;
            }
        });
        localHttpSetting.setFunctionId("entranceCatalog");
        localHttpSetting.setHost(Configuration.getPortalHost());
        if (paramBoolean1)
        {
            localHttpSetting.setLocalFileCache(true);
            localHttpSetting.setLocalFileCacheTime(86400000L);
            if (paramBoolean2)//if-eqz p2, :cond_2
                localHttpSetting.setCacheMode(4);
            else
                localHttpSetting.setCacheMode(0);
        }

        localHttpSetting.setBussinessId(300);
        if (this.U) {
            localHttpSetting.setCacheMode(2);
            this.U = false;
        }
        this.mBaseActivity.getHttpGroupaAsynPool().add(localHttpSetting);
        return;

    }

    static boolean synthetic_q(JDNewCategoryFragment paramJDNewCategoryFragment)
    {
        long l1 = System.currentTimeMillis();
        if (l1 - paramJDNewCategoryFragment.x < 800L)
            return true;
        paramJDNewCategoryFragment.x = l1;
        return false;
    }

    static void synthetic_z(JDNewCategoryFragment paramJDNewCategoryFragment)
    {
        paramJDNewCategoryFragment.H = ((Catelogy)paramJDNewCategoryFragment.mLeftCatelogList.get(0)).getcId();
        paramJDNewCategoryFragment.mCurrentCatelogyCId = ((Catelogy)paramJDNewCategoryFragment.mLeftCatelogList.get(0)).getcId();
        paramJDNewCategoryFragment.a(paramJDNewCategoryFragment.mCurrentCatelogyCId);
        paramJDNewCategoryFragment.S = true;
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
