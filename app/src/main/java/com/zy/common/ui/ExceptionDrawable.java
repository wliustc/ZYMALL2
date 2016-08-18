package com.zy.common.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.jingdong.common.BaseApplication;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/6/5.
 */
//f
public class ExceptionDrawable extends Drawable {
    private static Bitmap c = null;
    private static int d;
    private static int e;
    protected Paint a = new Paint();
    private final String b;

    public ExceptionDrawable(String paramString)
    {
        this.a.setColor(0xFF888888);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setTextSize(DPIUtil.dip2px(12.0F));
        this.a.setTextAlign(Paint.Align.CENTER);
        this.a.setAntiAlias(true);
        this.b = paramString;
        if (c == null)
        try
        {
            c = ((BitmapDrawable)BaseApplication.getInstance().getDefalutDrawble()).getBitmap();
            d = c.getWidth();
            e = c.getHeight();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    public ExceptionDrawable(String paramString, byte paramByte)
    {
        this.a.setColor(0xFF888888);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setTextSize(DPIUtil.dip2px(12.0F));
        this.a.setTextAlign(Paint.Align.CENTER);
        this.a.setAntiAlias(true);
        this.b = paramString;
        if (c == null)
            try
            {
                BitmapDrawable drawble = (BitmapDrawable) BaseApplication.getInstance().getDefalutDrawble();
                if (drawble != null) {
                    Bitmap bitmap = drawble.getBitmap();
                    c = bitmap;
                    if (c != null) {
                        d = c.getWidth();
                        e = c.getHeight();
                    }
                }
            }
            catch (Throwable e)
            {
                e.printStackTrace();
            }
    }

    @Override
    public void draw(Canvas paramCanvas)
    {
        if (Log.D)
            Log.d(ExceptionDrawable.class.getName(), "draw() -->> ");
        Rect localRect = getBounds();
        float f1 = localRect.right - localRect.width() / 2;
        float f2 = localRect.bottom - localRect.height() / 2;
        paramCanvas.drawText(this.b, f1, f2, this.a);
        if (c != null)
            paramCanvas.drawBitmap(c, f1 - d / 2, f2 - e / 2 + DPIUtil.dip2px(10.0F), this.a);
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int paramInt)
    {
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
    }
}
