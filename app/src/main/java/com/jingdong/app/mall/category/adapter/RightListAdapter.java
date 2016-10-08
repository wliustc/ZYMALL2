package com.jingdong.app.mall.category.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zy.common.entity.Catelogy;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDImageUtils;

import java.util.ArrayList;

/**
 * Created by robin on 16-8-25.
 */
//e
public class RightListAdapter extends BaseAdapter {
    private int a;
    private Context b;
    private List<com.jingdong.app.mall.category.b.b> c;
    private b d;
    private List<com.jingdong.app.mall.category.view.a> e = null;

    public e(Context paramContext)
    {
        this.b = paramContext;
    }

    private void a(Catelogy paramCatelogy, LinearLayout paramLinearLayout, boolean paramBoolean)
    {
        if (paramCatelogy == null);
        do
            return;
        while (paramLinearLayout == null);
        Object localObject1;
        Object localObject2;
        if (paramBoolean)
        {
            localObject1 = (ImageView)paramLinearLayout.getChildAt(0);
            localObject2 = (TextView)paramLinearLayout.getChildAt(1);
            if (localObject1 != null)
                JDImageUtils.displayImage(paramCatelogy.getImgUrl(), (ImageView)localObject1);
            if (localObject2 != null)
                ((TextView)localObject2).setText(paramCatelogy.getName());
        }
        while (true)
        {
            this.d.a(paramLinearLayout, paramCatelogy);
            return;
            localObject1 = (TextView)paramLinearLayout.getChildAt(0);
            localObject2 = (ImageView)paramLinearLayout.getChildAt(1);
            if (localObject1 != null)
                ((TextView)localObject1).setText(paramCatelogy.getName());
            if (localObject2 == null)
                continue;
            if (("chSpreadAllData".equals(paramCatelogy.getAction())) || ("enSpreadAllData".equals(paramCatelogy.getAction())))
            {
                ((ImageView)localObject2).setVisibility(0);
                ((ImageView)localObject2).setImageResource(2130839420);
                ((TextView)localObject1).setTextColor(this.b.getResources().getColor(2131100465));
                ((TextView)localObject1).setTextSize(13.0F);
                continue;
            }
            if (("chPackUpAllData".equals(paramCatelogy.getAction())) || ("enPackUpAllData".equals(paramCatelogy.getAction())))
            {
                ((TextView)localObject1).setTextColor(this.b.getResources().getColor(2131100465));
                ((TextView)localObject1).setTextSize(13.0F);
                ((ImageView)localObject2).setVisibility(0);
                ((ImageView)localObject2).setImageResource(2130839438);
                continue;
            }
            ((ImageView)localObject2).setVisibility(8);
            ((TextView)localObject1).setTextColor(this.b.getResources().getColor(2131099876));
            ((TextView)localObject1).setTextSize(12.0F);
        }
    }

    public final void a(b paramb)
    {
        this.d = paramb;
    }

    public final void a(com.jingdong.app.mall.category.view.a parama)
    {
        if (this.e == null)
            this.e = new ArrayList();
        com.jingdong.app.mall.category.b.b localb = new com.jingdong.app.mall.category.b.b();
        localb.a = -1;
        this.c.add(localb);
        this.e.add(parama);
    }

