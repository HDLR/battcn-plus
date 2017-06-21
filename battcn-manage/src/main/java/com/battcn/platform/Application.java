package com.battcn.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.battcn.platform.util.AppContextUtil;

@SpringBootApplication
@ComponentScan("com.battcn.platform")
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		AppContextUtil.setApplicationContext(context);
	}
	
}
