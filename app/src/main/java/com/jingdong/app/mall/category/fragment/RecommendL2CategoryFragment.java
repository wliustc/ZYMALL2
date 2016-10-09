package com.jingdong.app.mall.category.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.R;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.b.RightListColumn;
import com.zy.app.mall.category.b.RightTitleColumn;
import com.zy.app.mall.category.fragment.L2CategoryFragment;
import com.zy.common.entity.Catelogy;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/8/20.
 */
public class RecommendL2CategoryFragment extends L2CategoryFragment {


    private static String s;
    private static String t;
    private String r = "bp.category";
    private List<RightColumnBase> u = new ArrayList();
    private boolean v = false;
    private _AF w = null;

    private static int a(JSONArrayProxy paramJSONArrayPoxy)
    {
        int v1 = 0;
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() > 0)) {//if-eqz p0, :cond_1
            int i = 0;

            for (int j = 0; j < paramJSONArrayPoxy.length(); j++){//if-ge v0, v2, :cond_2
                try
                {
                    Catelogy localCatelogy = new Catelogy(paramJSONArrayPoxy.getJSONObject(j), 4);
                    //v1 = i;
                    if (localCatelogy.getSensitiveFlag() == 0)
                    {//if-nez v2, :cond_0
                       // v1 = i;
                        if (!TextUtils.isEmpty(localCatelogy.getImgUrl()))
                        {//if-nez v2, :cond_0
                            int m = localCatelogy.getColumNum();
                            if (m != 1)//if-eq v2, v3, :cond_0
                                v1++;
                        }
                    }
                }
                catch (JSONException localJSONException)
                {
                        localJSONException.printStackTrace();
                }
            }
        }
        return v1;
    }

    private static int b(JSONArrayProxy paramJSONArrayPoxy)
    {
        int k = 0;
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() > 0)) {//if-eqz p0, :cond_1   if-lez v1, :cond_1
            for (int j = 0; j < paramJSONArrayPoxy.length(); j++) {//if-ge v0, v2, :cond_2
                try
                {
                    Catelogy localCatelogy = new Catelogy(paramJSONArrayPoxy.getJSONObject(j), 4);
                    if (localCatelogy.getSensitiveFlag() == 0)
                    {
                        if (TextUtils.isEmpty(localCatelogy.getImgUrl()))
                        {//if-eqz v2, :cond_0
                            int m = localCatelogy.getColumNum();
                            if (m != 1)
                                k++;
                        }
                    }
                }
                catch (JSONException localJSONException)
                {
                    localJSONException.printStackTrace();
                }
            }
        }
        return k;
    }

    public static Fragment a(String uid, String guid)
    {
        RecommendL2CategoryFragment localRecommendL2CategoryFragment = new RecommendL2CategoryFragment();
        Bundle localBundle = new Bundle();
        s = uid;
        t = guid;
        localBundle.putCharSequence("uid", uid);
        localBundle.putCharSequence("guid", guid);
        a(localBundle, -1);
        localRecommendL2CategoryFragment.setArguments(localBundle);
        return localRecommendL2CategoryFragment;
    }

    // ERROR //
    private List<RightColumnBase> a(JSONArrayProxy paramJSONArrayPoxy, int paramInt)
    {
        ArrayList v10= new ArrayList();
        if(paramJSONArrayPoxy != null && paramJSONArrayPoxy.length() > 0){//if-eqz p1, :cond_8  if-lez v2, :cond_8
            //:goto_0
            for(int v2 = 0; v2 < paramJSONArrayPoxy.length(); v2++){//if-ge v2, jsonObjectProxy, :cond_8
                JSONObjectProxy jsonObjectProxy = paramJSONArrayPoxy.getJSONObjectOrNull(v2);
                if (jsonObjectProxy != null) {//if-eqz jsonObjectProxy, :cond_7
                    JSONArrayProxy v11 = jsonObjectProxy.getJSONArrayOrNull("catelogyList");
                    String name = jsonObjectProxy.optString("name");
                    String cid = jsonObjectProxy.optString("cid");
                    boolean rankingFlag = jsonObjectProxy.optBoolean("rankingFlag");
                    boolean isBook = jsonObjectProxy.optBoolean("isBook");
                    RightTitleColumn rightTitleColumn = new RightTitleColumn(name,cid,rankingFlag);
                    rightTitleColumn.a(isBook);
                    JSONArrayProxy rankCids = jsonObjectProxy.getJSONArrayOrNull("rankCids");
                    if (rankCids != null) {//if-eqz v3, :cond_0
                        String v4 = rankCids.toString();
                        //String v3 = v4.substring(1, v4.length() - 1);
                        rightTitleColumn.a(v4.substring(1, v4.length() - 1));
                    }//:cond_0
                    v10.add(rightTitleColumn);
                    if(v11 != null && v11.length() > 0){//if-eqz v11, :cond_7   if-lez v3, :cond_7
                        ArrayList v13 = new ArrayList();
                        ArrayList v14 = new ArrayList();
                        ArrayList v15 = new ArrayList();

                        RightListColumn v7 = null;
                        RightListColumn v6 = null;
                        int v5 = 0;
                        int v4 = 0;
                        int v3 = 0;
                        int v16 = RecommendL2CategoryFragment.a(v11);
                        int v17 = RecommendL2CategoryFragment.b(v11);
                        //:goto_1
                        for(int v8 = 0; v8< v11.length(); v8++){// if-ge v8, v9, :cond_6
                            try {
                                JSONObjectProxy jsonObject = v11.getJSONObject(v8);
                                Catelogy v0 = new Catelogy(jsonObject, paramInt);
                                v0.setLevel2Cid(cid);
                                if(v0.getSensitiveFlag() == 1){//if-ne v9, v0, :cond_2
                                    RightListColumn rightListColumn = new RightListColumn();
                                    rightListColumn.a = 2;
                                    rightListColumn.b(1);
                                    rightListColumn.a(v0);
                                    v15.add(rightListColumn);
                                    v3++;
                                    v0.setNum(v16 + v17 + v3);
                                }else {//:cond_2;
                                    if(!TextUtils.isEmpty(v0.getImgUrl())){//if-nez v9, :cond_4
                                        if(v5 % 3 == 0){//if-nez v9, :cond_3
                                            RightListColumn rightListColumn = new RightListColumn();
                                            rightListColumn.a = 1;
                                            rightListColumn.a(v0);
                                            v13.add(rightListColumn);
                                            v7 = rightListColumn;
                                        }else {// :cond_3
                                            v7.a(v0);
                                        }
                                        v5++;
                                        v0.setNum(v5);
                                    }else {
                                        if (v4 % 3 == 0) {//:cond_4 if-nez v9, :cond_5
                                            RightListColumn rightListColumn = new RightListColumn();
                                            rightListColumn.a = 2;
                                            rightListColumn.a(v0);
                                            v14.add(rightListColumn);
                                            v6 = rightListColumn;
                                        } else {//:cond_5
                                            v6.a(v0);
                                        }
                                        v4++;
                                        v0.setNum(v16+v4);
                                    }
                                }
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                        }//:cond_6
                        v10.addAll(v13);
                        v10.addAll(v14);
                        v10.addAll(v15);
                    }
                }// :cond_7
            }
        }//:cond_8
        return v10;
    }



    protected final View a(LayoutInflater layoutInflater)
    {
        View inflate = layoutInflater.inflate(R.layout.category_level_2_fragment, null);//2130903251
        this.p = ((ListView)inflate.findViewById(R.id.listView));//2131165251
        this.p.setSelector(android.R.color.transparent);//17170445
        return inflate;
    }

    public final void a(_AF paramaf)
    {
        this.w = paramaf;
    }

    public final void a(Catelogy paramCatelogy, String paramString)
    {
        if (paramCatelogy.getLevel2Cid().equals("99994444"))
            JDMtaUtils.sendCommonData(this.thisActivity, "CateCustomize_Scategory_Favor", paramCatelogy.getLevel3Cid() + "_" + paramCatelogy.getNum(), "", JDNewCategoryFragment.class, "", paramString, "");
        else if (paramCatelogy.getLevel2Cid().equals("44449999"))
            JDMtaUtils.sendCommonData(this.thisActivity, "CateCustomize_Scategory_Hot", paramCatelogy.getLevel3Cid(), "", JDNewCategoryFragment.class, "", paramString, "");
        else if(paramCatelogy.getLevel2Cid().equals("99999999"));
            JDMtaUtils.sendCommonData(this.thisActivity, "CateCustomize_Scategory_Special", paramCatelogy.getAction(), "", JDNewCategoryFragment.class, "", paramString, "");
    }

    public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
        a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, this.i);
    }

    public final void a(final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4, final boolean paramBoolean5)
    {
        post(new Runnable(){//v(this)
            @Override
            public void run() {
                if (RecommendL2CategoryFragment.this.isAdded())
                    RecommendL2CategoryFragment.this.l.setVisibility(View.VISIBLE);
            }
        });
        final HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setListener(new HttpGroup.OnCommonListener(){//w(this, new ExceptionReporter(localHttpSetting), paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5)
            private ExceptionReporter b = new ExceptionReporter(localHttpSetting);
            private boolean c = paramBoolean1;
            private boolean d = paramBoolean2;
            private boolean e = paramBoolean3;
            private boolean f = paramBoolean4;
            private boolean g = paramBoolean5;
            @Override
            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {
                RecommendL2CategoryFragment.this.post(new Runnable(){//x(this)
                    @Override
                    public void run() {
                        if ((RecommendL2CategoryFragment.this.isAdded()) && (RecommendL2CategoryFragment.this.h != null))
                            RecommendL2CategoryFragment.this.h.setEnabled(false);
                    }
                });
            }


            @Override
            public void onError(HttpGroup.HttpError paramHttpError) {
                RecommendL2CategoryFragment.this.post(new Runnable(){//y(this)
                    @Override
                    public void run() {
                        if ((RecommendL2CategoryFragment.this.isAdded()) && (RecommendL2CategoryFragment.this.h != null))
                            RecommendL2CategoryFragment.this.h.setEnabled(true);
                    }
                });
                if (RecommendL2CategoryFragment.this.w != null)
                    RecommendL2CategoryFragment.this.w.a(this.d, RecommendL2CategoryFragment.this.v, RecommendL2CategoryFragment.a(RecommendL2CategoryFragment.this.u), this.g);
                RecommendL2CategoryFragment.this.post(new Runnable(){//z(this)
                    @Override
                    public void run() {
                        if (RecommendL2CategoryFragment.this.isAdded())
                            RecommendL2CategoryFragment.this.l.setVisibility(8);
                    }
                });
            }

            @Override
            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                if (!this.f)
                {
                    if ((this.c) || (!this.g))
                        RecommendL2CategoryFragment.this.a(false, false, false, true, true);
                    RecommendL2CategoryFragment.this.post(new Runnable(){// aa(this)
                        @Override
                        public void run() {
                            if ((RecommendL2CategoryFragment.this.isAdded()) && (RecommendL2CategoryFragment.this.h != null))
                                RecommendL2CategoryFragment.this.h.setEnabled(true);
                        }
                    });
                    JSONArrayProxy data = paramHttpResponse.getJSONObject().getJSONArrayOrNull("data");
                    if (((data == null) || (data.length() <= 0)) && (this.d))
                    {
                        if (RecommendL2CategoryFragment.this.w != null)
                            RecommendL2CategoryFragment.this.w.a(this.d, RecommendL2CategoryFragment.this.v, RecommendL2CategoryFragment.a(RecommendL2CategoryFragment.this.u), this.g);
                    }else{
                        RecommendL2CategoryFragment.this.u = RecommendL2CategoryFragment.this.a(data, 4);
                        if (RecommendL2CategoryFragment.this.u.size() == 0)//if-nez v0, :cond_8
                            RecommendL2CategoryFragment.this.v = false;
                        else
                            RecommendL2CategoryFragment.this.v = true;
                        if ((this.c) || (this.e))
                            RecommendL2CategoryFragment.this.post(new Runnable(){//ab(this)
                                @Override
                                public void run() {
                                    if (RecommendL2CategoryFragment.this.g == null)
                                    {
                                        RecommendL2CategoryFragment.this.g = new e(RecommendL2CategoryFragment.this.thisActivity);
                                        RecommendL2CategoryFragment.this.g.a(new ac(this));
                                    }
                                    RecommendL2CategoryFragment.this.f.clear();
                                    RecommendL2CategoryFragment.this.f.addAll(RecommendL2CategoryFragment.c(this.a.a));
                                    RecommendL2CategoryFragment.this.g.a(RecommendL2CategoryFragment.this.f);
                                    RecommendL2CategoryFragment.this.g.a(new ad(this));
                                    RecommendL2CategoryFragment.this.p.setAdapter(RecommendL2CategoryFragment.this.g);
                                    RecommendL2CategoryFragment.this.g.notifyDataSetChanged();
                                }
                            });
                        if (RecommendL2CategoryFragment.this.w != null)
                            RecommendL2CategoryFragment.this.w.a(this.d, RecommendL2CategoryFragment.this.v, RecommendL2CategoryFragment.a(RecommendL2CategoryFragment.this.u), this.g);
                        RecommendL2CategoryFragment.this.post(new Runnable(){//ae(this)
                            @Override
                            public void run() {
                                if (RecommendL2CategoryFragment.this.isAdded())
                                    RecommendL2CategoryFragment.this.l.setVisibility(View.GONE);
                            }
                        });
                    }

                }
            }
        });
        localHttpSetting.setFunctionId("commonCatalogs");
        localHttpSetting.setHost(Configuration.getPortalHost());
        String str = "0";
        if (paramBoolean1)
            str = "1";
        localHttpSetting.putJsonParam("clear", str);
        localHttpSetting.putJsonParam("method", this.r);
        localHttpSetting.putJsonParam("uid", s);
        localHttpSetting.putJsonParam("guid", t);
        localHttpSetting.putJsonParam("token", Md5Encrypt.md5(s + t + "81395f50b94bb4891a4ce4ffb6ccf64b"));
        if (paramBoolean1){//if-nez p1, :cond_1
            if (paramBoolean5) {//if-eqz p5, :cond_3
                localHttpSetting.setLocalFileCache(true);
                localHttpSetting.setLocalFileCacheTime(3600000L);
                if (paramBoolean4)//if-eqz p4, :cond_2
                    localHttpSetting.setCacheMode(4);
                else
                    localHttpSetting.setCacheMode(0);
            }else
                a(true);
        }else{
            localHttpSetting.setBussinessId(300);
            this.thisActivity.getHttpGroupaAsynPool().add(localHttpSetting);
            a("-1", 1);
        }
    }

    public final void b(String paramString1, String paramString2)
    {
        s = paramString1;
        t = paramString2;
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        getArguments();
        this.c = -1;
    }

    public interface _AF
    {
        public abstract void a(boolean paramBoolean1, boolean paramBoolean2, List<String> paramList, boolean paramBoolean3);
    }
}
