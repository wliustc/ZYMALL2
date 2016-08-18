package com.zy.app.mall.home.floor.b;

import android.text.TextUtils;

import com.jingdong.app.mall.home.floor.b.IFloorFigureView;
import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.app.mall.utils.ui.view.CarouseFigureImagePagerAdapter;
import com.zy.app.mall.R;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.common.channel.common.utils.JumpUtil;
import com.zy.common.entity.Commercial;
import com.zy.common.entity.JumpEntity;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/6/17.
 */
//e
public class NewCarouselFigureViewCtrl {
    JDHomeFragment mHomeFragment;

    public final void a(final JDHomeFragment paramJDHomeFragment, IFloorFigureView floorFigureView, JSONArrayProxy jSONArrayPoxy)
    {
        this.mHomeFragment = paramJDHomeFragment;
        if (jSONArrayPoxy != null){
            final ArrayList<Commercial> list = Commercial.toList(jSONArrayPoxy, 0);
            if ((list != null) && (list.size() > 0))
                floorFigureView.setFigureViewAdapterData(new CarouseFigureImagePagerAdapter.DataPresenter(){//f((this, list, paramJDHomeFragment)
                    @Override
                    public int size() {
                        return list.size();
                    }

                    @Override
                    public String getImage(int index) {
                        return ((Commercial)list.get(index)).getHorizontalImg();
                    }

                    @Override
                    public JDDisplayImageOptions getDisplayImageOptions() {
                        return new JDDisplayImageOptions().showImageOnFail(R.drawable.homepage_carousel_defaulte).showImageOnLoading(R.drawable.homepage_carousel_defaulte);//2130839367 //2130839367
                    }

                    @Override
                    public void onClick(int paramInt) {
                        if (!CommonUtil.getInstance().isCanClick())
                            return;
                        if ((list.get(paramInt) != null) && (!TextUtils.isEmpty(((Commercial)list.get(paramInt)).getClickUrl())))
                        {
                            HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
                            localHttpSetting.setUrl(((Commercial)list.get(paramInt)).getClickUrl());
                            localHttpSetting.setPost(false);
                            paramJDHomeFragment.thisActivity.getHttpGroupaAsynPool().add(localHttpSetting);
                        }
                        NewCarouselFigureViewCtrl.jump(NewCarouselFigureViewCtrl.this, (Commercial)list.get(paramInt));
                    }
                });
        }
        return;

    }

    static void jump(NewCarouselFigureViewCtrl newCarouselFigureViewCtrl, Commercial commercial)
    {
        if (CommonUtil.getInstance().isCanClick())
        {
            JumpEntity jump = commercial.getJump();
            if (jump != null)
            {
                JumpUtil.a(newCarouselFigureViewCtrl.mHomeFragment.thisActivity, jump, 1);
                String srv = jump.getSrv();
                JDMtaUtils.sendCommonData(newCarouselFigureViewCtrl.mHomeFragment.thisActivity, "Home_FocusPic", srv, "", newCarouselFigureViewCtrl.mHomeFragment, "", "", "", Constants.b);
            }
        }
    }
}
