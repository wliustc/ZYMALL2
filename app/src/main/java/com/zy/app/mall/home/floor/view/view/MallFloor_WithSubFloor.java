package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.a.b.MallFloorTypeUtil;
import com.zy.app.mall.home.floor.d.a.WithSubFloorFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallWithSubFloorFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.WithSubFloorFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallWithSubFloorFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by robin on 16-7-12.
 */
public class MallFloor_WithSubFloor extends MallBaseFloor<MallWithSubFloorFloorPresenter> implements IMallWithSubFloorFloorUI {
    private HashMap<String, View> h = new HashMap();

    public MallFloor_WithSubFloor(Context paramContext)
    {
        super(paramContext);
    }

    public MallFloor_WithSubFloor(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public MallFloor_WithSubFloor(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void d(int paramInt1, int paramInt2)
    {
        Iterator localIterator = this.h.entrySet().iterator();
        //:cond_0
        //:goto_0
        while (localIterator.hasNext()){//if-eqz v0, :cond_4
            View localView = (View)((Map.Entry)localIterator.next()).getValue();
            if (((localView.getTop() < paramInt1) || (localView.getTop() > paramInt2))
                    && ((localView.getTop() + localView.getHeight() < paramInt1) || (localView.getTop() + localView.getHeight() > paramInt2)))
                continue;
            if ((localView instanceof MallFloor_Banner))
                ((MallFloor_Banner)localView).a();
            else if (localView instanceof MallFloor_Announcement)
                ((MallFloor_Announcement)localView).e();
        }//:cond_4
    }

    public final int a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, int p3, int p4) {
        if ((paramHomeFloorNewElements.getData() == null) || (paramHomeFloorNewElements.getData().size() == 0))
            removeAllViews();
        else {

            StringBuffer sb = new StringBuffer();

            //:goto_1
            for (int i = 0; i < paramHomeFloorNewElements.getData().size(); i++) {
                sb.append(((HomeFloorNewElement) paramHomeFloorNewElements.getData().get(i)).getId()).append(",");
            }
            //:cond_3

            /*String str = Md5Encrypt.md5(paramHomeFloorNewElements.getTpl() + sb.toString());*/
            String str = paramHomeFloorNewElements.getTpl() + "*" + sb.toString();
            View localObject = (View) this.h.get(str);
            if (localObject == null) {//if-nez v0, :cond_8
                localObject = MallFloorCommonUtil.getMallFloorLayout(getContext(), MallFloorTypeUtil.getFloorTypeByFloorElements(paramHomeFloorNewElements));
            }//else {
            //move-object v1, v0
            //}
            //:goto_2
            if (localObject != null) {//if-eqz v1, :cond_1
                if (((View) localObject).getParent() == null)
                    addView((View) localObject);
                if ((localObject instanceof MallBaseFloor)) {//if-eqz v0, :cond_5
                    ((MallBaseFloor) localObject).b(true);
                    ((MallBaseFloor) localObject).a(this.e, paramHomeFloorNewModel, paramHomeFloorNewElements, this.f);
                }//:cond_5
                ViewGroup.LayoutParams layoutParams = ((View) localObject).getLayoutParams();
                if ((p3 != 0) && (layoutParams != null)) {//if-eqz p3, :cond_6
                    if (!(layoutParams instanceof RelativeLayout.LayoutParams))//if-eqz v2, :cond_7
                        layoutParams = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, p3);
                    ((View) localObject).setLayoutParams(layoutParams);
                }//:cond_6
                ((View) localObject).setId(p4);
                this.h.put(str, localObject);
                return p4;

            }
        }
        //:cond_1
        //:goto_0
        return p3;
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
        return null;
    }

    public final void a(int paramInt1, int paramInt2)
    {
        if (b(paramInt1, paramInt2, getTop(), getHeight()))
        {
            if ((getTop() <= paramInt1) || (getTop() >= paramInt1 + paramInt2)){
                if ((getTop() + getHeight() > paramInt1) && (getTop() + getHeight() < paramInt1 + paramInt2))
                    d(paramInt1 - getTop(), getHeight());
            }else
                d(0, paramInt2 - (getTop() - paramInt1));
        }
        return;

    }

    public final void a(Bitmap paramBitmap)
    {
    }

    public final void a(boolean paramBoolean)
    {
    }

    public final void b(int paramInt1, int paramInt2)
    {
        super.b(paramInt1, paramInt2);
        a(paramInt1, paramInt2);
    }

    public final void c()
    {
    }

    public final void d()
    {
    }

    @Override
    protected MallWithSubFloorFloorPresenter h() {
        return new MallWithSubFloorFloorPresenter(WithSubFloorFloorEntity.class, WithSubFloorFloorEngine.class);
    }

    public void hideProgress()
    {
    }

    public boolean isRetain()
    {
        return false;
    }

    public final void j()
    {
        super.j();
        if (this.h != null){
            Iterator localIterator = this.h.entrySet().iterator();
            while (localIterator.hasNext())
            {
                Object localObject = ((Map.Entry)localIterator.next()).getValue();
                if ((localObject != null) && (localObject instanceof MallBaseFloor))
                    ((MallBaseFloor)localObject).j();
            }
        }
        return;
    }

    public final void k()
    {
        super.k();
        Iterator localIterator = this.h.entrySet().iterator();
        while (localIterator.hasNext())
        {
            View localView = (View)((Map.Entry)localIterator.next()).getValue();
            if (localView instanceof MallBaseFloor)
                ((MallBaseFloor)localView).k();
        }
    }

    public final void l()
    {
    }

    public final void m()
    {
    }

    public void showProgress()
    {
    }
}
