package com.battcn.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.battcn.platform")
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        SpringContextUtil.setApplicationContext(context);
    }

    static public class SpringContextUtil {

        private static ApplicationContext applicationContext;

        public static ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        public static void setApplicationContext(ApplicationContext applicationContext) {
            SpringContextUtil.applicationContext = applicationContext;
        }

        public static Object getBean(String name) {
            return applicationContext.getBean(name);
        }

        public static <T> T getBean(Class<T> requiredType) {
            return applicationContext.getBean(requiredType);
        }

    }

}
