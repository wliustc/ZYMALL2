package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.b.FloorFigureViewCtrl;
import com.zy.app.mall.home.floor.d.a.AnnouncementFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallAnnouncementFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.AnnouncementFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallAnnouncementFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.app.mall.home.floor.view.view.JDViewFlipper;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.utils.JDImageUtils;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by robin on 16-7-12.
 */
public class MallFloor_Announcement extends MallBaseFloor<MallAnnouncementFloorPresenter>
        implements IMallAnnouncementFloorUI, Observer {
    private SimpleDraweeView h = null;
    private JDViewFlipper i = null;
    private JDDisplayImageOptions j = new JDDisplayImageOptions().showImageOnFail(R.drawable.gonggaolan_default).showImageOnLoading(R.drawable.gonggaolan_default);//2130839273   //2130839273

    public MallFloor_Announcement(Context paramContext) {
        super(paramContext);
    }

    public MallFloor_Announcement(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MallFloor_Announcement(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public final void a() {
        if ((this.i == null) || (this.i.getChildCount() <= 1))
            return;
        this.i.setInAnimation(getContext(), R.anim.in_animation_bottom);//2130968619
        this.i.setOutAnimation(getContext(), R.anim.out_animation_top);//2130968638
        this.i.showNext();
    }

    public final void a(float paramFloat) {
        ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat}, null, null));
        localShapeDrawable.getPaint().setColor(0xFFFFFFFF);
        localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        setBackgroundDrawable(localShapeDrawable);
    }

    public final void a(int paramInt, float paramFloat) {
        if (this.i == null) {
            this.i = new JDViewFlipper(getContext());
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            layoutParams.addRule(1, this.h.getId());
            this.i.setLayoutParams(layoutParams);
            addView(this.i);
        }
        this.i.removeAllViews();
        MallAnnouncementFloorPresenter presenter = i();
        if (presenter.c())
            removeAllViews();
        else {
            int m = presenter.d();
            //:goto_0
            for (int k = 0; k < m; k++) {//if-ge v1, v3, :cond_1
                HomeFloorNewElement localHomeFloorNewElement = presenter.a(k);
                LinearLayout localLinearLayout = new LinearLayout(getContext());
                localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                localLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
                localLinearLayout.setGravity(Gravity.CENTER_VERTICAL);//16
                i();
                TextView localTextView;
                if (!TextUtils.isEmpty(localHomeFloorNewElement.getSlogan())) {
                    localTextView = new TextView(getContext());
                    localTextView.setIncludeFontPadding(false);
                    localTextView.setText(localHomeFloorNewElement.getSlogan());
                    localTextView.setTextColor(getResources().getColor(R.color.announcement_red));//2131099731
                    localTextView.setTextSize(1, paramFloat);
                    localLinearLayout.addView(localTextView);
                }
                if (!TextUtils.isEmpty(localHomeFloorNewElement.getAnnouncementContent())) {
                    localTextView = new TextView(getContext());
                    localTextView.setText(localHomeFloorNewElement.getAnnouncementContent());
                    localTextView.setTextColor(getResources().getColor(R.color.announcement_black));//2131099730
                    localTextView.setTextSize(1, paramFloat);
                    localTextView.setEllipsize(TextUtils.TruncateAt.END);
                    localTextView.setSingleLine();
                    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    localLayoutParams.leftMargin = (paramInt / 2);
                    localLinearLayout.addView(localTextView, localLayoutParams);
                }
                a(localLinearLayout, localHomeFloorNewElement);
                this.i.addView(localLinearLayout);

            }
        }
        return;
    }

    public final void a(int paramInt1, int paramInt2) {
        if (b(paramInt1, paramInt2, getTop(), getHeight()))
            e();
    }

    public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString) {
        FloorFigureViewCtrl.getInstance().addObserver(this);
        if (this.h == null) {
            this.h = new SimpleDraweeView(getContext());
            this.h.setId(R.id.mallfloor_announcement_leftimage);//2131165400
            addView(this.h);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
        localLayoutParams.rightMargin = paramInt3;
        localLayoutParams.addRule(CENTER_VERTICAL);
        this.h.setLayoutParams(localLayoutParams);
        this.h.setScaleType(ImageView.ScaleType.FIT_XY);
        JDImageUtils.displayImage(paramString, this.h, this.j, false);
    }

    public final void a(Runnable paramRunnable, int paramInt) {
        this.e.post(paramRunnable, paramInt);
    }

    public final void b(int paramInt1, int paramInt2) {
        super.b(paramInt1, paramInt2);
        a(paramInt1, paramInt2);
    }

    public final void e() {
        i().b();
    }

    public final void k() {
        super.k();
        FloorFigureViewCtrl.getInstance().addObserver(this);
    }

    public void update(Observable paramObservable, Object paramObject) {
        if (paramObject == FloorFigureViewCtrl.b.PAUSEALL) {
            i();
            MallAnnouncementFloorPresenter.a();
        } else if (paramObject != FloorFigureViewCtrl.b.RESUMEALL)
            e();
        return;
    }

    @Override
    protected MallAnnouncementFloorPresenter h() {
        return new MallAnnouncementFloorPresenter(AnnouncementFloorEntity.class, AnnouncementFloorEngine.class);
    }
}
