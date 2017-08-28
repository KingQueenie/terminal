package com.xgs.entity;

import java.io.Serializable;

public class Config implements Serializable{
	private Integer type;
	private String description;
	private String value;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Config [type=" + type + ", description=" + description + ", value=" + value + "]";
	}
}
