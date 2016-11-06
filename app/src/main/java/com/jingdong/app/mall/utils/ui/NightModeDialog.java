package com.jingdong.app.mall.utils.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.SeekBar;

import com.jingdong.app.mall.MainFrameActivity;

/**
 * Created by Robin on 2016/11/6.
 */
public class NightModeDialog extends Dialog {
    Context a;
    Button b;
    Button c;
    SeekBar d;
    Float e = Float.valueOf(0.0F);

    public NightModeDialog(Context paramContext, int paramInt)
    {
        super(paramContext, 2131296562);//2131296562
        this.a = paramContext;
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130904003);
        this.b = ((Button)findViewById(2131171360));
        this.c = ((Button)findViewById(2131171359));
        this.b.setOnClickListener(new ag(this));
        this.c.setOnClickListener(new ah(this));
        this.d = ((SeekBar)findViewById(2131171356));
        this.d.setOnSeekBarChangeListener(new ai(this));
        float f = CommonUtil.getJdSharedPreferences().getFloat("nightModeAlpha", -1.0F);
        if (f >= 0.0F)
        {
            int j = (int)((f + 0.005F) * 200.0F);
            paramBundle = this.d;
            int i = j;
            if (j > 100)
                i = 100;
            paramBundle.setProgress(i);
            return;
        }
        this.d.setProgress(21);
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        if (paramInt == 4)
        {
            if (!CommonUtil.getJdSharedPreferences().getBoolean("nightModeSwitch", false))
                break label40;
            el.a((Activity)this.a);
            dismiss();
        }
        while (true)
        {
            return super.onKeyDown(paramInt, paramKeyEvent);
            label40: el.a((Activity)this.a, -1.0F, true);
            dismiss();
        }
    }
}
