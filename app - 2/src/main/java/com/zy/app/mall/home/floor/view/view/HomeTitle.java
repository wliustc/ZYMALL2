package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zy.app.mall.R;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.personel.a.a.PersonalMessageManager;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;
import com.zy.common.BaseActivity;
import com.zy.common.entity.SourceEntity;
import com.zy.common.frame.JDHandler;
import com.zy.common.login.LoginUserBase;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/5/5.
 */
public class HomeTitle  extends LinearLayout implements PersonalMessageObserver {
    private static final int MSG_UPDATE_MESSAGE = 3;
    private static final int TYPE_SHOW_NONE = 2;
    private static final int TYPE_SHOW_NUMBER = 0;
    private static final int TYPE_SHOW_REDDOT = 1;
    private final String TAG = HomeTitle.class.getSimpleName();
    protected AutoCompleteTextView acEditView;
    private JDHomeFragment fragment;
    private SimpleDraweeView ivHomeMessageButton;
    private SimpleDraweeView ivHomeSearchButton;
    private SimpleDraweeView ivSearchIcon;
    private SimpleDraweeView ivVoiceSearchIcon;
    private LinearLayout llBarLayout;
    private JDHandler mHandler = new JDHandler(){//u(this)
        @Override
        public final void handleMessage(Message paramMessage)
        {
            Bundle bundle = null;
            switch (paramMessage.what)
            {
                case 3:
                    if ((HomeTitle.this.redDot != null) && (HomeTitle.this.messageNum != null) && (bundle = paramMessage.getData())!=null){
                        int i = bundle.getInt("style");
                        int j = bundle.getInt("num");
                        if (i == 1){//if-ne v1, v2, :cond_1
                            HomeTitle.this.redDot.setVisibility(View.VISIBLE);
                            HomeTitle.this.messageNum.setVisibility(View.GONE);
                            return;
                        }else if ((i == 0) || (j > 0)){
                            HomeTitle.this.redDot.setVisibility(View.GONE);
                            HomeTitle.this.messageNum.setVisibility(View.VISIBLE);
                            if (j > 99)
                            {
                                HomeTitle.this.messageNum.setText("99+");
                            }else if (j <= 9)
                            {
                                HomeTitle.this.messageNum.setText(j);
                            }else {
                                HomeTitle.this.messageNum.setText(j);
                            }
                        }else if(i == 2) {
                            HomeTitle.this.redDot.setVisibility(View.GONE);
                            HomeTitle.this.messageNum.setVisibility(View.GONE);
                        }
                    }
                    break;
            }
            return;
        }
    };
    public boolean mMessageFlag = false;
    private TextView messageNum;
    private ImageView redDot;
    private View searchLayout;
    private BaseActivity thisActivity;
    private int titleBarLayoutHeight = DPIUtil.dip2px(50.0F);
    private TextView tvHomeMessageButton;
    private TextView tvHomeSearchButton;
    private View vShadow;

    public HomeTitle(Context paramContext)
    {
        this(paramContext, null);
    }

