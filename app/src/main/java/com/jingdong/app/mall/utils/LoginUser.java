package com.jingdong.app.mall.utils;

import com.zy.app.mall.home.JDHomeFragment;
import com.zy.common.BaseActivity;
import com.zy.common.frame.IMyActivity;

/**
 * Created by Robin on 2016/5/16.
 */
public class LoginUser {
    private static LoginUser loginUser;
    private static String loginName;

    public static boolean hasLogin() {
        return false;
    }

    public static LoginUser getInstance() {
        if (loginUser == null)
            synchronized (LoginUser.class){
                if (loginUser == null)
                    loginUser = new LoginUser();
            }
        return loginUser;
    }

    public static String getLoginName() {
        return loginName;
    }

    public void homeAutoLogin(IMyActivity thisActivity, JDHomeFragment jdHomeFragment, int i1) {
    }

    public void executeLoginRunnable(BaseActivity p, Runnable title) {
    }
}
