package com.xgs.entity;

import java.io.Serializable;

public class Processoperation implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer currentProcessID;
	private String currentProcessName;
	private Integer opType;
	private Integer objectProcessID;
	private String objectProcessName;
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
	public Integer getCurrentProcessID() {
		return currentProcessID;
	}
	public void setCurrentProcessID(Integer currentProcessID) {
		this.currentProcessID = currentProcessID;
	}
	public String getCurrentProcessName() {
		return currentProcessName;
	}
	public void setCurrentProcessName(String currentProcessName) {
		this.currentProcessName = currentProcessName;
	}
	public Integer getOpType() {
		return opType;
	}
	public void setOpType(Integer opType) {
		this.opType = opType;
	}
	public Integer getObjectProcessID() {
		return objectProcessID;
	}
	public void setObjectProcessID(Integer objectProcessID) {
		this.objectProcessID = objectProcessID;
	}
	public String getObjectProcessName() {
		return objectProcessName;
	}
	public void setObjectProcessName(String objectProcessName) {
		this.objectProcessName = objectProcessName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Processoperation [id=" + id + ", uniqueId=" + uniqueId + ", currentProcessID=" + currentProcessID
				+ ", currentProcessName=" + currentProcessName + ", opType=" + opType + ", objectProcessID="
				+ objectProcessID + ", objectProcessName=" + objectProcessName + ", time=" + time + "]";
	}
}
