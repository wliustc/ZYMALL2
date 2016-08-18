package com.zy.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.zy.app.mall.R;
import com.zy.common.utils.DPIUtil;

/**
 * Created by robin on 16-6-30.
 */
public class JDProgressBar extends ProgressBar {
    public JDProgressBar(Context paramContext)
    {
        super(paramContext);
        init();
    }

    public JDProgressBar(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        init();
    }

    public JDProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init()
    {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DPIUtil.dip2px(34.0F), DPIUtil.dip2px(34.0F));
        localLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        setLayoutParams(localLayoutParams);
        setBackgroundResource(R.drawable.load_logo);
        setIndeterminateDrawable(getResources().getDrawable(R.drawable.progress_small));
        setIndeterminate(true);
    }
}
