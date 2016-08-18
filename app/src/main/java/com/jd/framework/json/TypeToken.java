package com.jd.framework.json;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by robin on 16-8-5.
 */
public class TypeToken<T> {
    public static final Type LIST_STRING = new TypeToken._1().getType();
    private final Type type = ((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public Type getType()
    {
        return this.type;
    }

    static class _1 extends TypeToken<List<String>>
    {
    }
}
