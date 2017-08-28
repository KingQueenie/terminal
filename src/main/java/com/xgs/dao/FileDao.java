package com.xgs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xgs.entity.File_alertsystembase_uniqueid;
import com.xgs.entity.Fileinfo;

public interface FileDao {
	public List<Fileinfo> findFileByPageAndUser(int start,int pageSize,@Param("username")String username);
	public Integer countFile(@Param("username")String username); 
	public void modifyFileinfo(String state,String file_uniqueid);
	public int countFileUniqueid(String file_uniqueid);
	public void addUniqueid(File_alertsystembase_uniqueid file_alertsystembase_uniqueid);
	public File_alertsystembase_uniqueid findFileSystemUniqueid(String file_uniqueid);
	public void modifyAlertsystembaseUniqueid(File_alertsystembase_uniqueid file_alertsystembase_uniqueid);
	public void deleteAlertsystembaseUniqueid(File_alertsystembase_uniqueid file_alertsystembase_uniqueid);
	public void saveFile(String uniqueid,String username,String filename,String filepath,String state,String time);
	public void deleteFileById(Integer id);
	public Fileinfo findFileById(Integer id);
}

