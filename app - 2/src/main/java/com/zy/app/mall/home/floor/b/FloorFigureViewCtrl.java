package com.zy.app.mall.home.floor.b;

import java.util.Observable;

/**
 * Created by Robin on 2016/5/8.
 */
//public final class a extends Observable
public class FloorFigureViewCtrl extends Observable {
    private static FloorFigureViewCtrl a = null;
    enum b{PAUSEALL, RESUMEALL}
    public static synchronized FloorFigureViewCtrl getInstance()
    {
        if (a == null)
            a = new FloorFigureViewCtrl();
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