    public HomeTitle(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        setOrientation(LinearLayout.VERTICAL);
        this.llBarLayout = new LinearLayout(paramContext);
        ImageUtil.inflate(R.layout.app_head_search_new, this.llBarLayout);    //2130903154
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, this.titleBarLayoutHeight);
        this.llBarLayout.setGravity(Gravity.CENTER_VERTICAL);
        addView(this.llBarLayout, layoutParams);
        this.thisActivity = ((BaseActivity)paramContext);
        initView();
        initShadow();
    }

    private void clearMessage()
    {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        Bundle localBundle = new Bundle();
        localBundle.putInt("style", 2);
        localBundle.putInt("num", 0);
        localMessage.setData(localBundle);
        this.mHandler.sendMessage(localMessage);
    }

    private void gotoSearch()
    {
        gotoSearch(null, null);
    }

    private void gotoSearch(String paramString1, String paramString2)
    {
        try
        {
            if ((VoiceSearchLayout.isUseJdCustomerVoiceService()) && ("type".equals(paramString1)) && ("voice".equals(paramString2)))
            {
                Intent intent = new Intent(this.thisActivity.getBaseContext(), VoiceSearchActivity.class);
                intent.putExtra("isFromHome", true);
                intent.putExtra("source", new SourceEntity("Home_VSearch", ""));
                this.thisActivity.startActivity(intent);
                JDMtaUtils.sendCommonData(this.thisActivity.getBaseContext(), "Home_VSearch", "", "onClick", this, JDHomeFragment.class.getSimpleName(), VoiceSearchActivity.class, "", Constants.b);
            }else {
                Intent intent = new Intent(this.thisActivity.getBaseContext(), SearchActivity.class);
                if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
                    intent.putExtra(paramString1, paramString2);
                intent.putExtra("isFromHome", true);
                this.thisActivity.startActivityForResult(intent, 272);
            }
        }
        catch (Exception e)
        {
            if (Log.E)
                e.printStackTrace();
        }
        return;
    }

    private void initSaoAsao()
    {
        findViewById(R.id.home_search_button).setOnClickListener(new View.OnClickListener(){//t(this)
            @Override
            public void onClick(View v) {
                if (HomeTitle.this.checkCameraHardware(HomeTitle.this.thisActivity.getApplicationContext()))
                    HomeTitle.this.thisActivity.startActivity(new Intent(HomeTitle.this.thisActivity.getBaseContext(), CaptureActivity.class));
                JDMtaUtils.sendCommonData(HomeTitle.this.thisActivity.getBaseContext(), "Home_Scan", "", "", HomeTitle.this.thisActivity.getBaseContext(), "", getClass(), "", Constants.b);
            }
        });//2131165808
    }

    private void initSearchComponent()
    {
        this.ivHomeSearchButton = ((SimpleDraweeView)findViewById(R.id.home_search_button_img));//2131165809
        this.tvHomeSearchButton = ((TextView)findViewById(R.id.home_search_button_txt));//2131165810
        this.ivHomeMessageButton = ((SimpleDraweeView)findViewById(R.id.home_message_img));//2131165805
        this.tvHomeMessageButton = ((TextView)findViewById(R.id.home_message_txt));//2131165813
        resolveAutoComplete(this.acEditView);
        initSaoAsao();
    }

    private void initShadow()
    {
        this.vShadow = new View(getContext());
        this.vShadow.setBackgroundResource(R.drawable.mallhome_searchbar_shadow);//2130840158
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, DPIUtil.getWidthByDesignValue720(5));
        this.vShadow.setVisibility(View.INVISIBLE);
        addView(this.vShadow, localLayoutParams);
    }

    private void initView()
    {
        this.acEditView = ((AutoCompleteTextView)findViewById(R.id.search_text));//2131166399
        this.acEditView.setFocusable(false);
        initSearchComponent();
        ((RelativeLayout)findViewById(R.id.to_message_btn)).setOnClickListener(new View.OnClickListener(){//p(this)
            @Override
            public void onClick(View v) {
                HomeTitle.this.clearMessage();
                PersonalMessageManager.a(LoginUserBase.getLoginUserName());
                PersonalMessageManager.a("message", System.currentTimeMillis(), HomeTitle.this.thisActivity.getHttpGroupWithNPSGroup());
                com.zy.common.constant.Constants.mustFreshMessage = true;
                Intent intent = new Intent(HomeTitle.this.thisActivity, MyMessageBox.class);
                intent.putExtra("title", HomeTitle.this.getContext().getString(R.string.content_message_center));//2131231239
                intent.putExtra("com.360buy:navigationDisplayFlag", -1);
                HomeTitle.this.thisActivity.startActivity(intent);
                JDMtaUtils.onClickWithPageId(HomeTitle.this.thisActivity.getBaseContext(), "Home_MessageCenter", getClass().getName(), Constants.b);
            }
        });//2131165812
        this.redDot = ((ImageView)findViewById(R.id.home_message_red_dot));//2131165806
        this.messageNum = ((TextView)findViewById(R.id.home_message_number));//2131165807
    }

    private void resolveAutoComplete(AutoCompleteTextView paramAutoCompleteTextView)
    {
        this.ivSearchIcon = ((SimpleDraweeView)findViewById(R.id.search_icon));//2131166398
        this.ivVoiceSearchIcon = ((SimpleDraweeView)findViewById(R.id.search_voice));//2131168592
        paramAutoCompleteTextView.setThreshold(1);
        paramAutoCompleteTextView.setOnTouchListener(new View.OnTouchListener(){//q(this)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Log.D)
                    Log.d(HomeTitle.access$200(this.a), "autoCompleteTextView 接收事件:" + event.getAction());
                if (event.getAction() == 0)
                {
                    if (Log.D)
                        Log.d(HomeTitle.access$200(this.a), " -->> autoCompleteTextView onTouch Action:Down");
                    HomeTitle.access$300(this.a);
                    JDMtaUtils.sendCommonData(HomeTitle.this.thisActivity.getBaseContext(), "Home_Search", "", "", HomeTitle.this.thisActivity.getBaseContext(), "", SearchActivity.class, "", Constants.b);
                    return true;
                }
                return false;
            }
        });
        this.ivVoiceSearchIcon.setOnTouchListener(new View.OnTouchListener(){//r(this)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 0)
                {
                    HomeTitle.access$400(this.a, "type", "voice");
                    return true;
                }
                return false;
            }
        });
        this.searchLayout = findViewById(R.id.home_title_search);//2131165811
        initSearchBarColor(true);
        this.searchLayout.setOnTouchListener(new View.OnTouchListener(){//s(this)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Log.D)
                    Log.d(HomeTitle.access$200(this.a), "searchLayout 接收事件:" + event.getAction());
                if (event.getAction() == 0)
                {
                    HomeTitle.access$300(this.a);
                    JDMtaUtils.sendCommonData(HomeTitle.this.thisActivity.getBaseContext(), "Home_Search", "", "", HomeTitle.this.thisActivity.getBaseContext(), "", SearchActivity.class, "", Constants.b);
                    return true;
                }
                return false;
            }
        });
    }

    private void setIconColor(boolean paramBoolean)
    {
        if (paramBoolean)
        {
            this.acEditView.setTextColor(-1);
            this.acEditView.setHintTextColor(-1);
            this.tvHomeSearchButton.setTextColor(-1);
            this.tvHomeMessageButton.setTextColor(-1);
            this.ivHomeSearchButton.setImageResource(2130841243);
            this.ivHomeMessageButton.setImageResource(2130841241);
            this.ivSearchIcon.setImageResource(2130839436);
            this.ivVoiceSearchIcon.setImageResource(2130838125);
            if ((this.vShadow != null) && (this.vShadow.getVisibility() == 0))
                this.vShadow.setVisibility(4);
        }
        do
        {
            return;
            this.tvHomeSearchButton.setTextColor(-16777216);
            this.tvHomeMessageButton.setTextColor(-16777216);
            this.acEditView.setTextColor(-12106170);
            this.acEditView.setHintTextColor(-5987421);
            this.ivHomeSearchButton.setImageResource(2130841244);
            this.ivHomeMessageButton.setImageResource(2130841242);
            this.ivSearchIcon.setImageResource(2130839435);
            this.ivVoiceSearchIcon.setImageResource(2130838124);
        }
        while ((this.vShadow == null) || (this.vShadow.getVisibility() == 0));
        this.vShadow.setVisibility(View.VISIBLE);
    }

    public void bindFragment(JDHomeFragment paramJDHomeFragment)
    {
        this.fragment = paramJDHomeFragment;
    }

    public void changeSearchBarColorVarScrolling(int paramInt)
    {
        boolean bool = true;
        if (this.fragment == null);
        int i;
        do
        {
            return;
            int j = this.fragment.b();
            if (j <= 0)
            {
                initSearchBarColor(false);
                return;
            }
            i = getHeight();
            int k = i / 2;
            if (paramInt <= k)
            {
                initSearchBarColor(true);
                return;
            }
            if ((paramInt <= k) || (paramInt > j - i))
                continue;
            float f = paramInt / (j - i);
            j = Color.argb((int)(255.0F * f * 0.97D), 255, 255, 255);
            this.llBarLayout.setBackgroundColor(j);
            j = (int)(244.0F - 32.0F * f);
            setSearchLayoutBackground(Color.argb((int)(255.0D * (0.6D - f * 0.09999999999999998D)), j, j, j));
            if (paramInt <= i);
            while (true)
            {
                setIconColor(bool);
                return;
                bool = false;
            }
        }
        while (paramInt <= i);
        initSearchBarColor(false);
    }

    public boolean checkCameraHardware(Context paramContext)
    {
        if (fe.b())
            return com.jingdong.common.ui.a.a(paramContext);
        return true;
    }

    public int getBarHeight()
    {
        return this.titleBarLayoutHeight;
    }

    public void initSearchBarColor(boolean paramBoolean)
    {
        if (paramBoolean)
        {
            setSearchLayoutBackground(-1711999756);
            i = Color.argb(0, 255, 255, 255);
            this.llBarLayout.setBackgroundColor(i);
            setIconColor(true);
            return;
        }
        int i = Color.argb(247, 255, 255, 255);
        this.llBarLayout.setBackgroundColor(i);
        setSearchLayoutBackground(2144654548);
        setIconColor(false);
    }

    public void onPause()
    {
        b.a(LoginUserBase.getLoginUserName());
        b.b(this);
    }

    public void onPersonalMessageReceived(Map<String, com.jingdong.app.mall.personel.a.a.a> paramMap)
    {
        if ((paramMap != null) && (paramMap.containsKey("message")))
        {
            paramMap = (com.jingdong.app.mall.personel.a.a.a)paramMap.get("message");
            if (paramMap != null);
        }
        else
        {
            return;
        }
        int i;
        if (paramMap.a())
            i = 0;
        while (true)
        {
            Message localMessage = Message.obtain();
            localMessage.what = 3;
            Bundle localBundle = new Bundle();
            localBundle.putInt("style", i);
            localBundle.putInt("num", paramMap.e);
            localMessage.setData(localBundle);
            this.mHandler.sendMessage(localMessage);
            return;
            if (paramMap.b())
            {
                i = 1;
                continue;
            }
            i = 2;
        }
    }

    public void onResume()
    {
        b.a(LoginUserBase.getLoginUserName());
        b.a(this);
        requestRedPoint();
        if (this.acEditView != null)
        {
            this.acEditView.setVisibility(View.VISIBLE);
            this.acEditView.setHint(2131231773);
            String str = CommonUtil.getJdSharedPreferences().getString("hintKeyWord", "");
            if (!TextUtils.isEmpty(str))
                this.acEditView.setHint(str);
        }
    }

    public void requestRedPoint()
    {
        clearMessage();
        if ((LoginUser.hasLogin()) && (this.mMessageFlag))
        {
            this.mMessageFlag = false;
            b.a(LoginUserBase.getLoginUserName());
            b.a(this.thisActivity.getHttpGroupWithNPSGroup());
        }
    }

    public void setMessageFlag(boolean paramBoolean)
    {
        this.mMessageFlag = paramBoolean;
    }

    public void setSearchLayoutBackground(int paramInt)
    {
        if (this.searchLayout == null)
            return;
        Object localObject = this.searchLayout.getBackground();
        if ((localObject == null) || (!(localObject instanceof ShapeDrawable)))
        {
            float f = DPIUtil.getWidthByDesignValue720(8);
            localObject = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
            ((ShapeDrawable)localObject).getPaint().setStyle(Paint.Style.FILL);
            ((ShapeDrawable)localObject).getPaint().setColor(paramInt);
            if (Build.VERSION.SDK_INT < 16)
                break label139;
            this.searchLayout.setBackground((Drawable)localObject);
        }
        while (true)
        {
            this.searchLayout.invalidate();
            return;
            localObject = (ShapeDrawable)localObject;
            break;
            label139: this.searchLayout.setBackgroundDrawable((Drawable)localObject);
        }
    }
}
