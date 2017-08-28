package com.xgs.entity;

import java.io.Serializable;

public class File_alertsystembase_uniqueid implements Serializable{
	private String file_uniqueid;
	private String alertsystembase_uniqueid;
	public String getFile_uniqueid() {
		return file_uniqueid;
	}
	public void setFile_uniqueid(String file_uniqueid) {
		this.file_uniqueid = file_uniqueid;
	}
	public String getAlertsystembase_uniqueid() {
		return alertsystembase_uniqueid;
	}
	public void setAlertsystembase_uniqueid(String alertsystembase_uniqueid) {
		this.alertsystembase_uniqueid = alertsystembase_uniqueid;
	}
	@Override
	public String toString() {
		return "File_alertsystembase_uniqueid [file_uniqueid=" + file_uniqueid
				+ ", alertsystembase_uniqueid=" + alertsystembase_uniqueid + "]";
	}
	
}
