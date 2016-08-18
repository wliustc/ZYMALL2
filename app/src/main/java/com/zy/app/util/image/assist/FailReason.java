package com.zy.app.util.image.assist;

/**
 * Created by robin on 16-7-1.
 */
public enum FailReason {
    a(1), b(2), c(3), d(4), e(5);
    private int index;

    FailReason(int i) {
        this.index = i;
    }

    public int getIndex(){
        return index;
    }
}
