package com.jingdong.app.mall.more;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.jd.voice.jdvoicesdk.JdVoiceRecognitionLintener;
import com.jd.voice.jdvoicesdk.a.c;

/**
 * Created by Robin on 2016/5/16.
 */
public class VoiceSearchLayout extends LinearLayout
        implements View.OnClickListener, JdVoiceRecognitionLintener {
    private Context mContext;
    public VoiceSearchLayout(Context paramContext)
    {
        this(paramContext, null);
        this.mContext = paramContext;

    }

    public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;

    }

    public static boolean isUseJdCustomerVoiceService() {
        return false;
    }

    @Override
    public void onBeginOfSpeech() {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(String paramString) {

    }

    @Override
    public void onRecognitionStart() {

    }

    @Override
    public void onResult(int paramInt, c paramc) {

    }

    @Override
    public void onVoiceServiceUnavailable() {

    }

    @Override
    public void onVolumeChanged(int paramInt) {

    }

    @Override
    public void onClick(View v) {

    }
}
