package com.xgs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xgs.dao.UserDao;
import com.xgs.entity.Changelog;
import com.xgs.entity.Errlogin;
import com.xgs.entity.Login;
import com.xgs.entity.User;
import com.xgs.util.TerResult;
import com.xgs.util.TerUtil;

@Service("userService") //扫描spring容器
public class UserServiceImpl implements UserService{
	@Resource
	UserDao dao;
	public TerResult<Login> checkLogin(String username, String password,String ipaddr) {
//		接收结果数据
		TerResult<Login> result = new TerResult<Login>();
		int max_login_times=0;
		int locked_mins=0;
		int login_times = 0;
		long time_diff = -1;
		String login_time = "";
		int max_chg_pwd_day=0;
		int to_chg_pwd = 0; 
		Login loginfo=dao.findByName(username);
		if(loginfo==null){
			result.setStatus(2);
			result.setMsg("您输入的用户名有误，请重新输入");
			return result;
		}
//		获得管理员登录尝试次数
		String max_login_times_value=dao.findByType(2);
		if(max_login_times_value==null){
			max_login_times = 5;
		}else{
			max_login_times = Integer.parseInt(max_login_times_value);
		}
//		获得管理员登录达到尝试次数限制后几分钟内不能登录
		String locked_mins_value=dao.findByType(3);
		if(locked_mins_value==null){
			locked_mins = 5;
		}else{
			locked_mins = Integer.parseInt(locked_mins_value);
		}
		String now=TerUtil.get_now();
		String ago=TerUtil.get_min_ago(locked_mins);
		List<Errlogin> listErrlogin = dao.findByDateAndIp(ipaddr, ago, now);
		login_times = listErrlogin.size();
		if(!loginfo.getPwd().equals(password) && login_times < max_login_times) {
			Errlogin errlogin = new Errlogin();
			errlogin.setIp_addr(ipaddr);
			errlogin.setLogin_time(now);
			errlogin.setUsername(username);
			dao.AddErrLoginInfo(errlogin);
			result.setStatus(3);
			result.setMsg("您输入的密码有误，请重新输入");
			return result;
		}
		if(login_times >= max_login_times){	//尝试登录次数过多，登录失败
			result.setStatus(4); 
			result.setMsg("您登录尝试次数过多，请稍后再试");
			return result;
		}
		String last_change=loginfo.getLast_change();
		if(!(last_change==null)){
			login_time = TerUtil.get_now();
			time_diff = TerUtil.get_time_diff(last_change, login_time);	//获得管理员修改密码间隔
		}
//		获得管理员修改密码最大间隔天数
		String max_chg_pwd_day_value = dao.findByType(4);
		if(max_chg_pwd_day_value==null){
			max_chg_pwd_day = 7;
		} else {
			max_chg_pwd_day = Integer.parseInt(max_chg_pwd_day_value);
		}
		if(time_diff==-1 || time_diff > max_chg_pwd_day*3600*24*1000){
			to_chg_pwd = 1; 
		}
//		to_chg_pwd=0表示未超过最大间隔天数；to_chg_pwd=1表示超过最大间隔天数
		result.setStatus(to_chg_pwd);
		result.setMsg("登录成功");
		result.setData(loginfo);
		result.setExData(max_chg_pwd_day);
		return result;
	}
	
	
	public TerResult<Object> addUser(String username, String pwd, Integer age, String gender, String email, String phone,
			String nickname) {
		TerResult<Object> result = new TerResult<Object>();
		Login hasUser = dao.findByName(username);
		if(hasUser!=null) {
			result.setStatus(1);
			result.setMsg("用户已经被占用，请重新输入");
			return result;
		}
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);
		user.setAge(age);
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		user.setNickname(nickname);
//		插入用户数据
		dao.saveUser(user);
		String type="user";
		int flag = 1;
		int group = 0;
		String last_change = TerUtil.get_now();
		Login login = new Login();
		login.setUsername(username);
		login.setPwd(pwd);
		login.setType(type);
		login.setFlag(flag);
		login.setGroup(group);
		login.setLast_change(last_change);
		dao.saveLogininfo(login);
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}


	public TerResult<Map<String,String>> changePwd(String username, String oldPassword, String newPassword) {
		int len_pwd=0;
		String isSame="N";//Y:原密码与数据库的密码一致；N：原密码输入错误
		int newPwdState=0;//0:密码长度和样式都符合要求；-1：密码长度小于len_pwd；-2：密码中没有同时包含数字和字母
		TerResult<Map<String,String>> result=new TerResult<Map<String,String>>();
		Map<String, String> mapMsg = new HashMap<String, String>();
		Login login=dao.findByName(username);
		User user = dao.findByUsername(username);
		String passwordata=login.getPwd();
		String len_pwd_value=dao.findByType(1);
		if(len_pwd_value==null) {
			len_pwd=8;
		} else {
			len_pwd=Integer.parseInt(len_pwd_value);
		}
		if(oldPassword.equals(passwordata)) {
			isSame="Y";
		}
		newPwdState=TerUtil.judgePwd(newPassword, len_pwd);
		int uniqueid=0;
		String table_name="";
		int table_id=0;
		String content="";
		String process_time=TerUtil.get_now();
		Changelog changelog = new Changelog();
		changelog.setUniqueid(uniqueid);
		changelog.setTable_name(table_name);
		changelog.setTable_id(table_id);
		changelog.setProcess_time(process_time);
		changelog.setUser(username);
		if(isSame.equals("Y") && newPwdState==0) {
			newPassword=TerUtil.encodeStrByMd5(newPassword);
			login.setPwd(newPassword);
			login.setLast_change(process_time);
			dao.modifyLogin(login);
			if(login.getType()=="user") {
				user.setPwd(newPassword);
				dao.modifyUser(user);
			}			
			content="修改密码成功";
			result.setStatus(0);
			result.setMsg("密码修改成功，请重新登录");
		} else {
			content="修改密码失败";
			result.setStatus(1);
			result.setMsg("密码修改失败");
			if(isSame.equals("N")) {
				mapMsg.put("oldPwdMsg","原密码输入错误，请重新输入");
			}
			if(newPwdState==-1) {
				mapMsg.put("newPwdMsg","密码不能小于"+len_pwd+"位，请重新输入");
			}
			if(newPwdState==-2) {
				mapMsg.put("newPwdMsg","密码应同时包含数字和字母，请重新输入");
			}
			result.setData(mapMsg);
		}
		changelog.setContent(content);
		dao.saveChangelog(changelog);
		return result;
	}
}
