package com.xgs.entity;

import java.io.Serializable;

public class FileSysteminfo implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer opType;
	private Integer removable;
	private String filePath;
	private String processName;
	private String processPath;
	private Integer state;
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
	public Integer getRemovable() {
		return removable;
	}
	public void setRemovable(Integer removable) {
		this.removable = removable;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcessPath() {
		return processPath;
	}
	public void setProcessPath(String processPath) {
		this.processPath = processPath;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "FileSysteminfo [id=" + id + ", uniqueId=" + uniqueId + ", opType=" + opType + ", removable=" + removable
				+ ", filePath=" + filePath + ", processName=" + processName + ", processPath=" + processPath
				+ ", state=" + state + ", time=" + time + "]";
	}
	
}
