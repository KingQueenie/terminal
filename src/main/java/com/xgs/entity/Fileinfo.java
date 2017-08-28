package com.xgs.entity;

import java.io.Serializable;

public class Fileinfo implements Serializable{
	private int id;
	private File_alertsystembase_uniqueid file_alertsystembase_uniqueid;
	private String username;
	private String fileName;
	private String filePath;
	private String state;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public File_alertsystembase_uniqueid getFile_alertsystembase_uniqueid() {
		return file_alertsystembase_uniqueid;
	}
	public void setFile_alertsystembase_uniqueid(File_alertsystembase_uniqueid file_alertsystembase_uniqueid) {
		this.file_alertsystembase_uniqueid = file_alertsystembase_uniqueid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
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
		return "Fileinfo [id=" + id + ", file_alertsystembase_uniqueid=" + file_alertsystembase_uniqueid + ", username="
				+ username + ", fileName=" + fileName + ", filePath=" + filePath + ", state=" + state + ", time=" + time
				+ "]";
	}
}
