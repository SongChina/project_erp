package com.cskaoyan.vo;

/**
 * Created by little Stone
 * Date 2019/6/17 Time 16:51
 */
public class COrderResponseVo<T> {
	T rows;
	int total;

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
