package com.zy.app.mall.category.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.R;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.category.adapter.IRightAdapterListener;
import com.zy.app.mall.category.adapter.RightListAdapter;
import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.b.RightListColumn;
import com.zy.app.mall.category.b.RightTitleColumn;
import com.zy.app.mall.category.fragment.L2CategoryFragment;
import com.zy.app.mall.category.view.CategoryFooter;
import com.zy.common.entity.Catelogy;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Robin on 2016/8/20.
 */
public class OrdinaryL2CategoryFragment extends L2CategoryFragment {
    private JSONArrayProxy r = null;
    private _U s = null;

    private List<RightColumnBase> a(JSONArrayProxy paramJSONArrayPoxy, int paramInt, String paramString)
    {
        if (this.m == null)
            this.m = new HashMap();
        this.m.clear();
        ArrayList localArrayList1 = new ArrayList();
        int i2 = paramJSONArrayPoxy.length();
        //:goto_0
        for (int i = 0; i < i2; i++){//if-ge v9, v11, :cond_17
            try {
                ArrayList localArrayList2 = new ArrayList();//v12
                JSONObjectProxy objectProxy = paramJSONArrayPoxy.getJSONObject(i);//
                String name = ((JSONObjectProxy) objectProxy).optString("name");//v6
                String str = ((JSONObjectProxy) objectProxy).optString("cid");//v13
                boolean rankingFlag = ((JSONObjectProxy) objectProxy).optBoolean("rankingFlag");//v14
                boolean isBook = ((JSONObjectProxy) objectProxy).optBoolean("isBook");//v15
                int columNum = ((JSONObjectProxy) objectProxy).optInt("columNum");//v16
                int fold = ((JSONObjectProxy) objectProxy).optInt("fold", -1);//v4
                JSONArrayProxy rankCids = ((JSONObjectProxy) objectProxy).getJSONArrayOrNull("rankCids");//v17
                if (fold == -1) {//if-ne v4, v7, :cond_7
                    fold = 0;
                } else {
                    fold = 1;  //v8
                }
                //:goto_1
                int k = 0;
                if (columNum == 1) {//if-ne v0, v4, :cond_18
                    k = 1;
                }
                //:goto_2
                RightTitleColumn rightTitleColumn = new RightTitleColumn((String) name, str, rankingFlag);//v3
                ((RightTitleColumn) rightTitleColumn).a(isBook);
                if ((rankCids != null) && (!TextUtils.isEmpty(((JSONArrayProxy) rankCids).toString()))) {//if-eqz v17, :cond_1   if-nez v4, :cond_1
                    int m = ((JSONArrayProxy) rankCids).toString().length();
                    ((RightTitleColumn) rightTitleColumn).a(((JSONArrayProxy) rankCids).toString().substring(1, m - 1));
                }
                //:cond_1
                localArrayList1.add(rightTitleColumn);
                JSONArrayProxy localJSONArrayProxy = ((JSONObjectProxy) objectProxy).getJSONArray("catelogyList");
                int catelogyListLength = localJSONArrayProxy.length(); //v15
                int m = 1;//v3
                //:goto_3
                for (int n = 0; n < catelogyListLength; n++) {//if-ge v4, v15, :cond_2
                    if (TextUtils.isEmpty(new Catelogy(localJSONArrayProxy.getJSONObject(n), paramInt).getImgUrl())) {//if-eqz v5, :cond_8
                        m = 0;//v3
                        break;
                    }//:cond_8
                }//:cond_2
                //:goto_4
                for (int n = 0; n < catelogyListLength; n++) {//if-ge v6, v15, :cond_13
                    Catelogy localCatelogy = new Catelogy(localJSONArrayProxy.getJSONObject(n), paramInt);//v18
                    localCatelogy.setLevel2Cid(str);
                    localCatelogy.setLevel1Cid(paramString);
                    //localObject3 = localObject1;
                    if (fold != 0 && m == 0) {//if-eqz v8, :cond_5 if-nez v3, :cond_5
                        RightListColumn v5 = null;
                        if (catelogyListLength > 6 && n >= 5 && columNum == 3) {//if-le v15, v0, :cond_4  if-lt v6, v0, :cond_4   if-ne v0, v1, :cond_4
                            if ((n % 3 == 0) || (n == 5)) {//if-eqz v17, :cond_3    if-ne v6, v0, :cond_9
                                //:cond_3
                                v5 = new RightListColumn();//v5
                                ((RightColumnBase) v5).a = 2;
                                ((RightListColumn) v5).a(localCatelogy);
                                localArrayList2.add(v5);
                            } else {//:cond_9
                                ((RightListColumn) v5).a(localCatelogy);
                            }
                        }//:cond_4
                        //:goto_5
                        if (catelogyListLength > 4 && n >= 3 && k != 0) {//if-le v15, v0, :cond_5   if-lt v6, v0, :cond_5   if-eqz v7, :cond_5
                            v5 = new RightListColumn();//v5
                            ((RightListColumn) v5).b(1);
                            ((RightColumnBase) v5).a = 2;
                            ((RightListColumn) v5).a(localCatelogy);
                            localArrayList2.add(v5);
                        }
                    }//:cond_5 464
                    if ((fold != 0) && (m == 0) && (catelogyListLength > 6) && (columNum == 3)) {//if-eqz v8, :cond_d if-nez v3, :cond_d  if-le v15, v0, :cond_d  if-ne v0, v1, :cond_d
                        if (n <= 5) {//if-gt v6, v0, :cond_6
                            RightListColumn v4 = null;
                            if (n == 5) {//if-ne v6, v0, :cond_b
                                Catelogy localObject1 = new Catelogy();
                                ((Catelogy) localObject1).setName(getFragmentString(R.string.spread_all_data));//2131233765
                                ((Catelogy) localObject1).setLevel2Cid(str);
                                ((Catelogy) localObject1).setLevel1Cid(paramString);
                                ((Catelogy) localObject1).setAction("chSpreadAllData");
                                ((RightListColumn) v4).a((Catelogy) localObject1);
                            } else if (n % 3 == 0) {//:cond_b //if-nez v17, :cond_c
                                v4 = new RightListColumn();//v4
                                ((RightColumnBase) v4).a = 2;
                                ((RightListColumn) v4).a(localCatelogy);
                                localArrayList1.add(v4);
                            } else {//:cond_c
                                ((RightListColumn) v4).a(localCatelogy);
                            }
                        }//:cond_6
                    } else if ((fold != 0) && (m == 0) && (catelogyListLength > 4) && (k != 0)) {//:cond_d   if-eqz v8, :cond_f  if-nez v3, :cond_f  if-le v15, v0, :cond_f  if-eqz v7, :cond_f
                        if (n <= 3) {//if-gt v6, v0, :cond_6
                            RightListColumn localObject2 = new RightListColumn();
                            ((RightListColumn) localObject2).b(1);
                            ((RightColumnBase) localObject2).a = 2;
                            if (n == 3) {
                                Catelogy catelogy = new Catelogy();
                                ((Catelogy) catelogy).setName(getFragmentString(R.string.en_spread_all_data));//2131231468
                                ((Catelogy) catelogy).setLevel2Cid(str);
                                ((Catelogy) catelogy).setLevel1Cid(paramString);
                                ((Catelogy) catelogy).setAction("enSpreadAllData");
                                ((RightListColumn) localObject2).a((Catelogy) catelogy);
                                localArrayList1.add(localObject2);
                            } else {
                                ((RightListColumn) localObject2).a(localCatelogy);
                                localArrayList1.add(localObject2);
                            }
                        }
                    } else if (k != 0) {//:cond_f if-eqz v7, :cond_10
                        RightListColumn localObject2 = new RightListColumn();
                        ((RightListColumn) localObject2).b(1);
                        ((RightColumnBase) localObject2).a = 2;
                        ((RightListColumn) localObject2).a(localCatelogy);
                        localArrayList1.add(localObject2);
                    } else if (n % 3 == 0) {//:cond_10    if-nez v17, :cond_12
                        RightListColumn localObject2 = new RightListColumn();
                        if (m != 0)//if-eqz v3, :cond_11
                            ((RightColumnBase) localObject2).a = 1;
                        else
                            ((RightColumnBase) localObject2).a = 2;
                        ((RightListColumn) localObject2).a(localCatelogy);
                        localArrayList1.add(localObject2);
                    } else {//:cond_12
                        ////invoke-virtual {v4, v0}, Lcom/jingdong/app/mall/category/b/c;->a(Lcom/jingdong/common/entity/Catelogy;)V
                    }
                    //:goto_6
                }//:cond_13
                if ((fold != 0) && (m == 0)) {//if-eqz v8, :cond_a     if-nez v3, :cond_a
                    if ((catelogyListLength > 6) && (columNum == 3)) {//if-le v15, v3, :cond_14    //if-ne v0, v3, :cond_14
                        Catelogy localObject2 = new Catelogy();
                        ((Catelogy) localObject2).setName(getFragmentString(R.string.pack_up_all_data));//2131232942
                        ((Catelogy) localObject2).setLevel2Cid(str);
                        ((Catelogy) localObject2).setLevel1Cid(paramString);
                        ((Catelogy) localObject2).setAction("chPackUpAllData");
                        if ((catelogyListLength - 1) % 3 == 2) {//if-ne v3, v5, :cond_16
                            RightListColumn localObject3 = new RightListColumn();
                            ((RightColumnBase) localObject3).a = 2;
                            ((RightListColumn) localObject3).a((Catelogy) localObject2);
                            localArrayList2.add(localObject3);
                        } else {//:cond_16
                            if (localArrayList2.size() > 0)
                                ((RightListColumn) localArrayList2.get(localArrayList2.size() - 1)).a((Catelogy) localObject2);
                        }
                    }//:cond_14
                    //:goto_9
                    if ((catelogyListLength > 4) && (columNum == 1)) {//if-le v15, v3, :cond_15   if-ne v0, v3, :cond_15
                        Catelogy localObject2 = new Catelogy();
                        ((Catelogy) localObject2).setName(getFragmentString(R.string.en_pack_up_all_data));//2131231467
                        ((Catelogy) localObject2).setLevel2Cid(str);
                        ((Catelogy) localObject2).setLevel1Cid(paramString);
                        ((Catelogy) localObject2).setAction("enPackUpAllData");
                        RightListColumn localObject3 = new RightListColumn();
                        ((RightColumnBase) localObject3).a = 2;
                        ((RightListColumn) localObject3).b(1);
                        ((RightListColumn) localObject3).a((Catelogy) localObject2);
                        localArrayList2.add(localObject3);
                    }//:cond_15
                    if ((this.m != null) && (localArrayList2.size() > 0)) {//if-eqz v3, :cond_a if-lez v3, :cond_a
                        this.m.put(str, localArrayList2);
                        ///goto/16 :goto_7 962
                    }
                }//:cond_a
                //:goto_7
            }catch (JSONException e){
                e.printStackTrace();
            }
        };//:cond_17
        return localArrayList1;
    }

