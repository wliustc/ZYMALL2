package com.jingdong.app.mall.category.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jingdong.app.mall.category.view.ParallaxHeaderHelper;
import com.jingdong.common.BaseActivity;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.cleanmvp.ui.BaseFragment;
import com.zy.common.entity.Catelogy;
import com.zy.common.utils.JDMtaUtils;

import java.util.List;

/**
 * Created by Robin on 2016/8/20.
 */
public class ConjoinedCategoryFragment extends BaseFragment implements NestedOrdinaryL2CategoryFragment._M, ParallaxHeaderHelper._H {
    protected int a = -1;
    protected String b;
    protected String c = null;
    protected View d;
    protected ImageView e;
    private List<Catelogy.MergedCatelogy> f;
    private ViewPager g;
    private ImageView h;
    private ParallaxHeaderHelper i;
    private BaseActivity j;
    private View k;

    public final void a(int paramInt)
    {
        ParallaxHeaderHelper.a = 2;
        this.g.setCurrentItem(paramInt + 1);
    }

    public final void a(int paramInt1, int paramInt2)
    {
        switch (paramInt2)
        {
            default:
                return;
            case 3:
                if ((this.f != null) && (this.f.get(paramInt1) != null));
                for (String str = ((Catelogy.MergedCatelogy)this.f.get(paramInt1)).getId() + "_" + (paramInt1 + 1); ; str = "")
                {
                    JDMtaUtils.onClick(getContext(), "Classification_CoCategory_Tab", JDNewCategoryFragment.class.getName(), str);
                    return;
                }
            case 2:
                JDMtaUtils.sendCommonData(getContext(), "Classification_CoCategory_Refresh", "", "", JDNewCategoryFragment.class, "", JDNewCategoryFragment.class, "");
                return;
            case 1:
        }
        JDMtaUtils.sendCommonData(getContext(), "Classification_CoCategory_Slide", "", "", JDNewCategoryFragment.class, "", JDNewCategoryFragment.class, "");
    }

    public final void a(View paramView)
    {
        this.k = paramView;
    }

    public final void a(View paramView, ImageView paramImageView)
    {
        this.d = paramView;
        this.e = paramImageView;
    }

    public final void a(BaseActivity paramBaseActivity)
    {
        this.j = paramBaseActivity;
    }

    public final void a(String paramString1, String paramString2, int paramInt)
    {
        this.b = paramString1;
        this.c = paramString2;
        this.a = paramInt;
    }

    public final void a(List<Catelogy.MergedCatelogy> paramList)
    {
        this.f = paramList;
        if (this.g != null)
            this.g.setCurrentItem(0);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903318, paramViewGroup, false);
        this.i = new ParallaxHeaderHelper();
        this.i.a(paramLayoutInflater.findViewById(2131165802), paramLayoutInflater.getResources().getDimensionPixelSize(2131035570));
        this.g = ((ViewPager)paramLayoutInflater.findViewById(2131165258));
        this.i.a((NestedViewPager)this.g, new ConjoinedCategoryFragment.PagerAdapter(this, getChildFragmentManager()));
        this.i.a((PagerSlidingTabStrip)paramLayoutInflater.findViewById(2131166626), paramLayoutInflater.getResources().getDimensionPixelSize(2131035875), true);
        this.i.a((TextView)paramLayoutInflater.findViewById(2131166627));
        this.h = ((ImageView)paramLayoutInflater.findViewById(2131166625));
        this.i.a(this);
        this.rootView = paramLayoutInflater;
        return paramLayoutInflater;
    }

    public View onCreateViews(LayoutInflater paramLayoutInflater, Bundle paramBundle)
    {
        setIsUseBasePV(false);
        return null;
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        return false;
    }

}
