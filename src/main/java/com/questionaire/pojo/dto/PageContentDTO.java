package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Collections;

public class PageContentDTO {
	@JSONField(name = "total")
	private int total;
	
	@JSONField(name = "content")
	private Object content;
	
	public static PageContentDTO emptyInstance() {
		return new PageContentDTO(0,Collections.emptyList());
	}

	public PageContentDTO() {
    }

    public PageContentDTO(int total, Object content) {
		super();
		this.total = total;
		this.content = content;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	
}
