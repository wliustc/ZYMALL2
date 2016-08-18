package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.zy.app.mall.R;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.common.BaseActivity;
import com.zy.common.config.Configuration;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.*;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/5/8.
 */
public class HomeProductHeadView extends LinearLayout {
    private final int Error_Net = 0;
    private final int Error_Server = 1;
    private BaseActivity activity;
    private String expid;
    private HomeFooterView footerView;
    private JDHomeFragment fragment;
    private TextView mActionText;
    private boolean mHasData = false;
    private boolean mInLoading = false;
    private float mLastY = -1.0F;
    private OnDataGetListener mOnDataGetListener;
    private int maxHeight;
    private int minHeight = DPIUtil.dip2px(120.0F);
    protected HomeFloorNewModel model;
    private ListViewNextPageLoader nextPageLoader;
    private String refreshText;
    private String rid;

    public HomeProductHeadView(Context paramContext)
    {
        this(paramContext, null);
    }

    public HomeProductHeadView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        initView();
    }

    private String getEntranceText(String paramString)
    {
        String str = getResources().getString(R.string.recommend_text_style);  //2131233527
        if (!TextUtils.isEmpty(paramString))
        {
            if (paramString.length() > 20)
                return String.format(str, new Object[] { paramString.substring(0, 19) + "..." });
            else
                return String.format(str, new Object[] { paramString });
        }
        return String.format(str, new Object[] { getResources().getString(R.string.recommend_text_nomal) });//2131233526
    }

    private void initNextPageLoader()
    {
        if (this.nextPageLoader != null)
            this.nextPageLoader.onDestroy();
        this.nextPageLoader = new J(this, this.activity, null, this.model.getFunctionId());
        this.nextPageLoader.b(Configuration.getPortalHost());
        this.nextPageLoader.b(false);
        this.nextPageLoader.c(false);
        this.nextPageLoader.d();
    }

    private void initView()
    {
        ImageUtil.inflate(R.layout.home_product_head, this);    //2130903590
        this.mActionText = ((TextView)findViewById(R.id.pull_note));    //2131165267
    }

    public boolean hasData()
    {
        return this.mHasData;
    }

    public synchronized void  init(JDHomeFragment paramJDHomeFragment, HomeFloorNewModel paramHomeFloorNewModel, HomeFooterView paramHomeFooterView)
    {

            this.fragment = paramJDHomeFragment;
            this.activity = paramJDHomeFragment.thisActivity;
            this.model = paramHomeFloorNewModel;
            this.footerView = paramHomeFooterView;
            if ((!this.mInLoading) && (paramHomeFloorNewModel != null))
                this.mActionText.setText(getEntranceText(paramHomeFloorNewModel.getShowName()));
            return;

    }

    public synchronized void onBottomPullUp()
    {
            if ((!this.mInLoading) && (!this.mHasData))
            {
                this.mInLoading = true;
                initNextPageLoader();
            }
            try
            {
                JDMtaUtils.sendCommonData(this.activity, "Home_ProductList", this.model.getSourceValue(), "", this.fragment, "", this.activity.getClass(), "", Constants.b);
            }
            catch (Exception e)
            {

                    if (Log.D)
                    e.printStackTrace();

            }

    }

    public void reSet()
    {
        if (this.nextPageLoader != null)
        {
            this.nextPageLoader.onDestroy();
            this.nextPageLoader = null;
        }
        if (this.footerView != null)
            this.footerView.setFooterState(0);
        this.mHasData = false;
        this.mInLoading = false;
    }

    public void setOnDataGetListener(OnDataGetListener paraml)
    {
        this.mOnDataGetListener = paraml;
    }

    public void tryShowNextPage()
    {
        if (this.nextPageLoader != null)
            this.nextPageLoader.f();
    }


    //l
    public interface OnDataGetListener{
        public abstract boolean a(ArrayList<?> paramArrayList, int paramInt);
    }

    final class J extends ListViewNextPageLoader
    {
        boolean a = false;
        int b = 0;

        J(HomeProductHeadView paramHomeProductHeadView, IMyActivity paramIMyActivity, ListView paramListView, String paramString)
        {
            super(paramIMyActivity, null, paramString);
        }

        protected final ArrayList<?> toList(HttpGroup.HttpResponse paramHttpResponse)
        {
            paramHttpResponse = paramHttpResponse.getJSONObject();
            try
            {
                HomeProductHeadView.access$002(this.c, paramHttpResponse.optString("floorIntro"));
                HomeProductHeadView.access$102(this.c, paramHttpResponse.optString("expid"));
                HomeProductHeadView.access$202(this.c, paramHttpResponse.optString("p"));
                b(paramHttpResponse.optInt("totalPage"));
                paramHttpResponse = paramHttpResponse.getJSONArrayOrNull("recommendList");
                if ((paramHttpResponse != null) && (paramHttpResponse.length() > 0))
                {
                    this.a = true;
                    return HomeRecommendTwoEntity.toList(paramHttpResponse);
                }
                if (!this.a)
                    this.b = 1;
                label97: if (!this.a)
                    return null;
                return new ArrayList();
            }
            catch (java.lang.Exception paramHttpResponse)
            {
                break label97;
            }
            catch (java.lang.IllegalAccessError paramHttpResponse)
            {
                break label97;
            }
        }

        protected final void a()
        {
            if (HomeProductHeadView.access$300(this.c) != null)
                HomeProductHeadView.access$300(this.c).setFooterState(0);
        }

        protected final void a(boolean paramBoolean)
        {
            if ((paramBoolean) && (HomeProductHeadView.access$300(this.c) != null))
            {
                if (!g())
                    break label89;
                HomeProductHeadView.access$300(this.c).setFooterState(2);
            }
            while (true)
            {
                if ((this.a) && (!HomeProductHeadView.access$400(this.c)))
                {
                    HomeProductHeadView.access$700(this.c).thisActivity.post(new k(this));
                    HomeProductHeadView.access$402(this.c, true);
                }
                HomeProductHeadView.access$802(this.c, false);
                return;
                label89: HomeProductHeadView.access$300(this.c).setFooterState(3);
            }
        }

        protected final boolean a(ArrayList<?> paramArrayList)
        {
            if (HomeProductHeadView.access$900(this.c) != null)
                return HomeProductHeadView.access$900(this.c).a(paramArrayList, h().intValue());
            return false;
        }

        protected final void b()
        {
            if (HomeProductHeadView.access$300(this.c) != null)
                HomeProductHeadView.access$300(this.c).setFooterState(1);
            HomeProductHeadView.access$802(this.c, false);
        }
    }
}
