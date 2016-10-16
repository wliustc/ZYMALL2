package com.zy.common.ui;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zy.app.mall.R;

/**
 * Created by Robin on 2016/10/11.
 */
public class JDDialog extends Dialog {
    private View.OnClickListener cancelClickListener = new View.OnClickListener(){//ai(this)
        @Override
        public void onClick(View v) {
            JDDialog.this.cancel();
        }
    };
    public EditText editText;
    public ImageView imageView;
    public LinearLayout inputLayout;
    public TextView messageView;
    public Button negButton;
    public Button posButton;
    public TextView secondMessageView;
    public TextView secondTitleView;
    public LinearLayout tipLayout;
    public TextView tipTextView;
    public TextView titleView;

    public JDDialog(Context paramContext)
    {
        super(paramContext, R.style.JD_Dialog_Common);//2131296257
        setCancelable(false);
    }

    public JDDialog(Context paramContext, int paramInt)
    {
        super(paramContext, paramInt);
        setCancelable(false);
    }

    public void setEditText(String paramString)
    {
        if ((this.editText != null) && (paramString != null))
            this.editText.setText(paramString);
    }

    public void setEditTextHint(String paramString)
    {
        if ((this.editText != null) && (paramString != null))
            this.editText.setHint(paramString);
    }

    public void setEditTextWrong()
    {
        if (this.editText != null)
        {
            this.editText.setBackgroundResource(R.drawable.jd_dialog_edit_bg_red);
            Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.edittext_shake);
            this.editText.startAnimation(localAnimation);
        }
    }

    public void setMessage(CharSequence paramCharSequence)
    {
        if (this.messageView != null)
        {
            if (!TextUtils.isEmpty(paramCharSequence))
            {
                this.messageView.setVisibility(View.VISIBLE);
                this.messageView.setText(paramCharSequence);
            }else
                this.messageView.setVisibility(View.GONE);
        }
        return;

    }

    public void setMessageColor(int paramInt)
    {
        if (this.messageView != null)
            this.messageView.setTextColor(paramInt);
    }

    public void setMessagePosition(int paramInt)
    {
        if (this.messageView != null)
            this.messageView.setGravity(paramInt);
    }

    public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
    {
        if (this.posButton != null)
            this.posButton.setOnClickListener(paramOnClickListener);
    }

    public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
    {
        if (this.negButton != null)
            this.negButton.setOnClickListener(paramOnClickListener);
    }

    public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener, boolean paramBoolean)
    {
        if (this.negButton != null)
        {
            this.negButton.setOnClickListener(paramOnClickListener);
            this.negButton.setClickable(paramBoolean);
        }
    }

    public void setSecondMessage(String paramString)
    {
        if (this.secondMessageView != null)
        {
            if (!TextUtils.isEmpty(paramString))
                this.secondMessageView.setText(paramString);
            else
                this.secondMessageView.setVisibility(View.GONE);
        }
        return;
    }

    public void setSecondTitle(String paramString)
    {
        if (this.secondTitleView != null)
        {
            if (!TextUtils.isEmpty(paramString))
                this.secondTitleView.setText(paramString);
            else
                this.secondTitleView.setVisibility(View.GONE);
        }
        return;
    }

    public void setTipMessageClickListener(View.OnClickListener paramOnClickListener)
    {
        if ((this.tipLayout != null) && (paramOnClickListener != null))
            this.tipLayout.setOnClickListener(paramOnClickListener);
    }

    public void setTitle(String paramString)
    {
        if (this.titleView != null)
        {
            if (!TextUtils.isEmpty(paramString))
            {
                this.titleView.setVisibility(View.VISIBLE);
                this.titleView.setText(paramString);
            }
            else
                this.titleView.setVisibility(View.GONE);
        }
        return;
    }

    protected void setTotalHeightofListView(ListView paramListView)
    {
        ListAdapter localListAdapter = paramListView.getAdapter();
        if (localListAdapter != null){
            int listViewHeight = 0;
            for (int j = 0; j < localListAdapter.getCount(); j++){//if-ge v0, v4, :cond_2
                View localObject = localListAdapter.getView(j, null, paramListView);
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                listViewHeight += ((View)localObject).getMeasuredHeight();
            }//:cond_2
            ViewGroup.LayoutParams localObject = paramListView.getLayoutParams();
            int dividerHeight = paramListView.getDividerHeight();
            int count = localListAdapter.getCount();
            int maxheight = (int)getContext().getResources().getDimension(R.dimen.base_ui_jd_dialog_content_maxheight);
            if (dividerHeight * (count - 1) + listViewHeight > maxheight) {
                ((ViewGroup.LayoutParams) localObject).height = maxheight;
                paramListView.setLayoutParams((ViewGroup.LayoutParams) localObject);
                paramListView.requestLayout();
            }
        }
        return;
    }

    public void useCancelClickEvent(View paramView)
    {
        if (paramView != null)
            paramView.setOnClickListener(this.cancelClickListener);
    }
}
