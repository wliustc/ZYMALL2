package com.zy.app.mall.home.floor.d.b;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;

import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.model.entity.FloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.IMallPanicFloorUI;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.cleanmvp.presenter.BasePresenter;
import com.zy.cleanmvp.presenter.IBaseUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.Log;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Robin on 2016/5/23.
 */
//d
public abstract class MallFloorPresenter<E extends FloorEntity, G extends FloorEngine, U extends IMallFloorUI> extends BasePresenter<U> {
    private static String TAG = MallFloorPresenter.class.getSimpleName();
    protected E mFloorEntity = null;   //a
    protected G mFloorEngine = null;   //b
    protected boolean c = false;
    private Handler mHadler = new Handler(Looper.getMainLooper());

    public MallFloorPresenter(Class<E> entityClass, Class<G> engineClass) {
        try {
            this.mFloorEntity = (E) entityClass.newInstance();
            this.mFloorEngine = (G) engineClass.newInstance();
            return;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public final int a(Context paramContext) {
        return paramContext.getResources().getColor(this.mFloorEntity.getRightCornerTextColorResValue());
    }

    protected void a(MallFloorEvent floorEvent) {
        String str = floorEvent.getType();
        int i = -1;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1"))
                    i = 0;
                break;
            case 50:
                if (str.equals("2"))
                    i = 1;
                break;
        }

        switch (i) {
            case 0:
                getUI().d();
                break;
            case 1:
                Object v1 = floorEvent.a();
                if (v1 instanceof Boolean)
                    getUI().a(((Boolean) v1).booleanValue());
                break;
        }
    }

    protected void a(HomeFloorNewElement paramHomeFloorNewElement) {
    }

    protected void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements) {
    }

    public final void a(HttpGroup paramHttpGroup) {
        this.mFloorEngine.a(paramHttpGroup);
    }

    public final int b(Context paramContext) {
        return DPIUtil.px2dip(paramContext, this.mFloorEntity.getRightCornerTextSizePx());
    }

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

    public final void d(boolean paramBoolean) {
        this.c = paramBoolean;
    }

    public final void e(int paramInt) {
        this.mFloorEntity.setLayoutWidthBy720Design(paramInt);
    }

    public final void f(int paramInt) {
        this.mFloorEntity.setLayoutHeightBy720Design(paramInt);
    }

    public final boolean g(int paramInt) {
        return paramInt >= this.mFloorEntity.getLimitElementSize();
    }

    public final boolean h(int paramInt) {
        return this.mFloorEntity.getSeparationDownloadParams(paramInt).c;
    }

    public final boolean i(int paramInt) {
        return this.mFloorEntity.getSeparationDownloadParams(paramInt).b;
    }

    public final boolean k() {
        return this.c;
    }

    public final int l() {
        return this.mFloorEntity.getTitleTextSizePx();
    }

    public final int m() {
        return this.mFloorEntity.getTitleTextColor();
    }

    protected final void n() {
        int m = 1;
        int bottomDividerHeight = 0;
        int rightMargin = this.mFloorEntity.getLayoutLeftRightMargin();
        int bottomMargin = this.mFloorEntity.getLayoutTopBottomMargin();
        int topDividerHeight;
        int i;
        if (this.mFloorEntity.hasTopDivider()) {
            topDividerHeight = this.mFloorEntity.getTopDividerHeight();
            i = 1;
        } else {
            i = 0;
            topDividerHeight = 0;
        }

        if (this.mFloorEntity.hasBottomDivider()) {
            bottomDividerHeight = this.mFloorEntity.getBottomDividerHeight();
        }
        if ((i != 0) && (getUI() != null))
            getUI().a(rightMargin, topDividerHeight + bottomMargin, rightMargin, bottomDividerHeight + bottomMargin);
        return;
    }

    public final int o() {
        return this.mFloorEntity.getItemDividerWidth();
    }

    @Override
    @Subscribe
    public void onEvent(BaseEvent paramBaseEvent) {
    }

    @Override
    @Subscribe
    public void onEventMainThread(BaseEvent paramBaseEvent) {
        if (paramBaseEvent instanceof MallFloorEvent) {
            if (getUI() != null) {
                final MallFloorEvent localb = (MallFloorEvent) paramBaseEvent;
                String type = localb.getType();
                int i = -1;
                switch (type.hashCode()) {
                    case -277321843:
                        if (type.equals("home_resume"))
                            i = 0;
                        break;
                }

                switch (i) {
                    case 0:
                        getUI().b(localb.b(), localb.c());
                }
                if (!(paramBaseEvent instanceof MallFloorEvent))
                    i = 0;
                else if (getUI() == null)
                    i = 0;
                else if (paramBaseEvent.getBundle() == null)
                    i = 0;
                else {
                    String str = paramBaseEvent.getBundle().getString(Constants.a);
                    if ((str == null) || (str.isEmpty()))
                        i = 0;
                    else if (!((IMallFloorUI) getUI()).getClass().getName().equalsIgnoreCase(str))
                        i = 0;
                    else
                        i = 1;

                }

                if (i != 0) {
                    mHadler.post(new Runnable() {
                        @Override
                        public void run() {
                            a(localb);
                        }
                    });

                }
            }
        }
        return;

    }

    @Override
    protected void onSuspend() {
    }

    public final String p() {
        return this.mFloorEntity.getTitleText();
    }

    public final boolean q() {
        return this.mFloorEntity.hasRightCorner();
    }

    public final String r() {
        return this.mFloorEntity.getRightCornerText();
    }

    public final boolean s() {
        return this.mFloorEntity.isShowTitle();
    }

    public final int t() {
        return this.mFloorEntity.getTitleBarLeftMargin();
    }

    public final int u() {
        return this.mFloorEntity.getTitleBarTopMargin();
    }

    public final int v() {
        return this.mFloorEntity.getTitleCenterHeight();
    }

    public final int w() {
        return this.mFloorEntity.getTitleBarHeight();
    }

    public final String x() {
        return this.mFloorEntity.getTitleImgUrl();
    }

    public final Point y() {
        return this.mFloorEntity.getTitleTextPadding();
    }

    public final Point z() {
        return this.mFloorEntity.getTitleImgSize();
    }


    @Override
    protected U createNullObject() {
        return null;
    }

    @Override
    protected void onAttach(U paramUI) {
        IMallFloorUI ui = (IMallFloorUI)paramUI;
        if (ui != null)
            this.mFloorEngine.a(ui.getClass().getName());
    }

    @Override
    protected void onDetach(U paramUI) {

    }
}
