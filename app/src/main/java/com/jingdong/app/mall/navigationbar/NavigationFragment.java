package com.jingdong.app.mall.navigationbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jingdong.app.mall.MainFrameActivity;
import com.jingdong.app.mall.basic.JDUntil;
import com.jingdong.app.mall.navigationbar.NavigationOptHelper;
import com.jingdong.app.mall.navigationbar.UnifyRequestDataHolder;
import com.zy.app.mall.R;
import com.zy.app.mall.navigationbar.INavigationPage;
import com.zy.app.mall.navigationbar.NavigationButton;
import com.zy.app.mall.navigationbar.RedPointOpt;
import com.zy.app.mall.utils.frame.RadioStateDrawable;
import com.zy.cleanmvp.ui.BaseFragment;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Robin on 2016/4/18.
 */
public class NavigationFragment extends BaseFragment {
    public static boolean b = true;
    protected RadioGroup rgBottomMenu;  //a
    private List<NavigationButton> navigationButtonList = new ArrayList();  //c
    private Stack<Integer> d = new Stack();
    private int e = -1;
    private boolean f;
    private boolean g = false;
    private View navigationBg;  //h
    private RadioGroup.LayoutParams layoutParams;   //i
    private boolean j = true;
    private INavigationPage k;
    private boolean m = false;
    private boolean isNavigationButtonOver ;  //f
    private View.OnTouchListener onTouchListener/*n*/ = new View.OnTouchListener(){////e(this);
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if ((event.getAction() == 1) && (v.getId() == NavigationOptHelper.getInstance().b()))
            {
                NavigationFragment.this.k = ((MainFrameActivity)NavigationFragment.this.thisActivity).j();
                if (NavigationFragment.this.k != null)
                    NavigationFragment.this.k.a(NavigationOptHelper.getInstance().b(), v.getId());
            }
            return !NavigationFragment.b;
        }

    };

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener/*o*/ = new RadioGroup.OnCheckedChangeListener(){//f
        private boolean b;
        private int c = -1;
        private int d = -2;

        public final void a(int paramInt)
        {
            this.c = paramInt;
        }

        public final void a(boolean paramBoolean)
        {
            this.b = true;
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (NavigationFragment.this.j){
                if (checkedId < 0)
                    return;
                if (this.b) {
                    this.b = false;
                    return;
                }//:cond_2
                if ((this.c != checkedId) || !NavigationFragment.this.g){
                    NavigationFragment.this.g = false;
                    this.d = this.c;
                    this.c = checkedId;
                    NavigationOptHelper.getInstance().lastIndex = checkedId;
                    if (Log.D)
                    {
                        Log.d("JDNavigationFragment", "onCheckedChanged checkedId-->> " + checkedId);
                        Log.d("JDNavigationFragment", "onCheckedChanged mNow-->> " + this.c);
                    }
                    if (Log.D)
                        Log.d("JDNavigationFragment", "onCheckedChanged buttonActionList-->> " + NavigationFragment.this.navigationButtonList.size());
                    NavigationButton.ButtonAction buttonAction = ((NavigationButton)group.findViewById(checkedId)).getButtonAction();
                    RedPointOpt.getInstance().a(checkedId, true);
                    if (!buttonAction.isHighlight())
                        NavigationFragment.this.a(Integer.valueOf(this.d));
                    NavigationFragment.this.d.push(Integer.valueOf(this.d));
                    ((NavigationButton)group.findViewById(checkedId)).getButtonAction().a();
                    UnifyRequestDataHolder.getInstance().b();
                }
            }
            return;
        }
    };

    public static NavigationFragment a(int lastIndex)
    {
        NavigationFragment navigationFragment = new NavigationFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("lastIndex", lastIndex);
        navigationFragment.setArguments(bundle);
        return navigationFragment;
    }
    @Override
    public View onCreateViews(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.app_jd_navigation_xml, null);//2130903160
        if (JDUntil.hasSmartBar())
            inflate.setVisibility(View.GONE);
        this.rgBottomMenu = ((RadioGroup)inflate.findViewById(R.id.bottomMenu));    //2131165838
        this.navigationBg = inflate.findViewById(R.id.navigation_bg);  //2131165836
        return inflate;
    }

    @Override
    public boolean onKeyDown(int paramInt, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        NavigationOptHelper.b = true;
        if (getArguments() != null)
            NavigationOptHelper.getInstance().lastIndex = getArguments().getInt("lastIndex");
        if (paramBundle != null)
        {
            NavigationOptHelper.getInstance().lastIndex = 0;
            this.m = true;
        }
        this.needRemoveviewOnStop = false;
        init();
    }

    //c()
    private void init() {

        if (Log.D)
            Log.d("JDNavigationFragment", "------navigationInit--------");
        this.navigationButtonList = NavigationOptHelper.getInstance().getNavigationButtonList(getActivity(), this.m, this.navigationBg);
        int lastIndex = NavigationOptHelper.getInstance().lastIndex;
        this.rgBottomMenu.removeAllViews();
        if ((this.navigationButtonList != null) && (this.navigationButtonList.size() > 0))
            this.navigationButtonList.size();
        int capacity;
        int naviButtonWidth;
        int bgWidth;
        try {
            capacity = DPIUtil.getWidth() / DPIUtil.dip2px(64.0F);
        } catch (Exception localObject) {
            capacity = 5;
        }
        bgWidth = DPIUtil.getWidth();
        if (this.navigationButtonList.size() <= capacity) {
            //if-gt v1, v0, :cond_5
            naviButtonWidth = bgWidth / this.navigationButtonList.size();
        } else {
            naviButtonWidth = bgWidth / capacity;
            this.isNavigationButtonOver = true;
        }
        //:goto_1
        RadioStateDrawable.naviButtonWidth = naviButtonWidth;
        RadioStateDrawable.bgWidth = bgWidth;
        synchronized (this) {
            for (int i2 = 0; i2 < this.navigationButtonList.size(); i2++) {
                NavigationButton button = (NavigationButton) this.navigationButtonList.get(i2);
                int index = button.getIndex();
                if (index == 2) //发现
                    MainFrameActivity.b(button.f());
                if (index == 3) //购物车
                    MainFrameActivity.a(button.getStateController());
                if (index == 4) //我的
                   MainFrameActivity.a(button.f());
                button.setId(index);
                button.setPadding(0, 0, 0, 0);
                button.setGravity(Gravity.CENTER);
                button.setOnTouchListener(this.onTouchListener);
                if (button.a)
                    this.layoutParams = new RadioGroup.LayoutParams(naviButtonWidth, getResources().getDimensionPixelSize(R.dimen.main_navigation_bottom_big_icon_height));//2131035864
                else {
                    this.layoutParams = new RadioGroup.LayoutParams(naviButtonWidth, getResources().getDimensionPixelSize(R.dimen.main_navigation_bottom_icon_height));   //2131035866
                    this.layoutParams.gravity = Gravity.BOTTOM;   //80
                }
                // :goto_3
                button.setLayoutParams(this.layoutParams);
                TextView text = new TextView(this.getContext());
                text.setText(""+i2);
                text.setTextColor(Color.RED);
                text.setPadding(0, 0, 0, 0);
                text.setGravity(Gravity.CENTER);
                text.setLayoutParams(this.layoutParams);
                this.rgBottomMenu.addView(button, i2);
            }
        }
        this.rgBottomMenu.setOnCheckedChangeListener(this.onCheckedChangeListener);
        ((NavigationButton) this.rgBottomMenu.findViewById(lastIndex)).setChecked(true);
        this.rgBottomMenu.check(lastIndex);
    }

    public final void a()
    {
        c();
        this.j = false;
        int i1 = j.a().a;
        b(-1);
        if ((i1 == 2) && (!TextUtils.isEmpty(((NavigationButton)this.c.get(i1)).b())))
        {
            this.j = true;
            this.g = true;
        }
        b(i1);
        this.j = true;
        s locals = s.a();
        if (!this.g);
        for (boolean bool = true; ; bool = false)
        {
            locals.a(i1, bool);
            return;
        }
    }

    public final void a(Integer paramInteger)
    {
        if (Log.D)
            Log.d("JDNavigationFragment", "radioId -->> " + paramInteger);
        j.a().a = paramInteger.intValue();
        if (this.a.getCheckedRadioButtonId() != paramInteger.intValue())
        {
            if (Log.D)
                Log.d("JDNavigationFragment", "bottomRadioGroup.getCheckedRadioButtonId() != radioId -->> " + this.a.getCheckedRadioButtonId());
            this.e = this.a.getCheckedRadioButtonId();
            this.o.a(true);
            this.o.a(paramInteger.intValue());
            this.a.check(paramInteger.intValue());
            if (Log.D)
                Log.d("JDNavigationFragment", "old -->> " + this.e);
        }
    }

    public final void b()
    {
        this.d.clear();
    }

    public final void b(int paramInt)
    {
        if (Log.D)
            Log.d("JDNavigationFragment", "setCurrentTab() index = " + paramInt);
        if (n.a());
        try
        {
            MainFrameActivity localMainFrameActivity = (MainFrameActivity)this.thisActivity;
            if (localMainFrameActivity != null)
                localMainFrameActivity.a(paramInt);
            this.a.check(paramInt);
            j.a().a = paramInt;
            return;
        }
        catch (Exception localException)
        {
            while (true)
                localException.printStackTrace();
        }
    }
}
