package com.jd.voice.jdvoicesdk;

import com.jd.voice.jdvoicesdk.a.c;

/**
 * Created by Robin on 2016/5/16.
 */
public interface JdVoiceRecognitionLintener {
    public abstract void onBeginOfSpeech();

    public abstract void onEndOfSpeech();

    public abstract void onError(String paramString);

    public abstract void onRecognitionStart();

    public abstract void onResult(int paramInt, c paramc);

    public abstract void onVoiceServiceUnavailable();

    public abstract void onVolumeChanged(int paramInt);
}
