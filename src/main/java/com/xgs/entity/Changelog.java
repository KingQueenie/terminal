package com.xgs.entity;

import java.io.Serializable;

public class Changelog implements Serializable{
	private int id;
	private int uniqueid;
	private String table_name;
	private int table_id;
	private String content;
	private String process_time;
	private String user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(int uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getProcess_time() {
		return process_time;
	}
	public void setProcess_time(String process_time) {
		this.process_time = process_time;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Changelog [id=" + id + ", uniqueid=" + uniqueid + ", table_name=" + table_name + ", table_id="
				+ table_id + ", content=" + content + ", process_time=" + process_time + ", user=" + user + "]";
	}
}
