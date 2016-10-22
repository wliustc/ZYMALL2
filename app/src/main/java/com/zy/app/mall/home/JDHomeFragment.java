package com.zy.app.mall.home;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jd.framework.json.JDJSON;
import com.jingdong.app.mall.MainFrameActivity;
import com.jingdong.app.mall.MyApplication;
import com.jingdong.app.mall.basic.ApplicationManager;
import com.jingdong.app.mall.home.HomePageObserver;
import com.jingdong.app.mall.home.floor.view.view.HomeFooterView;
import com.jingdong.app.mall.home.floor.view.view.HomeProductHeadView;
import com.jingdong.app.mall.navigationbar.NavigationOptHelper;
import com.jingdong.app.mall.utils.LoginUser;
import com.jingdong.common.BaseActivity;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.login.LoginUserBase;
import com.jingdong.common.utils.JSONObjectProxy;
import com.jingdong.common.utils.ToastUtils;
import com.jingdong.common.utils.b.CombineSetting;
import com.zy.app.mall.R;
import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.a.b.MallFloorTypeUtil;
import com.zy.app.mall.home.floor.b.FloorFigureViewCtrl;

import com.zy.app.mall.home.floor.c.FloorMaiDianCtrl;
import com.zy.app.mall.home.floor.model.entity.HomeRecommendTwoEntity;
import com.zy.app.mall.home.floor.view.adapter.HomeProductAdapter;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.app.mall.home.floor.view.view.DragFloatView;
import com.zy.app.mall.home.floor.view.view.DragImageView;
import com.zy.app.mall.home.floor.view.view.HomeTitle;

import com.zy.app.mall.navigationbar.TabFragment;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.entity.HomeLayerParamEntity;
import com.zy.common.frame.IDestroyListener;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;
import com.zy.common.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 2016/5/4.
 */
