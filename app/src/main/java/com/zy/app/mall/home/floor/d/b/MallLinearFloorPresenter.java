package com.zy.app.mall.home.floor.d.b;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.a.b.MallFloorTypeUtil;
import com.zy.app.mall.home.floor.d.a.LinearFloorEngine;
import com.zy.app.mall.home.floor.model.entity.LinearFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallLinearFloorUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.utils.DPIUtil;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-22.
 */
//i
public class MallLinearFloorPresenter extends MallUseBigBgFloorPresenter<LinearFloorEntity, LinearFloorEngine, IMallLinearFloorUI>{
    public MallLinearFloorPresenter(Class paramClass1, Class paramClass2)
    {
        super(paramClass1, paramClass2);
    }

    public final void a(int paramInt)
    {
        this.mFloorEntity.setItemCount(paramInt);
    }

    protected final void a(HomeFloorNewElements paramHomeFloorNewElements) {
        IMallLinearFloorUI ui = (IMallLinearFloorUI) getUI();
        if (ui == null)
            return;
        int viewCount = this.mFloorEntity.getItemViewCount();//v13
        if (this.mFloorEntity.isUseBigBg())
            viewCount += 1;//v13
        //:goto_1
        ArrayList<HomeFloorNewElement> localArrayList = paramHomeFloorNewElements.getData();
        if ((viewCount == 0) || (viewCount != localArrayList.size())) {
            ui.b();
            return;
        }
        MallFloorCommonUtil.a(MallFloorTypeUtil.getFloorTypeByFloorElements(paramHomeFloorNewElements), this.mFloorEntity);
        int w = this.mFloorEntity.getLayoutWidth() / viewCount;
        int v17 = this.mFloorEntity.getItemDividerWidth();

        int m = 0;
        int start = 0;//v2
        int index = start;//v6
        if (this.mFloorEntity.isUseBigBg()) {
            start = 1;//const/4 v2, 0x1
            index = start;//move v14, v2
        }
        //:goto_2
        //:goto_3
        for (; index < viewCount; index++) {//if-ge v6, v13, :cond_0
            HomeFloorNewElement elements = (HomeFloorNewElement) localArrayList.get(index);
            LinearFloorEngine.a(elements, this.mFloorEntity, index);
            int v4 = index;
            if (this.mFloorEntity.isHaveItemWidths()) {//if-eqz v3, :cond_4
                if (this.mFloorEntity.isUseBigBg())//if-eqz v3, :cond_6
                    v4 = index - 1;
                w = DPIUtil.getWidthByDesignValue720(this.mFloorEntity.getItemWidth(v4));
            }

            Object lo = null;
            if ((h(index)) && (!this.mFloorEntity.isUseBigBg())) {//if-nez v3, :cond_7
                if (index != start) {//if-eq v6, v14, :cond_9
                    w = w - v17;//sub-int v4, v9, v17
                }//:goto_5
                lo = ui.a(elements, this.mFloorEntity.getSeparationParams(), w, this.mFloorEntity.getInnerLayoutHeight(), index, Integer.valueOf(m));
            } else {//:cond_7
                lo = ui.a(elements, w, this.mFloorEntity.getInnerLayoutHeight(), index, Integer.valueOf(m));
            }//:goto_6
            if ((lo != null) && ((lo instanceof Integer)))
                m = ((Integer) lo).intValue();//v2

        }


    }

    public final void a(ArrayList<Integer> paramArrayList)
    {
        this.mFloorEntity.setItemsWidth(paramArrayList);
    }
}
