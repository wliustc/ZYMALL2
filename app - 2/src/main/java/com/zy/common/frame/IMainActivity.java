package com.zy.common.frame;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by Robin on 2016/4/6.
 */
//public abstract interface c
public interface IMainActivity {
    public abstract void e();

    public abstract Handler getHandler();

    public abstract Activity getThisActivity();

    public abstract boolean l();

    public abstract IMyActivity n();

    public abstract void startActivity(Intent paramIntent);
}
