package com.zy.app.mall.category.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.zy.app.mall.category.fragment.ScrollTabHolderFragment;

/**
 * Created by Robin on 2016/8/20.
 */
public abstract class ScrollTabHolderListFragment extends ScrollTabHolderFragment {
    private static final boolean a = Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11 ? true: false;
    private boolean b = false;
    private boolean c = false;
    private int d = 0;
    private int e = 0;
    protected ListView p;
    protected int q = -1;

    public static void a(Bundle paramBundle, int paramInt)
    {
        if (paramBundle != null)
            paramBundle.putInt("position", paramInt);
    }

    protected BaseAdapter a()
    {
        return null;
    }

    public final void a(int paramInt)
    {
        if (-1 == this.q)
            return;
        FrameLayout localFrameLayout = new FrameLayout(getContext());
        localFrameLayout.setPadding(0, paramInt, 0, 0);
        localFrameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));//17170445
        this.p.addHeaderView(localFrameLayout);
    }

    public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
    {
    }

    public final void b(int paramInt)
    {
        if ((paramInt == 0) && (this.p.getFirstVisiblePosition() > 0))
            return;
        this.p.setSelectionFromTop(1, paramInt);
    }

    protected void b(boolean paramBoolean)
    {
        BaseAdapter localBaseAdapter = a();
        if ((this.p.getAdapter() == null) && (localBaseAdapter != null))
        {
            this.p.setAdapter(localBaseAdapter);
            localBaseAdapter.notifyDataSetChanged();
        }
        this.p.setSelectionFromTop(this.d, this.e);
    }

    public void onActivityCreated(Bundle paramBundle)
    {
        super.onActivityCreated(paramBundle);
        this.p.setOnScrollListener(new AbsListView.OnScrollListener(){//ah(this)
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (ScrollTabHolderListFragment.this.o != null)
                    ScrollTabHolderListFragment.this.o.a(absListView, i, ScrollTabHolderListFragment.this.q);
                ScrollTabHolderListFragment.this.synthetic_a(absListView);
                ScrollTabHolderListFragment.this.a(absListView, i, ScrollTabHolderListFragment.this.q);
            }
        });
        if (a)
            this.p.setOnTouchListener(new View.OnTouchListener(){//ag(this)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (ScrollTabHolderListFragment.this.o != null)
                        ScrollTabHolderListFragment.this.o.a(ScrollTabHolderListFragment.this.p, 0, ScrollTabHolderListFragment.this.q);
                    return false;
                }
            });
    }

    private void synthetic_a(AbsListView paramAbsListView)
    {
        View localView = paramAbsListView.getChildAt(0);
        if (localView == null)
            return;
        this.e = localView.getTop();
        this.d = paramAbsListView.getFirstVisiblePosition();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        this.b = true;
    }

    public void onPause()
    {
        super.onPause();
        this.c = true;
    }

    public void onResume()
    {
        super.onResume();
        if (this.c)
        {
            b(this.b);
            this.c = false;
            this.b = false;
        }
    }
}
