package com.zy.app.mall.home.floor.view.baseUI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import com.jingdong.app.mall.home.floor.a.b.MallFloorImageCacheUtil;
import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.common.BaseActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.a.b.MallFloorClickUtil;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.d.b.MallFloorPresenter;
import com.zy.app.mall.home.floor.view.baseUI.IMallFloorUI;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.app.util.image.listener.JDImageLoadingListener;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.DPIUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Robin on 2016/5/16.
 */
public abstract class MallBaseFloor<P extends MallFloorPresenter> extends RelativeLayout implements IMallFloorUI {
    protected final int a = 256;
    protected final int b = 512;
    protected final int c = 768;
    protected P mPresenter;  //d
    protected JDHomeFragment e = null;
    protected ViewGroup f = null;
    protected MallFloorImageCacheUtil g = null;
    private Unbinder mUnbinder;

    public MallBaseFloor(Context paramContext)
    {
        this(paramContext, null);
    }

    public MallBaseFloor(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    public MallBaseFloor(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        a();
    }

    private TextView a(String paramString, int paramInt1, float paramFloat1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, Point paramPoint, float paramFloat2)
    {
        TextView localTextView = new TextView(getContext());
        a(localTextView, paramString, paramInt1, -1.0F, -2, -2, 16777215, paramArrayOfInt, paramPoint, paramFloat2);
        return localTextView;
    }

    private SimpleDraweeView a(int paramInt1, HomeFloorNewElement paramHomeFloorNewElement, ViewGroup paramViewGroup, int paramInt2)
    {
        SimpleDraweeView localSimpleDraweeView = e().a(paramInt1);
        if (localSimpleDraweeView == null)
            return null;
        if (paramHomeFloorNewElement != null)
            a(localSimpleDraweeView, paramHomeFloorNewElement);
        ViewParent view = localSimpleDraweeView.getParent();
        if (view != null){//if-eqz v0, :cond_3
            ViewGroup viewGroup = (ViewGroup)view;
            if (paramInt2 < 0)
                paramInt2 = viewGroup.indexOfChild(localSimpleDraweeView);
            viewGroup.removeViewAt(paramInt2);
        }
        if (localSimpleDraweeView.getParent() == null){//if-nez v0, :cond_4
            if (paramInt2 < 0)//if-gez p4, :cond_5
                paramViewGroup.addView(localSimpleDraweeView);
            else
                paramViewGroup.addView(localSimpleDraweeView, paramInt2);
        }
        return localSimpleDraweeView;

    }

    //private void a()
    private void a()
    {
        if (this.mPresenter == null)
            this.mPresenter = h();
        if (this.mPresenter != null)
            this.mPresenter.attachUI(this);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    private static void a(TextView paramTextView, String text, int textColor, float textSize1, int w, int h, int backgroundColor, int[] paramArrayOfInt, Point paramPoint, float textSize2) {
        paramTextView.setTextColor(textColor);
        if (textSize2 < 0.0F)
            paramTextView.setTextSize(1, textSize1);
        else
            paramTextView.setTextSize(0, textSize2);

        paramTextView.setText(text);
        paramTextView.setBackgroundColor(backgroundColor);
        paramTextView.setSingleLine();
        LayoutParams layoutParams = new LayoutParams(w, h);
        int j = paramArrayOfInt.length;
        int bottom = 0;
        int right = 0;
        int top = 0;
        int left = 0;
        textColor = 0;
        //:goto_1
        while (textColor < j) {//if-ge v5, v7, :cond_5
            int k = paramArrayOfInt[textColor];
            if (k == 9)
                left = paramPoint.x;
            if (k == 10)
                top = paramPoint.y;
            if (k == 11)
                right = paramPoint.x;
            if (k == 12)
                bottom = paramPoint.y;
            layoutParams.addRule(k);
            textColor += 1;
        }
        layoutParams.setMargins(left, top, right, bottom);
        paramTextView.setLayoutParams(layoutParams);
    }

    public static boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        return (paramInt1 <= paramInt3 + paramInt4) && (paramInt1 >= paramInt3 - paramInt2);
    }

    private MallFloorImageCacheUtil e()
    {
        if (this.g == null)
            this.g = new MallFloorImageCacheUtil();
        return this.g;
    }

    protected final int a(MallFloorCommonUtil._F paramf, RelativeLayout paramRelativeLayout, int paramInt) {
        Object localObject2 = paramf.a(paramInt);
        Object localObject1 = paramRelativeLayout.findViewWithTag(Integer.valueOf(256));
        View localView = paramRelativeLayout.findViewWithTag(Integer.valueOf(512));
        if (localObject1 != null)
            ((View) localObject1).setVisibility(INVISIBLE);
        if (localView != null)
            localView.setVisibility(INVISIBLE);
        if (localObject2 == null)//if-nez v12, :cond_2
            return 0;
        //:cond_2
        Point localPoint = paramf.d;
        //label164:
        int i;
        if (localObject1 == null) {//if-nez v1, :cond_3
            localObject1 = ((MallFloorCommonUtil._G) localObject2).d;
            paramInt = paramf.b;
            float f1 = paramf.c;
            localObject1 = a((String) localObject1, paramInt, -1.0F, -2, -2, 16777215, new int[]{9, 10}, localPoint, f1);
            ((TextView) localObject1).getPaint().setFakeBoldText(true);
            ((TextView) localObject1).setTag(Integer.valueOf(256));
            paramRelativeLayout.addView((View) localObject1);
        } else {
            ((TextView) localObject1).setText(((MallFloorCommonUtil._G) localObject2).d);
        }
        //:goto_1
        if (((TextView) localObject1).getText().length() != 0)   //if-eqz v2, :cond_4
            paramInt = VISIBLE;
        else
            paramInt = INVISIBLE;
        //:goto_2
        ((TextView) localObject1).setVisibility(paramInt);
        ((TextView) localObject1).bringToFront();
        localObject1 = ((TextView) localObject1).getPaint();
        paramInt = localPoint.y;
        i = (int) (((Paint) localObject1).descent() - ((Paint) localObject1).ascent() + 0.5F) + paramInt + paramf.h.y;
        TextView textView = null;
        if (localView == null) {  //if-nez v11, :cond_5
            localObject1 = ((MallFloorCommonUtil._G) localObject2).e;
            paramInt = paramf.f;
            localObject2 = new Point(paramf.h.x, i);
            float f1 = paramf.g;
            textView = a((String) localObject1, paramInt, -1.0F, -2, -2, 16777215, new int[]{9, 10}, (Point) localObject2, f1);
            textView.setTag(Integer.valueOf(512));
            paramRelativeLayout.addView(textView);
        } else {
            textView = (TextView) localView;
            textView.setText(((MallFloorCommonUtil._G) localObject2).e);
        }
        //:goto_3
        if (textView.getText().length() != 0) //if-eqz v2, :cond_6
            paramInt = VISIBLE;
        else
            paramInt = INVISIBLE;
        //:goto_4
        textView.setVisibility(paramInt);
        textView.bringToFront();
        TextPaint paint = textView.getPaint();
        return (int) (paint.descent() - paint.ascent() + 0.5F) + i;
    }

    protected final RelativeLayout a(boolean isRemoveChild, int childIndex, int w, int h, int backgroundColor) {
        if (isRemoveChild) {
            removeViewAt(childIndex);
            b(childIndex);
        }
        RelativeLayout relativeLayout = null;
        if ((!isRemoveChild) && (getChildCount() > childIndex) && (getChildAt(childIndex) == null) && (getChildAt(childIndex) instanceof RelativeLayout))
            relativeLayout = (RelativeLayout) getChildAt(childIndex);

        if (relativeLayout == null) {
            relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(w, h));
        }
        relativeLayout.setBackgroundColor(backgroundColor);
        return relativeLayout;
    }

