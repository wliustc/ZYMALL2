package com.jingdong.common.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;

/**
 * Created by Robin on 2016/10/11.
 */
public class JDDialogFactory {
    private static JDDialogFactory instance;

    public static JDDialogFactory getInstance()
    {
        monitorenter;
        try
        {
            if (instance == null)
                instance = new JDDialogFactory();
            JDDialogFactory localJDDialogFactory = instance;
            return localJDDialogFactory;
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
    }

    public JDDialog createJdDialogWithStyle1(Context paramContext, String paramString1, String paramString2)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        paramContext = new JDDialog(paramContext);
        paramContext.setContentView(R.layout.jd_common_dialog_style_1);
        paramContext.messageView = ((TextView)paramContext.findViewById(R.id.jd_dialog_message));
        paramContext.messageView.setText(paramString1);
        paramContext.posButton = ((Button)paramContext.findViewById(R.id.jd_dialog_pos_button));
        paramContext.posButton.setText(paramString2);
        paramContext.useCancelClickEvent(paramContext.posButton);
        return paramContext;
    }

    public JDDialog createJdDialogWithStyle10(Context paramContext, String paramString1, String paramString2, View paramView, String paramString3, String paramString4)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        JDDialog localJDDialog = new JDDialog(paramContext);
        localJDDialog.setContentView(R.layout.jd_common_dialog_style_10_2);
        localJDDialog.titleView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_title));
        localJDDialog.setTitle(paramString1);
        localJDDialog.messageView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_message));
        localJDDialog.messageView.setMovementMethod(LinkMovementMethod.getInstance());
        localJDDialog.setMessage(paramString2);
        localJDDialog.posButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_pos_button));
        if (TextUtils.isEmpty(paramString3))
        {
            localJDDialog.posButton.setVisibility(8);
            localJDDialog.negButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_neg_button));
            if (!TextUtils.isEmpty(paramString4))
                break label252;
            localJDDialog.negButton.setVisibility(8);
        }
        while (true)
        {
            if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
            {
                ((LinearLayout.LayoutParams)localJDDialog.negButton.getLayoutParams()).leftMargin = paramContext.getResources().getDimensionPixelSize(R.dimen.base_ui_jd_dialog_style10_button_child_margin);
                localJDDialog.negButton.requestLayout();
            }
            paramString1 = (LinearLayout)localJDDialog.findViewById(R.id.viewLayout);
            if (paramView != null)
                break label275;
            paramString1.setVisibility(8);
            return localJDDialog;
            localJDDialog.posButton.setText(paramString3);
            localJDDialog.useCancelClickEvent(localJDDialog.posButton);
            break;
            label252: localJDDialog.negButton.setText(paramString4);
            localJDDialog.useCancelClickEvent(localJDDialog.negButton);
        }
        label275: paramString1.addView(paramView);
        paramString1.getViewTreeObserver().addOnGlobalLayoutListener(new al(this, paramString1, paramContext));
        return localJDDialog;
    }

    public JDDialog createJdDialogWithStyle1_redbg(Context paramContext, String paramString1, String paramString2)
    {
        return createJdDialogWithStyle1_redbg(paramContext, paramString1, paramString2, -1);
    }

    public JDDialog createJdDialogWithStyle1_redbg(Context paramContext, String paramString1, String paramString2, int paramInt)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        JDDialog localJDDialog = new JDDialog(paramContext);
        localJDDialog.setContentView(R.layout.jd_common_dialog_style_1);
        localJDDialog.messageView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_message));
        localJDDialog.messageView.setText(paramString1);
        if (paramInt != -1)
            localJDDialog.messageView.setGravity(paramInt);
        localJDDialog.posButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_pos_button));
        localJDDialog.posButton.setText(paramString2);
        localJDDialog.posButton.setBackgroundResource(R.drawable.button_dialog_neg);
        localJDDialog.posButton.setTextColor(paramContext.getResources().getColorStateList(R.color.button_dialog_neg_font_color));
        localJDDialog.useCancelClickEvent(localJDDialog.posButton);
        return localJDDialog;
    }

    public JDDialog createJdDialogWithStyle2(Context paramContext, String paramString1, String paramString2, String paramString3)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString3))
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        paramContext = new JDDialog(paramContext);
        paramContext.setContentView(R.layout.jd_common_dialog_style_2);
        paramContext.messageView = ((TextView)paramContext.findViewById(R.id.jd_dialog_message));
        paramContext.messageView.setText(paramString1);
        paramContext.posButton = ((Button)paramContext.findViewById(R.id.jd_dialog_pos_button));
        paramContext.posButton.setText(paramString2);
        paramContext.useCancelClickEvent(paramContext.posButton);
        paramContext.negButton = ((Button)paramContext.findViewById(R.id.jd_dialog_neg_button));
        paramContext.negButton.setText(paramString3);
        paramContext.useCancelClickEvent(paramContext.negButton);
        return paramContext;
    }

    public JDDialog createJdDialogWithStyle3(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString4))
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString5))
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        paramContext = new JDDialog(paramContext);
        paramContext.setContentView(R.layout.jd_common_dialog_style_3);
        paramContext.messageView = ((TextView)paramContext.findViewById(R.id.jd_dialog_message));
        paramContext.messageView.setText(paramString1);
        paramContext.posButton = ((Button)paramContext.findViewById(R.id.jd_dialog_pos_button));
        paramContext.posButton.setText(paramString4);
        paramContext.useCancelClickEvent(paramContext.posButton);
        paramContext.negButton = ((Button)paramContext.findViewById(R.id.jd_dialog_neg_button));
        paramContext.negButton.setText(paramString5);
        paramContext.useCancelClickEvent(paramContext.negButton);
        paramContext.editText = ((EditText)paramContext.findViewById(R.id.jd_dialog_input_edit));
        paramContext.imageView = ((ImageView)paramContext.findViewById(R.id.jd_dialog_input_image));
        if (!TextUtils.isEmpty(paramString2))
            paramContext.editText.setHint(paramString2);
        if (!TextUtils.isEmpty(paramString3))
            JDImageUtils.displayImage(paramString3, paramContext.imageView);
        return paramContext;
    }

    public ad createJdDialogWithStyle4(Context paramContext, String paramString1, BaseAdapter paramBaseAdapter, String paramString2, String paramString3)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString3))
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        if (paramBaseAdapter == null)
            throw new IllegalArgumentException("the param items can not be empty in this dialog style");
        ad localad = new ad(paramContext);
        localad.setContentView(R.layout.jd_common_dialog_style_4);
        localad.messageView = ((TextView)localad.findViewById(R.id.jd_dialog_message));
        localad.messageView.setText(paramString1);
        localad.posButton = ((Button)localad.findViewById(R.id.jd_dialog_pos_button));
        localad.posButton.setText(paramString2);
        localad.useCancelClickEvent(localad.posButton);
        localad.negButton = ((Button)localad.findViewById(R.id.jd_dialog_neg_button));
        localad.negButton.setText(paramString3);
        localad.useCancelClickEvent(localad.negButton);
        localad.a(paramContext, paramBaseAdapter, null);
        return localad;
    }

    public ad createJdDialogWithStyle4(Context paramContext, String paramString1, ArrayList<String> paramArrayList, String paramString2, String paramString3)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString3))
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        if ((paramArrayList == null) || (paramArrayList.size() <= 0))
            throw new IllegalArgumentException("the param items can not be empty in this dialog style");
        ad localad = new ad(paramContext);
        localad.setContentView(R.layout.jd_common_dialog_style_4);
        localad.messageView = ((TextView)localad.findViewById(R.id.jd_dialog_message));
        localad.messageView.setText(paramString1);
        localad.posButton = ((Button)localad.findViewById(R.id.jd_dialog_pos_button));
        localad.posButton.setText(paramString2);
        localad.useCancelClickEvent(localad.posButton);
        localad.negButton = ((Button)localad.findViewById(R.id.jd_dialog_neg_button));
        localad.negButton.setText(paramString3);
        localad.useCancelClickEvent(localad.negButton);
        localad.a(paramContext, null, paramArrayList);
        return localad;
    }

    public JDDialog createJdDialogWithStyle5(Context paramContext, String paramString1, String paramString2, String paramString3)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param title can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString3))
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        paramContext = new JDDialog(paramContext);
        paramContext.setContentView(R.layout.jd_common_dialog_style_5);
        paramContext.titleView = ((TextView)paramContext.findViewById(R.id.jd_dialog_title));
        paramContext.titleView.setText(paramString1);
        paramContext.messageView = ((TextView)paramContext.findViewById(R.id.jd_dialog_message));
        paramContext.messageView.setText(paramString2);
        paramContext.posButton = ((Button)paramContext.findViewById(R.id.jd_dialog_pos_button));
        paramContext.posButton.setText(paramString3);
        paramContext.useCancelClickEvent(paramContext.posButton);
        return paramContext;
    }

    public JDDialog createJdDialogWithStyle6(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param title can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString3))
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        paramContext = new JDDialog(paramContext);
        paramContext.setContentView(R.layout.jd_common_dialog_style_6);
        paramContext.titleView = ((TextView)paramContext.findViewById(R.id.jd_dialog_title));
        paramContext.titleView.setText(paramString1);
        paramContext.messageView = ((TextView)paramContext.findViewById(R.id.jd_dialog_message));
        paramContext.setMessage(paramCharSequence);
        paramContext.posButton = ((Button)paramContext.findViewById(R.id.jd_dialog_pos_button));
        paramContext.posButton.setText(paramString2);
        paramContext.useCancelClickEvent(paramContext.posButton);
        paramContext.negButton = ((Button)paramContext.findViewById(R.id.jd_dialog_neg_button));
        paramContext.negButton.setText(paramString3);
        paramContext.useCancelClickEvent(paramContext.negButton);
        return paramContext;
    }

    public JDDialog createJdDialogWithStyle7(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString4))
            throw new IllegalArgumentException("the param tipMessage can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString5))
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString6))
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        JDDialog localJDDialog = new JDDialog(paramContext);
        localJDDialog.setContentView(R.layout.jd_common_dialog_style_7);
        localJDDialog.titleView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_title));
        localJDDialog.messageView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_message));
        localJDDialog.titleView.setText(paramString1);
        localJDDialog.messageView.setText(paramString2);
        localJDDialog.posButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_pos_button));
        localJDDialog.posButton.setText(paramString5);
        localJDDialog.useCancelClickEvent(localJDDialog.posButton);
        localJDDialog.negButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_neg_button));
        localJDDialog.negButton.setText(paramString6);
        localJDDialog.editText = ((EditText)localJDDialog.findViewById(R.id.jd_dialog_input_edit));
        paramString1 = paramContext.getResources().getDrawable(R.drawable.delete_selector);
        paramString1.setBounds(0, 0, paramString1.getIntrinsicWidth(), paramString1.getIntrinsicHeight());
        localJDDialog.editText.addTextChangedListener(new aj(this, paramString1, localJDDialog, paramContext));
        localJDDialog.editText.setOnTouchListener(new ak(this, localJDDialog));
        localJDDialog.tipLayout = ((LinearLayout)localJDDialog.findViewById(R.id.jd_dialog_tip_layout));
        localJDDialog.tipTextView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_tip_message));
        localJDDialog.tipTextView.setText(paramString4);
        if (!TextUtils.isEmpty(paramString3))
            localJDDialog.editText.setHint(paramString3);
        return localJDDialog;
    }

    public JDListDialog createJdDialogWithStyle8(Context paramContext, String paramString1, BaseAdapter paramBaseAdapter, String paramString2)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param title can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        if (paramBaseAdapter == null)
            throw new IllegalArgumentException("the param items can not be empty in this dialog style");
        JDListDialog localJDListDialog = new JDListDialog(paramContext);
        localJDListDialog.setContentView(R.layout.jd_common_dialog_style_8);
        localJDListDialog.titleView = ((TextView)localJDListDialog.findViewById(R.id.jd_dialog_title));
        localJDListDialog.titleView.setText(paramString1);
        localJDListDialog.posButton = ((Button)localJDListDialog.findViewById(R.id.jd_dialog_pos_button));
        localJDListDialog.posButton.setText(paramString2);
        localJDListDialog.useCancelClickEvent(localJDListDialog.posButton);
        localJDListDialog.initListView(paramContext, paramBaseAdapter, null);
        return localJDListDialog;
    }

    public JDListDialog createJdDialogWithStyle8(Context paramContext, String paramString1, List<aq> paramList, String paramString2)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString2))
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        if ((paramList == null) || (paramList.size() <= 0))
            throw new IllegalArgumentException("the param items can not be empty in this dialog style");
        JDListDialog localJDListDialog = new JDListDialog(paramContext);
        localJDListDialog.setContentView(R.layout.jd_common_dialog_style_8);
        localJDListDialog.titleView = ((TextView)localJDListDialog.findViewById(R.id.jd_dialog_title));
        localJDListDialog.titleView.setText(paramString1);
        localJDListDialog.posButton = ((Button)localJDListDialog.findViewById(R.id.jd_dialog_pos_button));
        localJDListDialog.posButton.setText(paramString2);
        localJDListDialog.useCancelClickEvent(localJDListDialog.posButton);
        localJDListDialog.initListView(paramContext, null, paramList);
        return localJDListDialog;
    }

    public JDDialog createJdDialogWithStyle9(Context paramContext, String paramString1, String paramString2, View paramView, String paramString3, String paramString4)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        JDDialog localJDDialog = new JDDialog(paramContext);
        localJDDialog.setContentView(R.layout.jd_common_dialog_style_9);
        localJDDialog.titleView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_title));
        localJDDialog.setTitle(paramString1);
        localJDDialog.messageView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_message));
        localJDDialog.messageView.setMovementMethod(LinkMovementMethod.getInstance());
        localJDDialog.setMessage(paramString2);
        localJDDialog.posButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_pos_button));
        if (TextUtils.isEmpty(paramString3))
        {
            localJDDialog.posButton.setVisibility(8);
            localJDDialog.negButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_neg_button));
            if (!TextUtils.isEmpty(paramString4))
                break label252;
            localJDDialog.negButton.setVisibility(8);
        }
        while (true)
        {
            if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
            {
                ((LinearLayout.LayoutParams)localJDDialog.negButton.getLayoutParams()).leftMargin = paramContext.getResources().getDimensionPixelSize(R.dimen.base_ui_jd_dialog_style9_button_child_margin);
                localJDDialog.negButton.requestLayout();
            }
            paramContext = (LinearLayout)localJDDialog.findViewById(R.id.bottomLayout);
            if (paramView != null)
                break label275;
            paramContext.setVisibility(8);
            return localJDDialog;
            localJDDialog.posButton.setText(paramString3);
            localJDDialog.useCancelClickEvent(localJDDialog.posButton);
            break;
            label252: localJDDialog.negButton.setText(paramString4);
            localJDDialog.useCancelClickEvent(localJDDialog.negButton);
        }
        label275: paramContext.addView(paramView);
        return localJDDialog;
    }

    public JDDialog createUpgradeJdDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param title can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString5))
            throw new IllegalArgumentException("the param posButton can not be empty in this dialog style");
        paramContext = new JDDialog(paramContext, R.style.JD_Dialog_Upgrade);
        paramContext.setContentView(R.layout.jd_upgrade_dialog);
        paramContext.titleView = ((TextView)paramContext.findViewById(R.id.jd_dialog_title));
        paramContext.secondTitleView = ((TextView)paramContext.findViewById(R.id.jd_dialog_second_title));
        paramContext.messageView = ((TextView)paramContext.findViewById(R.id.jd_dialog_message1));
        paramContext.secondMessageView = ((TextView)paramContext.findViewById(R.id.jd_dialog_message2));
        paramContext.setTitle(paramString1);
        paramContext.titleView.setGravity(17);
        paramContext.setSecondTitle(paramString2);
        paramContext.setMessage(paramString3);
        paramContext.setSecondMessage(paramString4);
        paramContext.posButton = ((Button)paramContext.findViewById(R.id.jd_dialog_pos_button));
        paramContext.posButton.setText(paramString5);
        paramContext.useCancelClickEvent(paramContext.posButton);
        paramContext.negButton = ((Button)paramContext.findViewById(R.id.jd_dialog_neg_button));
        paramContext.useCancelClickEvent(paramContext.negButton);
        if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString4)))
        {
            ((LinearLayout.LayoutParams)paramContext.posButton.getLayoutParams()).topMargin = DPIUtil.dip2px(40.0F);
            paramContext.posButton.requestLayout();
        }
        return paramContext;
    }
}
