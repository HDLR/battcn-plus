package com.battcn.framework.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 拦截Controller
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BattcnLog {

	/**
	 * 模块名称 系统管理-用户管理－列表页面
	 * 
	 * @return
	 */
	String module() default "";

	/**
	 * 新增用户
	 * 
	 * @return
	 */
	String methods() default "";

	/**
	 * 描述
	 * 
	 * @return
	 */
	String description() default "";

}
