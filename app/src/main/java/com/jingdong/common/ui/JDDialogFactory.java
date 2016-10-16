package com.jingdong.common.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zy.app.mall.R;
import com.zy.common.ui.JDDialog;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDImageUtils;

/**
 * Created by Robin on 2016/10/11.
 */
public class JDDialogFactory {
    private static JDDialogFactory instance;

    public static JDDialogFactory getInstance()
    {
            if (instance == null) {
                synchronized(JDDialogFactory.class){
                    if (instance == null) {
                        instance = new JDDialogFactory();
                    }
                }
            }
            return instance;
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
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_1);
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));
        dialog.messageView.setText(paramString1);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));
        dialog.posButton.setText(paramString2);
        dialog.useCancelClickEvent(dialog.posButton);
        return dialog;
    }

    /*public JDDialog createJdDialogWithStyle10(Context paramContext, String paramString1, String paramString2, View paramView, String paramString3, String paramString4)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_10_2);
        dialog.titleView = ((TextView)dialog.findViewById(R.id.jd_dialog_title));
        dialog.setTitle(paramString1);
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));
        dialog.messageView.setMovementMethod(LinkMovementMethod.getInstance());
        dialog.setMessage(paramString2);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));
        if (TextUtils.isEmpty(paramString3))
        {
            dialog.posButton.setVisibility(View.GONE);
            dialog.negButton = ((Button)dialog.findViewById(R.id.jd_dialog_neg_button));
            if (!TextUtils.isEmpty(paramString4))
                break label252;
            dialog.negButton.setVisibility(View.GONE);
        }
        while (true)
        {
            if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
            {
                ((LinearLayout.LayoutParams)dialog.negButton.getLayoutParams()).leftMargin = paramContext.getResources().getDimensionPixelSize(R.dimen.base_ui_jd_dialog_style10_button_child_margin);
                dialog.negButton.requestLayout();
            }
            paramString1 = (LinearLayout)dialog.findViewById(R.id.viewLayout);
            if (paramView != null)
                break label275;
            paramString1.setVisibility(View.GONE);
            return dialog;
            dialog.posButton.setText(paramString3);
            dialog.useCancelClickEvent(dialog.posButton);
            break;
            label252: dialog.negButton.setText(paramString4);
            dialog.useCancelClickEvent(dialog.negButton);
        }
        label275: paramString1.addView(paramView);
        paramString1.getViewTreeObserver().addOnGlobalLayoutListener(new al(this, paramString1, paramContext));
        return dialog;
    }*/

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
        localJDDialog.messageView = ((TextView)localJDDialog.findViewById(R.id.jd_dialog_message));//2131165227
        localJDDialog.messageView.setText(paramString1);
        if (paramInt != -1)
            localJDDialog.messageView.setGravity(paramInt);
        localJDDialog.posButton = ((Button)localJDDialog.findViewById(R.id.jd_dialog_pos_button));//2131165231
        localJDDialog.posButton.setText(paramString2);
        localJDDialog.posButton.setBackgroundResource(R.drawable.button_dialog_neg);
        localJDDialog.posButton.setTextColor(paramContext.getResources().getColorStateList(R.color.button_dialog_neg_font_color));//R.color.b0
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
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_2);
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));//2131165227
        dialog.messageView.setText(paramString1);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));//2131165231
        dialog.posButton.setText(paramString2);
        dialog.useCancelClickEvent(dialog.posButton);
        dialog.negButton = ((Button)dialog.findViewById(R.id.jd_dialog_neg_button));
        dialog.negButton.setText(paramString3);
        dialog.useCancelClickEvent(dialog.negButton);
        return dialog;
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
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_3);
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));//2131165227
        dialog.messageView.setText(paramString1);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));//2131165231
        dialog.posButton.setText(paramString4);
        dialog.useCancelClickEvent(dialog.posButton);
        dialog.negButton = ((Button)dialog.findViewById(R.id.jd_dialog_neg_button));//2131165230
        dialog.negButton.setText(paramString5);
        dialog.useCancelClickEvent(dialog.negButton);
        dialog.editText = ((EditText)dialog.findViewById(R.id.jd_dialog_input_edit));//2131165224
        dialog.imageView = ((ImageView)dialog.findViewById(R.id.jd_dialog_input_image));
        if (!TextUtils.isEmpty(paramString2))
            dialog.editText.setHint(paramString2);
        if (!TextUtils.isEmpty(paramString3))
            JDImageUtils.displayImage(paramString3, dialog.imageView);
        return dialog;
    }

    /*public ad createJdDialogWithStyle4(Context paramContext, String paramString1, BaseAdapter paramBaseAdapter, String paramString2, String paramString3)
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
        localad.messageView = ((TextView)localad.findViewById(R.id.jd_dialog_message));//2131165227
        localad.messageView.setText(paramString1);
        localad.posButton = ((Button)localad.findViewById(R.id.jd_dialog_pos_button));//2131165231
        localad.posButton.setText(paramString2);
        localad.useCancelClickEvent(localad.posButton);
        localad.negButton = ((Button)localad.findViewById(R.id.jd_dialog_neg_button));//2131165230
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
    }*/

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
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_5);
        dialog.titleView = ((TextView)dialog.findViewById(R.id.jd_dialog_title));//2131165235
        dialog.titleView.setText(paramString1);
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));//2131165227
        dialog.messageView.setText(paramString2);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));//2131165231
        dialog.posButton.setText(paramString3);
        dialog.useCancelClickEvent(dialog.posButton);
        return dialog;
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
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_6);
        dialog.titleView = ((TextView)dialog.findViewById(R.id.jd_dialog_title));//2131165235
        dialog.titleView.setText(paramString1);
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));//2131165227
        dialog.setMessage(paramCharSequence);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));//2131165231
        dialog.posButton.setText(paramString2);
        dialog.useCancelClickEvent(dialog.posButton);
        dialog.negButton = ((Button)dialog.findViewById(R.id.jd_dialog_neg_button));//2131165230
        dialog.negButton.setText(paramString3);
        dialog.useCancelClickEvent(dialog.negButton);
        return dialog;
    }

    /*public JDDialog createJdDialogWithStyle7(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
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
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_7);
        dialog.titleView = ((TextView)dialog.findViewById(R.id.jd_dialog_title));
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));
        dialog.titleView.setText(paramString1);
        dialog.messageView.setText(paramString2);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));
        dialog.posButton.setText(paramString5);
        dialog.useCancelClickEvent(dialog.posButton);
        dialog.negButton = ((Button)dialog.findViewById(R.id.jd_dialog_neg_button));
        dialog.negButton.setText(paramString6);
        dialog.editText = ((EditText)dialog.findViewById(R.id.jd_dialog_input_edit));
        Drawable drawable = paramContext.getResources().getDrawable(R.drawable.delete_selector);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        dialog.editText.addTextChangedListener(new aj(this, paramString1, dialog, paramContext));
        dialog.editText.setOnTouchListener(new ak(this, dialog));
        dialog.tipLayout = ((LinearLayout)dialog.findViewById(R.id.jd_dialog_tip_layout));
        dialog.tipTextView = ((TextView)dialog.findViewById(R.id.jd_dialog_tip_message));
        dialog.tipTextView.setText(paramString4);
        if (!TextUtils.isEmpty(paramString3))
            dialog.editText.setHint(paramString3);
        return dialog;
    }*/

    /*public JDListDialog createJdDialogWithStyle8(Context paramContext, String paramString1, BaseAdapter paramBaseAdapter, String paramString2)
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
    }*/

    /*public JDListDialog createJdDialogWithStyle8(Context paramContext, String paramString1, List<aq> paramList, String paramString2)
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
    }*/

    /*public JDDialog createJdDialogWithStyle9(Context paramContext, String paramString1, String paramString2, View paramView, String paramString3, String paramString4)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        JDDialog dialog = new JDDialog(paramContext);
        dialog.setContentView(R.layout.jd_common_dialog_style_9);
        dialog.titleView = ((TextView)dialog.findViewById(R.id.jd_dialog_title));
        dialog.setTitle(paramString1);
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message));
        dialog.messageView.setMovementMethod(LinkMovementMethod.getInstance());
        dialog.setMessage(paramString2);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));
        if (TextUtils.isEmpty(paramString3))
        {
            dialog.posButton.setVisibility(View.GONE);
            dialog.negButton = ((Button)dialog.findViewById(R.id.jd_dialog_neg_button));
            if (!TextUtils.isEmpty(paramString4))
                break label252;
            dialog.negButton.setVisibility(View.GONE);
        }
        while (true)
        {
            if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
            {
                ((LinearLayout.LayoutParams)dialog.negButton.getLayoutParams()).leftMargin = paramContext.getResources().getDimensionPixelSize(R.dimen.base_ui_jd_dialog_style9_button_child_margin);
                dialog.negButton.requestLayout();
            }
            paramContext = (LinearLayout)dialog.findViewById(R.id.bottomLayout);
            if (paramView != null)
                break label275;
            paramContext.setVisibility(View.GONE);
            return dialog;
            dialog.posButton.setText(paramString3);
            dialog.useCancelClickEvent(dialog.posButton);
            break;
            label252: dialog.negButton.setText(paramString4);
            dialog.useCancelClickEvent(dialog.negButton);
        }
        label275: paramContext.addView(paramView);
        return dialog;
    }*/

    public JDDialog createUpgradeJdDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
            throws IllegalArgumentException
    {
        if (paramContext == null)
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        if (TextUtils.isEmpty(paramString1))
            throw new IllegalArgumentException("the param title can not be empty in this dialog style");
        if (TextUtils.isEmpty(paramString5))
            throw new IllegalArgumentException("the param posButton can not be empty in this dialog style");
        JDDialog dialog = new JDDialog(paramContext, R.style.JD_Dialog_Upgrade);
        dialog.setContentView(R.layout.jd_upgrade_dialog);
        dialog.titleView = ((TextView)dialog.findViewById(R.id.jd_dialog_title));
        dialog.secondTitleView = ((TextView)dialog.findViewById(R.id.jd_dialog_second_title));
        dialog.messageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message1));
        dialog.secondMessageView = ((TextView)dialog.findViewById(R.id.jd_dialog_message2));
        dialog.setTitle(paramString1);
        dialog.titleView.setGravity(17);
        dialog.setSecondTitle(paramString2);
        dialog.setMessage(paramString3);
        dialog.setSecondMessage(paramString4);
        dialog.posButton = ((Button)dialog.findViewById(R.id.jd_dialog_pos_button));
        dialog.posButton.setText(paramString5);
        dialog.useCancelClickEvent(dialog.posButton);
        dialog.negButton = ((Button)dialog.findViewById(R.id.jd_dialog_neg_button));
        dialog.useCancelClickEvent(dialog.negButton);
        if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString4)))
        {
            ((LinearLayout.LayoutParams)dialog.posButton.getLayoutParams()).topMargin = DPIUtil.dip2px(40.0F);
            dialog.posButton.requestLayout();
        }
        return dialog;
    }
}
