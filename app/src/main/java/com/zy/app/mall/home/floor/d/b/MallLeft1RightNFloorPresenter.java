package com.zy.app.mall.home.floor.d.b;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.a.b.MallFloorTypeUtil;
import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.model.entity.Left1RightNFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallLeft1RightNFloorUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-14.
 */
//h
public class MallLeft1RightNFloorPresenter extends MallUseBigBgFloorPresenter<Left1RightNFloorEntity, FloorEngine, IMallLeft1RightNFloorUI>{
    public MallLeft1RightNFloorPresenter(Class<Left1RightNFloorEntity> paramClass, Class<FloorEngine> paramClass1)
    {
        super(paramClass, paramClass1);
    }

    public final int a()
    {
        return this.mFloorEntity.getImageBorderWidth();
    }

    public final void a(int paramInt)
    {
        if (paramInt <= 0)
            return;
        this.mFloorEntity.setRightItemCount(paramInt);
        this.mFloorEntity.setElementsSizeLimit(paramInt + 1);
    }

    protected final void a(HomeFloorNewElements paramHomeFloorNewElements) {
        IMallLeft1RightNFloorUI localg = getUI();
        ArrayList localArrayList = paramHomeFloorNewElements.getData();
        if (localg == null || localArrayList == null)
            return;
        int i4 = this.mFloorEntity.getLimitElementSize();//v19

        if (g(localArrayList.size())) {//if-eqz v2, :cond_0
            int i5 = MallFloorTypeUtil.getFloorTypeByFloorElements(paramHomeFloorNewElements);//v20
            int j = this.mFloorEntity.getRightItemCount();//v3
            int i, k;


            if (this.mFloorEntity.isUseBigBg())//if-eqz v2, :cond_3
                i = this.mFloorEntity.getInnerLayoutHeight();
            else if (this.mFloorEntity.getLayoutPadding() == 0)
                i = this.mFloorEntity.getLayoutHeight();
            else
                i = this.mFloorEntity.getLayoutHeight() - this.mFloorEntity.getLayoutPadding() * 2;

            int i1 = i / j;//v17
            j = this.mFloorEntity.getLayoutWidth();
            if (this.mFloorEntity.isUseBigBg()) {//if-eqz v2, :cond_d
                k = this.mFloorEntity.getInnerLayoutMarginLeft();
                j -= this.mFloorEntity.getInnerLayoutMarginRight() + k;
            } else
                j = i;
            //:goto_1
            k = j / 2;
            int m;
            if (this.mFloorEntity.getLeftItemWidth() != 0) {//if-nez v2, :cond_5
                k = this.mFloorEntity.getLeftItemWidth();//v14

            }
            j = this.mFloorEntity.getLayoutWidth();//v3
            if (this.mFloorEntity.isUseBigBg()) {//if-eqz v2, :cond_c
                m = this.mFloorEntity.getInnerLayoutMarginLeft();
                j -= this.mFloorEntity.getInnerLayoutMarginRight() + m;//sub-int v2, v3, v2
            }//else move v2, v3


            //:goto_3

            int i3 = j - k;//v16
            int i6 = this.mFloorEntity.getItemDividerWidth();//v21
            int i2;
            int n;
            if (this.mFloorEntity.getLayoutPadding() != 0)//if-eqz v2, :cond_6
                j = 1;
            else
                j = 0;
            if (j != 0) {
                localg.setBackgroundResource(2131099678);//2131099678
                j = this.mFloorEntity.getLayoutPadding();
                localg.setPadding(j, j, j, j);
            }
            if (this.mFloorEntity.isUseBigBg())//if-eqz v2, :cond_7
                m = 1;
            else
                m = 0;//v15

            //:goto_6
            for (i2 = m; i2 < i4; i2++) {//if-ge v6, v0, :cond_0
                HomeFloorNewElement element = (HomeFloorNewElement) localArrayList.get(i2);
                MallFloorCommonUtil.a(i5, this.mFloorEntity);
                MallFloorCommonUtil.a(i5, this.mFloorEntity, i2);
                FloorEngine.a(element, this.mFloorEntity, i2);
                if (i2 != m) {    //if-eq v6, v15, :cond_b
                    if (this.mFloorEntity.getIsHaveDivider()) {//if-eqz v3, :cond_a
                        n = i3 - i6;//sub-int v4, v16, v21
                        if (i2 > m + 1)//if-le v6, v3, :cond_9
                            j = i1 - i6;//sub-int v5, v17, v21
                        else
                            j = i1;//move/from16 v5, v17
                    } else {
                        n = i3;//move/from16 v4, v16
                        j = i1;//move/from16 v5, v17
                    }
                } else {
                    n = k;//move v4, v14
                    j = i;//move v5, v13
                }
                //:goto_7
                if ((h(i2)) && (!this.mFloorEntity.isUseBigBg()))
                    localg.a(element, this.mFloorEntity.getSeparationParams(), n, j, i2, null);
                else
                    localg.a(element, n, j, i2, null);

            }

        }

    }

    public final int b()
    {
        return this.mFloorEntity.getImageBorderColor();
    }
}
