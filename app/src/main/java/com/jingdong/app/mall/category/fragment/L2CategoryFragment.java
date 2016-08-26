package com.jingdong.app.mall.category.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jingdong.app.mall.category.adapter.RightListAdapter;
import com.jingdong.app.mall.searchRefactor.view.Activity.ProductListActivity;
import com.jingdong.app.mall.utils.JDEbookUtil;
import com.jingdong.app.mall.utils.LoginUser;
import com.jingdong.app.mall.utils.StartActivityUtils;
import com.jingdong.app.mall.utils.ui.view.CarouseFigureImagePagerAdapter;
import com.jingdong.app.mall.utils.ui.view.CarouselFigureView;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.jdtravel.FlightSearchActivity;
import com.jingdong.common.movie.main.MovieActivity;
import com.jingdong.common.phonecharge.PhoneChargeActivity;
import com.jingdong.common.ranking.activity.RankingListActivity;
import com.jingdong.common.sample.jshop.JshopMainShopActivity;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.JDGameUtil;
import com.jingdong.common.utils.URLParamMap;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.b.RightListColumn;
import com.zy.app.mall.category.fragment.CategoryFragment;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.common.entity.Catelogy;
import com.zy.common.entity.SourceEntity;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDMtaUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Robin on 2016/8/20.
 */
public class L2CategoryFragment extends CategoryFragment {
    private long A = -1L;
    private String B = "";
    private ViewGroup C;
    private CarouselFigureView D;
    protected int c = -1;
    protected String d;
    protected String e = null;
    protected List<RightColumnBase> f = new ArrayList();
    protected RightListAdapter g;
    protected View h;
    protected boolean i = true;
    protected View j;
    protected ImageView k;
    protected View l;
    protected HashMap<String, ArrayList<RightColumnBase>> m = null;
    protected String n;
    private String r = "-1";
    private String s = "";
    private String t = "0";
    private String u = "";
    private String v = "";
    private String w = "";
    private String x = "";
    private String y = "";
    private long z = 0L;

    protected static List<String> a(List<RightColumnBase> paramList)
    {
        ArrayList<String> localArrayList = new ArrayList();
        Iterator<RightColumnBase> iterator = paramList.iterator();
        while (iterator.hasNext())
        {
            Object localObject = (RightListColumn)iterator.next();
            if (((RightColumnBase)localObject).a != 1)
                continue;
            localObject = (RightListColumn)localObject;
            int i2 = ((RightListColumn)localObject).c();

            for (int i1 = 0; i1 < i2; i1++)
            {
                String str = ((RightListColumn)localObject).a(i1).getImgUrl();
                if (!TextUtils.isEmpty(str))
                    localArrayList.add(str);

            }
        }
        return localArrayList;
    }

    protected final BaseAdapter a()
    {
        return this.g;
    }

    public final void a(View paramView)
    {
        this.l = paramView;
    }

    public final void a(View paramView, ImageView paramImageView)
    {
        this.j = paramView;
        this.k = paramImageView;
    }

    protected final void a(ViewGroup paramViewGroup, View paramView)
    {
        paramViewGroup.addView(paramView);
        if (this.p.getAdapter() == null)
        {
            this.p.addHeaderView(paramViewGroup);
            return;
        }
        this.p.setAdapter(null);
        this.p.addHeaderView(paramViewGroup);
        this.p.setAdapter(this.g);
    }

