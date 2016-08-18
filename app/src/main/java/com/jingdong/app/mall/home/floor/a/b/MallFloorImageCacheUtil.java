package com.jingdong.app.mall.home.floor.a.b;

import android.util.Pair;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/5/23.
 */
//h
public class MallFloorImageCacheUtil {
    protected ArrayList<Pair<SimpleDraweeView, String>> a = new ArrayList();

    public final SimpleDraweeView a(int paramInt)
    {
        if (this.a.size() <= paramInt)
            return null;
        Pair localPair = (Pair)this.a.get(paramInt);
        if (localPair == null)
            return null;
        return (SimpleDraweeView)localPair.first;
    }

    public final void a(SimpleDraweeView paramSimpleDraweeView, String paramString, int paramInt)
    {
        if (this.a.size() < paramInt)
            return;
        Pair pair = new Pair(paramSimpleDraweeView, paramString);
        if (this.a.size() == paramInt)
            this.a.add(pair);
        else
            this.a.set(paramInt, pair);
    }

    public final void b(int paramInt)
    {
        if (this.a.size() > paramInt)
            this.a.set(paramInt, null);
    }
}
