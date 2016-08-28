package com.jingdong.common.utils;
import android.text.TextUtils;

import com.jingdong.common.BaseApplication;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Robin on 2016/6/5.
 */
public class ExceptionReporter {
    private static final String BIG_BITMAP_ERRCODE = "903";
    private static final String BITMAP_EXP_ERRCODE = "805";
    public static final String DOMAIN_REQUEST_EXP_ERRCODE = "804";
    private static final String DUPLICATE_PIC_ERRCODE = "801";
    private static final String FLOW_DATA_ERRCODE = "902";
    public static final String HTTPDNS_EXP_ERRCODE = "802";
    private static final String HTTP_BUSNISS_ERRCODE = "901";
    public static final String IP_REQUEST_EXP_ERRCODE = "803";
    private static final String TAG = ExceptionReporter.class.getSimpleName();
    private static final String UPGRADE_ERRCODE = "951";
    private static final String WEBVIEW_ERROR_HOST_ERRCODE = "904";
    private HttpGroup.HttpSetting mHttpSetting;

    public ExceptionReporter()
    {
    }

    public ExceptionReporter(HttpGroup.HttpSetting paramHttpSetting)
    {
        attachHttpSetting(paramHttpSetting);
    }

//    private static byte[] compressException(String paramString)
//            throws IOException
//    {
//        if (Log.D)
//            Log.d(TAG, "compressException:" + paramString);
//        if (TextUtils.isEmpty(paramString))
//            return new byte[1];
//        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
//        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
//        localGZIPOutputStream.write(paramString.getBytes());
//        localGZIPOutputStream.close();
//        return localByteArrayOutputStream.toByteArray();
//    }
//
//    private static final boolean isReport(int paramInt1, int paramInt2, long paramLong)
//    {
//        if (Log.D)
//            Log.d(TAG, "width = " + paramInt1 + "height = " + paramInt2 + "size = " + paramLong);
//        long l2 = 307200L;
//        String str = com.jingdong.common.e.a.a("maxImageSize", "300");
//        if (Log.D)
//            Log.d(TAG, "strmaxSize = " + str);
//        long l1 = l2;
//        try
//        {
//            if (!TextUtils.isEmpty(str))
//            {
//                l1 = Long.parseLong(str);
//                l1 *= 1024L;
//            }
//            if (paramLong > l1)
//                return true;
//        }
//        catch (Exception localException)
//        {
//            while (true)
//            {
//                l1 = l2;
//                if (!Log.E)
//                    continue;
//                localException.printStackTrace();
//                l1 = l2;
//            }
//        }
//        return false;
//    }
//
//    public static void reportApplicationUpgradeEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
//    {
//        reportApplicationUpgradeEvent(paramString1, paramString2, paramString3, paramString4, paramString5, "");
//    }
//
//    public static void reportApplicationUpgradeEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
//    {
//        if (Log.D)
//            Log.d(TAG, "reportApplicationUpgradeEvent: " + paramString1);
//        try
//        {
//            HashMap localHashMap = new HashMap();
//            localHashMap.put("function", "");
//            localHashMap.put("url", Base64.encodeBytes(paramString1.getBytes()));
//            localHashMap.put("upClickTime", paramString2);
//            localHashMap.put("upCancleTime", paramString3);
//            localHashMap.put("upDownSize", paramString4);
//            localHashMap.put("upInstallTime", paramString5);
//            localHashMap.put("errCode", "951");
//            localHashMap.put("errType", "3");
//            localHashMap.put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//            if (!TextUtils.isEmpty(paramString6))
//             localHashMap.put("exception", paramString6);
//            JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), localHashMap);
//            return;
//        }
//        catch (Throwable e)
//        {
//             if(!Log.E);
//            e.printStackTrace();
//        }
//    }
//
    public static final void reportBigBitmapException(String paramString, int paramInt1, int paramInt2, long paramLong){
        if (Log.D)
            Log.d(TAG, "reportBigBitmapException:" + paramString + "width = " + paramInt1 + "height = " + paramInt2 + "size = " + paramLong);
        throw new RuntimeException("Not reportBigBitmapException!");
//        if (!isReport(paramInt1, paramInt2, paramLong));
//        while (true)
//        {
//            return;
//            Object localObject1 = "{}";
//            try
//            {
//                Object localObject2 = new JSONObjectProxy();
//                ((JSONObjectProxy)localObject2).put("size", paramLong);
//                ((JSONObjectProxy)localObject2).put("width", paramInt1);
//                ((JSONObjectProxy)localObject2).put("height", paramInt2);
//                localObject2 = ((JSONObjectProxy)localObject2).toString();
//                localObject1 = localObject2;
//                label116: if (Log.D)
//                    Log.d(TAG, "reportBigBitmapException:" + paramString + "width = " + paramInt1 + "height = " + paramInt2 + "size = " + paramLong + ",postDataStr" + (String)localObject1);
//                try
//                {
//                    localObject2 = new HashMap();
//                    ((HashMap)localObject2).put("function", "bigBitmap");
//                    ((HashMap)localObject2).put("url", Base64.encodeBytes(paramString.getBytes()));
//                    ((HashMap)localObject2).put("postData", Base64.encodeBytes(((String)localObject1).getBytes()));
//                    ((HashMap)localObject2).put("httpResp", "0");
//                    ((HashMap)localObject2).put("errCode", "903");
//                    ((HashMap)localObject2).put("verifyCode", "");
//                    ((HashMap)localObject2).put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//                    ((HashMap)localObject2).put("errType", "2");
//                    JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), (HashMap)localObject2);
//                    return;
//                }
//                catch (Throwable paramString)
//                {
//                }
//                if (!Log.E)
//                    continue;
//                paramString.printStackTrace();
//                return;
//            }
//            catch (Exception localException)
//            {
//                break label116;
//            }
//        }
    }