    protected final SimpleDraweeView a(int paramInt, HomeFloorNewElement paramHomeFloorNewElement, ViewGroup paramViewGroup)
    {
        return a(paramInt, paramHomeFloorNewElement, paramViewGroup, -1);
    }

    protected final SimpleDraweeView a(MallFloorCommonUtil._F paramf, RelativeLayout paramRelativeLayout, String paramString, int paramInt) {
        SimpleDraweeView localSimpleDraweeView2 = a(paramInt, null, paramRelativeLayout, 0);
        int left;
        int top;
        int bottom = paramf.s.x;
        int right = paramf.s.y;
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 9;
        arrayOfInt[1] = 10;

        switch (_R.a[paramf.p.ordinal()]) {
            case 1: //:pswitch_0
                top = right;
                left = bottom;
                bottom = 0;
                right = 0;
                break;
            case 2: //:pswitch_1
                arrayOfInt[0] = 11;
                top = right;
                left = 0;
                bottom = 0;
                right = paramf.s.x;
                break;
            case 3: //:pswitch_2
                arrayOfInt[1] = 12;
                top = 0;
                left = bottom;
                bottom = paramf.s.y;
                right = 0;
                break;
            case 4: //:pswitch_3
                arrayOfInt[0] = 11;
                arrayOfInt[1] = 12;
                top = 0;
                left = 0;
                bottom = paramf.s.y;
                right = paramf.s.x;
                break;
            case 5: //:pswitch_4
                arrayOfInt[0] = 13;
                arrayOfInt[1] = -1;
                top = 0;
                left = 0;
                bottom = 0;
                right = 0;
            default:
                top = right;
                left = bottom;
                right = 0;
                bottom = 0;
        }
        //:goto_0
        localSimpleDraweeView2 = localSimpleDraweeView2;
        if (localSimpleDraweeView2 == null) {
            localSimpleDraweeView2 = c(paramf.q, paramf.r);
            a(localSimpleDraweeView2, paramString, paramInt);
        }
        LayoutParams layoutParams = (LayoutParams) localSimpleDraweeView2.getLayoutParams();
        layoutParams.setMargins(left, top, right, bottom);

        for (int ii = 0; ii < 2; ii++)
            layoutParams.addRule(arrayOfInt[ii]);

        localSimpleDraweeView2.setLayoutParams(layoutParams);
        if (localSimpleDraweeView2.getParent() == null)
            paramRelativeLayout.addView(localSimpleDraweeView2, 0);
        return localSimpleDraweeView2;
    }

