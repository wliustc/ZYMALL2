package com.jingdong.common.utils;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;

import com.jingdong.common.BaseApplication;
import com.zy.common.res.StringUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/11/13.
 */
public class BitmapkitUtils {
    public static final String API_KEY = "XJgK2J9rXdmAH37ilm";
    private static final int RETRY_TIMES = 3;
    public static Application a;
    private static boolean b = false;
    public static boolean isBMPLoad = false;

    public static native String a(String[] paramArrayOfString);

    public static native byte[] encodeJni(byte[] paramArrayOfByte, boolean paramBoolean);

    public static boolean isFuncAvailable()
    {
        loadBMP();
        return b;
    }

    public static void loadBMP()
    {
        monitorenter;
        try
        {
            if (!b)
            {
                boolean bool = isBMPLoad;
                if (!bool)
                    break label21;
            }
            while (true)
            {
                return;
                try
                {
                    label21: System.loadLibrary("jdbitmapkit");
                    b = true;
                    isBMPLoad = true;
                }
                catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
                {
                    localUnsatisfiedLinkError.printStackTrace();
                }
                if (!localUnsatisfiedLinkError.getMessage().contains("unknown failure"))
                    continue;
                b = false;
                isBMPLoad = true;
            }
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    public void actionClose()
    {
        BaseApplication.exitAll();
    }

    public void actionFeedbackWebsite(c paramc)
    {
        if (Log.D)
            Log.d("Temp", "actionFeedbackWebsite -->> ");
        Uri localUri = Uri.parse("http://m.jd.com/showvote.html");
        paramc.n().startActivityForResultNoExceptionStatic(paramc.getThisActivity(), new Intent("android.intent.action.VIEW", localUri), 1);
        BaseApplication.exitAll();
    }

    public void alertLoadlibFailedDialog(Handler paramHandler)
    {
        if (Log.D)
            Log.d("HttpGroup", "id:- alertErrorDialog() -->> ");
        c localc = BaseApplication.getInstance().getMainFrameActivity();
        s locals = new s(this, localc);
        locals.setTitle(StringUtil.prompt);
        locals.setMessage(StringUtil.comment_feedback);
        locals.setPositiveButton(StringUtil.label_feedback);
        locals.setNegativeButton(StringUtil.app_error_close);
        locals.init(localc.getThisActivity());
        paramHandler.post(new t(this, locals));
    }
}
