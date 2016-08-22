package com.jingdong.app.mall.category.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jingdong.app.mall.faxian.view.view.AuthorPageView;
import com.zy.app.mall.R;

import java.util.Locale;

/**
 * Created by robin on 16-8-22.
 */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static String b = PagerSlidingTabStrip.class.getSimpleName();
    private static final int[] c = { 16842901, 16842904 };
    private int A = 0xFF666666;//-10066330;
    private int B = 0xFF666666;//-10066330;
    private Typeface C = null;
    private int D = 0;
    private int E = 0;
    private int F = android.R.color.transparent;//17170445;
    private Locale G;
    private ViewGroup H;
    public ViewPager.OnPageChangeListener a;
    private LinearLayout.LayoutParams d;
    private LinearLayout.LayoutParams e;
    private final ViewPager.OnPageChangeListener f = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            PagerSlidingTabStrip.a(this.a, paramInt1);
            PagerSlidingTabStrip.a(this.a, paramFloat);
            if ((paramInt1 >= 0) && (paramInt1 <= PagerSlidingTabStrip.c(this.a) - 1) && (PagerSlidingTabStrip.d(this.a) != null) && (PagerSlidingTabStrip.d(this.a).getChildAt(paramInt1) != null))
                PagerSlidingTabStrip.a(this.a, paramInt1, (int)(PagerSlidingTabStrip.d(this.a).getChildAt(paramInt1).getWidth() * paramFloat));
            this.a.invalidate();
            if (this.a.a != null)
                this.a.a.onPageScrolled(paramInt1, paramFloat, paramInt2);
        }

        @Override
        public void onPageSelected(int position) {
            PagerSlidingTabStrip.b(this.a, paramInt);
            PagerSlidingTabStrip.e(this.a);
            if (this.a.a != null)
                this.a.a.onPageSelected(paramInt);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (paramInt == 0)
                PagerSlidingTabStrip.a(this.a, PagerSlidingTabStrip.a(this.a).getCurrentItem(), 0);
            if (this.a.a != null)
                this.a.a.onPageScrollStateChanged(paramInt);
        }
    };
    private LinearLayout g;
    private ViewPager h;
    private int i;
    private int j = 0;
    private int k = 0;
    private float l = 0.0F;
    private Paint m;
    private Paint n;
    private int o = 0xFF666666;//-10066330;
    private int p = 0x1A000000;//436207616;
    private int q = 0x1A000000;//436207616;
    private boolean r = false;
    private boolean s = false;
    private int t = 52;
    private int u = 8;
    private int v = 2;
    private int w = 12;
    private int x = 24;
    private int y = 1;
    private int z = 12;

    public PagerSlidingTabStrip(Context paramContext)
    {
        this(paramContext, null);
    }

    public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        setFillViewport(true);
        setWillNotDraw(false);
        this.g = new LinearLayout(paramContext);
        this.g.setOrientation(LinearLayout.HORIZONTAL);
        this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.g);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.t = (int) TypedValue.applyDimension(1, this.t, (DisplayMetrics)displayMetrics);
        this.u = (int) TypedValue.applyDimension(1, this.u, (DisplayMetrics)displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, this.v, (DisplayMetrics)displayMetrics);
        this.w = (int) TypedValue.applyDimension(1, this.w, (DisplayMetrics)displayMetrics);
        this.x = (int) TypedValue.applyDimension(1, this.x, (DisplayMetrics)displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, this.y, (DisplayMetrics)displayMetrics);
        this.z = (int) TypedValue.applyDimension(2, this.z, (DisplayMetrics)displayMetrics);
        TypedArray typedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, c);
        this.z = ((TypedArray)typedArray1).getDimensionPixelSize(0, this.z);
        this.A = ((TypedArray)typedArray1).getColor(1, this.A);
        ((TypedArray)typedArray1).recycle();
        TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagerSlidingTabStrip);
        this.o = typedArray.getColor(0, this.o);
        this.B = typedArray.getColor(11, this.o);
        this.p = typedArray.getColor(1, this.p);
        this.q = typedArray.getColor(2, this.q);
        this.u = typedArray.getDimensionPixelSize(3, this.u);
        this.v = typedArray.getDimensionPixelSize(4, this.v);
        this.w = typedArray.getDimensionPixelSize(5, this.w);
        this.x = typedArray.getDimensionPixelSize(6, this.x);
        this.F = typedArray.getResourceId(8, this.F);
        this.r = typedArray.getBoolean(9, this.r);
        this.t = typedArray.getDimensionPixelSize(7, this.t);
        this.s = typedArray.getBoolean(10, this.s);
        typedArray.recycle();
        this.m = new Paint();
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        this.n = new Paint();
        this.n.setAntiAlias(true);
        this.n.setStrokeWidth(this.y);
        this.d = new LinearLayout.LayoutParams(-2, -1);
        this.e = new LinearLayout.LayoutParams(0, -1, 1.0F);
        if (this.G == null)
            this.G = getResources().getConfiguration().locale;
    }

    private void a()
    {
        this.g.removeAllViews();
        this.i = this.h.getAdapter().getCount();

        //:goto_0
        for (int i1 = 0; i1 < this.i; i1++){//if-ge v1, v0, :cond_1
            Object localObject;
            if ((this.h.getAdapter() instanceof PagerSlidingTabStrip._E))
            {//if-eqz v0, :cond_0
                int i2 = ((PagerSlidingTabStrip._E)this.h.getAdapter()).a();
                localObject = new ImageButton(getContext());
                ((ImageButton)localObject).setImageResource(i2);
                a(i1, (View)localObject);
            }else{
                localObject = this.h.getAdapter().getPageTitle(i1).toString();
                TextView localTextView = new TextView(getContext());
                localTextView.setText((CharSequence)localObject);
                localTextView.setGravity(17);
                localTextView.setSingleLine();
                a(i1, localTextView);
            }
            //:goto_1
        }
        b();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){//c(this)
            @Override
            public void onGlobalLayout() {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip.this.j = PagerSlidingTabStrip.this.h.getCurrentItem();
                PagerSlidingTabStrip.this.synthetic_a(PagerSlidingTabStrip.this.j, 0);
            }
        });
    }

     void synthetic_a( int paramInt1, int paramInt2)
    {
        if (this.i != 0){//if-eqz v0, :cond_2
            int i1 = 0;
            if ((paramInt1 >= 0) && (paramInt1 <= this.i - 1) && (this.g != null) && (this.g.getChildAt(paramInt1) != null))
                i1 = this.g.getChildAt(paramInt1).getLeft() + paramInt2;
            if (paramInt1 > 0 || paramInt2 > 0) //if-gtz p1, :cond_0
                i1 = i1 - this.t;
            if (i1 != this.E) {
                this.E = i1;
                this.scrollTo(i1, 0);
            }
        }
        return;
    }

    private void a(final int paramInt, View paramView)
    {
        paramView.setFocusable(true);
        paramView.setOnClickListener(new View.OnClickListener(){//d(this, paramInt)
            @Override
            public void onClick(View view) {
                ParallaxHeaderHelper.a = 3;
                PagerSlidingTabStrip.this.h.setCurrentItem(paramInt);
            }
        });
        paramView.setPadding(this.x, 0, this.x, 0);
        LinearLayout localLinearLayout = this.g;
        LinearLayout.LayoutParams localLayoutParams = this.e;
        if (!this.r)//if-eqz v0, :cond_0
             localLayoutParams = this.d;

        localLinearLayout.addView(paramView, paramInt, localLayoutParams);
        return;

    }

    private void b() {

        //:goto_0
        for (int i1 = 0; i1 < this.i; i1++) {
            Object localObject = this.g.getChildAt(i1);
            ((View) localObject).setBackgroundResource(this.F);
            if ((localObject instanceof TextView)) {//if-eqz v3, :cond_1
                localObject = (TextView) localObject;
                ((TextView) localObject).setTextSize(0, this.z);
                ((TextView) localObject).setTypeface(this.C, this.D);
                ((TextView) localObject).setTextColor(this.A);
                if (this.s) {//if-eqz v3, :cond_0
                    if (Build.VERSION.SDK_INT >= 14)//if-lt v3, v4, :cond_2
                        ((TextView) localObject).setAllCaps(true);
                    else
                        ((TextView) localObject).setText(((TextView) localObject).getText().toString().toUpperCase(this.G));
                }
            }
            //:goto_1
            if (i1 == this.k)
                ((TextView) localObject).setTextColor(this.B);
        }
    }

    public final void a(ViewPager paramViewPager)
    {
        this.h = paramViewPager;
        if (paramViewPager.getAdapter() == null)
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        a();
        paramViewPager.setOnPageChangeListener(this.f);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if ((isInEditMode()) || (this.i == 0))
            return;
        int i2 = getHeight();
        this.m.setColor(this.p);
        paramCanvas.drawRect(0.0F, i2 - this.v, this.g.getWidth(), i2, this.m);
        this.m.setColor(this.o);
        View localView = this.g.getChildAt(this.j);
        float f1 = localView.getLeft();
        float f2 = localView.getRight();    //v1
        if ((this.l > 0.0F) && (this.j < this.i - 1)) {//if-ge v1, v2, :cond_2
            localView = this.g.getChildAt(this.j + 1);
            float f4 = localView.getLeft();
            float f3 = localView.getRight();
            f1 = this.l * f4 + f1 * (1.0F - this.l);
            f2 = this.l * f3 + (1.0F - this.l) * f2;
        }//else move v1, v0
        //:goto_0

        paramCanvas.drawRect(f1, i2 - this.u, f2, i2, this.m);
        this.n.setColor(this.q);

        //:goto_1
        for (int i1 = 0; i1 < this.i - 1; i1++) {
            localView = this.g.getChildAt(i1);
            paramCanvas.drawLine(localView.getRight(), this.w, localView.getRight(), i2 - this.w, this.n);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
        switch (paramMotionEvent.getAction())
        {//pswitch_data_0
            default:
                if ((this.H != null) && (this.H instanceof AuthorPageView))
                    this.H.requestDisallowInterceptTouchEvent(true);
                break;
            case 0: //pswitch_0
                if ((this.H != null) && (this.H instanceof AuthorPageView))
                    this.H.requestDisallowInterceptTouchEvent(true);
                break;

            case 2: //pswitch_1
                if ((this.H != null) && (this.H instanceof AuthorPageView) && (AuthorPageView.isShow))
                    this.H.requestDisallowInterceptTouchEvent(false);
                break;
            case 1: //pswitch_2
            case 3: //pswitch_2
                if ((this.H != null) && (this.H instanceof AuthorPageView))
                    this.H.requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.onInterceptTouchEvent(paramMotionEvent);
    }

    public void onRestoreInstanceState(Parcelable paramParcelable)
    {
        PagerSlidingTabStrip.SavedState savedState = (PagerSlidingTabStrip.SavedState)paramParcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.j = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        PagerSlidingTabStrip.SavedState localSavedState = new PagerSlidingTabStrip.SavedState(super.onSaveInstanceState());
        localSavedState.a = this.j;
        return localSavedState;
    }

    static class SavedState extends View.BaseSavedState
    {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {//g()
            @Override
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;

        private SavedState(Parcel paramParcel)
        {
            super(paramParcel);
            this.a = paramParcel.readInt();
        }

        public SavedState(Parcelable paramParcelable)
        {
            super(paramParcelable);
        }

        public void writeToParcel(Parcel paramParcel, int paramInt)
        {
            super.writeToParcel(paramParcel, paramInt);
            paramParcel.writeInt(this.a);
        }
    }

    public interface _E
    {
        public int a();
    }
}
