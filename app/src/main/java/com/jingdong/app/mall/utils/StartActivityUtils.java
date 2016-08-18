package com.jingdong.app.mall.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.jingdong.app.mall.product.ProductDetailActivity;
import com.jingdong.common.BaseActivity;
import com.jingdong.common.jdtravel.FlightSearchActivity;
import com.zy.app.mall.utils.MyActivity;
import com.zy.common.entity.SourceEntity;

/**
 * Created by Robin on 2016/6/21.
 */
public class StartActivityUtils {
    public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
    {
        if ((paramActivity == null) || (paramIntent == null))
            return;
        if ((paramActivity.getParent() != null) && ((paramActivity instanceof MyActivity)))
        {
            paramIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
            ((BaseActivity)paramActivity).startActivityInFrame(paramIntent);
            return;
        }else
            paramActivity.startActivity(paramIntent);
    }

    public static void a(Activity paramActivity, Bundle paramBundle)
    {
        if ((paramActivity == null) || ((paramActivity instanceof FlightSearchActivity)))
            return;
        Intent localIntent = new Intent(paramActivity.getApplicationContext(), FlightSearchActivity.class);
        localIntent.putExtra("com.360buy:clearTopFlag", true);
        if (paramBundle != null)
            localIntent.putExtras(paramBundle);
        paramActivity.startActivity(localIntent);
    }

    public static void a(Activity paramActivity, Bundle paramBundle, int paramInt, SourceEntity paramSourceEntity)
    {
        Intent localIntent = new Intent(paramActivity, ProductDetailActivity.class);
        localIntent.putExtra("fromCart", true);
        localIntent.putExtras(paramBundle);
        localIntent.putExtra("source", paramSourceEntity);
        paramActivity.startActivityForResult(localIntent, paramInt);
    }

    public static void a(Activity paramActivity, Bundle paramBundle, SourceEntity paramSourceEntity)
    {
        if ((paramActivity == null) || (paramBundle == null))
            return;
        Intent localIntent = new Intent(paramActivity, ProductDetailActivity.class);
        localIntent.putExtras(paramBundle);
        localIntent.putExtra("source", paramSourceEntity);
        paramActivity.startActivity(localIntent);
    }


//    public static void a(Activity paramActivity, Bundle paramBundle, String paramString)
//    {
//        String str = null;
//        if (paramBundle != null)
//            str = paramBundle.getString("orderId");
//        Log.d("StartActivityUtils", "startAirOderDetailActivity orderId = " + str);
//        paramBundle = new Intent();
//        paramBundle.addFlags(268435456);
//        paramBundle.putExtra("pluginname", "flightDetail");
//        paramBundle.putExtra("orderId", str);
//        paramBundle.putExtra("type", paramString);
//        paramBundle.putExtra("pauseBackRefresh", "yes");
//        StartHybridActivityUtils.startHybridActivity(paramActivity.getApplicationContext(), paramBundle);
//    }
//
    public static void a(Activity paramActivity, Long paramLong, String paramString, int paramInt, SourceEntity paramSourceEntity)
    {
        if ((paramActivity == null) || (paramLong == null))
            return;
        Bundle localBundle = new Bundle();
        localBundle.putLong("id", paramLong.longValue());
        if (!TextUtils.isEmpty(paramString))
            localBundle.putString("title", paramString);
        a(paramActivity, localBundle, paramInt, paramSourceEntity);
    }

