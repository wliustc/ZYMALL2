package com.zy.app.mall.home.floor.model.entity;

import android.graphics.Point;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;

/**
 * Created by Robin on 2016/6/5.
 */
public interface ISeparationFloorEntity {
    public abstract MallFloorCommonUtil._G getSeparationDownloadParams(int paramInt);

    public abstract MallFloorCommonUtil._F getSeparationParams();

    public abstract void setSeparationImgMargin(Point paramPoint);

    public abstract void setSeparationImgPos(MallFloorCommonUtil._D paramd);

    public abstract void setSeparationImgWidthHeightBy720Design(int paramInt1, int paramInt2);

    public abstract void setSeparationLabelCharCountLimit(int paramInt);

    public abstract void setSeparationLabelMargin(Point paramPoint);

    public abstract void setSeparationLabelPadding(Point paramPoint);

    //setSeparationLabelPos$7b837c32
    public abstract void setSeparationLabelPos(int paramInt);

    public abstract void setSeparationLabelTextSizeDp(float paramFloat);

    public abstract void setSeparationSubTitleCharCountLimit(int paramInt);

    public abstract void setSeparationTitleCharCountLimit(int paramInt);

    public abstract void setSeparationTitleMargin(Point paramPoint);
}
