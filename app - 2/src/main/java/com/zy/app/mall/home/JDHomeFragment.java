package com.zy.app.mall.home;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.b.FloorFigureViewCtrl;
import com.zy.app.mall.home.floor.view.view.DragImageView;
import com.zy.app.mall.home.floor.view.view.HomeFooterView;
import com.zy.app.mall.home.floor.view.view.HomeProductHeadView;
import com.zy.app.mall.home.floor.view.view.HomeTitle;
import com.zy.app.mall.navigationbar.JDTabFragment;
import com.zy.common.BaseActivity;
import com.zy.common.config.Configuration;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.frame.IDestroyListener;
import com.zy.common.login.LoginUserBase;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;
import com.zy.common.utils.b.CombineSetting;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Robin on 2016/5/4.
 */
public class JDHomeFragment extends JDTabFragment
        implements LoginUserBase {
    public static String b = null;
    public static boolean c = true;
    private static JDHomeFragment j;
    com.jingdong.app.mall.home.floor.view.view.a a;
    protected PullToRefreshListView mPullToRefreshListView;//d;
    protected LinearLayout mRefreshListHeader;//e;
    protected View view = null;   //f
    protected z g;
    protected HomePageObserver mHomePageObserver;//h;
    protected Boolean i = Boolean.valueOf(false);
    private final String k = JDHomeFragment.class.getSimpleName();
    private int l = (int)(DPIUtil.getHeight() * 0.618D);
    private HashMap<String, View> m = new HashMap();
    private View n = null;
    private HomeProductHeadView mHomeProductHeadView;   //o;
    private HomeFooterView mHomeFooterView;                //p;
    private View mSnapToTop;//q
    private DragImageView mDragImageView;    //r
    private HomeTitle mHomeTitle;       //s
    private ListView mRefreshListView;//t;
    private HomeProductAdapter mHomeProductAdapter;//u
    private int v = 0;
    private Runnable w;
    private String x;
    private HomeLayerParamEntity y;

    public static JDHomeFragment a()
    {
        if (j == null)
            j = new JDHomeFragment();
        return j;
    }

    private void a(int paramInt)
    {
        if (this.mHomeTitle != null)
            this.mHomeTitle.changeSearchBarColorVarScrolling(paramInt);
        if (this.mSnapToTop == null);
        do
            while (true)
            {
                return;
                if (paramInt >= DPIUtil.getHeight())
                    break;
                if (this.mSnapToTop.getVisibility() != View.VISIBLE)
                    continue;
                post(new am(this));
                return;
            }
        while (this.mSnapToTop.getVisibility() != View.GONE);
        post(new an(this));
    }

    private void a(ArrayList<HomeFloorNewModel> paramArrayList)
    {
        monitorenter;
        while (true)
        {
            int i1;
            HomeFloorNewModel localHomeFloorNewModel;
            String str;
            int i2;
            MallBaseFloor localMallBaseFloor;
            try
            {
                this.mRefreshListHeader.removeAllViews();
                this.mDragImageView.setVisibility(View.GONE);
                this.a = null;
                i1 = 0;
                if (i1 >= paramArrayList.size())
                    break label348;
                localHomeFloorNewModel = (HomeFloorNewModel)paramArrayList.get(i1);
                if (localHomeFloorNewModel == null)
                    break label355;
                str = Md5Encrypt.md5(localHomeFloorNewModel.getType() + localHomeFloorNewModel.getFloorId());
                localObject = (View)this.m.get(str);
                if (localObject != null)
                    break label351;
                i2 = i.a(localHomeFloorNewModel);
                localMallBaseFloor = com.jingdong.app.mall.home.floor.a.b.b.a(this.thisActivity, i2);
                if (i2 != i.j)
                    continue;
                if (localMallBaseFloor != null)
                    continue;
                this.mRefreshListHeader.setPadding(this.mRefreshListHeader.getPaddingLeft(), this.mHomeTitle.getBarHeight(), this.mRefreshListHeader.getPaddingRight(), this.mRefreshListHeader.getPaddingBottom());
                localObject = localMallBaseFloor;
                if (localMallBaseFloor != null)
                    break label351;
                if (i2 == i.p)
                {
                    localObject = new HomeProductHeadView(this.thisActivity.getBaseContext());
                    this.mHomeProductHeadView = ((HomeProductHeadView)localObject);
                    this.mHomeProductHeadView.setOnDataGetListener(new HomeProductHeadView.OnDataGetListener(){//ab(this)
                        @Override
                        public boolean a(ArrayList<?> paramArrayList, int paramInt) {
                            boolean bool = false;
                            if ((JDHomeFragment.c(this.a) != null) && (paramArrayList != null) && (JDHomeFragment.e(this.a) != null) && (JDHomeFragment.e(this.a).getVisibility() == 0))
                            {
                                HomeProductAdapter localHomeProductAdapter = JDHomeFragment.c(this.a);
                                if (paramInt == 1)
                                    bool = true;
                                localHomeProductAdapter.a(paramArrayList, bool);
                                JDHomeFragment.c(this.a).notifyDataSetChanged();
                                return true;
                            }
                            return false;
                        }
                    });
                    break label351;
                    this.n = localMallBaseFloor;
                    continue;
                }
            }
            finally
            {
                monitorexit;
            }
            Object localObject = localMallBaseFloor;
            if (i2 == i.q)
            {
                localObject = localMallBaseFloor;
                if (this.mDragImageView != null)
                {
                    this.a = com.jingdong.app.mall.home.floor.view.view.a.a();
                    this.a.a(this, localHomeFloorNewModel, this.mDragImageView);
                    localObject = localMallBaseFloor;
                }
            }
            label348: label351:
            while (localObject != null)
            {
                if (((View)localObject).getParent() == null)
                    this.mRefreshListHeader.addView((View)localObject);
                if ((localObject instanceof MallBaseFloor))
                    ((MallBaseFloor)localObject).a(this, localHomeFloorNewModel, null, null);
                while (true)
                {
                    this.m.put(str, localObject);
                    break;
                    if (!(localObject instanceof HomeProductHeadView))
                        break;
                    ((HomeProductHeadView)localObject).init(this, localHomeFloorNewModel, this.mHomeFooterView);
                }
                monitorexit;
                return;
            }
            label355: i1 += 1;
        }
    }

    private void a(boolean paramBoolean)
    {
        int i1 = 1;
        if (this.mHomeTitle != null)
            this.mHomeTitle.setMessageFlag(true);
        if (this.w == null)
            this.w = new ae(this);
        post(this.w);
        BaseActivity localBaseActivity = this.thisActivity;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramBoolean)
            i1 = 0;
        JDMtaUtils.sendCommonData(localBaseActivity, "Home_Refresh", i1, "", this, "", "", "", com.jingdong.app.mall.home.floor.a.a.a.b);
        if (paramBoolean)
            d();
    }

    private int f()
    {
        int i1 = 0;
        if ((this.mRefreshListView == null) || (this.mRefreshListView.getAdapter() == null) || (this.mRefreshListHeader == null) || (this.mRefreshListHeader.getChildCount() == 0) || (this.mRefreshListHeader.getHeight() == 0));
        int i2;
        do
        {
            return 0;
            i2 = this.mRefreshListView.getFirstVisiblePosition();
        }
        while (i2 == 0);
        if (i2 == 1)
        {
            View localView = this.mRefreshListView.getChildAt(0);
            if (localView == null);
            while (true)
            {
                return -i1;
                i1 = localView.getTop();
            }
        }
        return this.mRefreshListHeader.getHeight();
    }

    public final void a(int paramInt1, int paramInt2)
    {
        if (Log.D)
            Log.d("navigation-click", this.k + "   old-->" + paramInt1 + " now-->" + paramInt2);
        if ((paramInt1 == paramInt2) && (paramInt2 == 0) && (this.v == 0))
        {
            if (!this.mPullToRefreshListView.isRefreshing())
            {
                a(0);
                if (this.mRefreshListView != null)
                    this.mRefreshListView.setSelection(0);
                this.mPullToRefreshListView.setRefreshing();
            }
            JDMtaUtils.onClickWithPageId(this.thisActivity.getBaseContext(), "NavigationBar_Home", getClass().getName(), "NavigationBar_Main");
        }
    }

    public final int b()
    {
        if (this.n != null)
            return this.n.getHeight();
        return 0;
    }

    public final void c()
    {
        if (!c)
            return;
        if (this.mHomeTitle != null)
            this.mHomeTitle.requestRedPoint();
        if (this.g == null)
        {
            this.g = new ao(this);
            this.mHomePageObserver.a(this.g);
        }
        this.mHomePageObserver.a();
    }

    protected final void d()
    {
        if ((this.mHomeProductHeadView != null) && (this.mHomeProductAdapter != null))
            post(new ad(this));
    }

    public final void e()
    {
        if (Log.D)
            Log.d("Temp", "loginCompletedNotify() -->> ");
        post(new af(this));
    }

    public void onCreate(Bundle paramBundle)
    {
        if (Log.D)
            Log.d(this.k, "onCreate -->> ");
        setPageId("Home_Main");
        this.needRemoveviewOnStop = false;
        if (this.mHomePageObserver == null)
            this.mHomePageObserver = HomePageObserver.getInstance(this.thisActivity);
        int i1 = this.thisActivity.getIntent().getIntExtra("moduleId", -1);
        if ((Configuration.getBooleanProperty("beforeInitTip").booleanValue()) && (!com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences().getBoolean("hasInitTip", false)))
            c = false;
        this.mHttpGroupWithNPS = this.mHomePageObserver.c();
        try
        {
            LoginUserBase.init();
            LoginUser.getInstance().homeAutoLogin(this.thisActivity, this, i1);
            if (this.x == null)
                this.x = LoginUserBase.getLoginUserName();
            super.onCreate(paramBundle);
            return;
        }
        catch (Throwable e)
        {

                if (Log.E)
                e.printStackTrace();

        }
    }

    public View onCreateViews(LayoutInflater paramLayoutInflater, Bundle paramBundle)
    {
        this.view = ImageUtil.inflate(R.layout.pull_refresh_scroll_new, null);       //2130904224
        this.thisActivity.addDestroyListener(new IDestroyListener(){//aa(this));
            @Override
            public void onDestroy() {
                JDHomeFragment.this.d();
            }
        });
        this.mPullToRefreshListView = ((PullToRefreshListView)this.view.findViewById(R.id.pull_refresh_scroll));//2131172359
        ((ListView)this.mPullToRefreshListView.getRefreshableView()).setOverScrollMode(2);
        this.mPullToRefreshListView.setBackgroundResource(R.color.home_content_bg);//2131100105
        this.mPullToRefreshListView.setFadingEdgeLength(0);
        this.mPullToRefreshListView.setVerticalScrollBarEnabled(false);
        ((ListView)this.mPullToRefreshListView.getRefreshableView()).setCacheColorHint(0);
        ((ListView)this.mPullToRefreshListView.getRefreshableView()).setScrollingCacheEnabled(false);
        ((ListView)this.mPullToRefreshListView.getRefreshableView()).setDividerHeight(0);
        ((ListView)this.mPullToRefreshListView.getRefreshableView()).setSelector(R.color.transparent);//2131099688
        this.mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>(){//ag(this));
            @Override
            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                JDHomeFragment.this.a(true);
                JDHomeFragment.this.post(new Runnable(){//ah(this)
                    @Override
                    public void run() {
                        JDHomeFragment.this.mPullToRefreshListView.onRefreshComplete();
                    }
                }, 10000);
            }
        });
        this.mRefreshListView = ((ListView)this.mPullToRefreshListView.getRefreshableView());
        this.mRefreshListHeader = new LinearLayout(this.thisActivity);
        this.mRefreshListHeader.setOrientation(LinearLayout.VERTICAL);
        this.mRefreshListView.addHeaderView(this.mRefreshListHeader, null, false);
        this.mPullToRefreshListView.setOnPullEventListener(new PullToRefreshBase.OnPullEventListener<ListView>(){//ai(this)
            @Override
            public void onPullEvent(PullToRefreshBase<ListView> pullToRefreshBase, PullToRefreshBase.State state, PullToRefreshBase.Mode mode) {
                if (JDHomeFragment.this.mHomeTitle != null) {
                    if ((state == PullToRefreshBase.State.PULL_TO_REFRESH) || (state == PullToRefreshBase.State.MANUAL_REFRESHING)) {
                        if (JDHomeFragment.this.mHomeTitle.getVisibility() == View.VISIBLE) {
                            JDHomeFragment.this.mHomeTitle.setVisibility(View.INVISIBLE);
                        }
                    } else if ((state == PullToRefreshBase.State.RESET) && (JDHomeFragment.this.mHomeTitle.getVisibility() == View.INVISIBLE))
                        JDHomeFragment.this.mHomeTitle.setVisibility(View.VISIBLE);
                }
            }
        });
        this.mRefreshListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            int a;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                JDHomeFragment.this.v = scrollState;
                if (scrollState == 0)
                {
                    EventBus bus = EventBus.getDefault();
                    int i = JDHomeFragment.this.f();
                    int headerHeight = 0;
                    if (JDHomeFragment.this.mRefreshListHeader != null)
                        headerHeight = JDHomeFragment.this.mRefreshListHeader.getHeight();

                    bus.post(new MallFloorEvent("home_scroll_stop", i, headerHeight));
                    JDHomeFragment.this.a(i);//b(this.b, JDHomeFragment.b(this.b));


                }else {
                    EventBus.getDefault().post(new MallFloorEvent("home_on_scroll"));
                    FloorFigureViewCtrl.getInstance().c();
                }
                return;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (JDHomeFragment.this.mHomeProductAdapter == null)
                    return;
                View firstView = JDHomeFragment.this.mRefreshListView.getChildAt(0);
                int top = 0;
                int bottom = 0;
                if (firstView != null)
                    top = firstView.getTop();
                if (firstView != null)
                    bottom = firstView.getBottom();


                if (firstVisibleItem == 1) {
                    JDHomeFragment.this.a(-top);
                    if ((bottom > 0) && (JDHomeFragment.this.mRefreshListView.getHeight() > 0) && (bottom - JDHomeFragment.this.mRefreshListView.getHeight() < 400) && (-top > this.a) && (JDHomeFragment.this.mHomeProductHeadView != null) && (!JDHomeFragment.this.mHomeProductHeadView.hasData()) && (JDHomeFragment.this.mHomeProductHeadView.getVisibility() == 0))
                        JDHomeFragment.this.mHomeProductHeadView.onBottomPullUp();
                    this.a = (-top);
                } else if ((JDHomeFragment.this.mHomeFooterView != null) && (JDHomeFragment.this.mHomeFooterView.getFooterState() != 1) && (JDHomeFragment.this.mHomeFooterView.getFooterState() != 2) && (JDHomeFragment.this.mHomeProductHeadView != null) && (JDHomeFragment.this.mHomeProductHeadView.getVisibility() == 0) && (JDHomeFragment.this.mHomeProductHeadView.hasData()) && (firstVisibleItem + visibleItemCount > totalItemCount - 4))
                    JDHomeFragment.this.mHomeProductHeadView.tryShowNextPage();
                return;

            }
        });//aj(this));
        this.mHomeFooterView = new HomeFooterView(this.thisActivity);
        this.mHomeFooterView.setRetryListener(new HomeFooterView.RetryListener(){////ak(this));
            @Override
            public void refreshing() {
                JDHomeFragment.this.mPullToRefreshListView.setRefreshing();
            }

            @Override
            public void tryShowNextPage() {
                if (JDHomeFragment.this.mHomeProductHeadView != null)
                    JDHomeFragment.this.mHomeProductHeadView.tryShowNextPage();
            }
        });

        this.mSnapToTop = this.view.findViewById(R.id.snap_to_top);//2131167835
        this.mSnapToTop.setOnClickListener(new View.OnClickListener(){//al(this));
            @Override
            public void onClick(View v) {
                //JDHomeFragment.g(this.a);
                FloorFigureViewCtrl floorFigureViewCtrl = FloorFigureViewCtrl.getInstance();
                floorFigureViewCtrl.c();
                if(JDHomeFragment.this.mRefreshListView!=null){
                    JDHomeFragment.this.mRefreshListView.setSelection(0);
                }
                JDHomeFragment.this.a(0);
                floorFigureViewCtrl.d();
                JDMtaUtils.onClick(JDHomeFragment.this.thisActivity.getBaseContext(), "Home_ReturntoTop", getClass().getName());
            }
        });
        this.mHomeTitle = ((HomeTitle)this.view.findViewById(R.id.home_common_title));//2131172360
        this.mHomeTitle.bindFragment(this);
        this.mDragImageView = ((DragImageView)this.view.findViewById(R.id.home_ad));//2131172361
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(DPIUtil.getWidth() * 90 / 720, DPIUtil.getWidth() * 90 / 720);
        params.setMargins(0, this.l - DPIUtil.dip2px(50.0F), 0, 0);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        this.mDragImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mDragImageView.setLayoutParams(params);
        this.mDragImageView.setClickable(true);
        c();
        return this.view;
    }

    public void onDestroy()
    {
        CombineSetting.getInstance().a("indexManager_content");
        super.onDestroy();
        com.jingdong.app.mall.home.floor.b.a.b();
        if (this.m == null)
            return;
        synchronized (this.i)
        {
            Iterator localIterator = this.m.entrySet().iterator();
            while (localIterator.hasNext())
            {
                Object localObject2 = ((Map.Entry)localIterator.next()).getValue();
                if ((localObject2 == null) || (!(localObject2 instanceof MallBaseFloor)))
                    continue;
                ((MallBaseFloor)localObject2).j();
            }
        }
        this.i = Boolean.valueOf(true);
        monitorexit;
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        if (Log.D)
            Log.d(this.k, "keyCode -->> " + paramInt);
        if (paramInt == 4)
        {
            com.jingdong.common.utils.CommonUtil.setHomeActivityStoppedPeriod(System.currentTimeMillis());
            paramKeyEvent = MyApplication.getInstance().getMainFrameActivity();
            if ((paramKeyEvent != null) && (!paramKeyEvent.removeGuideView()))
            {
                MyApplication.exitControl();
                return true;
            }
        }
        return false;
    }

    public void onPause()
    {
        EventBus.getDefault().post(new com.jingdong.app.mall.home.floor.a.a.b("home_pause"));
        super.onPause();
        com.jingdong.app.mall.home.floor.c.a.a().b();
        if (this.mHomeTitle != null)
        {
            this.mHomeTitle.onPause();
            this.mHomeTitle.setMessageFlag(true);
        }
        if (this.mHttpGroupWithNPS != null)
            this.mHttpGroupWithNPS.onPause();
        if (this.mPullToRefreshListView != null)
            this.mPullToRefreshListView.onRefreshComplete();
        com.jingdong.app.mall.home.floor.b.a.a().c();
        au.b();
    }

    public void onResume()
    {
        while (true)
        {
            int i1;
            synchronized (this.i)
            {
                if ((this.m == null) || (!this.i.booleanValue()))
                {
                    ??? = EventBus.getDefault();
                    int i2 = f();
                    if (this.mRefreshListHeader != null)
                        break label359;
                    i1 = 0;
                    ((EventBus)???).post(new com.jingdong.app.mall.home.floor.a.a.b("home_resume", i2, i1));
                    super.onResume();
                    com.jingdong.app.mall.home.floor.c.a.a().c();
                    if (!Log.D)
                        continue;
                    Log.d(this.k, "HomeActivity onResume() -->> ");
                    l.a();
                }
            }
            try
            {
                j.a();
                j.c(0);
                if (this.mHttpGroupWithNPS != null)
                    this.mHttpGroupWithNPS.onResume();
                if (this.mHomeProductAdapter != null)
                    this.mHomeProductAdapter.notifyDataSetChanged();
                l1 = System.currentTimeMillis();
                l2 = com.jingdong.common.utils.CommonUtil.getHomeActivityStoppedPeriod();
                l3 = com.jingdong.common.utils.CommonUtil.getLongFromPreference("indexOfAll", 600000L);
                if (!this.x.equals(LoginUserBase.getLoginUserName()))
                {
                    a(true);
                    this.x = LoginUserBase.getLoginUserName();
                    post(new ac(this));
                    if (this.thisActivity.getRequestedOrientation() != 1)
                        this.thisActivity.setRequestedOrientation(1);
                    JDMtaUtils.sendPagePv(this.thisActivity, this, getPageParam(), this.page_id, this.shop_id);
                    if (this.mHomeTitle != null)
                        this.mHomeTitle.onResume();
                    if ((this.mDragImageView != null) && (this.a != null))
                    {
                        this.mDragImageView.setVisibility(View.VISIBLE);
                        if (this.m.isEmpty())
                            this.mHomePageObserver.a();
                    }
                    au.a();
                    return;
                    Iterator localIterator = this.m.entrySet().iterator();
                    while (localIterator.hasNext())
                    {
                        Object localObject3 = ((Map.Entry)localIterator.next()).getValue();
                        if ((localObject3 == null) || (!(localObject3 instanceof MallBaseFloor)))
                            continue;
                        ((MallBaseFloor)localObject3).k();
                        continue;
                        localObject2 = finally;
                        monitorexit;
                        throw localObject2;
                    }
                    this.i = Boolean.valueOf(false);
                    monitorexit;
                    continue;
                    label359: i1 = this.mRefreshListHeader.getHeight();
                }
            }
            catch (Exception localException)
            {
                while (true)
                {
                    long l1;
                    long l2;
                    long l3;
                    if (!Log.D)
                        continue;
                    localException.printStackTrace();
                    continue;
                    if (l1 - l2 - l3 <= 0L)
                        continue;
                    a(false);
                }
            }
        }
    }

    public void onStop()
    {
        super.onStop();
    }
}