    public static void a(Activity paramActivity, Long paramLong, String paramString, SourceEntity paramSourceEntity)
    {
        if ((paramActivity == null) || (paramLong == null))
            return;
        Bundle localBundle = new Bundle();
        localBundle.putLong("id", paramLong.longValue());
        if (!TextUtils.isEmpty(paramString))
            localBundle.putString("title", paramString);
        a(paramActivity, localBundle, paramSourceEntity);
    }
//
//    public static void a(Activity paramActivity, Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, SourceEntity paramSourceEntity)
//    {
//        if ((paramActivity == null) || (paramLong == null))
//            return;
//        Bundle localBundle = new Bundle();
//        localBundle.putLong("id", paramLong.longValue());
//        if (!TextUtils.isEmpty(paramString1))
//            localBundle.putString("title", paramString1);
//        if (!TextUtils.isEmpty(paramString2))
//            localBundle.putString("image", paramString2);
//        if (!TextUtils.isEmpty(paramString3))
//            localBundle.putString("price", paramString3);
//        if (!TextUtils.isEmpty(paramString4))
//            localBundle.putString("targetUrl", paramString4);
//        a(paramActivity, localBundle, paramSourceEntity);
//    }
//
//    public static void a(Activity paramActivity, String paramString, SourceEntity paramSourceEntity)
//    {
//        if (paramActivity == null)
//            return;
//        Intent localIntent = new Intent(paramActivity, JshopSearchListActivity.class);
//        localIntent.putExtra("keyword", paramString);
//        localIntent.putExtra("source", paramSourceEntity);
//        a(paramActivity, localIntent, false);
//    }
//
//    public static void a(MyActivity paramMyActivity)
//    {
//        if (paramMyActivity == null)
//            return;
//        CommonUtil.getInstance().backToHomePage(paramMyActivity);
//    }
//
//    public static void a(MyActivity paramMyActivity, int paramInt)
//    {
//        if (paramMyActivity == null);
//        Intent localIntent;
//        do
//        {
//            return;
//            localIntent = d(paramMyActivity, 102);
//        }
//        while (localIntent == null);
//        paramMyActivity.startActivityForResultNoException(localIntent, 1000);
//    }
//
//    public static void a(MyActivity paramMyActivity, CompleteOrderContinue paramCompleteOrderContinue, int paramInt)
//    {
//        if ((paramMyActivity == null) || (paramCompleteOrderContinue == null))
//            return;
//        Bundle localBundle = new Bundle();
//        localBundle.putString("subDes", paramCompleteOrderContinue.getSubType());
//        localBundle.putString("activityID", paramCompleteOrderContinue.getJumpData());
//        if (!LoginUser.hasLogin())
//        {
//            paramCompleteOrderContinue = new br(paramMyActivity, localBundle, 1000);
//            LoginUser.getInstance().executeLoginRunnable(paramMyActivity, paramCompleteOrderContinue);
//            return;
//        }
//        DeepLinkStoryHelper.startStoryMainForResult(paramMyActivity, localBundle, 1000);
//    }
//
//    public static void a(BaseActivity paramBaseActivity)
//    {
//        if ((paramBaseActivity == null) || ((paramBaseActivity instanceof PhoneChargeActivity)));
//        Intent localIntent;
//        do
//        {
//            return;
//            localIntent = d(paramBaseActivity, 8);
//        }
//        while (localIntent == null);
//        paramBaseActivity.startActivityInFrameWithNoNavigation(localIntent);
//    }
//
//    public static void a(BaseActivity paramBaseActivity, int paramInt)
//    {
//        if ((paramBaseActivity == null) || ((paramBaseActivity instanceof PhoneChargeActivity)));
//        Intent localIntent;
//        do
//        {
//            return;
//            localIntent = d(paramBaseActivity, 8);
//        }
//        while (localIntent == null);
//        paramBaseActivity.startActivityForResultNoException(localIntent, 1000);
//    }
//
//    public static void a(BaseActivity paramBaseActivity, String paramString)
//    {
//        if (paramBaseActivity == null)
//            return;
//        Intent localIntent = new Intent(paramBaseActivity.getApplicationContext(), PhoneChargeActivity.class);
//        localIntent.setFlags(335544320);
//        localIntent.putExtra("com.360buy:clearTopFlag", true);
//        if ("tap_flow".equals(paramString))
//            localIntent.putExtra("jumpType", 3);
//        while (true)
//        {
//            paramBaseActivity.startActivityInFrameWithNoNavigation(localIntent);
//            return;
//            if ("tap_qq".equals(paramString))
//            {
//                localIntent.putExtra("jumpType", 0);
//                continue;
//            }
//            if ("tap_game".equals(paramString))
//            {
//                localIntent.putExtra("jumpType", 1);
//                continue;
//            }
//            localIntent.putExtra("jumpType", 2);
//        }
//    }
//
//    public static void a(String paramString, boolean paramBoolean)
//    {
//        BaseActivity localBaseActivity = MyApplication.getInstance().getCurrentMyActivity();
//        if (localBaseActivity == null)
//            return;
//        paramString = new bq(localBaseActivity, paramString, paramBoolean);
//        LoginUser.getInstance().executeLoginRunnable(localBaseActivity, paramString);
//    }
//
//    public static void b(Activity paramActivity, Bundle paramBundle, SourceEntity paramSourceEntity)
//    {
//        if ((paramActivity == null) || (paramBundle == null))
//            return;
//        Intent localIntent = new Intent(paramActivity, JshopMainShopActivity.class);
//        localIntent.putExtras(paramBundle);
//        localIntent.putExtra("source", paramSourceEntity);
//        paramActivity.startActivity(localIntent);
//    }
//
//    public static void b(BaseActivity paramBaseActivity)
//    {
//        if ((paramBaseActivity == null) || ((paramBaseActivity instanceof MovieActivity)))
//            return;
//        Intent localIntent = new Intent(paramBaseActivity.getApplicationContext(), MovieActivity.class);
//        localIntent.putExtra("com.360buy:clearTopFlag", true);
//        paramBaseActivity.startActivityInFrameWithNoNavigation(localIntent);
//    }
//
//    public static void b(BaseActivity paramBaseActivity, int paramInt)
//    {
//        if (paramBaseActivity == null);
//        Intent localIntent;
//        do
//        {
//            return;
//            localIntent = d(paramBaseActivity, 7);
//        }
//        while (localIntent == null);
//        paramBaseActivity.startActivityForResultNoException(localIntent, 1000);
//    }
//
//    public static void c(BaseActivity paramBaseActivity)
//    {
//        if (paramBaseActivity == null);
//        Intent localIntent;
//        do
//        {
//            return;
//            localIntent = d(paramBaseActivity, 7);
//        }
//        while (localIntent == null);
//        paramBaseActivity.startActivityInFrame(localIntent);
//    }
//
//    public static void c(BaseActivity paramBaseActivity, int paramInt)
//    {
//        if (paramBaseActivity == null);
//        Intent localIntent;
//        do
//        {
//            return;
//            localIntent = d(paramBaseActivity, 1);
//        }
//        while (localIntent == null);
//        paramBaseActivity.startActivityForResultNoException(localIntent, 1000);
//    }
//
//    private static Intent d(BaseActivity paramBaseActivity, int paramInt)
//    {
//        if (paramBaseActivity == null)
//            return null;
//        switch (paramInt)
//        {
//            default:
//                return null;
//            case 1:
//                paramBaseActivity = new Intent(paramBaseActivity, MyGoodsOrderListActivity.class);
//                paramBaseActivity.putExtra("isOtherOrder", false);
//                paramBaseActivity.putExtra("com.360buy:navigationDisplayFlag", -1);
//                return paramBaseActivity;
//            case 7:
//                paramBaseActivity = new Intent(paramBaseActivity, MiaoShaActivity.class);
//                paramBaseActivity.putExtra("source", new SourceEntity("indexMiaoShaArea", ""));
//                paramBaseActivity.putExtra("com.360buy:navigationDisplayFlag", -1);
//                paramBaseActivity.putExtra("com.360buy:clearHistoryFlag", true);
//                return paramBaseActivity;
//            case 8:
//                paramBaseActivity = new Intent(paramBaseActivity, PhoneChargeActivity.class);
//                paramBaseActivity.putExtra("com.360buy:clearTopFlag", true);
//                return paramBaseActivity;
//            case 102:
//        }
//        return new Intent(paramBaseActivity, CouponMainActivity.class);
//    }
//
//    public static void d(BaseActivity paramBaseActivity)
//    {
//        if (paramBaseActivity == null);
//        Intent localIntent;
//        do
//        {
//            return;
//            localIntent = d(paramBaseActivity, 1);
//        }
//        while (localIntent == null);
//        paramBaseActivity.startActivityInFrame(localIntent);
//    }
}
