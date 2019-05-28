package com.jw.mockdata.generator.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;

//import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * 查找spring bean实例
 * 
 * @author  hh
 * @version  [版本号, Feb 21, 2014]
 */
public class ServiceLocator
{
    private static ApplicationContext context;

    public static void setContext(ServletConfig conf)
    {
        context = WebApplicationContextUtils.getWebApplicationContext(conf.getServletContext());
    }
    
    public static Object findService(String beanName)
    {
        if (null == getContext())
        {
            boolean istest = false;
            Throwable ex = new Throwable();
            StackTraceElement[] stackElements = ex.getStackTrace();
            if (stackElements != null && stackElements.length > 0)
            {
                if(stackElements[stackElements.length - 1].getClassName().startsWith("test.com.pip."))
                {
                    istest = true;
                }
                else
                {
                    for (StackTraceElement e : stackElements)
                    {
                        if (e.getClassName().equals("org.junit.runners.ParentRunner"))
                        {
                            istest = true;
                            break;
                        }
                    }
                }
            }
            //测试模式
//            if (istest)
//            {
//                System.out.println(">>>>>>>>>>>> 测试模式   <<<<<<<<<<<<<");
//                context =
//                    new ClassPathXmlApplicationContext("classpath:spring-cfg/service-spring.xml",
//                        "classpath:testspring/junitapplicationContext.xml",
//                        "classpath:testspring/junitdubbo.xml");
//
//            }
//            else//正式
//            {
                context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//            }
        }
        return getContext().getBean(beanName);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T findService(String beanName, Class<T> clazz)
    {
        return (T)findService(beanName);
    }
    
    public static void destroy()
    {
        if (null != getContext())
        {
            ((AbstractApplicationContext)context).destroy();
        }
    }
    
    private static ApplicationContext getContext()
    {
        return context; 
    }
}
