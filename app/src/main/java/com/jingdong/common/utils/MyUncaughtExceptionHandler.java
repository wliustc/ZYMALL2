package com.jingdong.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Process;

import com.jingdong.common.BaseApplication;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.Log;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Robin on 2016/11/2.
 */
//do
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    private static Queue<String> c = new LinkedList();
    private static StringBuffer d = new StringBuffer();
    private static String e = null;
    private Context a;
    private Thread.UncaughtExceptionHandler b;

    public MyUncaughtExceptionHandler(Context paramContext)
    {
        this.a = paramContext;
        this.b = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static String a()
    {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("page info:");
        LinkedList localLinkedList = (LinkedList)c;
        if (localLinkedList == null)
            return "";
        int j = localLinkedList.size();
        if (j <= 0)
            return "";
        int i = 0;
        while (i < j - 1)
        {
            localStringBuffer.append((String)localLinkedList.get(i) + ">>");
            i += 1;
        }
        localStringBuffer.append((String)localLinkedList.get(j - 1) + "\n");
        localStringBuffer.append(e);
        return localStringBuffer.toString();
    }

    public static void a(String paramString1, String paramString2)
    {
        try
        {
            if (c.size() >= 5)
                c.poll();
            c.offer(paramString2);
            d.setLength(0);
            e = paramString1;
            return;
        }
        catch (Throwable e)
        {
                if (Log.D)
                e.printStackTrace();
        }
    }

    private boolean a(Throwable paramThrowable)
    {
//        Object localObject = BaseApplication.getInstance().getCurrentMyActivity();
//        if (localObject != null)
//        {
//            if (Log.D)
//                Log.d("MyUncaughtExceptionHandler", "myActivity!= null 将其finish掉了");
//            ((IMyActivity)localObject).post(new dp(this, (IMyActivity)localObject));
//        }
//        while (true)
//        {
//            int i;
//            try
//            {
//                d.append("page info:");
//                int j = c.size();
//                i = 0;
//                if (i < j)
//                {
//                    if (i >= j - 1)
//                        continue;
//                    d.append((String)c.poll() + ">>");
//                    break label303;
//                    d.append((String)c.poll() + "\n");
//                }
//            }
//            catch (Throwable paramThrowable)
//            {
//                paramThrowable.printStackTrace();
//                System.exit(0);
//                return true;
//            }
//            d.append(e);
//            localObject = new Intent();
//            ((Intent)localObject).putExtra("user", StatisticsReportUtil.getReportString(true));
//            ((Intent)localObject).putExtra("currentPageInfo", d.toString());
//            ((Intent)localObject).putExtra("crashStack", a.a(paramThrowable));
//            try
//            {
//                ((Intent)localObject).putExtra("MemInfo", i.a());
//                if (BaseApplication.getInstance().isBackstage())
//                {
//                    ((Intent)localObject).setClass(this.a, CrashService.class);
//                    this.a.startService((Intent)localObject);
//                    return true;
//                }
//            }
//            catch (Throwable paramThrowable)
//            {
//                while (true)
//                {
//                    if (!Log.D)
//                        continue;
//                    paramThrowable.printStackTrace();
//                }
//                ((Intent)localObject).setFlags(268435456);
//                ((Intent)localObject).setClass(this.a, BaseApplication.getInstance().getErrorActivityClass());
//                this.a.startActivity((Intent)localObject);
//                return true;
//            }
//            label303: i += 1;
//        }
        return true;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        ex.printStackTrace();
        a(ex);
        Process.killProcess(Process.myTid());
        System.exit(0);
    }
}
