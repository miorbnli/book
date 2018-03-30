package com.book.common.util;

import java.util.List;

/**
 * 分頁工具類
 * @author LiYuanbin
 * @param <T>
 */
public class PageObject<T> {
	/** 当前页的记录 */
	private List<T> records;
	/** 总页数(计算) */
	private int pageCount;
	/** 总记录数(从数据库获取) */
	private int rowCount;
	/** 当前页的页码(从页面获取) */
	private int pageCurrent;

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

}
