package com.jingdong.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.c.LocManager;
import com.jingdong.common.config.Configuration;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.Log;
import com.zy.common.utils.NetUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by robin on 16-8-19.
 */
public class StatisticsReportUtil {
    public static final String DEVICE_INFO_UUID = "uuid";
    public static final String REPORT_PARAM_LBS_AREA = "&area=";
    public static final String REPORT_PARAM_NETWORK_TYPE = "&networkType=";
    private static final String SHOPPING_CART_UUID = "shoppingCartUUID";
    private static boolean already;
    private static String deivceUUID;
    private static String macAddress;
    private static CommonBase._AK macAddressListener = new CommonBase._AK(){//fw()
        @Override
        public synchronized void a(String paramString) {
            StatisticsReportUtil.macAddress = paramString;
            StatisticsReportUtil.already = true;
            notifyAll();
        }
    };
    private static String paramStr;
    private static String paramStrWithOutDeviceUUID;

    public static String genarateDeviceUUID(Context arg0) {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject3 = CommonUtil.getDeviceId(arg0);
        if (!TextUtils.isEmpty((CharSequence) localObject3))
            localObject3 = ((String) localObject3).trim().replaceAll("-", "");

        if (macAddress == null) {//if-nez v1, :cond_3
            CommonUtil.getLocalMacAddress(macAddressListener, arg0);
            synchronized (macAddressListener) {
                try {
                    if (!already) {//if-nez v1, :cond_2
                        if (Log.D)
                            Log.d("Temp", "mac wait start -->> ");
                        macAddressListener.wait();
                        if (Log.D)
                            Log.d("Temp", "mac wait end -->> ");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //:cond_2
                if (macAddress == null) {//if-nez v1, :cond_7
                    macAddress = "";
                } else {
                    //sget-object v1, Lcom/jingdong/common/utils/StatisticsReportUtil;->macAddress:Ljava/lang/String;
                    macAddress = macAddress;
                }
            }
        }
        //:cond_3
        //:goto_1
        if (!TextUtils.isEmpty((CharSequence) macAddress))
            macAddress = ((String) macAddress).trim().replaceAll("-|\\.|:", "");
        if (!TextUtils.isEmpty((CharSequence) localObject3))
            localStringBuilder.append((String) localObject3);
        localStringBuilder.append("-");
        if (!TextUtils.isEmpty((String) macAddress))
            localStringBuilder.append(macAddress);
        return localStringBuilder.toString();
    }

    public static String getBrand()
    {
        String str = "";
        try
        {
            str = spilitSubString(Build.MANUFACTURER, 12).replaceAll(" ", "");
        }
        catch (Exception e)
        {
            if (Log.D)
                e.printStackTrace();
        }
        return str;
    }

    public static String getDNSParamStr()
    {
        Object localObject = new StringBuffer();
        ((StringBuffer)localObject).append("client=").append(Configuration.getProperty("client", ""));
        ((StringBuffer)localObject).append("&clientVersion=").append(spilitSubString(getSoftwareVersionName(), 12));
        ((StringBuffer)localObject).append("&osVersion=").append(spilitSubString(Build.VERSION.RELEASE, 12));
        ((StringBuffer)localObject).append("&uuid=").append(readDeviceUUID());
        ((StringBuffer)localObject).append("&build=").append(CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance()));
        localObject = ((StringBuffer)localObject).toString();
        if (Log.D)
            Log.d("Temp", "dns getParamStr() create -->> " + (String)localObject);
        return (String)localObject;
    }

    public static String getDeviceInfoStr()
    {
        JSONObject localJSONObject = new JSONObject();
        try
        {
            localJSONObject.put(DEVICE_INFO_UUID, readDeviceUUID());
            localJSONObject.put("platform", 100);
            localJSONObject.put("brand", spilitSubString(Build.MANUFACTURER, 12));
            localJSONObject.put("model", spilitSubString(Build.MODEL, 12));
            Display localDisplay = ((WindowManager)BaseApplication.getInstance().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            localJSONObject.put("screen", localDisplay.getHeight() + "*" + localDisplay.getWidth());
            localJSONObject.put("clientVersion", getSoftwareVersionName());
            localJSONObject.put("osVersion", Build.VERSION.RELEASE);
            localJSONObject.put("partner", Configuration.getProperty("partner", ""));
            localJSONObject.put("nettype", getNetworkTypeName(BaseApplication.getInstance()));
            if (Log.D)
                Log.d("Temp", "getDeviceInfoStr() return -->> " + localJSONObject.toString());
        }
        catch (JSONException e)
        {
                e.printStackTrace();
        }
        return localJSONObject.toString();
    }

    public static String getModel()
    {
        String str = "";
        try
        {
            str = spilitSubString(Build.MODEL, 12).replaceAll(" ", "");
        }
        catch (Exception e)
        {
            if (Log.D)
            e.printStackTrace();
        }
        return str;
    }

    public static String getNetworkTypeName(Context paramContext)
    {
        Object localObject = (ConnectivityManager)paramContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService(Context.TELEPHONY_SERVICE);
        NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)localObject).getAllNetworkInfo();
        String str = "UNKNOWN";
            try
            {
                for (int i = 0; i < arrayOfNetworkInfo.length; i++){//if-ge v2, v4, :cond_3
                    paramContext = (Context)localObject;
                    if (arrayOfNetworkInfo[i].isConnected()) {
                        if (arrayOfNetworkInfo[i].getTypeName().toUpperCase().contains("MOBILE")) {
                            str = localTelephonyManager.getNetworkType()+"";
                        }else if (arrayOfNetworkInfo[i].getTypeName().toUpperCase().contains("WIFI")) {
                            str = "WIFI";
                        }else
                            str = "UNKNOWN";
                    }
                }
            }
            catch (Exception e)
            {
                str = "UNKNOWN";
            }
        return str;
    }

