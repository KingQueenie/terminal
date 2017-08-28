package com.xgs.entity;

import java.io.Serializable;

public class Alarminfo implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer Type;
	private String ProcessName;
	private String Path;
	private String Explain1;
	private String Explain2;
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
	public Integer getType() {
		return Type;
	}
	public void setType(Integer type) {
		Type = type;
	}
	public String getProcessName() {
		return ProcessName;
	}
	public void setProcessName(String processName) {
		ProcessName = processName;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getExplain1() {
		return Explain1;
	}
	public void setExplain1(String explain1) {
		Explain1 = explain1;
	}
	public String getExplain2() {
		return Explain2;
	}
	public void setExplain2(String explain2) {
		Explain2 = explain2;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Alarminfo [id=" + id + ", uniqueId=" + uniqueId + ", Type=" + Type + ", ProcessName=" + ProcessName
				+ ", Path=" + Path + ", Explain1=" + Explain1 + ", Explain2=" + Explain2 + ", time=" + time + "]";
	}
}
