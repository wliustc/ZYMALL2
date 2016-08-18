package com.zy.app.util.image.display;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.zy.app.util.image.display.JDBitmapDisplayer;

/**
 * Created by robin on 16-7-1.
 */
public class JDFadeInBitmapDisplayer implements JDBitmapDisplayer {
    public final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public JDFadeInBitmapDisplayer(int paramInt) {
        this(paramInt, true, true, true);
    }

    private JDFadeInBitmapDisplayer(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        this.a = paramInt;
        this.b = true;
        this.c = true;
        this.d = true;
    }

    public final void display(Bitmap paramBitmap, ImageView paramImageView, int paramInt) {
        if ((paramImageView != null) && (paramBitmap != null)) {
            paramImageView.setImageBitmap(paramBitmap);
            if (((this.b) && (paramInt == 0)) || ((this.c) && (paramInt == 1)) || ((this.d) && (paramInt == 2))) {
                paramInt = this.a;
                if (paramImageView != null) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                    alphaAnimation.setDuration(paramInt);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    paramImageView.startAnimation(alphaAnimation);
                }
            }
        }
    }
}
