package com.jingdong.app.mall.utils;

import com.jingdong.app.mall.MainFrameActivity;
import com.jingdong.common.utils.CommonBase;
import com.zy.common.frame.IMyActivity;

import java.util.prefs.Preferences;

/**
 * Created by Robin on 2016/5/16.
 */
public class CommonUtil  extends CommonBase {

    private static final String TAG = "CommonUtil";
    private static CommonUtil commonUtil;
    private static long lastToClientTimeMillis;
    private static String mAction = "";
    private long lastTounionAndWeiXinPayTimeMillis;
    private String tn;

    public static CommonUtil getInstance()
    {
        if (commonUtil == null)
            synchronized (CommonUtil.class){
                if (commonUtil == null)
                    commonUtil = new CommonUtil();
            }
        return commonUtil;
    }
    @Override
    public void goToShoppingCartPage(IMyActivity paramIMyActivity, boolean paramBoolean) {

    }

    @Override
    public void goToShoppingCartPageSingle(IMyActivity paramIMyActivity) {

    }
}
