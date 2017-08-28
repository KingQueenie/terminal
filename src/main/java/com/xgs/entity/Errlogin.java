package com.xgs.entity;

import java.sql.Timestamp;

public class Errlogin {
	private Integer id;
	private String ip_addr;
	private String login_time;
	private String username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp_addr() {
		return ip_addr;
	}
	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Errlogin [id=" + id + ", ip_addr=" + ip_addr + ", login_time=" + login_time + ", username=" + username
				+ "]";
	}
	
}
