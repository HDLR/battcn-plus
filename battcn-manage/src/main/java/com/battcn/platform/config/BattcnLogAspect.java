package com.battcn.platform.config;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.common.utils.IPAddress;
import com.battcn.platform.pojo.po.Log;
import com.battcn.platform.service.LogService;

/**
 * 切点类
 */
@Aspect
@Component
public class BattcnLogAspect {
	// 本地异常日志记录对象
	private static final Logger logger = LoggerFactory.getLogger(BattcnLogAspect.class);

	@Autowired
	LogService logsService;
	@Autowired
	HttpServletRequest request;

	/**
	 * Controller 拦截点,前置通知
	 */
	@Pointcut("@annotation(com.battcn.framework.common.annotation.BattcnLog)")
	public void beforeController() {
	}

	private String getURI(HttpServletRequest request) throws IllegalStateException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int start = uri.indexOf(contextPath);
		return uri.substring(start + contextPath.length());
	}

	/**
	 * 操作异常记录
	 * 
	 * @param point
	 * @param e
	 * @author LJN
	 * @date 2015年5月5日
	 * @version 1.0
	 */
	@AfterThrowing(pointcut = "beforeController()", throwing = "e")
	public void doAfterThrowing(JoinPoint point, Throwable e) {
		String ip = null;
		try {
			ip = IPAddress.INTERNET_IP;
		} catch (Exception ee) {
			ip = "无法获取登录用户Ip";
		}
		try {
			Log log = getBattcnLog(point);
			// 登录名
			// accountName = SessionUtil.getSession().getAccount();
			String accountName = StringUtils.defaultString("memmsc", "don't username");
			log.setUrl(getURI(request));
			log.setAccount(accountName);
			log.setDuration(new Short("0"));
			log.setIp(ip);
			logsService.insertSelective(log);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 *
	 * @param joinPoint
	 *            切点
	 */
	@Around("beforeController()")
	public Object doController(ProceedingJoinPoint point) {
		Object result = null;
		// 执行方法名
		String accountName = null;
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().getSimpleName();
		Log log = new Log();
		Long start, time = 0L;
		String ip = null;
		try {
			ip = IPAddress.INTERNET_IP;
		} catch (Exception ee) {
			ip = "无法获取登录用户Ip";
		}
		try {
			accountName = StringUtils.defaultString("memmsc", "无法获取登录用户信息");
			log = getBattcnLog(point);
			// 执行方法所消耗的时间
			start = System.currentTimeMillis();
			result = point.proceed();
			time = System.currentTimeMillis() - start;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		// 当前用户
		try {
			logger.debug("=====通知开始=====");
			logger.debug("请求方法:{}.{}()", className, methodName);
			logger.debug("方法描述:{}", JSON.toJSONString(log));
			logger.debug("请求IP:{}", ip);
			logger.debug("=====通知结束=====");
			log.setUrl(getURI(request));
			log.setAccount(accountName);
			log.setDuration(time.shortValue());
			log.setIp(ip);
			logsService.insertSelective(log);
		} catch (Throwable e) {
			// 记录本地异常日志
			logger.error("====通知异常====");
			logger.error("异常信息:", e.getMessage());
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	private Log getBattcnLog(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName) && method.getParameterTypes().length == arguments.length) {
				BattcnLog bl = method.getAnnotation(BattcnLog.class);
				return new Log(bl.module(), bl.methods(), StringUtils.defaultString(bl.description(), "执行成功!"));
			}
		}
		return null;
	}
}
