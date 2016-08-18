package com.zy.app.mall.navigationbar;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.zy.app.mall.utils.frame.TabBarButton;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/7.
 */
public class NavigationButton extends TabBarButton {
    private static long m = 0L;
    public boolean a = false;
    Handler handler = new Handler();
    private String titile;
    private int index;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private Context context;
    private ButtonAction buttonAction;
    private String url;
    private boolean l = false;

    private NavigationButton(Context paramContext, int index)
    {
        super(paramContext);
        this.context = paramContext;
        this.index = index;
        this.buttonAction = new ButtonAction(index);
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

    public final ButtonAction getButtonAction()
    {
        return this.buttonAction;
    }

    private static Runnable h(int paramInt){
        NavigationOptHelper v1 = NavigationOptHelper.getInstance();
        Runnable v0=null;
        /*switch (paramInt){
            case 5:       //:pswitch_0
            case 6:     //:pswitch_0
            case 7:     //:pswitch_0
            case 8:     //:pswitch_0
            case 9:     //:pswitch_0
            case 10:    //:pswitch_0
            case 11:        //:pswitch_0
                break;
            case 0:         //:pswitch_1
                v0= new Runnable(){//n
                    @Override
                    public void run() {
                        this.a.a = 0;
                        Bundle localBundle = new Bundle();
                        JDHomeFragment.JDHomeTM localJDHomeTM = new JDHomeFragment.JDHomeTM();
                        localJDHomeTM.setBundle(localBundle);
                        l.a(localJDHomeTM);
                    }
                };
                break;
            case 1:         //:pswitch_2
            case 12:        //:pswitch_2
                v0= new Runnable(){//o
                    @Override
                    public void run() {
                        this.b.a = this.a;
                        Bundle localBundle = new Bundle();
                        JDNewCategoryFragment.JDNewCategoryTM localJDNewCategoryTM = new JDNewCategoryFragment.JDNewCategoryTM();
                        localJDNewCategoryTM.setBundle(localBundle);
                        l.a(localJDNewCategoryTM);
                    }
                };
                break;
            case 3:         //:pswitch_3
                v0= new Runnable(){//p
                    @Override
                    public void run() {
                        this.a.a = 3;
                        Bundle localBundle = new Bundle();
                        JDShoppingCartFragment.JDShoppingCartTM localJDShoppingCartTM = new JDShoppingCartFragment.JDShoppingCartTM();
                        localJDShoppingCartTM.setBundle(localBundle);
                        l.a(localJDShoppingCartTM);
                    }
                };
                break;
            case 2:         //:pswitch_4
                v0= new Runnable(){//q
                    @Override
                    public void run() {
                        this.a.a = 2;
                        Bundle localBundle = new Bundle();
                        Object localObject = this.a.b(2);
                        if (((g)localObject).a())
                        {
                            JDMFragment.JDMM localJDMM = new JDMFragment.JDMM();
                            localBundle.putString("url", ((g)localObject).b());
                            localBundle.putBoolean("isTopBarGone", false);
                            localBundle.putBoolean("isUseRightBtn", false);
                            localBundle.putBoolean("isNeedShare", false);
                            localJDMM.setBundle(localBundle);
                            l.a(localJDMM);
                            return;
                        }
                        localObject = new JDFaxianFragment.JDFaxianTM();
                        ((JDFaxianFragment.JDFaxianTM)localObject).setBundle(localBundle);
                        l.a((JDTaskModule)localObject);
                    }
                };
                break;
            case 4:         //:pswitch_5
                v0= new Runnable(){//r
                    @Override
                    public void run() {
                        this.a.a = 4;
                        Bundle localBundle = new Bundle();
                        x localx = new x();
                        localx.setBundle(localBundle);
                        l.a(localx);
                    }
                };
                break;
        }*/
        return v0;

    }

    //h
    public final  class ButtonAction{
        private Runnable mRunnable;
        private boolean highlight;
        private int d;
        private boolean e = true;

        private ButtonAction(int paramInt){
            this(h(paramInt), paramInt);
            if(Log.D)
                Log.d("navigationButton", "ButtonAction this.index -->> "+NavigationButton.this.titile);

        }

        private ButtonAction(Runnable paramRunnable, int paramInt)
        {
            this(paramRunnable, true, paramInt);
        }

        private ButtonAction(Runnable paramRunnable, boolean paramBoolean, int paramInt)
        {
            this.d = paramInt;
            if (paramRunnable == null)
                return;
            this.mRunnable = paramRunnable;
            this.highlight = true;
        }

        public final void a()
        {
            /*switch (this.d)
            {
                case 5: //:pswitch_0
                case 6://:pswitch_0
                case 7://:pswitch_0
                case 8://:pswitch_0
                case 9://:pswitch_0
                case 10://:pswitch_0
                case 11://:pswitch_0
                    this.mRunnable.run();
                    if (System.currentTimeMillis() - NavigationButton.d() > 300000L)
                    {
                        NavigationButton.a(System.currentTimeMillis());
                        NavigationButton.this.handler.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                //"loadRedDot in"
                                com.jingdong.app.mall.faxian.b.a.f.a().a(true);
                            }
                        }, 500L);
                    }
                    break;
                case 0: //:pswitch_1
                    if (NavigationOptHelper.b)
                    {
                        NavigationOptHelper.b = false;
                    }else{
                        JDMtaUtils.sendCommonData(NavigationButton.a(this.a), "NavigationBar_Home", "", "", NavigationButton.a(this.a), "", JDHomeFragment.class, "");
                    }
                    break;
                case 1: //:pswitch_2
                case 12://:pswitch_2
                    JDMtaUtils.sendCommonData(NavigationButton.a(this.a), "NavigationBar_Classification", "", "", NavigationButton.a(this.a), "", JDNewCategoryFragment.class, "");
                    break;
                case 2: //:pswitch_3
                    JDMtaUtils.sendCommonData(NavigationButton.a(this.a), "NavigationBar_Discover", "", "", NavigationButton.a(this.a), "", JDFaxianFragment.class, "");
                    break;
                case 3: //:pswitch_4
                    JDMtaUtils.sendCommonData(NavigationButton.a(this.a), "NavigationBar_Shopcart", "", "", NavigationButton.a(this.a), "", JDShoppingCartFragment.class, "");
                    break;
                case 4: //:pswitch_5
                    JDMtaUtils.sendCommonData(NavigationButton.a(this.a), "NavigationBar_MyJD", "", "", NavigationButton.a(this.a), "", JDPersonalFragment.class, "");
                    break;

            }*/

        }

        public final boolean isHighlight()
        {
            return this.highlight;
        }
    }
}
