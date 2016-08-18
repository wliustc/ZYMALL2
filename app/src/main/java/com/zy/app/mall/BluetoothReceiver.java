package com.zy.app.mall;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by robin on 16-7-15.
 */
public class BluetoothReceiver extends BroadcastReceiver {
    private static String TAG = "BluetoothReceiver";

    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        if ((context == null) || (intent == null) || (kP(intent.getAction())))
            return;

        int i;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            Log.d(TAG, "getDefaultAdapter == null");
            return;
        }
        Set<BluetoothDevice> set = defaultAdapter.getBondedDevices();
        if ((set == null) || (set.size() == 0)) {
            Log.d(TAG, "getBondedDevices == null");
            return;
        }
        if (!kP(intent.getAction())) {//if-nez v0, :cond_0
            Log.d(TAG, "dkbt action :" + intent.getAction());

            //if (ah.qw()) {
            try {
                i = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);

            } catch (java.lang.Exception e) {

                e.printStackTrace();
                i = 0;

            }
            //:goto_1
            Log.d(TAG, "dkbt  action :" + intent.getAction() + " state:" + i + " isBluetoothScoOn :" + D.getInstance(context).mu() + " " + D.getInstance(context).mx());
            if (i == 1) {
                Log.d(TAG, "sco connected!");
                D d = D.getInstance(context);
                Log.d(TAG, String.format("dkbt bluetoothStartSucc %s", new Object[]{d.mx()}));
                D.bcJ = true;
                d.cb(1);
            } else if (i == 0) {
                Log.d(TAG, "sco disconnected!");
                //if (p.bge.beN == 1)
                //    D.getInstance().mt();
                D d = D.getInstance(context);
                Log.d(TAG, String.format("dkbt bluetoothStopped %s", new Object[]{d.mx()}));
                D.bcJ = false;
                d.cb(2);

                //}
                return;
            }
        }

    }

    public static boolean kP(String paramString) {
        return (paramString == null) || (paramString.length() <= 0);
    }

    public static class D {
        private static D mInstance;
        private final AudioManager bcG;
        public static boolean bcJ = false;
        private int bcH = -1;
        private Context mContext;
        private final Set<A> aaL = new HashSet<A>();

        public synchronized static D getInstance(Context context) {
            if (mInstance == null)
                mInstance = new D(context);
            return mInstance;
        }

        private D(Context context) {
            this.mContext = context;
            this.bcG = ((AudioManager) context.getSystemService(Context.AUDIO_SERVICE));
        }

        public final boolean mu() {
            return (this.bcG.isBluetoothScoOn()) || (bcJ);
        }

        public final String mx() {
            return "mode:" + this.bcG.getMode() + " isSpeakerphoneOn:" + this.bcG.isSpeakerphoneOn() + " isBluetoothOn:" + mu() + " btStatus:" + this.bcH;
        }

        public void cb(int i) {
            Log.d(TAG, String.format("notify, new status: %d, current status: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.bcH)}));
            if (this.bcH != i) {
                this.bcH = i;
//                Iterator localIterator = this.aaL.iterator();
//                while (localIterator.hasNext())
//                    ((a)localIterator.next()).bb(paramInt);
            }
        }

        public final void a(A parama)
        {
            if (parama != null)
                this.aaL.add(parama);
        }

        public final void b(A parama)
        {
            if (parama != null)
                this.aaL.remove(parama);
        }

        public final void mt()
        {
            Log.d(TAG, String.format("dkbt begin stopBluetooth %s", new Object[] { mx() }));
            stopBluetoothSco(this.bcG);
            Log.d(TAG, String.format("dkbt end stopBluetooth %s", new Object[] { mx() }));
        }

        private boolean stopBluetoothSco(AudioManager paramAudioManager){
            if (!paramAudioManager.isBluetoothScoOn())
                return true;
//            if (al.awW)
//                    return false;
//            if ((p.bge.beO == 1) || (p.bge.beP == -1))
                paramAudioManager.setBluetoothScoOn(false);

//            if ((p.bge.beO == 1) || (p.bge.beP == -1))
                paramAudioManager.stopBluetoothSco();
            return true;
        }
    }

    public static abstract interface A
    {
        public abstract void bb(int paramInt);
    }
}
