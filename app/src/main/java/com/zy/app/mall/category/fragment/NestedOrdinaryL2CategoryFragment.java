package com.zy.app.mall.category.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jingdong.app.mall.category.fragment.OrdinaryL2CategoryFragment;
import com.zy.app.mall.R;
import com.zy.app.mall.category.view.CategoryFooter;
import com.zy.common.utils.JDImageUtils;

/**
 * Created by robin on 16-8-22.
 */
public class NestedOrdinaryL2CategoryFragment extends OrdinaryL2CategoryFragment {

    private String r = null;
    private String s = null;
    private ImageView t = null;
    private _M u = null;

    public static Fragment a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
        NestedOrdinaryL2CategoryFragment localNestedOrdinaryL2CategoryFragment = new NestedOrdinaryL2CategoryFragment();
        Bundle localBundle = new Bundle();
        localBundle.putCharSequence("level_first", paramString1);
        localBundle.putCharSequence("catalog_sort_event_id", paramString2);
        localBundle.putInt("current_item", paramInt1);
        a(localBundle, paramInt2);
        localNestedOrdinaryL2CategoryFragment.setArguments(localBundle);
        return localNestedOrdinaryL2CategoryFragment;
    }

    protected final View a(LayoutInflater paramLayoutInflater) {
        View paramLayout = paramLayoutInflater.inflate(R.layout.category_fragment, null);//2130903249
        final PullToRefreshListView localPullToRefreshListView = (PullToRefreshListView) paramLayout.findViewById(R.id.listView);//2131165251
        localPullToRefreshListView.setMode(PullToRefreshBase.Mode.DISABLED);
        if (!TextUtils.isEmpty(this.s)) {
            localPullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
            localPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {//g(this, localPullToRefreshListView)
                @Override
                public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                    localPullToRefreshListView.onRefreshComplete();
                    if (NestedOrdinaryL2CategoryFragment.this.u != null)
                        NestedOrdinaryL2CategoryFragment.this.post(new Runnable() {//h(this)
                            @Override
                            public void run() {
                                NestedOrdinaryL2CategoryFragment.this.u.a(NestedOrdinaryL2CategoryFragment.this.q);
                            }
                        });
                }
            });
        }
        this.p = ((ListView) localPullToRefreshListView.getRefreshableView());
        this.p.setSelector(android.R.color.transparent);//17170445
        return paramLayout;
    }

    public final void a(ImageView paramImageView) {
        this.t = paramImageView;
    }

    public final void a(_M paramm) {
        this.u = paramm;
    }

    protected final void a(final String paramString) {
        if ((paramString == null) || (paramString.equals(this.n)))
            return;
        post(new Runnable() {//i(this, paramString)
            @Override
            public void run() {
                if (NestedOrdinaryL2CategoryFragment.this.isAdded())
                    JDImageUtils.displayImage(paramString, NestedOrdinaryL2CategoryFragment.this.t);
            }
        });
    }

    public final void b(String paramString) {
        this.r = paramString;
    }

    public final void c() {
        this.n = null;
    }

    public final void c(String paramString) {
        this.s = paramString;
    }

    private static View synthetic_a(final NestedOrdinaryL2CategoryFragment paramNestedOrdinaryL2CategoryFragment, int paramInt, View paramView, ViewGroup paramViewGroup) {
        Holder holder = null;
        if ((paramView == null) || (paramView.getTag() == null)) {//if-eqz p2, :cond_0   if-nez v0, :cond_1
            holder = new Holder();
            paramView = LayoutInflater.from(paramNestedOrdinaryL2CategoryFragment.getContext()).inflate(R.layout.level_2_category_footer, null);//2130903821
            holder.a = ((TextView) paramView.findViewById(R.id.footer_text));//2131169924
            paramView.setTag(holder);
        } else {
            holder = (Holder) paramView.getTag();

        }

        final Holder finalHolder = holder;
        paramNestedOrdinaryL2CategoryFragment.thisActivity.runOnUiThread(new Runnable() {//l(paramNestedOrdinaryL2CategoryFragment, holder)
            @Override
            public void run() {
                finalHolder.a.setText("上拉继续浏览 " + paramNestedOrdinaryL2CategoryFragment.s);
            }
        });
        return paramView;
    }

    protected final void d() {
        super.d();
        if (!TextUtils.isEmpty(this.s))
            this.g.a(new CategoryFooter() {//k(this)
                @Override
                public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
                    return NestedOrdinaryL2CategoryFragment.synthetic_a(NestedOrdinaryL2CategoryFragment.this, paramInt, paramView, paramViewGroup);
                }
            });
    }

    public final void d(String paramString) {
        this.t.setOnClickListener(new View.OnClickListener() {//j(this)
            @Override
            public void onClick(View v) {
                NestedOrdinaryL2CategoryFragment.this.b();
            }
        });
        super.d(paramString);
    }

    public interface _M {
        public abstract void a(int paramInt);
    }

    public static class Holder {
        TextView a;
    }
}
