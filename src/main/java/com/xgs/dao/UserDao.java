package com.xgs.dao;

import java.util.List;

import com.xgs.entity.Changelog;
import com.xgs.entity.Errlogin;
import com.xgs.entity.Login;
import com.xgs.entity.User;

public interface UserDao {
//	登录用户信息
	public Login findByName(String name);
//	向表logininfo插入新注册的用户信息
	public void saveLogininfo(Login login);
	public void modifyLogin(Login login); 
//	从表config获取登录配置信息
	public String findByType(int type);
//	从表errlogininfo中获取错误信息
	public List<Errlogin> findByDateAndIp(String ip_addr,String begin,String end);
//	向表errlogininfo中插入错误登录信息
	public void AddErrLoginInfo(Errlogin errlogin);
//	注册用户信息
	public User findByUsername(String name);
	public void saveUser(User user);
	public void modifyUser(User user); 
	public void saveChangelog(Changelog changelog);
}
