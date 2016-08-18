package com.zy.app.mall.utils.frame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.zy.app.mall.R;

/**
 * Created by Robin on 2016/4/7.
 */
public class TabBarButton extends RadioButton {
    private StateController a = new StateController();
    private RedPoint b = new RedPoint();
    Context context;

    public TabBarButton(Context context)
    {
        super(context);
        this.context = context;
    }

    public TabBarButton(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        this.context = context;
    }

    private void setStateImageDrawables(Drawable onDrawable, Drawable offDrawable)
    {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        Drawable bottomBarHighlightDrawable = getResources().getDrawable(R.drawable.bottom_bar_highlight);    //2130838331
        localStateListDrawable.addState(new int[] { android.R.attr.state_checked, android.R.attr.state_pressed }, onDrawable);  // 16842912, 16842919
        localStateListDrawable.addState(new int[] { -android.R.attr.state_checked, android.R.attr.state_pressed }, onDrawable); // -16842912, 16842919
        localStateListDrawable.addState(new int[] { android.R.attr.state_checked, android.R.attr.state_focused }, onDrawable);  // 16842912, 16842908
        localStateListDrawable.addState(new int[] { -android.R.attr.state_checked, android.R.attr.state_focused }, offDrawable); //-16842912, 16842908
        localStateListDrawable.addState(new int[] { android.R.attr.state_checked }, onDrawable);    //16842912
        localStateListDrawable.addState(new int[] { -android.R.attr.state_checked }, offDrawable);   //-16842912
        localStateListDrawable.addState(new int[0], bottomBarHighlightDrawable);
        setButtonDrawable(localStateListDrawable);
    }

    public final void setState(String paramString, int paramInt1, int paramInt2)
    {
        RadioStateDrawable radioStateDrawable1 = new RadioStateDrawable(this.context, paramInt2, paramString);
        RadioStateDrawable radioStateDrawable2 = new RadioStateDrawable(this.context, paramInt1, paramString);
        radioStateDrawable1.a(this.a);
        radioStateDrawable2.a(this.a);
        radioStateDrawable1.a(this.b);
        radioStateDrawable2.a(this.b);
        setStateImageDrawables(radioStateDrawable2, radioStateDrawable1);
    }

    //naviLabel, offPath, onPath, false, iconTag
    public final void setState(String naviLabel, String offPath, String onPath, boolean paramBoolean1, boolean iconTag)
    {
        RadioStateDrawable radioStateDrawable1 = new RadioStateDrawable(this.context, offPath, naviLabel, false, iconTag);
        RadioStateDrawable radioStateDrawable2 = new RadioStateDrawable(this.context, onPath, naviLabel, true, iconTag);
        radioStateDrawable1.a(this.a);
        radioStateDrawable2.a(this.a);
        radioStateDrawable1.a(this.b);
        radioStateDrawable2.a(this.b);
        setStateImageDrawables(radioStateDrawable2, radioStateDrawable1);
    }

    //public final Number e()
    public final StateController getStateController()
    {
        return this.a;
    }

    public final RedPoint f()
    {
        return this.b;
    }

    //public class _B{
    public class StateController{
        private Integer num;

        public final String getNum()
        {
            if (this.num == null)
                return null;
            if (this.num.intValue() >= 100)
                return "99+";
            return this.num.toString();
        }

        public final void a(Integer paramInteger)
        {
            this.num = paramInteger;
            TabBarButton.this.invalidate();//重绘
        }
    }

    //_C
    public class RedPoint{
        private Boolean a;
        private Boolean b;

        public RedPoint()
        {
        }

        public final Boolean a()
        {
            return this.a;
        }

        public final void a(Boolean paramBoolean)
        {
            this.a = paramBoolean;
            TabBarButton.this.invalidate();//重绘
        }

        public final Boolean b()
        {
            return this.b;
        }

        public final void b(Boolean paramBoolean)
        {
            this.b = paramBoolean;
            TabBarButton.this.invalidate();//重绘
        }
    }

}