public class JDHomeFragment extends TabFragment
        implements LoginUserBase._D {
    public static String b = null;
    public static boolean c = true;
    private static JDHomeFragment instance;
    private DragFloatView a;
    protected PullToRefreshListView mPullToRefreshListView;//d;
    protected LinearLayout mRefreshListHeader;//e;
    protected View view = null;   //f
    protected HomePageObserver._Z g;
    protected HomePageObserver mHomePageObserver;//h;
    protected Boolean isDestroy = Boolean.valueOf(false);//i
    private final static String TAG = JDHomeFragment.class.getSimpleName();//k
    private int l = (int) (DPIUtil.getHeight() * 0.618D);
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

    public static JDHomeFragment getInstance() {
        if (instance == null)
            synchronized (JDHomeFragment.class) {
                if (instance == null)
                    instance = new JDHomeFragment();
            }
        return instance;
    }

    private void a(int paramInt) {
        if (this.mHomeTitle != null)
            this.mHomeTitle.changeSearchBarColorVarScrolling(paramInt);
        if (this.mSnapToTop != null) {
            if (paramInt < DPIUtil.getHeight()) {//if-ge p1, v0, :cond_3
                if (this.mSnapToTop.getVisibility() == View.VISIBLE)
                    post(new Runnable() {//am(this)
                        @Override
                        public void run() {
                            JDHomeFragment.this.mSnapToTop.setVisibility(View.GONE);
                        }
                    });
            } else if (this.mSnapToTop.getVisibility() == View.GONE)
                post(new Runnable() {//an(this)
                    @Override
                    public void run() {
                        JDHomeFragment.this.mSnapToTop.setVisibility(View.VISIBLE);
                    }
                });
        }
        return;

    }


    private synchronized void a(List<HomeFloorNewModel> paramArrayList) {
        int i1;
        HomeFloorNewModel localHomeFloorNewModel;
        String str = "";
        //MallBaseFloor localMallBaseFloor = null;

        this.mRefreshListHeader.removeAllViews();
        this.mDragImageView.setVisibility(View.GONE);
        this.a = null;

        //:goto_0
        for (i1 = 0; i1 < paramArrayList.size(); i1++) {//if-ge v4, v1, :cond_8
            localHomeFloorNewModel = paramArrayList.get(i1);//v1
            if (localHomeFloorNewModel == null)
                continue;
            /*str = Md5Encrypt.md5(localHomeFloorNewModel.getType() + localHomeFloorNewModel.getFloorId());*/
            str = localHomeFloorNewModel.getType() + "*" + localHomeFloorNewModel.getFloorId() + "*" + localHomeFloorNewModel.getShowName();
            View view = this.m.get(str);
            if (view == null) {//if-nez v2, :cond_9
                int floorType = MallFloorTypeUtil.getFloorTypeByFloorModel(localHomeFloorNewModel);
                view = MallFloorCommonUtil.getMallFloorLayout(this.thisActivity, floorType);//v3
                if (floorType == MallFloorTypeUtil.BANNER/*banner*/) {//if-ne v2, v6, :cond_0
                    if (view == null)//if-nez v3, :cond_3
                        this.mRefreshListHeader.setPadding(this.mRefreshListHeader.getPaddingLeft()
                                , this.mHomeTitle.getBarHeight()
                                , this.mRefreshListHeader.getPaddingRight()
                                , this.mRefreshListHeader.getPaddingBottom());
                    else//:cond_3
                        this.n = view;
                }//:cond_0 :goto_1
                if (view == null) {//if-nez v3, :cond_1
                    if (floorType == MallFloorTypeUtil.RECOMMEND/*recommend*/) {//if-ne v2, v6, :cond_4
                        view = new HomeProductHeadView(this.thisActivity.getBaseContext());
                        this.mHomeProductHeadView = ((HomeProductHeadView) view);
                        this.mHomeProductHeadView.setOnDataGetListener(new HomeProductHeadView.OnDataGetListener() {//ab(this)
                            @Override
                            public boolean a(ArrayList<?> paramArrayList, int paramInt) {
                                boolean bool = false;
                                if ((JDHomeFragment.this.mHomeProductAdapter != null)
                                        && (paramArrayList != null)
                                        && (JDHomeFragment.this.mHomeProductHeadView != null)
                                        && (JDHomeFragment.this.mHomeProductHeadView.getVisibility() == View.VISIBLE)) {
                                    HomeProductAdapter localHomeProductAdapter = JDHomeFragment.this.mHomeProductAdapter;
                                    if (paramInt == 1)
                                        bool = true;
                                    localHomeProductAdapter.a((List<HomeRecommendTwoEntity>) paramArrayList, bool);
                                    JDHomeFragment.this.mHomeProductAdapter.notifyDataSetChanged();
                                    return true;
                                }
                                return false;
                            }
                        });
                    }
                    else if (floorType == MallFloorTypeUtil.FLOAT/*float*/) {//if-ne v2, v6, :cond_1
                        if (this.mDragImageView != null) {
                            this.a = DragFloatView.getInstance();
                            this.a.a(this, localHomeFloorNewModel, this.mDragImageView);
                        }
                    }
                }
            }else {//:cond_9
                //localMallBaseFloor = view;
                //move-object v3, v2    v2 to v3
                //goto :goto_2
            }
            //:cond_1 :goto_2
            if (view != null) {//if-nez v3, :cond_5
                if (((View) view).getParent() == null)  //if-nez v2, :cond_6
                    this.mRefreshListHeader.addView((View) view);
                if ((view instanceof MallBaseFloor))//if-eqz v2, :cond_7
                    ((MallBaseFloor) view).a(this, localHomeFloorNewModel, null, null);
                else if (view instanceof HomeProductHeadView)//if-eqz v2, :cond_2
                    ((HomeProductHeadView) view).init(this, localHomeFloorNewModel, this.mHomeFooterView);
                else
                    continue;
                //:goto_4
                this.m.put(str, view);
                //goto :goto_3
            }
            //:cond_2
            //:goto_3
        }
        //:cond_8
    }

    private void a(boolean paramBoolean) {
        int i1 = 1;
        if (this.mHomeTitle != null)
            this.mHomeTitle.setMessageFlag(true);
        if (this.w == null)
            this.w = new Runnable() {//ae(this)
                @Override
                public void run() {
                    JDHomeFragment.this.c();
                }
            };
        post(this.w);
        BaseActivity localBaseActivity = this.thisActivity;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramBoolean)
            i1 = 0;
        JDMtaUtils.sendCommonData(localBaseActivity, "Home_Refresh", localStringBuilder.append(i1).toString(), "", this, "", "", "", Constants.b);
        if (paramBoolean)
            d();
    }

    //
    private int f() {
        int i1 = 0;
        int i2;
        if ((this.mRefreshListView != null) && (this.mRefreshListView.getAdapter() != null) && (this.mRefreshListHeader != null) && (this.mRefreshListHeader.getChildCount() != 0) && (this.mRefreshListHeader.getHeight() != 0)) {
            i2 = this.mRefreshListView.getFirstVisiblePosition();
            if (i2 != 0) {
                if (i2 == 1) {
                    View localView = this.mRefreshListView.getChildAt(0);
                    if (localView != null) {
                        i1 = localView.getTop();
                    }
                    return -i1;
                } else
                    return this.mRefreshListHeader.getHeight();
            }
        }
        return 0;
    }

    public final void a(int paramInt1, int paramInt2) {
        if (Log.D)
            Log.d("navigation-click", TAG + "   old-->" + paramInt1 + " now-->" + paramInt2);
        if ((paramInt1 == paramInt2) && (paramInt2 == 0) && (this.v == 0)) {
            if (!this.mPullToRefreshListView.isRefreshing()) {
                a(0);
                if (this.mRefreshListView != null)
                    this.mRefreshListView.setSelection(0);
                this.mPullToRefreshListView.setRefreshing();
            }
            JDMtaUtils.onClickWithPageId(this.thisActivity.getBaseContext(), "NavigationBar_Home", getClass().getName(), "NavigationBar_Main");
        }
    }

    public final int b() {
        if (this.n != null)
            return this.n.getHeight();
        return 0;
    }

    public final void c() {
        if (!c)
            return;
        if (this.mHomeTitle != null)
            this.mHomeTitle.requestRedPoint();
        if (this.g == null)
        {
            this.g = new HomePageObserver._Z() {//ao(this)
                @Override
                public void a() {
                    JDHomeFragment.b = null;
                    JDHomeFragment.this.post(new Runnable() {//as(this)
                        @Override
                        public void run() {
                            int i;
                            if (JDHomeFragment.this.mHomeProductAdapter == null)
                                i = 1;
                            else
                                i = 0;
                            if (i != 0) {
                                JDHomeFragment.this.mHomeProductAdapter = new HomeProductAdapter(null, JDHomeFragment.this, "", "", JDHomeFragment.this.mHomeFooterView);
                                JDHomeFragment.this.mRefreshListView.setAdapter(JDHomeFragment.this.mHomeProductAdapter);
                            }
                            if ((JDHomeFragment.this.mRefreshListHeader.getChildCount() > 1) && (NetUtils.isNetworkAvailable())) {
                                ToastUtils.showToast(JDHomeFragment.this.thisActivity, JDHomeFragment.this.getString(R.string.network_exception_tip));//2131232721
                            } else if (JDHomeFragment.this.mRefreshListHeader.getChildCount() == 0) {
                                JDHomeFragment.this.mHomeFooterView.setNoDataLayoutHeight(JDHomeFragment.this.mPullToRefreshListView.getHeight());
                                JDHomeFragment.this.mHomeFooterView.setFooterState(3);
                                if (i == 0) {
                                    HomeTitle localHomeTitle = JDHomeFragment.this.mHomeTitle;
                                    boolean bool = true;
                                    if ((JDHomeFragment.this.n == null) || (JDHomeFragment.this.n.getVisibility() != View.VISIBLE))
                                        bool = false;
                                    localHomeTitle.initSearchBarColor(bool);
                                }

                            }
                            JDHomeFragment.this.mPullToRefreshListView.onRefreshComplete();
                            return;
                        }
                    });
                }

                @Override
                public void a(JSONObjectProxy jsonObject) {
                    JSONArrayProxy floorList = null;
                    JSONObjectProxy localObject = null;
                    try {
                        floorList = jsonObject.getJSONArray("floorList");
                        long NaviDataVersion = 0;
                        long naviVer = jsonObject.optLong("naviVer");
                        NavigationOptHelper navigationOptHelper = NavigationOptHelper.getInstance();
                        try {
                            NaviDataVersion = com.jingdong.app.mall.utils.CommonUtil.sharedPreferences.getLong("dataVersion_Navigation", 0L);
                        } catch (Exception localException) {
                            if (Log.D)
                                localException.printStackTrace();
                            NaviDataVersion = 0L;
                        }

                        if (naviVer > NaviDataVersion)
                            navigationOptHelper.e();/* 更新导航栏图标 */
                        localObject = jsonObject.getJSONObjectOrNull("displayHongBao");
                        if ((localObject != null) && (!TextUtils.isEmpty(localObject.toString())))
                            ///*JDHomeFragment.a(JDHomeFragment.this, (HomeLayerParamEntity) JDJSON.parseObject(((JSONObjectProxy)localObject).toString(), HomeLayerParamEntity.class));
                            JDHomeFragment.this.y = (HomeLayerParamEntity) JDJSON.parseObject((localObject).toString(), HomeLayerParamEntity.class);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (floorList == null) {//if-nez v5, :cond_4
                        JDHomeFragment.this.post(new Runnable() {//ap(this)
                            @Override
                            public void run() {
                                JDHomeFragment.this.g.a();//error
                            }
                        });
                    } else {
                        final List<HomeFloorNewModel> homeFloorList = HomeFloorNewModel.toList(floorList);
                        if ((homeFloorList == null) || (((ArrayList) homeFloorList).size() == 0)) {
                            JDHomeFragment.this.post(new Runnable() {//aq(this)
                                @Override
                                public void run() {
                                    JDHomeFragment.this.g.a();//error
                                }
                            });
                        } else {
                            JDHomeFragment.this.post(new Runnable() {//ar(this, (ArrayList) homeFloorList)
                                @Override
                                public void run() {
                                    JDHomeFragment.this.mPullToRefreshListView.onRefreshComplete();
                                    JDHomeFragment.this.a(homeFloorList);
                                    int i;
                                    if (JDHomeFragment.this.mHomeTitle != null) {//if-eqz v0, :cond_0
                                        if ((JDHomeFragment.this.n != null) && (JDHomeFragment.this.n.getVisibility() == View.VISIBLE)) {//if-eqz v0, :cond_4
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }//:goto_0
                                        int j = JDHomeFragment.this.f();
                                        if (i != 0) {//if-eqz v0, :cond_6
                                            if (j > 0) {//if-lez v3, :cond_5
                                                JDHomeFragment.this.mHomeTitle.changeSearchBarColorVarScrolling(j);
                                            } else
                                                JDHomeFragment.this.mHomeTitle.initSearchBarColor(true);
                                        } else
                                            JDHomeFragment.this.mHomeTitle.initSearchBarColor(false);
                                    }//:cond_0
                                    //:goto_1

                                    if (JDHomeFragment.this.mHomeProductAdapter == null) {
                                        JDHomeFragment.this.mHomeProductAdapter = new HomeProductAdapter(null, JDHomeFragment.this, "", "", JDHomeFragment.this.mHomeFooterView);
                                        JDHomeFragment.this.mRefreshListView.setAdapter(JDHomeFragment.this.mHomeProductAdapter);
                                    }
                                    if ((JDHomeFragment.this.mHomeProductHeadView == null) || (JDHomeFragment.this.mHomeProductHeadView.getVisibility() != View.VISIBLE))
                                        JDHomeFragment.this.mHomeFooterView.setFooterState(4);
                                    JdLayerUtil.a(JDHomeFragment.this.thisActivity, JDHomeFragment.this.y);
                                    return;

                                }
                            });
                            if ((jsonObject == null) || (TextUtils.isEmpty(JDHomeFragment.b)) || (homeFloorList == null) || (homeFloorList.isEmpty()))
                                JDHomeFragment.this.mHomePageObserver.b();
                        }
                    }
                }

                /*@Override
                public void a(HttpGroup.HttpResponse paramHttpResponse) {
                    com.zy.common.utils.CommonUtil.setHomeActivityStoppedPeriod(System.currentTimeMillis());
                    Object localObject;
                    long l2;
                    NavigationOptHelper localj;
                    if (paramHttpResponse.getJSONObject() != null) {//if-eqz v0, :cond_2
                        localObject = paramHttpResponse.getJSONObject();
                        JSONObjectProxy floorList = ((JSONObjectProxy) localObject).getJSONArrayOrNull("floorList");
                        l2 = ((JSONObjectProxy) localObject).optLong("naviVer");
                        localj = NavigationOptHelper.getInstance();
                        try {
                            l1 = com.jingdong.app.mall.utils.CommonUtil.sharedPreferences.getLong("dataVersion_Navigation", 0L);
                        } catch (Exception localException) {
                            if (Log.D)
                                localException.printStackTrace();
                            long l1 = 0L;
                        }

                        if (l2 > l1)
                            localj.e();
                        localObject = ((JSONObjectProxy) localObject).getJSONObjectOrNull("displayHongBao");
                        if ((localObject != null) && (!TextUtils.isEmpty(((JSONObjectProxy) localObject).toString())))
                            ///*JDHomeFragment.a(JDHomeFragment.this, (HomeLayerParamEntity) JDJSON.parseObject(((JSONObjectProxy)localObject).toString(), HomeLayerParamEntity.class));
                            JDHomeFragment.this.y = (HomeLayerParamEntity) JDJSON.parseObject(((JSONObjectProxy) localObject).toString(), HomeLayerParamEntity.class);
                        if (floorList == null) {//if-nez v5, :cond_4
                            JDHomeFragment.this.post(new ap(this));
                        } else {
                            ArrayList homeFloorList = HomeFloorNewModel.toList(floorList);
                            if ((homeFloorList == null) || (((ArrayList) homeFloorList).size() == 0)) {
                                JDHomeFragment.this.post(new aq(this));
                            } else {
                                JDHomeFragment.this.post(new ar(this, (ArrayList) homeFloorList));
                                if ((paramHttpResponse == null) || (TextUtils.isEmpty(JDHomeFragment.b)) || (localObject == null) || (((ArrayList) localObject).isEmpty()))
                                    JDHomeFragment.this.h.b();
                            }
                        }
                    }
                    //:cond_2
                    //:goto_1
                    return;
                }*/

                @Override
                public void b() {
                    JDHomeFragment.this.post(new Runnable(){//at(this)
                        @Override
                        public void run() {
                            JDHomeFragment.this.mPullToRefreshListView.onRefreshComplete();
                        }
                    });
                }

                @Override
                public String getJsonString()  {
                    return JDHomeJsonString.getInstance().getNaviVerJson();
                }
            };
            this.mHomePageObserver.a(this.g);
        }
        this.mHomePageObserver.a();
    }

    protected final void d() {
        if ((this.mHomeProductHeadView != null) && (this.mHomeProductAdapter != null))
            post(new Runnable(){//ad(this)
                @Override
                public void run() {
                    JDHomeFragment.this.mHomeProductHeadView.reSet();
                    JDHomeFragment.this.mHomeProductAdapter.a(null, true);
                    JDHomeFragment.this.mHomeProductAdapter.notifyDataSetChanged();
                }
            });
    }

    //
    public final void e() {
        if (Log.D)
            Log.d("Temp", "loginCompletedNotify() -->> ");
        post(new Runnable() {//af(this)
            @Override
            public void run() {
                ((MainFrameActivity) JDHomeFragment.this.thisActivity).c();
            }
        });
    }

    @Override
    public void onCreate(Bundle paramBundle) {
        if (Log.D)
            Log.d(TAG, "onCreate -->> ");
        setPageId("Home_Main");
        this.needRemoveviewOnStop = false;
        if (this.mHomePageObserver == null)
            this.mHomePageObserver = HomePageObserver.getInstance(this.thisActivity);
        int i1 = this.thisActivity.getIntent().getIntExtra("moduleId", -1);
        if ((Configuration.getBooleanProperty("beforeInitTip").booleanValue()) && (!com.jingdong.app.mall.utils.CommonUtil.getJdSharedPreferences().getBoolean("hasInitTip", false)))
            c = false;
        //this.mHttpGroupWithNPS = this.mHomePageObserver.c();
        try {
            LoginUserBase.init();
            LoginUser.getInstance().homeAutoLogin(this.thisActivity, this, i1);
            if (this.x == null)
                this.x = LoginUserBase.getLoginUserName();
            super.onCreate(paramBundle);
            return;
        } catch (Throwable e) {
            if (Log.E)
                e.printStackTrace();

        }
    }

    @Override
    public View onCreateViews(LayoutInflater paramLayoutInflater, Bundle paramBundle) {
        this.view = ImageUtil.inflate(R.layout.pull_refresh_scroll_new, null);       //2130904224
        this.thisActivity.addDestroyListener(new IDestroyListener() {//aa(this));
            @Override
            public void onDestroy() {
                JDHomeFragment.this.d();
            }
        });
        this.mPullToRefreshListView = ((PullToRefreshListView) this.view.findViewById(R.id.pull_refresh_scroll));//2131172359
        ((ListView) this.mPullToRefreshListView.getRefreshableView()).setOverScrollMode(2);
        this.mPullToRefreshListView.setBackgroundResource(R.color.home_content_bg);//2131100105
        this.mPullToRefreshListView.setFadingEdgeLength(0);
        this.mPullToRefreshListView.setVerticalScrollBarEnabled(false);
        ((ListView) this.mPullToRefreshListView.getRefreshableView()).setCacheColorHint(0);
        ((ListView) this.mPullToRefreshListView.getRefreshableView()).setScrollingCacheEnabled(false);
        ((ListView) this.mPullToRefreshListView.getRefreshableView()).setDividerHeight(0);
        ((ListView) this.mPullToRefreshListView.getRefreshableView()).setSelector(R.color.transparent);//2131099688
        this.mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {//ag(this));
            @Override
            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                JDHomeFragment.this.a(true);
                JDHomeFragment.this.post(new Runnable() {//ah(this)
                    @Override
                    public void run() {
                        JDHomeFragment.this.mPullToRefreshListView.onRefreshComplete();
                    }
                }, 10000);
            }
        });
        this.mRefreshListView = ((ListView) this.mPullToRefreshListView.getRefreshableView());
        this.mRefreshListHeader = new LinearLayout(this.thisActivity);
        this.mRefreshListHeader.setOrientation(LinearLayout.VERTICAL);
        this.mRefreshListView.addHeaderView(this.mRefreshListHeader, null, false);
        this.mPullToRefreshListView.setOnPullEventListener(new PullToRefreshBase.OnPullEventListener<ListView>() {//ai(this)
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
        this.mRefreshListView.setOnScrollListener(new AbsListView.OnScrollListener() {//aj(this));
            int a;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                JDHomeFragment.this.v = scrollState;
                if (scrollState == 0) {
                    EventBus bus = EventBus.getDefault();
                    int i = JDHomeFragment.this.f();
                    int headerHeight = 0;
                    if (JDHomeFragment.this.mRefreshListHeader != null)
                        headerHeight = JDHomeFragment.this.mRefreshListHeader.getHeight();

                    bus.post(new MallFloorEvent("home_scroll_stop", i, headerHeight));
                    JDHomeFragment.this.a(i);//b(this.b, JDHomeFragment.b(this.b));


                } else {
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
                    if ((bottom > 0)
                            && (JDHomeFragment.this.mRefreshListView.getHeight() > 0)
                            && (bottom - JDHomeFragment.this.mRefreshListView.getHeight() < 400)
                            && (-top > this.a)
                            && (JDHomeFragment.this.mHomeProductHeadView != null)
                            && (!JDHomeFragment.this.mHomeProductHeadView.hasData())
                            && (JDHomeFragment.this.mHomeProductHeadView.getVisibility() == View.VISIBLE))
                        JDHomeFragment.this.mHomeProductHeadView.onBottomPullUp();
                    this.a = (-top);
                } else if ((JDHomeFragment.this.mHomeFooterView != null)
                        && (JDHomeFragment.this.mHomeFooterView.getFooterState() != 1)
                        && (JDHomeFragment.this.mHomeFooterView.getFooterState() != 2)
                        && (JDHomeFragment.this.mHomeProductHeadView != null)
                        && (JDHomeFragment.this.mHomeProductHeadView.getVisibility() == View.VISIBLE)
                        && (JDHomeFragment.this.mHomeProductHeadView.hasData())
                        && (firstVisibleItem + visibleItemCount > totalItemCount - 4))
                    JDHomeFragment.this.mHomeProductHeadView.tryShowNextPage();
                return;

            }
        });
        this.mHomeFooterView = new HomeFooterView(this.thisActivity);
        this.mHomeFooterView.setRetryListener(new HomeFooterView.RetryListener() {////ak(this));
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
        this.mSnapToTop.setOnClickListener(new View.OnClickListener() {//al(this));
            @Override
            public void onClick(View v) {
                /*JDHomeFragment.g(this.a);*/
                FloorFigureViewCtrl floorFigureViewCtrl = FloorFigureViewCtrl.getInstance();
                floorFigureViewCtrl.c();
                if (JDHomeFragment.this.mRefreshListView != null) {
                    JDHomeFragment.this.mRefreshListView.setSelection(0);
                }
                JDHomeFragment.this.a(0);
                floorFigureViewCtrl.d();
                JDMtaUtils.onClick(JDHomeFragment.this.thisActivity.getBaseContext(), "Classification_CoCategory_Tab", "Home_ReturntoTop", getClass().getName());
            }
        });
        this.mHomeTitle = ((HomeTitle) this.view.findViewById(R.id.home_common_title));//2131172360
        this.mHomeTitle.bindFragment(this);
        this.mDragImageView = ((DragImageView) this.view.findViewById(R.id.home_ad));//2131172361
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(DPIUtil.getWidth() * 90 / 720, DPIUtil.getWidth() * 90 / 720);
        params.setMargins(0, this.l - DPIUtil.dip2px(50.0F), 0, 0);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        this.mDragImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mDragImageView.setLayoutParams(params);
        this.mDragImageView.setClickable(true);
        c();
        return this.view;
    }

    @Override
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (Log.D)
            Log.d(TAG, "keyCode -->> " + paramInt);
        if (paramInt == 4) {
            com.zy.common.utils.CommonUtil.setHomeActivityStoppedPeriod(System.currentTimeMillis());
            MainFrameActivity mainFrameActivity = MyApplication.getInstance().getMainFrameActivity();
            if ((mainFrameActivity != null) && (!mainFrameActivity.removeGuideView())) {
                MyApplication.exitControl();
                return true;
            }
        }
        return false;
    }

    @Override
    public void onResume() {
        int i1;
        synchronized (this.isDestroy) {
            if ((this.m != null) && (this.isDestroy.booleanValue())) {
                Iterator localIterator = this.m.entrySet().iterator();
                while (localIterator.hasNext()) {
                    Object localObject3 = ((Map.Entry) localIterator.next()).getValue();
                    if ((localObject3 == null) || (!(localObject3 instanceof MallBaseFloor)))
                        continue;
                    ((MallBaseFloor) localObject3).k();

                }
                this.isDestroy = Boolean.valueOf(false);
            }
        }
        //:cond_0
        // :goto_0
        EventBus eventBus = EventBus.getDefault();
        int i2 = f();
        i1 = 0;
        if (this.mRefreshListHeader != null)
            i1 = this.mRefreshListHeader.getHeight();

        eventBus.post(new MallFloorEvent("home_resume", i2, i1));
        super.onResume();
        FloorFigureViewCtrl.getInstance().c();
        if (Log.D)
            Log.d(TAG, "HomeActivity onResume() -->> ");
        ApplicationManager.a();


        try {
            NavigationOptHelper.getInstance();
            NavigationOptHelper.c(0);
        } catch (Exception localException) {
            if (Log.D)
                localException.printStackTrace();
        }
        //:cond_2
        //:goto_2
//            if (this.mHttpGroupWithNPS != null)
//                this.mHttpGroupWithNPS.onResume();
            if (this.mHomeProductAdapter != null)
                this.mHomeProductAdapter.notifyDataSetChanged();
        long l1 = System.currentTimeMillis();
        long l2 = com.zy.common.utils.CommonUtil.getHomeActivityStoppedPeriod();
        long l3 = com.zy.common.utils.CommonUtil.getLongFromPreference("indexOfAll", 600000L);
        if (!this.x.equals(LoginUserBase.getLoginUserName())) {//if-nez v0, :cond_d
            a(true);
            this.x = LoginUserBase.getLoginUserName();
            post(new Runnable() {//ac(this)
                @Override
                public void run() {
                        /*JDHomeFragment.g(this.a);*/
                    FloorFigureViewCtrl.getInstance().c();
                    if (JDHomeFragment.this.mRefreshListView != null)
                        JDHomeFragment.this.mRefreshListView.setSelection(0);
                    JDHomeFragment.this.a(0);
                    FloorFigureViewCtrl.getInstance().d();
                }
            });
        } else if (l1 - l2 - l3 > 0L)
            a(false);
        //:cond_5
        //:goto_3
        if (this.thisActivity.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            this.thisActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        JDMtaUtils.sendPagePv(this.thisActivity, this, getPageParam(), this.page_id, this.shop_id);
        if (this.mHomeTitle != null)
            this.mHomeTitle.onResume();
        if ((this.mDragImageView != null) && (this.a != null)) {
            this.mDragImageView.setVisibility(View.VISIBLE);
            if (this.m.isEmpty())
                this.mHomePageObserver.a();
        }
        JdLayerUtil.a();


        return;
    }

    @Override
    public void onPause() {
        EventBus.getDefault().post(new MallFloorEvent("home_pause"));
        super.onPause();
        FloorMaiDianCtrl.getInstance().b();
        if (this.mHomeTitle != null) {
            this.mHomeTitle.onPause();
            this.mHomeTitle.setMessageFlag(true);
        }
//        if (this.mHttpGroupWithNPS != null)
//            this.mHttpGroupWithNPS.onPause();
        if (this.mPullToRefreshListView != null)
            this.mPullToRefreshListView.onRefreshComplete();
        FloorFigureViewCtrl.getInstance().c();
        JdLayerUtil.b();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        CombineSetting.getInstance().a("indexManager_content");
        super.onDestroy();
        FloorFigureViewCtrl.b();
        if (this.m == null)
            return;
        synchronized (this.isDestroy) {
            Iterator localIterator = this.m.entrySet().iterator();
            while (localIterator.hasNext()) {
                Object localObject2 = ((Map.Entry) localIterator.next()).getValue();
                if ((localObject2 != null) && (localObject2 instanceof MallBaseFloor))
                    ((MallBaseFloor) localObject2).j();
            }
        }
        this.isDestroy = Boolean.valueOf(true);

    }

    public static class JDHomeTM extends JDTaskModule {
        private JDHomeFragment home;

        public JDHomeTM() {
            setNeedClearBackStack(true);
        }

        public synchronized void doInit() {

            HomePageObserver.a = true;
            //this.home = JDHomeFragment.getInstance();
            this.home = JDHomeFragment.getInstance();
            this.home.setMoveTaskBack(true);
            if (this.home.getArguments() == null) {
                getBundle().putInt("com.360buy:navigationFlag", 0);
                this.home.setArguments(getBundle());
            }
            return;

        }

        public void doShow() {
            replaceAndCommit(this.home, Integer.valueOf(0));
        }
    }
}
