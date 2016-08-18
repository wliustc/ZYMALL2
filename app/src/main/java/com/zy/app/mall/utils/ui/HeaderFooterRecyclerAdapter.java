package com.zy.app.mall.utils.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by robin on 16-7-28.
 */
public abstract class HeaderFooterRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private View a;
    private View b;
    private final int c = 10001;
    private final int d = 10002;

    public abstract int a();

    public abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup);

    public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);

    public final void a(View paramView)
    {
        this.b = paramView;
    }

    public final View e()
    {
        return this.b;
    }

    public final int getItemCount() {
        int i = 0;
        int j = 0;
        int k = a();
        if (this.a != null)
            i = 1;
        if (this.b != null)
            j = 1;
        return i + k + j;
    }

    public final int getItemViewType(int paramInt)
    {
        if ((paramInt == 0) && (this.a != null))
            return 10001;
        if ((paramInt == getItemCount() - 1) && (this.b != null))
            return 10002;
        return 1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
        if (paramViewHolder == null)
            return;
        switch (getItemViewType(paramInt))
        {
            case 10001:
            case 10002:
                return;
        }
        int i = 0;
        if (this.a != null)
            i = 1;
            a(paramViewHolder, paramInt - i);
            return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
        switch (paramInt)
        {
            default:
                return a(paramViewGroup);
            case 10001:
                return new HeaderFooterRecyclerAdapter.SimpleViewHolder(this, this.a);
            case 10002:
        }
        return new HeaderFooterRecyclerAdapter.SimpleViewHolder(this, this.b);
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder
    {
        public SimpleViewHolder(HeaderFooterRecyclerAdapter paramHeaderFooterRecyclerAdapter, View paramView)
        {
            super(paramView);
        }
    }
}
