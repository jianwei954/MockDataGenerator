package com.jw.mockdata.generator.util;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * web jdbctemplate
 * 重复利用jdbcTemplate，不要到处new jdbcTemplate实例
 * 
 * @author  hh
 */
public class PcollectBaseDaoUtil
{
    private JdbcTemplate jdbcTemplate;
    private static PcollectBaseDaoUtil instance = new PcollectBaseDaoUtil();
    
    public static PcollectBaseDaoUtil instance()
    {
        return instance;
    }
    
    public DataSource getDataSource()
    {
        return ServiceLocator.findService("dataSource_pcollect", DataSource.class);
    }

    public JdbcTemplate getJdbcTemplate()
    {
        if (jdbcTemplate == null)
        {
            jdbcTemplate = new JdbcTemplate(getDataSource());
            jdbcTemplate.setLazyInit(false);
        }
        return jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplateDatacollectV2()
    {
        return ServiceLocator.findService("jdbcTemplate_datacollectV2", JdbcTemplate.class);
    }
}
