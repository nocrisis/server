package com.questionaire.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.questionaire.common.constant.Constants;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Json util class based on fastjson
 */
public class FastJsonUtils {
	private static final SerializeConfig config;
	  
    static {  
        config = new SerializeConfig();
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }  
  
    private static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.DisableCircularReferenceDetect //禁止循环引用检测
    };  
    
    public static String toJSONString(Object object) {  
        return JSON.toJSONString(object, config, features);
    }  
      
    public static String toJSONNoFeatures(Object object) {  
        return JSON.toJSONString(object, config);
    }  
  
    public static Object toBean(String text) {  
        return JSON.parse(text);
    }  
  
    public static <T> T toBean(String text, Class<T> clazz) {  
        return JSON.parseObject(text, clazz);
    }  
  
    // 转换为List  
    public static <T> List<T> toList(String text, Class<T> clazz) {  
        return JSON.parseArray(text, clazz);
    }  
  
    /**  
     * json字符串转化为map  
     * @param s  
     * @return  
     */  
    @SuppressWarnings("rawtypes")
	public static Map stringToCollect(String s) {  
        Map m = JSONObject.parseObject(s);
        return m;  
    }  

    /**
     * jsonArray转换成List
     * @param jsonArray
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonArrayToList(JSONArray jsonArray, Class<T> clazz) {
        String json = JSON.toJSONString(jsonArray);
        return JSON.parseArray(json, clazz);
    }

    /**
     * 生产简单jsonObject
     * @param key
     * @param object
     * @return
     */

    public static JSONObject putParmToJsonObject(String key, Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, object);
        return jsonObject;
    }


    /**
     * 判断结果json对象是否是code 200
     *
     * @param jsonText
     * @return
     */
    public static boolean isSuccess(String jsonText) {
        if (StringUtils.isEmpty(jsonText)){
            return false;
        }

        JSONObject resultJson = JSON.parseObject(jsonText);

        return isSuccess(resultJson);
    }

    /**
     * 判断结果json对象是否是code 200
     *
     * @param resultJson
     * @return
     */
    public static boolean isSuccess(JSONObject resultJson) {
        if(Objects.isNull(resultJson)){
            return false;
        }
        return resultJson.getIntValue(Constants.CODE_FLAG) == 200 || "200".equals(resultJson.getString(Constants.CODE_FLAG));
    }
}
