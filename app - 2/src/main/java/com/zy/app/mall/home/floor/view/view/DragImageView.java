package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zy.common.utils.DPIUtil;

/**
 * Created by Robin on 2016/5/5.
 */
public class DragImageView extends SimpleDraweeView {
    private boolean isMove = false;
    private int mX;
    private int mY;
    private int d;
    private int e;
    private int f = DPIUtil.getWidth();
    private int g = DPIUtil.getHeight();
    private Drawable drawable;
    private RelativeLayout parentLayout;
    private RelativeLayout.LayoutParams layoutParams;
    private SimpleDraweeView simpleDraweeView;
    private Handler l = new Handler();
    private int m = DPIUtil.getWidth() * 90 / 720;

    public DragImageView(Context paramContext) {
        super(paramContext);
    }

    public DragImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.mX = (int) motionEvent.getX();
                this.mY = (int) motionEvent.getY();
                this.drawable = getDrawable();
        }
        return super.dispatchTouchEvent(motionEvent);

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN://;0://:pswitch_0
                break;
            case MotionEvent.ACTION_MOVE://2://:pswitch_1
                if (!this.isMove) {
                    this.isMove = true;
                    setVisibility(INVISIBLE);
                    this.parentLayout = ((RelativeLayout) getParent());
                    this.layoutParams = new RelativeLayout.LayoutParams(getWidth(), getHeight());
                    this.layoutParams.leftMargin = getLeft();
                    this.layoutParams.topMargin = getTop();
                    this.simpleDraweeView = new SimpleDraweeView(getContext());
                    this.simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.simpleDraweeView.setImageDrawable(this.drawable);
                    this.parentLayout.addView(this.simpleDraweeView, this.layoutParams);
                }
                this.d = (int) (getLeft() + motionEvent.getX() - this.mX);
                this.e = (int) (getTop() + motionEvent.getY() - this.mY);
                if (this.d > this.parentLayout.getWidth() - getWidth()) {
                    this.d = (this.parentLayout.getWidth() - getWidth());
                } else if (this.d < 0) {
                    this.d = 0;
                }
                if (this.e > this.parentLayout.getHeight() - getHeight())
                    this.e = (this.parentLayout.getHeight() - getHeight());
                else if (this.e < 0)
                    this.e = 0;

                this.layoutParams.leftMargin = this.d;
                this.layoutParams.topMargin = this.e;
                if (this.simpleDraweeView != null)
                    this.simpleDraweeView.setLayoutParams(this.layoutParams);
                break;

            case  MotionEvent.ACTION_UP://1://:pswitch_2
                if (this.simpleDraweeView != null) {//if-eqz v0, :cond_8
                    if (this.isMove)//if-eqz v0, :cond_6
                    {
                        if (this.d + this.simpleDraweeView.getWidth() / 2 >= this.parentLayout.getWidth() / 2) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getWidth(), getHeight());
                            new RelativeLayout.LayoutParams(getWidth(), getHeight());
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                            layoutParams.topMargin = this.e;
                            setLayoutParams(layoutParams);
                            TranslateAnimation translateAnimation = new TranslateAnimation(0.0F, this.f - this.simpleDraweeView.getRight(), 0.0F, 0.0F);
                            translateAnimation.setDuration(100L);
                            this.simpleDraweeView.startAnimation(translateAnimation);
                            translateAnimation.setAnimationListener(new Animation.AnimationListener(){//d(this)
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    //DragImageView.a(this.a);
                                    if(DragImageView.this.simpleDraweeView != null){
                                        DragImageView.this.parentLayout.removeView(DragImageView.this.simpleDraweeView);
                                        DragImageView.this.simpleDraweeView = null;
                                    }
                                    DragImageView.this.setVisibility(0);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        } else {
                            this.layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getWidth(), getHeight());
                            layoutParams.leftMargin = 0;
                            layoutParams.topMargin = this.e;
                            setLayoutParams(layoutParams);
                            TranslateAnimation translateAnimation = new TranslateAnimation(0.0F, -this.simpleDraweeView.getLeft(), 0.0F, 0.0F);
                            translateAnimation.setDuration(100L);
                            this.simpleDraweeView.startAnimation(translateAnimation);
                            translateAnimation.setAnimationListener(new Animation.AnimationListener(){//e(this)
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    //DragImageView.a(this.a);
                                    if(DragImageView.this.simpleDraweeView != null){
                                        DragImageView.this.parentLayout.removeView(DragImageView.this.simpleDraweeView);
                                        DragImageView.this.simpleDraweeView = null;
                                    }
                                    DragImageView.this.setVisibility(0);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                    }
                } else
                    setVisibility(0);
                this.isMove = false;
                break;
        }
        return true;
    }

}