    public static final void reportBitmapException(String paramString, JDFailReason paramJDFailReason)
    {
        if (Log.D)
            Log.d(TAG, "reportBitmapException：" + paramString + ",failReason:" + paramJDFailReason);
        throw new RuntimeException("Not reportBitmapException!");
//        try
//        {
//            HashMap localHashMap = new HashMap();
//            localHashMap.put("function", "picRes");
//            localHashMap.put("url", Base64.encodeBytes(paramString.getBytes()));
//            localHashMap.put("postData", "");
//            localHashMap.put("httpResp", "0");
//            localHashMap.put("errCode", "805");
//            localHashMap.put("verifyCode", "");
//            if (paramJDFailReason != null)
//            {
//                paramString = "99";
//                if (paramJDFailReason.getType() != d.b)
//                    break label245;
//                paramString = "图片解码错误！";
//                localHashMap.put("errMsg", Base64.encodeBytes(paramString.getBytes()));
//                if (paramJDFailReason.getCause() == null)
//                    break label313;
//                if (Log.D)
//                    Log.d(TAG, "reportBitmapException：failReason:" + paramJDFailReason.getCause());
//                localHashMap.put("exception", Base64.encodeBytes(compressException(com.jingdong.lib.a.a.a(paramJDFailReason.getCause()))));
//            }
//            while (true)
//            {
//                localHashMap.put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//                localHashMap.put("errType", "1");
//                JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), localHashMap);
//                return;
//                label245: if (paramJDFailReason.getType() == d.a)
//                {
//                    paramString = "图片读取输入流错误，可能网络问题。";
//                    break;
//                }
//                if (paramJDFailReason.getType() == d.c)
//                {
//                    paramString = "用户禁止使用网络下载图片！";
//                    break;
//                }
//                if (paramJDFailReason.getType() == d.d)
//                {
//                    paramString = "获取图片内存溢出！";
//                    break;
//                }
//                if (paramJDFailReason.getType() != d.e)
//                    break;
//                paramString = "未知错误！";
//                break;
//                label313: localHashMap.put("exception", "");
//            }
//        }
//        catch (Throwable e)
//        {
//            if (Log.E)
//                e.printStackTrace();
//        }
    }

//    public static final void reportDuplicatePicException(String paramString)
//    {
//        if (Log.D)
//            Log.d(TAG, "reportDuplicatePicException:" + paramString);
//        try
//        {
//            HashMap localHashMap = new HashMap();
//            localHashMap.put("function", "duplicatePic");
//            localHashMap.put("url", Base64.encodeBytes(paramString.getBytes()));
//            localHashMap.put("postData", "");
//            localHashMap.put("httpResp", "0");
//            localHashMap.put("errCode", "801");
//            localHashMap.put("verifyCode", "");
//            localHashMap.put("exception", "");
//            localHashMap.put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//            localHashMap.put("errType", "1");
//            JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), localHashMap);
//            return;
//        }
//        catch (Throwable paramString)
//        {
//            while (!Log.E);
//            paramString.printStackTrace();
//        }
//    }
//
//    public static void reportFlowData(String paramString1, String paramString2)
//    {
//        if (Log.D)
//            Log.d(TAG, "reportFlowData：" + paramString1);
//        try
//        {
//            HashMap localHashMap = new HashMap();
//            localHashMap.put("function", "self_flowData");
//            localHashMap.put("specialFlag", "1");
//            localHashMap.put("url", Base64.encodeBytes(paramString1.getBytes()));
//            localHashMap.put("postData", Base64.encodeBytes(paramString2.getBytes()));
//            localHashMap.put("httpResp", "0");
//            localHashMap.put("errCode", "902");
//            localHashMap.put("verifyCode", "");
//            localHashMap.put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//            localHashMap.put("specialFlag", "1");
//            localHashMap.put("errType", "2");
//            JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), localHashMap);
//            return;
//        }
//        catch (Throwable paramString1)
//        {
//            while (!Log.E);
//            paramString1.printStackTrace();
//        }
//    }
//
//    public static void reportHttpException(String paramString1, HttpGroup.HttpSetting paramHttpSetting, HttpGroup.HttpError paramHttpError, String paramString2)
//    {
//        if (Log.D)
//            Log.d(TAG, "reportHttpException:id：" + paramHttpSetting.getId() + ",errorCode: " + paramString2 + ",exception:" + paramHttpError.getException() + ",JsonCode:" + paramHttpError.getJsonCode());
//        try
//        {
//            HashMap localHashMap = new HashMap();
//            localHashMap.put("function", paramHttpSetting.getMtaFunctionId());
//            if (TextUtils.isEmpty(paramString1))
//            {
//                if (paramHttpSetting.getUrl() == null)
//                {
//                    paramString1 = "";
//                    localHashMap.put("url", Base64.encodeBytes(paramString1.getBytes()));
//                    localHashMap.put("postData", Base64.encodeBytes(paramHttpSetting.getJsonParamsString().getBytes()));
//                    localHashMap.put("httpResp", paramHttpError.getErrorCode());
//                    if (paramHttpError.getException() != null)
//                        break label282;
//                    localHashMap.put("errCode", paramHttpError.getJsonCode());
//                }
//                while (true)
//                {
//                    localHashMap.put("verifyCode", paramHttpError.getValidDataErrorCode());
//                    localHashMap.put("exception", Base64.encodeBytes(compressException(com.jingdong.lib.a.a.a(paramHttpError.getException()))));
//                    localHashMap.put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//                    localHashMap.put("errType", "1");
//                    JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), localHashMap);
//                    return;
//                    paramString1 = paramHttpSetting.getUrl();
//                    break;
//                    label282: localHashMap.put("errCode", paramString2);
//                }
//            }
//        }
//        catch (Exception paramString1)
//        {
//            while (Log.E)
//            {
//                paramString1.printStackTrace();
//                return;
//            }
//        }
//    }
//
//    public static final void reportWebViewErrorUrl(String paramString)
//    {
//        if (Log.D)
//            Log.d(TAG, "reportWebViewErrorUrl:" + paramString);
//        try
//        {
//            HashMap localHashMap = new HashMap();
//            localHashMap.put("function", "WebView_Error_Host");
//            localHashMap.put("url", Base64.encodeBytes(paramString.getBytes()));
//            localHashMap.put("postData", "{}");
//            localHashMap.put("httpResp", "0");
//            localHashMap.put("errCode", "904");
//            localHashMap.put("verifyCode", "");
//            localHashMap.put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//            localHashMap.put("errType", "2");
//            JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), localHashMap);
//            return;
//        }
//        catch (Throwable paramString)
//        {
//            while (!Log.E);
//            paramString.printStackTrace();
//        }
//    }

