package com.jingdong.common.ranking;

import android.content.Context;
import android.content.Intent;

import com.jingdong.common.ranking.activity.RankingListActivity;
import com.zy.app.mall.utils.MyActivity;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/10/11.
 */
public class RankingController {
    public static void a(Context paramContext, String paramString)
    {
        if (Log.D)
            Log.d("RankingController", "RankHomeActivity入口参数from: " + paramString);
        Intent localIntent = new Intent(paramContext, RankHomeActivity.class);
        localIntent.putExtra("rank_big_entry", paramString);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public static void a(Context paramContext, String paramString1, String paramString2, RankAddress paramRankAddress, String paramString3, String paramString4, String paramString5, String paramString6)
    {
        Intent localIntent = new Intent(paramContext, RankingListActivity.class);
        localIntent.putExtra("rank_big_entry", paramString4);
        localIntent.putExtra("cateId", paramString1);
        localIntent.putExtra("rank_id", "rank3002");
        localIntent.putExtra("skuId", paramString2);
        localIntent.putExtra("skuIds", paramString3);
        localIntent.putExtra("rank_address", paramRankAddress);
        localIntent.putExtra("floor_number", paramString6);
        localIntent.putExtra("test_type", paramString5);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
        if (Log.D)
            Log.d("RankingController", "RankingListActivity入口参数---------->\nskuId: " + paramString1 + "\ncateId: " + paramString2 + "\ncateList: " + paramString3 + "\ncateName: " + paramString4 + "\nfrom: " + paramString5 + "\nrankId: " + paramString6);
        Intent localIntent = new Intent(paramContext, RankingListActivity.class);
        localIntent.putExtra("rank_small_entry", paramString5);
        localIntent.putExtra("skuId", paramString1);
        localIntent.putExtra("cateId", paramString2);
        localIntent.putExtra("rank_cate_name", paramString4);
        localIntent.putExtra("cate2Id", paramString3);
        localIntent.putExtra("rank_id", paramString6);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public static void a(Context paramContext, String paramString1, String paramString2, ArrayList<RankList.CateListEntity> paramArrayList, RankAddress paramRankAddress, String paramString3, String paramString4, String paramString5)
    {
        Intent localIntent = new Intent(paramContext, RankingListActivity.class);
        localIntent.putExtra("shop_id", paramString1);
        localIntent.putExtra("rank_id", "rank3006");
        localIntent.putExtra("rank_big_entry", paramString3);
        localIntent.putExtra("cateId", paramString2);
        localIntent.putParcelableArrayListExtra("cate_list", paramArrayList);
        localIntent.putExtra("rank_address", paramRankAddress);
        localIntent.putExtra("test_type", paramString4);
        localIntent.putExtra("floor_number", paramString5);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public static void a(Context paramContext, String paramString1, ArrayList<RankList.CateListEntity> paramArrayList, RankAddress paramRankAddress, String paramString2, String paramString3, String paramString4)
    {
        Intent localIntent = new Intent(paramContext, RankingListActivity.class);
        localIntent.putExtra("rank_big_entry", paramString2);
        localIntent.putExtra("cateId", paramString1);
        localIntent.putExtra("rank_id", "rank3001");
        localIntent.putParcelableArrayListExtra("cate_list", paramArrayList);
        localIntent.putExtra("rank_address", paramRankAddress);
        localIntent.putExtra("test_type", paramString3);
        localIntent.putExtra("floor_number", paramString4);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public static void a(MyActivity paramMyActivity, JSONObject paramJSONObject, HttpGroup.OnCommonListener paramOnCommonListener)
    {
        a("getJdRankHome", paramMyActivity, paramJSONObject, paramOnCommonListener);
    }

    public static void a(MyActivity paramMyActivity, JSONObject paramJSONObject, HttpGroup.OnCommonListener paramOnCommonListener, boolean paramBoolean)
    {
        int i = 0;
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        if (Log.D)
            Log.d("RankingController", "host = " + Configuration.getNgwHost());
        localHttpSetting.setHost(Configuration.getNgwHost());
        localHttpSetting.setFunctionId("getJdRankInfo");
        localHttpSetting.setJsonParams(paramJSONObject);
        if (LoginUserBase.hasLogin())
            localHttpSetting.setUseCookies(true);
        while (true)
        {
            localHttpSetting.setNotifyUser(false);
            localHttpSetting.setReadTimeout(15000);
            localHttpSetting.setAttempts(3);
            if (paramBoolean)
                i = 1;
            localHttpSetting.setEffect(i);
            localHttpSetting.setUseCookies(true);
            localHttpSetting.setListener(paramOnCommonListener);
            paramMyActivity.getHttpGroupaAsynPool().add(localHttpSetting);
            return;
            localHttpSetting.setUseCookies(false);
        }
    }

    private static void a(String paramString, MyActivity paramMyActivity, JSONObject paramJSONObject, HttpGroup.OnCommonListener paramOnCommonListener)
    {
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        if (Log.D)
            Log.d("RankingController", "host = " + Configuration.getNgwHost() + "request times:" + b.a);
        localHttpSetting.setHost(Configuration.getNgwHost());
        localHttpSetting.setFunctionId(paramString);
        localHttpSetting.setJsonParams(paramJSONObject);
        if (LoginUserBase.hasLogin())
            localHttpSetting.setUseCookies(true);
        while (true)
        {
            localHttpSetting.setNotifyUser(false);
            localHttpSetting.setReadTimeout(15000);
            localHttpSetting.setAttempts(3);
            localHttpSetting.setEffect(1);
            localHttpSetting.setUseCookies(true);
            localHttpSetting.setListener(paramOnCommonListener);
            paramMyActivity.getHttpGroupaAsynPool().add(localHttpSetting);
            return;
            localHttpSetting.setUseCookies(false);
        }
    }

    public static void b(Context paramContext, String paramString)
    {
        Intent localIntent = new Intent(paramContext, ProductListActivity.class);
        localIntent.putExtra("keyWord", paramString);
        localIntent.putExtra("sortKey", -2);
        paramContext.startActivity(localIntent);
    }

    public static void b(Context paramContext, String paramString1, String paramString2, RankAddress paramRankAddress, String paramString3, String paramString4, String paramString5, String paramString6)
    {
        Intent localIntent = new Intent(paramContext, RankingListActivity.class);
        localIntent.putExtra("rank_big_entry", paramString4);
        localIntent.putExtra("rank_id", "rank3004");
        localIntent.putExtra("cateId", paramString1);
        localIntent.putExtra("skuId", paramString2);
        localIntent.putExtra("skuIds", paramString3);
        localIntent.putExtra("rank_address", paramRankAddress);
        localIntent.putExtra("test_type", paramString5);
        localIntent.putExtra("floor_number", paramString6);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public static void b(MyActivity paramMyActivity, JSONObject paramJSONObject, HttpGroup.OnCommonListener paramOnCommonListener)
    {
        a("getJdRankList", paramMyActivity, paramJSONObject, paramOnCommonListener);
    }

    public static void c(Context paramContext, String paramString1, String paramString2, RankAddress paramRankAddress, String paramString3, String paramString4, String paramString5, String paramString6)
    {
        Intent localIntent = new Intent(paramContext, RankingListActivity.class);
        localIntent.putExtra("rank_id", "rank3005");
        localIntent.putExtra("rank_big_entry", paramString4);
        localIntent.putExtra("cateId", paramString1);
        localIntent.putExtra("key_word", paramString2);
        localIntent.putExtra("key_words", paramString3);
        localIntent.putExtra("rank_address", paramRankAddress);
        localIntent.putExtra("test_type", paramString5);
        localIntent.putExtra("floor_number", paramString6);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public static void c(MyActivity paramMyActivity, JSONObject paramJSONObject, HttpGroup.OnCommonListener paramOnCommonListener)
    {
        a("getJdRankArea", paramMyActivity, paramJSONObject, paramOnCommonListener);
    }
}
