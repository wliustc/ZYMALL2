package com.zy.app.mall.utils.frame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import com.zy.app.mall.R;
import com.zy.app.mall.navigationbar.NavigationOptHelper;
import com.zy.common.utils.DPIUtil;


/**
 * Created by Robin on 2016/4/7.
 */
// a
public class RadioStateDrawable extends Drawable {
    public static int naviButtonWidth;  //b
    public static int bgWidth;          //c
    Context context;
    private Bitmap bitmap;
    private boolean isOn;
    private String label;
    private boolean bigIcon;
    private TabBarButton.StateController stateNum;
    private TabBarButton.RedPoint redPoint;
    private Bitmap redPointBitmap;

    public RadioStateDrawable(Context context, int bitmapId, String label) {
        this.context = context;
        this.label = label;
        this.bitmap = BitmapFactory.decodeStream(context.getResources().openRawResource(bitmapId));
    }

    //RadioStateDrawable radioStateDrawable1 = new RadioStateDrawable(this.context, offPath, naviLabel, false, iconTag);
    //RadioStateDrawable radioStateDrawable2 = new RadioStateDrawable(this.context, onPath, naviLabel, true, iconTag);
    public RadioStateDrawable(Context context, String path, String naviLabel, boolean isOn, boolean bigIcon) {
        this.bigIcon = bigIcon;
        this.isOn = isOn;
        this.label = naviLabel;
        this.context = context;
        this.bitmap = BitmapFactory.decodeFile(path);
        if (this.bitmap == null)
            this.bitmap = BitmapFactory.decodeStream(context.getResources().openRawResource(NavigationOptHelper.a(naviLabel, isOn)));
    }

    public final void a(TabBarButton.StateController paramb) {
        this.stateNum = paramb;
    }

    public final void a(TabBarButton.RedPoint paramc) {
        this.redPoint = paramc;
    }

    public final void draw(Canvas canvas) {
        int m = 0;
        int iconW = this.context.getResources().getDimensionPixelSize(R.dimen.main_navigation_bottom_icon_width);//2131035868
        int iconH;
        if (this.bigIcon)
            iconH = this.context.getResources().getDimensionPixelSize(R.dimen.main_navigation_bottom_big_icon_height);//2131035864
        else
            iconH = this.context.getResources().getDimensionPixelSize(R.dimen.main_navigation_bottom_icon_height);//2131035866
        //:goto_0
        int left = (naviButtonWidth - iconW) / 2;
        canvas.drawColor(Color.TRANSPARENT);
        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setTextSize(DPIUtil.dip2px(10.0F));
        paint1.setTypeface(Typeface.DEFAULT_BOLD);
        paint1.setFakeBoldText(true);
        paint1.setTextAlign(Paint.Align.CENTER);
        paint1.setAntiAlias(true);
        Rect rect = new Rect(left, 0, iconW + left, iconH + 0);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
        paint2.setDither(true);
        canvas.drawBitmap(this.bitmap, null, (Rect) rect, (Paint) paint2);
        //.line 256
        int redPointBottom;
        if ((this.redPoint != null) && (this.redPoint.a() != null) && (this.redPoint.a().booleanValue())) {
            redPointBottom = this.context.getResources().getDimensionPixelSize(R.dimen.main_navigation_bottom_item_red_point);//2131035869
            iconW = (int) (naviButtonWidth * 0.25F);
            int h = DPIUtil.dip2px(7.5F);
            rect = new Rect(naviButtonWidth - iconW - redPointBottom, h, naviButtonWidth - iconW, redPointBottom + h);
            if (this.redPointBitmap == null)
                this.redPointBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.jd_red_point);//2130837659
            canvas.drawBitmap(this.redPointBitmap, null, (Rect) rect, (Paint) paint2);
        }
        if ((this.redPoint != null) && (this.redPoint.b() != null) && (this.redPoint.b().booleanValue())) {
            redPointBottom = this.context.getResources().getDimensionPixelSize(R.dimen.main_navigation_bottom_item_red_point);//2131035869
            iconW = (int) (naviButtonWidth * 0.25F);
            int h = DPIUtil.dip2px(7.5F);
            rect = new Rect(naviButtonWidth - iconW - redPointBottom, h, naviButtonWidth - iconW, redPointBottom + h);
            if (this.redPointBitmap == null)
                this.redPointBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.jd_red_point);//2130837659
            canvas.drawBitmap(this.redPointBitmap, null, (Rect) rect, (Paint) paint2);
        }
        //.line 281
        //:cond_3

        if ((this.stateNum != null) && (this.stateNum.getNum() != null)) {  //if-eqz v0, :cond_6
            String s = this.stateNum.getNum().toString();
            float f2 = naviButtonWidth - DPIUtil.dip2px(20.0F);
            float f3 = DPIUtil.dip2px(16.0F) + 0;
            float f1 = 0.0F;
            float[] floats = new float[((String) s).length()];
            paint1.getTextWidths((String) s, floats);

            //:goto_1

            for (int y = m; y < floats.length; y++) {
                f1 += floats[y];
            }
            Paint.FontMetrics fontMetrics = paint1.getFontMetrics();
            float f4 = ((Paint.FontMetrics) fontMetrics).descent - ((Paint.FontMetrics) fontMetrics).top;
            f1 = Math.max(f4, f1 + DPIUtil.dip2px(5.0F));
            Paint paint = new Paint();
            ((Paint) paint).setAntiAlias(true);
            RectF localRectF = new RectF();
            localRectF.left = (f2 - f1 / 2.0F);
            localRectF.top = (f3 - DPIUtil.dip2px(4.0F) - f4 / 2.0F);
            localRectF.right = (f1 + localRectF.left);
            localRectF.bottom = (localRectF.top + f4);
            f1 = f4 / 2.0F;
            ((Paint) paint).setStyle(Paint.Style.FILL);
            ((Paint) paint).setColor(this.context.getResources().getColor(R.color.c_F02B2B));//2131099716
            canvas.drawRoundRect(localRectF, f1, f1, (Paint) paint);
            ((Paint) paint).setStyle(Paint.Style.STROKE);
            ((Paint) paint).setColor(this.context.getResources().getColor(R.color.c_F02B2B));//2131099716
            ((Paint) paint).setShader(null);
            ((Paint) paint).setStrokeWidth(DPIUtil.dip2px(1.0F));
            canvas.drawRoundRect(localRectF, f1, f1, (Paint) paint);
            canvas.drawText((String) s, f2, f3, paint1);
        }


    }

    public final int getOpacity() {
        return 0;
    }

    public final void setAlpha(int paramInt) {
    }

    public final void setColorFilter(ColorFilter paramColorFilter) {
    }
}
