package com.jingdong.common.network;

import android.text.TextUtils;

import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.HttpGroup;
import com.zy.common.utils.Log;
import com.zy.common.utils.NetUtils;
import com.zy.common.utils.StatisticsReportUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Robin on 2016/11/23.
 */
public class JDDnsUtil {
    private static JDDnsUtil a;
    private final String b = "ware.m.jd.com,search.m.jd.com,cart.m.jd.com,order.m.jd.com,i.m.jd.com,portal.m.jd.com,virtual.m.jd.com,ngw.m.jd.com,ngw.m.jd.care";
    private String c;

    private JDDnsUtil()
    {
        EventBus.getDefault().register(this);
    }

    //a()
    public static JDDnsUtil getInstance()
    {
        if (a == null)
            synchronized (JDDnsUtil.class){
            if (a == null)
                a = new JDDnsUtil();
            }
        return a;
    }

    public static void a(String paramString1, HttpGroup.HttpSetting paramHttpSetting, HttpGroup.HttpError paramHttpError, String paramString2)
    {
        if (Log.D)
            Log.d("HttpDns", "mta:" + paramString1 + "," + paramHttpError.getException().toString());
        new ExceptionReporter();
        ExceptionReporter.reportHttpException(paramString1, paramHttpSetting, paramHttpError, paramString2);
    }

    public static boolean a(String paramString)
    {
        return "ware.m.jd.com,search.m.jd.com,cart.m.jd.com,order.m.jd.com,i.m.jd.com,portal.m.jd.com,virtual.m.jd.com,ngw.m.jd.com,ngw.m.jd.care".indexOf(paramString) != -1;
    }

    public final void b()
    {
        b.a("ware.m.jd.com,search.m.jd.com,cart.m.jd.com,order.m.jd.com,i.m.jd.com,portal.m.jd.com,virtual.m.jd.com,ngw.m.jd.com,ngw.m.jd.care", c());
    }

    public final String c()
    {
        if (TextUtils.isEmpty(this.c))
            this.c = StatisticsReportUtil.getDNSParamStr();
        StringBuffer localStringBuffer = new StringBuffer(this.c);
        localStringBuffer.append("&networkType=").append(NetUtils.getNetworkType());
        return localStringBuffer.toString();
    }

    public void onEvent(e parame)
    {
        if (Log.D)
            Log.d("httpDns", "event:" + parame.c() + "," + parame.a() + "," + parame.b().toString());
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setFunctionId("");
        localHttpSetting.setUrl(parame.a());
        HttpGroup.HttpError localHttpError = new HttpGroup.HttpError(parame.b());
        a(parame.a(), localHttpSetting, localHttpError, "802");
        if (!parame.c())
            j.a = false;
    }
}
