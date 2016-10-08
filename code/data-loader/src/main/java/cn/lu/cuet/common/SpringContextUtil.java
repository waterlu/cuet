package cn.lu.cuet.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * Created by lu on 16-10-8.
 */
public class SpringContextUtil {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }
}
