package com.zy.app.mall.home.floor.d.b;

import com.jingdong.common.entity.Product;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.d.a.PanicFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallListItemFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.PanicFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallPanicFloorUI;
import com.zy.app.mall.utils.JDMiaoShaUtil;
import com.zy.app.mall.utils.ui.view.DateDrawable;
import com.zy.common.utils.Log;
import com.zy.common.utils.MyCountdownTimer;

/**
 * Created by Robin on 2016/6/22.
 */
//l
public class MallPanicFloorPresenter extends MallListItemFloorPresenter<PanicFloorEntity, PanicFloorEngine, IMallPanicFloorUI> {
    private JDMiaoShaUtil e = null;

    public MallPanicFloorPresenter(Class<PanicFloorEntity> paramClass, Class<PanicFloorEngine> paramClass1)
    {
        super(paramClass, paramClass1);
    }

    public static void c(DateDrawable paramu)
    {
        paramu.a("00");
        paramu.b("00");
        paramu.c("00");
    }

    public final void A()
    {
        if (((PanicFloorEntity)this.mFloorEntity).isItemListEmpty())
            ((IMallPanicFloorUI)getUI()).f();
        else
            ((IMallPanicFloorUI)getUI()).a(((Product)((PanicFloorEntity)this.mFloorEntity).getLastItem()).getId());
        try
        {
                ((IMallPanicFloorUI)getUI()).a("Home_SeckillSlideIn", ((PanicFloorEntity)this.mFloorEntity).getMaiDianSourceValue(false));
        }
        catch (Exception localException)
        {
            if (Log.D)
            localException.printStackTrace();
        }
        return;
    }

    public final void B()
    {
        if ("miaosha".equals(((PanicFloorEntity)this.mFloorEntity).getAdvertJump()))
            ((IMallPanicFloorUI)getUI()).f();
        else
            ((IMallPanicFloorUI)getUI()).g();
            ((IMallPanicFloorUI)getUI()).a("Home_BrandSeckill", ((PanicFloorEntity)this.mFloorEntity).getMaiDianSourceValue(false));
            return;
    }

    public final void C()
    {
        JSONObjectProxy localJSONObjectProxy = ((PanicFloorEntity)this.mFloorEntity).getNextRoundObject();
        if (localJSONObjectProxy != null)
        {
            if (!((PanicFloorEngine)this.mFloorEngine).a(localJSONObjectProxy, (PanicFloorEntity)this.mFloorEntity))
                ((PanicFloorEngine)this.mFloorEngine).a(false, (PanicFloorEntity)this.mFloorEntity);
            ((PanicFloorEntity)this.mFloorEntity).clearNextRoundMap();
        }else
            ((PanicFloorEngine)this.mFloorEngine).a(false, (PanicFloorEntity)this.mFloorEntity);
    }

    public final boolean D()
    {
        return "1".equals(((PanicFloorEntity)this.mFloorEntity).getRcJumpType());
    }

