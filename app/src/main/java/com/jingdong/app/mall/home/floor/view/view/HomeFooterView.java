package com.jingdong.app.mall.home.floor.view.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zy.app.mall.R;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDImageUtils;

/**
 * Created by Robin on 2016/5/8.
 */
public class HomeFooterView extends LinearLayout {
    public static final int FOOTER_END = 2;
    public static final int FOOTER_ERROR = 1;
    public static final int FOOTER_NODATA = 3;
    public static final int FOOTER_NONE = 4;
    public static final int FOOTER_NORMAL = 0;
    private SimpleDraweeView endView;
    private View errView;
    private int footerState;
    private LinearLayout loadingLayout;
    private LinearLayout noDataLayout;
    private RetryListener retryListener;

    public HomeFooterView(Context paramContext)
    {
        this(paramContext, null);
    }

    public HomeFooterView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        ImageUtil.inflate(R.layout.home_product_footer, this);    //2130903589
        initFooter();
    }

    private void footerStateChange(int state)
    {
        switch (state)
        {
            default:
            case FOOTER_NORMAL://0:
                this.loadingLayout.setVisibility(VISIBLE);
                this.noDataLayout.setVisibility(GONE);
                this.errView.setVisibility(GONE);
                this.endView.setVisibility(GONE);
                break;
            case FOOTER_ERROR://1:
                this.loadingLayout.setVisibility(GONE);
                this.noDataLayout.setVisibility(GONE);
                this.errView.setVisibility(VISIBLE);
                this.endView.setVisibility(GONE);
                break;
            case FOOTER_END://2:
                this.loadingLayout.setVisibility(GONE);
                this.noDataLayout.setVisibility(GONE);
                this.errView.setVisibility(GONE);
                this.endView.setVisibility(VISIBLE);
                break;
            case FOOTER_NODATA://3:
                this.loadingLayout.setVisibility(GONE);
                this.noDataLayout.setVisibility(VISIBLE);
                this.errView.setVisibility(GONE);
                this.endView.setVisibility(GONE);
                break;
            case FOOTER_NONE://4:
                this.loadingLayout.setVisibility(GONE);
                this.noDataLayout.setVisibility(GONE);
                this.errView.setVisibility(GONE);
                this.endView.setVisibility(GONE);
                break;
        }

            this.loadingLayout.postInvalidate();
            return;
    }

    private void initFooter()
    {
        setGravity(Gravity.CENTER_VERTICAL|Gravity.AXIS_SPECIFIED);//17
        this.loadingLayout = ((LinearLayout)findViewById(R.id.home_product_loading_layout));//2131168487
        this.errView = findViewById(R.id.home_product_err);//2131168490
        this.errView.setOnClickListener(new OnClickListener(){//f(this)
            @Override
            public void onClick(View v) {
                if (HomeFooterView.this.retryListener != null)
                    HomeFooterView.this.retryListener.tryShowNextPage();
            }
        });
        this.endView = ((SimpleDraweeView)findViewById(R.id.home_product_end));//2131168491
        JDImageUtils.displayImage("res:///"+R.drawable.home_product_footview, this.endView);//2130839341
        this.noDataLayout = ((LinearLayout)findViewById(R.id.loading_error_tips_layout));//2131165616
        ((ImageView)this.noDataLayout.findViewById(R.id.jd_tip_image)).setBackgroundResource(R.drawable.y_03);//2131165239//2130837707
        ((TextView)this.noDataLayout.findViewById(R.id.jd_tip_tv1)).setText(R.string.cart_error_fail);//2131165240//2131231071
        ((TextView)this.noDataLayout.findViewById(R.id.jd_tip_tv2)).setText(R.string.cart_error_fail_check);//2131165241//2131231073
        Button localButton = (Button)this.noDataLayout.findViewById(R.id.jd_tip_button);//2131165236
        localButton.setText(R.string.loading_error_again);//2131232396
        localButton.setOnClickListener(new OnClickListener(){//g(this)
            @Override
            public void onClick(View v) {
                if (HomeFooterView.this.retryListener != null)
                    HomeFooterView.this.retryListener.refreshing();
            }
        });
    }

    public int getFooterState()
    {
        return this.footerState;
    }

    public void setFooterState(final int state)
    {
        this.footerState = state;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            post(new Runnable(){//h(this, paramInt)
                @Override
                public void run() {
                    footerStateChange(state);
                }
            });
        }else
            footerStateChange(state);
    }

    public void setNoDataLayoutHeight(int paramInt)
    {
        if ((this.noDataLayout != null) && (Looper.myLooper() == Looper.getMainLooper()) && (paramInt > 0) && (this.noDataLayout.getHeight() != paramInt))
        {
            LayoutParams localLayoutParams = new LayoutParams(-1, paramInt);
            this.noDataLayout.setLayoutParams(localLayoutParams);
        }
    }

    public void setRetryListener(RetryListener retryListener)
    {
        this.retryListener = retryListener;
    }

    //i
    public interface RetryListener{
        public void refreshing();

        public void tryShowNextPage();
    }
}
