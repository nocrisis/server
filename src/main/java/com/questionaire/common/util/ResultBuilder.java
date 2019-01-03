package com.questionaire.common.util;


import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.pojo.BaseResponse;

import java.util.HashMap;
import java.util.Map;


public class ResultBuilder {

    private static final String MESSAGE_FLG = "message";
    
    private static final int SUCCESS_CODE =200;
    
    private ResultBuilder(){
        
    }
    

    public static String buildSuccess(String message) {
        Map<String, Object> data = new HashMap<>(0);
        data.put(MESSAGE_FLG, message);
        return buildSuccessData(data);
    }


    public static String buildSuccessData(Object data) {
        BaseResponse result = new BaseResponse();
        result.setData(data);
        result.setCode(SUCCESS_CODE);

        return FastJsonUtil.toSnakeCaseJSONString(result);
    }

    public static String buildError(String errorMsg) {
        BaseResponse result = new BaseResponse();
        result.setErrorMsg(errorMsg);
        result.setCode(500);

        return FastJsonUtil.toSnakeCaseJSONString(result);
    }

    public static String buildError(String errorMsg, Object data) {
        BaseResponse result = new BaseResponse();
        result.setErrorMsg(errorMsg);
        result.setData(data);
        result.setCode(500);
        return FastJsonUtil.toJSONString(result);
    }

    public static String buildError(BaseCode baseCode){
    	 BaseResponse result = new BaseResponse();
    	 result.setCode(baseCode.getCode());
    	 result.setErrorMsg(baseCode.getMessage());
    	 return FastJsonUtil.toJSONString(result);
    }
}


