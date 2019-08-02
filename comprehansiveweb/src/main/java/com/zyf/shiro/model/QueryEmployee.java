package com.zyf.shiro.model;

public class QueryEmployee {
	private String employeeName;
	private Integer levelCode;
	private Integer partCode;
	private Integer page=1;//默认第1页
	private Integer rows=2;//每页2条
	private Integer last;//上一页
	private Integer next;//下一页
	private Integer pageCounts;//总页数
	private Integer start;//从第几条开始
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(Integer levelCode) {
		this.levelCode = levelCode;
	}
	public Integer getPartCode() {
		return partCode;
	}
	public void setPartCode(Integer partCode) {
		this.partCode = partCode;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Integer getPageCounts() {
		return pageCounts;
	}
	public void setPageCounts(Integer pageCounts) {
		this.pageCounts = pageCounts;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	
}
