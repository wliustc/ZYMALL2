package com.jingdong.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.jingdong.common.BaseApplication;
import com.zy.app.mall.R;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.app.util.image.assist.FailReason;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.app.util.image.display.JDBitmapDisplayer;
import com.zy.app.util.image.display.JDFadeInBitmapDisplayer;
import com.zy.app.util.image.display.JDRoundedBitmapDisplayer;
import com.zy.app.util.image.listener.JDImageLoadingListener;
import com.zy.common.res.StringUtil;
import com.zy.common.ui.ExceptionDrawable;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.Log;

import java.io.File;
import java.util.List;

/**
 * Created by Robin on 2016/6/5.
 */
//cb
public class JDFrescoUtils {
    private static String a = JDFrescoUtils.class.getSimpleName();
    private static Context mContext;
    private static boolean isLog;

    public static void initialize(Context paramContext, ImagePipelineConfig paramImagePipelineConfig, boolean paramBoolean) {
        mContext = paramContext;
        isLog = paramBoolean;
        Fresco.initialize(paramContext.getApplicationContext(), paramImagePipelineConfig);
        paramImagePipelineConfig.getMainDiskCacheConfig().getBaseDirectoryName();
    }

    public static DisplayMetrics getDisplayMetrics()
    {
        return mContext.getResources().getDisplayMetrics();
    }

    public static String getString(int id){
        return mContext.getResources().getString(id);
    }

    private static Drawable a(Drawable paramDrawable)
    {
        if (paramDrawable != null)
        {//if-eqz p0, :cond_1
            int v0 = paramDrawable.getIntrinsicWidth();
            int v1 = paramDrawable.getIntrinsicHeight();
            ///*mContext.getResources().getDisplayMetrics();
            //if (v0 > Fresco.getDisplayMetrics().widthPixels || v1 > Fresco.getDisplayMetrics().heightPixels)
            if (v0 > JDFrescoUtils.getDisplayMetrics().widthPixels || v1 > JDFrescoUtils.getDisplayMetrics().heightPixels)
            {//if-gt v0, v2, :cond_0  //if-le v1, v2, :cond_1
                //:cond_0
                paramDrawable = null;
                if (Log.D)
                {
                    Log.d(a, "to big drawable：" + v0 + "x" + v1);
                }
            }
        }//:cond_1
        return paramDrawable;
    }

    private static class _Cj{
        public static int[] a = new int[8];
        static {
            a[ImageView.ScaleType.CENTER.ordinal()] = 1;
            a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 5;
            a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            a[ImageView.ScaleType.FIT_START.ordinal()] = 7;

        }
    }

