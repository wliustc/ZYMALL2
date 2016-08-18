package com.zy.common.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.common.BaseApplication;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.JDFrescoUtils;
import com.jingdong.common.utils.NoImageUtils;
import com.jingdong.common.utils.cache.GlobalImageCache;
import com.zy.app.mall.R;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.app.util.image.listener.JDImageLoadingListener;
import com.zy.app.util.image.listener.JDImageLoadingProgressListener;
import com.zy.app.util.image.listener.JDImageReportListener;
import com.zy.common.ui.ExceptionDrawable;
import com.zy.common.utils.Log;

import java.io.File;

/**
 * Created by Robin on 2016/5/22.
 */
public class JDImageUtils {
    public static final int STATUS_FAILED = 3;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_SUCCESS = 2;
    public static int STATUS_TAG = R.id.jdImageLoader_status_tag;
    private static final String TAG = "JDImageUtils";
    private static Handler mHandler;

    public static void cancelDisplayTask(ImageView paramImageView)
    {
        JDFrescoUtils.a(paramImageView);
    }

    public static void displayImage(String paramString, ImageView paramImageView)
    {
        displayImage(paramString, paramImageView, null, null, null);
    }

    public static void displayImage(String paramString, ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions)
    {
        displayImage(paramString, paramImageView, paramJDDisplayImageOptions, null, null);
    }

    public static void displayImage(String paramString, ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener)
    {
        displayImage(paramString, paramImageView, paramJDDisplayImageOptions, paramJDImageLoadingListener, null);
    }

    public static void displayImage(String paramString, ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener, JDImageLoadingProgressListener parama)
    {
        displayImage(paramString, paramImageView, paramJDDisplayImageOptions, true, paramJDImageLoadingListener, null);
    }

    public static void displayImage(String paramString, ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions, boolean paramBoolean)
    {
        displayImage(paramString, paramImageView, paramJDDisplayImageOptions, paramBoolean, null, null);
    }

