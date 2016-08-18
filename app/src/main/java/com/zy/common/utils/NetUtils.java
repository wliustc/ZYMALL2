package com.zy.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.jingdong.common.BaseApplication;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/5/31.
 */
public class NetUtils {
    public static final String NETWORK_TYPE_2G = "2g";
    public static final String NETWORK_TYPE_3G = "3g";
    public static final String NETWORK_TYPE_4G = "4g";
    public static final String NETWORK_TYPE_WIFI = "wifi";
    private static final int NO_NET = 2147483647;
    private static final int ROAMING = 2147483644;
    private static final String TAG = "NetUtils";
    private static final int UNKNOWN = 2147483646;
    private static final int WIFI = 2147483645;
    public static int currentNetType;
    private static String current_type = "";
    private static boolean isOffNetwork;
    public static boolean isProxy = true;

    static
    {
        currentNetType = 0;
    }

    public static String getCurrentType()
    {
        return current_type;
    }

    public static String getExtraInfo(NetworkInfo paramNetworkInfo)
    {
        if (paramNetworkInfo == null)
            return "";
        try
        {
            return paramNetworkInfo.getExtraInfo();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public static NetUtils.NetType getNetType()
    {
        return getNetType(BaseApplication.getInstance());
    }

    public static NetUtils.NetType getNetType(Context paramContext) {
        NetUtils.NetType localNetType = new NetUtils.NetType();
        Object localObject1;
        int i;

        ConnectivityManager localConnectivityManager = (ConnectivityManager) BaseApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (localConnectivityManager == null)
            return localNetType;
        else if (!isNetworkAvailable())
            return localNetType;
        else {
            i = getSummaryType((ConnectivityManager) localConnectivityManager);
            try {
                localObject1 = ((ConnectivityManager) localConnectivityManager).getActiveNetworkInfo();
            } catch (Exception e) {
                localObject1 = null;
            }
            return new NetUtils.NetType(i, getExtraInfo((NetworkInfo) localObject1), paramContext);
        }
    }

    public static String getNetworkOperator()
    {
        return getNetType().getNetworkOperator();
    }

    public static String getNetworkOperatorName()
    {
        return getNetType().getNetworkOperatorName();
    }

    public static String getNetworkType()
    {
        NetUtils.NetType localNetType = getNetType();
        if (localNetType.summaryType == 1)
            return NETWORK_TYPE_WIFI;
        if (localNetType.summaryType == 2) {
            try {
                int i = ((TelephonyManager) BaseApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE/*"phone"*/)).getNetworkType();
                switch (i) {
                    case 1://:pswitch_0
                    case 2://:pswitch_0
                    case 4://:pswitch_0
                    case 7://:pswitch_0
                    case 11://:pswitch_0
                        return NETWORK_TYPE_2G;
                    case 3://:pswitch_1
                    case 5://:pswitch_1
                    case 6://:pswitch_1
                    case 8://:pswitch_1
                    case 9://:pswitch_1
                    case 10://:pswitch_1
                    case 12://:pswitch_1
                    case 14://:pswitch_1
                    case 15://:pswitch_1
                        return NETWORK_TYPE_3G;
                    case 13://:pswitch_2
                        return NETWORK_TYPE_4G;
                }
            } catch (Throwable e) {
                if (Log.E)
                    e.printStackTrace();
            }
        }
        return "UNKNOW";
    }

    public static String getNetworkType(Context paramContext)
    {
        return getNetworkType();
    }

    public static int getSummaryType(ConnectivityManager paramConnectivityManager) {
        Object localObject2 = null;
        NetworkInfo.State v0 = null, v1 = null;
        try {
            v0 = paramConnectivityManager.getNetworkInfo(0).getState();
        } catch (Throwable e) {
        }
        //:goto_0
        try {
            v1 = paramConnectivityManager.getNetworkInfo(1).getState();
        } catch (Throwable e) {
        }
        //:goto_1
        if ((v1 == NetworkInfo.State.CONNECTED) || (v1 == NetworkInfo.State.CONNECTING))
            return 1;
        if ((v0 == NetworkInfo.State.CONNECTED) || (v0 == NetworkInfo.State.CONNECTING))
            return 2;
        return 0;
    }

    public static boolean is2GNetwork(Context paramContext)
    {
        if (getNetType().summaryType == 1)
            return false;
        int i = ((TelephonyManager)paramContext.getSystemService(Context.TELEPHONY_SERVICE/*"phone"*/)).getNetworkType();
        if (Log.D)
            Log.d("NetUtils", "Net work type:" + i);
        return (4 == i) || (1 == i) || (2 == i);
    }

    public static boolean is3GOr2GNetwork()
    {
        return getNetType().summaryType == 2;
    }

    public static boolean isNetworkAvailable()
    {
        ConnectivityManager localConnectivityManager = null;
        try
        {
            localConnectivityManager = (ConnectivityManager)BaseApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE/*"connectivity"*/);
            if (localConnectivityManager == null)
                return false;
        }
        catch (Exception e)
        {
                if (Log.D)
                {
                    Log.d("NetUtils", " isNetworkAvailable -->> " + e.getMessage());
                    e.printStackTrace();
                }
        }
        try
        {
            NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
            if (localNetworkInfo != null)
            {
                boolean bool = localNetworkInfo.isConnectedOrConnecting();
                if (bool)
                    return true;
            }
            return false;
        }
        catch (Exception localException2)
        {
            if (Log.D)
                localException2.printStackTrace();
        }
        return false;
    }

