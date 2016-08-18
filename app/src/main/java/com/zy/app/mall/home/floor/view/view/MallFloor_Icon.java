package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jingdong.app.mall.home.floor.view.adapter.MallIconFloorAdapter;
import com.jingdong.app.mall.utils.CommonUtil;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.d.a.IconFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallIconFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.IconFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallIconFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.common.channel.common.utils.JumpUtil;
import com.zy.common.entity.AppEntry;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.ui.JDGridView;
import com.zy.common.utils.JDMtaUtils;

/**
 * Created by robin on 16-7-5.
 */
public class MallFloor_Icon extends MallBaseFloor<MallIconFloorPresenter>
        implements IMallIconFloorUI {
    private JDGridView h = null;
    private MallIconFloorAdapter i = null;
    private boolean j = false;

    public MallFloor_Icon(Context paramContext, int paramInt1, int paramInt2)
    {
        super(paramContext);
        MallIconFloorPresenter presenter = (MallIconFloorPresenter)i();
        presenter.a(5);
        presenter.b(2);
    }

    public MallFloor_Icon(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public MallFloor_Icon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
        return null;
    }

    public final synchronized void a(int paramInt1, int paramInt2)
    {
            MallIconFloorPresenter presenter = i();
            if (presenter.j()){
                this.h = new JDGridView(getContext());
                RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
                this.h.setLayoutParams(localLayoutParams);
                this.h.setFocusable(false);
                this.h.setNumColumns(paramInt1);
                this.h.setVerticalScrollBarEnabled(false);
                this.h.setVerticalSpacing(paramInt2);
                this.h.setGravity(17);
                this.h.setSelector(new ColorDrawable(0));
                this.i = new MallIconFloorAdapter(getContext(), presenter, this.j);
                this.h.setAdapter(this.i);
                this.h.setOnItemClickListener(new AdapterView.OnItemClickListener() {//x(this))
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        MallFloor_Icon.this.a(view, position);
                    }
                });
                addView(this.h);
                if (getVisibility() != VISIBLE)
                    setVisibility(VISIBLE);
            }
                return;
    }

    public final void a(Bitmap paramBitmap)
    {
        if (paramBitmap != null)
        {
            this.j = true;
            setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), paramBitmap));
            if (this.h != null)
            {
                TextView textView = (TextView)this.h.findViewById(R.id.home_icon_text);//2131165369
                if (textView != null)
                    textView.setTextColor(i().h());
            }
        }
    }

    protected final void a(View paramView, int paramInt)
    {
        if (!CommonUtil.getInstance().isCanClick())
            return;
        MallIconFloorPresenter presenter = i();
        paramView.findViewById(R.id.home_icon_reddot).setVisibility(GONE);//2131165368
        AppEntry appEntry = presenter.c(paramInt);
        JumpUtil.a(this.e.thisActivity, appEntry.getJump(), 1);
        String str = presenter.a(appEntry);
        JDMtaUtils.onClickWithPageId(this.e.thisActivity.getApplicationContext(), "Home_Shortcut", this.e.getClass().getName(), str, Constants.b);
    }

    public final void a(boolean paramBoolean) {
        setVisibility(paramBoolean? VISIBLE :GONE );
        return;
    }

    public final void c()
    {
        setBackgroundDrawable(null);
    }

    @Override
    protected MallIconFloorPresenter h() {
        return new MallIconFloorPresenter(IconFloorEntity.class, IconFloorEngine.class);
    }

    public final void k()
    {
        if ((this.h != null) && (this.i != null))
            this.h.setAdapter(this.i);
        super.k();
    }

    public final void l()
    {
    }

    public final void m()
    {
    }
}