    public static void displayImage(String paramString, ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions, boolean paramBoolean, final JDImageLoadingListener paramJDImageLoadingListener, JDImageLoadingProgressListener parama)
    {
        if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
            setImageForEmptyUri(paramImageView, paramJDDisplayImageOptions, paramBoolean);
        else{
            paramImageView.setTag(STATUS_TAG, Integer.valueOf(STATUS_LOADING));
            if (Log.D)
                Log.d("JDImageUtils", "is SimpleDraweeView:" + (paramImageView instanceof SimpleDraweeView));
            JDImageLoadingListener imageLoadingListener = new JDImageLoadingListener(){//cl(paramJDImageLoadingListener)
                @Override
                public void onLoadingCancelled(String paramString, View paramView) {
                    if (paramJDImageLoadingListener != null)
                        paramJDImageLoadingListener.onLoadingCancelled(paramString, paramView);
                    if (Log.I)
                        Log.i("JDImageUtils", "onLoadingCancelled = " + paramString);
                }

                @Override
                public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
                    if (paramJDImageLoadingListener != null)
                        paramJDImageLoadingListener.onLoadingComplete(paramString, paramView, paramBitmap);
                    if ((paramView != null) && ((paramView instanceof ImageView)))
                    {
                        ((ImageView)paramView).setTag(JDImageUtils.STATUS_TAG, Integer.valueOf(STATUS_SUCCESS));
                        paramView = (ImageView)paramView;
                        if ((paramView != null) && (NoImageUtils.a()))
                        {
                            paramView.setOnLongClickListener(null);
                            paramView.setLongClickable(false);
                        }
                    }
                    if (Log.I)
                        Log.i("JDImageUtils", "onLoadingComplete = " + paramString);
                }

                @TargetApi(Build.VERSION_CODES.DONUT)
                @Override
                public void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason) {
                    if (paramJDImageLoadingListener != null)
                        paramJDImageLoadingListener.onLoadingFailed(paramString, paramView, paramJDFailReason);
                    if ((paramView != null) && ((paramView instanceof ImageView)))
                        ((ImageView)paramView).setTag(JDImageUtils.STATUS_TAG, Integer.valueOf(STATUS_FAILED));
                    ExceptionReporter.reportBitmapException(paramString, paramJDFailReason);
                    if (Log.E)
                        Log.e("JDImageUtils", "onLoadingFailed = " + paramJDFailReason.getType() + paramJDFailReason.toString());
                }

                @Override
                public void onLoadingStarted(String paramString, View paramView) {
                    if (paramJDImageLoadingListener != null)
                        paramJDImageLoadingListener.onLoadingStarted(paramString, paramView);
                }
            };
            JDDisplayImageOptions displayImageOptions = JDDisplayImageOptions.createSimple().cloneFrom(paramJDDisplayImageOptions);
            JDImageReportListener v0 = null;
            if (paramJDDisplayImageOptions != null)
                v0 = paramJDDisplayImageOptions.getImageReportListener();
            final JDImageReportListener finalV = v0;
            displayImageOptions.setReportListener(new JDImageReportListener(){//cm(v0)
                @Override
                public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
                    ExceptionReporter.reportBigBitmapException(paramString, paramInt2, paramInt3, paramInt1);
                    if (finalV != null)
                        finalV.a(paramString, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
                }
            });
            if (paramImageView instanceof SimpleDraweeView)
                JDFrescoUtils.a(paramString, (SimpleDraweeView)paramImageView, displayImageOptions, paramBoolean, imageLoadingListener);
        }

    }

    public static void displayImage(String paramString, ImageView paramImageView, JDImageLoadingListener paramJDImageLoadingListener)
    {
        displayImage(paramString, paramImageView, null, paramJDImageLoadingListener, null);
    }

    public static void displayImageOnlyCache(String paramString, ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener)
    {
        if (!TextUtils.isEmpty(paramString)){
            if (paramImageView instanceof SimpleDraweeView)
            JDFrescoUtils.a(paramString, (SimpleDraweeView)paramImageView, paramJDDisplayImageOptions, paramJDImageLoadingListener);
        }

    }

    public static Bitmap getBitmap(Context paramContext, int paramInt)
    {
        if ((paramContext == null) || (paramInt <= 0))
            return null;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = false;
        try
        {
            Bitmap localBitmap = BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions);
            return localBitmap;
        }
        catch (Throwable localThrowable)
        {
            if (Log.E)
                localThrowable.printStackTrace();
            GlobalImageCache.getLruBitmapCache().a();
        }
        return BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions);
    }

    public static Bitmap getBitmapWithJpg16(Context paramContext, int paramInt)
    {
        if ((paramContext == null) || (paramInt <= 0))
            return null;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = false;
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions);
    }

    private static Handler getHandler()
    {
        if (mHandler == null)
            mHandler = new Handler(Looper.getMainLooper());
        return mHandler;
    }

    public static File getImageDiskCacheFile(String paramString)
    {
        return JDFrescoUtils.a(paramString);
    }

    public static Bitmap imageCrop(Bitmap paramBitmap)
    {
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
            return null;
        int k = paramBitmap.getWidth();
        int m = paramBitmap.getHeight();
        int i;
        int j;
        if (k > m)
            i = m;
        else
            i = k;
         if (k > m)
             j = (k - m) / 2;
        else
            j = 0;
        if (k > m)
            k = 0;
        else
            k = (m - k) / 2;
        return Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);

    }

    public static void imageToGray(ImageView paramImageView)
    {
        Drawable drawable = paramImageView.getDrawable();
        if (drawable != null)
        {
            drawable.mutate();
            ColorMatrix localColorMatrix = new ColorMatrix();
            localColorMatrix.setSaturation(0.0F);
            drawable.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
            drawable.invalidateSelf();
        }
    }

    @Deprecated
    public static void loadImage(String paramString, int paramInt1, int paramInt2, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener)
    {
        loadImage(paramString, paramInt1, paramInt2, paramJDDisplayImageOptions, paramJDImageLoadingListener, null);
    }

    @Deprecated
    public static void loadImage(String paramString, int paramInt1, int paramInt2, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener, JDImageLoadingProgressListener parama)
    {
        loadImage(paramString, null, paramInt1, paramInt2, paramJDDisplayImageOptions, paramJDImageLoadingListener, parama);
    }

    @Deprecated
    public static void loadImage(String paramString, int paramInt1, int paramInt2, JDImageLoadingListener paramJDImageLoadingListener)
    {
        loadImage(paramString, paramInt1, paramInt2, null, paramJDImageLoadingListener, null);
    }

    @Deprecated
    public static void loadImage(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, JDDisplayImageOptions paramJDDisplayImageOptions, final JDImageLoadingListener paramJDImageLoadingListener, JDImageLoadingProgressListener parama)
    {
        if (TextUtils.isEmpty(paramString))
            return;

        if (paramJDDisplayImageOptions == null)
            paramJDDisplayImageOptions = new JDDisplayImageOptions();
        paramJDDisplayImageOptions.setReportListener(new JDImageReportListener(){//cn()
            @Override
            public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
                ExceptionReporter.reportBigBitmapException(paramString, paramInt2, paramInt3, paramInt1);
            }
        });
        JDFrescoUtils.a(paramString, paramImageView, paramJDDisplayImageOptions, new JDImageLoadingListener(){//co(paramJDImageLoadingListener)
            @Override
            public void onLoadingCancelled(String paramString, View paramView) {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingCancelled(paramString, paramView);
                if (Log.I)
                    Log.i("JDImageUtils", "onLoadingCancelled = " + paramString);
            }

            @Override
            public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingComplete(paramString, paramView, paramBitmap);
                if (Log.I)
                    Log.i("JDImageUtils", "onLoadingComplete = " + paramString);
            }

            @Override
            public void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason) {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingFailed(paramString, paramView, paramJDFailReason);
                ExceptionReporter.reportBitmapException(paramString, paramJDFailReason);
                if (Log.I)
                    Log.i("JDImageUtils", "onLoadingFailed = " + paramJDFailReason.getType() + paramJDFailReason.toString());
            }

            @Override
            public void onLoadingStarted(String paramString, View paramView) {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingStarted(paramString, paramView);
                if (Log.I)
                    Log.i("JDImageUtils", "onLoadingStarted = ");
            }
        });
    }

    @Deprecated
    public static void loadImage(String paramString, ImageView paramImageView, JDImageLoadingListener paramJDImageLoadingListener)
    {
        loadImage(paramString, paramImageView, 0, 0, null, paramJDImageLoadingListener, null);
    }

    @Deprecated
    public static void loadImage(String paramString, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener)
    {
        loadImage(paramString, 0, 0, paramJDDisplayImageOptions, paramJDImageLoadingListener, null);
    }

    @Deprecated
    public static void loadImage(String paramString, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener, JDImageLoadingProgressListener parama)
    {
        loadImage(paramString, 0, 0, paramJDDisplayImageOptions, paramJDImageLoadingListener, null);
    }

    @Deprecated
    public static void loadImage(String paramString, JDImageLoadingListener paramJDImageLoadingListener)
    {
        loadImage(paramString, 0, 0, null, paramJDImageLoadingListener, null);
    }

    private static void setImageForEmptyUri(ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions, boolean paramBoolean)
    {
        if (paramImageView != null)
        {
            Drawable localDrawable = null;
            if (paramJDDisplayImageOptions != null)
                localDrawable = paramJDDisplayImageOptions.getImageForEmptyUri(BaseApplication.getInstance().getApplicationContext().getResources());
            if (localDrawable == null && paramBoolean){
                    BaseApplication.getInstance().getApplicationContext();
                    localDrawable = new ExceptionDrawable(paramImageView.getResources().getString(R.string.app_name), (byte) 0);
            }
            if (localDrawable != null)
                paramImageView.setImageDrawable(localDrawable);
        }
    }
}
