package com.zy.app.mall.home.floor.view.baseUI;

import com.zy.app.mall.home.floor.view.baseUI.IMallFloorUI;
import com.zy.common.entity.HomeFloorNewElement;

/**
 * Created by Robin on 2016/6/15.
 */
//c
public interface IMallBannerFloorUI  extends ICarouselFigureFloorUI, IMallFloorUI {
    public abstract void a(int layoutHeight, int cursorMarginBottom, int scrollDuration);

    public abstract void a(String floorId, String eventId);

    public abstract void onClick(HomeFloorNewElement homeFloorNewElement);
}
