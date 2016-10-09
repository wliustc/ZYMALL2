package com.jingdong.app.mall.category.adapter;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zy.app.mall.R;
import com.zy.app.mall.category.adapter.IRightAdapterListener;
import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.b.RightListColumn;
import com.zy.app.mall.category.b.RightTitleColumn;
import com.zy.app.mall.category.view.CategoryFooter;
import com.zy.common.entity.Catelogy;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDImageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 16-8-25.
 */
//e
public class RightListAdapter extends BaseAdapter {
    private int a;
    private Context b;
    private List<RightColumnBase> c;
    private IRightAdapterListener d;
    private List<CategoryFooter> e = null;

    public RightListAdapter(Context paramContext)
    {
        this.b = paramContext;
    }

    private void a(Catelogy paramCatelogy, LinearLayout paramLinearLayout, boolean paramBoolean)
    {
        if (paramCatelogy != null && paramLinearLayout != null){
            ImageView localObject2;
            TextView localObject1;
            if (paramBoolean)
            {//if-eqz p3, :cond_4
                localObject2 = (ImageView)paramLinearLayout.getChildAt(0);
                localObject1 = (TextView)paramLinearLayout.getChildAt(1);
                if (localObject2 != null)
                    JDImageUtils.displayImage(paramCatelogy.getImgUrl(), (ImageView)localObject2);
                if (localObject1 != null)
                    ((TextView)localObject1).setText(paramCatelogy.getName());
            }else {//:cond_4
                localObject1 = (TextView)paramLinearLayout.getChildAt(0);
                localObject2 = (ImageView)paramLinearLayout.getChildAt(1);
                if (localObject1 != null)
                    ((TextView)localObject1).setText(paramCatelogy.getName());
                if (localObject2 != null){//if-eqz v1, :cond_3
                    if (("chSpreadAllData".equals(paramCatelogy.getAction())) || ("enSpreadAllData".equals(paramCatelogy.getAction())))
                    {
                        ((ImageView)localObject2).setVisibility(View.VISIBLE);
                        ((ImageView)localObject2).setImageResource(R.drawable.icon_down_arrow);//2130839420
                        ((TextView)localObject1).setTextColor(this.b.getResources().getColor(R.color.pdn_gray));//2131100465
                        ((TextView)localObject1).setTextSize(13.0F);
                    }else if (("chPackUpAllData".equals(paramCatelogy.getAction())) || ("enPackUpAllData".equals(paramCatelogy.getAction())))
                    {
                        ((TextView)localObject1).setTextColor(this.b.getResources().getColor(R.color.pdn_gray));//2131100465
                        ((TextView)localObject1).setTextSize(13.0F);
                        ((ImageView)localObject2).setVisibility(View.VISIBLE);
                        ((ImageView)localObject2).setImageResource(R.drawable.icon_up_arrow);//2130839438
                    }else {
                        ((ImageView) localObject2).setVisibility(View.GONE);
                        ((TextView) localObject1).setTextColor(this.b.getResources().getColor(R.color.category_new_level3_font));//2131099876
                        ((TextView) localObject1).setTextSize(12.0F);
                    }
                }
            }
            //:cond_3
            //:goto_1
            this.d.a(paramLinearLayout, paramCatelogy);
        }
        //:cond_0
        //:goto_0
        return;
    }

    public final void a(IRightAdapterListener paramb)
    {
        this.d = paramb;
    }

    public final void a(CategoryFooter parama)
    {
        if (this.e == null)
            this.e = new ArrayList();
        RightColumnBase localb = new RightColumnBase();
        localb.a = -1;
        this.c.add(localb);
        this.e.add(parama);
    }

    public final void a(List<RightColumnBase> paramList)
    {
        this.c = paramList;
        if (this.e != null)
            this.e.clear();
    }

    public final int getCount()
    {
        if (this.c != null)
            return this.c.size();
        return 0;
    }

    public final Object getItem(int paramInt)
    {
        if (this.c != null)
            return (RightColumnBase)this.c.get(paramInt);
        return null;
    }

    public final long getItemId(int paramInt)
    {
        return paramInt;
    }

    public final int getItemViewType(int paramInt)
    {
        if ((this.c != null) && (this.c.get(paramInt) != null))
            return ((RightColumnBase)this.c.get(paramInt)).a;
        return 1;
    }

    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        int j = 0;
        Object localObject1 = (RightColumnBase)this.c.get(paramInt);//v0
        this.a = getItemViewType(paramInt);
        Object localObject2;
        Holder holder = null;

