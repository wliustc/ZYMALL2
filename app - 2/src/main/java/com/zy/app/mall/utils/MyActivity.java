package com.zy.app.mall.utils;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.zy.common.BaseActivity;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/14.
 */
@SuppressLint({"NewApi"})
public class MyActivity extends BaseActivity {
    private static final String TAG = MyActivity.class.getSimpleName();
    protected void onCreate(Bundle paramBundle)
    {
        if (Log.D)
        {
            Log.d(TAG, "onCreate() TaskId = " + getTaskId() + " -->> " + getClass().getName());
            Log.d(TAG, "onCreate() -->> getIntent : " + getIntent());
        }
        super.onCreate(paramBundle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onResume()
    {
        super.onResume();
    }
}