    public static Fragment b(String paramString1, String paramString2, int paramInt)
    {
        OrdinaryL2CategoryFragment localOrdinaryL2CategoryFragment = new OrdinaryL2CategoryFragment();
        Bundle localBundle = new Bundle();
        localBundle.putCharSequence("level_first", paramString1);
        localBundle.putCharSequence("catalog_sort_event_id", paramString2);
        localBundle.putInt("current_item", paramInt);
        a(localBundle, -1);
        localOrdinaryL2CategoryFragment.setArguments(localBundle);
        return localOrdinaryL2CategoryFragment;
    }

    protected View a(LayoutInflater paramLayoutInflater)
    {
        View view = paramLayoutInflater.inflate(R.layout.category_level_2_fragment, null);//2130903251
        this.p = ((ListView)view.findViewById(R.id.listView));//2131165251
        this.p.setSelector(android.R.color.transparent);//17170445
        return view;
    }

    public final void a(_U paramu)
    {
        this.s = paramu;
    }

    public final void a(Catelogy paramCatelogy, String paramString)
    {
        JDMtaUtils.sendCommonData(this.thisActivity, "MCategory_VCategory", paramCatelogy.getcId() + "_" + this.e, "", JDNewCategoryFragment.class, this.d + "_" + (this.c + 1), paramString, "");
    }

