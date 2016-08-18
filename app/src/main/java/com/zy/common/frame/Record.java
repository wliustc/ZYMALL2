package com.zy.common.frame;

import android.content.ComponentName;
import android.content.Intent;

/**
 * Created by Robin on 2016/4/6.
 */
//public final class g
public class Record {
    private String id;
    private Intent intent;
    private String compentName;

    public final String a() {
        return this.id;
    }

    public final void a(Intent intent) {
        this.intent = intent;
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component != null)
                this.compentName = component.getClassName();
        }
    }

    public final Intent b() {
        return this.intent;
    }

    public final boolean equals(Object paramObject) {
        if (this == paramObject)
            return true;
        else if (paramObject == null)
            return false;
        else if (getClass() != paramObject.getClass())
            return false;
        paramObject = (Record) paramObject;
        if (this.compentName != null && ((Record) paramObject).compentName != null && this.compentName.equals(((Record) paramObject).compentName))
            return true;
        return false;
    }

    public final int hashCode() {
        if (this.compentName == null) ;
        for (int i = 0; ; i = this.compentName.hashCode())
            return i + 31;
    }

    public final String toString() {
        return "Record [id=" + this.id + ", intent=" + this.intent + ", compentName=" + this.compentName + "]";
    }
}
