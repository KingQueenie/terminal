package com.xgs.entity;

import java.io.Serializable;

public class Behavior implements Serializable{
	private Integer id;
	private Integer pid;
	private String name;
	private String description;
	private String type;
	private String time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Behavior [id=" + id + ", pid=" + pid + ", name=" + name + ", description=" + description + ", type="
				+ type + ", time=" + time + "]";
	}
	
}
