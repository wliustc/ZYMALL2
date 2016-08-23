package com.zy.app.mall.category.view;

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

import com.jingdong.app.mall.category.view.ParallaxHeaderHelper;
import com.jingdong.app.mall.faxian.view.view.AuthorPageView;
import com.zy.app.mall.R;

import java.util.Locale;

/**
 * Created by robin on 16-8-22.
 * https://github.com/astuetz/PagerSlidingTabStrip
 */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static String b = PagerSlidingTabStrip.class.getSimpleName();
    private static final int[] ATTRS = { android.R.attr.textSize, android.R.attr.textColor};
    private int tabTextColor = 0xFF666666;//-10066330;
    private int B = 0xFF666666;//-10066330;
    private Typeface C = null;//C
    private int D = 0;//D
    private int lastScrollX = 0;//E
    private int tabBackgroundResId = R.drawable.background_tab;//android.R.color.transparent;//17170445;
    private Locale locale;
    private ViewGroup H;//H
    public ViewPager.OnPageChangeListener delegatePageListener;//a
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    private LinearLayout.LayoutParams expandedTabLayoutParams;
    private LinearLayout tabsContainer;
    private ViewPager pager;
    private int tabCount;
    private int currentPosition = 0;//j
    private int k = 0;//k
    private float currentPositionOffset = 0.0F;//l
    private Paint rectPaint;
    private Paint dividerPaint;
    private int indicatorColor = 0xFF666666;//-10066330;
    private int underlineColor = 0x1A000000;//436207616;
    private int dividerColor = 0x1A000000;//436207616;
    private boolean shouldExpand = false;
    private boolean textAllCaps = false;
    private int scrollOffset = 52;
    private int indicatorHeight = 8;
    private int underlineHeight = 2;
    private int dividerPadding = 12;
    private int tabPadding = 24;
    private int dividerWidth = 1;
    private int tabTextSize = 12;

    private final PageListener pageListener = new PageListener();


    public PagerSlidingTabStrip(Context paramContext)
    {
        this(paramContext, null);
    }

    public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        setFillViewport(true);
        setWillNotDraw(false);

        this.tabsContainer = new LinearLayout(context);
        this.tabsContainer.setOrientation(LinearLayout.HORIZONTAL);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(this.tabsContainer);

        DisplayMetrics dm  = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.scrollOffset, (DisplayMetrics)dm );
        this.indicatorHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.indicatorHeight, (DisplayMetrics)dm );
        this.underlineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.underlineHeight, (DisplayMetrics)dm );
        this.dividerPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.dividerPadding, (DisplayMetrics)dm );
        this.tabPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.tabPadding, (DisplayMetrics)dm );
        this.dividerWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.dividerWidth, (DisplayMetrics)dm );
        this.tabTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.tabTextSize, (DisplayMetrics)dm );

        // get system attrs (android:textSize and android:textColor)

        TypedArray typedArray1 = context.obtainStyledAttributes(attrs, ATTRS);

        this.tabTextSize = typedArray1.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = typedArray1.getColor(1, this.tabTextColor);

        typedArray1.recycle();

        // get custom attrs

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PagerSlidingTabStrip);
        this.indicatorColor = typedArray.getColor(R.styleable.PagerSlidingTabStrip_pstsIndicatorColor, this.indicatorColor);
        this.B = typedArray.getColor(R.styleable.PagerSlidingTabStrip_b, this.indicatorColor);
        this.underlineColor = typedArray.getColor(R.styleable.PagerSlidingTabStrip_pstsUnderlineColor, this.underlineColor);
        this.dividerColor = typedArray.getColor(R.styleable.PagerSlidingTabStrip_pstsDividerColor, this.dividerColor);
        this.indicatorHeight = typedArray.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsIndicatorHeight, this.indicatorHeight);
        this.underlineHeight = typedArray.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsUnderlineHeight, this.underlineHeight);
        this.dividerPadding = typedArray.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsDividerPadding, this.dividerPadding);
        this.tabPadding = typedArray.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, this.tabPadding);
        this.tabBackgroundResId = typedArray.getResourceId(R.styleable.PagerSlidingTabStrip_pstsTabBackground, this.tabBackgroundResId);
        this.shouldExpand = typedArray.getBoolean(R.styleable.PagerSlidingTabStrip_pstsShouldExpand, this.shouldExpand);
        this.scrollOffset = typedArray.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsScrollOffset, this.scrollOffset);
        this.textAllCaps = typedArray.getBoolean(R.styleable.PagerSlidingTabStrip_pstsTextAllCaps, this.textAllCaps);

        typedArray.recycle();

        this.rectPaint = new Paint();
        this.rectPaint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);

        this.dividerPaint = new Paint();
        this.dividerPaint.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth(this.dividerWidth);
        this.defaultTabLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        this.expandedTabLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1.0F);
        if (this.locale == null)
            this.locale = getResources().getConfiguration().locale;
    }

    //private void a()
    private void notifyDataSetChanged()
    {
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();

        //:goto_0
        for (int i1 = 0; i1 < this.tabCount; i1++){//if-ge v1, v0, :cond_1
            if ((this.pager.getAdapter() instanceof PagerSlidingTabStrip.IconTabProvider))
            {//if-eqz v0, :cond_0
                int resId = ((PagerSlidingTabStrip.IconTabProvider)this.pager.getAdapter()).getPageIconResId(i1);
                ImageButton tab = new ImageButton(getContext());
                ((ImageButton)tab).setImageResource(resId);
                addTab(i1, (View)tab);
            }else{
                String title = this.pager.getAdapter().getPageTitle(i1).toString();
                TextView localTextView = new TextView(getContext());
                localTextView.setText((CharSequence)title);
                localTextView.setGravity(17);
                localTextView.setSingleLine();
                addTab(i1, localTextView);
            }
            //:goto_1
        }
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){//c(this)
            @Override
            public void onGlobalLayout() {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.pager.getCurrentItem();
                PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
            }
        });
    }

    private void scrollToChild( int position, int offset)
    {
        if (this.tabCount != 0){//if-eqz v0, :cond_2
            int newScrollX = 0;
            if ((position >= 0) && (position <= this.tabCount - 1) && (this.tabsContainer != null) && (this.tabsContainer.getChildAt(position) != null))
                newScrollX = this.tabsContainer.getChildAt(position).getLeft() + offset;
            if (position > 0 || offset > 0) //if-gtz p1, :cond_0
                newScrollX = newScrollX - this.scrollOffset;
            if (newScrollX != this.lastScrollX) {
                this.lastScrollX = newScrollX;
                this.scrollTo(newScrollX, 0);
            }
        }
        return;
    }

    //private void a(final int paramInt, View paramView)
    private void addTab(final int paramInt, View paramView)
    {
        paramView.setFocusable(true);
        paramView.setOnClickListener(new View.OnClickListener(){//d(this, paramInt)
            @Override
            public void onClick(View view) {
                ParallaxHeaderHelper.a = 3;
                PagerSlidingTabStrip.this.pager.setCurrentItem(paramInt);
            }
        });
        paramView.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        LinearLayout localLinearLayout = this.tabsContainer;
        LinearLayout.LayoutParams localLayoutParams = this.expandedTabLayoutParams;
        if (!this.shouldExpand)//if-eqz v0, :cond_0
             localLayoutParams = this.defaultTabLayoutParams;

        localLinearLayout.addView(paramView, paramInt, localLayoutParams);
        return;

    }

    //private void b() {
    private void updateTabStyles() {

        for (int i = 0; i < this.tabCount; i++) {
            View v = this.tabsContainer.getChildAt(i);
            ((View) v).setBackgroundResource(this.tabBackgroundResId);
            if ((v instanceof TextView)) {
                TextView tab = (TextView) v;
                tab.setTextSize(0, this.tabTextSize);
                tab.setTypeface(this.C, this.D);
                tab.setTextColor(this.tabTextColor);
                if (this.textAllCaps) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
                        tab.setAllCaps(true);
                    else
                        tab.setText(tab.getText().toString().toUpperCase(this.locale));
                }
            }
            //:goto_1
            if (i == this.k)
                ((TextView) v).setTextColor(this.B);
        }
    }

    //public final void a(ViewPager paramViewPager)
    public final void setViewPager(ViewPager paramViewPager)
    {
        this.pager = paramViewPager;
        if (paramViewPager.getAdapter() == null)
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        notifyDataSetChanged();
        paramViewPager.setOnPageChangeListener(this.pageListener);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((isInEditMode()) || (this.tabCount == 0))
            return;

        int height = getHeight();

        this.rectPaint.setColor(this.indicatorColor);

        // default: line below current tab
        View currentTab = this.tabsContainer.getChildAt(this.currentPosition);
        float lineLeft = currentTab.getLeft();
        float lineRight = currentTab.getRight();

        // if there is an offset, start interpolating left and right coordinates between current and next tab
        if ((this.currentPositionOffset > 0.0F) && (this.currentPosition < this.tabCount - 1)) {//if-ge v1, v2, :cond_2
            View nextTab = this.tabsContainer.getChildAt(this.currentPosition + 1);
            float nextTabLeft = nextTab.getLeft();
            float nextTabRight = nextTab.getRight();
            lineLeft = this.currentPositionOffset * nextTabLeft + (1.0F - this.currentPositionOffset) * lineLeft;
            lineRight = this.currentPositionOffset * nextTabRight + (1.0F - this.currentPositionOffset) * lineRight;
        }

        canvas.drawRect(lineLeft, height - this.indicatorHeight, lineRight, height, this.rectPaint);

        // draw underline
        this.rectPaint.setColor(this.underlineColor);
        canvas.drawRect(0.0F, height - this.underlineHeight, this.tabsContainer.getWidth(), height, this.rectPaint);

        // draw divider

        this.dividerPaint.setColor(this.dividerColor);
        for (int i = 0; i < this.tabCount - 1; i++) {
            View tab = this.tabsContainer.getChildAt(i);
            canvas.drawLine(tab.getRight(), this.dividerPadding, tab.getRight(), height - this.dividerPadding, this.dividerPaint);
        }
    }

    @Override
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

    public void onRestoreInstanceState(Parcelable state)
    {
        PagerSlidingTabStrip.SavedState savedState = (PagerSlidingTabStrip.SavedState)state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        PagerSlidingTabStrip.SavedState savedState = new PagerSlidingTabStrip.SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState
    {
        int currentPosition;
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {//g()
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };

        private SavedState(Parcel in)
        {
            super(in);
            this.currentPosition = in.readInt();
        }

        public SavedState(Parcelable superState)
        {
            super(superState);
        }

        public void writeToParcel(Parcel dest, int flags)
        {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPosition);
        }
    }

    //_E
    public interface IconTabProvider
    {
        //a()
        public int getPageIconResId(int position);
    }

    private class PageListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            PagerSlidingTabStrip.this.currentPosition = position;
            PagerSlidingTabStrip.this.currentPositionOffset = positionOffset;
            if ((position >= 0) && (position <= PagerSlidingTabStrip.this.tabCount - 1) && (PagerSlidingTabStrip.this.tabsContainer != null) && (PagerSlidingTabStrip.this.tabsContainer.getChildAt(position) != null))
                PagerSlidingTabStrip.this.scrollToChild(position, (int)(PagerSlidingTabStrip.this.tabsContainer.getChildAt(position).getWidth() * positionOffset));
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.delegatePageListener != null)
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            PagerSlidingTabStrip.this.k = position;
            PagerSlidingTabStrip.this.updateTabStyles();
            if (PagerSlidingTabStrip.this.delegatePageListener != null)
                PagerSlidingTabStrip.this.delegatePageListener.onPageSelected(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE)
                PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.pager.getCurrentItem(), 0);
            if (PagerSlidingTabStrip.this.delegatePageListener != null)
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrollStateChanged(state);
        }
    };
}