    private static GenericDraweeHierarchy a(SimpleDraweeView paramSimpleDraweeView, JDDisplayImageOptions paramJDDisplayImageOptions, boolean paramBoolean) {
        ///*GenericDraweeHierarchy构造方法中的参数builder
        /*GenericDraweeHierarchyBuilder localGenericDraweeHierarchyBuilder = ((GenericDraweeHierarchy) paramSimpleDraweeView.getHierarchy()).getBuilder();*/
        GenericDraweeHierarchy hierarchy = (GenericDraweeHierarchy) paramSimpleDraweeView.getHierarchy();
        BaseApplication.getInstance().getApplicationContext();
        ExceptionDrawable appNameDrawable = new ExceptionDrawable(getString(R.string.app_name)/*StringUtil.app_name*/, (byte) 0);
        ScalingUtils.ScaleType scaleType;
        if (paramSimpleDraweeView.getScaleType() != null) {//if-eqz v0, :cond_0
            ImageView.ScaleType stype = paramSimpleDraweeView.getScaleType();
            /*switch (_Cj.a[((ImageView.ScaleType) stype).ordinal()]) {*/
            switch (stype) {
                case CENTER://:pswitch_0
                    scaleType = ScalingUtils.ScaleType.CENTER;
                    break;
                case CENTER_CROP://:pswitch_1
                    scaleType = ScalingUtils.ScaleType.CENTER_CROP;
                    break;
                case CENTER_INSIDE://:pswitch_2
                    scaleType = ScalingUtils.ScaleType.CENTER_INSIDE;
                    break;
                case FIT_XY://:pswitch_3
                    scaleType = ScalingUtils.ScaleType.FIT_XY;
                    break;
                case FIT_CENTER://:pswitch_4
                    scaleType = ScalingUtils.ScaleType.FIT_CENTER;
                    break;
                case FIT_END://:pswitch_5
                    scaleType = ScalingUtils.ScaleType.FIT_END;
                    break;
                case FIT_START://:pswitch_6
                    scaleType = ScalingUtils.ScaleType.FIT_START;
                    break;
                default:
                    scaleType = null;
                    break;
            }
        } else
            scaleType = null;
        //:goto_0
        Drawable placeholderlDrawable = paramJDDisplayImageOptions.getImageOnLoading(BaseApplication.getInstance().getApplicationContext().getResources());
        Drawable failureDrawable = paramJDDisplayImageOptions.getImageOnFail(BaseApplication.getInstance().getApplicationContext().getResources());
        placeholderlDrawable = a(placeholderlDrawable);
        failureDrawable = a(failureDrawable);
        if (placeholderlDrawable != null)//if-eqz v1, :cond_5
            hierarchy.setPlaceholderImage(placeholderlDrawable, (ScalingUtils.ScaleType) scaleType);//占位图(Placeholder)
        else if (paramBoolean)  //if-eqz p2, :cond_1
            hierarchy.setPlaceholderImage(appNameDrawable, (ScalingUtils.ScaleType) scaleType);
        //:cond_1
        //:goto_1
        if (failureDrawable != null)//if-eqz v4, :cond_6
            hierarchy.setFailureImage(failureDrawable, (ScalingUtils.ScaleType) scaleType);//设置加载失败占位图
        else if (paramBoolean)  //if-eqz p2, :cond_2
            hierarchy.setFailureImage(appNameDrawable, (ScalingUtils.ScaleType) scaleType);
        // :cond_2
        // :goto_2
        if (NoImageUtils.a()) {//if-eqz v1, :cond_3
            BaseApplication.getInstance().getApplicationContext();
            hierarchy.setFailureImage(new _F(StringUtil.need_long_click, (byte) 0), (ScalingUtils.ScaleType) scaleType);
        }//:cond_3
        if (scaleType != null)
            hierarchy.setActualImageScaleType((ScalingUtils.ScaleType) scaleType);//修改缩放类型:
        //:cond_4
        JDBitmapDisplayer displayer = paramJDDisplayImageOptions.getJdBitmapDisplayer();
        if (displayer != null) {//if-eqz v0, :cond_a
            if (displayer instanceof JDRoundedBitmapDisplayer) {//if-eqz v1, :cond_8
                int i = ((JDRoundedBitmapDisplayer) displayer).cornerRadius;
                if (hierarchy.getRoundingParams() != null)
                    hierarchy.getRoundingParams().setCornersRadius(i);
                else
                    hierarchy.setRoundingParams(RoundingParams.fromCornersRadius(i));
            } else if ((displayer instanceof JDFadeInBitmapDisplayer))
                hierarchy.setFadeDuration(((JDFadeInBitmapDisplayer) displayer).a);
            else
                hierarchy.setFadeDuration(0);

        } else
            hierarchy.setFadeDuration(0);

        //:goto_3
        /*GenericDraweeHierarchy genericDraweeHierarchy = localGenericDraweeHierarchyBuilder.build();
        genericDraweeHierarchy.setChangeImageListener(paramSimpleDraweeView.getChangeImageListener());
        return genericDraweeHierarchy;*/
        return hierarchy;
    }

//    public static File a()
//    {
//        ///*Fresco.getImagePipelineFactory().getMainDiskStorageCache().getRootDir();
//        ///*=>DefaultDiskStorage.mRootDirectory
//        return Fresco.getDiskCacheDir();
//    }

    public static File a(String paramString)
    {
        FileBinaryResource r = (FileBinaryResource) ImagePipelineFactory.getInstance().getMainDiskStorageCache().getResource(new SimpleCacheKey(paramString));
        if (r != null)
            return r.getFile();
        return null;
    }

    public static void a(ImageView paramImageView)
    {
        if ((paramImageView != null) && ((paramImageView instanceof SimpleDraweeView)))
            ((SimpleDraweeView)paramImageView).setController(null);
    }