    private static PackageInfo getPackageInfo()
    {
        try
        {
            Context context = BaseApplication.getInstance();
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        catch (Exception localException)
        {
        }
        return null;
    }

    private static String getParamStr()
    {
        if (!TextUtils.isEmpty(paramStr))
        {
            if (Log.D)
                Log.d("Temp", "getParamStr() -->> " + paramStr);
            return paramStr;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("&uuid=").append(readDeviceUUID());
        localStringBuffer.append(getParamStrWithOutDeviceUUID());
        paramStr = localStringBuffer.toString();
        if (Log.D)
            Log.d("Temp", "getParamStr() create -->> " + paramStr);
        return paramStr;
    }

    private static String getParamStrWithOutDeviceUUID()
    {
        if (!TextUtils.isEmpty(paramStrWithOutDeviceUUID))
        {
            if (Log.D)
                Log.d("Temp", "getParamStrWithOutDeviceUUID() -->> " + paramStrWithOutDeviceUUID);
            return paramStrWithOutDeviceUUID;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("&clientVersion=").append(spilitSubString(getSoftwareVersionName(), 12));
        localStringBuffer.append("&build=").append(CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance()));
        localStringBuffer.append("&client=").append(Configuration.getProperty("client", ""));
        try
        {
            Object localObject = spilitSubString(Build.MANUFACTURER, 12).replaceAll(" ", "");
            localStringBuffer.append("&d_brand=").append((String)localObject);
            localObject = spilitSubString(Build.MODEL, 12).replaceAll(" ", "");
            localStringBuffer.append("&d_model=").append((String)localObject);

        }
        catch (Exception localException)
        {
                if (Log.E)
                localException.printStackTrace();
        }
        localStringBuffer.append("&osVersion=").append(spilitSubString(Build.VERSION.RELEASE, 12));
        Display display = ((WindowManager)BaseApplication.getInstance().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        localStringBuffer.append("&screen=").append(display.getHeight() + "*" + display.getWidth());
        localStringBuffer.append("&partner=").append(Configuration.getProperty("partner", ""));
        paramStrWithOutDeviceUUID = localStringBuffer.toString();
        if (Log.D)
            Log.d("Temp", "getParamStrWithOutDeviceUUID() create -->> " + paramStrWithOutDeviceUUID);
        return paramStrWithOutDeviceUUID;
    }

    public static String getReportString(boolean paramBoolean)
    {
        return getReportString(paramBoolean, true);
    }

    public static String getReportString(boolean paramBoolean1, boolean paramBoolean2)
    {
        if ((paramBoolean1) || (getValidDeviceUUIDByInstant() != null));
        for (String str = getParamStr(); ; str = getParamStrWithOutDeviceUUID())
        {
            StringBuffer localStringBuffer = new StringBuffer();
            localStringBuffer.append(str);
            str = LocManager.e();
            if ((str != null) && (paramBoolean2))
            {
                str = str.replace("-1", "0");
                localStringBuffer.append(REPORT_PARAM_LBS_AREA).append(str);
            }
            localStringBuffer.append(REPORT_PARAM_NETWORK_TYPE).append(NetUtils.getNetworkType());
            if (Log.D)
                Log.d("Temp", "getReportString() -->> " + localStringBuffer.toString());
            return localStringBuffer.toString();
        }
    }

    public static int getSoftwareVersionCode()
    {
        PackageInfo localPackageInfo = getPackageInfo();
        if (localPackageInfo == null)
            return 0;
        return localPackageInfo.versionCode;
    }

    public static String getSoftwareVersionName()
    {
        PackageInfo localPackageInfo = getPackageInfo();
        if (localPackageInfo == null)
            return "";
        return localPackageInfo.versionName;
    }

    private static String getValidDeviceUUIDByInstant()
    {
        if (!TextUtils.isEmpty(deivceUUID))
            return deivceUUID;
        String str = CommonUtil.getJdSharedPreferences().getString(DEVICE_INFO_UUID, null);
        if (isValidDeviceUUID(str))
        {
            deivceUUID = str;
            return str;
        }
        return null;
    }

    private static boolean isValidDeviceUUID(String paramString)
    {
        if (!TextUtils.isEmpty(paramString)) {
            String[] strs = paramString.split("-");
            if ((strs.length > 1) && (!TextUtils.isEmpty(strs[1])))
                return true;
        }
        return false;
    }

    public static String readCartUUID()
    {
        SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();
        String str2 = localSharedPreferences.getString(SHOPPING_CART_UUID, null);
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
            str1 = readDeviceUUID();
            str1 = str1 + UUID.randomUUID();
            localSharedPreferences.edit().putString(SHOPPING_CART_UUID, str1).commit();
        }
        return str1;
    }

    // ERROR //
    public static String readDeviceUUID()
    {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: invokestatic 331	com/jingdong/common/utils/StatisticsReportUtil:getValidDeviceUUIDByInstant	()Ljava/lang/String;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnull +40 -> 48
        //   11: aload_1
        //   12: astore_0
        //   13: getstatic 85	com/jingdong/common/utils/Log:D	Z
        //   16: ifeq +27 -> 43
        //   19: ldc 87
        //   21: new 50	java/lang/StringBuilder
        //   24: dup
        //   25: ldc_w 407
        //   28: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   31: aload_1
        //   32: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   35: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   38: invokestatic 93	com/jingdong/common/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   41: aload_1
        //   42: astore_0
        //   43: ldc 2
        //   45: monitorexit
        //   46: aload_0
        //   47: areturn
        //   48: getstatic 85	com/jingdong/common/utils/Log:D	Z
        //   51: ifeq +11 -> 62
        //   54: ldc 87
        //   56: ldc_w 409
        //   59: invokestatic 93	com/jingdong/common/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   62: invokestatic 166	com/jingdong/common/BaseApplication:getInstance	()Lcom/jingdong/common/BaseApplication;
        //   65: invokestatic 411	com/jingdong/common/utils/StatisticsReportUtil:genarateDeviceUUID	(Landroid/content/Context;)Ljava/lang/String;
        //   68: astore_1
        //   69: aload_1
        //   70: invokestatic 378	com/jingdong/common/utils/StatisticsReportUtil:isValidDeviceUUID	(Ljava/lang/String;)Z
        //   73: ifeq +39 -> 112
        //   76: getstatic 85	com/jingdong/common/utils/Log:D	Z
        //   79: ifeq +11 -> 90
        //   82: ldc 87
        //   84: ldc_w 413
        //   87: invokestatic 93	com/jingdong/common/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   90: invokestatic 369	com/jingdong/common/utils/CommonUtil:getJdSharedPreferences	()Landroid/content/SharedPreferences;
        //   93: invokeinterface 396 1 0
        //   98: ldc 8
        //   100: aload_1
        //   101: invokeinterface 402 3 0
        //   106: invokeinterface 405 1 0
        //   111: pop
        //   112: aload_1
        //   113: astore_0
        //   114: getstatic 85	com/jingdong/common/utils/Log:D	Z
        //   117: ifeq -74 -> 43
        //   120: ldc 87
        //   122: new 50	java/lang/StringBuilder
        //   125: dup
        //   126: ldc_w 415
        //   129: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   132: aload_1
        //   133: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   136: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   139: invokestatic 93	com/jingdong/common/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   142: aload_1
        //   143: astore_0
        //   144: goto -101 -> 43
        //   147: astore_0
        //   148: ldc 2
        //   150: monitorexit
        //   151: aload_0
        //   152: athrow
        //   153: astore_0
        //   154: getstatic 85	com/jingdong/common/utils/Log:D	Z
        //   157: ifeq -45 -> 112
        //   160: aload_0
        //   161: invokevirtual 125	java/lang/Exception:printStackTrace	()V
        //   164: goto -52 -> 112
        //
        // Exception table:
        //   from	to	target	type
        //   3	7	147	finally
        //   13	41	147	finally
        //   48	62	147	finally
        //   62	90	147	finally
        //   90	112	147	finally
        //   114	142	147	finally
        //   154	164	147	finally
        //   90	112	153	java/lang/Exception
    }

    private static String spilitSubString(String paramString, int paramInt)
    {
        String str = paramString;
        if (str != null) {

            try {
                if (str.length() > paramInt)
                    str = str.substring(0, paramInt);
            } catch (Exception e) {
                if (Log.E)
                e.printStackTrace();
            }
        }
        return str;
    }
}
