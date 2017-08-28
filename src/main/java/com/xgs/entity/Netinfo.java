package com.xgs.entity;

import java.io.Serializable;

public class Netinfo implements Serializable{
	private Integer id;
	private Integer uniqueId;
	private Integer internetProtocol;
	private Integer opType;
	private Integer dataProtocol;
	private String localIP;
	private Integer localPort;
	private String remoteIP;
	private Integer remotePort;
	private String processName;
	private String processPath;
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
	public Integer getInternetProtocol() {
		return internetProtocol;
	}
	public void setInternetProtocol(Integer internetProtocol) {
		this.internetProtocol = internetProtocol;
	}
	public Integer getOpType() {
		return opType;
	}
	public void setOpType(Integer opType) {
		this.opType = opType;
	}
	public Integer getDataProtocol() {
		return dataProtocol;
	}
	public void setDataProtocol(Integer dataProtocol) {
		this.dataProtocol = dataProtocol;
	}
	public String getLocalIP() {
		return localIP;
	}
	public void setLocalIP(String localIP) {
		this.localIP = localIP;
	}
	public Integer getLocalPort() {
		return localPort;
	}
	public void setLocalPort(Integer localPort) {
		this.localPort = localPort;
	}
	public String getRemoteIP() {
		return remoteIP;
	}
	public void setRemoteIP(String remoteIP) {
		this.remoteIP = remoteIP;
	}
	public Integer getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(Integer remotePort) {
		this.remotePort = remotePort;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Netinfo [id=" + id + ", uniqueId=" + uniqueId + ", internetProtocol=" + internetProtocol + ", opType="
				+ opType + ", dataProtocol=" + dataProtocol + ", localIP=" + localIP + ", localPort=" + localPort
				+ ", remoteIP=" + remoteIP + ", remotePort=" + remotePort + ", processName=" + processName
				+ ", processPath=" + processPath + ", time=" + time + "]";
	}
}
