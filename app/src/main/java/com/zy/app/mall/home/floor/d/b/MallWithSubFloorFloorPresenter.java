package com.zy.app.mall.home.floor.d.b;

import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.d.a.WithSubFloorFloorEngine;
import com.zy.app.mall.home.floor.model.entity.WithSubFloorFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.IMallWithSubFloorFloorUI;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

import org.greenrobot.eventbus.Subscribe;

import java.util.Iterator;

/**
 * Created by robin on 16-7-12.
 */
//p
public class MallWithSubFloorFloorPresenter extends MallFloorPresenter<WithSubFloorFloorEntity, WithSubFloorFloorEngine, IMallWithSubFloorFloorUI> {
    public MallWithSubFloorFloorPresenter(Class<WithSubFloorFloorEntity> paramClass, Class<WithSubFloorFloorEngine> paramClass1) {
        super(paramClass, paramClass1);
    }

    protected final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements) {
        super.a(paramHomeFloorNewModel, paramHomeFloorNewElements);
        if (getUI() != null) {
            Iterator<HomeFloorNewElements> iterator = this.mFloorEntity.getElementIterator();
            getUI().b();
            if (iterator != null) {//if-eqz v5, :cond_0
                getUI().a(paramHomeFloorNewModel);
                int v2 = 0;
                if (this.mFloorEntity.isShowTitle())//if-eqz v0, :cond_2
                    v2 = R.id.mallfloor_floor_title;//2131165401
                int v3 = 256;
                int v4 = v2;
                //:goto_2
                while (iterator.hasNext()) {//if-eqz v0, :cond_3
                    HomeFloorNewElements localHomeFloorNewElements = iterator.next();
                    v4 = getUI().a(paramHomeFloorNewModel, localHomeFloorNewElements, v4, v3++);
                }
                if (v4 == v2)
                    getUI().b();//removeAllViews
            }

        }
    }

    @Override
    @Subscribe
    public final void onEvent(BaseEvent paramBaseEvent) {
        if ((paramBaseEvent instanceof MallFloorEvent) && (getUI() != null)) {
            MallFloorEvent event = (MallFloorEvent) paramBaseEvent;
            String str = event.getType();
            int i = -1;
            switch (str.hashCode()) {
                case 881725140://:pswitch_1
                    if (str.equals("home_scroll_stop"))
                        i = 0;
                    break;
            }

            switch (i) {
                case 0://:pswitch_0
                    getUI().a(event.b(), event.c());
                    break;
            }

        }
        return;

    }

    @Override
    public void b(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements) {
        this.mFloorEngine.a(paramHomeFloorNewModel, paramHomeFloorNewElements, this.mFloorEntity);
        if (this.c)
            this.mFloorEntity.setBottomDividerHeight(2);
        if (getUI() != null) {
            IMallFloorUI locald = (IMallFloorUI) getUI();
            this.mFloorEntity.getLayoutWidth();
            locald.a(this.mFloorEntity.getLayoutHeight());
        }
        a(paramHomeFloorNewModel, paramHomeFloorNewElements);
        n();
    }
}
