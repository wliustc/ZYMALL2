package com.zy.common.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.jingdong.common.utils.FileService;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/11/23.
 */
public class StorageReceiver extends BroadcastReceiver {
    private static IntentFilter a;
    private static StorageReceiver b;

    public static void a(Context paramContext)
    {
        if (b == null)
            b = new StorageReceiver();
        if (paramContext != null)
        {
            IntentFilter localIntentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
            a = localIntentFilter;
            localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
            a.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            a.addAction("android.intent.action.MEDIA_REMOVED");
            a.addAction("android.intent.action.MEDIA_UNMOUNTED");
            a.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            a.addDataScheme("file");
            paramContext.registerReceiver(b, a);
        }
    }

    public static void b(Context paramContext)
    {
        if ((paramContext != null) && (b != null))
            paramContext.unregisterReceiver(b);
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
        if (Log.D)
            Log.d("StorageReceiver", " StorageReceiver onReceive -->> action: " + paramIntent.getAction());
        FileService.a();
    }
}
