package com.zy.app.mall.home.floor.b;

import java.util.Observable;

/**
 * Created by Robin on 2016/5/8.
 */
//public final class a extends Observable
public class FloorFigureViewCtrl extends Observable {
    private static FloorFigureViewCtrl a = null;
    public enum b{PAUSEALL, RESUMEALL}

    //a
    public static  FloorFigureViewCtrl getInstance()
    {
        if (a == null)
            synchronized(FloorFigureViewCtrl.class){
                if (a == null)
                    a = new FloorFigureViewCtrl();
            }

        return a;
    }

    public static void b()
    {
        if (a != null)
            a = null;
    }

    public final void c()
    {
        setChanged();
        notifyObservers(b.PAUSEALL);
    }

    public final void d()
    {
        setChanged();
        notifyObservers(b.RESUMEALL);
    }
}
