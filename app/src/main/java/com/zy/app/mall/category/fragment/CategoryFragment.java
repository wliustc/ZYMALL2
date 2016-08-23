package com.zy.app.mall.category.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.zy.app.mall.R;
import com.zy.app.mall.category.fragment.ScrollTabHolderListFragment;

/**
 * Created by Robin on 2016/8/20.
 */
public class CategoryFragment extends ScrollTabHolderListFragment {
    protected BaseAdapter a = null;
    protected int b;
    private View c = null;
    private boolean d = false;

    protected View a(LayoutInflater paramLayoutInflater)
    {
        return null;
    }

    public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
    {
        this.b = (paramInt1 - 1);
        if (paramInt1 == 0)
        {
            this.c.setVisibility(View.GONE);
            return;
        }
        this.c.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityCreated(Bundle paramBundle)
    {
        super.onActivityCreated(paramBundle);
        if ((this.p.getAdapter() == null) && (this.a != null))
            this.p.setAdapter(this.a);
        this.d = true;
    }

    @Override
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.q = -1;
        if (paramBundle != null)
            this.q = paramBundle.getInt("position");
        return;
    }

    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View view = a(paramLayoutInflater);
        a(getResources().getDimensionPixelSize(R.dimen.header_height));//2131035570
        this.c = view.findViewById(R.id.list_to_top);//2131166211
        this.c.setOnClickListener(new View.OnClickListener(){//a(this)
            @Override
            public void onClick(View view) {
                if (CategoryFragment.this.p.getSelectedItemPosition() != 0)
                    CategoryFragment.this.p.setSelection(0);
            }
        });
        return view;
    }

    @Override
    public View onCreateViews(LayoutInflater paramLayoutInflater, Bundle paramBundle)
    {
        setIsUseBasePV(false);
        return onCreateView(paramLayoutInflater, null, paramBundle);
    }

    @Override
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        return false;
    }
}
