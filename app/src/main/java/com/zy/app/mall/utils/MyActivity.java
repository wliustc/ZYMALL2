package com.zy.app.mall.utils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.jingdong.common.BaseActivity;
import com.zy.app.mall.R;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/14.
 */
@SuppressLint({"NewApi"})
public class MyActivity extends BaseActivity {
    private static final String TAG = MyActivity.class.getSimpleName();

    public void makeViewToTop(final ListView paramListView)
    {
        if (paramListView == null)
            return;
        final ImageView localImageView = (ImageView)findViewById(R.id.order_commodity_listview_to_top);//2131170435
        localImageView.setVisibility(View.GONE);
        paramListView.setOnScrollListener(new AbsListView.OnScrollListener(){//bd(this, getWindowManager().getDefaultDisplay().getHeight(), localImageView)
            private int a;
            private int[] b;
            private int c;
            private int d = getWindowManager().getDefaultDisplay().getHeight();

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                visibleItemCount = 0;
                if ((this.b == null) || (this.b.length != totalItemCount))
                    this.b = new int[totalItemCount];
                if (firstVisibleItem == this.c) {//if-ne p2, v1, :cond_5
                    if (view.getChildAt(0) != null) {//if-eqz v1, :cond_3
                        if (Log.D)//if-eqz v1, :cond_2
                            Log.d("onScroll", this.a + "|" + -view.getChildAt(0).getTop() + "|" + (this.a - view.getChildAt(0).getTop() - this.d * 2));
                        if (this.a - view.getChildAt(0).getTop() - this.d * 2 > 0)//if-lez v1, :cond_4
                            localImageView.setVisibility(View.VISIBLE);
                        else
                            localImageView.setVisibility(View.GONE);
                    }
                }else{
                    if (Log.D)
                        Log.d("onScroll", firstVisibleItem + "|" + this.c);
                    if (view.getChildAt(0) != null){//if-eqz v1, :cond_3
                        this.c = firstVisibleItem;
                        if (Log.D)
                            Log.d("onScroll", firstVisibleItem + "|" + this.c);
                        this.b[this.c] = view.getChildAt(0).getHeight();
                        this.a = 0;

                        for (int i = visibleItemCount; i < this.c;  i ++)
                        {
                            this.a += this.b[i];
                        }
                    }
                }
                //:cond_3
                //:goto_0
                return;
            }
        });
        localImageView.setOnClickListener(new View.OnClickListener(){//be(this, paramListView, localImageView)
            @Override
            public void onClick(View v) {
                paramListView.setSelection(View.VISIBLE);
                localImageView.setVisibility(View.GONE);
            }
        });
    }

    protected void onCreate(Bundle paramBundle)
    {
        if (Log.D)
        {
            Log.d(TAG, "onCreate() TaskId = " + getTaskId() + " -->> " + getClass().getName());
            Log.d(TAG, "onCreate() -->> getIntent : " + getIntent());
        }
        super.onCreate(paramBundle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onResume()
    {
        super.onResume();
    }
}
