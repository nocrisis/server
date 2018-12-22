package com.questionaire.common.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum BaseCode {
    /**查询参数错误、缺少**/
    ILLEGAL_PARAMETER(19999, "参数错误"),
	QUESTIONNAIRE_UID_IS_EMPTY(40000,"问卷UID不能为空"),
	USER_QUESTIONNAIRE_UNIQUE_ERROR(40001,"该用户已经填写过问卷"),
	QUESTIONNAIRE_IS_EXIST(40002,"问卷不存在"),
    UNKNOWN(-1, "Unknown error");
    
	private int code;
	private String message;

	BaseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public static BaseCode valueOf(int code) {
		BaseCode ec = values.get(code);
		if (ec != null){
			return ec;
		}
		return UNKNOWN;
	}
	
	public static BaseCode valueOfCodeStr(String codeStr) {
		try{
			int code = Integer.valueOf(codeStr);
			BaseCode ec = values.get(code);
			if (ec != null){
				return ec;
			}
			return UNKNOWN;
		} catch(Exception e){
			return UNKNOWN;
		}
		
	}

	private static final Map<Integer, BaseCode> values = new HashMap<Integer, BaseCode>();
	static {
		for (BaseCode ec : BaseCode.values()) {
			values.put(ec.code, ec);
		}
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
