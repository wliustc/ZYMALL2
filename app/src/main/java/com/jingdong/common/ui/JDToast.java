package com.jingdong.common.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zy.app.mall.R;

/**
 * Created by Robin on 2016/5/31.
 */
public class JDToast  extends Toast {
    public static final byte MODE_BOTTOM = 2;
    public static final byte MODE_BOTTOM_Y = 3;
    public static final byte MODE_CENTER = 1;
    public static final byte MODE_IMAGE_EXCLAMATORY = 1;
    public static final byte MODE_IMAGE_TICK = 2;
    private int currentMode;
    public ImageView iv;
    public TextView tv;

    public JDToast(Context paramContext, byte paramByte)
    {
        super(paramContext);
        this.currentMode = paramByte;
        switch (this.currentMode)
        {
            default:
                return;
            case 1:
                initCenterView(paramContext);
                return;
            case 2:
        }
        initBottomView(paramContext);
    }

    public JDToast(Context paramContext, int paramInt)
    {
        super(paramContext);
        initBottomView(paramContext, paramInt);
    }

    private void initBottomView(Context paramContext)
    {
//        View inflate = LayoutInflater.from(paramContext).inflate(R.layout.jd_common_toast_style_bottom, null);
//        setView(inflate);
//        this.tv = ((TextView)inflate.findViewById(R.id.jd_toast_txt));
    }

    private void initBottomView(Context paramContext, int paramInt)
    {
//        View inflate = LayoutInflater.from(paramContext).inflate(R.layout.jd_common_toast_style_bottom, null);
//        setView(inflate);
//        this.tv = ((TextView)inflate.findViewById(R.id.jd_toast_txt));
//        setGravity(80, 0, paramInt);
    }

    private void initCenterView(Context paramContext)
    {
//        View inflate = LayoutInflater.from(paramContext).inflate(R.layout.jd_common_toast_style_center, null);
//        setView(inflate);
//        this.tv = ((TextView)inflate.findViewById(R.id.jd_toast_txt));
//        this.iv = ((ImageView)inflate.findViewById(R.id.jd_toast_image));
//        setGravity(17, 0, 0);
    }

    public void setImage(byte paramByte)
    {
//        if (this.iv == null)
//            return;
//        switch (paramByte)
//        {
//            default:
//                return;
//            case 1:
//                this.iv.setBackgroundResource(R.drawable.jd_toast_exclamation);
//                return;
//            case 2:
//        }
//        this.iv.setBackgroundResource(R.drawable.jd_toast_tick);
    }

    public void setText(CharSequence paramCharSequence)
    {
        if (this.tv == null)
            return;
        this.tv.setText(paramCharSequence);
    }
}
