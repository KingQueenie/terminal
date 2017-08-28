package com.xgs.entity;

import java.io.Serializable;

public class Reginfo implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer processId;
	private String processName;
	private String regPath;
	private Integer opType;
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
	public Integer getProcessId() {
		return processId;
	}
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getRegPath() {
		return regPath;
	}
	public void setRegPath(String regPath) {
		this.regPath = regPath;
	}
	public Integer getOpType() {
		return opType;
	}
	public void setOpType(Integer opType) {
		this.opType = opType;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Reginfo [id=" + id + ", uniqueId=" + uniqueId + ", processId=" + processId + ", processName="
				+ processName + ", regPath=" + regPath + ", opType=" + opType + ", time=" + time + "]";
	}
}