    public static void a(String paramString, ImageView paramImageView, JDDisplayImageOptions paramJDDisplayImageOptions, JDImageLoadingListener paramJDImageLoadingListener)
    {
        if (Log.D)
            Log.d(a, "loadImage:" + paramString);
        ImageRequest imageRequest = b(paramString, paramJDDisplayImageOptions, ImageRequest.RequestLevel.FULL_FETCH, null);
        Fresco.getImagePipeline()
                .fetchDecodedImage(imageRequest, BaseApplication.getInstance().getApplicationContext())
                .subscribe(new _CG(paramJDImageLoadingListener, paramString, paramImageView), UiThreadImmediateExecutorService.getInstance());
    }

    /**
     * displayImageOnlyCache
     * @param paramString
     * @param paramSimpleDraweeView
     * @param paramJDDisplayImageOptions
     * @param paramJDImageLoadingListener
     */
    public static void a(final String paramString, final SimpleDraweeView paramSimpleDraweeView, JDDisplayImageOptions paramJDDisplayImageOptions, final JDImageLoadingListener paramJDImageLoadingListener)
    {
        //paramJDImageLoadingListener = new cf(paramJDImageLoadingListener, paramString, paramSimpleDraweeView);
        ImageRequest imageRequest = b(paramString, paramJDDisplayImageOptions, ImageRequest.RequestLevel.DISK_CACHE, paramSimpleDraweeView);
        DraweeController controller = b(imageRequest, paramSimpleDraweeView, new BaseControllerListener<ImageInfo>(){//new cf(paramJDImageLoadingListener, paramString, paramSimpleDraweeView);
            public final void onCancelled()
            {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingCancelled(paramString, paramSimpleDraweeView);
            }

            public final void onFailure(String paramString, Throwable paramThrowable)
            {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingFailed(paramString, paramSimpleDraweeView, new JDFailReason(FailReason.e.getIndex(), paramThrowable));
            }

            public final void onStart()
            {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingStarted(paramString, paramSimpleDraweeView);
            }
        });
        paramSimpleDraweeView.setHierarchy(a(paramSimpleDraweeView, paramJDDisplayImageOptions, true));
        paramSimpleDraweeView.setController(controller);
    }

