package com.address.entity;

import java.util.List;

/**
 * 分页实体类
 */
public class PagingResult<T> {
	private Integer pageNo=1;//当前页
	private Integer pageCount;//总页数
	private Integer pageSize=15;//页大小
	private Integer rowCount;//记录总数
	private List<T> data;//数据
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageCount() {
		return (rowCount-1)/pageSize+1;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
	//计算
	public Integer getFirstResult(){
		return (pageNo-1)*pageSize;
	}
}
