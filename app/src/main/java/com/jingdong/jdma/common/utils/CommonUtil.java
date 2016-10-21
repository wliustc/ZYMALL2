package com.jingdong.jdma.common.utils;

import java.util.regex.Pattern;

/**
 * Created by Robin on 2016/10/21.
 */
public class CommonUtil {
    public static final int BROADCAST_ALIGNING_COUNT = 107;
    public static final int BROADCAST_GET_THRESHOLD = 105;
    public static final int BROADCAST_MIN_INTERVAL_TIME = 500;
    public static final int BROADCAST_REPORT_NUM = 106;
    public static final int BROADCAST_RESULT_SEND_EXCEPTION_MESSAGE = 102;
    public static final int BROADCAST_RESULT_SEND_REPORT_FAIL = 101;
    public static final int BROADCAST_RESULT_SEND_REPORT_SUCC = 100;
    public static final int BROADCAST_UPDATESTRATEGE = 103;
    public static final int BROADCAST_USER_CHANGE = 104;
    public static final int CONN_TIMEOUT = 10000;
    public static final int DEFAULT_INTERVAL = 30;
    public static final int DEFAULT_REQUEST_GAP_TIME = 2000;
    public static final Long EXCEPTION_DEFULT_UNWIFIREPORT_SIZE;
    public static final Long EXCEPTION_DEFULT_UNWIFI_INTER;
    public static final Long EXCEPTION_DEFULT_WIFI_INTER;
    public static final Long EXCEPTION_DEFULT_WIFI_REPORT_SIZE;
    public static final String EXCEPTION_GET_STRATEGY_URL = "http://ex.m.jd.com/exception_monitor/getRule";
    public static final String EXCEPTION_REPORT_DATA_URL = "http://ex.m.jd.com/exception_monitor/report";
    public static final String EXCEPTION_TABLE_NAME = "exception";
    public static final int GET_STRATEGY_FAIL = -1;
    public static final int GET_STRATEGY_SUCC = 0;
    public static final String LOGIN_SUC_ACTION = "refresh_recommedData";
    public static boolean LOGSWITCH = false;
    public static final int MAX_COUNT = 300;
    public static final int POST_TIMEOUT = 30000;
    public static final String[] RECORD_CLASS_ANME = { "com.jingdong.jdma.servicereport.ExceptionReportDemon", "com.jingdong.jdma.servicereport.StatisticReportDemon" };
    public static final int RECORD_TYPE_EX = 0;
    public static final int RECORD_TYPE_MAX = 2;
    public static final int RECORD_TYPE_STATISTIC = 1;
    public static final String REPORT_COMMAND_BROADCAST_RECEIVER_ACTION = "android.intent.action.reportcommand";
    public static final String REPORT_COMMAND_BROADCAST_TRIGER_APP_ACTION = "android.intent.action.triggerapp";
    public static final int REPORT_DATA_FAIL = -1;
    public static final int REPORT_DATA_NULL = 1;
    public static final int REPORT_DATA_SUCC = 0;
    public static final int REPORT_MIN_INTERVAL_TIME = 10000;
    public static final int RETRY_NUM = 3;
    public static final String SERVICENAME = "com.jingdong.jdma.service.JDMAService";
    public static final String SET_STRATEGY_GET_RULE_FAIL = "getRuleFail";
    public static final String SET_STRATEGY_GET_RULE_SUC = "getRuleSuc";
    public static final String SET_STRATEGY_REPORT_FAIL = "reportFail";
    public static final String SET_STRATEGY_REPORT_SUC = "reportSuc";
    public static final Long STATISTIC_DEFULT_UNWIFIREPORT_SIZE;
    public static final Long STATISTIC_DEFULT_UNWIFI_INTER;
    public static final Long STATISTIC_DEFULT_WIFI_INTER;
    public static final Long STATISTIC_DEFULT_WIFI_REPORT_SIZE;
    public static final String STATISTIC_GET_STRATEGY_METHOD = "bp.search";
    public static final String STATISTIC_GET_STRATEGY_URL = "http://stat.m.jd.com/stat/access";
    public static final String STATISTIC_REPORT_METHOD = "bp.report";
    public static final String STATISTIC_REPORT_URL = "http://stat.m.jd.com/stat/access";
    public static final String STATISTIC_TABLE_NAME = "statistic";
    public static final String[] TABLE_NAME_LIST;
    public static final String TAG = "JDMASDK";
    public static final String UTF8 = "utf-8";
    public static CommonUtil commonUtilInstance;

    static
    {
        EXCEPTION_DEFULT_WIFI_INTER = Long.valueOf(300L);
        EXCEPTION_DEFULT_WIFI_REPORT_SIZE = Long.valueOf(0L);
        EXCEPTION_DEFULT_UNWIFI_INTER = Long.valueOf(300L);
        EXCEPTION_DEFULT_UNWIFIREPORT_SIZE = Long.valueOf(0L);
        STATISTIC_DEFULT_WIFI_INTER = Long.valueOf(300L);
        STATISTIC_DEFULT_WIFI_REPORT_SIZE = Long.valueOf(0L);
        STATISTIC_DEFULT_UNWIFI_INTER = Long.valueOf(300L);
        STATISTIC_DEFULT_UNWIFIREPORT_SIZE = Long.valueOf(0L);
        TABLE_NAME_LIST = new String[] { "exception", "statistic" };
        LOGSWITCH = false;
    }

    public static void commonUtilLog(String paramString1, String paramString2)
    {
    }

    public static CommonUtil getCommonUtilInstance()
    {
        if (commonUtilInstance == null)
            commonUtilInstance = new CommonUtil();
        return commonUtilInstance;
    }

    public static String getCurrentMicrosecond()
    {
        return String.format("%.6f", new Object[] { Double.valueOf((System.currentTimeMillis() + 0.0D) / 1000.0D) });
    }

    public static boolean isNumeric(String paramString)
    {
        paramString = paramString.trim();
        return Pattern.compile("[0-9]*").matcher(paramString).matches();
    }

    public static Long parseLongPositive(String paramString, Long paramLong)
    {
        Long l = null;
        if (isNumeric(paramString)){
            try
            {
            l = Long.valueOf(Long.parseLong(paramString));
            }
            catch (Exception e)
            {
                    e.printStackTrace();
            }
            if (l.longValue() >= 0L)
                paramLong = l;
        }
        return paramLong;
    }
}
