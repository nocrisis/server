package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

public class PageableRequestDTO {
	@JSONField(name = "page_no")
    private Integer pageNo ;  //分页页码
	
    @JSONField(name = "page_size")
    private Integer pageSize ;//分页每一页数量

	@JSONField(name = "page_start")
	private Integer pageStart;// 分页开始页数量

	@JSONField(name = "sort_key")
    private String sortKey;//排序字段
    
    @JSONField(name = "sort_order")
    private String sortOrder;//正序还是倒叙 asc/desc
    
	public int getPageStartOffset() {
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize < 0) {
			pageSize = 20;
		}
		return (pageNo - 1) * pageSize;
	}
	
	public boolean isSort() {
        return StringUtils.isNotBlank(sortKey);
    }
    
	public boolean isPageable() {
        return null != pageNo && null != pageSize;
    }
    
	public Integer getPageNo() {
	    if(null == pageNo){
	        return pageNo;
	    }
	    if(pageNo == 0){
	        return 1;
	    }
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortKey() {
		return sortKey;
	}
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}
}
