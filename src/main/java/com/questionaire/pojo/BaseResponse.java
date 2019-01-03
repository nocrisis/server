package com.questionaire.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;


/**
 * 返回值对象
 * 
 * @author 蘑小菇
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class BaseResponse implements Serializable{

	private static final long serialVersionUID = 3195300067096687338L;


	@JSONField(name="code")
    private int code;
	
	@JSONField(name="error_message")
    private String errorMsg;
	
	@JSONField(name="data")
	private Object data;
	
	public BaseResponse() {
        super();
    }

	public BaseResponse(int code) {
        super();
        this.code = code;
        this.errorMsg = "";
        this.data = new HashMap<>(0);
    }
	public BaseResponse(int code, String errorMsg) {
		super();
		this.code = code;
		this.errorMsg = errorMsg;
		this.data = new HashMap<>(0);
	}
	

	public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data==null?new HashMap<>(0):data;
    }
    /**
     * 
     * @return
     *     The code
     */
    public int getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The error_msg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 
     * @param error_msg
     *     The error_msg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


}