    protected final void a(Catelogy paramCatelogy, View paramView) {
        if (paramCatelogy == null)
            return;
        ArrayList<RightColumnBase> list = null;
        int i1 = 0, i2 = 0;
        if ((this.m != null) && (this.m.containsKey(paramCatelogy.getLevel2Cid()))) {//if-eqz v0, :cond_2
            list = (ArrayList) this.m.get(paramCatelogy.getLevel2Cid());//v8
            String action = paramCatelogy.getAction();//v4
            String cid = paramCatelogy.getLevel2Cid();//v5
            if ((this.f != null) || (this.f.size() > 0)) {//if-lez v0, :cond_5
                //v2
                //:goto_1
                labe:for (i1 = 0; i1 < this.f.size(); i1++) {//if-ge v2, v0, :cond_5
                    RightColumnBase rightColumn = (RightColumnBase) this.f.get(i1);
                    if (rightColumn instanceof RightListColumn) {//if-eqz v1, :cond_4
                        //v3
                        //:goto_2
                        for (i2 = 0; i2 < ((RightListColumn) rightColumn).a().size(); i2++) {//if-ge v3, v1, :cond_4
                            Catelogy localCatelogy = ((RightListColumn) rightColumn).a(i2);
                            if ((((String) action).equals(localCatelogy.getAction())) && (((String) cid).equals(localCatelogy.getLevel2Cid()))) {//if-eqz v1, :cond_3
                                break labe;//goto :goto_3
                            }
                            //:cond_3

                        }
                    }//:cond_4
                }
            }else//:cond_5
                i1--;
            //:goto_3
            if (i1 != -1) {//if-eq v9, v0, :cond_2
                if ("chSpreadAllData".equals(paramCatelogy.getAction())) {//if-eqz v0, :cond_6
                    JDMtaUtils.sendCommonData(getActivity(), "MCategory_MoreSCategory", "", "onClick", JDNewCategoryFragment.class.getName(), paramCatelogy.getLevel2Cid(), "", "");
                    List<Catelogy> list1 = ((RightListColumn) this.f.get(i1)).a();
                    list1.remove(list1.size() - 1);
                    if ((list != null) && (((ArrayList) list).size() > 0)) {//if-eqz v8, :cond_2
                        list1.add(((RightListColumn) ((ArrayList) list).get(0)).a(0));
                        List list2 = new ArrayList();
                        list2.addAll((Collection) list);
                        list2.remove(0);
                        this.f.addAll(i1 + 1, list2);
                        this.g.notifyDataSetChanged();
                    }
                } else if ("enSpreadAllData".equals(paramCatelogy.getAction())) {//if-eqz v0, :cond_7
                    JDMtaUtils.sendCommonData(getActivity(), "MCategory_MoreSCategory", "", "onClick", JDNewCategoryFragment.class.getName(), paramCatelogy.getLevel2Cid(), "", "");
                    this.f.remove(i1);
                    if ((list != null) && (((ArrayList) list).size() > 0)) {
                        this.f.addAll(i1, (Collection) list);
                        this.g.notifyDataSetChanged();
                    }
                } else if ("chPackUpAllData".equals(paramCatelogy.getAction())) {//if-eqz v0, :cond_8
                    Catelogy catelogy = new Catelogy();
                    ((Catelogy) catelogy).setName(getFragmentString(2131233765));//2131233765
                    ((Catelogy) catelogy).setLevel2Cid(paramCatelogy.getLevel2Cid());
                    ((Catelogy) catelogy).setAction("chSpreadAllData");
                    if ((list != null) && (((ArrayList) list).size() > 0)) {
                        i2 = i1 - (((ArrayList) list).size() - 1);
                        List<Catelogy> list1 = ((RightListColumn) this.f.get(i2)).a();
                        ((List) list1).remove(2);
                        ((List) list1).add(catelogy);
                        List list2 = new ArrayList();
                        ((ArrayList) list2).addAll((Collection) list);
                        ((ArrayList) list2).remove(0);
                        this.f.removeAll((Collection) list2);
                        this.g.notifyDataSetChanged();
                        Rect rect = new Rect();
                        getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect) rect);
                        i1 = ((Rect) rect).top;
                        int[] a = new int[2];
                        paramView.getLocationOnScreen(a);
                        i2 -= 2;
                        if ((i2 != 0) && (i2 < this.b)) {
                            int i3 = a[1];
                            int i4 = DPIUtil.dip2px(147.0F);
                            this.p.setSelectionFromTop(i2 + 1, i3 - i1 - i4);
                        }
                    }
                } else if ("enPackUpAllData".equals(paramCatelogy.getAction())) {//if-eqz v0, :cond_2
                    RightListColumn rightListColumn = new RightListColumn();
                    rightListColumn.b(1);
                    rightListColumn.a = 2;
                    Catelogy catelogy = new Catelogy();
                    ((Catelogy) catelogy).setName(getFragmentString(2131231468));//2131231468
                    ((Catelogy) catelogy).setLevel2Cid(paramCatelogy.getLevel2Cid());
                    ((Catelogy) catelogy).setAction("enSpreadAllData");
                    rightListColumn.a((Catelogy) catelogy);
                    if ((list != null) && (((ArrayList) list).size() > 0)) {
                        i2 = ((ArrayList) list).size();
                        this.f.removeAll((Collection) list);
                        this.f.add(i1 - (i2 - 1), rightListColumn);
                        this.g.notifyDataSetChanged();
                        //goto/16 :goto_4
                    }
                }
            }
        }

        //:cond_2
        //:goto_4
        if ((paramCatelogy.isWantedToEbookM()) && (!TextUtils.isEmpty(paramCatelogy.getAction()))) {//if-nez v0, :cond_9
            a(paramCatelogy, "");
            JDEbookUtil.a(this.thisActivity, paramCatelogy.getAction());
            //goto/16 :goto_0
        } else if (paramCatelogy.isWantedToQqRecharge()) {//if-eqz v0, :cond_a
            Intent intent = new Intent(this.thisActivity, PhoneChargeActivity.class);
            intent.putExtra("jumpType", 0);
            a(paramCatelogy, PhoneChargeActivity.class.getName());
            this.thisActivity.startActivityInFrame(intent);
            return;
        } else if (paramCatelogy.isWantedToGameRecharge()) {//if-eqz v0, :cond_b
            Intent intent = new Intent(this.thisActivity, PhoneChargeActivity.class);
            intent.putExtra("jumpType", 1);
            a(paramCatelogy, PhoneChargeActivity.class.getName());
            this.thisActivity.startActivityInFrame(intent);
            return;
        } else if (paramCatelogy.isWantedToRecharge()) {//if-eqz v0, :cond_c
            Intent intent = new Intent(this.thisActivity, PhoneChargeActivity.class);
            intent.putExtra("jumpType", 2);
            a(paramCatelogy, PhoneChargeActivity.class.getName());
            this.thisActivity.startActivityInFrame(intent);
            return;
        } else if (paramCatelogy.isWantedToDataRecharge()) {//if-eqz v0, :cond_d
            Intent intent = new Intent(this.thisActivity, PhoneChargeActivity.class);
            intent.putExtra("jumpType", 3);
            a(paramCatelogy, PhoneChargeActivity.class.getName());
            this.thisActivity.startActivityInFrame(intent);
            return;
        } else if (paramCatelogy.isWantedToGoToShop()) {//if-eqz v0, :cond_e
            Intent intent = new Intent(this.thisActivity, JshopMainShopActivity.class);
            JSONObject jsonObject = new JSONObject();
            try {
                ((JSONObject) jsonObject).put("shopId", paramCatelogy.getShopId());
                intent.putExtra("brand.json", ((JSONObject) jsonObject).toString());
                a(paramCatelogy, JshopMainShopActivity.class.getName());
                this.thisActivity.startActivityInFrameWithNoNavigation(intent);
            } catch (JSONException localJSONException) {
                    localJSONException.printStackTrace();
            }
            return;
        } else if (paramCatelogy.isWantedToSearchProduct()) {//if-eqz v0, :cond_f
            Intent intent = new Intent(this.thisActivity, ProductListActivity.class);
            intent.putExtra("keyWord", paramCatelogy.getSearchKey());
            intent.putExtra("sortKey", -2);
            intent.putExtra("forNoText", true);
            a(paramCatelogy, ProductListActivity.class.getName());
            this.thisActivity.startActivityInFrameWithNoNavigation(intent);
            return;
        } else if (paramCatelogy.isWantedToLottery()) {//if-eqz v0, :cond_10
            a(paramCatelogy, "");
            return;
        } else if (paramCatelogy.isWantedToAirLine()) {//if-eqz v0, :cond_11
            a(paramCatelogy, FlightSearchActivity.class.getName());
            StartActivityUtils.a(this.thisActivity, null);
            return;
        } else if (paramCatelogy.isGoToMoviePage()) {//if-eqz v0, :cond_12
            a(paramCatelogy, MovieActivity.class.getName());
            StartActivityUtils.b(this.thisActivity);
            return;
        } else if (paramCatelogy.isGoToMWithAction()) {//if-eqz v0, :cond_13
            a(paramCatelogy, "");
            com.jingdong.app.mall.utils.CommonUtil.toBrowserInFrame(this.thisActivity, paramCatelogy.getAction(), new URLParamMap());
            return;
        } else if (paramCatelogy.isGoToMWithTo()) {//if-eqz v0, :cond_17
            a(paramCatelogy, "");
            if (paramCatelogy.isWantedToJDGame()) {//if-eqz v0, :cond_16
                Activity activity = this.thisActivity;
                String action = paramCatelogy.getAction();
                URLParamMap urlParamMap = new URLParamMap();
                StringBuilder stringBuilder = new StringBuilder().append((String) action).append("?hasApp=");
                PackageInfo packageInfo = CommonUtil.getPackageInfo(activity, "com.jingdong.jgame");
                boolean hasApp = false;
                if (packageInfo != null&& (((PackageInfo) packageInfo).versionCode > 4))//if-le v0, v6, :cond_14
                    hasApp = true;

                urlParamMap.put("to", stringBuilder.append(hasApp).append("&loginName").append("=").append(LoginUser.getLoginName()).append("&loginCookie").append("=").append(JDGameUtil.a(HttpGroup.getCookie())).toString());
                com.jingdong.app.mall.utils.CommonUtil.toBrowserInFrame(activity, "to", urlParamMap);
            }
            URLParamMap urlParamMap = new URLParamMap();
            urlParamMap.put("to", paramCatelogy.getAction());
            com.jingdong.app.mall.utils.CommonUtil.toBrowserInFrame(this.thisActivity, "to", urlParamMap);
            return;
        } else if (paramCatelogy.isGoToHotBook()) {//if-eqz v0, :cond_18
            a(paramCatelogy, "");
            Activity activity = this.thisActivity;
            String cateId = paramCatelogy.getLevel3Cid();
            Intent intent = new Intent(activity, RankingListActivity.class);
            ((Intent) intent).putExtra("rank_id", "rank3008");
            ((Intent) intent).putExtra("cateId", cateId);
            ((Intent) intent).putExtra("rank_small_entry", "Classification");
            ((Intent) intent).addFlags(268435456);
            activity.startActivity((Intent) intent);
            return;
        } else if (paramCatelogy.isGoToNewBook()) {//if-eqz v0, :cond_19
            a(paramCatelogy, "");
            Activity activity = this.thisActivity;
            String cateId = paramCatelogy.getLevel3Cid();
            Intent intent = new Intent(activity, RankingListActivity.class);
            intent.putExtra("rank_id", "rank3009");
            intent.putExtra("cateId", cateId);
            intent.putExtra("rank_small_entry", "Classification");
            intent.addFlags(268435456);
            activity.startActivity(intent);
            return;
        } else if (-1 == this.c) {//if-ne v0, v1, :cond_1b
            Intent intent = new Intent(this.thisActivity, ProductListActivity.class);
            Bundle bundle = new Bundle();
            ((Bundle) bundle).putString("name", paramCatelogy.getName());
            if (!TextUtils.isEmpty(paramCatelogy.getLevel3Cid())) {//if-nez v0, :cond_0
                ((Bundle) bundle).putString("cid", paramCatelogy.getLevel3Cid());
                if (paramCatelogy.isHasLevelFour())
                    ((Bundle) bundle).putParcelableArrayList("levelFourList", (ArrayList) paramCatelogy.getLevelFourList());
                ((Bundle) bundle).putString("levelFirst", paramCatelogy.getLevel1Cid());
                ((Bundle) bundle).putString("levelSecond", paramCatelogy.getLevel2Cid());
                ((Bundle) bundle).putBoolean("firstToList", true);
                intent.putExtras((Bundle) bundle);
                intent.putExtra("source", new SourceEntity("catelogy", paramCatelogy.getLevel3Cid()));
                StartActivityUtils.a(this.thisActivity, intent, false);
                a(paramCatelogy, "");
            }
            return;
        } else {
            String cid = paramCatelogy.getcId();
            String name = paramCatelogy.getName();

            if (!TextUtils.isEmpty(cid)) {//if-nez v1, :cond_0
                Object localObject3 = paramCatelogy.getLevel2Cid();
                Object localObject4 = new Intent(this.thisActivity, ProductListActivity.class);
                Object localObject5 = new Bundle();
                ((Bundle) localObject5).putString("name", (String) name);
                ((Bundle) localObject5).putString("cid", cid);
                if (paramCatelogy.isHasLevelFour())
                    ((Bundle) localObject5).putParcelableArrayList("levelFourList", (ArrayList) paramCatelogy.getLevelFourList());
                ((Bundle) localObject5).putString("levelFirst", this.d);
                ((Bundle) localObject5).putString("levelSecond", (String) localObject3);
                ((Bundle) localObject5).putBoolean("firstToList", true);
                ((Intent) localObject4).putExtras((Bundle) localObject5);
                ((Intent) localObject4).putExtra("source", new SourceEntity("catelogy", cid));
                StartActivityUtils.a(this.thisActivity, (Intent) localObject4, false);
                JDMtaUtils.sendCommonData(this.thisActivity, "MCategory_SCategory", cid + "_" + this.e, "", JDNewCategoryFragment.class, this.d + "_" + (this.c + 1), ProductListActivity.class, "");

            }

        }
    }

    public void a(Catelogy paramCatelogy, String paramString)
    {
    }

    protected void a(final String paramString)
    {
        if ((paramString == null) || (paramString.equals(this.n)))
            return;
        this.thisActivity.runOnUiThread(new Runnable(){//b(this)
            @Override
            public void run() {
                try
                {
                    if (L2CategoryFragment.this.C != null)
                        L2CategoryFragment.this.p.removeHeaderView(L2CategoryFragment.this.C);
                    L2CategoryFragment.this.C = L2CategoryFragment.a(this.a, L2CategoryFragment.this.p);
                    L2CategoryFragment.this.D = L2CategoryFragment.b(this.a, L2CategoryFragment.this.C);
                    L2CategoryFragment.this.a(L2CategoryFragment.this.C, L2CategoryFragment.this.D);
                    return;
                }
                catch (Exception localException)
                {
                    localException.printStackTrace();
                }
            }
        });
        post(new Runnable(){//c(this, paramString)
            @Override
            public void run() {
                L2CategoryFragment.this.D.a(new CarouseFigureImagePagerAdapter.DataPresenter() {
                    @Override
                    public int size() {
                        return 1;
                    }

                    @Override
                    public String getImage(int paramInt) {
                        return paramString;
                    }

                    @Override
                    public JDDisplayImageOptions getDisplayImageOptions() {
                        return null;
                    }

                    @Override
                    public void onClick(int paramInt) {
                        L2CategoryFragment.this.b();
                    }
                });

            }
        });
    }

    public final void a(String paramString, int paramInt)
    {
        this.r = paramString;
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setListener(new e(this, paramString, new ExceptionReporter(localHttpSetting)));
        localHttpSetting.setFunctionId("getCmsPromotionsListByCatelogyID");
        localHttpSetting.setHost(Configuration.getPortalHost());
        localHttpSetting.putJsonParam("catelogyID", paramString);
        localHttpSetting.putJsonParam("level", 1);
        localHttpSetting.setPost(false);
        localHttpSetting.setEffect(0);
        this.thisActivity.getHttpGroupaAsynPool().add(localHttpSetting);
    }

    public void a(String paramString1, String paramString2, int paramInt)
    {
        this.d = paramString1;
        this.e = paramString2;
        this.c = paramInt;
    }

    public final void a(boolean paramBoolean)
    {
        this.i = paramBoolean;
    }

    protected final void b()
    {
        if (!this.t.equals("0"))
        {
            if (TextUtils.isEmpty(this.v))
                break label586;
            if (!this.v.equals("ads"))
                break label184;
        }
        label184: label586: for (Object localObject1 = "1"; ; localObject1 = "0")
        {
            while (true)
            {
                Object localObject2 = new HttpGroup.HttpSetting();
                ((HttpGroup.HttpSetting)localObject2).setFunctionId("adsPromotionLog");
                ((HttpGroup.HttpSetting)localObject2).setHost(Configuration.getPortalHost());
                ((HttpGroup.HttpSetting)localObject2).putJsonParam("bannerSource", this.v);
                ((HttpGroup.HttpSetting)localObject2).putJsonParam("promotionLogUrl", this.w);
                this.thisActivity.getHttpGroupaAsynPool().add((HttpGroup.HttpSetting)localObject2);
                if ((!TextUtils.isEmpty(this.y)) && (this.y.equals("1")))
                {
                    localObject1 = new Intent(this.thisActivity, JshopMainShopActivity.class);
                    try
                    {
                        localObject2 = new JSONObject();
                        ((JSONObject)localObject2).put("shopId", this.B);
                        localBundle = new Bundle();
                        localBundle.putString("brand.json", ((JSONObject)localObject2).toString());
                        ((Intent)localObject1).putExtras(localBundle);
                        startActivity((Intent)localObject1);
                        return;
                        localObject1 = "0";
                    }
                    catch (JSONException localJSONException)
                    {
                        while (true)
                            localJSONException.printStackTrace();
                    }
                }
            }
            if (!TextUtils.isEmpty(this.u))
            {
                localObject3 = new URLParamMap();
                ((URLParamMap)localObject3).put("to", this.u);
                com.jingdong.app.mall.utils.CommonUtil.toBrowserInFrame(this.thisActivity, "to", (URLParamMap)localObject3);
                if (this.c == -1)
                {
                    JDMtaUtils.sendCommonData(this.thisActivity, "Classification_activityid", "", "", JDNewCategoryFragment.class, this.r + "_" + (String)localObject1, WebActivity.class, "");
                    return;
                }
                JDMtaUtils.sendCommonData(this.thisActivity, "BCategory_activityid", "", "", JDNewCategoryFragment.class, this.r + "_" + (String)localObject1, WebActivity.class, "");
                return;
            }
            Object localObject3 = new Intent(this.thisActivity, PromotionMessageActivity.class);
            Bundle localBundle = new Bundle();
            if ((this.s == null) || ("".equals(this.s)))
                this.s = "促销专题";
            localBundle.putString("comeFrom", "category");
            localBundle.putString("name", this.s);
            localBundle.putString("promotion_id", this.t);
            ((Intent)localObject3).putExtras(localBundle);
            ((Intent)localObject3).putExtra("com.360buy:navigationDisplayFlag", -1);
            startActivity((Intent)localObject3);
            if (this.c == -1)
            {
                JDMtaUtils.sendCommonData(this.thisActivity, "Classification_activityid", this.t, "", JDNewCategoryFragment.class, this.r + "_" + (String)localObject1, PromotionMessageActivity.class, "");
                return;
            }
            JDMtaUtils.sendCommonData(this.thisActivity, "BCategory_activityid", this.t, "", JDNewCategoryFragment.class, this.r + "_" + (String)localObject1, PromotionMessageActivity.class, "");
            return;
        }
    }

    protected final void b(boolean paramBoolean)
    {
        String str = this.n;
        if (paramBoolean)
            this.n = null;
        a(str);
        if (paramBoolean)
            this.n = str;
        super.b(paramBoolean);
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.d = paramBundle.getString("level_first");
        this.e = paramBundle.getString("catalog_sort_event_id");
        this.c = paramBundle.getInt("current_item");
    }

    public void onDestroy()
    {
        super.onDestroy();
    }


}
