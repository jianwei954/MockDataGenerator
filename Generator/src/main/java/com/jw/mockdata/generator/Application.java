package com.jw.mockdata.generator;

import com.jw.mockdata.generator.model.ResourceBundleExt;
import com.jw.mockdata.generator.task.TaskTimer;
import com.jw.mockdata.generator.util.PropertiesUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ResourceBundle;
import java.util.Timer;

/**
 * Created by dell on 2017/3/16.
 */
@SpringBootApplication
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages = "com.jw.mockdata.generator")
@MapperScan("com.jw.mockdata.generator.mapper")
public class Application
{
    public static final String VERSION = "0.0.1";
    private static Log logger = LogFactory.getLog(Application.class);
    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }

        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.out.println("Version:" + VERSION);
        try {
            String tasks = PropertiesUtil.read("task");
            for(String taskName:tasks.split(","))
            {
                Timer timer = new Timer(taskName);
                TaskTimer taskTimer = new TaskTimer();
                ResourceBundleExt res1 = PropertiesUtil.getResourceProperty("task\\"+taskName);
                taskTimer.setResourceBundleExt(res1);
                long scheduled = res1.readInt("scheduled", 5) * 60 * 1000;
                timer.scheduleAtFixedRate(taskTimer, 5000, scheduled);
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
