package com.xgs.util;

import java.io.Serializable;

public class TerResult<T> implements Serializable {
	private int status;
	private String msg;
	private Integer exData;//存储额外数据
	private T data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getExData() {
		return exData;
	}
	public void setExData(Integer exData) {
		this.exData = exData;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "TerResult [status=" + status + ", msg=" + msg + ", exData=" + exData + ", data=" + data + "]";
	}
	
}
