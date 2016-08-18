package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.d.a.LinearFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallLinearFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.LinearFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallLinearFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.common.entity.HomeFloorNewElement;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-22.
 */
public class MallFloor_LinearLayout extends MallUseBigBgFloor<MallLinearFloorPresenter>
        implements IMallLinearFloorUI {
    public MallFloor_LinearLayout(Context paramContext, int itemCount, int layoutHeight)
    {
        this(paramContext, itemCount, layoutHeight, -1, null);
    }

    public MallFloor_LinearLayout(Context paramContext, int itemCount, int layoutHeight, int layoutWidth, ArrayList<Integer> ItemsWidth)
    {
        super(paramContext);
        MallLinearFloorPresenter presenter = (MallLinearFloorPresenter)i();
        presenter.a(itemCount);//setItemCount
        presenter.e(layoutWidth);//setLayoutWidthBy720Design
        presenter.f(layoutHeight);//setLayoutHeightBy720Design
        presenter.a(ItemsWidth);//setItemsWidth
    }

    public MallFloor_LinearLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MallFloor_LinearLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    private Object a(View paramView, HomeFloorNewElement paramHomeFloorNewElement, int paramInt, boolean paramBoolean, Object paramObject) {
        if (!(paramObject instanceof Integer))
            return null;
        int j = ((MallLinearFloorPresenter) i()).o();
        int i = 0;
        if (paramInt == 0)
            i = 1;
        //:goto_1
        int k = ((Integer) paramObject).intValue();
        a(paramView, paramHomeFloorNewElement);
        if (i == 0) {//if-nez v0, :cond_1
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) paramView.getLayoutParams();
            layoutParams.addRule(1, k);
            if (((findViewById(k) instanceof SimpleDraweeView)) && ((paramView instanceof SimpleDraweeView)))
                i = 0;
            else
                i = j;
            //:goto_2
            layoutParams.setMargins(i, 0, 0, 0);
            paramView.setLayoutParams(layoutParams);
        }
        paramView.setId(paramInt + 1);
        if (paramView.getParent() == null) {//if-nez v1, :cond_2
            if ((paramBoolean) && (getChildCount() > paramInt))
                addView(paramView, paramInt);
            else
                addView(paramView);
        }//:cond_2
        return Integer.valueOf(paramInt + 1);

    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int w, int h, int index, Object paramObject) {
        boolean bool1 = false;
        if (getChildCount() > index) {//if-le v0, p4, :cond_0
            bool1 = false;
            if (i().i(index)) {//if-eqz v0, :cond_0
                removeViewAt(index);
                b(index);
                bool1 = true;
            }
        }
        if (((MallLinearFloorPresenter) i()).c())
            index -= 1;

        SimpleDraweeView simpleDraweeView = a(index, null, this);
        if (simpleDraweeView == null)
            simpleDraweeView = c(w, h);
        paramObject = a(simpleDraweeView, paramHomeFloorNewElement, index, bool1, paramObject);
        if (paramObject == null)
            return null;
        a(simpleDraweeView, paramHomeFloorNewElement.getImg(), index);
        FloorImageLoadCtrl.a(simpleDraweeView, paramHomeFloorNewElement.getImg(), true);
        return paramObject;

    }

    @Override
    protected MallLinearFloorPresenter h() {
        return new MallLinearFloorPresenter(LinearFloorEntity.class, LinearFloorEngine.class);
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, MallFloorCommonUtil._F paramf, int w, int h, int childIndex, Object paramObject) {
        MallFloorCommonUtil._G localObject1 = paramf.a(childIndex);
        if (localObject1 == null)//if-nez v0, :cond_0
            return null;
        if (!((MallFloorCommonUtil._G) localObject1).c)//if-nez v0, :cond_1
            return null;
        //:cond_1
        boolean bool = false;
        if ((getChildCount() > childIndex) && (((MallLinearFloorPresenter) i()).i(childIndex))) {//if-eqz v0, :cond_3
            bool = true;
        }//:cond_3
        RelativeLayout.LayoutParams layoutParams;
        //:goto_1
        RelativeLayout layout = a(bool, childIndex, w, h, paramf.backgroundColor);
        if (childIndex != 0) {//if-eqz p5, :cond_2
            layoutParams = (RelativeLayout.LayoutParams) ((RelativeLayout) layout).getLayoutParams();
            ((RelativeLayout.LayoutParams) layoutParams).setMargins(((MallLinearFloorPresenter) this.mPresenter).o(), 0, 0, 0);
            ((RelativeLayout) layout).setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        }
        SimpleDraweeView v8 = a(paramf, (RelativeLayout) layout, paramHomeFloorNewElement.getImg(), childIndex);
        a(paramf, (RelativeLayout) layout, a(paramf, (RelativeLayout) layout, childIndex), childIndex);
        Object o = a((View) layout, paramHomeFloorNewElement, childIndex, bool, paramObject);
        if (o != null) {
            FloorImageLoadCtrl.a((ImageView) v8, paramHomeFloorNewElement.getImg(), false);
            return o;
        }
        return null;


    }
}
