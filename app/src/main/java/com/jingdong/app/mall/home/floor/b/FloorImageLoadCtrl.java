package com.jingdong.app.mall.home.floor.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.common.BaseApplication;
import com.zy.common.utils.JDImageUtils;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.view.view.DragFloatView;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.app.util.image.listener.JDImageLoadingListener;
import com.zy.app.util.image.listener.JDImageLoadingProgressListener;

/**
 * Created by Robin on 2016/5/22.
 */
//c
public class FloorImageLoadCtrl {
    private static JDDisplayImageOptions a = new JDDisplayImageOptions().resetViewBeforeLoading(true).showImageOnFail(R.drawable.mallhome_default).showImageOnLoading(R.drawable.mallhome_default);//2130840156
    private static JDDisplayImageOptions b = new JDDisplayImageOptions().resetViewBeforeLoading(false).showImageOnFail(null);
    private static JDDisplayImageOptions c = new JDDisplayImageOptions().resetViewBeforeLoading(false).showImageOnFail(R.drawable.mallhome_default).showImageOnLoading(R.drawable.mallhome_default).showImageForEmptyUri(R.drawable.mallhome_default);

    public static JDDisplayImageOptions a() {
        return a;
    }

    public static void a(ImageView paramImageView, String paramString) {
        a(paramImageView, paramString, true, false);
    }

    public static void a(ImageView paramImageView, String paramString, JDImageLoadingListener paramJDImageLoadingListener) {
        a(paramImageView, paramString, paramJDImageLoadingListener, null);
    }

    private static void a(ImageView paramImageView, String paramString, JDImageLoadingListener paramJDImageLoadingListener, JDImageLoadingProgressListener parama) {
        if (paramImageView != null) {
            b.bitmapConfig(Bitmap.Config.RGB_565);
            //R.id.image_last_url   2131165370
            if ((paramImageView.getTag(R.id.image_last_url) == null) || (paramString == null) || (!paramString.equals(paramImageView.getTag(R.id.image_last_url))) || ((paramImageView.getTag(JDImageUtils.STATUS_TAG) != null) && (paramImageView.getTag(JDImageUtils.STATUS_TAG).equals(Integer.valueOf(JDImageUtils.STATUS_FAILED))))) {
                JDImageUtils.displayImage(paramString, paramImageView, b, false, paramJDImageLoadingListener, null);
                paramImageView.setTag(R.id.image_last_url, paramString);
            }
        }
        return;
    }

    public static void a(ImageView paramImageView, String paramString, boolean paramBoolean) {
        a(paramImageView, paramString, paramBoolean, false);
    }

    public static void a(ImageView paramImageView, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        if (paramImageView != null) {
            a.bitmapConfig(Bitmap.Config.RGB_565);
            if ((paramImageView.getTag(R.id.image_last_url) == null) || (paramString == null) || (!paramString.equals(paramImageView.getTag(R.id.image_last_url))) || ((paramImageView.getTag(JDImageUtils.STATUS_TAG) != null) && (paramImageView.getTag(JDImageUtils.STATUS_TAG).equals(Integer.valueOf(3))))) {
                if ((paramImageView.getTag(R.id.image_last_url) != null) || (!paramBoolean1))
                    JDImageUtils.displayImage(paramString, paramImageView, null, false);
                else {
                    if (((paramImageView instanceof SimpleDraweeView)) && (paramImageView.getScaleType() == ImageView.ScaleType.FIT_CENTER)) {
                        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView) paramImageView;
                        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) localSimpleDraweeView.getHierarchy();
                        Drawable localDrawable = BaseApplication.getInstance().getApplicationContext().getResources().getDrawable(R.drawable.mallhome_default);
                        genericDraweeHierarchy.setPlaceholderImage(localDrawable, ScalingUtils.ScaleType.CENTER);
                        genericDraweeHierarchy.setFailureImage(localDrawable, ScalingUtils.ScaleType.CENTER);
                        localSimpleDraweeView.setHierarchy(genericDraweeHierarchy);
                        if (paramBoolean2)
                            paramImageView.setBackgroundColor(0);
                        else
                            paramImageView.setBackgroundColor(0xFFFDFDFD);//-131587
                        JDImageUtils.displayImage(paramString, paramImageView, null, false);
                    }
                    JDImageUtils.displayImage(paramString, paramImageView, a, false);
                }
                paramImageView.setTag(R.id.image_last_url, paramString);
            }
        }
        return;
    }

    public static void b(ImageView paramImageView, String paramString) {
        a(paramImageView, paramString, null, null);
    }

    public static void c(ImageView paramImageView, String paramString) {
        int j = 1;
        int i = 1;
        if (paramImageView != null) {//if-eqz p0, :cond_2

            if (paramImageView.getTag(R.id.image_last_url) != null) {//if-eqz v2, :cond_0
                if (!TextUtils.isEmpty(paramString)) {//if-eqz v2, :cond_3
                    //break label51;
                    if (paramImageView.getTag(R.id.image_last_url) != null && paramString.equals(paramImageView.getTag(R.id.image_last_url)) && paramImageView.getTag(JDImageUtils.STATUS_TAG) != null && !paramImageView.getTag(JDImageUtils.STATUS_TAG).equals(Integer.valueOf(JDImageUtils.STATUS_FAILED)))
                        i = 0;
                }
            }
            //:cond_0

        } else {//:cond_2
            i = 0;
        }
        // //:goto_0

        if (i != 0) {
            JDImageUtils.displayImage(paramString, paramImageView, c);
            paramImageView.setTag(R.id.image_last_url, paramString);
        }
        return;
    }
}
