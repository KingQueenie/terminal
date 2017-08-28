package com.xgs.interceptors;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于Session验证的拦截器
 */
public class SessionInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, 
			                 HttpServletResponse response, Object handler)throws Exception {			
		System.out.println("preHandle()");
		HttpSession session=request.getSession();
		Object obj = session.getAttribute("username");
		if(obj==null){
//			没有登录，转发到登录页面
			request.getRequestDispatcher("xgs_login.jsp").forward(request, response);
			return false;
		}
//		已经登录，则允许访问
		return true;
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
