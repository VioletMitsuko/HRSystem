package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

	// 总记录条数
	private int totalItems;
	// 当前页码
	private int curPage;
	// 总页数
	private int totalPages;
	// 每页显示的记录
	private List<T> list;

	public PageBean() {
		super();
	}

	public PageBean(int totalItems, int curPage, int totalPages, List<T> list) {
		super();
		this.totalItems = totalItems;
		this.curPage = curPage;
		this.totalPages = totalPages;
		this.list = list;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<T> getList() {
		return list;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [totalItems=" + totalItems + ", curPage=" + curPage + ", totalPages=" + totalPages + ", list="
				+ list + "]";
	}

}
