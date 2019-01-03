package com.questionaire.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.pojo.dto.BaseDTO;
import org.springframework.util.StringUtils;


public class BasePageRequest extends BaseDTO {
	
	@JSONField(name = "page_no")
	private int pageNo = 1;
	
	@JSONField(name = "page_size")
	private int pageSize = 10;
	
	@JSONField(name = "sort_field")
	private String sortField = "id";
	
	@JSONField(name = "order")
	private String order = "desc";
	
	protected int getPageStart(){
		return (pageNo-1)*pageSize;
	}



	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = StringUtils.isEmpty(sortField) ? "id" : sortField;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo < 1 ? 1 : pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize < 1 ? 1 : pageSize;
	}

	@Override
	public String toString() {
		return "BasePageRequest{" +
				"pageNo=" + pageNo +
				", pageSize=" + pageSize +
				", sortField='" + sortField + '\'' +
				", order='" + order + '\'' +
				", createdAt=" + createdAt +
				", createdBy='" + createdBy + '\'' +
				", updatedAt=" + updatedAt +
				", updatedBy='" + updatedBy + '\'' +
				", pageNo=" + pageNo +
				", pageSize=" + pageSize +
				'}';
	}
}