    public final float E()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getPageWidth();
    }

    public final int F()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getInnerLayoutLeftRightPadding();
    }

    public final int G()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getInnerLayoutHeight();
    }

    public final int H()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getFootTextViewLeftMargin();
    }

    public final int I()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getDisCountMaxLength();
    }

    public final int J()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getAdvertRightDividerLineHeight();
    }

    public final int K()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getAdvertRightDividerLineTopMargin();
    }

    public final String L()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getNameText();
    }

    public final int M()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getBuyTimeLayoutWidth();
    }

    public final int N()
    {
        return ((PanicFloorEntity)this.mFloorEntity).getBuyTimeLayoutHeight();
    }

    public final void a(MallFloorEvent paramb) {
        if (getUI() == null)
            return;
        String str = paramb.getType();
        int i = -1;
        switch (str.hashCode()) {
            case 49:    //:pswitch_0 0x31
                if (str.equals("1"))
                    i = 0;
        }
        switch (i) {
            case 0://:pswitch_1
                getUI().a(this.mFloorEntity.getContentHeight() + this.mFloorEntity.getViewPagerBottomMargin()
                        , this.mFloorEntity.getViewPagerTopMargin()
                        , this.mFloorEntity.getViewPagerBottomMargin());
                return;
        }
        super.onEventMainThread(paramb);
        return;
    }

    public final void a(DateDrawable paramu)
    {
        PanicFloorEntity.BuyTimeViewData localBuyTimeViewData = ((PanicFloorEntity)this.mFloorEntity).getBuyTimeViewData();
        paramu.b(localBuyTimeViewData.getTimePointColor());
        paramu.c(localBuyTimeViewData.getBackgroundColor());
        paramu.d(localBuyTimeViewData.getBackgroundWidth());
        paramu.e(localBuyTimeViewData.getBackgroundHeight());
        paramu.a(localBuyTimeViewData.getTimeTextColor());
        paramu.a(localBuyTimeViewData.getTimeTextSizePx());
    }

    public final void a(long[] paramArrayOfLong)
    {
        int i = ((PanicFloorEntity)this.mFloorEntity).getMiaoshaAdvance();
        int j = i / 60;
        JSONObjectProxy localJSONObjectProxy = ((PanicFloorEntity)this.mFloorEntity).getNextRoundObject();
        if ((paramArrayOfLong[0] == 0L) && (paramArrayOfLong[1] == j) && (paramArrayOfLong[2] == i % 60) && (localJSONObjectProxy == null))
            ((PanicFloorEngine)this.mFloorEngine).a(true, (PanicFloorEntity)this.mFloorEntity);
    }

    public final void b(final DateDrawable paramu)
            throws Exception
    {
        if (this.e != null)
            this.e.a();
        this.e = new JDMiaoShaUtil();
        PanicFloorEntity.BuyTimeViewData localBuyTimeViewData = ((PanicFloorEntity)this.mFloorEntity).getBuyTimeViewData();
        long l2 = System.currentTimeMillis() - localBuyTimeViewData.getTimeMillis();
        long l1 = 0L - l2;
        l2 = Math.abs(localBuyTimeViewData.getTimeRemain()) * 1000L - l2;
        if ((l1 <= 0L) && (l2 <= 0L))
        {
            c(paramu);
            paramu.invalidateSelf();
            return;
        }
        this.e.a(l1, l2, new JDMiaoShaUtil._AW(){//m(this, paramu)
            @Override
            public void changed(MyCountdownTimer paramdi, long paramLong, long[] paramArrayOfLong, int paramInt) {
                if (paramArrayOfLong == null)
                    return;
                try {
                    String str1 = Long.toString(paramArrayOfLong[0]);
                    String str2 = Long.toString(paramArrayOfLong[1]);
                    String str3 = Long.toString(paramArrayOfLong[2]);

                    //paramdi = (MyCountdownTimer)localObject2;
                    if (str1.length() <= 1)
                        str1 = "0" + (String) str1;
                    paramu.a(str1);

                    //paramdi = (MyCountdownTimer)localObject1;
                    if (str2.length() <= 1)
                        str2 = "0" + (String) str2;
                    paramu.b(str2);

                    //paramdi = str;
                    if (str3.length() <= 1)
                        str3 = "0" + str3;
                    ((DateDrawable) paramu).c(str3);
                    paramu.invalidateSelf();
                    MallPanicFloorPresenter.this.a(paramArrayOfLong);
                } catch (Exception e) {
                    if (Log.D)
                        e.printStackTrace();
                }


            }

            @Override
            public boolean finish(MyCountdownTimer paramdi, long paramLong, int paramInt) {
                MallPanicFloorPresenter.c(paramu);
                MallPanicFloorPresenter.this.C();
                return false;
            }
        });
    }

    public final void c(int paramInt)
    {
        Product localProduct = (Product)((PanicFloorEntity)this.mFloorEntity).getItemByPosition(paramInt);
        ((IMallPanicFloorUI)getUI()).a(localProduct, ((PanicFloorEntity)this.mFloorEntity).isTestA());
    }

}
