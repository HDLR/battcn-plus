package com.battcn.platform.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.battcn.platform.pojo.dto.ManagerDto;

public class SessionUtil {

	/**
	 * 用户信息key
	 */
	public static final String USER_SESSION_KEY = "USER_SESSION_KEY";
	public static final String USER_SESSION_LOGOUT_LOGOUT_KEY = "USER_SESSION_LOGOUT_LOGOUT_KEY";

	/**
	 * 从session中获取当前登录的用户信息
	 * 
	 * @return[参数、异常说明] @return UserForm [返回类型说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static ManagerDto getSession() {
		Session session = SecurityUtils.getSubject().getSession();
		return (ManagerDto) session.getAttribute(USER_SESSION_KEY);
	}
	
	public static void setSession(ManagerDto manager) {
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(USER_SESSION_KEY, manager);
	}

}