    public static void a(final String paramString, final SimpleDraweeView paramSimpleDraweeView, final JDDisplayImageOptions displayImageOptions, boolean paramBoolean, final JDImageLoadingListener paramJDImageLoadingListener)
    {
        //cc localcc = new cc(paramString, paramJDImageLoadingListener, paramSimpleDraweeView);
        final BaseControllerListener<ImageInfo> controllerListener = new BaseControllerListener<ImageInfo>(){//new cc(paramString, paramJDImageLoadingListener, paramSimpleDraweeView);
            public final void onCancelled()
            {
                if (Log.D)
                    Log.d(JDFrescoUtils.a, "load cancelled:" + paramString);
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingCancelled(paramString, paramSimpleDraweeView);
            }

            public final void onFailure(String id, Throwable throwable)
            {
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingFailed(paramString, paramSimpleDraweeView, new JDFailReason(FailReason.e.getIndex(), throwable));
                if (Log.D)
                {
                    Log.d(JDFrescoUtils.a, "load failure:" + paramString);
                    throwable.printStackTrace();
                }
            }

            public final void onStart()
            {
                if (Log.D)
                    Log.d(JDFrescoUtils.a, "load start:" + paramString);
                if (paramJDImageLoadingListener != null)
                    paramJDImageLoadingListener.onLoadingStarted(paramString, paramSimpleDraweeView);
            }
        };

        //NoImageUtils.a()返回值不正确
        if (NoImageUtils.a())
        {
            a(paramString, paramSimpleDraweeView, displayImageOptions, new JDImageLoadingListener(){//cd(paramJDImageLoadingListener, paramSimpleDraweeView, paramString, paramJDDisplayImageOptions, localcc)
                @Override
                public void onLoadingCancelled(String paramString, View paramView) {
                    if (paramJDImageLoadingListener != null)
                        paramJDImageLoadingListener.onLoadingCancelled(paramString, paramView);
                }

                @Override
                public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
                    if (paramJDImageLoadingListener != null)
                        paramJDImageLoadingListener.onLoadingComplete(paramString, paramView, paramBitmap);
                    paramSimpleDraweeView.setOnLongClickListener(null);
                    paramSimpleDraweeView.setLongClickable(false);
                }

                @Override
                public void onLoadingFailed(final String s, View paramView, JDFailReason paramJDFailReason) {
                    paramSimpleDraweeView.setOnLongClickListener(new View.OnLongClickListener(){//ce(this)
                        @Override
                        public boolean onLongClick(View v) {
                            //paramView = cb.a(cb.a(this.a.c, this.a.d, ImageRequest.RequestLevel.FULL_FETCH, this.a.b), this.a.b, this.a.e);
                            ImageRequest imageRequest = JDFrescoUtils.b(paramString, displayImageOptions, ImageRequest.RequestLevel.FULL_FETCH, paramSimpleDraweeView);
                            DraweeController c = JDFrescoUtils.b(imageRequest, paramSimpleDraweeView, controllerListener);
                            paramSimpleDraweeView.setController(c);
                            return true;
                        }
                    });
                }

                @Override
                public void onLoadingStarted(String paramString, View paramView) {
                    if (paramJDImageLoadingListener != null)
                        paramJDImageLoadingListener.onLoadingStarted(paramString, paramView);
                }
            });
            return;
        }else {
            ImageRequest imageRequest = b(paramString, displayImageOptions, ImageRequest.RequestLevel.FULL_FETCH, paramSimpleDraweeView);
            DraweeController controller = b(imageRequest, paramSimpleDraweeView, controllerListener);
            paramSimpleDraweeView.setHierarchy(a(paramSimpleDraweeView, displayImageOptions, paramBoolean));
            paramSimpleDraweeView.setController(controller);
        }
    }

    public static void a(List<String> paramList)
    {
        if ((paramList != null) && (paramList.size() > 0))
        {

            for (int i = 0;i < paramList.size();i++)
            {
                Fresco.getImagePipeline().evictFromMemoryCache(Uri.parse((String)paramList.get(i)));
                /*Fresco.removeMemoryCache(Uri.parse((String)paramList.get(i)));*/
            }
        }
    }

    private static DraweeController b(ImageRequest paramImageRequest, SimpleDraweeView paramSimpleDraweeView, ControllerListener paramControllerListener)
    {
        return  Fresco.newDraweeControllerBuilder()
                .setImageRequest(paramImageRequest)
                .setOldController(paramSimpleDraweeView.getController())
                .setControllerListener(paramControllerListener)
                .setAutoPlayAnimations(true)
                .build();
    }

    private static ImageRequest b(String paramString, final JDDisplayImageOptions paramJDDisplayImageOptions, ImageRequest.RequestLevel paramRequestLevel, ImageView paramImageView)
    {
        boolean cacheOnDisk = paramJDDisplayImageOptions.isCacheOnDisk();
        boolean cacheInMemory = paramJDDisplayImageOptions.isCacheInMemory();
        if (Log.D)
            Log.d(a, "cacheOnDisk:" + cacheOnDisk + ",cacheInMemory:" + cacheInMemory + ",uri:" + paramString);
        BasePostprocessor localch = null;
        if (paramJDDisplayImageOptions.getPostProcessor() != null)
            localch = new BasePostprocessor(){//ch(paramJDDisplayImageOptions)
                public final void process(Bitmap paramBitmap)
                {
                    paramJDDisplayImageOptions.getPostProcessor().a(paramBitmap);
                }
            };
        ImageRequestBuilder imageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(paramString))
                .setLowestPermittedRequestLevel(paramRequestLevel)
////                .setCacheOnDisk(cacheOnDisk)
////                .setCacheInMemory(cacheInMemory)
                .setAutoRotateEnabled(paramJDDisplayImageOptions.isConsiderExifParams())
                .setPostprocessor(localch);
////                .setInSampleSize(paramJDDisplayImageOptions.getInSampleSise())
////                .setIsUseThumbnail(paramJDDisplayImageOptions.isUseThumbnail());
////        if (paramJDDisplayImageOptions.isScale())
//        {
//            imageRequestBuilder.setIsScale(paramJDDisplayImageOptions.isScale());
//            if (paramImageView != null)
//                imageRequestBuilder.setTargetImageSize(paramImageView)
//                        .setViewScaleType(ViewScaleType.fromImageView(paramImageView));
////        }
        ImageRequest imageRequest = imageRequestBuilder.build();
