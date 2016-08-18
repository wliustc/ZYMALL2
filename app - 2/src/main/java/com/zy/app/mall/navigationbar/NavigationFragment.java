package com.zy.app.mall.navigationbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zy.app.mall.MainFrameActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.basic.JDUntil;
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
    protected RadioGroup rgBottomMenu;
    private List<NavigationButton> navigationButtonList = new ArrayList();
    private Stack<Integer> d = new Stack();
    private View navigationBg;
    private RadioGroup.LayoutParams layoutParams;
    private boolean m = false;
    private boolean isNavigationButtonOver ;  //f
    private View.OnTouchListener onTouchListener = new View.OnTouchListener(){////e(this);
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
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
////                if (index == 2) //发现
////                    MainFrameActivity.b(localNavigationButton.f());
////                if (index == 3) //购物车
////                    MainFrameActivity.a(localNavigationButton.getStateController());
////                if (index == 4) //我的
////                    MainFrameActivity.a(localNavigationButton.f());
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
////        this.rgBottomMenu.setOnCheckedChangeListener(this.onCheckedChangeListener);
        ((NavigationButton) this.rgBottomMenu.findViewById(lastIndex)).setChecked(true);
        this.rgBottomMenu.check(lastIndex);
    }


}
