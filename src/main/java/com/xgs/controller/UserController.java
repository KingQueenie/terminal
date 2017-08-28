package com.xgs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xgs.entity.Login;
import com.xgs.service.UserService;
import com.xgs.util.TerResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	UserService userService;
	@RequestMapping("/login.do") //匹配请求
	@ResponseBody //JSON输出
	public TerResult<Login> login(String username, String password,String ipaddr,HttpSession session) {
//		调用UserService处理登录请求
//		System.out.println(username+","+password);
		TerResult<Login> result = userService.checkLogin(username, password, ipaddr);
		if(result.getStatus()==0 || result.getStatus()==1) {
			session.setAttribute("username", username);
		}
		System.out.println("-------------->>>> "+username+", "+result.getMsg());
		return result;
	}
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public TerResult<Object> regist(String username,String password,Integer age,String gender,String email,String phone,String nickname){
		TerResult<Object> result = new TerResult<Object>();
		result=userService.addUser(username, password, age, gender, email, phone, nickname);
		System.out.println("-------------->>>> "+username+", "+result.getMsg());
		return result;
	}
	
	@RequestMapping("/changePassword.do")
	@ResponseBody
	public TerResult<Map<String, String>> changePassword(String username, String oldPassword, String newPassword){
		TerResult<Map<String, String>> result  = new TerResult<Map<String, String>>();
		result = userService.changePwd(username, oldPassword, newPassword);
		System.out.println("-------------->>>> "+username+", "+result.getMsg());
		return result;
	}
	
	@RequestMapping("/quit.do")
	@ResponseBody
	public TerResult<Object> quit(HttpServletRequest req,HttpSession session){
		TerResult<Object> result = new TerResult<Object>();
		String username=(String)session.getAttribute("username");
		req.getSession().removeAttribute("username");
		req.getSession().invalidate();
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		result.setStatus(0);
		result.setMsg(username+"在"+df.format(new Date())+"成功退出了系统");
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
}
