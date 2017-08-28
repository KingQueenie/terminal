package com.xgs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xgs.dao.DetailsTestDao;
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
@Service("detailsTestService")
public class DetailsTestServiceImpl implements DetailsTestService{
	@Resource
	DetailsTestDao dao;
	// 文件操作详情
	public TerResult<List<FileSysteminfo>> loadFileSysteminfo(int pageNum,int pageSize,Integer uniqueId) {
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		int start = pageSize*(pageNum-1);
		List<FileSysteminfo> list = dao.findFileSysteminfoByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countFileSystem(uniqueId);
		result.setStatus(0);
		result.setMsg("查询文件操作详情信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<FileSysteminfo>> loadFileSysteminfoByElements(
			int pageNum, int pageSize, Integer uniqueId,Integer opType, Integer removable, 
			String filePath, String processName, String processPath, String time) {
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		int start = pageSize*(pageNum-1);
		List<FileSysteminfo> list = dao.findFileSysteminfoByElements(start, pageSize, uniqueId, opType, removable, filePath, processName, processPath, time);
		int cnt=dao.countFileSysteminfoByElements(uniqueId, opType, removable, filePath, processName, processPath, time);
		result.setStatus(0);
		result.setMsg("查询文件操作详情信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 文件map操作详情
	public TerResult<List<FileSysteminfo>> loadFileSystemMapinfo(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		int start = pageSize*(pageNum-1);
		List<FileSysteminfo> list = dao.findFileSystemMapinfoByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countFileSystemMap(uniqueId);
		result.setStatus(0);
		result.setMsg("查询文件map操作详情信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<FileSysteminfo>> loadFileSystemMapinfoByElements(int pageNum, int pageSize, Integer uniqueId,
			Integer opType, Integer removable, String filePath, String processName, String processPath, String time) {
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		int start = pageSize*(pageNum-1);
		List<FileSysteminfo> list = dao.findFileSystemMapinfoByElements(start, pageSize, uniqueId, opType, removable, filePath, processName, processPath, time);
		int cnt=dao.countFileSystemMapinfoByElements(uniqueId, opType, removable, filePath, processName, processPath, time);
		result.setStatus(0);
		result.setMsg("查询文件map操作详情信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 网络使用信息
	public TerResult<List<Netinfo>> loadNetinfo(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Netinfo>> result=new TerResult<List<Netinfo>>();
		int start = pageSize*(pageNum-1);
		List<Netinfo> list = dao.findNetinfoByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countNetinfo(uniqueId);
		result.setStatus(0);
		result.setMsg("查询网络使用信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Netinfo>> loadNetinfoByElements(int pageNum, int pageSize, Integer uniqueId, Integer opType,
			String processName, Integer dataProtocol, String time) {
		TerResult<List<Netinfo>> result=new TerResult<List<Netinfo>>();
		int start = pageSize*(pageNum-1);
		List<Netinfo> list = dao.findNetinfoByElements(start, pageSize, uniqueId, opType, processName, dataProtocol, time);
		int cnt=dao.countNetinfoByElements(uniqueId, opType, processName, dataProtocol, time);
		result.setStatus(0);
		result.setMsg("查询网络使用信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 注册表基本信息
	public TerResult<List<Reginfo>> loadReginfo(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Reginfo>> result=new TerResult<List<Reginfo>>();
		int start = pageSize*(pageNum-1);
		List<Reginfo> list = dao.findReginfoByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countReginfo(uniqueId);
		result.setStatus(0);
		result.setMsg("查询注册表基本信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Reginfo>> loadReginfoByElements(int pageNum, int pageSize, Integer uniqueId, Integer opType,
			String processName, Integer processId, String regPath, String time) {
		TerResult<List<Reginfo>> result=new TerResult<List<Reginfo>>();
		int start = pageSize*(pageNum-1);
		List<Reginfo> list = dao.findReginfoByElements(start, pageSize, uniqueId, opType, processName, processId, regPath, time);
		int cnt = dao.countReginfoByElements(uniqueId, opType, processName, processId, regPath, time);
		result.setStatus(0);
		result.setMsg("查询注册表基本信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 注册表赋值操作
	public TerResult<List<Setregvaluekey>> loadSetregvaluekey(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Setregvaluekey>> result=new TerResult<List<Setregvaluekey>>();
		int start = pageSize*(pageNum-1);
		List<Setregvaluekey> list = dao.findSetregvaluekeyByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countSetregvaluekey(uniqueId);
		result.setStatus(0);
		result.setMsg("查询注册表赋值操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Setregvaluekey>> loadSetregvaluekeyByElements(int pageNum, int pageSize, Integer uniqueId,
			String processName, Integer processID, String keyValue, String regPath, String time) {
		TerResult<List<Setregvaluekey>> result=new TerResult<List<Setregvaluekey>>();
		int start = pageSize*(pageNum-1);
		List<Setregvaluekey> list = dao.findSetregvaluekeyByElements(start, pageSize, uniqueId, processName, processID, keyValue, regPath, time);
		int cnt = dao.countSetregvaluekeyByElements(uniqueId, processName, processID, keyValue, regPath, time);
		result.setStatus(0);
		result.setMsg("查询注册表赋值操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 进程操作信息
	public TerResult<List<Processoperation>> loadProcessoperation(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Processoperation>> result=new TerResult<List<Processoperation>>();
		int start = pageSize*(pageNum-1);
		List<Processoperation> list = dao.findProcessoperationByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countProcessoperation(uniqueId);
		result.setStatus(0);
		result.setMsg("查询进程操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Processoperation>> loadProcessoperationByElements(int pageNum, int pageSize, Integer uniqueId,
			Integer opType, String currentProcessName, Integer currentProcessID, String objectProcessName,Integer objectProcessID, String time) {
		TerResult<List<Processoperation>> result=new TerResult<List<Processoperation>>();
		int start = pageSize*(pageNum-1);
		List<Processoperation> list = dao.findProcessoperationByElements(start, pageSize, uniqueId, opType, currentProcessName, currentProcessID, objectProcessName, objectProcessID, time);
		int cnt = dao.countProcessoperationByElements(uniqueId, opType, currentProcessName, currentProcessID, objectProcessName, objectProcessID, time);
		result.setStatus(0);
		result.setMsg("查询进程操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 进程操作线程信息
	public TerResult<List<Createthread>> loadCreatethread(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Createthread>> result=new TerResult<List<Createthread>>();
		int start = pageSize*(pageNum-1);
		List<Createthread> list = dao.findCreatethreadByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countCreatethread(uniqueId);
		result.setStatus(0);
		result.setMsg("查询进程操作线程信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Createthread>> loadCreatethreadByElements(int pageNum, int pageSize, Integer uniqueId,
			String currentProcessName, Integer currentProcessID, String targetProcessName, Integer targetProcessID,
			String threadHandle, String time) {
		TerResult<List<Createthread>> result=new TerResult<List<Createthread>>();
		int start = pageSize*(pageNum-1);
		List<Createthread> list = dao.findCreatethreadByElements(start, pageSize, uniqueId, currentProcessName, currentProcessID, targetProcessName, targetProcessID, threadHandle, time);
		int cnt = dao.countCreatethreadByElements(uniqueId, currentProcessName, currentProcessID, targetProcessName, targetProcessID, threadHandle, time);
		result.setStatus(0);
		result.setMsg("查询进程操作线程信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 挂起线程操作信息
	public TerResult<List<Pendingthread>> loadPendingthread(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Pendingthread>> result=new TerResult<List<Pendingthread>>();
		int start = pageSize*(pageNum-1);
		List<Pendingthread> list = dao.findPendingthreadByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countPendingthread(uniqueId);
		result.setStatus(0);
		result.setMsg("查询挂起线程操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Pendingthread>> loadPendingthreadByElements(int pageNum, int pageSize, Integer uniqueId,
			String currentProcessName, Integer currentProcessID, String dependProcessName, String dependProcessID,
			String pendingProcessID, String time) {
		TerResult<List<Pendingthread>> result=new TerResult<List<Pendingthread>>();
		int start = pageSize*(pageNum-1);
		List<Pendingthread> list = dao.findPendingthreadByElements(start, pageSize, uniqueId, currentProcessName, currentProcessID, dependProcessName, dependProcessID, pendingProcessID, time);
		int cnt = dao.countPendingthreadByElements(uniqueId, currentProcessName, currentProcessID, dependProcessName, dependProcessID, pendingProcessID, time);
		result.setStatus(0);
		result.setMsg("查询挂起线程操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 恢复线程操作信息
	public TerResult<List<Recoverthread>> loadRecoverthread(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Recoverthread>> result=new TerResult<List<Recoverthread>>();
		int start = pageSize*(pageNum-1);
		List<Recoverthread> list = dao.findRecoverthreadByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countRecoverthread(uniqueId);
		result.setStatus(0);
		result.setMsg("查询恢复线程操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Recoverthread>> loadRecoverthreadByElements(int pageNum, int pageSize, Integer uniqueId,
			String currentProcessName, Integer currentProcessID, String dependProcessName, String dependProcessID,
			String pendingProcessID, String time) {
		TerResult<List<Recoverthread>> result=new TerResult<List<Recoverthread>>();
		int start = pageSize*(pageNum-1);
		List<Recoverthread> list = dao.findRecoverthreadByElements(start, pageSize, uniqueId, currentProcessName, currentProcessID, dependProcessName, dependProcessID, pendingProcessID, time);
		int cnt = dao.countRecoverthreadByElements(uniqueId, currentProcessName, currentProcessID, dependProcessName, dependProcessID, pendingProcessID, time);
		result.setStatus(0);
		result.setMsg("查询恢复线程操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 模块操作
	public TerResult<List<Module>> loadModule(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Module>> result=new TerResult<List<Module>>();
		int start = pageSize*(pageNum-1);
		List<Module> list = dao.findModuleByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countModule(uniqueId);
		result.setStatus(0);
		result.setMsg("查询模块操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Module>> loadModuleByElements(int pageNum, int pageSize, Integer uniqueId, Integer opType,
			String processName, Integer processNum, String regeditName, String time) {
		TerResult<List<Module>> result=new TerResult<List<Module>>();
		int start = pageSize*(pageNum-1);
		List<Module> list = dao.findModuleByElements(start, pageSize, uniqueId, opType, processName, processNum, regeditName, time);
		int cnt = dao.countModuleByElements(uniqueId, opType, processName, processNum, regeditName, time);
		result.setStatus(0);
		result.setMsg("查询模块操作信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 告警信息
	public TerResult<List<Alarminfo>> loadAlarminfo(int pageNum, int pageSize, Integer uniqueId) {
		TerResult<List<Alarminfo>> result=new TerResult<List<Alarminfo>>();
		int start = pageSize*(pageNum-1);
		List<Alarminfo> list = dao.findAlarminfoByUniqueId(start, pageSize, uniqueId);
		int cnt=dao.countAlarminfo(uniqueId);
		result.setStatus(0);
		result.setMsg("查询告警信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<List<Alarminfo>> loadAlarminfoByElements(int pageNum, int pageSize, Integer uniqueId, Integer type,
			String processName, String path, String explain1, String explain2, String time) {
		TerResult<List<Alarminfo>> result=new TerResult<List<Alarminfo>>();
		int start = pageSize*(pageNum-1);
		List<Alarminfo> list = dao.findAlarminfoByElements(start, pageSize, uniqueId, type, processName, path, explain1, explain2, time);
		int cnt = dao.countAlarminfoByElements(uniqueId, type, processName, path, explain1, explain2, time);
		result.setStatus(0);
		result.setMsg("查询告警信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	// 样本检测报告
	public TerResult<List<Behavior>> loadBehavior() {
		TerResult<List<Behavior>> result=new TerResult<List<Behavior>>();
		List<Behavior> list=dao.findBehavior();
		int cnt=dao.countBehavior();
		result.setStatus(0);
		result.setMsg("查询样本检测报告信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
}
