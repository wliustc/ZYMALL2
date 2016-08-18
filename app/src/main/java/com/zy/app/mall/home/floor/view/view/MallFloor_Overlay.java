package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.d.b.MallOverlayFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.OverlayFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.common.entity.HomeFloorNewElement;

/**
 * Created by robin on 16-7-27.
 */
public class MallFloor_Overlay extends MallBaseFloor<MallOverlayFloorPresenter> {
    public MallFloor_Overlay(Context paramContext) {
        super(paramContext);
    }

    public MallFloor_Overlay(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MallFloor_Overlay(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
        SimpleDraweeView localSimpleDraweeView = a(paramInt3, paramHomeFloorNewElement, this);
        MallFloorCommonUtil._D locald = MallFloorCommonUtil._D.CENTER;
        if ((paramObject != null) && ((paramObject instanceof MallFloorCommonUtil._D)))
            locald = (MallFloorCommonUtil._D) paramObject;//p5


        if (paramInt1 < 0)
            paramInt1 = -1;

        if (paramInt2 < 0)
            paramInt2 = -1;
        if (localSimpleDraweeView == null)
            localSimpleDraweeView = c(paramInt1, paramInt2);

        MallOverlayFloorPresenter presenter = (MallOverlayFloorPresenter) i();
        if (paramInt3 == 1) {//if-ne p4, v6, :cond_2
            localSimpleDraweeView.setPadding(presenter.a(), presenter.b(), 0, presenter.b());
            ViewGroup.LayoutParams localObject = localSimpleDraweeView.getLayoutParams();
            LayoutParams v2 = null;
            if (localObject == null)//if-nez v0, :cond_4
                v2 = new RelativeLayout.LayoutParams(-2, -2);
            else if ((localObject instanceof RelativeLayout.LayoutParams))
                v2 = (RelativeLayout.LayoutParams) localObject;
            else {
                v2 = new LayoutParams(localObject.width, localObject.height);
                if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
                    v2.setMargins(((ViewGroup.MarginLayoutParams) localObject).leftMargin, ((ViewGroup.MarginLayoutParams) localObject).topMargin, ((ViewGroup.MarginLayoutParams) localObject).rightMargin, ((ViewGroup.MarginLayoutParams) localObject).bottomMargin);
                }
            }
            //:goto_2
            //switch (_Y.a[locald.ordinal()]) {
            switch(locald){
                case LEFT_TOP: //1 pswitch_0
                    break;
                case RIGHT_TOP: //2 pswitch_1
                    v2.addRule(ALIGN_PARENT_RIGHT);
                    break;
                case LEFT_BOTTOM: //3 pswitch_2
                    v2.addRule(ALIGN_PARENT_BOTTOM);
                    break;
                case RIGHT_BOTTOM: //4 pswitch_3
                    v2.addRule(ALIGN_PARENT_RIGHT);
                    v2.addRule(ALIGN_PARENT_BOTTOM);
                    break;
                case CENTER: //5 pswitch_4
                    v2.addRule(CENTER_IN_PARENT);
                    break;
            }
            localSimpleDraweeView.setLayoutParams(v2);
        }

        a(localSimpleDraweeView, paramHomeFloorNewElement);
        if (localSimpleDraweeView.getParent() == null)
            addView(localSimpleDraweeView);
        a(localSimpleDraweeView, paramHomeFloorNewElement.getImg(), paramInt3);
        FloorImageLoadCtrl.a(localSimpleDraweeView, paramHomeFloorNewElement.getImg(), true);
        return null;
    }

    @Override
    protected MallOverlayFloorPresenter h() {
        return new MallOverlayFloorPresenter(OverlayFloorEntity.class, FloorEngine.class);
    }

    private static class _Y{
        private static int[] a = new int[5];
        static {
            a[MallFloorCommonUtil._D.LEFT_TOP.ordinal()] = 1;
            a[MallFloorCommonUtil._D.RIGHT_TOP.ordinal()] = 2;
            a[MallFloorCommonUtil._D.LEFT_BOTTOM.ordinal()] = 3;
            a[MallFloorCommonUtil._D.RIGHT_BOTTOM.ordinal()] = 4;
            a[MallFloorCommonUtil._D.CENTER.ordinal()] = 5;

        }
    }
}
