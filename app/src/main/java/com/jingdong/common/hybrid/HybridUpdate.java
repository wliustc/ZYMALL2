package com.jingdong.common.hybrid;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.jingdong.common.utils.HttpGroup;

import java.io.File;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 2016/11/7.
 */

public class HybridUpdate {
    private static final String BAK_PATH_KEY = "bakPathsKey";
    private static final String BUFF_DIR_ONE = "backup0";
    private static final String BUFF_DIR_TWO = "backup1";
    private static final String CUR_PATH_KEY = "curPathKey";
    private static final int DOWNLOAD_FAIL = 1001;
    private static final int DOWNLOAD_OK = 1002;
    public static final String D_FLAG = "downLoadStatus";
    private static final int END_COPY = 1005;
    private static final int END_DOWNLOAD = 1007;
    private static final int END_UNZIP = 1009;
    private static final int END_UPDATE = 1006;
    public static final String F_FLAG = "firsttimedFlag";
    private static final String H5_CONFIG_PATH = "h5Config";
    private static final int HTTP_TIMEOUT_ERROR = 1011;
    private static final String HYBRID_PATH = "hybrid";
    private static final String JSON_CACHE_PATH = "hybrid";
    public static final String LAST_CHECK_COMPLETE_KEY = "lastCHeckComplete";
    public static final String LAST_CHECK_TIME_KEY = "lastCHeckTime";
    private static final int START_COPY = 1004;
    private static final int START_DOWNLOAD = 1010;
    private static final int START_UNZIP = 1008;
    private static final int START_UPDATE = 1003;
    private static final String TAG = "HybridUpdate";
    private static String hybridBaseDir;
    private static HybridUpdate instance = null;
    private String appName;
    private HttpGroup.CustomOnAllListener checkUpdateListener = new HybridUpdate.1(this);
    public Intent configIntentParam = new Intent();
    public HybridUpdate.DownloadTaskManagerRunnable downloadTaskManagerRunnable;
    public boolean forceUseAsset = false;
    public Map<String, String> h5ConfigInfo = new HashMap();
    private H5Info h5InfoJson;
    private H5Info h5InfoXml = new H5Info();
    private String h5Name;
    private boolean hasLocal = false;
    private HybridStatusListener hybridStatusListener;
    private HybridUpdateManager hybridThreadManager;
    public boolean isForceUpdate = true;
    private Context mContext;
    private Thread managerThread;
    private Handler messageHandler;
    public String murl;
    private String sDir;

    static
    {
        hybridBaseDir = null;
    }

    private HybridUpdate(Context paramContext, String paramString)
    {
        this.mContext = paramContext;
        this.appName = paramString;
        paramContext = this.mContext.getDir("hybrid", 0);
        hybridBaseDir = paramContext.getAbsolutePath();
        this.messageHandler = new HybridUpdate.MessageHandler(this, this.mContext);
        this.h5InfoJson = new H5Info();
        FileUtil.chModFile("777", paramContext);
        Log.i("HybridUpdate", "hybrid base diretory is " + hybridBaseDir);
    }

    private void H5ConfigFileFormatError()
    {
        Log.e("HybridUpdate", "=====================================================================================");
        Log.e("HybridUpdate", "FORMAT ERROR: H5Config.xml format is not correct, modify it to your project.");
        Log.e("HybridUpdate", "=====================================================================================");
    }

    private void H5ConfigFileMissing()
    {
        Log.e("HybridUpdate", "=====================================================================================");
        Log.e("HybridUpdate", "ERROR: H5Config.xml is missing.  Add it to your project.");
        Log.e("HybridUpdate", "=====================================================================================");
    }

    private boolean checkDataFileIntegrity(String paramString)
    {
        int j = 0;
        try
        {
            Log.d("HybridUpdate", "Get base path " + hybridBaseDir);
            new File(hybridBaseDir, paramString);
            Object localObject = hybridBaseDir + File.separator + getCurPath(paramString) + File.separator;
            paramString = new File((String)localObject + paramString + ".html");
            localObject = new File((String)localObject + "plugins.xml");
            int i = j;
            if (paramString.exists())
            {
                i = j;
                if (((File)localObject).exists())
                {
                    Log.d("HybridUpdate", "html file directory " + paramString.getAbsolutePath() + " plugin file directory " + localObject);
                    i = 1;
                }
            }
            return i;
        }
        catch (Exception paramString)
        {
            paramString.printStackTrace();
        }
        return false;
    }

    private String encodeKey(String paramString1, String paramString2)
    {
        return URLEncoder.encode(paramString1 + "_" + paramString2);
    }

    private String getCurPath(String paramString)
    {
        String str2 = getSharedPreferences(paramString).getString("curPathKey", "");
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
            str1 = paramString + "/backup0";
        return str1;
    }

    private String getCurrenConfigPath()
    {
        if (!new File(hybridBaseDir + "/common/h5config.xml").exists())
        {
            putFirstTimeFlag(true);
            return "file:///android_asset/hybrid/";
        }
        putFirstTimeFlag(false);
        return hybridBaseDir + "/common/";
    }

    private String getDownLoadingStatus(String paramString)
    {
        return getSharedPreferences(paramString).getString("downLoadStatus", "none");
    }

    public static HybridUpdate getInstance(Context paramContext, String paramString)
    {
        if (instance == null)
            instance = new HybridUpdate(paramContext, paramString);
        return instance;
    }

    private long getLastCheckTime(String paramString)
    {
        return getSharedPreferences(paramString).getLong("lastCHeckTime", 0L);
    }

    private SharedPreferences getSharedPreferences(String paramString)
    {
        return this.mContext.getSharedPreferences(URLEncoder.encode(paramString), 0);
    }

    public void check()
    {
        check(600000L);
    }

    public void check(long paramLong)
    {
        getHybridConfig();
        if (!getLastCheckCompleteFlag(this.appName))
        {
            putLastCheckCompleteFlag(this.appName, true);
            Log.d("HybridUpdate", "send check request for LastCheckComplete is false");
            sendRequest(this.h5ConfigInfo, this.checkUpdateListener);
            putLastCheckTime(this.appName);
        }
        long l1;
        long l2;
        do
        {
            return;
            l1 = new Date().getTime();
            l2 = getLastCheckTime(this.appName);
            Log.d("HybridUpdate", "nowTime - lastCheckTIme = " + (l1 - l2));
            Log.d("HybridUpdate", "checkThreshold " + paramLong);
        }
        while (l1 - l2 <= paramLong);
        Log.d("HybridUpdate", "send check request");
        sendRequest(this.h5ConfigInfo, this.checkUpdateListener);
        putLastCheckTime(this.appName);
    }
}
