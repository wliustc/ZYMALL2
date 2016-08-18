package com.zy.app.mall.home.floor.d.b;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.a.b.MallFloorTypeUtil;
import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.model.entity.Left1Right1TopNBottomFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallLeft1Right1TopNBottomFloorUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-27.
 */
//g
public class MallLeft1Right1TopNBottomFloorPresenter extends MallUseBigBgFloorPresenter<Left1Right1TopNBottomFloorEntity, FloorEngine, IMallLeft1Right1TopNBottomFloorUI> {
    public MallLeft1Right1TopNBottomFloorPresenter(Class<Left1Right1TopNBottomFloorEntity> paramClass, Class<FloorEngine> paramClass1) {
        super(paramClass, paramClass1);
    }

    private int a() {
        if (this.mFloorEntity.isUseBigBg())
            return this.mFloorEntity.getInnerLayoutHeight();
        return this.mFloorEntity.getLayoutHeight();
    }

    public final void a(int paramInt) {
        if (paramInt <= 0)
            return;
        this.mFloorEntity.setRightBottomItemCount(paramInt);
        this.mFloorEntity.setElementsSizeLimit(paramInt + 2);
    }

    protected final void a(HomeFloorNewElements paramHomeFloorNewElements) {
        IMallLeft1Right1TopNBottomFloorUI localf = getUI();
        if (localf == null)
            return;
        ArrayList localArrayList = paramHomeFloorNewElements.getData();

        if (localArrayList == null)
            return;
        int i3 = this.mFloorEntity.getLimitElementSize();//v19

        if (g(localArrayList.size())) {//if-eqz v2, :cond_0
            int i4 = MallFloorTypeUtil.getFloorTypeByFloorElements(paramHomeFloorNewElements);//v20
            int k = this.mFloorEntity.getRightBottomItemCount();//v4
            int i2 = a();//v16
            int n = a() / 2;//v3
            int i = this.mFloorEntity.getRightTopItemHeight();//v2

            if (i != 0)//if-nez v2, :cond_2 //move v13, v3
                n = i;//move v13, v2
            int i5 = this.mFloorEntity.getItemDividerWidth();//v21
            //.line 50
            //sub-int v2, v16, v13  ok

            //sub-int v17, v2, v21  i2 - n - i5  oj
            i = this.mFloorEntity.getLayoutWidth();//v3
            if (this.mFloorEntity.isUseBigBg()) {//if-eqz v2, :cond_9
                i -= this.mFloorEntity.getInnerLayoutMarginRight() + this.mFloorEntity.getInnerLayoutMarginLeft();//sub-int v2, v3, v2
            } else {
                //move v2, v3  ok
            }

            //:goto_1
            i /= 2; //div-int/lit8 v3, v2, 0x2   //v3
            int j = this.mFloorEntity.getLeftItemWidth();   //v2
            int m;
            if (j != 0)//if-nez v2, :cond_3
                i = j;  // v14
            //:goto_2
            j = this.mFloorEntity.getLayoutWidth();//v3
            if (this.mFloorEntity.isUseBigBg()) {//if-eqz v2, :cond_8
                m = this.mFloorEntity.getInnerLayoutMarginLeft();
                j -= this.mFloorEntity.getInnerLayoutMarginRight() + m; //sub-int v2, v3, v2
            }
            //:goto_3

            int i6 = j - i;//v22
            int i7 = i6 / k;//v23

            if (this.mFloorEntity.isUseBigBg())//if-eqz v2, :cond_4
                j = 1;//v15
            else
                j = 0;//v15
            //:goto_4
            //v6
            //:goto_5
            for (int i1 = j; i1 < i3; i1++) {//if-ge v6, v0, :cond_0
                HomeFloorNewElement elements = (HomeFloorNewElement) localArrayList.get(i1);
                //Lcom/jingdong/app/mall/home/floor/a/b/b;->a
                MallFloorCommonUtil.a(i4, this.mFloorEntity);
                MallFloorCommonUtil.a(i4, this.mFloorEntity, i1);
                //Lcom/jingdong/app/mall/home/floor/d/a/c;->a
                FloorEngine.a(elements, this.mFloorEntity, i1);
                k = i7 - i5;//v4
                if (i1 == j) {//if-ne v6, v15, :cond_5
                    k = i;  //v4
                    m = i2; //v5
                } else if (i1 == j + 1) {
                    k = i6 - i5;//sub-int v4, v22, v21
                    m = n - i5; //sub-int v5, v13, v21
                } else {
                    m = i2 - n - i5;// //move/from16 v5, v17
                }
                //:goto_6
                if ((h(i1)) && (!this.mFloorEntity.isUseBigBg()))
                    localf.a(elements, this.mFloorEntity.getSeparationParams(), k, m, i1, Integer.valueOf(i5));
                else
                    localf.a(elements, k, m, i1, Integer.valueOf(i5));
            }

        }

    }
}
