package com.jingdong.jdma.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.common.utils.Md5Encrypt;
import com.zy.common.utils.NetUtils;
import com.zy.jdma.common.secure.DesUtil;
import com.zy.jdma.minterface.MaInitCommonInfo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by robin on 16-8-19.
 */
public class UserInfoModel {
    public static final String DES_KEY = "this is the pinaddress key apoaffffe";
    public static final String G_ANDROID = "ANDROID";
    public static final String JDMA_SDK_VERSION = "2";
    public static final String PID_KEY = "7B6697227CBCA902B1BE925D40FBB11B353F2DF4359D2050";
    public static String PIN;
    public static final String VERSION = "1.0";
    private static UserInfoModel instance = null;
    public static final String key = "5YT%aC89$22OI@pQ";
    private String app = "android";
    private String appBuildVersion = "";
    private String appVersion;
    private String app_device = "";
    private String appv;
    private String appver_code = "";
    private String channel;
    private String client;
    private String device;
    private String guid;
    private String imei = "";
    private String imsi = "";
    private String machineCode;
    private String machineType;
    private String method;
    private String os = "android";
    private String osVersion;
    private String osv;
    private String project_id;
    private String report_time;
    private String requestype = "app";
    private String resolu;
    private String sdk_version;
    private String siteid = "";
    private String token;

    static
    {
        PIN = "";
    }

    private UserInfoModel(Context paramContext, MaInitCommonInfo paramMaInitCommonInfo)
    {
        setMachineCode(paramMaInitCommonInfo.guid);
        setMachineType(spilitSubString(Build.MODEL, 12));
        setOsv(spilitSubString(Build.VERSION.RELEASE, 12));
        setAppVersion(paramMaInitCommonInfo.appv);
        setProjectId(paramMaInitCommonInfo.proj_id);
        setGuid(paramMaInitCommonInfo.guid);
        setClient("ANDROID");
        setAppv(paramMaInitCommonInfo.appv);
        Object localObject = paramContext.getResources().getDisplayMetrics();
        setResolu(((DisplayMetrics)localObject).heightPixels + "*" + ((DisplayMetrics)localObject).widthPixels);
        setDevice(spilitSubString(Build.MANUFACTURER, 12) + "_" + Build.MODEL);
        setOsVersion(Build.VERSION.RELEASE);
        setSdkVersion("2");
        setChannel(paramMaInitCommonInfo.channel);
        setApp_device(paramMaInitCommonInfo.app_device);
        localObject = (TelephonyManager)paramContext.getSystemService(Context.TELEPHONY_SERVICE/*"phone"*/);
        setImei(((TelephonyManager)localObject).getDeviceId());
        setImsi(((TelephonyManager)localObject).getSubscriberId());
        setAppBuildVersion(paramMaInitCommonInfo.build);
        try
        {
            PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
            setAppver_code(new StringBuilder().append(packageInfo.versionCode).toString());
            setSiteid(paramMaInitCommonInfo.site_id);
            return;
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }
    }

    public static String getEncryptLoginPid(String paramString)
    {
        if (TextUtils.isEmpty(paramString))
            return "";
        return DesUtil.encrypt(paramString, "7B6697227CBCA902B1BE925D40FBB11B353F2DF4359D2050");
    }

    public static String getEncryptLoginUserName(String paramString)
    {
        if (TextUtils.isEmpty(paramString))
            return "";
        return DesUtil.encrypt(paramString, "this is the pinaddress key apoaffffe");
    }

    public static UserInfoModel getInstance(Context paramContext, MaInitCommonInfo paramMaInitCommonInfo)
    {
        if (instance == null)
            instance = new UserInfoModel(paramContext, paramMaInitCommonInfo);
        return instance;
    }

