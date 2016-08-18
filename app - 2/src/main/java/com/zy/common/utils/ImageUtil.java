package com.zy.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.common.BaseApplication;
import com.zy.common.frame.IMyActivity;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Robin on 2016/5/9.
 */
public class ImageUtil {
    public static final int DEFAULT_ROUND = 6;
    public static final int IMAGE_MAX_HEIGHT = 666;
    public static final int IMAGE_MAX_WIDTH = 666;

    public static Bitmap createBitmap(ImageUtil.InputWay paramInputWay, int paramInt1, int paramInt2)
    {
        if (Log.D)
            Log.d(ImageUtil.class.getName(), "createBitmap() width=" + paramInt1 + " height=" + paramInt2 + " -->> ");
        int i = paramInt1;
        if (paramInt1 > DPIUtil.dip2px(666.0F))
            i = DPIUtil.dip2px(666.0F);
        if (paramInt2 > DPIUtil.dip2px(666.0F));
        for (paramInt1 = DPIUtil.dip2px(666.0F); ; paramInt1 = paramInt2)
        {
            if ((i == 0) && (paramInt1 == 0))
            {
                paramInt2 = DPIUtil.dip2px(666.0F);
                paramInt1 = DPIUtil.dip2px(666.0F);
            }
            while (true)
            {
                com.c.a.a.a.a locala = new com.c.a.a.a.a();
                i = 0;
                Object localObject2 = null;
                Object localObject3 = localObject2;
                if (i < 2)
                {
                    Object localObject1;
                    if (paramInputWay.getResourceId() != 0)
                        localObject1 = locala.a(BaseApplication.getInstance(), paramInt2, paramInt1, paramInputWay.getResourceId(), false);
                    while (true)
                    {
                        localObject3 = localObject1;
                        if (localObject1 != null)
                            break label275;
                        GlobalImageCache.getLruBitmapCache().a();
                        i += 1;
                        localObject2 = localObject1;
                        break;
                        if (paramInputWay.getFile() != null)
                        {
                            localObject1 = locala.a(paramInputWay.getFile(), paramInt2, paramInt1);
                            if (localObject1 == null)
                            {
                                localObject1 = null;
                                continue;
                            }
                            localObject1 = locala.a((Bitmap)localObject1, paramInt2, paramInt1, false);
                            continue;
                        }
                        localObject1 = localObject2;
                        if (paramInputWay.getInputStream() != null)
                            continue;
                        localObject1 = localObject2;
                        if (paramInputWay.getByteArray() == null)
                            continue;
                        try
                        {
                            localObject1 = BitmapFactory.decodeByteArray(paramInputWay.getByteArray(), 0, paramInputWay.getByteArray().length);
                            if (localObject1 == null)
                                localObject1 = null;
                        }
                        catch (Throwable localBitmap)
                        {
                            while (true)
                                localBitmap = null;
                            Bitmap localBitmap = locala.a(localBitmap, paramInt2, paramInt1, false);
                        }
                    }
                }
                label275: if ((Log.D) && (localObject3 != null))
                    Log.d(ImageUtil.class.getName(), "createBitmap() return width=" + localObject3.getWidth() + " height=" + localObject3.getHeight() + " -->> ");
                return localObject3;
                paramInt2 = i;
            }
        }
    }

    public static Bitmap createBitmap(ImageUtil.InputWay paramInputWay, GlobalImageCache.BitmapDigest paramBitmapDigest)
    {
        if (paramBitmapDigest.isLarge())
        {
            if (Log.D)
                Log.d(ImageUtil.class.getName(), "createBitmap() bitmapDigest isLarge let cleanMost  -->> ");
            GlobalImageCache.getLruBitmapCache().b();
        }
        Bitmap localBitmap = createBitmap(paramInputWay, paramBitmapDigest.getWidth(), paramBitmapDigest.getHeight());
        if (localBitmap == null)
            paramInputWay = null;
        do
        {
            return paramInputWay;
            paramInputWay = localBitmap;
        }
        while (paramBitmapDigest.getRound() == 0);
        return toRoundCorner(localBitmap, paramBitmapDigest.getRound());
    }

