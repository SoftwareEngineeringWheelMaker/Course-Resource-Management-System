package com.course.vo;

import java.util.List;

import jdk.management.resource.internal.TotalResourceContext;

public class Page<T> {
	private int pageNo;// 当前页码
	private int pagesize;// 每页记录数
	private int totalRecords;// 总记录数
	private List<T> list;// 结果集

	/**
	 * 总页数
	 */
	public int getTotalPages() {
		return (totalRecords + pagesize - 1) / pagesize;
	}

	/**
	 * 取得第一页
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 取得上一页
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}

	/**
	 * 取得下一页
	 */
	public int getNextPageNo() {
		if (pageNo >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return pageNo + 1;
	}

	/**
	 * 取得最后一页
	 */
	public int getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}