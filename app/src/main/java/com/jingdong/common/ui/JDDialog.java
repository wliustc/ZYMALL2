package com.jingdong.common.ui;

import android.app.Dialog;
import android.view.View;

/**
 * Created by Robin on 2016/10/11.
 */
public class JDDialog extends Dialog {
    private View.OnClickListener cancelClickListener = new ai(this);
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
        super(paramContext, R.style.JD_Dialog_Common);
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
                this.messageView.setVisibility(0);
                this.messageView.setText(paramCharSequence);
            }
        }
        else
            return;
        this.messageView.setVisibility(8);
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
        }
        else
            return;
        this.secondMessageView.setVisibility(8);
    }

    public void setSecondTitle(String paramString)
    {
        if (this.secondTitleView != null)
        {
            if (!TextUtils.isEmpty(paramString))
                this.secondTitleView.setText(paramString);
        }
        else
            return;
        this.secondTitleView.setVisibility(8);
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
                this.titleView.setVisibility(0);
                this.titleView.setText(paramString);
            }
        }
        else
            return;
        this.titleView.setVisibility(8);
    }

    protected void setTotalHeightofListView(ListView paramListView)
    {
        ListAdapter localListAdapter = paramListView.getAdapter();
        if (localListAdapter == null);
        int j;
        int i;
        Object localObject;
        int k;
        int m;
        do
        {
            return;
            j = 0;
            i = 0;
            while (j < localListAdapter.getCount())
            {
                localObject = localListAdapter.getView(j, null, paramListView);
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                i += ((View)localObject).getMeasuredHeight();
                j += 1;
            }
            localObject = paramListView.getLayoutParams();
            j = paramListView.getDividerHeight();
            k = localListAdapter.getCount();
            m = (int)getContext().getResources().getDimension(R.dimen.base_ui_jd_dialog_content_maxheight);
        }
        while (j * (k - 1) + i <= m);
        ((ViewGroup.LayoutParams)localObject).height = m;
        paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramListView.requestLayout();
    }

    public void useCancelClickEvent(View paramView)
    {
        if (paramView != null)
            paramView.setOnClickListener(this.cancelClickListener);
    }
}
