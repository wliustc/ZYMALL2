package com.zy.app.mall.home.floor.d.b;

import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.model.entity.UseBigBgFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallUseBigBgFloorUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.DPIUtil;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-15.
 */
//o
public abstract class MallUseBigBgFloorPresenter<E extends UseBigBgFloorEntity, G extends FloorEngine, U extends IMallUseBigBgFloorUI> extends MallFloorPresenter<E, G, U> {
    public MallUseBigBgFloorPresenter(Class<E> paramClass, Class<G> paramClass1)
    {
        super(paramClass, paramClass1);
    }

    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        this.mFloorEntity.setInnerLayoutMargin(DPIUtil.getWidthByDesignValue720(paramInt1), DPIUtil.getWidthByDesignValue720(paramInt2), DPIUtil.getWidthByDesignValue720(paramInt3), DPIUtil.getWidthByDesignValue720(paramInt4));
    }

    protected abstract void a(HomeFloorNewElements paramHomeFloorNewElements);

    protected final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements)
    {
        super.a(paramHomeFloorNewModel, paramHomeFloorNewElements);
        if (getUI() == null)
            return;
        if (paramHomeFloorNewElements == null)
        {
            getUI().b();
            return;
        }
        if (this.mFloorEntity.isUseBigBg())
        {
            ArrayList<HomeFloorNewElement> list = paramHomeFloorNewElements.getData();
            if (list.size() <= 0)
            {
                getUI().b();
                return;
            }
            if (this.mFloorEntity.isUseBigBg())
            {
                getUI().a(list.get(0));
                getUI().setPadding(this.mFloorEntity.getInnerLayoutMarginLeft(), this.mFloorEntity.getInnerLayoutMarginTop(), this.mFloorEntity.getInnerLayoutMarginRight(), this.mFloorEntity.getInnerLayoutMarginBottom());
            }
        }
        a(paramHomeFloorNewElements);
    }

    public final void a(boolean paramBoolean)
    {
        this.mFloorEntity.setIsUseBigBg(paramBoolean);
        this.mFloorEntity.setElementsSizeLimit(this.mFloorEntity.getLimitElementSize() + 1);
    }

    public final boolean c()
    {
        return this.mFloorEntity.isUseBigBg();
    }
}
