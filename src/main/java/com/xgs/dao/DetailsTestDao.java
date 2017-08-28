package com.xgs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

public interface DetailsTestDao {
	//文件操作详情
	public List<FileSysteminfo> findFileSysteminfoByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countFileSystem(Integer uniqueId);
	public List<FileSysteminfo> findFileSysteminfoByElements(int start,int pageSize,
			Integer uniqueId,@Param("opType")Integer opType,@Param("removable")Integer removable,
			@Param("filePath")String filePath,@Param("processName")String processName,
			@Param("processPath")String processPath,@Param("time")String time);
	public int countFileSysteminfoByElements(Integer uniqueId,@Param("opType")Integer opType,@Param("removable")Integer removable,
			@Param("filePath")String filePath,@Param("processName")String processName,
			@Param("processPath")String processPath,@Param("time")String time);
	//文件map操作详情
	public List<FileSysteminfo> findFileSystemMapinfoByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countFileSystemMap(Integer uniqueId);
	public List<FileSysteminfo> findFileSystemMapinfoByElements(int start,int pageSize,
			Integer uniqueId,@Param("opType")Integer opType,@Param("removable")Integer removable,
			@Param("filePath")String filePath,@Param("processName")String processName,
			@Param("processPath")String processPath,@Param("time")String time);
	public int countFileSystemMapinfoByElements(Integer uniqueId,@Param("opType")Integer opType,@Param("removable")Integer removable,
			@Param("filePath")String filePath,@Param("processName")String processName,
			@Param("processPath")String processPath,@Param("time")String time);
	//网络使用信息
	public List<Netinfo> findNetinfoByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countNetinfo(Integer uniqueId);
	public List<Netinfo> findNetinfoByElements(int start,int pageSize,
			Integer uniqueId,@Param("opType")Integer opType,@Param("processName")String processName,
			@Param("dataProtocol")Integer dataProtocol,@Param("time")String time);
	public int countNetinfoByElements(Integer uniqueId,@Param("opType")Integer opType,
			@Param("processName")String processName,@Param("dataProtocol")Integer dataProtocol,@Param("time")String time);
	// 注册表基本信息
	public List<Reginfo> findReginfoByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countReginfo(Integer uniqueId);
	public List<Reginfo> findReginfoByElements(int start,int pageSize,
			Integer uniqueId,@Param("opType")Integer opType,@Param("processName")String processName,
			@Param("processId")Integer processId,@Param("regPath")String regPath,@Param("time")String time);
	public int countReginfoByElements(Integer uniqueId,@Param("opType")Integer opType,
			@Param("processName")String processName,@Param("processId")Integer processId,
			@Param("regPath")String regPath,@Param("time")String time);
	// 注册表赋值操作
	public List<Setregvaluekey> findSetregvaluekeyByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countSetregvaluekey(Integer uniqueId);
	public List<Setregvaluekey> findSetregvaluekeyByElements(int start,int pageSize,
			Integer uniqueId,@Param("processName")String processName,@Param("processID")Integer processID,
			@Param("keyValue")String keyValue,@Param("regPath")String regPath,@Param("time")String time);
	public int countSetregvaluekeyByElements(Integer uniqueId,@Param("processName")String processName,@Param("processID")Integer processID,
			@Param("keyValue")String keyValue,@Param("regPath")String regPath,@Param("time")String time);
	// 进程操作信息
	public List<Processoperation> findProcessoperationByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countProcessoperation(Integer uniqueId);
	public List<Processoperation> findProcessoperationByElements(int start,int pageSize,
			Integer uniqueId,@Param("opType")Integer opType,@Param("currentProcessName")String currentProcessName,
			@Param("currentProcessID")Integer currentProcessID,@Param("objectProcessName")String objectProcessName,
			@Param("objectProcessID")Integer objectProcessID,@Param("time")String time);
	public int countProcessoperationByElements(Integer uniqueId,@Param("opType")Integer opType,
			@Param("currentProcessName")String currentProcessName,@Param("currentProcessID")Integer currentProcessID,
			@Param("objectProcessName")String objectProcessName,@Param("objectProcessID")Integer objectProcessID,@Param("time")String time);
	// 进程操作线程信息
	public List<Createthread> findCreatethreadByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countCreatethread(Integer uniqueId);
	public List<Createthread> findCreatethreadByElements(int start,int pageSize,
			Integer uniqueId,@Param("currentProcessName")String currentProcessName,
			@Param("currentProcessID")Integer currentProcessID,@Param("targetProcessName")String targetProcessName,
			@Param("targetProcessID")Integer targetProcessID,@Param("threadHandle")String threadHandle,@Param("time")String time);
	public int countCreatethreadByElements(Integer uniqueId,@Param("currentProcessName")String currentProcessName,
			@Param("currentProcessID")Integer currentProcessID,@Param("targetProcessName")String targetProcessName,
			@Param("targetProcessID")Integer targetProcessID,@Param("threadHandle")String threadHandle,@Param("time")String time);
	// 挂起线程操作信息
	public List<Pendingthread> findPendingthreadByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countPendingthread(Integer uniqueId);
	public List<Pendingthread> findPendingthreadByElements(int start,int pageSize,
			Integer uniqueId,@Param("currentProcessName")String currentProcessName,@Param("currentProcessID")Integer currentProcessID,
			@Param("dependProcessName")String dependProcessName,@Param("dependProcessID")String dependProcessID,
			@Param("pendingProcessID")String pendingProcessID,@Param("time")String time);
	public int countPendingthreadByElements(Integer uniqueId,@Param("currentProcessName")String currentProcessName,@Param("currentProcessID")Integer currentProcessID,
			@Param("dependProcessName")String dependProcessName,@Param("dependProcessID")String dependProcessID,
			@Param("pendingProcessID")String pendingProcessID,@Param("time")String time);
	// 恢复线程操作信息
	public List<Recoverthread> findRecoverthreadByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countRecoverthread(Integer uniqueId);
	public List<Recoverthread> findRecoverthreadByElements(int start,int pageSize,
			Integer uniqueId,@Param("currentProcessName")String currentProcessName,@Param("currentProcessID")Integer currentProcessID,
			@Param("dependProcessName")String dependProcessName,@Param("dependProcessID")String dependProcessID,
			@Param("pendingProcessID")String pendingProcessID,@Param("time")String time);
	public int countRecoverthreadByElements(Integer uniqueId,@Param("currentProcessName")String currentProcessName,@Param("currentProcessID")Integer currentProcessID,
			@Param("dependProcessName")String dependProcessName,@Param("dependProcessID")String dependProcessID,
			@Param("pendingProcessID")String pendingProcessID,@Param("time")String time);
	// 模块操作
	public List<Module> findModuleByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countModule(Integer uniqueId);
	public List<Module> findModuleByElements(int start,int pageSize,Integer uniqueId,@Param("opType")Integer opType,
			@Param("processName")String processName,@Param("processNum")Integer processNum,@Param("regeditName")String regeditName,@Param("time")String time);
	public int countModuleByElements(Integer uniqueId,@Param("opType")Integer opType,@Param("processName")String processName,
			@Param("processNum")Integer processNum,@Param("regeditName")String regeditName,@Param("time")String time);
	// 告警信息
	public List<Alarminfo> findAlarminfoByUniqueId(int start,int pageSize,Integer uniqueId);
	public int countAlarminfo(Integer uniqueId);
	public List<Alarminfo> findAlarminfoByElements(int start,int pageSize,Integer uniqueId,@Param("type")Integer type,
			@Param("processName")String processName,@Param("path")String path,@Param("explain1")String explain1,
			@Param("explain2")String explain2,@Param("time")String time);
	public int countAlarminfoByElements(Integer uniqueId,@Param("type")Integer type,@Param("processName")String processName,
			@Param("path")String path,@Param("explain1")String explain1,@Param("explain2")String explain2,@Param("time")String time);
	// 样本检测报告
	public List<Behavior> findBehavior();
	public int countBehavior();
	
}
