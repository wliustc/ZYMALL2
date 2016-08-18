package com.zy.app.mall.home.floor.d.b;

import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.jingdong.app.mall.utils.ui.view.CarouseFigureImagePagerAdapter;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.c.FloorMaiDianCtrl;
import com.zy.app.mall.home.floor.d.a.BannerFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.BannerFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallBannerFloorUI;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Robin on 2016/6/15.
 */
//c
public class MallBannerFloorPresenter extends MallFloorPresenter<BannerFloorEntity, BannerFloorEngine, IMallBannerFloorUI>
        implements CarouseFigureImagePagerAdapter.DataPresenter {
    public MallBannerFloorPresenter(Class<BannerFloorEntity> paramClass, Class<BannerFloorEngine> paramClass1) {
        super(paramClass, paramClass1);
    }

    /*-- implements interface CarouseFigureImagePagerAdapter.DataPresenter  --*/
    @Override
    public final int size() {
        return this.mFloorEntity.getItemListSize();
    }

    /*-- implements interface CarouseFigureImagePagerAdapter.DataPresenter  --*/
    @Override
    public final String getImage(int paramInt) {
        HomeFloorNewElement itemByPosition = this.mFloorEntity.getItemByPosition(paramInt);
        if (itemByPosition != null)
            return itemByPosition.getImg();
        return null;
    }

    /*-- implements interface CarouseFigureImagePagerAdapter.DataPresenter  --*/
    @Override
    public final JDDisplayImageOptions getDisplayImageOptions() {
        return FloorImageLoadCtrl.a();
    }

    /*-- implements interface CarouseFigureImagePagerAdapter.DataPresenter  --*/
    @Override
    public final void onClick(int paramInt) {
        if (getUI() != null) {
            HomeFloorNewElement localHomeFloorNewElement = this.mFloorEntity.getItemByPosition(paramInt);
            if (localHomeFloorNewElement != null) ;
            getUI().onClick(localHomeFloorNewElement);
        }
        return;
    }

    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.mFloorEntity.setCarouselPagePadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    protected final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements) {
        super.a(paramHomeFloorNewModel, paramHomeFloorNewElements);
        if (getUI() != null) {
            getUI().a(this.mFloorEntity.getFloorId(), this.mFloorEntity.getEventId());
            BannerFloorEntity.CarouselPagePadding carouselPagePadding = this.mFloorEntity.getCarouselPagePadding();
            getUI().setPadding(carouselPagePadding.left, carouselPagePadding.top, carouselPagePadding.right, carouselPagePadding.bottom);
            getUI().a(this.mFloorEntity.getLayoutHeight(), this.mFloorEntity.getCursorMarginBottom(), this.mFloorEntity.getScrollDuration());
        }
    }


    public final void b(int paramInt) {
        FloorMaiDianCtrl.getInstance().a(this.mFloorEntity.getFloorId(), this.mFloorEntity.getSourceValue(paramInt));
    }

    public final int c() {
        this.mFloorEntity.getClass();
        return 4000;
    }

    public final void c(int paramInt) {
        this.mFloorEntity.setScrollDuration(paramInt);
    }

    public final void d(int paramInt) {
        this.mFloorEntity.setBottomDividerHeight(paramInt);
    }

    public final boolean d() {
        return this.mFloorEntity.isAutoPlay();
    }

    public final boolean e() {
        return this.mFloorEntity.isCarousel();
    }

    public final int f() {
        return this.mFloorEntity.getCursorWidth();
    }

    public final int g() {
        return this.mFloorEntity.getCursorHeight();
    }

    public final int h() {
        return this.mFloorEntity.getCursorSpace();
    }

    public final int i() {
        return this.mFloorEntity.getNormalResource();
    }

    public final int j() {
        return this.mFloorEntity.getLightResource();
    }


    @Subscribe
    public final void onEvent(BaseEvent paramBaseEvent) {
        if (paramBaseEvent instanceof MallFloorEvent) {
            if (getUI() == null) {
                paramBaseEvent = (MallFloorEvent) paramBaseEvent;
                String str = paramBaseEvent.getType();
                int i = -1;
                switch (str.hashCode()) {
                    case 0x30cbf1cd: //818672077:
                        if (str.equals("home_on_scroll"))
                            i = 0;
                        break;
                    case 0x348e0ed4: //881725140:
                        if (str.equals("home_scroll_stop"))
                            i = 1;
                        break;
                }
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        getUI().a(((MallFloorEvent) paramBaseEvent).b(), ((MallFloorEvent) paramBaseEvent).c());
                        break;
                }
            }
        }
        return;
    }


}
