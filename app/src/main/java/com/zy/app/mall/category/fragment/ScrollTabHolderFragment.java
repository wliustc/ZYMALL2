package com.zy.app.mall.category.fragment;

import com.zy.app.mall.category.view.ScrollTabHolder;
import com.zy.cleanmvp.ui.BaseFragment;

/**
 * Created by Robin on 2016/8/20.
 */
public abstract class ScrollTabHolderFragment extends BaseFragment
        implements ScrollTabHolder {
    protected ScrollTabHolder o;

    public final void a(ScrollTabHolder parami)
    {
        this.o = parami;
    }
}
