package com.zy.app.mall.utils.ui.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;

import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/6/22.
 */
//u
public class DateDrawable extends Drawable {
    private CharSequence a = "00";
    private CharSequence b = "00";
    private CharSequence c = "00";
    private final String d = ":";
    private TextPaint e = new TextPaint(1);
    private int f = 0xFF000000;
    private int g = 0xFF000000;
    private int h = 0xFFFFFFFF;
    private int i = 0;
    private int j = 0;
    private Typeface k;
    private int l = 2;

    public DateDrawable()
    {
        this.e.setAntiAlias(true);
        this.e.setTextSize(14.0F);
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setStrokeWidth(this.l);
    }

    private float a(Paint paramPaint, CharSequence paramCharSequence)
    {
        if (!TextUtils.isEmpty(paramCharSequence))
        {
            float f1 = paramPaint.measureText(paramCharSequence.toString());
            return (this.i - f1) / 2.0F;
        }
        return 0.0F;
    }

    public final void a(float paramFloat)
    {
        if (this.e != null)
            this.e.setTextSize(paramFloat);
    }

    public final void a(int paramInt)
    {
        this.f = paramInt;
    }

    public final void a(Typeface paramTypeface)
    {
        this.k = paramTypeface;
        if (this.e != null)
            this.e.setTypeface(paramTypeface);
    }

    public final void a(CharSequence paramCharSequence)
    {
        this.a = paramCharSequence;
    }

    public final void b(int paramInt)
    {
        this.g = paramInt;
    }

    public final void b(CharSequence paramCharSequence)
    {
        this.b = paramCharSequence;
    }

    public final void c(int paramInt)
    {
        this.h = paramInt;
    }

    public final void c(CharSequence paramCharSequence)
    {
        this.c = paramCharSequence;
    }

    public final void d(int paramInt)
    {
        this.i = paramInt;
    }

    @Override
    public final void draw(Canvas paramCanvas) {
        try {
            Object localObject = Typeface.DEFAULT;
            if (this.k != null)
                localObject = this.k;

            this.e.setTypeface((Typeface) localObject);
            localObject = getBounds();
            int m = DPIUtil.dip2px(2.0F);
            float f1 = this.i * 3 + m * 9;
            float f4 = (((Rect) localObject).right - f1) / 2.0F;
            Rect localRect = new Rect();
            this.e.getTextBounds("00", 0, 2, localRect);
            float f5 = ((Rect) localObject).height() / 2 + localRect.height() / 2;
            float f6 = this.i;
            float f7 = m * 4;
            float f8 = this.i * 2;
            float f9 = m * 8;
            float f10 = this.i;
            float f11 = this.i * 2;
            float f12 = m * 4;
            float f13 = this.i * 3;
            float f14 = m * 8;
            float f3 = f4 + a(this.e, this.a);
            f1 = this.i;
            float f2 = m * 4;
            f2 = a(this.e, this.b) + (f1 + f4 + f2);
            f1 = this.i * 2 + f4 + m * 8 + a(this.e, this.c);
            if ((DPIUtil.getWidth() <= 240) && (DPIUtil.getHeight() <= 320)) {
                f1 -= 1.0F;
                f2 -= 1.0F;
                f3 -= 1.0F;
            }
            //:goto_1
            float f15 = this.i;
            float f16 = m;
            float f17 = this.i * 2;
            float f18 = m * 5;
            this.e.setColor(this.h);
            this.e.setStyle(Paint.Style.STROKE);
            paramCanvas.drawRect(f4, m, f4 + f10, this.j + m, this.e);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setColor(this.f);
            paramCanvas.drawText(this.a, 0, this.a.length(), f3, f5 + 0.0F, this.e);
            this.e.setColor(this.g);
            paramCanvas.drawText(":", 0, 1, f15 + f4 + f16, f5 + 0.0F, this.e);
            this.e.setColor(this.h);
            this.e.setStyle(Paint.Style.STROKE);
            paramCanvas.drawRect(f6 + f4 + f7, m, f11 + f4 + f12, this.j + m, this.e);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setColor(this.f);
            paramCanvas.drawText(this.b, 0, this.b.length(), f2, f5 + 0.0F, this.e);
            this.e.setColor(this.g);
            paramCanvas.drawText(":", 0, 1, f17 + f4 + f18, f5 + 0.0F, this.e);
            this.e.setColor(this.h);
            this.e.setStyle(Paint.Style.STROKE);
            paramCanvas.drawRect(f8 + f4 + f9, m, f13 + f4 + f14, this.j + m, this.e);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setColor(this.f);
            paramCanvas.drawText(this.c, 0, this.c.length(), f1, f5 + 0.0F, this.e);
        } catch (Exception e) {
            if (Log.D) {
                e.printStackTrace();

            }
        }
        return;
    }

    public final void e(int paramInt)
    {
        this.j = paramInt;
    }

    @Override
    public final int getOpacity()
    {
        return 0;
    }

    @Override
    public final void setAlpha(int paramInt)
    {
    }

    @Override
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
    }
}
