package com.zy.app.mall.category.c;

import android.content.Context;

import com.zy.common.ui.CameraUtils;
import com.zy.common.utils.SDKUtils;

/**
 * Created by robin on 16-8-19.
 */
//a
public class CatelogyUtil {
    public static boolean a(Context paramContext)
    {
        if (SDKUtils.b())
            return CameraUtils.a(paramContext);
        return true;
    }
}
