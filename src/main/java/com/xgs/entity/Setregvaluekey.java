package com.xgs.entity;

import java.io.Serializable;

public class Setregvaluekey implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer processID;
	private String processName;
	private String keyValue;
	private Integer dataType;
	private Integer dataSize;
	private String regPath;
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
	public Integer getProcessID() {
		return processID;
	}
	public void setProcessID(Integer processID) {
		this.processID = processID;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public Integer getDataSize() {
		return dataSize;
	}
	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}
	public String getRegPath() {
		return regPath;
	}
	public void setRegPath(String regPath) {
		this.regPath = regPath;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Setregvaluekey [id=" + id + ", uniqueId=" + uniqueId + ", processID=" + processID + ", processName="
				+ processName + ", keyValue=" + keyValue + ", dataType=" + dataType + ", dataSize=" + dataSize
				+ ", regPath=" + regPath + ", time=" + time + "]";
	}
}
