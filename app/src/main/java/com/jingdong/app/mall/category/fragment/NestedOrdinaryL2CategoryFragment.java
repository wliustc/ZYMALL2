package com.jingdong.app.mall.category.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by robin on 16-8-22.
 */
public class NestedOrdinaryL2CategoryFragment extends OrdinaryL2CategoryFragment{

    private String r = null;
    private String s = null;
    private ImageView t = null;
    private _M u = null;

    public static Fragment a(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
        NestedOrdinaryL2CategoryFragment localNestedOrdinaryL2CategoryFragment = new NestedOrdinaryL2CategoryFragment();
        Bundle localBundle = new Bundle();
        localBundle.putCharSequence("level_first", paramString1);
        localBundle.putCharSequence("catalog_sort_event_id", paramString2);
        localBundle.putInt("current_item", paramInt1);
        a(localBundle, paramInt2);
        localNestedOrdinaryL2CategoryFragment.setArguments(localBundle);
        return localNestedOrdinaryL2CategoryFragment;
    }

    protected final View a(LayoutInflater paramLayoutInflater)
    {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903249, null);
        PullToRefreshListView localPullToRefreshListView = (PullToRefreshListView)paramLayoutInflater.findViewById(2131165251);
        localPullToRefreshListView.setMode(PullToRefreshBase.Mode.DISABLED);
        if (!TextUtils.isEmpty(this.s))
        {
            localPullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
            localPullToRefreshListView.setOnRefreshListener(new g(this, localPullToRefreshListView));
        }
        this.p = ((ListView)localPullToRefreshListView.getRefreshableView());
        this.p.setSelector(17170445);
        return paramLayoutInflater;
    }

    public final void a(ImageView paramImageView)
    {
        this.t = paramImageView;
    }

    public final void a(_M paramm)
    {
        this.u = paramm;
    }

    protected final void a(String paramString)
    {
        if ((paramString == null) || (paramString.equals(this.n)))
            return;
        post(new i(this, paramString));
    }

    public final void b(String paramString)
    {
        this.r = paramString;
    }

    public final void c()
    {
        this.n = null;
    }

    public final void c(String paramString)
    {
        this.s = paramString;
    }

    protected final void d()
    {
        super.d();
        if (!TextUtils.isEmpty(this.s))
            this.g.a(new k(this));
    }

    public final void d(String paramString)
    {
        this.t.setOnClickListener(new j(this));
        super.d(paramString);
    }

    public abstract interface _M
    {
        public abstract void a(int paramInt);
    }
}
