package com.zy.app.mall.home.floor.d.b;

import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.d.a.AnnouncementFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.AnnouncementFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallAnnouncementFloorUI;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.Log;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by robin on 16-7-12.
 */
//a
public class MallAnnouncementFloorPresenter extends MallFloorPresenter<AnnouncementFloorEntity, AnnouncementFloorEngine, IMallAnnouncementFloorUI> {
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = true;
    private int g = 1;
    private Runnable h = new Runnable(){//b(this)
        @Override
        public void run() {
            if ((!MallAnnouncementFloorPresenter.d) && (MallAnnouncementFloorPresenter.this.getUI() != null)){//if-eqz v0, :cond_1
                if (MallAnnouncementFloorPresenter.this.g % ((AnnouncementFloorEntity)MallAnnouncementFloorPresenter.this.mFloorEntity).getRotateTime() == 0){//if-nez v0, :cond_0
                    MallAnnouncementFloorPresenter.this.g = 0;
                    try
                    {
                        MallAnnouncementFloorPresenter.this.getUI().a();

                    }
                    catch (Exception localException)
                    {
                        MallAnnouncementFloorPresenter.this.d = true;
                            if (Log.D)
                            localException.printStackTrace();
                    }

                }//:cond_0

                MallAnnouncementFloorPresenter.this.g++;
                (MallAnnouncementFloorPresenter.this.getUI()).a(this, ((AnnouncementFloorEntity)MallAnnouncementFloorPresenter.this.mFloorEntity).getStartDelayTime());
            }else {//:cond_1
                MallAnnouncementFloorPresenter.f = true;
                MallAnnouncementFloorPresenter.e = false;
            }
            return;
        }
    };

    public MallAnnouncementFloorPresenter(Class<AnnouncementFloorEntity> paramClass, Class<AnnouncementFloorEngine> paramClass1)
    {
        super(paramClass, paramClass1);
    }

    public static void a()
    {
        f = false;
        d = true;
    }

    public final HomeFloorNewElement a(int paramInt)
    {
        return this.mFloorEntity.getListItem(paramInt);
    }

    protected final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements)
    {
        if (getUI() != null && !this.mFloorEntity.isListEmpty()){
            getUI().a(this.mFloorEntity.getBgRadii());
            int i = this.mFloorEntity.getInnerMargin();
            getUI().setPadding(i, 0, i, 0);
            getUI().a(this.mFloorEntity.getImageWidth(), this.mFloorEntity.getImageHeight(), i, this.mFloorEntity.getLeftImageUrl());
            getUI().a(i, this.mFloorEntity.getTextSizeDp());
            b();
        }
    }

    public final void b() {
        if (d && getUI() != null) {
            d = false;
            if (!f) {
                f = true;
                if (e)
                    return;
            }
            getUI().a(this.h, this.mFloorEntity.getStartDelayTime());
            e = true;
        }
    }

    public final boolean c()
    {
        return this.mFloorEntity.isListEmpty();
    }

    public final int d()
    {
        return this.mFloorEntity.getListItemCount();
    }

    @Override
    @Subscribe
    public final void onEvent(BaseEvent paramBaseEvent)
    {
        if (paramBaseEvent instanceof MallFloorEvent && getUI() != null){
            MallFloorEvent mallFloorEvent = (MallFloorEvent) paramBaseEvent;
            String str = mallFloorEvent.getType();
            int i = -1;
            switch (str.hashCode())
            {
                case 818672077:
                    if (str.equals("home_on_scroll"))
                    i = 0;
                    break;
                case 881725140:
                    if (str.equals("home_scroll_stop"))
                    i = 1;
                    break;
                case 1236015766:
                    if (str.equals("home_pause"))
                    i = 2;
                    break;
            }
            //:cond_2
            //:goto_1
            switch (i)
            {
                case 0:
                    break;
                case 1:
                    getUI().a(mallFloorEvent.b(), mallFloorEvent.c());
                    break;
                case 2:
                    a();
                    break;
            }
        }
        return;
    }
}
