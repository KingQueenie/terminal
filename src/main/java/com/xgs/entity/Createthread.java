package com.xgs.entity;

import java.io.Serializable;

public class Createthread implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer currentProcessID;
	private String currentProcessName;
	private String threadHandle;
	private Integer targetProcessID;
	private String targetProcessName;
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
	public String getThreadHandle() {
		return threadHandle;
	}
	public void setThreadHandle(String threadHandle) {
		this.threadHandle = threadHandle;
	}
	public Integer getTargetProcessID() {
		return targetProcessID;
	}
	public void setTargetProcessID(Integer targetProcessID) {
		this.targetProcessID = targetProcessID;
	}
	public String getTargetProcessName() {
		return targetProcessName;
	}
	public void setTargetProcessName(String targetProcessName) {
		this.targetProcessName = targetProcessName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Createthread [id=" + id + ", uniqueId=" + uniqueId + ", currentProcessID=" + currentProcessID
				+ ", currentProcessName=" + currentProcessName + ", threadHandle=" + threadHandle + ", targetProcessID="
				+ targetProcessID + ", targetProcessName=" + targetProcessName + ", time=" + time + "]";
	}

}
