package com.xgs.service;

import java.util.List;

import com.xgs.entity.Fileinfo;
import com.xgs.util.TerResult;

public interface FileService {
	public TerResult<List<Fileinfo>> loadFiles(int pageNum,int pageSize,String username);
	public TerResult<Object> changeState(String file_uniqueid,String stateValue,String alertsystembase_uniqueid);
	public TerResult<Object> addFile(String uniqueid,String username,String filename,String filepath,String state,String time);
	public TerResult<Object> removeFile(Integer id);
}
