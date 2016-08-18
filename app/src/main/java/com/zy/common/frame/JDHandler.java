package com.zy.common.frame;

import android.os.Handler;
import android.os.Message;

import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/6.
 */
//public class f extends Handler
public class JDHandler extends Handler {
    @Override
    public void dispatchMessage(Message msg)
    {
        try
        {
            super.dispatchMessage(msg);
            return;
        }
        catch (java.lang.Throwable error)
        {
            if(!Log.E)
                error.printStackTrace();
        }
    }
}
