package com.zy.app.mall.navigationbar;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.jingdong.app.mall.faxian.JDFaxianFragment;
import com.jingdong.app.mall.faxian.b.a.FaxianEntryInteractor;
import com.jingdong.app.mall.navigationbar.NavigationOptHelper;
import com.jingdong.app.mall.personel.home.JDPersonalFragment;
import com.jingdong.app.mall.shopping.JDShoppingCartFragment;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.utils.frame.TabBarButton;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/7.
 */
public class NavigationButton extends TabBarButton {
    private static long m = 0L;
    public boolean a = false;
    Handler handler = new Handler();//b
    private String titile;//d
    private int index;//e
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private Context context;    //i
    private ButtonAction buttonAction;  //j
    private String url;     //k

    private boolean l = false;

    private NavigationButton(Context paramContext, int index)
    {
        super(paramContext);
        this.context = paramContext;
        this.index = index;
        this.buttonAction = new ButtonAction(this, index);
    }

    public NavigationButton(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
        this(paramContext, paramInt1);
        this.titile = paramString;
        setState(paramString, paramInt2, paramInt3);
    }

    public NavigationButton(Context paramContext, int functionId, String naviLabel, String offPath, String onPath, boolean iconTag)
    {
        this(paramContext, functionId);
        this.titile = naviLabel;
        setState(naviLabel, offPath, onPath, false, iconTag);
        this.a = iconTag;
    }

    //public final int a()
    public final int getIndex()
    {
        return this.index;
    }

    //public final void a(String paramString)
    public final void setUrl(String paramString)
    {
        this.url = paramString;
    }

    public final void a(boolean paramBoolean)
    {
        this.l = true;
    }

    //public final String b()
    public final String getUrl()
    {
        return this.url;
    }

    //public final h c()
    public final ButtonAction getButtonAction()
    {
        return this.buttonAction;
    }



    //h
    public static final class ButtonAction{
        private NavigationButton a;
        private Runnable mRunnable; //b
        private boolean highlight;  //c
        private int d;
        private boolean e = true;

        private ButtonAction(NavigationButton button, int paramInt){
            this(button, createRunnable(paramInt), paramInt);
            if(Log.D)
                Log.d("navigationButton", "ButtonAction this.index -->> "+this.a.titile);
        }

        private ButtonAction(NavigationButton button,Runnable paramRunnable, int paramInt)
        {
            this(button, paramRunnable, true, paramInt);
        }

        private ButtonAction(NavigationButton button,Runnable paramRunnable, boolean paramBoolean, int paramInt)
        {
            this.a = button;
            this.d = paramInt;
            if (paramRunnable == null)
                return;
            this.mRunnable = paramRunnable;
            this.highlight = true;
        }

        public final void a()
        {
            switch (this.d)
            {
                case 5: //:pswitch_0
                case 6://:pswitch_0
                case 7://:pswitch_0
                case 8://:pswitch_0
                case 9://:pswitch_0
                case 10://:pswitch_0
                case 11://:pswitch_0
                    break;
                case 0: //:pswitch_1
                    if (NavigationOptHelper.b)
                    {
                        NavigationOptHelper.b = false;
                    }else{
                        JDMtaUtils.sendCommonData(this.a.context, "NavigationBar_Home", "", "", this.a.context, "", JDHomeFragment.class, "");
                    }
                    break;
                case 1: //:pswitch_2
                case 12://:pswitch_2
                    JDMtaUtils.sendCommonData(this.a.context, "NavigationBar_Classification", "", "", this.a.context, "", JDNewCategoryFragment.class, "");
                    break;
                case 2: //:pswitch_3
                    JDMtaUtils.sendCommonData(this.a.context, "NavigationBar_Discover", "", "", this.a.context, "", JDFaxianFragment.class, "");
                    break;
                case 3: //:pswitch_4
                    JDMtaUtils.sendCommonData(this.a.context, "NavigationBar_Shopcart", "", "", this.a.context, "", JDShoppingCartFragment.class, "");
                    break;
                case 4: //:pswitch_5
                    JDMtaUtils.sendCommonData(this.a.context, "NavigationBar_MyJD", "", "", this.a.context, "", JDPersonalFragment.class, "");
                    break;

            }
            this.mRunnable.run();
            if (System.currentTimeMillis() - NavigationButton.m > 300000L)
            {
                NavigationButton.m = System.currentTimeMillis();
                this.a.handler.postDelayed(new Runnable(){   //new i(this)
                    @Override
                    public void run() {
                        //"loadRedDot in"
                        FaxianEntryInteractor.getInstance().a(true);
                    }
                }, 500L);
            }

        }

        public final boolean isHighlight()
        {
            return this.highlight;
        }

        private static Runnable createRunnable(int paramInt) {
            NavigationOptHelper v1 = NavigationOptHelper.getInstance();
            Runnable v0 = null;
            switch (paramInt) {
                case 5:     //:pswitch_0
                case 6:     //:pswitch_0
                case 7:     //:pswitch_0
                case 8:     //:pswitch_0
                case 9:     //:pswitch_0
                case 10:    //:pswitch_0
                case 11:    //:pswitch_0
                    break;
                case 0:     //:pswitch_1
                    v0 = new NavigationOptHelper._N(v1);//n(Lcom/jingdong/app/mall/navigationbar/j;)V
                    break;
                case 1:         //:pswitch_2
                case 12:        //:pswitch_2
                    v0 = new NavigationOptHelper._O(v1, paramInt);//o(Lcom/jingdong/app/mall/navigationbar/j;I)V
                    break;
                case 3:         //:pswitch_3
                    v0 = new NavigationOptHelper._P(v1);//p(Lcom/jingdong/app/mall/navigationbar/j;)V
                    break;
                case 2:         //:pswitch_4
                    v0 = new NavigationOptHelper._Q(v1);//q(Lcom/jingdong/app/mall/navigationbar/j;)V
                    break;
                case 4:         //:pswitch_5
                    v0 = new NavigationOptHelper._R(v1);//r(Lcom/jingdong/app/mall/navigationbar/j;)V
                    break;
            }
            return v0;

        }
    }
}