    public void attachHttpSetting(HttpGroup.HttpSetting paramHttpSetting)
    {
        this.mHttpSetting = paramHttpSetting;
    }

    public void reportHttpBusinessException(HttpGroup.HttpResponse paramHttpResponse)
    {
//        if (this.mHttpSetting == null)
//            return;
//        String str1;
//        label15: Object localObject;
//        String str2;
//        String str3;
//        if (paramHttpResponse == null)
//        {
//            str1 = "";
//            localObject = this.mHttpSetting;
//            str2 = ((HttpGroup.HttpSetting)localObject).getUrl();
//            str3 = ((HttpGroup.HttpSetting)localObject).getJsonParamsString();
//            if (Log.D)
//                Log.d(TAG, "reportHttpBusinessException:id：" + ((HttpGroup.HttpSetting)localObject).getId() + "," + ((HttpGroup.HttpSetting)localObject).getMtaFunctionId());
//        }
//        while (true)
//        {
//            try
//            {
//                HashMap localHashMap = new HashMap();
//                localHashMap.put("function", ((HttpGroup.HttpSetting)localObject).getMtaFunctionId());
//                localHashMap.put("url", Base64.encodeBytes(str2.getBytes()));
//                localHashMap.put("postData", Base64.encodeBytes(str3.getBytes()));
//                localObject = new StringBuilder();
//                if (paramHttpResponse != null)
//                    break label271;
//                paramHttpResponse = "";
//                localHashMap.put("httpResp", paramHttpResponse);
//                localHashMap.put("errCode", "901");
//                localHashMap.put("errMsg", Base64.encodeBytes(str1.toString().getBytes()));
//                localHashMap.put("verifyCode", "");
//                localHashMap.put("exception", "");
//                localHashMap.put("occurTime", JDMtaUtils.getCurrentMicrosecond());
//                localHashMap.put("errType", "2");
//                JDMtaUtils.sendExceptionData(BaseApplication.getInstance(), localHashMap);
//                return;
//            }
//            catch (Throwable paramHttpResponse)
//            {
//            }
//            if (!Log.E)
//                break;
//            paramHttpResponse.printStackTrace();
//            return;
//            str1 = paramHttpResponse.getString();
//            break label15;
//            label271: int i = paramHttpResponse.getCode();
//            paramHttpResponse = Integer.valueOf(i);
//        }
    }
}
