package com.jingdong.app.mall.category.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingdong.app.mall.category.view.ParallaxHeaderHelper;
import com.jingdong.common.BaseActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.category.adapter.ScrollTabHolderPagerAdapter;
import com.zy.app.mall.category.fragment.L2CategoryFragment;
import com.zy.app.mall.category.fragment.ScrollTabHolderFragment;
import com.zy.app.mall.category.view.NestedViewPager;
import com.zy.app.mall.category.view.PagerSlidingTabStrip;
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
        this.rootView = paramLayoutInflater.inflate(R.layout.conjoined_category_fragment, paramViewGroup, false);   //2130903318
        this.i = new ParallaxHeaderHelper();
        this.i.a(this.rootView.findViewById(R.id.header), this.rootView.getResources().getDimensionPixelSize(R.dimen.header_height));   //2131165802    //2131035570
        this.g = ((ViewPager)this.rootView.findViewById(R.id.pager)); //2131165258
        this.i.a((NestedViewPager)this.g, new ConjoinedCategoryFragment.PagerAdapter(this, getChildFragmentManager()));
        this.i.a((PagerSlidingTabStrip)this.rootView.findViewById(R.id.tabs), this.rootView.getResources().getDimensionPixelSize(R.dimen.min_header_height), true);   //2131166626    //2131035875
        this.i.a((TextView)this.rootView.findViewById(R.id.info));   //2131166627
        this.h = ((ImageView)this.rootView.findViewById(R.id.imageView)); //2131166625
        this.i.a(this);
        return this.rootView;
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

    public class PagerAdapter extends ScrollTabHolderPagerAdapter
    {
        private NestedOrdinaryL2CategoryFragment b;
        private final String[] c = new String[0];
        private int d = -1;

        public PagerAdapter(ConjoinedCategoryFragment paramConjoinedCategoryFragment, FragmentManager paramFragmentManager)
        {
            super(paramFragmentManager);
        }

        public final ScrollTabHolderFragment a(int paramInt)
        {

            String str2 = "";
            String str1 = str2;
            Object localObject1 = "";
            if (paramInt >= 0)
            {
                str1 = str2;
                //localObject1 = localObject2;
                if (paramInt < getCount())
                {
                    Catelogy.MergedCatelogy localMergedCatelogy = (Catelogy.MergedCatelogy)ConjoinedCategoryFragment.this.f.get(paramInt);
                    str1 = str2;
                    //localObject1 = localObject2;
                    if (localMergedCatelogy != null)
                    {
                        localObject1 = localMergedCatelogy.getId();
                        str1 = localMergedCatelogy.getName();
                    }
                }
            }
            ScrollTabHolderFragment localObject2 = (NestedOrdinaryL2CategoryFragment)NestedOrdinaryL2CategoryFragment.a((String)localObject1, ConjoinedCategoryFragment.this.c, ConjoinedCategoryFragment.this.a, paramInt);
            ((NestedOrdinaryL2CategoryFragment)localObject2).a(ConjoinedCategoryFragment.this.k);
            ((NestedOrdinaryL2CategoryFragment)localObject2).a(ConjoinedCategoryFragment.this.h);
            ((NestedOrdinaryL2CategoryFragment)localObject2).a(ConjoinedCategoryFragment.this.d, ConjoinedCategoryFragment.this.e);
            ((L2CategoryFragment)localObject2).thisActivity = ConjoinedCategoryFragment.this.j;
            ((NestedOrdinaryL2CategoryFragment)localObject2).a((String)localObject1, ConjoinedCategoryFragment.this.c, ConjoinedCategoryFragment.this.a);
            ((NestedOrdinaryL2CategoryFragment)localObject2).b(str1);
            paramInt += 1;
            if ((paramInt >= 0) && (paramInt < getCount()))
            {
                localObject1 = (Catelogy.MergedCatelogy)ConjoinedCategoryFragment.this.f.get(paramInt);
                if (localObject1 != null)
                {
                    ((NestedOrdinaryL2CategoryFragment)localObject2).c(((Catelogy.MergedCatelogy)localObject1).getName());
                    ((NestedOrdinaryL2CategoryFragment)localObject2).a(ConjoinedCategoryFragment.this);
                }
            }
            return localObject2;
        }

        public final void a(int paramInt, ScrollTabHolderFragment paramScrollTabHolderFragment)
        {
            if ((this.d != paramInt) && (paramInt >= 0) && (paramInt < getCount()) && (paramScrollTabHolderFragment != null))
            {
                Catelogy.MergedCatelogy localMergedCatelogy = (Catelogy.MergedCatelogy)ConjoinedCategoryFragment.this.f.get(paramInt);
                if (localMergedCatelogy != null)
                {
                    ((NestedOrdinaryL2CategoryFragment)paramScrollTabHolderFragment).d(localMergedCatelogy.getId());
                    if (this.b != null)
                        this.b.c();
                    this.b = ((NestedOrdinaryL2CategoryFragment)paramScrollTabHolderFragment);
                    this.d = paramInt;
                }
            }
        }

        public int getCount()
        {
            if (ConjoinedCategoryFragment.this.f != null)
                return ConjoinedCategoryFragment.this.f.size();
            return 0;
        }

        public CharSequence getPageTitle(int paramInt)
        {
            if (ConjoinedCategoryFragment.this.f != null)
                return ConjoinedCategoryFragment.this.f.get(paramInt).getName();
            return "";
        }
    }

}
