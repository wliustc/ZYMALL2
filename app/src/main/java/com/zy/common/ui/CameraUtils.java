package com.zy.common.ui;

import android.annotation.SuppressLint;
import android.content.Context;

import com.zy.common.utils.SDKUtils;

/**
 * Created by Robin on 2016/5/16.
 */
public class CameraUtils {
    @SuppressLint({"NewApi"})
    public static boolean a(Context paramContext)
    {
        return (!SDKUtils.b()) || (paramContext.getPackageManager().hasSystemFeature("android.hardware.camera"));
    }
}
