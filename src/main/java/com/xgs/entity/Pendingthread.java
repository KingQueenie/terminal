package com.xgs.entity;

import java.io.Serializable;

public class Pendingthread implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer currentProcessID;
	private String currentProcessName;
	private String pendingProcessID;
	private String dependProcessID;
	private String dependProcessName;
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
	public String getPendingProcessID() {
		return pendingProcessID;
	}
	public void setPendingProcessID(String pendingProcessID) {
		this.pendingProcessID = pendingProcessID;
	}
	public String getDependProcessID() {
		return dependProcessID;
	}
	public void setDependProcessID(String dependProcessID) {
		this.dependProcessID = dependProcessID;
	}
	public String getDependProcessName() {
		return dependProcessName;
	}
	public void setDependProcessName(String dependProcessName) {
		this.dependProcessName = dependProcessName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Pendingthread [id=" + id + ", uniqueId=" + uniqueId + ", currentProcessID=" + currentProcessID
				+ ", currentProcessName=" + currentProcessName + ", pendingProcessID=" + pendingProcessID
				+ ", dependProcessID=" + dependProcessID + ", dependProcessName=" + dependProcessName + ", time=" + time
				+ "]";
	}
}