////        imageRequest.setImageReportListener(new ImageRequest.ImageReportListener(){//ci(paramJDDisplayImageOptions)
//            public final void report(String imageUri, int size, int width, int height, long startTime, long endTime)
//            {
//                if (Log.D)
//                    Log.d(JDFrescoUtils.a, "imageUri = " + imageUri + ",size = " + size + ",width = " + width + ",height = " + height + ",startTime = " + startTime + ",endTime = " + endTime);
//                if (paramJDDisplayImageOptions.getImageReportListener() != null)
//                    paramJDDisplayImageOptions.getImageReportListener().a(imageUri, size, width, height, startTime, endTime);
//            }
////        });
        return imageRequest;
    }

    public static void b()
    {
        Fresco.getImagePipelineFactory().getMainDiskStorageCache().clearAll();
        /*Fresco.clearDiskCache();*/
    }

    public static void c()
    {
        ///*Fresco.getImagePipeline().clearMemoryCache();
        Fresco.getImagePipeline().clearMemoryCaches();
        /*Fresco.clearMemoryCache();*/
    }

    public static void d()
    {
        ///*Fresco.getImagePipeline().clearMemoryCache();
        Fresco.getImagePipeline().clearMemoryCaches();
        /*Fresco.destory();*/
    }

    private static class _F extends Drawable{
        private static Bitmap c = null;
        private static int d;
        private static int e;
        protected Paint a = new Paint();
        private final String b;

        public _F(String paramString)
        {
            this(paramString, (byte) 0);
        }

        public _F(String paramString, byte paramByte)
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
                    BitmapDrawable drawable = (BitmapDrawable)BaseApplication.getInstance().getDefalutDrawble();
                    if (drawable != null) {
                        c = drawable.getBitmap();
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

        public void draw(Canvas canvas)
        {
            if (Log.D)
                Log.d(_F.class.getName(), "draw() -->> ");
            Rect localRect = getBounds();
            float f1 = localRect.right - localRect.width() / 2;
            float f2 = localRect.bottom - localRect.height() / 2;
            canvas.drawText(this.b, f1, f2, this.a);
            if (c != null)
                canvas.drawBitmap(c, f1 - d / 2, f2 - e / 2 + DPIUtil.dip2px(10.0F), this.a);
        }

        public int getOpacity()
        {
            return 0;
        }

        public void setAlpha(int alpha)
        {
        }

        public void setColorFilter(ColorFilter colorFilter)
        {
        }
    }

    private static class _CG extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        private final JDImageLoadingListener a;
        private final String b;
        private final ImageView c;

        _CG(JDImageLoadingListener paramJDImageLoadingListener, String paramString, ImageView paramImageView)
        {
            this.a = paramJDImageLoadingListener;
            this.b = paramString;
            this.c = paramImageView;
        }

        protected final void onCancelImpl(DataSource<CloseableReference<CloseableImage>> paramDataSource)
        {
            if (this.a != null)
                this.a.onLoadingCancelled(this.b, this.c);
        }

        public final void onFailureImpl(DataSource paramDataSource)
        {
            Throwable throwable = paramDataSource.getFailureCause();
            if (this.a != null)
                this.a.onLoadingFailed(this.b, this.c, new JDFailReason(FailReason.e.getIndex(), throwable));
        }

        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> paramDataSource) {
            paramDataSource.isFinished();
            CloseableReference localCloseableReference = (CloseableReference) paramDataSource.getResult();
            if (localCloseableReference != null) {//if-eqz v0, :cond_1
                try {
                    CloseableImage v1 = (CloseableImage) localCloseableReference.get();
                    Bitmap bitmap = null;
                    if (!(v1 instanceof CloseableAnimatedImage))//if-nez v3, :cond_2
                        bitmap = Bitmap.createBitmap(((CloseableBitmap) v1).getUnderlyingBitmap());
                    else
                        bitmap = null;
                    //:goto_0
                    if (this.a != null)//if-eqz v2, :cond_0
                        this.a.onLoadingComplete(this.b, this.c, bitmap);
                } finally {
                    localCloseableReference.close();
                }
            }
        }
    }
}
