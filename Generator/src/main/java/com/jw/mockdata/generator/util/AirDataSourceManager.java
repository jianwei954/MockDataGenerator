package com.jw.mockdata.generator.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2017/8/22.
 */
@Slf4j
public class AirDataSourceManager
{
    private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");

    public static DriverManagerDataSource Init(String preflix)
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        try
        {
            Properties properties=System.getProperties();
            String os = properties.getProperty("os.name");
            //判断当前系统
            if(os.toLowerCase().indexOf("windows")>=0)
            {
                properties.load(new FileInputStream(PropertiesUtil.read("datasource.file")));
            }
            else
            {
                properties.load(new FileInputStream(PropertiesUtil.read("datasource.file")));
            }
            ds.setDriverClassName(propertyUtil(preflix+".driver",properties));
            ds.setUrl(propertyUtil(preflix+".url",properties));
            ds.setUsername(propertyUtil(preflix+".username",properties));
            ds.setPassword(propertyUtil(preflix+".password",properties));
        }
        catch (Exception e)
        {
            log.error("",e);
        }
        return ds;
    }
    public static String propertyUtil(String value,Properties properties)
    {
        if(properties==null||!properties.containsKey(value))
        {
            return null;
        }
        Matcher matcher = PATTERN.matcher(properties.getProperty(value));
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String matcherKey = matcher.group(1);
            String matchervalue = propertyUtil(matcherKey,properties);
            if (matchervalue != null) {
                matcher.appendReplacement(buffer, matchervalue);
            }
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

}
