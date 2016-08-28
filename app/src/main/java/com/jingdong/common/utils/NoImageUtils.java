package com.jingdong.common.utils;

import android.widget.ImageView;

import com.jingdong.common.BaseApplication;
import com.zy.app.mall.R;
import com.zy.common.frame.IMyActivity;
import com.zy.common.res.StringUtil;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.NetUtils;

/**
 * Created by Robin on 2016/6/5.
 */
//em
public class NoImageUtils {
//    public static void a(IMyActivity paramIMyActivity, HttpGroup paramHttpGroup, ImageView paramImageView, String paramString, boolean paramBoolean)
//    {
//        if (paramBoolean)
//            paramIMyActivity.addResumeListener(new en(paramIMyActivity, paramHttpGroup, paramImageView, paramString));
//        if (a())
//            paramImageView.setOnLongClickListener(new eo(paramIMyActivity, paramHttpGroup, paramImageView, paramString));
//        while (true)
//        {
//            a(false, paramIMyActivity, paramHttpGroup, paramImageView, paramString);
//            return;
//            paramImageView.setOnLongClickListener(null);
//            paramImageView.setLongClickable(false);
//        }
//    }
//
//    public static void a(boolean paramBoolean, IMyActivity paramIMyActivity, HttpGroup paramHttpGroup, ImageView paramImageView, String paramString)
//    {
//        if ((!paramBoolean) && (a()));
//        for (paramBoolean = true; ; paramBoolean = false)
//        {
//            paramIMyActivity = new ep(paramIMyActivity, paramImageView, paramBoolean);
//            paramImageView = new HttpGroup.HttpSetting();
//            paramImageView.setType(5000);
//            paramImageView.setUrl(paramString);
//            paramImageView.setListener(paramIMyActivity);
//            if (paramBoolean)
//                paramImageView.setCacheMode(1);
//            paramHttpGroup.add(paramImageView);
//            return;
//        }
//    }

    public static boolean a()
    {
        String str = BaseApplication.getInstance().getResources().getString(R.string.no_image_switch_key);
        boolean i = false;
        if (CommonUtil.getJdSharedPreferences().getBoolean(str, false))
        {
            i = false;
            if (!NetUtils.isWifiForLoadImage())
                i = true;
        }
        return i;
    }
}
