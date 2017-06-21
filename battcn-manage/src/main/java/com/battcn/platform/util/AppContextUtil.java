package com.battcn.platform.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class AppContextUtil
{
	private static ApplicationContext ctx = null;

	public static void setApplicationContext(ApplicationContext ctx)
			throws BeansException
	{
		AppContextUtil.ctx = ctx;
	}

	public static Object getBean(String beanName)
	{
		return ctx.getBean(beanName);
	}

}