    public final void a(String paramString1, String paramString2, int paramInt)
    {
        this.d = paramString1;
        this.e = paramString2;
        this.c = paramInt;
    }

    protected void d()
    {
        if (this.s != null)
            this.s.a(a(this.f));
    }

    public void d(final String paramString)
    {
        post(new Runnable(){
            @Override
            public void run() {

            }
        });
        final HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setListener(new HttpGroup.OnCommonListener(){//p(this, paramString, new ExceptionReporter(localHttpSetting))
            private void a() {
                OrdinaryL2CategoryFragment.this.post(new Runnable(){//t(this)
                    @Override
                    public void run() {
                        OrdinaryL2CategoryFragment.this.l.setVisibility(View.GONE);
                        OrdinaryL2CategoryFragment.this.p.setVisibility(View.GONE);
                        OrdinaryL2CategoryFragment.this.j.setVisibility(View.VISIBLE);
                        if (OrdinaryL2CategoryFragment.this.isAdded())
                            OrdinaryL2CategoryFragment.this.k.setBackgroundResource(R.drawable.y_03);
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
                OrdinaryL2CategoryFragment.this.r = paramHttpResponse.getJSONObject().getJSONArrayOrNull("data");
                if (OrdinaryL2CategoryFragment.this.r == null || OrdinaryL2CategoryFragment.this.r.length() == 0)
                {
                    new ExceptionReporter(localHttpSetting).reportHttpBusinessException(paramHttpResponse);
                    a();
                    return;
                }
                OrdinaryL2CategoryFragment.this.post(new Runnable(){//q(this)
                    @Override
                    public void run() {
                        if (OrdinaryL2CategoryFragment.this.g == null)
                        {
                            OrdinaryL2CategoryFragment.this.g = new RightListAdapter(OrdinaryL2CategoryFragment.this.thisActivity);
                            OrdinaryL2CategoryFragment.this.g.a(new IRightAdapterListener(){//r(this)
                                @Override
                                public void a() {

                                }

                                @Override
                                public void a(View paramView) {
                                    OrdinaryL2CategoryFragment.this.h = paramView;
                                }

                                @Override
                                public void a(LinearLayout paramLinearLayout, final Catelogy paramCatelogy) {
                                    paramLinearLayout.setOnClickListener(new View.OnClickListener(){//f(this.a.a.a, paramCatelogy)
                                        @Override
                                        public void onClick(View v) {
                                            OrdinaryL2CategoryFragment.this.a(paramCatelogy, v);
                                        }
                                    });
                                }
                            });
                        }
                        OrdinaryL2CategoryFragment.this.f.clear();
                        OrdinaryL2CategoryFragment.this.f = OrdinaryL2CategoryFragment.this.a( OrdinaryL2CategoryFragment.this.r, 3, paramString);
                        OrdinaryL2CategoryFragment.this.g.a(OrdinaryL2CategoryFragment.this.f);
                        OrdinaryL2CategoryFragment.this.d();
                        OrdinaryL2CategoryFragment.this.g.a(new CategoryFooter(){//s(this)
                            @Override
                            public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
                                return LayoutInflater.from(OrdinaryL2CategoryFragment.this.thisActivity).inflate(R.layout.category_footer, null);//2130903248
                            }
                        });
                        OrdinaryL2CategoryFragment.this.p.setAdapter(OrdinaryL2CategoryFragment.this.g);
                        OrdinaryL2CategoryFragment.this.p.setVisibility(View.VISIBLE);
                        OrdinaryL2CategoryFragment.this.l.setVisibility(View.GONE);
                        OrdinaryL2CategoryFragment.this.g.notifyDataSetChanged();
                    }
                });
            }
        });
        localHttpSetting.setFunctionId("newSubCatalog");
        localHttpSetting.setHost(Configuration.getPortalHost());
        localHttpSetting.putJsonParam("catelogyId", paramString);
        localHttpSetting.setLocalFileCache(true);
        localHttpSetting.setLocalFileCacheTime(86400000L);
        localHttpSetting.setBussinessId(300);
        this.thisActivity.getHttpGroupaAsynPool().add(localHttpSetting);
        a(paramString, 1);
    }

    public void onCreate(Bundle paramBundle)
    {
        setIsUseBasePV(false);
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.d = paramBundle.getString("level_first");
        this.e = paramBundle.getString("catalog_sort_event_id");
        this.c = paramBundle.getInt("current_item");
    }

    public interface _U
    {
        public void a(List<String> paramList);
    }
}
