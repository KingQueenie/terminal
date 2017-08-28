package com.xgs.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Login implements Serializable{
	private String username;
	private String pwd;
	private String type;
	private int flag;
	private int group;
	private String last_change;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public String getLast_change() {
		return last_change;
	}
	public void setLast_change(String last_change) {
		this.last_change = last_change;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", pwd=" + pwd + ", type=" + type + ", flag=" + flag + ", group=" + group
				+ ", last_change=" + last_change + "]";
	}
	
}
