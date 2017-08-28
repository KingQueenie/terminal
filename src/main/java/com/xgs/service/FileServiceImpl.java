package com.xgs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xgs.dao.FileDao;
import com.xgs.entity.File_alertsystembase_uniqueid;
import com.xgs.entity.Fileinfo;
import com.xgs.util.TerResult;

@Service("fileService")
public class FileServiceImpl implements FileService{
	@Resource
	FileDao dao;
	public TerResult<List<Fileinfo>> loadFiles(int pageNum,int pageSize,String username) {
		TerResult<List<Fileinfo>> result = new TerResult<List<Fileinfo>>();
		int start = pageSize*(pageNum-1);
		List<Fileinfo> list = dao.findFileByPageAndUser(start, pageSize, username);
		Integer cnt=dao.countFile(username);
		result.setStatus(0);
		result.setMsg("查询文件信息成功");
		result.setExData(cnt);
		result.setData(list);
		return result;
	}
	public TerResult<Object> changeState(String file_uniqueid, String stateValue, String alertsystembase_uniqueid) {
		String state="";
		int cnt=1;
		TerResult<Object> result=new TerResult<Object>();
		cnt =dao.countFileUniqueid(file_uniqueid);
		if(cnt==0) {
			result.setStatus(1);
			result.setMsg("文件不存在，请重新输入");
			return result;
		}
		File_alertsystembase_uniqueid fau=dao.findFileSystemUniqueid(file_uniqueid);
		if(stateValue.equals("1")) {
			state="已检测";
			if(fau==null) {
				File_alertsystembase_uniqueid fau1=new File_alertsystembase_uniqueid();
				fau1.setFile_uniqueid(file_uniqueid);
				fau1.setAlertsystembase_uniqueid(alertsystembase_uniqueid);
				dao.addUniqueid(fau1);
			} else {
				fau.setAlertsystembase_uniqueid(alertsystembase_uniqueid);
				dao.modifyAlertsystembaseUniqueid(fau);
			}
		} else {
			state="未检测";
			if(!(fau==null)) {
				dao.deleteAlertsystembaseUniqueid(fau);
			}
		}
		dao.modifyFileinfo(state, file_uniqueid);
		result.setStatus(0);
		result.setMsg("修改状态成功");
		return result;
	}
	public TerResult<Object> addFile(String uniqueid,String username,String filename,String filepath,String state,String time) {
		TerResult<Object> result = new TerResult<Object>();
		dao.saveFile(uniqueid, username, filename, filepath, state, time);
		result.setStatus(0);
		result.setMsg("插入文件成功");
		return result;
	}
	public TerResult<Object> removeFile(Integer id) {
		TerResult<Object> result = new TerResult<Object>();
		Fileinfo fileinfo =dao.findFileById(id);
		dao.deleteFileById(id);
		if(fileinfo.getState().equals("已检测")) { //若删除已检测的文件，同时删除表file_alertsystembase_uniqueid中的数据
			String file_uniqueid=fileinfo.getFile_alertsystembase_uniqueid().getFile_uniqueid();
			String alertsystembase_uniqueid=fileinfo.getFile_alertsystembase_uniqueid().getAlertsystembase_uniqueid();
			File_alertsystembase_uniqueid file_alertsystembase_uniqueid=new File_alertsystembase_uniqueid();
			file_alertsystembase_uniqueid.setFile_uniqueid(file_uniqueid);
			file_alertsystembase_uniqueid.setAlertsystembase_uniqueid(alertsystembase_uniqueid);
			dao.deleteAlertsystembaseUniqueid(file_alertsystembase_uniqueid);
		}
		result.setStatus(0);
		result.setMsg("删除文件成功");
		return result;
	}
}
