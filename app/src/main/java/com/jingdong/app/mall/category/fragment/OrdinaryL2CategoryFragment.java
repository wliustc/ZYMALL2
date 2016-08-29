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
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.category.fragment.L2CategoryFragment;
import com.zy.common.entity.Catelogy;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Robin on 2016/8/20.
 */
public class OrdinaryL2CategoryFragment extends L2CategoryFragment {
    private JSONArrayProxy r = null;
    private _U s = null;

    private List<b> a(JSONArrayProxy paramJSONArrayPoxy, int paramInt, String paramString)
    {
        if (this.m == null)
            this.m = new HashMap();
        this.m.clear();
        ArrayList localArrayList1 = new ArrayList();
        int i2 = paramJSONArrayPoxy.length();
        int i = 0;
        if (i < i2);
        while (true)
        {
            ArrayList localArrayList2;
            Object localObject4;
            String str;
            int i3;
            int j;
            Object localObject3;
            int m;
            int i4;
            int n;
            label282: Catelogy localCatelogy;
            int k;
            Object localObject5;
            try
            {
                localArrayList2 = new ArrayList();
                localObject1 = paramJSONArrayPoxy.getJSONObject(i);
                localObject4 = ((JSONObjectProxy)localObject1).optString("name");
                str = ((JSONObjectProxy)localObject1).optString("cid");
                boolean bool1 = ((JSONObjectProxy)localObject1).optBoolean("rankingFlag");
                boolean bool2 = ((JSONObjectProxy)localObject1).optBoolean("isBook");
                i3 = ((JSONObjectProxy)localObject1).optInt("columNum");
                j = ((JSONObjectProxy)localObject1).optInt("fold", -1);
                localObject3 = ((JSONObjectProxy)localObject1).getJSONArrayOrNull("rankCids");
                if (j != -1)
                    break label1211;
                j = 0;
                break label1170;
                localObject4 = new d((String)localObject4, str, bool1);
                ((d)localObject4).a(bool2);
                if ((localObject3 == null) || (TextUtils.isEmpty(((JSONArrayProxy)localObject3).toString())))
                    continue;
                m = ((JSONArrayProxy)localObject3).toString().length();
                ((d)localObject4).a(((JSONArrayProxy)localObject3).toString().substring(1, m - 1));
                localArrayList1.add(localObject4);
                JSONArrayProxy localJSONArrayPoxy = ((JSONObjectProxy)localObject1).getJSONArray("catelogyList");
                i4 = localJSONArrayPoxy.length();
                int i1 = 1;
                n = 0;
                m = i1;
                if (n >= i4)
                    break label1182;
                if (!TextUtils.isEmpty(new Catelogy(localJSONArrayPoxy.getJSONObject(n), paramInt).getImgUrl()))
                    break label1217;
                m = 0;
                break label1182;
                if (n < i4)
                {
                    localCatelogy = new Catelogy(localJSONArrayPoxy.getJSONObject(n), paramInt);
                    localCatelogy.setLevel2Cid(str);
                    localCatelogy.setLevel1Cid(paramString);
                    localObject3 = localObject1;
                    if (j == 0)
                        continue;
                    localObject3 = localObject1;
                    if (m != 0)
                        continue;
                    localObject4 = localObject1;
                    if (i4 <= 6)
                        continue;
                    localObject4 = localObject1;
                    if (n < 5)
                        continue;
                    localObject4 = localObject1;
                    if (i3 != 3)
                        continue;
                    if ((n % 3 != 0) && (n != 5))
                        continue;
                    localObject4 = new c();
                    ((b)localObject4).a = 2;
                    ((c)localObject4).a(localCatelogy);
                    localArrayList2.add(localObject4);
                    localObject3 = localObject4;
                    if (i4 <= 4)
                        continue;
                    localObject3 = localObject4;
                    if (n < 3)
                        continue;
                    localObject3 = localObject4;
                    if (k == 0)
                        continue;
                    localObject3 = new c();
                    ((c)localObject3).b(1);
                    ((b)localObject3).a = 2;
                    ((c)localObject3).a(localCatelogy);
                    localArrayList2.add(localObject3);
                    if ((j != 0) && (m == 0) && (i4 > 6) && (i3 == 3))
                    {
                        localObject1 = localObject5;
                        if (n > 5)
                            break label1194;
                        if (n == 5)
                        {
                            localObject1 = new Catelogy();
                            ((Catelogy)localObject1).setName(getFragmentString(2131233765));
                            ((Catelogy)localObject1).setLevel2Cid(str);
                            ((Catelogy)localObject1).setLevel1Cid(paramString);
                            ((Catelogy)localObject1).setAction("chSpreadAllData");
                            localObject5.a((Catelogy)localObject1);
                            localObject1 = localObject5;
                            break label1194;
                            ((c)localObject1).a(localCatelogy);
                            localObject4 = localObject1;
                            continue;
                        }
                    }
                }
            }
            catch (JSONException localJSONException)
            {
                Object localObject1;
                localJSONException.printStackTrace();
            }
            Object localObject2;
            do
            {
                i += 1;
                break;
                if (n % 3 == 0)
                {
                    localObject2 = new c();
                    ((b)localObject2).a = 2;
                    ((c)localObject2).a(localCatelogy);
                    localArrayList1.add(localObject2);
                    break label1194;
                }
                localObject5.a(localCatelogy);
                localObject2 = localObject5;
                break label1194;
                if ((j != 0) && (m == 0) && (i4 > 4) && (k != 0))
                {
                    localObject2 = localObject5;
                    if (n > 3)
                        break label1194;
                    localObject2 = new c();
                    ((c)localObject2).b(1);
                    ((b)localObject2).a = 2;
                    if (n == 3)
                    {
                        localObject4 = new Catelogy();
                        ((Catelogy)localObject4).setName(getFragmentString(2131231468));
                        ((Catelogy)localObject4).setLevel2Cid(str);
                        ((Catelogy)localObject4).setLevel1Cid(paramString);
                        ((Catelogy)localObject4).setAction("enSpreadAllData");
                        ((c)localObject2).a((Catelogy)localObject4);
                        localArrayList1.add(localObject2);
                        break label1194;
                    }
                    ((c)localObject2).a(localCatelogy);
                    localArrayList1.add(localObject2);
                    break label1194;
                }
                if (k != 0)
                {
                    localObject2 = new c();
                    ((c)localObject2).b(1);
                    ((b)localObject2).a = 2;
                    ((c)localObject2).a(localCatelogy);
                    localArrayList1.add(localObject2);
                    break label1194;
                }
                if (n % 3 == 0)
                {
                    localObject2 = new c();
                    if (m != 0);
                    for (((b)localObject2).a = 1; ; ((b)localObject2).a = 2)
                    {
                        ((c)localObject2).a(localCatelogy);
                        localArrayList1.add(localObject2);
                        break;
                    }
                }
                localObject5.a(localCatelogy);
                localObject2 = localObject5;
                break label1194;
            }
            while ((j == 0) || (m != 0));
            if ((i4 > 6) && (i3 == 3))
            {
                localObject2 = new Catelogy();
                ((Catelogy)localObject2).setName(getFragmentString(2131232942));
                ((Catelogy)localObject2).setLevel2Cid(str);
                ((Catelogy)localObject2).setLevel1Cid(paramString);
                ((Catelogy)localObject2).setAction("chPackUpAllData");
                if ((i4 - 1) % 3 != 2)
                    break label1130;
                localObject3 = new c();
                ((b)localObject3).a = 2;
                ((c)localObject3).a((Catelogy)localObject2);
                localArrayList2.add(localObject3);
            }
            while (true)
            {
                if ((i4 > 4) && (i3 == 1))
                {
                    localObject2 = new Catelogy();
                    ((Catelogy)localObject2).setName(getFragmentString(2131231467));
                    ((Catelogy)localObject2).setLevel2Cid(str);
                    ((Catelogy)localObject2).setLevel1Cid(paramString);
                    ((Catelogy)localObject2).setAction("enPackUpAllData");
                    localObject3 = new c();
                    ((b)localObject3).a = 2;
                    ((c)localObject3).b(1);
                    ((c)localObject3).a((Catelogy)localObject2);
                    localArrayList2.add(localObject3);
                }
                if ((this.m == null) || (localArrayList2.size() <= 0))
                    break;
                this.m.put(str, localArrayList2);
                break;
                label1130: if (localArrayList2.size() <= 0)
                    continue;
                ((c)localArrayList2.get(localArrayList2.size() - 1)).a((Catelogy)localObject2);
            }
            return localArrayList1;
            label1170: label1182: label1194: label1211: label1215:
            while (true)
            {
                k = 0;
                break;
                while (true)
                {
                    if (i3 != 1)
                        break label1215;
                    k = 1;
                    break;
                    localObject2 = null;
                    localObject5 = null;
                    n = 0;
                    break label282;
                    n += 1;
                    localObject5 = localObject2;
                    localObject2 = localObject3;
                    break label282;
                    j = 1;
                }
            }
            label1217: n += 1;
        }
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
        paramLayoutInflater = paramLayoutInflater.inflate(2130903251, null);
        this.p = ((ListView)paramLayoutInflater.findViewById(2131165251));
        this.p.setSelector(17170445);
        return paramLayoutInflater;
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

    public void d(String paramString)
    {
        post(new o(this));
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setListener(new p(this, paramString, new ExceptionReporter(localHttpSetting)));
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
