package com.zy.app.mall.category.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by Robin on 2016/10/11.
 */
//a
public class BorderDrawable extends Drawable {
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private int e;
    private int f;

    public final void a(int paramInt1, int paramInt2)
    {
        this.e = -1841687;
        this.f = 1;
    }

    public final void a(boolean paramBoolean)
    {
        this.a = true;
    }

    public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
        this.a = false;
        this.c = false;
        this.b = false;
        this.d = false;
    }

    public final void b(boolean paramBoolean)
    {
        this.c = true;
    }

    public final void c(boolean paramBoolean)
    {
        this.b = true;
    }

    public final void d(boolean paramBoolean)
    {
        this.d = true;
    }

    public final void draw(Canvas paramCanvas)
    {
        Paint localPaint = new Paint();
        localPaint.setColor(this.e);
        localPaint.setStrokeWidth(this.f * 2.0F);
        Rect localRect = getBounds();
        if (this.a)
            paramCanvas.drawLine(localRect.left, localRect.top, localRect.left, localRect.bottom, localPaint);
        if (this.b)
            paramCanvas.drawLine(localRect.right, localRect.top, localRect.right, localRect.bottom, localPaint);
        if (this.c)
            paramCanvas.drawLine(localRect.left, localRect.top, localRect.right, localRect.top, localPaint);
        if (this.d)
            paramCanvas.drawLine(localRect.left, localRect.bottom, localRect.right, localRect.bottom, localPaint);
    }

    public final int getOpacity()
    {
        return 0;
    }

    public final void setAlpha(int paramInt)
    {
    }

    public final void setColorFilter(ColorFilter paramColorFilter)
    {
    }
}