    public static Bitmap drawableToBitmap(Drawable paramDrawable)
    {
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        if (paramDrawable.getOpacity() != -1);
        for (Object localObject = Bitmap.Config.ARGB_8888; ; localObject = Bitmap.Config.RGB_565)
        {
            localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
            Canvas localCanvas = new Canvas((Bitmap)localObject);
            paramDrawable.setBounds(0, 0, i, j);
            paramDrawable.draw(localCanvas);
            return localObject;
        }
    }

    public static Drawable drawableToDrawable16(Drawable paramDrawable)
    {
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, i, j);
        paramDrawable.draw(localCanvas);
        return new BitmapDrawable(localBitmap);
    }

    private static LayoutInflater getLayoutInflater()
    {
        IMyActivity localIMyActivity = BaseApplication.getInstance().getCurrentMyActivity();
        c localc = BaseApplication.getInstance().getMainFrameActivity();
        if (localIMyActivity != null)
            return getLayoutInflater(localIMyActivity.getThisActivity());
        if (localc != null)
            return getLayoutInflater(localc.getThisActivity());
        return getLayoutInflater(BaseApplication.getInstance());
    }

    private static LayoutInflater getLayoutInflater(Context paramContext)
    {
        return (LayoutInflater)paramContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, float paramFloat)
    {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        RectF localRectF = new RectF(localRect);
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
        return localBitmap;
    }

    public static Bitmap getRoundedCornerBitmap(Drawable paramDrawable, float paramFloat)
    {
        return getRoundedCornerBitmap(drawableToBitmap(paramDrawable), paramFloat);
    }

    public static Intent getSelectSystemImageIntent()
    {
        if (Build.VERSION.SDK_INT < 19)
        {
            localIntent = new Intent();
            localIntent.setAction("android.intent.action.GET_CONTENT");
            return localIntent;
        }
        Intent localIntent = new Intent("android.intent.action.OPEN_DOCUMENT");
        localIntent.addCategory("android.intent.category.OPENABLE");
        return localIntent;
    }

    public static View inflate(int paramInt, ViewGroup paramViewGroup)
    {
        try
        {
            View localView = getLayoutInflater().inflate(paramInt, paramViewGroup);
            return localView;
        }
        catch (Throwable localThrowable)
        {
            GlobalImageCache.getLruBitmapCache().a();
        }
        return getLayoutInflater().inflate(paramInt, paramViewGroup);
    }

    public static View inflate(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
    {
        try
        {
            View localView = getLayoutInflater().inflate(paramInt, paramViewGroup, paramBoolean);
            return localView;
        }
        catch (Throwable localThrowable)
        {
            GlobalImageCache.getLruBitmapCache().a();
        }
        return getLayoutInflater().inflate(paramInt, paramViewGroup, paramBoolean);
    }

    public static View inflate(Context paramContext, int paramInt, ViewGroup paramViewGroup)
    {
        try
        {
            View localView = getLayoutInflater(paramContext).inflate(paramInt, paramViewGroup);
            return localView;
        }
        catch (Throwable localThrowable)
        {
            GlobalImageCache.getLruBitmapCache().a();
        }
        return getLayoutInflater(paramContext).inflate(paramInt, paramViewGroup);
    }

    public static boolean isBitmapCanUse(Bitmap paramBitmap)
    {
        return (paramBitmap != null) && (!paramBitmap.isRecycled());
    }

    public static Bitmap loadImageWithCache(GlobalImageCache.BitmapDigest paramBitmapDigest)
    {
        paramBitmapDigest = GlobalImageCache.getLruBitmapCache().a(paramBitmapDigest);
        if ((paramBitmapDigest != null) && (!paramBitmapDigest.isRecycled()))
            return paramBitmapDigest;
        return null;
    }

    public static Drawable scaleDrawable(Drawable paramDrawable, float paramFloat1, float paramFloat2)
    {
        try
        {
            Bitmap bitmap = drawableToBitmap(paramDrawable);
            int i = ((Bitmap)bitmap).getWidth();
            int j = ((Bitmap)bitmap).getHeight();
            Matrix localMatrix = new Matrix();
            localMatrix.postScale(DPIUtil.getDefaultDisplay().getWidth() / paramFloat1, DPIUtil.getDefaultDisplay().getHeight() / paramFloat2);
            return new BitmapDrawable(Bitmap.createBitmap((Bitmap)bitmap, 0, 0, i, j, localMatrix, true));
        }
        catch (Exception e)
        {
            if (Log.D)
            e.printStackTrace();
        }
        return (Drawable)paramDrawable;
    }

    public static Bitmap toRoundBitmap(Bitmap paramBitmap)
    {
        try
        {
            int i = paramBitmap.getWidth();
            int j = paramBitmap.getHeight();
            float f7;
            float f1;
            float f3;
            float f6;
            float f4;
            float f2;
            int k;
            float f5;
            if (i <= j)
            {
                f7 = i / 2;
                f1 = i;
                f3 = f1;
                f6 = 0.0F;
                j = i;
                f4 = f1;
                f2 = f1;
                k = j;
                f5 = f1;
                f1 = f2;
                j = i;
            }
            while (true)
            {
                Bitmap localBitmap = Bitmap.createBitmap(k, j, Bitmap.Config.ARGB_8888);
                Canvas localCanvas = new Canvas(localBitmap);
                Paint localPaint = new Paint();
                Rect localRect1 = new Rect((int)f6, 0, (int)f5, (int)f3);
                Rect localRect2 = new Rect(0, 0, (int)f4, (int)f1);
                RectF localRectF = new RectF(localRect2);
                localPaint.setAntiAlias(true);
                localCanvas.drawARGB(0, 0, 0, 0);
                localPaint.setColor(-12434878);
                localCanvas.drawRoundRect(localRectF, f7, f7, localPaint);
                localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
                localPaint.setColor(-1140850689);
                localPaint.setStyle(Paint.Style.STROKE);
                localPaint.setStrokeWidth(DPIUtil.dip2px(4.0F));
                localCanvas.drawCircle((localRectF.right - localRectF.left) / 2.0F, (localRectF.bottom - localRectF.top) / 2.0F, f7, localPaint);
                return localBitmap;
                f2 = j / 2;
                k = (i - j) / 2;
                f6 = k;
                f3 = i;
                f1 = j;
                f7 = f3 - f6;
                i = j;
                f4 = f1;
                f3 = f1;
                f5 = f1;
                f1 = f4;
                f4 = f5;
                f5 = f7;
                f7 = f2;
                k = i;
            }
        }
        catch (Throwable localThrowable)
        {
            if (Log.D)
                localThrowable.printStackTrace();
        }
        return paramBitmap;
    }

    public static Bitmap toRoundBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        paramInt1 = paramBitmap.getWidth();
        paramInt2 = paramBitmap.getHeight();
        int i;
        int j;
        if (paramInt1 > paramInt2)
        {
            i = paramInt2;
            j = paramInt2;
        }
        while (true)
        {
            if (Log.D)
            {
                Log.d("ImageUile", "toRoundBitmap width-->> " + paramInt1);
                Log.d("ImageUile", "toRoundBitmap height-->> " + paramInt2);
                Log.d("ImageUile", "toRoundBitmap dw-->> " + j);
                Log.d("ImageUile", "toRoundBitmap dh-->> " + i);
            }
            Bitmap localBitmap1;
            if (j >= paramInt1)
            {
                localBitmap1 = paramBitmap;
                if (i >= paramInt2)
                    break label147;
            }
            try
            {
                localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, i, i, true);
                label147: if (paramInt1 > j)
                {
                    if (paramInt2 <= i)
                        break label412;
                    if (paramInt1 > paramInt2)
                        break label418;
                    f2 = j / 2;
                    f4 = j;
                    f6 = 0.0F;
                    f5 = j;
                    f3 = j;
                    f1 = j;
                    paramBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
                    Canvas localCanvas = new Canvas(paramBitmap);
                    Paint localPaint = new Paint();
                    Rect localRect1 = new Rect((int)f6, 0, (int)f5, (int)f4);
                    Rect localRect2 = new Rect(0, 0, (int)f3, (int)f1);
                    RectF localRectF = new RectF(localRect2);
                    localPaint.setAntiAlias(true);
                    localCanvas.drawARGB(0, 0, 0, 0);
                    localPaint.setColor(-12434878);
                    localCanvas.drawRoundRect(localRectF, f2, f2, localPaint);
                    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    localCanvas.drawBitmap(localBitmap1, localRect1, localRect2, localPaint);
                    return paramBitmap;
                    i = paramInt1;
                    j = paramInt1;
                }
            }
            catch (Throwable localBitmap2)
            {
                while (true)
                {
                    GlobalImageCache.getLruBitmapCache().a();
                    try
                    {
                        localBitmap2 = Bitmap.createScaledBitmap(paramBitmap, i, i, true);
                    }
                    catch (Throwable localThrowable2)
                    {
                        localBitmap2 = paramBitmap;
                    }
                    if (!Log.D)
                        continue;
                    Log.d("ImageUtil", " -->> " + localThrowable2);
                    Bitmap localBitmap2 = paramBitmap;
                    continue;
                    j = paramInt1;
                    continue;
                    label412: i = paramInt2;
                    continue;
                    label418: float f2 = i / 2;
                    float f6 = (j - i) / 2;
                    float f5 = j - f6;
                    float f4 = i;
                    float f3 = i;
                    float f1 = i;
                }
            }
        }
    }

    public static Bitmap toRoundCorner(Bitmap paramBitmap, int paramInt)
    {
        if (Log.D)
            Log.d(ImageUtil.class.getName(), "toRoundCorner() dp -->> " + paramInt);
        float f = DPIUtil.dip2px(paramInt);
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        RectF localRectF = new RectF(localRect);
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, f, f, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
        paramBitmap.recycle();
        if (Log.D)
            Log.d(ImageUtil.class.getName(), "toRoundCorner() bitmap -->> " + localBitmap);
        return localBitmap;
    }

    public static Drawable zoomDrawable(Drawable paramDrawable)
    {
        Bitmap bitmap = drawableToBitmap(paramDrawable);
        return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), (int)(bitmap.getHeight() * 0.65D)));
    }

    public abstract interface ImageLoadListener
    {
        public abstract void onError(GlobalImageCache.BitmapDigest paramBitmapDigest);

        public abstract void onProgress(GlobalImageCache.BitmapDigest paramBitmapDigest, int paramInt1, int paramInt2);

        public abstract void onStart(GlobalImageCache.BitmapDigest paramBitmapDigest);

        public abstract void onSuccess(GlobalImageCache.BitmapDigest paramBitmapDigest, Bitmap paramBitmap);
    }

    public static class InputWay
    {
        private byte[] byteArray;
        private File file;
        private InputStream inputStream;
        private int resourceId;

        public static InputWay createInputWay(HttpGroup.HttpResponse paramHttpResponse)
        {
            InputWay localInputWay = new InputWay();
            if (paramHttpResponse != null)
            {
                localInputWay.setByteArray(paramHttpResponse.getInputData());
                localInputWay.setFile(paramHttpResponse.getSaveFile());
            }
            return localInputWay;
        }

        public byte[] getByteArray()
        {
            return this.byteArray;
        }

        public File getFile()
        {
            return this.file;
        }

        public InputStream getInputStream()
        {
            return this.inputStream;
        }

        public int getResourceId()
        {
            return this.resourceId;
        }

        public void setByteArray(byte[] paramArrayOfByte)
        {
            this.byteArray = paramArrayOfByte;
        }

        public void setFile(File paramFile)
        {
            this.file = paramFile;
        }

        public void setInputStream(InputStream paramInputStream)
        {
            this.inputStream = paramInputStream;
        }

        public void setResourceId(int paramInt)
        {
            this.resourceId = paramInt;
        }
    }
}
