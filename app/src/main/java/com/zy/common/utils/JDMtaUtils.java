package com.zy.common.utils;

import android.content.Context;

import com.jingdong.app.mall.more.VoiceSearchActivity;
import com.jingdong.common.BaseApplication;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.view.view.HomeTitle;
import com.zy.cleanmvp.ui.BaseFragment;

import java.util.HashMap;

/**
 * Created by Robin on 2016/5/8.
 */
public class JDMtaUtils {
    public static void onClick(Context paramContext, String paramString1, String paramString2) {
        sendCommonData(paramContext, paramString1, "", "onClick", paramString2, "", "", "");
    }

    public static void onClick(Context context, String paramString1, String paramString3, String paramString2) {
        sendCommonData(context, paramString1, paramString3, "onClick", paramString2, "", "", "");
    }

    public static void onClick(Context context, String paramString1, String name, String paramString2, String paramString3) {
    }

    public static void sendCommonData(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject, String paramString4, Class paramClass, String paramString5)
    {
        sendCommonData(paramContext, paramString1, paramString2, paramString3, paramObject, paramString4, paramClass, paramString5, "");
    }

    public static void sendCommonData(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject, String paramString4, Class paramClass, String paramString5, String paramString6)
    {

    }

    public static void sendCommonData(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject, String paramString4, String paramString5, String paramString6)
    {
        sendCommonData(paramContext, paramString1, paramString2, paramString3, paramObject, paramString4, paramString5, paramString6, "");
    }

    public static void sendCommonData(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject, String paramString4, String paramString5, String paramString6, String paramString7)
    {

    }

    public static void sendCommonData(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    {

    }

    public static void sendCommonData(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt) {

    }


    public static void onClickWithPageId(Context paramContext, String paramString1, String paramString2, String paramString3) {
        try
        {
            sendCommonData(paramContext, paramString1, "", "onClick", paramString2, "", "", "", paramString3, "");
            return;
        }
        catch (Throwable e)
        {
            if (Log.E);
            e.printStackTrace();
        }
    }

    public static void onClickWithPageId(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4){
        try
        {
            sendCommonData(paramContext, paramString1, paramString3, "onClick", paramString2, "", "", "", paramString4, "");
            return;
        }
        catch (Throwable e)
        {
            if (Log.E);
            e.printStackTrace();
        }
    }

    public static void onClickWithPageId(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5){
        try
        {
            sendCommonData(paramContext, paramString1, paramString3, "onClick", paramString2, paramString4, "", "", paramString5, "");
            return;
        }
        catch (Throwable e)
        {
            if (Log.E);
            e.printStackTrace();
        }
    }


    public static void sendPagePv(Context paramContext, Object paramObject, String paramString1, String paramString2, String paramString3)
    {
        sendPagePv(paramContext, paramObject, paramString1, paramString2, paramString3, "", "");
    }

    public static void sendPagePv(Context paramContext, Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5){
    }

    public static void init(Context applicationContext) {

    }


    public static String getCurrentMicrosecond() {
        return String.format("%.6f", new Object[] { Double.valueOf((System.currentTimeMillis() + 0.0D) / 1000.0D) });
    }

    public static void sendExceptionData(BaseApplication instance, HashMap localHashMap) {
    }
}
