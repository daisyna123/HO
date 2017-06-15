package com.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @DESCRIPTION 手动获取bean工具类
 * @AUTHER administrator zhangna
 * @create 2017-06-14
 */
public class TCSL_UTIL_SpringContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext app) throws BeansException {
        applicationContext = app;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBeanById(String id){
        return applicationContext.getBean(id);
    }

    public static Object getBeanByClass(Class c){
        return applicationContext.getBean(c);
    }
}
