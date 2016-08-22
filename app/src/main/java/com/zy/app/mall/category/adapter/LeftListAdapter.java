package com.zy.app.mall.category.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zy.app.mall.R;
import com.zy.common.entity.Catelogy;

import java.util.ArrayList;

/**
 * Created by robin on 16-8-19.
 */
//c
public class LeftListAdapter extends BaseAdapter {
    private ArrayList<Catelogy> a;
    private Context b;
    private int c;
    private ILeftAdapterListener d;

    public LeftListAdapter(ArrayList<Catelogy> paramArrayList, Context paramContext)
    {
        this.a = paramArrayList;
        this.b = paramContext;
    }

    public final void a(int paramInt)
    {
        this.c = paramInt;
    }

    public final void a(ILeftAdapterListener parama)
    {
        this.d = parama;
    }

    public final int getCount()
    {
        return this.a.size();
    }

    public final Object getItem(int paramInt)
    {
        return null;
    }

    public final long getItemId(int paramInt)
    {
        return 0L;
    }

    @SuppressLint({"ResourceAsColor"})
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        View localView = null;
        LeftListViewHolder holder = null;
        if (paramView == null) {//if-nez p2, :cond_0
            localView = LayoutInflater.from(this.b).inflate(R.layout.category_new_text_item, null);//2130903256
            holder = new LeftListViewHolder();
            holder.mText = ((TextView) localView.findViewById(R.id.text));//2131166233
            localView.setTag(holder);
        } else
            holder = (LeftListViewHolder) paramView.getTag();

        if (paramInt == this.c) {
            this.d.a(localView);
            localView.setBackgroundResource(R.drawable.category_new_left_facous);//2130838453
            holder.mText.setTextColor(this.b.getResources().getColor(R.color.category_new_red_font));//2131099877
        } else {
            localView.setBackgroundResource(R.drawable.category_new_left_normal);//2130838454
            holder.mText.setTextColor(this.b.getResources().getColor(R.color.category_new__dark_font));//2131099873
        }

        holder.mText.setText(((Catelogy) this.a.get(paramInt)).getName());
        return localView;

    }

    public static class LeftListViewHolder{
        public TextView mText;
    }
}
