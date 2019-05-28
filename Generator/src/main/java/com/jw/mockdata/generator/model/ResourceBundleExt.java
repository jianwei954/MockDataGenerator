package com.jw.mockdata.generator.model;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author: create by djw
 * @version: v1.0
 * @description: com.jw.mockdata.generator.model
 * @date:2019/5/24
 */
public class ResourceBundleExt extends PropertyResourceBundle
{
    public ResourceBundleExt (Reader reader) throws IOException
    {
        super(reader);
    }

    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public int readInt(String key)
    {
        return new Integer(this.getString(key));
    }

    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public int readInt(String key,int defaultValue)
    {
        try
        {
            return readInt(key);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }
}
