package com.battcn.platform.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

	protected Logger LOGGER = LoggerFactory.getLogger(getClass());
	static final String PATH_REDIRECT_LOGOUT = "redirect:/login";
	static final String PATH_MAIN = "main";
	static final String PATH_LOGIN = "login";
	
	@Autowired
	public HttpServletRequest request;
	@Autowired
	public HttpServletResponse response;
	@Autowired
	public HttpSession session;

}
