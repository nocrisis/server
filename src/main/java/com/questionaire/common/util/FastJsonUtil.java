package com.questionaire.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class FastJsonUtil {
    private static final SerializeConfig CONFIG = new SerializeConfig();
    private static final SerializerFeature[] FEATURES;
    private static NameFilter nameFilter;
    private static SerializeFilter[] filters;

    private FastJsonUtil() {
    }

    public static String toJSONStringWithoutNull(Object object) {
        return JSON.toJSONString(object, CONFIG, new SerializerFeature[0]);
    }

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, CONFIG, FEATURES);
    }

    public static String toJSONNoFeatures(Object object) {
        return JSON.toJSONString(object, CONFIG, new SerializerFeature[0]);
    }

    public static String toSnakeCaseJSONString(Object object) {
        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        return JSON.toJSONString(object, config, FEATURES);
    }

    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static <T> Object[] toArray(String text) {
        return toArray(text, (Class)null);
    }

    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    public static Map<String, ?> stringToCollect(String s) {
        return JSONObject.parseObject(s);
    }

    public static <T> List<T> jsonArrayToList(JSONArray jsonArray, Class<T> clazz) {
        String json = JSON.toJSONString(jsonArray);
        return JSON.parseArray(json, clazz);
    }

    public static JSONObject putParmToJsonObject(String key, Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, object);
        return jsonObject;
    }

    public static boolean isSuccess(JSONObject resultJson) {
        if (null == resultJson) {
            return false;
        } else {
            return resultJson.getIntValue("code") == 200;
        }
    }

    static {
        CONFIG.put(Date.class, new JSONLibDataFormatSerializer());
        CONFIG.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        FEATURES = new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteDateUseDateFormat};
        nameFilter = new NameFilter() {
            public String process(Object o, String propertyName, Object o1) {
                return TextUtil.camel2Underline(propertyName);
            }
        };
        filters = new SerializeFilter[]{nameFilter};
    }
}

