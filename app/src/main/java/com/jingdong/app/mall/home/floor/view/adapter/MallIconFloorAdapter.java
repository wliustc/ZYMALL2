package com.jingdong.app.mall.home.floor.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.d.b.MallIconFloorPresenter;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.app.util.image.listener.JDImageLoadingListener;
import com.zy.common.entity.AppEntry;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDImageUtils;

/**
 * Created by robin on 16-7-5.
 */
//e
public class MallIconFloorAdapter extends BaseAdapter {
    protected boolean a = false;
    protected Context mContext;
    protected MallIconFloorPresenter mMallIconFloorPresenter;
    private final int d = 2131165370;

    public MallIconFloorAdapter(Context paramContext, MallIconFloorPresenter parame, boolean paramBoolean) {
        this.mContext = paramContext;
        this.mMallIconFloorPresenter = parame;
        this.a = paramBoolean;
    }

    @Override
    public final int getCount() {
        return this.mMallIconFloorPresenter.a();
    }

    @Override
    public final Object getItem(int paramInt) {
        return null;
    }

    @Override
    public final long getItemId(int paramInt) {
        return 0L;
    }

    @Override
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {

        if (paramView == null) {//if-nez p2, :cond_5
            try {
                if ((this.mContext != null) && (this.mContext.getResources() != null)) {//if-eqz v0, :cond_0   //if-nez v0, :cond_1
                    //:cond_1
                    paramView = new RelativeLayout(this.mContext);
                    int right = this.mMallIconFloorPresenter.b();//v2
                    int left;             //v4
                    if (paramInt % right == 0) {//if-nez v4, :cond_2
                        right = this.mMallIconFloorPresenter.c();
                        left = 0;
                    } else if (paramInt % right == right - 1) {//:cond_2
                        left = this.mMallIconFloorPresenter.d();
                        right = 0;
                    } else {
                        left = this.mMallIconFloorPresenter.d();
                        right = this.mMallIconFloorPresenter.c();
                    }

                    //:goto_2
                    ((RelativeLayout)paramView).setPadding(left, 0, right, 0);
                    ((RelativeLayout)paramView).setGravity(Gravity.CENTER);
                    SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.mContext);

                    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(this.mMallIconFloorPresenter.e(), this.mMallIconFloorPresenter.e());
                    layoutParams1.addRule(RelativeLayout.CENTER_HORIZONTAL, -1);
                    simpleDraweeView.setLayoutParams(layoutParams1);
                    simpleDraweeView.setId(R.id.home_icon_image);//2131165367
                    ((RelativeLayout)paramView).addView(simpleDraweeView);
                    TextView textView = new TextView(this.mContext);

                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams2.addRule(RelativeLayout.CENTER_HORIZONTAL, -1);
                    layoutParams2.topMargin = this.mMallIconFloorPresenter.f();
                    layoutParams2.addRule(RelativeLayout.BELOW, simpleDraweeView.getId());
                    textView.setId(R.id.home_icon_text);//2131165369
                    textView.setIncludeFontPadding(false);
                    textView.setLayoutParams(layoutParams2);
                    textView.setGravity(Gravity.CENTER);
                    textView.setTextColor(0xFF848689);
                    textView.setTextSize(0, this.mMallIconFloorPresenter.g());
                    textView.setSingleLine();
                    ((RelativeLayout)paramView).addView((View) textView);
                    right = DPIUtil.dip2px(6.0F);

                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(right, right);
                    layoutParams3.addRule(1, R.id.home_icon_image);//2131165367
                    ImageView imageView = new ImageView(this.mContext);
                    imageView.setLayoutParams(layoutParams3);
                    imageView.setImageResource(R.drawable.app_faxian_item_red_dot);//2130838112
                    imageView.setVisibility(View.GONE);
                    imageView.setId(R.id.home_icon_reddot);//2131165368
                    ((RelativeLayout)paramView).addView(imageView);
                    //goto/16 :goto_0
                }//:cond_0
                //:goto_0
                /*if (v0 == null)//if-nez v0, :cond_4
                    return null;
                paramView = v0;*/
                //goto :cond_5

            } catch (java.lang.NullPointerException e) {
                return null;
            }
        }//:cond_5
        Tag tag = (Tag)paramView.getTag();
        if (tag == null) {//if-nez v0, :cond_a
            tag = new Tag();
            tag.mIconText = ((TextView) paramView.findViewById(R.id.home_icon_text));//2131165369
            tag.mIconReddot = paramView.findViewById(R.id.home_icon_reddot);//2131165368
            tag.mIconImage = ((SimpleDraweeView) paramView.findViewById(R.id.home_icon_image));//2131165367
            paramView.setTag(tag);
        }

        //:goto_3
        AppEntry appEntry = this.mMallIconFloorPresenter.c(paramInt);
        if (appEntry != null) {//if-eqz v2, :cond_9
            if ((tag.mIconText != null) && (appEntry.getName() != null)) {
                tag.mIconText.setText(appEntry.getName());
                if (this.a)
                    tag.mIconText.setTextColor(this.mMallIconFloorPresenter.h());
            }
            if (tag.mIconReddot != null) {//if-eqz v4, :cond_7
                if ((this.mMallIconFloorPresenter.a(appEntry.getAppCode())) && (this.mMallIconFloorPresenter.i()))
                    tag.mIconReddot.setVisibility(View.VISIBLE);
                else
                    tag.mIconReddot.setVisibility(View.GONE);
            }
            //:cond_7
            //:goto_4
            if ((tag.mIconImage != null)
                    && ((tag.mIconImage.getTag(R.id.image_last_url) == null)
                        || (appEntry.getIcon() == null)
                        || (!appEntry.getIcon().equals(tag.mIconImage.getTag(R.id.image_last_url)))
                        || (tag.mIconImage.getTag(JDImageUtils.STATUS_TAG).equals(Integer.valueOf(JDImageUtils.STATUS_FAILED)))
                        )
                    ) {
                tag.mIconImage.setTag(R.id.image_last_url, appEntry.getIcon());//2131165370
                JDImageUtils.displayImage(appEntry.getIcon(), tag.mIconImage, null, new JDImageLoadingListener(){//f(this)
                    @Override
                    public void onLoadingCancelled(String paramString, View paramView) {

                    }

                    @Override
                    public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {

                    }

                    @Override
                    public void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason) {
                        if ((paramView != null) && ((paramView instanceof ImageView)))
                            ((ImageView)paramView).setImageDrawable(MallIconFloorAdapter.this.mContext.getResources().getDrawable(R.drawable.home_icon_default));//2130839331
                    }

                    @Override
                    public void onLoadingStarted(String paramString, View paramView) {

                    }
                });
            }
        }//:cond_9

        return paramView;

    }
    public static class Tag{
        protected TextView mIconText;
        protected View mIconReddot;
        protected SimpleDraweeView mIconImage;
    }
}