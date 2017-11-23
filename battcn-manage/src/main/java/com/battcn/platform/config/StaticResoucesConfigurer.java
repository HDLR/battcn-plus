/**
 * File Name: com.battcn.platform.config.StaticResoucesConfigurer.java

 * @Date:2017年11月23日上午9:10:19
 */
package com.battcn.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * File Name: com.battcn.platform.config.StaticResoucesConfigurer.java
 * 
 * @Date:2017年11月23日上午9:10:19
 */
@Configuration
public class StaticResoucesConfigurer extends WebMvcConfigurerAdapter{

	@Value("${img.path}")
	protected String imgPath;
	

	/**
	 * 增加多个路径配置，方便开发，测试和部署，
	 * 读取优先级从左往右，并且保证文件夹存在，具体访问的资源存在 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imgs/**","/imgs/pro/**").addResourceLocations("file:G:/imgs/","file:G:/imgs/pro/",
				"classpath:/imgs/","classpath:/imgs/pro/","classpath:/META-INF/resources/static/imgs/","classpath:/META-INF/resources/static/imgs/pro/",
				"file:" + imgPath);
		super.addResourceHandlers(registry);
	}
	

}
