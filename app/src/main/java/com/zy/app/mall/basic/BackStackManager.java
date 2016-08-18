package com.zy.app.mall.basic;

import com.zy.common.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/5/19.
 */
//m
public class BackStackManager {
    private static final String TAG = BackStackManager.class.getSimpleName();
    private static BackStackManager instance;
    private List<JDTaskModule> c = new ArrayList();
    private JDTaskModule d;
    private JDTaskModule e;

    public static BackStackManager getInstance()
    {
        if (instance == null)
            synchronized (BackStackManager.class){
                if (instance == null)
                    instance = new BackStackManager();
            }
        return instance;
    }

    private void b(JDTaskModule paramJDTaskModule)
    {
        this.c.add(paramJDTaskModule);
        if (Log.D)
            Log.d(TAG, "push() history add size = " + c());
    }

    public final void a(JDTaskModule paramJDTaskModule)
    {
        if (Log.D)
            Log.d(TAG, "setCurrent()");
        this.e = this.d;
        if ((this.d != null) && (this.d.isInHistory()))
            b(this.d);
        if ((paramJDTaskModule.isNoShowAgain()) && (this.e != null))
            b(this.e);
        this.d = paramJDTaskModule;
    }

    public final void b()
    {
        this.c.clear();
    }

    public final int c()
    {
        return this.c.size();
    }

    public final JDTaskModule d()
    {
        return this.d;
    }
}
