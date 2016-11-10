package com.jingdong.app.mall.basic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jingdong.app.mall.MyApplication;
import com.zy.app.mall.MainFrameActivity;
import com.zy.app.mall.basic.BackStackManager;
import com.zy.app.mall.basic.JDTaskModule;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/14.
 */
//l
public class ApplicationManager {
    public static int a = -1;
    private static final BackStackManager b = BackStackManager.getInstance();
    private static final MainFrameActivity c = MyApplication.getInstance().getMainFrameActivity();
    private static FragmentManager fragmentManager;//d

    public static void a() {
        try
        {
            b.b();
            c.b.b();
            if (Log.D)
                Log.d("ApplicationManager", "clearBackStack() -->>> backStackManager.size() -->> " + b.c() + " manager.getBackStackEntryCount() = " + fragmentManager.getBackStackEntryCount());
            if (fragmentManager.getBackStackEntryCount() > 0)
                fragmentManager.popBackStackImmediate(null, 1);
            if (Log.D)
                Log.d("ApplicationManager", "clearBackStack() -->>> manager.getBackStackEntryCount() = " + fragmentManager.getBackStackEntryCount());
            return;
        }
        catch (Exception localException)
        {
                if (Log.D)
                    localException.printStackTrace();

        }
    }

    public static void a(Fragment paramFragment)
    {
        if (paramFragment != null);
        try
        {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(paramFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);//4099
            transaction.commitAllowingStateLoss();
            return;
        }
        catch (Exception e)
        {
            if (Log.D)
                e.printStackTrace();
        }
    }

    public static void a(FragmentManager paramFragmentManager)
    {
        fragmentManager = paramFragmentManager;
    }

    public static void a(JDTaskModule taskModule)
    {
        if (Log.D)
            Log.d("ApplicationManager", "go() -->> taskModule:" + taskModule);
        taskModule.setPrev(b.d());
        if (!taskModule.premise())
            return;
        b.a(taskModule);
        if (taskModule.isNeedClearBackStack())
        {
            if (Log.D)
                Log.d("ApplicationManager", "go() -->> taskModule.isNeedClearBackStack:true");
            taskModule.setPrev(null);
            a();
        }
        taskModule.init();
        taskModule.show();
        a(taskModule, "go");
    }

    private static void a(JDTaskModule paramJDTaskModule, String paramString)
    {
//        if (paramJDTaskModule == null)
//            return;
//        StringBuffer localStringBuffer;
//        while (true)
//        {
//            Object localObject;
//            try
//            {
//                localObject = paramJDTaskModule.getPrev();
//                localStringBuffer = new StringBuffer();
//                if (localObject == null)
//                    break label204;
//                localStringBuffer.append("；prev：" + paramJDTaskModule.getPrev().getClass().getSimpleName());
//                localStringBuffer.append("；goOrBack：" + paramString);
//                localStringBuffer.append("；intent content:");
//                localObject = paramJDTaskModule.getBundle();
//                if (localObject == null)
//                    break label226;
//                Iterator localIterator = ((Bundle)localObject).keySet().iterator();
//                if (!localIterator.hasNext())
//                    break label226;
//                paramString = (String)localIterator.next();
//                if ("productList".equals(paramString))
//                    continue;
//                localStringBuffer.append(paramString + "：");
//                if (((Bundle)localObject).get(paramString) != null)
//                    break label214;
//                paramString = "<null>";
//                localStringBuffer.append(paramString + "，");
//                continue;
//            }
//            catch (Throwable paramJDTaskModule)
//            {
//            }
//            if (!Log.D)
//                break;
//            paramJDTaskModule.printStackTrace();
//            return;
//            label204: localStringBuffer.append("；prev：null");
//            continue;
//            label214: paramString = ((Bundle)localObject).get(paramString).toString();
//        }
//        label226: if (Log.D)
//            Log.i("ApplicationManager", localStringBuffer.toString());
//        do.a(localStringBuffer.toString(), paramJDTaskModule.getClass().getSimpleName());
    }
}