    public Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
        return null;
    }

    public final void a(int paramInt)
    {
        if (paramInt <= 0)
            paramInt = -2;
        if (i().k())
            setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
        else
            setLayoutParams(new LinearLayout.LayoutParams(-1, paramInt));
    }

    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        Object localObject = getLayoutParams();
        if (localObject != null) {
            if (i().k()) {
                if ((localObject instanceof RelativeLayout.LayoutParams)) {
                    ((RelativeLayout.LayoutParams) localObject).setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
                    setLayoutParams((ViewGroup.LayoutParams) localObject);
                }
            } else if (localObject instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) localObject).setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
                setLayoutParams((ViewGroup.LayoutParams) localObject);
            }
        }
                return;
    }

    public void a(Bitmap paramBitmap)
    {
    }

    protected final void a(View paramView, final HomeFloorNewElement paramHomeFloorNewElement)
    {
        if (paramHomeFloorNewElement == null)
            return;
        paramHomeFloorNewElement.getJumpType();
        paramHomeFloorNewElement.getUrl();
        paramHomeFloorNewElement.getJumpTo();
        paramView.setOnClickListener(new View.OnClickListener(){//q(this, paramHomeFloorNewElement.getSourceValue(), paramHomeFloorNewElement.getParam(), paramHomeFloorNewElement)
            @Override
            public void onClick(View v) {
                if (!CommonUtil.getInstance().isCanClick())
                    return;
                MallFloorClickUtil.a(MallBaseFloor.this.e.thisActivity, this, paramHomeFloorNewElement.getSourceValue(), paramHomeFloorNewElement.getParam(), paramHomeFloorNewElement.getJump());
            }
        });
    }

    protected final void a(SimpleDraweeView paramSimpleDraweeView, String paramString, int paramInt)
    {
        e().a(paramSimpleDraweeView, paramString, paramInt);
    }

    public synchronized void a(JDHomeFragment paramJDHomeFragment, HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, ViewGroup paramViewGroup)
    {

            a();
            this.e = paramJDHomeFragment;
            this.f = paramViewGroup;
            P mallFloorPresenter = i();
            mallFloorPresenter.a(paramJDHomeFragment.thisActivity.getHttpGroupWithNPSGroup());
            mallFloorPresenter.b(paramHomeFloorNewModel, paramHomeFloorNewElements);

            return;

    }

    protected final void a(MallFloorCommonUtil._F paramf, RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2) {
        MallFloorCommonUtil._G localg = paramf.a(paramInt2);
        TextView textView = (TextView) paramRelativeLayout.findViewWithTag(Integer.valueOf(768));
        if (textView != null)
            textView.setVisibility(INVISIBLE);
        if ((localg == null) || (TextUtils.isEmpty(localg.text)))
            return;
        int pointX = paramf.m.x;
        int pointY = paramf.m.y;
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 9;
        arrayOfInt[1] = 10;
        switch (_R.b[(paramf.l - 1)]) {
            case 1://pswitch_0
                pointY = pointY + paramInt1;
                //goto :goto_2
                break;
            case 2://pswitch_1
                arrayOfInt[0] = 11;
                pointY = pointY;
                //goto :goto_2
                break;
            case 3://pswitch_2
                arrayOfInt[1] = 12;
                pointY = pointY;
                //goto :goto_2
                break;
            case 4://pswitch_3
                arrayOfInt[0] = 11;
                arrayOfInt[1] = 12;
                //goto :goto_1
                //:goto_1
                pointY = pointY;
                break;
        }
        //:goto_2
        if (textView == null) {
            textView = new TextView(getContext());
            textView.setTag(Integer.valueOf(768));
        } else {
            paramRelativeLayout.removeView(textView);
        }
        //:goto_3
        a(textView, localg.text, paramf.textColor, paramf.textSize1, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, localg.backgroundColor, arrayOfInt, new Point(pointX, pointY), -1.0F);
        if (textView.getText().length() != 0) {//if-eqz v1, :cond_5
            int left = paramf.o.x;
            int top = paramf.o.y;
            textView.setPadding(left, top, left, DPIUtil.getWidthByDesignValue720(1) + top);
            if (textView.getParent() == null)
                paramRelativeLayout.addView(textView);
            textView.setVisibility(VISIBLE);
            textView.bringToFront();
        } else
            textView.setVisibility(INVISIBLE);
        return;
    }

    public final void a(final HomeFloorNewModel paramHomeFloorNewModel) {
        int j = R.drawable.mallhome_title_bg3;//2130840161;
        MallFloorPresenter locald = i();
        RelativeLayout localRelativeLayout = (RelativeLayout) findViewById(R.id.mallfloor_floor_title); //2131165401

        if ((localRelativeLayout == null) && (locald.s())) {//if-nez v1, :cond_3  if-eqz v3, :cond_3
            localRelativeLayout = new RelativeLayout(getContext());
            localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, locald.w()));
            localRelativeLayout.setGravity(Gravity.BOTTOM | Gravity.AXIS_SPECIFIED);

            switch (locald.m()) {//:sswitch_data_0
                case 0xFFF44469://-768919:       //-0xbbb97 -> :sswitch_0
                    break;
                case 0xFFFF9845://-26555:        //-0x67bb -> :sswitch_1
                    j = R.drawable.mallhome_title_bg1;//2130840159;
                    break;
                case 0xFF2A2A2A://-14013910:     //-0xd5d5d6 -> :sswitch_2
                    j = R.drawable.mallhome_title_bg2;//2130840160;
                    break;
                case 0xFFF02B2B://-1037525:      //-0xfd4d5 -> :sswitch_3
                    j = R.drawable.mallhome_title_bg4;//2130840162;
                    break;
                case 0xFF874AF8://-7910664:      //-0x78b508 -> :sswitch_4
                    j = R.drawable.mallhome_title_bg5;//2130840163;
                    break;
            }
            localRelativeLayout.setBackgroundResource(j);//v3
            LinearLayout localObject1 = null;
            if ((locald.q()) && (paramHomeFloorNewModel != null)) {  // if-eqz p1, :cond_4
                localObject1 = new LinearLayout(getContext());
                ((LinearLayout) localObject1).setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, locald.v()));
                ((LinearLayout) localObject1).setGravity(Gravity.CENTER_VERTICAL);
                ((LinearLayout) localObject1).setOrientation(LinearLayout.HORIZONTAL);
                localRelativeLayout.addView((View) localObject1);//v3
            } else
                localObject1 = null;
            //:goto_1
            RelativeLayout localObject0 = new RelativeLayout(getContext());
            ((RelativeLayout) localObject0).setGravity(Gravity.BOTTOM | Gravity.AXIS_SPECIFIED);//81
            final TextView titleText = new TextView(getContext());
            titleText.setIncludeFontPadding(false);
            titleText.setGravity(Gravity.CENTER_VERTICAL);//16
            titleText.setText(this.mPresenter.p());
            titleText.setTextColor(this.mPresenter.m());
            titleText.setTextSize(0, this.mPresenter.l());
            Object localObject3 = this.mPresenter.y();
            titleText.setPadding(((Point) localObject3).x, ((Point) localObject3).y, ((Point) localObject3).x, ((Point) localObject3).y);
            ((RelativeLayout) localObject0).addView(titleText);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
            ((SimpleDraweeView) simpleDraweeView).setScaleType(ImageView.ScaleType.FIT_XY);
            Object localObject4 = this.mPresenter.z();
            localObject4 = new RelativeLayout.LayoutParams(((Point) localObject4).x, ((Point) localObject4).y);
            ((RelativeLayout.LayoutParams) localObject4).addRule(RelativeLayout.CENTER_HORIZONTAL);//14
            ((RelativeLayout.LayoutParams) localObject4).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);//12
            ((SimpleDraweeView) simpleDraweeView).setLayoutParams((ViewGroup.LayoutParams) localObject4);
            ((RelativeLayout) localObject0).addView((View) simpleDraweeView);
            //这里的正常逻辑应该是simpleDraweeView正常显示后textView就会GONE
            //但onLoadingComplete没有执行，所以界面上会显示两个Titel(一个是文字，一个是图片)
            FloorImageLoadCtrl.a((ImageView) simpleDraweeView, i().x(), new JDImageLoadingListener(){//o(this, localTextView)
                @Override
                public void onLoadingCancelled(String paramString, View paramView) {
                    paramView.setVisibility(GONE);
                    titleText.setVisibility(VISIBLE);
                }

                @Override
                public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
                    titleText.setVisibility(GONE);
                    paramView.requestLayout();
                }

                @Override
                public void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason) {
                    paramView.setVisibility(GONE);
                    titleText.setVisibility(VISIBLE);
                }

                @Override
                public void onLoadingStarted(String paramString, View paramView) {

                }
            });
            if (localObject1 != null) {//if-eqz v1, :cond_2
                ((LinearLayout) localObject1).addView((View) localObject0);
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.home_new_textarrow, null);//2130903588
                ((TextView) textView).setGravity(Gravity.CENTER_VERTICAL);
                ((TextView) textView).setText(locald.r());
                ((TextView) textView).setTextColor(locald.a(getContext()));
                ((TextView) textView).setTextSize(locald.b(getContext()));
                if (paramHomeFloorNewModel != null)// if-eqz p1, :cond_0
                    ((View) textView).setOnClickListener(new View.OnClickListener(){//p(this, paramHomeFloorNewModel, "Home_TopRight")
                        @Override
                        public void onClick(View v) {
                            if (!CommonUtil.getInstance().isCanClick())
                                return;
                            BaseActivity activity = MallBaseFloor.this.e.thisActivity;
                            String str = paramHomeFloorNewModel.getSourceValue();
                            paramHomeFloorNewModel.getParam();
                            MallFloorClickUtil.b(activity, this, str, "Home_TopRight", paramHomeFloorNewModel.getJump());
                        }
                    });
                ((LinearLayout) localObject1).addView((View) textView);
            } else {
                ((View) localObject0).setLayoutParams(new RelativeLayout.LayoutParams(-2, locald.v()));
                localRelativeLayout.addView((View) localObject0);//v3
            }
            //:goto_2
            localRelativeLayout.setId(R.id.mallfloor_floor_title);//2131165401  //v3
            addView(localRelativeLayout);//v3
        } else {
            if ((localRelativeLayout != null) && (!locald.s()))//if-eqz v1, :cond_1   if-nez v0, :cond_1
                removeView((View) localRelativeLayout);
            //goto :goto_3
        }
        return;
    }

    public void a(boolean paramBoolean)
    {
    }

    public final void b()
    {
        removeAllViews();
    }

    protected final void b(int paramInt)
    {
        e().b(paramInt);
    }

    public void b(int paramInt1, int paramInt2)
    {
    }

    public final void b(boolean paramBoolean)
    {
        i().d(true);
    }

    protected SimpleDraweeView c(int w, int h)
    {
        SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(getContext());
        localSimpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        localSimpleDraweeView.setLayoutParams(new RelativeLayout.LayoutParams(w, h));
        return localSimpleDraweeView;
    }

    public void c()
    {
    }

    public void d()
    {
    }

    protected abstract P h();

    public void hideProgress()
    {
    }

    protected final P i()
    {
        if (this.mPresenter == null)
            this.mPresenter = h();
        if (this.mPresenter == null)
            throw new NullPointerException("presenter is null ! you should create a presenter.");
        return this.mPresenter;
    }

    public boolean isRetain()
    {
        return false;
    }

    public void j() {
        if (this.mPresenter != null)
        {
            this.mPresenter.suspend();
            this.mPresenter.detachUI(this);
        }
        if(mUnbinder != null)
            mUnbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    public void k() {
        a();
    }

    public void l()
    {
    }

    public void m()
    {
    }

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (this.mPresenter == null)
            this.mPresenter = h();
        if (this.mPresenter != null)
            this.mPresenter.attachUI(this);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(BaseEvent paramBaseEvent)
    {
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onWindowVisibilityChanged(int paramInt)
    {
        super.onWindowVisibilityChanged(paramInt);
        if (this.mPresenter != null)
        {
            if (paramInt == VISIBLE)
                this.mPresenter.setIsShow(true);
        }
        else
            return;
        this.mPresenter.setIsShow(false);
    }

    public void showProgress()
    {
    }

    public void showToast(String paramString)
    {
        Toast.makeText(getContext(), paramString, Toast.LENGTH_SHORT).show();
    }

    static class _R{
        static int[] a = new int[5];
        static int[] b = new int[5];

        static {
            b[MallFloorCommonUtil._E.a -1] = 1;
            b[MallFloorCommonUtil._E.c -1] = 2;
            b[MallFloorCommonUtil._E.d -1] = 3;
            b[MallFloorCommonUtil._E.e -1] = 4;

            a[MallFloorCommonUtil._D.LEFT_TOP.ordinal()] = 1;
            a[MallFloorCommonUtil._D.RIGHT_TOP.ordinal()] = 2;
            a[MallFloorCommonUtil._D.LEFT_BOTTOM.ordinal()] = 3;
            a[MallFloorCommonUtil._D.RIGHT_BOTTOM.ordinal()] = 4;
            a[MallFloorCommonUtil._D.CENTER.ordinal()] = 5;
        }
    }
}
