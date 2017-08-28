package com.xgs.entity;

import java.io.Serializable;

public class Module implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer opType;
	private Integer processNum;
	private String processName;
	private String regeditName;
	private String time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Integer getOpType() {
		return opType;
	}
	public void setOpType(Integer opType) {
		this.opType = opType;
	}
	public Integer getProcessNum() {
		return processNum;
	}
	public void setProcessNum(Integer processNum) {
		this.processNum = processNum;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getRegeditName() {
		return regeditName;
	}
	public void setRegeditName(String regeditName) {
		this.regeditName = regeditName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", uniqueId=" + uniqueId + ", opType=" + opType + ", processNum=" + processNum
				+ ", processName=" + processName + ", regeditName=" + regeditName + ", time=" + time + "]";
	}
}
