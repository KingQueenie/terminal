package com.xgs.service;

import java.util.Map;

import com.xgs.entity.Login;
import com.xgs.util.TerResult;

public interface UserService {
	public TerResult<Login> checkLogin(String name,String password,String ipaddr);
	public TerResult<Object> addUser(String username,String pwd,Integer age,String gender,String email,String phone,String nickname);
	public TerResult<Map<String,String>> changePwd(String username,String oldPassword,String newPassword);
}
