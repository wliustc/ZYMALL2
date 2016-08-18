package com.jingdong.common.utils;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by robin on 16-6-24.
 */
public class URLParamMap implements Serializable, Map<String, String> {
    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @NonNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return null;
    }

    @Override
    public String get(Object key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @NonNull
    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public String put(String key, String value) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> map) {

    }

    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @NonNull
    @Override
    public Collection<String> values() {
        return null;
    }
}
