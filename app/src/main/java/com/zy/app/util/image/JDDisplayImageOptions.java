package com.zy.app.util.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;

import com.zy.app.util.image.assist.JDBitmapProcessor;
import com.zy.app.util.image.display.JDBitmapDisplayer;
import com.zy.app.util.image.listener.JDImageReportListener;

/**
 * Created by Robin on 2016/5/22.
 */
public class JDDisplayImageOptions {
    private boolean cacheInMemory = true;
    private boolean cacheOnDisk = true;
    private boolean checkDefault = false;
    private boolean considerExifParams = false;
    private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
    private int delayBeforeLoading = 0;
    private JDBitmapDisplayer displayer = null;
    private Object extraForDownloader = null;
    private Handler handler = null;
    private Drawable imageForEmptyUri = null;
    private Drawable imageOnFail = null;
    private Drawable imageOnLoading = null;
    private int imageResForEmptyUri = 0;
    private int imageResOnFail = 0;
    private int imageResOnLoading = 0;
    private int inSampleSize = 1;
    private boolean isLoadFromNetworkAnyTime = false;
    private boolean isOnlyCache = false;
    private boolean isScale = true;
    private boolean isSyncLoading = false;
    private boolean isUseThumbnail = true;
    private JDImageReportListener mJDImageReportListener;
    private JDBitmapProcessor postProcessor = null;
    private JDBitmapProcessor preProcessor = null;
    private boolean resetViewBeforeLoading = true;

