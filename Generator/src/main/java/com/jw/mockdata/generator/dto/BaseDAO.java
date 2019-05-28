package com.jw.mockdata.generator.dto;

import com.jw.mockdata.generator.util.AirDataSourceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

/**
 * Created by djw on 2017/3/2.
 */
@Slf4j
public class BaseDAO
{
    protected static Connection conn;
    protected static JdbcTemplate jdbcTemplate;
    DriverManagerDataSource driverManagerDataSource;
    public BaseDAO(String dataSourcePreflix)
    {
        init(dataSourcePreflix);
    }
    /**
     * 初始化数据库连接和jdbc
     */
    public void init(String dataSourcePreflix)
    {
        try
        {
            driverManagerDataSource = AirDataSourceManager.Init(dataSourcePreflix);
            conn = DriverManager.getConnection(driverManagerDataSource.getUrl(), driverManagerDataSource.getUsername(), driverManagerDataSource.getPassword());
            jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        }
        catch (SQLException e)
        {
            log.error("BaseDAO.init",e);
        }
    }

    public Connection getConn()
    {
        while(true)
        {
            try
            {
                if (conn  == null||conn.isClosed())
                {
                    conn = DriverManager.getConnection(driverManagerDataSource.getUrl(), driverManagerDataSource.getUrl(), driverManagerDataSource.getPassword());
                }
                break;
            }
            catch (SQLRecoverableException err)
            {
                log.error("数据库连接异常，30秒后重试",err);
                try
                {
                    Thread.sleep(30*1000);
                }
                catch (Exception e)
                {
                    log.error("",e);
                }
            }
            catch (SQLException errNet)
            {
                log.error("数据库连接异常，30秒后重试",errNet);
                try
                {
                    Thread.sleep(30*1000);
                }
                catch (Exception e)
                {
                    log.error("",e);
                }
            }
            catch (Exception e)
            {
                log.error("",e);
            }
        }
        return conn;
    }

    public JdbcTemplate getJdbcTemplate()
    {
        while(true)
        {
            try
            {
                if (jdbcTemplate==null||jdbcTemplate.getDataSource().getConnection().isClosed())
                {
                    jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
                }
                break;
            }
            catch (SQLRecoverableException err)
            {
                log.error("数据库JdbcTemplate连接异常，30秒后重试",err);
                try
                {
                    Thread.sleep(30*1000);
                }
                catch (Exception e)
                {
                    log.error("",e);
                }
            }
            catch (SQLException errNet)
            {
                log.error("数据库JdbcTemplate连接异常，30秒后重试",errNet);
                try
                {
                    Thread.sleep(30*1000);
                }
                catch (Exception e)
                {
                    log.error("",e);
                }
            }
            catch (Exception e)
            {
                log.error("",e);
            }
        }
        return jdbcTemplate;
    }
}
