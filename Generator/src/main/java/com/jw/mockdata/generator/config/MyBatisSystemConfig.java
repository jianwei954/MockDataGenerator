package com.jw.mockdata.generator.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 使用ORACLE、POSTGRESQL
 */
@Configuration
@MapperScan(basePackages = "com.jw.mockdata.generator.mapper", sqlSessionTemplateRef  = "defaultSqlSessionTemplate")
@EnableTransactionManagement
public class MyBatisSystemConfig
{
    @Bean(name="defaultDataSource")
    @Primary
    public DataSource defaultDataSource() {
        return null;
    }



    @Bean(name = "defaultSqlSessionFactory")
    @Primary
    public SqlSessionFactory defaultSessionFactoryBean() {
//        if(defaultDataSource() == null)
            return null;
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(defaultDataSource());
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        //添加插件
//        Interceptor interceptor = new QueryInterceptor();
//        interceptor.plugin(pageHelper);
//        bean.setPlugins(new Interceptor[]{interceptor});
//        try {
//            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//            bean.setMapperLocations(resolver.getResources("classpath:mapper/cloudatlas/*/*.xml"));
//            return bean.getObject();
//        } catch (Exception e) {
//            return null;
//        }
    }

    @Bean(name = "defaultTransactionManager")
    @Primary
    public DataSourceTransactionManager defaultTransactionManager(@Qualifier("defaultDataSource") DataSource dataSource) {
        try
        {
            return new DataSourceTransactionManager(dataSource);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Bean(name = "defaultSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate defaultSqlSessionTemplate(@Qualifier("defaultSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        if(sqlSessionFactory==null)
            return null;
        else
            return new SqlSessionTemplate(sqlSessionFactory);
    }
}