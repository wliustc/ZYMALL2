package com.zy.app.mall.home.floor.d.a;

import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;

import com.jingdong.common.utils.HttpGroup;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.model.entity.FloorEntity;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Robin on 2016/6/5.
 */
//c
public class FloorEngine<E extends FloorEntity> {
    public String a = "";
    protected HttpGroup b = null;

    public static void a(HomeFloorNewElement paramHomeFloorNewElement, FloorEntity paramE, int paramInt)
    {
        boolean bool2 = true;
        MallFloorCommonUtil._G localg = paramE.getSeparationDownloadParams(paramInt);
        if (localg != null){
            boolean bool1;
            if (paramHomeFloorNewElement.getImageType() == 1)
                bool1 = true;
            else
                bool1 = false;
            if (localg.a){//if-eqz v4, :cond_3
                if (bool1 == localg.c){
                    bool2 = false;
                }
                localg.b = bool2;
            }else{//:cond_3
                localg.a = true;
            }
            //:goto_3
            paramE.getSeparationParams();
            localg.c = bool1;
            localg.d = MallFloorCommonUtil.null2Str(paramHomeFloorNewElement.getShowName());
            localg.e = MallFloorCommonUtil.null2Str(paramHomeFloorNewElement.getSubtitle());
            localg.text = MallFloorCommonUtil.null2Str(paramHomeFloorNewElement.getLabelWords());
            localg.backgroundColor = MallFloorCommonUtil.str2Color(paramHomeFloorNewElement.getLabelColor(), 0xFFFF0000);
        }
            return;
    }

    protected final void a(final MallFloorEvent paramb)
    {
        new Thread(new Runnable() {//d(this, paramb)
            @Override
            public void run() {

                //:goto_0
                //while (true) {
                    for ( int i = 0; i < 3000; i++) {//if-ge v0, v1, :cond_0
                        synchronized (FloorEngine.this.a) {
                            if (FloorEngine.this.a == null) {//if-eqz v2, :cond_1
                                //:cond_1
                                try {
                                    Thread.sleep(20L);
                                    i += 1;
                                    continue;
                                    //goto :goto_0
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }//:cond_0
                    Bundle localBundle1 = new Bundle();
                    synchronized (FloorEngine.this.a) {
                        if (FloorEngine.this.a != null) {//if-nez v2, :cond_2
                            localBundle1.putString(Constants.a, FloorEngine.this.a);
                            paramb.setBundle(localBundle1);
                            EventBus.getDefault().post(paramb);
                            //goto :goto_1
                        }
                    }
                    //:goto_1
                    return;
               // }
            }
        }).start();
    }

    public void a(HomeFloorNewElement paramHomeFloorNewElement, E paramE) {
        boolean bool1 = true;
        if (paramE != null) {
            String showName = paramHomeFloorNewElement.getShowName();
            String rightCorner = paramHomeFloorNewElement.getRightCorner();

            paramE.setIsShowTitle(!TextUtils.isEmpty(showName));
            paramE.setTitleText(showName);

            paramE.setHasRightCorner(!TextUtils.isEmpty(rightCorner));
            paramE.setRightCornerText(rightCorner);
        }
        return;
    }

    public void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, E paramE) {
        if (paramE == null || paramHomeFloorNewModel == null)
            return;
        paramE.setIsShowTitle("1".equals(paramHomeFloorNewModel.getHead()));
        paramE.setTitleText(paramHomeFloorNewModel.getShowName());
        String rightCorner = paramHomeFloorNewModel.getRightCorner();
        boolean bool;
        int i;

        paramE.setHasRightCorner(!TextUtils.isEmpty(rightCorner));
        paramE.setRightCornerText(rightCorner);
        String logoImage = paramHomeFloorNewModel.getLogoImage();
        paramE.setTitleImgUrl(logoImage);
        i = paramE.getTitleImgDefaultHeight();
        Point p = MallFloorCommonUtil.b(logoImage);
        if ((p.x <= 0) && (p.y <= 0))
            p = null;
        else
            p = new Point((int) (i / p.y * p.x), i);
        paramE.setTitleImgSize(p);
        paramE.setTitleTextColor(MallFloorCommonUtil.str2Color(paramHomeFloorNewModel.getTextColor(), 0xFFFF0000));
        i = paramHomeFloorNewModel.getBottomMargin();
        if (i > 0)
            paramE.setBottomDividerHeight(i);
        return;
    }

    public final void a(HttpGroup paramHttpGroup)
    {
        this.b = paramHttpGroup;
    }

    public final void a(String paramString)
    {
        synchronized (this.a)
        {
            this.a = paramString;
            return;
        }
    }
}
