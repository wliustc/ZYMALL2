package com.zy.app.mall.category.fragment;

import com.jingdong.app.mall.category.view.ScrollTabHolder;
import com.zy.cleanmvp.ui.BaseFragment;

/**
 * Created by Robin on 2016/8/20.
 */
public abstract class ScrollTabHolderFragment extends BaseFragment
        implements ScrollTabHolder._I {
    protected ScrollTabHolder._I o;

    public final void a(ScrollTabHolder._I parami)
    {
        this.o = parami;
    }
}
