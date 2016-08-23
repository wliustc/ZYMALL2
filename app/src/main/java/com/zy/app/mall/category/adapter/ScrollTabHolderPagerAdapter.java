package com.zy.app.mall.category.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

import com.jingdong.app.mall.category.view.ScrollTabHolder;
import com.zy.app.mall.category.fragment.ScrollTabHolderFragment;

/**
 * Created by robin on 16-8-22.
 */
public abstract class ScrollTabHolderPagerAdapter extends FragmentPagerAdapter {
    private SparseArrayCompat<ScrollTabHolder._I> a = new SparseArrayCompat();
    private ScrollTabHolder._I b;

    public ScrollTabHolderPagerAdapter(FragmentManager paramFragmentManager)
    {
        super(paramFragmentManager);
    }

    public final SparseArrayCompat<ScrollTabHolder._I> a()
    {
        return this.a;
    }

    public abstract ScrollTabHolderFragment a(int paramInt);

    public void a(int paramInt, ScrollTabHolderFragment paramScrollTabHolderFragment)
    {
    }

    public final void a(ScrollTabHolder._I parami)
    {
        this.b = parami;
    }

    public Fragment getItem(int paramInt)
    {
        ScrollTabHolderFragment localScrollTabHolderFragment = a(paramInt);
        this.a.put(paramInt, localScrollTabHolderFragment);
        if (this.b != null)
            localScrollTabHolderFragment.a(this.b);
        return localScrollTabHolderFragment;
    }

    public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
        super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
        a(paramInt, (ScrollTabHolderFragment)paramObject);
    }
}