    private static String spilitSubString(String paramString, int paramInt)
    {
        String str = paramString;
        if (paramString != null)
            str = paramString;
        try
        {
            if (paramString.length() > paramInt)
                str = paramString.substring(0, paramInt);
            return str;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return paramString;
    }

    public JSONObject dataToJson(Context paramContext, int paramInt, String paramString)
    {
        JSONObject localJSONObject = new JSONObject();
        try
        {
            String str1 = CommonUtil.getCurrentMicrosecond();
            String str2 = Md5Encrypt.md5(str1 + "5YT%aC89$22OI@pQ");
            if (paramInt == 1)
            {
                localJSONObject.put("report_ts", str1);
                localJSONObject.put("token", str2);
                localJSONObject.put("proj_id", this.project_id);
                localJSONObject.put("uid", this.guid);
                localJSONObject.put("osp", this.client);
                localJSONObject.put("apv", this.appv);
                localJSONObject.put("scr", this.resolu);
                localJSONObject.put("dvc", this.device);
                localJSONObject.put("osv", this.osv);
                localJSONObject.put("jvr", this.sdk_version);
                localJSONObject.put("chf", this.channel);
                localJSONObject.put("method", paramString);
                localJSONObject.put("bld", this.appBuildVersion);
                localJSONObject.put("machineType", getMachineType());
                localJSONObject.put("imei", this.imei);
                localJSONObject.put("imsi", this.imsi);
                localJSONObject.put("app_device", this.app_device);
                localJSONObject.put("clt", this.requestype);
                localJSONObject.put("ver", "1.0");
                localJSONObject.put("apc", this.appver_code);
                localJSONObject.put("std", this.siteid);
                return localJSONObject;
            }
            if (paramInt == 0)
            {
                localJSONObject.put("accountId", getEncryptLoginUserName(PIN));
                localJSONObject.put("machineCode", getMachineCode());
                localJSONObject.put("machineType", getMachineType());
                localJSONObject.put("os", getOs());
                localJSONObject.put("osVersion", getOsVersion());
                localJSONObject.put("app", getApp());
                localJSONObject.put("appVersion", getAppVersion());
                localJSONObject.put("net", NetUtils.getNetworkType(paramContext));
                localJSONObject.put("curTime", str1);
                localJSONObject.put("sdkVersion", this.sdk_version);
                localJSONObject.put("token", str2);
                localJSONObject.put("build", this.appBuildVersion);
                return localJSONObject;
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (ClassCastException e)
        {
            e.printStackTrace();
        }
        return localJSONObject;
    }

    public String getApp()
    {
        return this.app;
    }

    public String getAppBuildVersion()
    {
        return this.appBuildVersion;
    }

    public String getAppVersion()
    {
        return this.appVersion;
    }

    public String getApp_device()
    {
        return this.app_device;
    }

    public String getAppv()
    {
        return this.appv;
    }

    public String getAppver_code()
    {
        return this.appver_code;
    }

    public String getChannel()
    {
        return this.channel;
    }

    public String getClient()
    {
        return this.client;
    }

    public String getDevice()
    {
        return this.device;
    }

    public String getGuid()
    {
        return this.guid;
    }

    public String getImei()
    {
        return this.imei;
    }

    public String getImsi()
    {
        return this.imsi;
    }

    public String getMachineCode()
    {
        return this.machineCode;
    }

    public String getMachineType()
    {
        return this.machineType;
    }

    public String getMethod()
    {
        return this.method;
    }

    public String getOs()
    {
        return this.os;
    }

    public String getOsVersion()
    {
        return this.osVersion;
    }

    public String getOsv()
    {
        return this.osv;
    }

    public String getProjectId()
    {
        return this.project_id;
    }

    public String getReportTime()
    {
        return this.report_time;
    }

    public String getResolu()
    {
        return this.resolu;
    }

    public String getSdkVersion()
    {
        return this.sdk_version;
    }

    public String getSiteid()
    {
        return this.siteid;
    }

    public String getToken()
    {
        return this.token;
    }

    public void setApp(String paramString)
    {
        this.app = paramString;
    }

    public void setAppBuildVersion(String paramString)
    {
        this.appBuildVersion = paramString;
    }

    public void setAppVersion(String paramString)
    {
        this.appVersion = paramString;
    }

    public void setApp_device(String paramString)
    {
        this.app_device = paramString;
    }

    public void setAppv(String paramString)
    {
        this.appv = paramString;
    }

    public void setAppver_code(String paramString)
    {
        this.appver_code = paramString;
    }

    public void setChannel(String paramString)
    {
        this.channel = paramString;
    }

    public void setClient(String paramString)
    {
        this.client = paramString;
    }

    public void setDevice(String paramString)
    {
        this.device = paramString;
    }

    public void setGuid(String paramString)
    {
        this.guid = paramString;
    }

    public void setImei(String paramString)
    {
        this.imei = paramString;
    }

    public void setImsi(String paramString)
    {
        if (paramString != null)
        {
            this.imsi = paramString;
            return;
        }
        this.imsi = "";
    }

    public void setMachineCode(String paramString)
    {
        this.machineCode = paramString;
    }

    public void setMachineType(String paramString)
    {
        this.machineType = paramString;
    }

    public void setMethod(String paramString)
    {
        this.method = paramString;
    }

    public void setOs(String paramString)
    {
        this.os = paramString;
    }

    public void setOsVersion(String paramString)
    {
        this.osVersion = paramString;
    }

    public void setOsv(String paramString)
    {
        this.osv = paramString;
    }

    public void setProjectId(String paramString)
    {
        this.project_id = paramString;
    }

    public void setReportTime(String paramString)
    {
        this.report_time = paramString;
    }

    public void setResolu(String paramString)
    {
        this.resolu = paramString;
    }

    public void setSdkVersion(String paramString)
    {
        this.sdk_version = paramString;
    }

    public void setSiteid(String paramString)
    {
        this.siteid = paramString;
    }

    public void setToken(String paramString)
    {
        this.token = paramString;
    }
}
