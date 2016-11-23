package com.jd.framework.json;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zy.common.entity.JumpEntity;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Robin on 2016/5/23.
 */
public class JDJSON {

    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = 0;
    public static String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT;
    public static String DUMP_CLASS;
    public static final String VERSION = "1.2.5";
    public static boolean debug = true;

    static
    {
        DUMP_CLASS = null;
        DEFAULT_PARSER_FEATURE = Feature.AutoCloseSource.getMask() | 0x0 | Feature.InternFieldNames.getMask() | Feature.UseBigDecimal.getMask() | Feature.AllowUnQuotedFieldNames.getMask() | Feature.AllowSingleQuotes.getMask() | Feature.AllowArbitraryCommas.getMask() | Feature.SortFeidFastMatch.getMask() | Feature.IgnoreNotMatch.getMask();
        DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        DEFAULT_GENERATE_FEATURE = SerializerFeature.QuoteFieldNames.getMask() | 0x0 | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
    }

    public static void init(boolean paramBoolean) {
        debug = paramBoolean;
    }

    public static final <T> T parseObject(String paramString, Class<T> paramClass){
        throw new RuntimeException("Not find parseObject(String paramString, Class<T> paramClass) in JDJSON");
    }

    public static <T> List<T> parseArray(String s, Class<T> stringClass) {
        throw new RuntimeException("Not find parseArray(String s, Class<T> stringClass) in JDJSON");
    }

    public static final <T> T parseObject(String paramString, Type type, Feature[] features) {
        throw new RuntimeException("Not find parseObject(String paramString, Type type, Feature[] features) in JDJSON");
    }
}
