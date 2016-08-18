package com.zy.app.util.image.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by robin on 16-7-1.
 */
public class JDRoundedBitmapDisplayer implements JDBitmapDisplayer {
    public final int cornerRadius;
    protected final int margin;

    public JDRoundedBitmapDisplayer(int paramInt)
    {
        this(paramInt, 0);
    }

    public JDRoundedBitmapDisplayer(int paramInt1, int paramInt2)
    {
        this.cornerRadius = paramInt1;
        this.margin = paramInt2;
    }

    public void display(final Bitmap paramBitmap, ImageView paramImageView, final int paramInt)
    {
        if ((paramImageView != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
            paramImageView.setImageDrawable(new _B(paramBitmap, this.cornerRadius, this.margin));
    }

    private static class _B extends Drawable{
        protected final float a;
        protected final int b;
        protected final RectF c = new RectF();
        protected final RectF d;
        protected final BitmapShader e;
        protected final Paint f;

        public _B(Bitmap paramBitmap, int paramInt1, int paramInt2){
            this.a = paramInt1;
            this.b = paramInt2;
            this.e = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.d = new RectF(paramInt2, paramInt2, paramBitmap.getWidth() - paramInt2, paramBitmap.getHeight() - paramInt2);
            this.f = new Paint();
            this.f.setAntiAlias(true);
            this.f.setShader(this.e);
        }

        @Override
        public void draw(Canvas canvas) {
            this.f.setAntiAlias(true);
            this.f.setShader(this.e);
            canvas.drawRoundRect(this.c, this.a, this.a, this.f);
        }

        @Override
        public void setAlpha(int alpha) {
            this.f.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {
            this.f.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
            return -3;
        }

        @Override
        protected final void onBoundsChange(Rect paramRect)
        {
            super.onBoundsChange(paramRect);
            this.c.set(this.b, this.b, paramRect.width() - this.b, paramRect.height() - this.b);
            Matrix m = new Matrix();
            m.setRectToRect(this.d, this.c, Matrix.ScaleToFit.FILL);
            this.e.setLocalMatrix(m);
        }
    }
}
