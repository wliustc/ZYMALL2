package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.d.b.MallLeft1RightNFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.Left1RightNFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallLeft1RightNFloorUI;
import com.zy.common.entity.HomeFloorNewElement;

/**
 * Created by robin on 16-7-14.
 */
public class MallFloor_Left1RightN extends MallUseBigBgFloor<MallLeft1RightNFloorPresenter>
        implements IMallLeft1RightNFloorUI {
    public MallFloor_Left1RightN(Context paramContext, int paramInt1, int paramInt2) {
        this(paramContext, 2, paramInt2, -1);
    }

    private MallFloor_Left1RightN(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
        super(paramContext);
        MallLeft1RightNFloorPresenter presenter = i();
        presenter.a(paramInt1);
        presenter.f(paramInt2);
        presenter.e(-1);
    }

    public MallFloor_Left1RightN(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MallFloor_Left1RightN(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void a(View paramView, HomeFloorNewElement paramHomeFloorNewElement, int paramInt, boolean paramBoolean) {
        a(paramView, paramHomeFloorNewElement);
        int i;
        if (paramInt != 0) {
            ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
            if (!(layoutParams instanceof RelativeLayout.LayoutParams))
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams) layoutParams).addRule(1, 1);
            i = i().o();
            if (paramInt > 1) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, paramInt);
                ((RelativeLayout.LayoutParams) layoutParams).setMargins(i, i, 0, 0);
            } else {
                ((RelativeLayout.LayoutParams) layoutParams).setMargins(i, 0, 0, 0);
            }
            paramView.setLayoutParams(layoutParams);
        }
        paramView.setId(paramInt + 1);
        if (paramView.getParent() == null) {
            if ((!paramBoolean) || (getChildCount() <= paramInt))
                addView(paramView);
            else
                addView(paramView, paramInt);
        }
        return;
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (getChildCount() > paramInt3) {
            bool1 = bool2;
            if (i().i(paramInt3)) {
                removeViewAt(paramInt3);
                b(paramInt3);
                bool1 = true;
            }
        }
        int i = paramInt3;
        if (i().c())
            i = paramInt3 - 1;
        SimpleDraweeView localSimpleDraweeView = a(i, paramHomeFloorNewElement, this);
        if (localSimpleDraweeView == null)
            localSimpleDraweeView = c(paramInt1, paramInt2);
        a(localSimpleDraweeView, paramHomeFloorNewElement, i, bool1);
        a(localSimpleDraweeView, paramHomeFloorNewElement.getImg(), i);
        FloorImageLoadCtrl.a(localSimpleDraweeView, paramHomeFloorNewElement.getImg(), true);
        return null;
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, MallFloorCommonUtil._F paramf, int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
        MallFloorCommonUtil._G g = paramf.a(paramInt3);
        if (g == null || !g.c)
            return null;

        boolean bool = false;
        if ((getChildCount() > paramInt3) && (i().i(paramInt3)))
            bool = true;

        RelativeLayout layout = a(bool, paramInt3, paramInt1, paramInt2, paramf.backgroundColor);
        SimpleDraweeView localSimpleDraweeView = a(paramf, layout, paramHomeFloorNewElement.getImg(), paramInt3);
        a(paramf, layout, a(paramf, layout, paramInt3), paramInt3);
        a(layout, paramHomeFloorNewElement, paramInt3, bool);
        FloorImageLoadCtrl.a(localSimpleDraweeView, paramHomeFloorNewElement.getImg(), false);
        return null;

    }

    protected final SimpleDraweeView c(int paramInt1, int paramInt2) {
        SimpleDraweeView localSimpleDraweeView = super.c(paramInt1, paramInt2);
        MallLeft1RightNFloorPresenter localh = i();
        paramInt1 = localh.a();
        if (paramInt1 > 0) {
            localSimpleDraweeView.setPadding(paramInt1, paramInt1, paramInt1, paramInt1);
            localSimpleDraweeView.setBackgroundColor(localh.b());
        }
        return localSimpleDraweeView;
    }

    @Override
    protected MallLeft1RightNFloorPresenter h() {
        return new MallLeft1RightNFloorPresenter(Left1RightNFloorEntity.class, FloorEngine.class);
    }

}
