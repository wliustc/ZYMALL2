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
import com.zy.app.mall.home.floor.d.b.MallLeft1Right1TopNBottomFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.Left1Right1TopNBottomFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.common.entity.HomeFloorNewElement;

/**
 * Created by robin on 16-7-27.
 */
public class MallFloor_Left1Right1TopNBottom extends MallUseBigBgFloor<MallLeft1Right1TopNBottomFloorPresenter>
        implements com.zy.app.mall.home.floor.view.baseUI.IMallLeft1Right1TopNBottomFloorUI {
    public MallFloor_Left1Right1TopNBottom(Context paramContext, int paramInt1, int paramInt2) {
        this(paramContext, 2, paramInt2, -1);
    }

    private MallFloor_Left1Right1TopNBottom(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
        super(paramContext);
        MallLeft1Right1TopNBottomFloorPresenter presenter = (MallLeft1Right1TopNBottomFloorPresenter) i();
        presenter.a(paramInt1);
        presenter.f(paramInt2);
        presenter.e(-1);
    }

    public MallFloor_Left1Right1TopNBottom(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MallFloor_Left1Right1TopNBottom(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void a(View paramView, HomeFloorNewElement paramHomeFloorNewElement, int paramInt, boolean paramBoolean, Object paramObject) {
        int i = 0;
        if ((paramObject != null) && ((paramObject instanceof Integer)))
            i = ((Integer) paramObject).intValue();
        a(paramView, paramHomeFloorNewElement);
        RelativeLayout.LayoutParams layoutParams = null;
        if ((paramView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
            layoutParams = (RelativeLayout.LayoutParams) paramView.getLayoutParams();
        else
            layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        if (paramInt == 1)
            layoutParams.setMargins(i, 0, 0, i);
        else if (paramInt > 1)
            layoutParams.setMargins(i, 0, 0, 0);

        if (paramInt != 0) {
            layoutParams.addRule(1, 1);
            if (paramInt > 1)
                layoutParams.addRule(3, 2);
            if (paramInt > 2)
                layoutParams.addRule(1, paramInt);
            paramView.setLayoutParams(layoutParams);
        }
        paramView.setId(paramInt + 1);
        if (paramView.getParent() == null) {
            if ((paramBoolean) && (getChildCount() > paramInt))
                addView(paramView, paramInt);
            else
                addView(paramView);

        }
        return;
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
        boolean bool1 = false;
        if (getChildCount() > paramInt3) {
            bool1 = false;
            if (i().i(paramInt3)) {
                removeViewAt(paramInt3);
                b(paramInt3);
                bool1 = true;
            }
        }
        if (i().c())
            paramInt3 -= 1;
        SimpleDraweeView localSimpleDraweeView1 = a(paramInt3, paramHomeFloorNewElement, this);
        if (localSimpleDraweeView1 == null)
            localSimpleDraweeView1 = c(paramInt1, paramInt2);
        a(localSimpleDraweeView1, paramHomeFloorNewElement, paramInt3, bool1, paramObject);
        a(localSimpleDraweeView1, paramHomeFloorNewElement.getImg(), paramInt3);
        FloorImageLoadCtrl.a(localSimpleDraweeView1, paramHomeFloorNewElement.getImg(), true);
        return null;

    }

    @Override
    protected MallLeft1Right1TopNBottomFloorPresenter h() {
        return new MallLeft1Right1TopNBottomFloorPresenter(Left1Right1TopNBottomFloorEntity.class, FloorEngine.class);
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, MallFloorCommonUtil._F paramf, int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
        MallFloorCommonUtil._G g = paramf.a(paramInt3);
        if (g == null)
            return null;
        if (!((MallFloorCommonUtil._G) g).c)
            return null;
        boolean bool = false;
        if ((getChildCount() > paramInt3) && (i().i(paramInt3)))
            bool = true;

        RelativeLayout relativeLayout = a(bool, paramInt3, paramInt1, paramInt2, paramf.backgroundColor);
        SimpleDraweeView localSimpleDraweeView = a(paramf, (RelativeLayout) relativeLayout, paramHomeFloorNewElement.getImg(), paramInt3);
        a(paramf, (RelativeLayout) relativeLayout, a(paramf, (RelativeLayout) relativeLayout, paramInt3), paramInt3);
        a((View) relativeLayout, paramHomeFloorNewElement, paramInt3, bool, paramObject);
        FloorImageLoadCtrl.a(localSimpleDraweeView, paramHomeFloorNewElement.getImg(), false);
        return null;

    }
}
