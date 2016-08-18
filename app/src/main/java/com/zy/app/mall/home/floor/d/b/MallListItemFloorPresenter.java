package com.zy.app.mall.home.floor.d.b;

import android.view.View;

import com.zy.app.mall.home.floor.d.a.ListItemFloorEngine;
import com.zy.app.mall.home.floor.model.entity.ListItemFloorEntity;
import com.zy.app.mall.home.floor.view.adapter.MallListItemPagerAdapter;
import com.zy.app.mall.home.floor.view.baseUI.IMallListItemFloorUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

/**
 * Created by Robin on 2016/6/22.
 */
//j
public abstract class MallListItemFloorPresenter<E extends ListItemFloorEntity, G extends ListItemFloorEngine, U extends IMallListItemFloorUI> extends MallFloorPresenter<E, G, U>
        implements MallListItemPagerAdapter.OnClickListener {
    protected boolean d;

    public MallListItemFloorPresenter(Class<E> paramClass1, Class<G> paramClass2)
    {
        super(paramClass1, paramClass2);
    }

    protected abstract void A();

    protected abstract void B();

    public final Object a(int paramInt)
    {
        return this.mFloorEntity.getItemByPosition(paramInt);
    }

    public final String a(boolean paramBoolean)
    {
        return this.mFloorEntity.getMaiDianSourceValue(paramBoolean);
    }

    public final void a()
    {
        this.mFloorEntity.resetItemListFromTmp();
    }

    public final void a(View paramView)
    {
        if (getUI() == null)
            return;
        B();
    }

    protected final void a(HomeFloorNewElement paramHomeFloorNewElement)
    {
        super.a(paramHomeFloorNewElement);
        if (getUI() == null)
            return;
        getUI().a();
        this.mFloorEngine.a(false, paramHomeFloorNewElement.getContent(), (ListItemFloorEntity)this.mFloorEntity);
        getUI().e();
    }

    public final void b(int paramInt)
    {
        if (getUI() == null)
            return;
        c(paramInt);
    }

    public final void b(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements)
    {
        if ((paramHomeFloorNewElements == null) || (paramHomeFloorNewElements.getData() == null) || (paramHomeFloorNewElements.getData().size() == 0))
            return;
        HomeFloorNewElement homeFloorNewElement = (HomeFloorNewElement)paramHomeFloorNewElements.getData().get(0);
            this.mFloorEngine.a(homeFloorNewElement, (ListItemFloorEntity)this.mFloorEntity);
            a(homeFloorNewElement);

        if (getUI() != null){
            IMallListItemFloorUI ui = (IMallListItemFloorUI)getUI();
            this.mFloorEntity.getLayoutWidth();
            ui.a(this.mFloorEntity.getLayoutHeight());
            n();
        }

    }

    public final boolean b()
    {
        return this.mFloorEntity.isItemListEmpty();
    }

    public final int c()
    {
        return this.mFloorEntity.getItemListSize();
    }

    protected abstract void c(int paramInt);

    public final int d()
    {
        if (!this.mFloorEntity.isItemListEmpty())
        {
            int i = this.mFloorEntity.getItemListSize();
            if (i > this.mFloorEntity.getListItemCountLimit())
            {
                this.d = true;
                if (this.mFloorEntity.isHaveAdvert())
                    return i + 2;
                return i + 1;
            }
            this.d = false;
            if (this.mFloorEntity.isHaveAdvert())
                return i + 1;
            return i;
        }
        return 0;
    }

    public final boolean e()
    {
        return this.mFloorEntity.isHaveAdvert();
    }

    public final boolean f()
    {
        return this.d;
    }

    public final int g()
    {
        return this.mFloorEntity.getContentWidth();
    }

    public final int h()
    {
        return this.mFloorEntity.getContentHeight();
    }

    public final String i()
    {
        return this.mFloorEntity.getAdvertImgUrl();
    }

    public final void j()
    {
        if (getUI() == null)
            return;
        A();
    }
}