    private static boolean isNetworkAvailable(ConnectivityManager paramConnectivityManager) {
        NetworkInfo[] info = null;
        try {
            info = paramConnectivityManager.getAllNetworkInfo();
        } catch (Throwable e) {
        }
        for (int j = 0; info != null && info.length > 0; j++) {
            if (info[j].getState() == NetworkInfo.State.CONNECTED)
                return true;
        }
        return false;
    }

    public static boolean isOffNetwork()
    {
        return isOffNetwork;
    }

    public static boolean isWifi()
    {
        return getNetType().summaryType == 1;
    }

    public static boolean isWifiForLoadImage()
    {
        if (currentNetType == 0)
            updateNetType();
        return currentNetType == 1;
    }

    public static void setCurrentType(String paramString)
    {
        current_type = paramString;
    }

    public static void setOffNetwork(boolean paramBoolean)
    {
        isOffNetwork = paramBoolean;
    }

    public static void updateNetType()
    {
        currentNetType = 1;//NetUtils.NetType.access$000(getNetType());
    }

    public static class NetType{
        public static final int NSP_CHINA_MOBILE = 1;
        public static final int NSP_CHINA_TELECOM = 3;
        public static final int NSP_CHINA_UNICOM = 2;
        public static final int NSP_NO = -1;
        public static final int NSP_OTHER = 0;
        public static final int SUMMARY_TYPE_MOBILE = 2;
        public static final int SUMMARY_TYPE_OTHER = 0;
        public static final int SUMMARY_TYPE_WIFI = 1;
        private String detailType;
        private String extraInfo;
        String networkOperator;
        String networkOperatorName;
        String networkType;
        String networkTypeName;
        String proxyHost;
        Integer proxyPort;
        Integer simState;
        private int summaryType = 0;

        public NetType()
        {
        }

        public NetType(int paramInt, String paramString)
        {
            this.summaryType = paramInt;
            this.extraInfo = paramString;
            getSimAndOperatorInfo();
        }

        public NetType(int paramInt, String paramString, Context paramContext)
        {
            this.summaryType = paramInt;
            this.extraInfo = paramString;
            getSimAndOperatorInfo(paramContext);
        }

        private void getSimAndOperatorInfo()
        {
            getSimAndOperatorInfo(BaseApplication.getInstance());
        }

        private void getSimAndOperatorInfo(Context paramContext) {
            TelephonyManager telephonyManager = (TelephonyManager) paramContext.getSystemService(Context.TELEPHONY_SERVICE);//"phone"
            try {
                this.simState = Integer.valueOf(telephonyManager.getSimState());
            } catch (Throwable e) {
            }
            try {
                this.networkOperatorName = telephonyManager.getNetworkOperatorName();
            } catch (Throwable e) {
            }
            try {
                this.networkOperator = telephonyManager.getNetworkOperator();
            } catch (Throwable e) {
            }
            try {
                int type = telephonyManager.getNetworkType();
                this.networkType = type + "";
                this.networkTypeName = getNetworkTypeName(type);
                return;
            } catch (Throwable e) {
            }
        }

        public String getDetailType()
        {
            return "";
        }

        public int getNSP()
        {
            if ((this.simState == null) || (this.simState.intValue() == 0) || ((TextUtils.isEmpty(this.networkOperatorName)) && (TextUtils.isEmpty(this.networkOperator))))
                return -1;

            if (("中国移动".equalsIgnoreCase(this.networkOperatorName)) || ("CMCC".equalsIgnoreCase(this.networkOperatorName)) || ("46000".equalsIgnoreCase(this.networkOperator)) || ("China Mobile".equalsIgnoreCase(this.networkOperatorName)))
                return 1;
            if (("中国电信".equalsIgnoreCase(this.networkOperatorName)) || ("China Telecom".equalsIgnoreCase(this.networkOperatorName)) || ("46003".equalsIgnoreCase(this.networkOperator)))
                return 3;
            if (("中国联通".equalsIgnoreCase(this.networkOperatorName)) || ("China Unicom".equalsIgnoreCase(this.networkOperatorName)) || ("46001".equalsIgnoreCase(this.networkOperator)) || ("CU-GSM".equalsIgnoreCase(this.networkOperatorName)))
                return 2;
            return 0;
        }

        public String getNetworkOperator()
        {
            return this.networkOperator;
        }

        public String getNetworkOperatorName()
        {
            return this.networkOperatorName;
        }

        @SuppressLint({"NewApi"})
        public String getNetworkTypeName(int paramInt)
        {
            switch (paramInt)
            {
                default:
                    return "UNKNOWN";
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 4:
                    return "CDMA";
                case 5:
                    return "CDMA - EvDo rev. 0";
                case 6:
                    return "CDMA - EvDo rev. A";
                case 7:
            }
            return "CDMA - 1xRTT";
        }

        public String getProxyHost()
        {
            String str = Proxy.getDefaultHost();
            if (Log.D)
                Log.d("NetUtils", "getProxyHost() proxyHost -->> " + str);
            if (1 == this.summaryType)
            {
                if (Log.D)
                    Log.d("NetUtils", "getProxyHost() WIFI -->> ");
                return null;
            }
            if (Log.D)
                Log.d("NetUtils", "getProxyHost() else -->> ");
            this.proxyHost = str;
            this.proxyPort = Integer.valueOf(Proxy.getDefaultPort());
            if (Log.D)
                Log.d("NetUtils", "getProxyHost() proxyHost -->> " + str);
            return this.proxyHost;
        }

        public Integer getProxyPort()
        {
            return this.proxyPort;
        }

        public String getUploadType()
        {
            return this.networkType;
        }
    }

}
