package com.zy.app.mall.aura.internal;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Robin on 2016/11/3.
 */
//d
public class SequenceExecutor implements Runnable{
    private Queue<Runnable> a;
    private boolean b = false;
    private String c;

    public SequenceExecutor(String paramString)
    {
        this.c = paramString;
    }

    public synchronized final void a(Runnable paramRunnable)
    {

            if (this.a == null)
                this.a = new ConcurrentLinkedQueue();
            this.a.add(paramRunnable);
            if (!this.b)
            {
                this.b = true;
                new Thread(this).start();
            }
            return;
    }

    public synchronized final void run()
    {

            Runnable localRunnable = null;

                if (this.a != null)
                    localRunnable = (Runnable)this.a.poll();
                if (localRunnable == null)
                {
                    this.b = false;
                    return;
                }else{
                    try
                    {
                        localRunnable.run();
                    }
                    catch (Exception localException)
                    {
                        localException.printStackTrace();
                    }
                }
    }

}
