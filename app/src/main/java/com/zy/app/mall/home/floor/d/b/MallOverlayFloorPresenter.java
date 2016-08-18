package com.zy.app.mall.home.floor.d.b;

import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.model.entity.OverlayFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallFloorUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-27.
 */
//k
public class MallOverlayFloorPresenter extends MallFloorPresenter<OverlayFloorEntity, FloorEngine, IMallFloorUI>{
    public MallOverlayFloorPresenter(Class<OverlayFloorEntity> paramClass, Class<FloorEngine> paramClass1)
    {
        super(paramClass, paramClass1);
    }

    public final int a()
    {
        return this.mFloorEntity.getInerPaddingLeft();
    }

    protected final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements)
    {
        super.a(paramHomeFloorNewModel, paramHomeFloorNewElements);
        if (paramHomeFloorNewElements == null)
            return;
        ArrayList<HomeFloorNewElement> list = paramHomeFloorNewElements.getData();

        if ((list != null) && (!g(list.size()))){
            //:goto_0
            for (int i = 0; i < this.mFloorEntity.getLimitElementSize(); i++)
            {
                HomeFloorNewElement elements = (HomeFloorNewElement)list.get(i);
                int j = -1;
                if (elements != null && i == 1)
                    j = this.mFloorEntity.getInerImgWidth();
                if (getUI() != null)
                    getUI().a(elements, j, -1, i, this.mFloorEntity.getOverlayPos());
            }
        }

    }

    public final int b()
    {
        return this.mFloorEntity.getInerPadding();
    }
}
