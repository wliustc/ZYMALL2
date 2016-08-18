package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

/**
 * Created by robin on 16-7-12.
 */
public class JDViewFlipper extends ViewFlipper {
    public JDViewFlipper(Context paramContext)
    {
        super(paramContext);
    }

    public JDViewFlipper(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    protected void onDetachedFromWindow()
    {
        try
        {
            super.onDetachedFromWindow();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
            stopFlipping();
        }
        catch (Exception localException)
        {
        }
    }
}