    public JDDisplayImageOptions()
    {
        this.decodingOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public JDDisplayImageOptions(JDDisplayImageOptions paramJDDisplayImageOptions)
    {
        cloneFrom(paramJDDisplayImageOptions);
    }

    public static JDDisplayImageOptions createSimple()
    {
        return new JDDisplayImageOptions();
    }

    public final JDDisplayImageOptions bitmapConfig(Bitmap.Config paramConfig)
    {
        if (paramConfig == null)
            throw new IllegalArgumentException("bitmapConfig can't be null");
        this.decodingOptions.inPreferredConfig = paramConfig;
        return this;
    }

    public final JDDisplayImageOptions cacheInMemory(boolean paramBoolean)
    {
        this.cacheInMemory = paramBoolean;
        return this;
    }

    public final JDDisplayImageOptions cacheOnDisk(boolean paramBoolean)
    {
        this.cacheOnDisk = paramBoolean;
        return this;
    }

    public final JDDisplayImageOptions cloneFrom(JDDisplayImageOptions paramJDDisplayImageOptions)
    {
        JDDisplayImageOptions localJDDisplayImageOptions = paramJDDisplayImageOptions;
        if (paramJDDisplayImageOptions == null)
            localJDDisplayImageOptions = createSimple();
        this.imageResOnLoading = localJDDisplayImageOptions.imageResOnLoading;
        this.imageResForEmptyUri = localJDDisplayImageOptions.imageResForEmptyUri;
        this.imageResOnFail = localJDDisplayImageOptions.imageResOnFail;
        this.imageOnLoading = localJDDisplayImageOptions.imageOnLoading;
        this.imageForEmptyUri = localJDDisplayImageOptions.imageForEmptyUri;
        this.imageOnFail = localJDDisplayImageOptions.imageOnFail;
        this.resetViewBeforeLoading = localJDDisplayImageOptions.resetViewBeforeLoading;
        this.cacheInMemory = localJDDisplayImageOptions.cacheInMemory;
        this.cacheOnDisk = localJDDisplayImageOptions.cacheOnDisk;
        this.decodingOptions = localJDDisplayImageOptions.decodingOptions;
        this.delayBeforeLoading = localJDDisplayImageOptions.delayBeforeLoading;
        this.considerExifParams = localJDDisplayImageOptions.considerExifParams;
        this.extraForDownloader = localJDDisplayImageOptions.extraForDownloader;
        this.preProcessor = localJDDisplayImageOptions.preProcessor;
        this.postProcessor = localJDDisplayImageOptions.postProcessor;
        this.displayer = localJDDisplayImageOptions.displayer;
        this.handler = localJDDisplayImageOptions.handler;
        this.isSyncLoading = localJDDisplayImageOptions.isSyncLoading;
        this.isScale = localJDDisplayImageOptions.isScale;
        this.isUseThumbnail = localJDDisplayImageOptions.isUseThumbnail;
        this.isOnlyCache = localJDDisplayImageOptions.isOnlyCache;
        this.inSampleSize = localJDDisplayImageOptions.inSampleSize;
        this.isLoadFromNetworkAnyTime = localJDDisplayImageOptions.isLoadFromNetworkAnyTime;
        this.mJDImageReportListener = localJDDisplayImageOptions.mJDImageReportListener;
        return this;
    }

    public final JDDisplayImageOptions considerExifParams(boolean paramBoolean)
    {
        this.considerExifParams = paramBoolean;
        return this;
    }

    public final JDDisplayImageOptions decodingOptions(BitmapFactory.Options paramOptions)
    {
        if (paramOptions == null)
            throw new IllegalArgumentException("decodingOptions can't be null");
        this.decodingOptions = paramOptions;
        return this;
    }

    public final JDDisplayImageOptions delayBeforeLoading(int paramInt)
    {
        this.delayBeforeLoading = paramInt;
        return this;
    }

    public final JDDisplayImageOptions displayer(JDBitmapDisplayer paramJDBitmapDisplayer)
    {
        if (paramJDBitmapDisplayer == null)
            throw new IllegalArgumentException("displayer can't be null");
        this.displayer = paramJDBitmapDisplayer;
        return this;
    }

    public final Drawable getImageForEmptyUri(Resources paramResources)
    {
        if (this.imageResForEmptyUri != 0)
            return paramResources.getDrawable(this.imageResForEmptyUri);
        return this.imageForEmptyUri;
    }

    public final Drawable getImageOnFail(Resources paramResources)
    {
        if (this.imageResOnFail != 0)
            return paramResources.getDrawable(this.imageResOnFail);
        return this.imageOnFail;
    }

    public final Drawable getImageOnLoading(Resources paramResources)
    {
        if (this.imageResOnLoading != 0)
            return paramResources.getDrawable(this.imageResOnLoading);
        return this.imageOnLoading;
    }

    public final JDImageReportListener getImageReportListener()
    {
        return this.mJDImageReportListener;
    }

    public final int getInSampleSise()
    {
        return this.inSampleSize;
    }

    public final JDBitmapDisplayer getJdBitmapDisplayer()
    {
        return this.displayer;
    }

    public final JDBitmapProcessor getPostProcessor()
    {
        return this.postProcessor;
    }

    public final JDDisplayImageOptions handler(Handler paramHandler)
    {
        this.handler = paramHandler;
        return this;
    }

    public final JDDisplayImageOptions inSampleSize(int paramInt)
    {
        this.inSampleSize = paramInt;
        return this;
    }

    public final boolean isCacheInMemory()
    {
        return this.cacheInMemory;
    }

    public final boolean isCacheOnDisk()
    {
        return this.cacheOnDisk;
    }

    public final boolean isCheckDefault()
    {
        return this.checkDefault;
    }

    public final boolean isConsiderExifParams()
    {
        return this.considerExifParams;
    }

    public final JDDisplayImageOptions isLoadFromNetworkAnyTime(boolean paramBoolean)
    {
        this.isLoadFromNetworkAnyTime = paramBoolean;
        return this;
    }

    public final boolean isOnlyCache()
    {
        return this.isOnlyCache;
    }

    public final JDDisplayImageOptions isScale(boolean paramBoolean)
    {
        this.isScale = paramBoolean;
        return this;
    }

    public final boolean isScale()
    {
        return this.isScale;
    }

    public final JDDisplayImageOptions isUseThumbnail(boolean paramBoolean)
    {
        this.isUseThumbnail = paramBoolean;
        return this;
    }

    public final boolean isUseThumbnail()
    {
        return this.isUseThumbnail;
    }

    public final JDDisplayImageOptions onlyCache(boolean paramBoolean)
    {
        this.isOnlyCache = paramBoolean;
        return this;
    }

    public final JDDisplayImageOptions postProcessor(JDBitmapProcessor paramc)
    {
        this.postProcessor = paramc;
        return this;
    }

    public final JDDisplayImageOptions preProcessor(JDBitmapProcessor paramc)
    {
        this.preProcessor = paramc;
        return this;
    }

    public final JDDisplayImageOptions resetViewBeforeLoading(boolean paramBoolean)
    {
        this.resetViewBeforeLoading = paramBoolean;
        return this;
    }

    public final void setCheckDefault(boolean paramBoolean)
    {
        this.checkDefault = paramBoolean;
    }

    public final JDDisplayImageOptions setReportListener(JDImageReportListener paramb)
    {
        this.mJDImageReportListener = paramb;
        return this;
    }

    public final JDDisplayImageOptions showImageForEmptyUri(int paramInt)
    {
        this.imageResForEmptyUri = paramInt;
        return this;
    }

    public final JDDisplayImageOptions showImageForEmptyUri(Drawable paramDrawable)
    {
        this.imageForEmptyUri = paramDrawable;
        return this;
    }

    public final JDDisplayImageOptions showImageOnFail(int paramInt)
    {
        this.imageResOnFail = paramInt;
        return this;
    }

    public final JDDisplayImageOptions showImageOnFail(Drawable paramDrawable)
    {
        this.imageOnFail = paramDrawable;
        return this;
    }

    public final JDDisplayImageOptions showImageOnLoading(int paramInt)
    {
        this.imageResOnLoading = paramInt;
        return this;
    }

    public final JDDisplayImageOptions showImageOnLoading(Drawable paramDrawable)
    {
        this.imageOnLoading = paramDrawable;
        return this;
    }

    final JDDisplayImageOptions syncLoading(boolean paramBoolean)
    {
        this.isSyncLoading = paramBoolean;
        return this;
    }
}