        switch (this.a) {
            case 0://:pswitch_0
                String str1;
                if (paramView == null) {//if-nez p2, :cond_1
                    paramView = LayoutInflater.from(this.b).inflate(2130903259, null);
                    holder = new Holder();//v2
                    holder.a = ((TextView) paramView.findViewById(2131166252));
                    holder.e = ((LinearLayout) paramView.findViewById(2131166253));
                    holder.f = ((LinearLayout) paramView.findViewById(2131166254));
                    paramView.setTag(holder);
                } else {
                    holder = (Holder) paramView.getTag();
                }
                //:goto_1
                localObject2 = ((RightTitleColumn) localObject1).b();
                str1 = ((RightTitleColumn) localObject1).d();
                if (!TextUtils.isEmpty((CharSequence) localObject2)) {//if-nez v1, :cond_2
                    holder.a.setText((CharSequence) localObject2);
                } else {//:cond_2
                    holder.a.setVisibility(View.GONE);
                }
                //:goto_2
                if (this.b.getString(2131231218).equals(localObject2)) {//if-eqz v1, :cond_3
                    this.d.a(holder.e);
                    holder.e.setVisibility(View.VISIBLE);
                    holder.e.setOnClickListener(new f(this));
                } else {
                    holder.e.setVisibility(8);
                }
                //:goto_3
                boolean bool1 = ((RightTitleColumn) localObject1).c();
                String str2 = ((RightTitleColumn) localObject1).e();
                boolean bool2 = ((RightTitleColumn) localObject1).a();
                if (bool1) {//if-eqz v7, :cond_4
                    holder.f.setVisibility(View.VISIBLE);
                    holder.f.setOnClickListener(new i(this, str1, bool2, str2, (String) localObject2));
                }else {
                    holder.f.setVisibility(View.GONE);
                }
                break;
            case 1://:pswitch_1
                if (paramView == null) {//if-nez p2, :cond_7
                    paramView = LayoutInflater.from(this.b).inflate(2130903257, null);
                    holder = new Holder();
                    holder.b = ((LinearLayout)paramView.findViewById(2131166234));
                    holder.c = ((LinearLayout)paramView.findViewById(2131166237));
                    holder.d = ((LinearLayout)paramView.findViewById(2131166240));
                    paramView.setTag(holder);
                }else {
                    holder = (Holder)paramView.getTag();
                    holder.c.setVisibility(View.VISIBLE);
                    holder.d.setVisibility(View.VISIBLE);
                }
                //:goto_4
                int i = ((RightListColumn)localObject1).c();
                if (i == 1) {//if-ne v2, v4, :cond_8
                    a(((RightListColumn) localObject1).a(0), holder.b, true);
                    holder.c.setVisibility(View.INVISIBLE);
                    holder.d.setVisibility(View.INVISIBLE);
                }else if (i == 2)
                {
                    a(((RightListColumn)localObject1).a(0), holder.b, true);
                    a(((RightListColumn)localObject1).a(1), holder.c, true);
                    holder.d.setVisibility(View.INVISIBLE);
                }else if (i == 3) {
                    a(((RightListColumn) localObject1).a(0), holder.b, true);
                    a(((RightListColumn) localObject1).a(1), holder.c, true);
                    a(((RightListColumn) localObject1).a(2), holder.d, true);
                }
                //:cond_5
                //:goto_5
                i = getItemViewType(paramInt - 1);
                if (paramInt != this.c.size() - 1)
                    getItemViewType(paramInt + 1);
                paramInt = 0;
                if (i == 0) {//if-nez v0, :cond_20
                    paramInt = DPIUtil.dip2px(15.0F);
                }
                paramView.setPadding(0, paramInt, 0, paramView.getPaddingBottom());
                break;
            case 2://:pswitch_2
                int m;
                if (paramView == null) {//if-nez p2, :cond_b
                    paramView = LayoutInflater.from(this.b).inflate(2130903258, null);
                    holder = new Holder();
                    holder.b = ((LinearLayout) paramView.findViewById(2131166243));
                    holder.c = ((LinearLayout) paramView.findViewById(2131166246));
                    holder.d = ((LinearLayout) paramView.findViewById(2131166249));
                    holder.g = false;
                    holder.h = false;
                    paramView.setTag(holder);
                }else {
                    holder = (Holder)paramView.getTag();
                    holder.c.setVisibility(View.VISIBLE);
                    holder.d.setVisibility(View.VISIBLE);
                }
                //:goto_7
                m = getItemViewType(paramInt - 1);
                if (paramInt == this.c.size() - 1) {//if-ne p1, v2, :cond_c
                    i = -1;
                }else {
                    i = getItemViewType(paramInt + 1);
                }
                //:goto_8
                if (m == 0)
                        j = DPIUtil.dip2px(8.0F);
                int  k = 0;
                if (2 != i) {//if-eq v2, v5, :cond_1f
                    k = DPIUtil.dip2px(8.0F); ;
                }
                paramView.setPadding(0, j, 0, k);
                localObject2 = new com.jingdong.app.mall.category.a.a[3];

                for (j = 0; j < 3; j++){//if-ge v2, v4, :cond_d
                    localObject2[j] = new com.jingdong.app.mall.category.a.a();
                    localObject2[j].a(false, false, false, false);
                    localObject2[j].a(-1841687, 1);
                }
                if ((!holder.g) && (paramInt > 0)) {//if-nez v2, :cond_e if-gtz p1, :cond_12
                    holder.g = true;
                    j = getItemViewType(paramInt);
                    if ((1 == j) || (2 == j)) {//if-eq v2, v4, :cond_13 if-ne v2, v4, :cond_e
                        //paramInt -= 1;
                        ////:goto_e
                        while (--paramInt >= 0) {//if-ltz v2, :cond_e
                            k = getItemViewType(paramInt);
                            if ((1 == k) || (2 == k)) {
                                if (k != j){//if-eq v7, v4, :cond_15
                                    holder.h = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                //:cond_e
                //:goto_b
                if (holder.h) {//if-eqz v2, :cond_10
                    localObject2[0].a(true);
                    if (1 == m)
                        localObject2[0].b(true);
                    if (2 != i)
                        localObject2[0].d(true);
                }
                localObject2[0].c(true);

                paramInt = ((RightListColumn) localObject1).c();
                if (paramInt == 1) {//if-ne v2, v4, :cond_16
                    a(((RightListColumn) localObject1).a(0), holder.b, false);
                    holder.c.setVisibility(View.INVISIBLE);
                    holder.d.setVisibility(View.INVISIBLE);
                } else if (paramInt == 2) {//if-ne v2, v4, :cond_19
                    a(((RightListColumn) localObject1).a(0), holder.b, false);
                    a(((RightListColumn) localObject1).a(1), holder.c, false);
                    holder.d.setVisibility(View.INVISIBLE);
                    if (holder.h) {//if-eqz v2, :cond_18
                        if (1 == m)//if-ne v2, v6, :cond_17
                            localObject2[1].b(true);
                        if (2 != i) {//if-eq v2, v5, :cond_18
                            localObject2[0].d(true);
                            localObject2[1].d(true);
                        }
                    }//:cond_18
                    localObject2[1].c(true);
                }else if (paramInt == 3){//if-ne v2, v4, :cond_11
                    a(((RightListColumn)localObject1).a(0), holder.b, false);
                    a(((RightListColumn)localObject1).a(1), holder.c, false);
                    a(((RightListColumn)localObject1).a(2), holder.d, false);
                    localObject2[1].c(true);
                    if (holder.h)
                    {//if-eqz v2, :cond_1c
                        if (1 == m)
                        {
                            localObject2[1].b(true);
                            localObject2[2].b(true);
                        }
                        if (2 != i)
                        {
                            localObject2[0].d(true);
                            localObject2[1].d(true);
                            localObject2[2].d(true);
                        }
                        localObject2[2].c(true);
                    }//:cond_1c
                    if (2 == i){//if-ne v2, v5, :cond_11
                        localObject2[0].d(true);
                        localObject2[1].d(true);
                        localObject2[2].d(true);
                    }
                }
                //:cond_11
                //:goto_c
                if (Build.VERSION.SDK_INT > 16) {//if-lt v2, v4, :cond_1d
                    holder.b.setBackground(localObject2[0]);
                    holder.c.setBackground(localObject2[1]);
                    holder.d.setBackground(localObject2[2]);
                } else {
                    holder.b.setBackgroundDrawable(localObject2[0]);
                    holder.c.setBackgroundDrawable(localObject2[1]);
                    holder.d.setBackgroundDrawable(localObject2[2]);
                }
                //:goto_d
                if (((RightListColumn)localObject1).b() != 1) {//if-ne v0, v2, :cond_1e
                    holder.c.setVisibility(8);
                    holder.d.setVisibility(8);
                    holder.b.setGravity(3);
                    holder = (TextView)holder.b.getChildAt(0);
                    holder.setGravity(16);
                    holder.setPadding(16, 0, 16, 0);
                }else {
                    holder.b.setGravity(17);
                    localObject1 = (TextView)holder.b.getChildAt(0);
                    ((TextView)localObject1).setGravity(17);
                    holder = (TextView)holder.c.getChildAt(0);
                    ((TextView)localObject1).setPadding(holder.getPaddingLeft(), 0, holder.getPaddingRight(), 0);
                }
                break;
            case -1://:pswitch_3
                if ((this.e != null) && (this.e.size() > 0)) {//if-eqz v0, :cond_0  if-lez v0, :cond_0
                    i = getCount();
                    paramInt = this.e.size() + (paramInt - i);
                    if (this.e.get(paramInt) != null)//if-eqz v0, :cond_0
                        return ((CategoryFooter)this.e.get(paramInt)).a(paramInt, paramView, holder);
                }
                    break;

        }
                    return paramView;


    }

    public final int getViewTypeCount()
    {
        return 3;
    }

    final static class Holder
    {
        public TextView a;
        public LinearLayout b;
        public LinearLayout c;
        public LinearLayout d;
        public LinearLayout e;
        public LinearLayout f;
        public boolean g;
        public boolean h;
    }
}