    public final void a(List<com.jingdong.app.mall.category.b.b> paramList)
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
        if (this.c == null)
            return null;
        return (com.jingdong.app.mall.category.b.b)this.c.get(paramInt);
    }

    public final long getItemId(int paramInt)
    {
        return paramInt;
    }

    public final int getItemViewType(int paramInt)
    {
        if ((this.c != null) && (this.c.get(paramInt) != null))
            return ((com.jingdong.app.mall.category.b.b)this.c.get(paramInt)).a;
        return 1;
    }

    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        int j = 0;
        Object localObject1 = (com.jingdong.app.mall.category.b.b)this.c.get(paramInt);
        this.a = getItemViewType(paramInt);
        Object localObject2;
        label169: label301: label313: label325: int i;
        switch (this.a)
        {
            default:
                return paramView;
            case 0:
                String str1;
                if (paramView == null)
                {
                    paramView = LayoutInflater.from(this.b).inflate(2130903259, null);
                    paramViewGroup = new j();
                    paramViewGroup.a = ((TextView)paramView.findViewById(2131166252));
                    paramViewGroup.e = ((LinearLayout)paramView.findViewById(2131166253));
                    paramViewGroup.f = ((LinearLayout)paramView.findViewById(2131166254));
                    paramView.setTag(paramViewGroup);
                    localObject2 = ((d)localObject1).b();
                    str1 = ((d)localObject1).d();
                    if (TextUtils.isEmpty((CharSequence)localObject2))
                        break label301;
                    paramViewGroup.a.setText((CharSequence)localObject2);
                    if (!this.b.getString(2131231218).equals(localObject2))
                        break label313;
                    this.d.a(paramViewGroup.e);
                    paramViewGroup.e.setVisibility(0);
                    paramViewGroup.e.setOnClickListener(new f(this));
                }
                while (true)
                {
                    boolean bool1 = ((d)localObject1).c();
                    String str2 = ((d)localObject1).e();
                    boolean bool2 = ((d)localObject1).a();
                    if (!bool1)
                        break label325;
                    paramViewGroup.f.setVisibility(0);
                    paramViewGroup.f.setOnClickListener(new i(this, str1, bool2, str2, (String)localObject2));
                    return paramView;
                    paramViewGroup = (j)paramView.getTag();
                    break;
                    paramViewGroup.a.setVisibility(8);
                    break label169;
                    paramViewGroup.e.setVisibility(8);
                }
                paramViewGroup.f.setVisibility(8);
                return paramView;
            case 1:
                if (paramView != null)
                    break;
                paramView = LayoutInflater.from(this.b).inflate(2130903257, null);
                paramViewGroup = new j();
                paramViewGroup.b = ((LinearLayout)paramView.findViewById(2131166234));
                paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131166237));
                paramViewGroup.d = ((LinearLayout)paramView.findViewById(2131166240));
                paramView.setTag(paramViewGroup);
                label406: localObject1 = (c)localObject1;
                i = ((c)localObject1).c();
                if (i == 1)
                {
                    a(((c)localObject1).a(0), paramViewGroup.b, true);
                    paramViewGroup.c.setVisibility(4);
                    paramViewGroup.d.setVisibility(4);
                    label457: i = getItemViewType(paramInt - 1);
                    if (paramInt != this.c.size() - 1)
                        getItemViewType(paramInt + 1);
                    if (i != 0)
                        break label1609;
                }
            case 2:
            case -1:
        }
        label1177: label1179: label1470: label1603: label1609: for (paramInt = DPIUtil.dip2px(15.0F); ; paramInt = 0)
        {
            paramView.setPadding(0, paramInt, 0, paramView.getPaddingBottom());
            return paramView;
            paramViewGroup = (j)paramView.getTag();
            paramViewGroup.c.setVisibility(0);
            paramViewGroup.d.setVisibility(0);
            break label406;
            if (i == 2)
            {
                a(((c)localObject1).a(0), paramViewGroup.b, true);
                a(((c)localObject1).a(1), paramViewGroup.c, true);
                paramViewGroup.d.setVisibility(4);
                break label457;
            }
            if (i != 3)
                break label457;
            a(((c)localObject1).a(0), paramViewGroup.b, true);
            a(((c)localObject1).a(1), paramViewGroup.c, true);
            a(((c)localObject1).a(2), paramViewGroup.d, true);
            break label457;
            int m;
            if (paramView == null)
            {
                paramView = LayoutInflater.from(this.b).inflate(2130903258, null);
                paramViewGroup = new j();
                paramViewGroup.b = ((LinearLayout)paramView.findViewById(2131166243));
                paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131166246));
                paramViewGroup.d = ((LinearLayout)paramView.findViewById(2131166249));
                paramViewGroup.g = false;
                paramViewGroup.h = false;
                paramView.setTag(paramViewGroup);
                m = getItemViewType(paramInt - 1);
                if (paramInt != this.c.size() - 1)
                    break label877;
                i = -1;
                label753: if (m == 0)
                    j = DPIUtil.dip2px(8.0F);
                if (2 == i)
                    break label1603;
            }
            for (int k = DPIUtil.dip2px(8.0F); ; k = 0)
            {
                paramView.setPadding(0, j, 0, k);
                localObject2 = new com.jingdong.app.mall.category.a.a[3];
                j = 0;
                while (true)
                    if (j < 3)
                    {
                        localObject2[j] = new com.jingdong.app.mall.category.a.a();
                        localObject2[j].a(false, false, false, false);
                        localObject2[j].a(-1841687, 1);
                        j += 1;
                        continue;
                        paramViewGroup = (j)paramView.getTag();
                        paramViewGroup.c.setVisibility(0);
                        paramViewGroup.d.setVisibility(0);
                        break;
                        label877: i = getItemViewType(paramInt + 1);
                        break label753;
                    }
                if ((paramViewGroup.g) || (paramInt <= 0))
                {
                    if (paramViewGroup.h)
                    {
                        localObject2[0].a(true);
                        if (1 == m)
                            localObject2[0].b(true);
                        if (2 != i)
                            localObject2[0].d(true);
                    }
                    localObject2[0].c(true);
                    localObject1 = (c)localObject1;
                    paramInt = ((c)localObject1).c();
                    if (paramInt != 1)
                        break label1179;
                    a(((c)localObject1).a(0), paramViewGroup.b, false);
                    paramViewGroup.c.setVisibility(4);
                    paramViewGroup.d.setVisibility(4);
                    label1000: if (Build.VERSION.SDK_INT < 16)
                        break label1434;
                    paramViewGroup.b.setBackground(localObject2[0]);
                    paramViewGroup.c.setBackground(localObject2[1]);
                    paramViewGroup.d.setBackground(localObject2[2]);
                }
                while (true)
                {
                    if (((c)localObject1).b() != 1)
                        break label1470;
                    paramViewGroup.c.setVisibility(8);
                    paramViewGroup.d.setVisibility(8);
                    paramViewGroup.b.setGravity(3);
                    paramViewGroup = (TextView)paramViewGroup.b.getChildAt(0);
                    paramViewGroup.setGravity(16);
                    paramViewGroup.setPadding(16, 0, 16, 0);
                    return paramView;
                    paramViewGroup.g = true;
                    j = getItemViewType(paramInt);
                    if ((1 != j) && (2 != j))
                        break;
                    paramInt -= 1;
                    while (true)
                    {
                        if (paramInt < 0)
                            break label1177;
                        k = getItemViewType(paramInt);
                        if ((1 != k) && (2 != k))
                            break;
                        if (k != j)
                        {
                            paramViewGroup.h = true;
                            break;
                        }
                        paramInt -= 1;
                    }
                    break;
                    if (paramInt == 2)
                    {
                        a(((c)localObject1).a(0), paramViewGroup.b, false);
                        a(((c)localObject1).a(1), paramViewGroup.c, false);
                        paramViewGroup.d.setVisibility(4);
                        if (paramViewGroup.h)
                        {
                            if (1 == m)
                                localObject2[1].b(true);
                            if (2 != i)
                            {
                                localObject2[0].d(true);
                                localObject2[1].d(true);
                            }
                        }
                        localObject2[1].c(true);
                        break label1000;
                    }
                    if (paramInt != 3)
                        break label1000;
                    a(((c)localObject1).a(0), paramViewGroup.b, false);
                    a(((c)localObject1).a(1), paramViewGroup.c, false);
                    a(((c)localObject1).a(2), paramViewGroup.d, false);
                    localObject2[1].c(true);
                    if (paramViewGroup.h)
                    {
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
                    }
                    if (2 != i)
                        break label1000;
                    localObject2[0].d(true);
                    localObject2[1].d(true);
                    localObject2[2].d(true);
                    break label1000;
                    paramViewGroup.b.setBackgroundDrawable(localObject2[0]);
                    paramViewGroup.c.setBackgroundDrawable(localObject2[1]);
                    paramViewGroup.d.setBackgroundDrawable(localObject2[2]);
                }
                paramViewGroup.b.setGravity(17);
                localObject1 = (TextView)paramViewGroup.b.getChildAt(0);
                ((TextView)localObject1).setGravity(17);
                paramViewGroup = (TextView)paramViewGroup.c.getChildAt(0);
                ((TextView)localObject1).setPadding(paramViewGroup.getPaddingLeft(), 0, paramViewGroup.getPaddingRight(), 0);
                return paramView;
                if ((this.e == null) || (this.e.size() <= 0))
                    break;
                i = getCount();
                paramInt = this.e.size() + (paramInt - i);
                if (this.e.get(paramInt) == null)
                    break;
                return ((com.jingdong.app.mall.category.view.a)this.e.get(paramInt)).a(paramInt, paramView, paramViewGroup);
            }
        }
    }

    public final int getViewTypeCount()
    {
        return 3;
    }
}
