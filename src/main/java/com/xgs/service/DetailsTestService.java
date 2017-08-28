package com.xgs.service;

import java.util.List;

import com.xgs.entity.Alarminfo;
import com.xgs.entity.Behavior;
import com.xgs.entity.Createthread;
import com.xgs.entity.FileSysteminfo;
import com.xgs.entity.Module;
import com.xgs.entity.Netinfo;
import com.xgs.entity.Pendingthread;
import com.xgs.entity.Processoperation;
import com.xgs.entity.Recoverthread;
import com.xgs.entity.Reginfo;
import com.xgs.entity.Setregvaluekey;
import com.xgs.util.TerResult;

public interface DetailsTestService {
	// 文件操作详情
	public TerResult<List<FileSysteminfo>> loadFileSysteminfo(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<FileSysteminfo>> loadFileSysteminfoByElements(
			int pageNum,int pageSize,Integer uniqueId,Integer opType,Integer removable,
			String filePath,String processName,String processPath,String time);
	// 文件map操作详情
	public TerResult<List<FileSysteminfo>> loadFileSystemMapinfo(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<FileSysteminfo>> loadFileSystemMapinfoByElements(
			int pageNum,int pageSize,Integer uniqueId,Integer opType,Integer removable,
			String filePath,String processName,String processPath,String time);
	// 网络使用信息
	public TerResult<List<Netinfo>> loadNetinfo(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Netinfo>> loadNetinfoByElements(int pageNum,int pageSize,
			Integer uniqueId,Integer opType,String processName,Integer dataProtocol,String time);
	// 注册表基本信息
	public TerResult<List<Reginfo>> loadReginfo(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Reginfo>> loadReginfoByElements(int pageNum,int pageSize,
			Integer uniqueId,Integer opType,String processName,Integer processId,String regPath,String time);
	// 注册表赋值操作
	public TerResult<List<Setregvaluekey>> loadSetregvaluekey(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Setregvaluekey>> loadSetregvaluekeyByElements(int pageNum,int pageSize,
			Integer uniqueId,String processName,Integer processID,String keyValue,String regPath,String time);
	// 进程操作信息
	public TerResult<List<Processoperation>> loadProcessoperation(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Processoperation>> loadProcessoperationByElements(int pageNum,int pageSize,
			Integer uniqueId,Integer opType,String currentProcessName,Integer currentProcessID,
			String objectProcessName,Integer objectProcessID,String time);
	// 进程操作线程信息
	public TerResult<List<Createthread>> loadCreatethread(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Createthread>> loadCreatethreadByElements(int pageNum,int pageSize,
			Integer uniqueId,String currentProcessName,Integer currentProcessID,
			String targetProcessName,Integer targetProcessID,String threadHandle,String time);
	// 挂起线程操作信息
	public TerResult<List<Pendingthread>> loadPendingthread(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Pendingthread>> loadPendingthreadByElements(int pageNum,int pageSize,Integer uniqueId,
			String currentProcessName,Integer currentProcessID,String dependProcessName,String dependProcessID,
			String pendingProcessID,String time);
	// 恢复线程操作信息
	public TerResult<List<Recoverthread>> loadRecoverthread(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Recoverthread>> loadRecoverthreadByElements(int pageNum,int pageSize,Integer uniqueId,
			String currentProcessName,Integer currentProcessID,String dependProcessName,String dependProcessID,
			String pendingProcessID,String time);
	// 模块操作
	public TerResult<List<Module>> loadModule(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Module>> loadModuleByElements(int pageNum,int pageSize,Integer uniqueId,Integer opType,
			String processName,Integer processNum,String regeditName,String time);
	// 告警信息
	public TerResult<List<Alarminfo>> loadAlarminfo(int pageNum,int pageSize,Integer uniqueId);
	public TerResult<List<Alarminfo>> loadAlarminfoByElements(int pageNum,int pageSize,Integer uniqueId,Integer type,
			String processName,String path,String explain1,String explain2,String time);
	// 样本检测报告
	public TerResult<List<Behavior>> loadBehavior();
}
