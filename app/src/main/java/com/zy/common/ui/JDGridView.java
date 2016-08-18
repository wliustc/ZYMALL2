package com.zy.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by robin on 16-7-5.
 */
public class JDGridView extends GridView {
    private boolean a = false;

    public JDGridView(Context paramContext)
    {
        super(paramContext);
    }

    public JDGridView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public JDGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        this.a = false;
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public void onMeasure(int size, int mode)
    {
        mode = View.MeasureSpec.makeMeasureSpec(0x1FFFFFFF, MeasureSpec.AT_MOST);//536870911    //-2147483648
        this.a = true;
        super.onMeasure(size, mode);
    }
}
