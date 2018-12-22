package com.questionaire.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.questionaire.common.constant.Constants;
import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.pojo.dto.BaseResponseDTO;

import java.util.HashMap;
import java.util.Map;

public class ResultBuilderUtils {
	
	public static String buildSuccess(String message) {
		Map<String, Object> data = new HashMap<>();
		data.put(Constants.MESSAGE_FLAG, message);
		return buildSuccess(data);
	}

	public static String buildSuccess(Object data) {
		BaseResponseDTO result = new BaseResponseDTO(data);
		return FastJsonUtils.toJSONString(result);
	}

	public static String buildError(String message) {
		BaseResponseDTO result = new BaseResponseDTO(message);
		return FastJsonUtils.toJSONString(result);
	}
	
	public static String buildError(BaseCode errorCode) {
		BaseResponseDTO result = new BaseResponseDTO(errorCode.getCode(),errorCode.getMessage());
		return FastJsonUtils.toJSONString(result);
	}

	public static String buildError(BaseCode errorCode, String message) {
		BaseResponseDTO result = new BaseResponseDTO(errorCode.getCode(), message);
		return FastJsonUtils.toJSONString(result);
	}
	
	public static String buildErrorWithData(BaseCode errorCode, Object data) {
		BaseResponseDTO result = new BaseResponseDTO(errorCode.getCode(),errorCode.getMessage(), data);
		return FastJsonUtils.toJSONString(result);
	}
	
	public static String buildResponse(Object data, String code, String message) {
		JSONObject result = new JSONObject();
		result.put(Constants.CODE_FLAG, code);
		result.put(Constants.MESSAGE_FLAG, message);
		result.put(Constants.DATA_FLAG, data);

		return JSON.toJSONString(result);
	}
	
	public static String buildPosSuccessResponse(Object data) {
		JSONObject result = new JSONObject();
		result.put(Constants.CODE_FLAG, "200");
		result.put(Constants.DATA_FLAG, data);

		return JSON.toJSONString(result);
	}
	
	public static String buildPosFailResponse(Object data, String code, String errorMsg) {
		JSONObject result = new JSONObject();
		result.put(Constants.CODE_FLAG, code);
		result.put(Constants.ERROR_MSG_FLAG, errorMsg);
		result.put(Constants.DATA_FLAG, data);

		return JSON.toJSONString(result);
	}
}
