package com.jingdong.app.mall.category.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.URLParamMap;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.category.fragment.CategoryFragment;
import com.zy.common.entity.Catelogy;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.JDMtaUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
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
    protected List<com.jingdong.app.mall.category.b.b> f = new ArrayList();
    protected com.jingdong.app.mall.category.adapter.e g;
    protected View h;
    protected boolean i = true;
    protected View j;
    protected ImageView k;
    protected View l;
    protected HashMap<String, ArrayList<com.jingdong.app.mall.category.b.b>> m = null;
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

    protected static List<String> a(List<com.jingdong.app.mall.category.b.b> paramList)
    {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
            Object localObject = (com.jingdong.app.mall.category.b.b)paramList.next();
            if (((com.jingdong.app.mall.category.b.b)localObject).a != 1)
                continue;
            localObject = (com.jingdong.app.mall.category.b.c)localObject;
            int i2 = ((com.jingdong.app.mall.category.b.c)localObject).c();
            int i1 = 0;
            while (i1 < i2)
            {
                String str = ((com.jingdong.app.mall.category.b.c)localObject).a(i1).getImgUrl();
                if (!TextUtils.isEmpty(str))
                    localArrayList.add(str);
                i1 += 1;
            }
        }
        return (List<String>)localArrayList;
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

    protected final void a(Catelogy paramCatelogy, View paramView)
    {
        if (paramCatelogy == null);
        Object localObject1;
        label116: label379:
        do
        {
            while (true)
            {
                return;
                Object localObject2;
                int i1;
                int i2;
                if ((this.m != null) && (this.m.containsKey(paramCatelogy.getLevel2Cid())))
                {
                    localObject1 = (ArrayList)this.m.get(paramCatelogy.getLevel2Cid());
                    localObject2 = paramCatelogy.getAction();
                    localObject4 = paramCatelogy.getLevel2Cid();
                    if ((this.f == null) || (this.f.size() <= 0))
                        break label379;
                    i1 = 0;
                    if (i1 >= this.f.size())
                        break label379;
                    localObject5 = (com.jingdong.app.mall.category.b.b)this.f.get(i1);
                    if (!(localObject5 instanceof com.jingdong.app.mall.category.b.c))
                        break label370;
                    i2 = 0;
                    if (i2 >= ((com.jingdong.app.mall.category.b.c)localObject5).a().size())
                        break label370;
                    Catelogy localCatelogy = ((com.jingdong.app.mall.category.b.c)localObject5).a(i2);
                    if ((!((String)localObject2).equals(localCatelogy.getAction())) || (!((String)localObject4).equals(localCatelogy.getLevel2Cid())))
                        break label361;
                    if (i1 != -1)
                    {
                        if (!"chSpreadAllData".equals(paramCatelogy.getAction()))
                            break label385;
                        JDMtaUtils.sendCommonData(getActivity(), "MCategory_MoreSCategory", "", "onClick", JDNewCategoryFragment.class.getName(), paramCatelogy.getLevel2Cid(), "", "");
                        paramView = ((com.jingdong.app.mall.category.b.c)this.f.get(i1)).a();
                        paramView.remove(paramView.size() - 1);
                        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
                        {
                            paramView.add(((com.jingdong.app.mall.category.b.c)((ArrayList)localObject1).get(0)).a(0));
                            paramView = new ArrayList();
                            paramView.addAll((Collection)localObject1);
                            paramView.remove(0);
                            this.f.addAll(i1 + 1, paramView);
                            this.g.notifyDataSetChanged();
                        }
                    }
                }
                while (true)
                {
                    if ((!paramCatelogy.isWantedToEbookM()) || (TextUtils.isEmpty(paramCatelogy.getAction())))
                        break label848;
                    a(paramCatelogy, "");
                    at.a(this.thisActivity, paramCatelogy.getAction());
                    return;
                    i2 += 1;
                    break label116;
                    i1 += 1;
                    break;
                    i1 = -1;
                    break label172;
                    if ("enSpreadAllData".equals(paramCatelogy.getAction()))
                    {
                        JDMtaUtils.sendCommonData(getActivity(), "MCategory_MoreSCategory", "", "onClick", JDNewCategoryFragment.class.getName(), paramCatelogy.getLevel2Cid(), "", "");
                        this.f.remove(i1);
                        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
                            continue;
                        this.f.addAll(i1, (Collection)localObject1);
                        this.g.notifyDataSetChanged();
                        continue;
                    }
                    if ("chPackUpAllData".equals(paramCatelogy.getAction()))
                    {
                        localObject2 = new Catelogy();
                        ((Catelogy)localObject2).setName(getFragmentString(2131233765));
                        ((Catelogy)localObject2).setLevel2Cid(paramCatelogy.getLevel2Cid());
                        ((Catelogy)localObject2).setAction("chSpreadAllData");
                        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
                            continue;
                        i2 = i1 - (((ArrayList)localObject1).size() - 1);
                        localObject4 = ((com.jingdong.app.mall.category.b.c)this.f.get(i2)).a();
                        ((List)localObject4).remove(2);
                        ((List)localObject4).add(localObject2);
                        localObject2 = new ArrayList();
                        ((ArrayList)localObject2).addAll((Collection)localObject1);
                        ((ArrayList)localObject2).remove(0);
                        this.f.removeAll((Collection)localObject2);
                        this.g.notifyDataSetChanged();
                        localObject1 = new Rect();
                        getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
                        i1 = ((Rect)localObject1).top;
                        localObject1 = new int[2];
                        paramView.getLocationOnScreen(localObject1);
                        i2 -= 2;
                        if ((i2 == 0) || (i2 >= this.b))
                            continue;
                        int i3 = localObject1[1];
                        int i4 = DPIUtil.dip2px(147.0F);
                        this.p.setSelectionFromTop(i2 + 1, i3 - i1 - i4);
                        continue;
                    }
                    if (!"enPackUpAllData".equals(paramCatelogy.getAction()))
                        continue;
                    paramView = new com.jingdong.app.mall.category.b.c();
                    paramView.b(1);
                    paramView.a = 2;
                    localObject2 = new Catelogy();
                    ((Catelogy)localObject2).setName(getFragmentString(2131231468));
                    ((Catelogy)localObject2).setLevel2Cid(paramCatelogy.getLevel2Cid());
                    ((Catelogy)localObject2).setAction("enSpreadAllData");
                    paramView.a((Catelogy)localObject2);
                    if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
                        continue;
                    i2 = ((ArrayList)localObject1).size();
                    this.f.removeAll((Collection)localObject1);
                    this.f.add(i1 - (i2 - 1), paramView);
                    this.g.notifyDataSetChanged();
                }
                if (paramCatelogy.isWantedToQqRecharge())
                {
                    paramView = new Intent(this.thisActivity, PhoneChargeActivity.class);
                    paramView.putExtra("jumpType", 0);
                    a(paramCatelogy, PhoneChargeActivity.class.getName());
                    this.thisActivity.startActivityInFrame(paramView);
                    return;
                }
                if (paramCatelogy.isWantedToGameRecharge())
                {
                    paramView = new Intent(this.thisActivity, PhoneChargeActivity.class);
                    paramView.putExtra("jumpType", 1);
                    a(paramCatelogy, PhoneChargeActivity.class.getName());
                    this.thisActivity.startActivityInFrame(paramView);
                    return;
                }
                if (paramCatelogy.isWantedToRecharge())
                {
                    paramView = new Intent(this.thisActivity, PhoneChargeActivity.class);
                    paramView.putExtra("jumpType", 2);
                    a(paramCatelogy, PhoneChargeActivity.class.getName());
                    this.thisActivity.startActivityInFrame(paramView);
                    return;
                }
                if (paramCatelogy.isWantedToDataRecharge())
                {
                    paramView = new Intent(this.thisActivity, PhoneChargeActivity.class);
                    paramView.putExtra("jumpType", 3);
                    a(paramCatelogy, PhoneChargeActivity.class.getName());
                    this.thisActivity.startActivityInFrame(paramView);
                    return;
                }
                if (paramCatelogy.isWantedToGoToShop())
                {
                    paramView = new Intent(this.thisActivity, JshopMainShopActivity.class);
                    localObject1 = new JSONObject();
                    try
                    {
                        ((JSONObject)localObject1).put("shopId", paramCatelogy.getShopId());
                        paramView.putExtra("brand.json", ((JSONObject)localObject1).toString());
                        a(paramCatelogy, JshopMainShopActivity.class.getName());
                        this.thisActivity.startActivityInFrameWithNoNavigation(paramView);
                        return;
                    }
                    catch (JSONException localJSONException)
                    {
                        while (true)
                            localJSONException.printStackTrace();
                    }
                }
                if (paramCatelogy.isWantedToSearchProduct())
                {
                    paramView = new Intent(this.thisActivity, ProductListActivity.class);
                    paramView.putExtra("keyWord", paramCatelogy.getSearchKey());
                    paramView.putExtra("sortKey", -2);
                    paramView.putExtra("forNoText", true);
                    a(paramCatelogy, ProductListActivity.class.getName());
                    this.thisActivity.startActivityInFrameWithNoNavigation(paramView);
                    return;
                }
                if (paramCatelogy.isWantedToLottery())
                {
                    a(paramCatelogy, "");
                    return;
                }
                if (paramCatelogy.isWantedToAirLine())
                {
                    a(paramCatelogy, FlightSearchActivity.class.getName());
                    bp.a(this.thisActivity, null);
                    return;
                }
                if (paramCatelogy.isGoToMoviePage())
                {
                    a(paramCatelogy, MovieActivity.class.getName());
                    bp.b(this.thisActivity);
                    return;
                }
                if (paramCatelogy.isGoToMWithAction())
                {
                    a(paramCatelogy, "");
                    com.jingdong.app.mall.utils.CommonUtil.toBrowserInFrame(this.thisActivity, paramCatelogy.getAction(), new URLParamMap());
                    return;
                }
                if (paramCatelogy.isGoToMWithTo())
                {
                    a(paramCatelogy, "");
                    if (paramCatelogy.isWantedToJDGame())
                    {
                        paramView = this.thisActivity;
                        localObject1 = paramCatelogy.getAction();
                        paramCatelogy = new URLParamMap();
                        localObject1 = new StringBuilder().append((String)localObject1).append("?hasApp=");
                        localObject3 = com.zy.common.utils.CommonUtil.getPackageInfo(paramView, "com.jingdong.jgame");
                        boolean bool;
                        if (localObject3 != null)
                            if (((PackageInfo)localObject3).versionCode > 4)
                                bool = true;
                        while (true)
                        {
                            paramCatelogy.put("to", bool + "&loginName" + "=" + LoginUser.getLoginName() + "&loginCookie" + "=" + ck.a(HttpGroup.getCookie()));
                            com.jingdong.app.mall.utils.CommonUtil.toBrowserInFrame(paramView, "to", paramCatelogy);
                            return;
                            bool = false;
                            continue;
                            bool = false;
                        }
                    }
                    paramView = new URLParamMap();
                    paramView.put("to", paramCatelogy.getAction());
                    com.jingdong.app.mall.utils.CommonUtil.toBrowserInFrame(this.thisActivity, "to", paramView);
                    return;
                }
                if (paramCatelogy.isGoToHotBook())
                {
                    a(paramCatelogy, "");
                    paramView = this.thisActivity;
                    paramCatelogy = paramCatelogy.getLevel3Cid();
                    localObject1 = new Intent(paramView, RankingListActivity.class);
                    ((Intent)localObject1).putExtra("rank_id", "rank3008");
                    ((Intent)localObject1).putExtra("cateId", paramCatelogy);
                    ((Intent)localObject1).putExtra("rank_small_entry", "Classification");
                    ((Intent)localObject1).addFlags(268435456);
                    paramView.startActivity((Intent)localObject1);
                    return;
                }
                if (paramCatelogy.isGoToNewBook())
                {
                    a(paramCatelogy, "");
                    paramView = this.thisActivity;
                    paramCatelogy = paramCatelogy.getLevel3Cid();
                    localObject1 = new Intent(paramView, RankingListActivity.class);
                    ((Intent)localObject1).putExtra("rank_id", "rank3009");
                    ((Intent)localObject1).putExtra("cateId", paramCatelogy);
                    ((Intent)localObject1).putExtra("rank_small_entry", "Classification");
                    ((Intent)localObject1).addFlags(268435456);
                    paramView.startActivity((Intent)localObject1);
                    return;
                }
                if (-1 != this.c)
                    break;
                paramView = new Intent(this.thisActivity, ProductListActivity.class);
                localObject1 = new Bundle();
                ((Bundle)localObject1).putString("name", paramCatelogy.getName());
                if (TextUtils.isEmpty(paramCatelogy.getLevel3Cid()))
                    continue;
                ((Bundle)localObject1).putString("cid", paramCatelogy.getLevel3Cid());
                if (paramCatelogy.isHasLevelFour())
                    ((Bundle)localObject1).putParcelableArrayList("levelFourList", (ArrayList)paramCatelogy.getLevelFourList());
                ((Bundle)localObject1).putString("levelFirst", paramCatelogy.getLevel1Cid());
                ((Bundle)localObject1).putString("levelSecond", paramCatelogy.getLevel2Cid());
                ((Bundle)localObject1).putBoolean("firstToList", true);
                paramView.putExtras((Bundle)localObject1);
                paramView.putExtra("source", new SourceEntity("catelogy", paramCatelogy.getLevel3Cid()));
                bp.a(this.thisActivity, paramView, false);
                a(paramCatelogy, "");
                return;
            }
            paramView = paramCatelogy.getcId();
            localObject1 = paramCatelogy.getName();
        }
        while (TextUtils.isEmpty(paramView));
        label172: label361: label370: Object localObject3 = paramCatelogy.getLevel2Cid();
        label385: label848: Object localObject4 = new Intent(this.thisActivity, ProductListActivity.class);
        Object localObject5 = new Bundle();
        ((Bundle)localObject5).putString("name", (String)localObject1);
        ((Bundle)localObject5).putString("cid", paramView);
        if (paramCatelogy.isHasLevelFour())
            ((Bundle)localObject5).putParcelableArrayList("levelFourList", (ArrayList)paramCatelogy.getLevelFourList());
        ((Bundle)localObject5).putString("levelFirst", this.d);
        ((Bundle)localObject5).putString("levelSecond", (String)localObject3);
        ((Bundle)localObject5).putBoolean("firstToList", true);
        ((Intent)localObject4).putExtras((Bundle)localObject5);
        ((Intent)localObject4).putExtra("source", new SourceEntity("catelogy", paramView));
        bp.a(this.thisActivity, (Intent)localObject4, false);
        JDMtaUtils.sendCommonData(this.thisActivity, "MCategory_SCategory", paramView + "_" + this.e, "", JDNewCategoryFragment.class, this.d + "_" + (this.c + 1), ProductListActivity.class, "");
    }

    public void a(Catelogy paramCatelogy, String paramString)
    {
    }

    protected void a(String paramString)
    {
        if ((paramString == null) || (paramString.equals(this.n)))
            return;
        this.thisActivity.runOnUiThread(new b(this));
        post(new c(this, paramString));
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
