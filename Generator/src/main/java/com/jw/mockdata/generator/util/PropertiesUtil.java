package com.jw.mockdata.generator.util;

import com.jw.mockdata.generator.model.ResourceBundleExt;
import lombok.extern.slf4j.Slf4j;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Boolean.parseBoolean;

/**
 * 读取配置文件工具类
 * Created by djw on 2017/2/20.
 */
@Slf4j
public class PropertiesUtil
{
    public static final String dir = System.getProperty ("user.dir");
    private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");
    private static final String configdir = "config";
    private static Map<String,String> propertyList = new HashMap<>();
    private static Map<String,ResourceBundle> propertyMap = new HashMap<>();
    static
    {
        try
        {
            log.info("PropertiesUtil.dir",dir);
            File configDir = new File(dir);
            log.info("PropertiesUtil.configProp",configDir.getParent()+File.separator+configdir+File.separator);
            log.info("PropertiesUtil.configProp",configDir.getCanonicalPath()+File.separator+configdir+File.separator);
            log.info("PropertiesUtil.configProp",configDir.getCanonicalPath()+File.separator);
            log.info("PropertiesUtil.configdir",configdir);
        }
        catch (Exception e)
        {
        }
    }
    /**
     * 读取配置文件配置属性
     * @param propertyName 配置文件名
     * @param key 属性名
     * @return
     */
    public static String read(String propertyName,String key)
    {
        String value = new String();
        String configProp = null;
        InputStream in = null;
        try
        {
//            if(propertyMap.containsKey(propertyName))
//            {
//                value = propertyMap.get(propertyName).getString(key);
//            }
//            else
//            {
                if (propertyList.containsKey(propertyName))
                {
                    in = new BufferedInputStream(new FileInputStream(propertyList.get(propertyName)));
                }
                else
                {
                    File configDir = new File(dir);
                    configProp =
                        configDir.getParent() + File.separator + configdir + File.separator + propertyName +
                            ".properties";

                    if (!new File(configProp).exists())
                    {
                        configProp =
                            configDir.getCanonicalPath() + File.separator + configdir + File.separator + propertyName +
                                ".properties";
                        if (!new File(configProp).exists())
                        {
                            configProp = configDir.getCanonicalPath() + File.separator + propertyName + ".properties";
                            if (!new File(configProp).exists())
                            {
                                in =
                                    PropertiesUtil.class.getClassLoader()
                                        .getResourceAsStream(propertyName + ".properties");
                                configProp = PropertiesUtil.class.getClassLoader().getResource(propertyName + ".properties").getPath();
                            }
                            else
                            {
                                //读取属性文件a.properties
                                in = new BufferedInputStream(new FileInputStream(configProp));
                            }

                        }
                        else
                        {
                            //读取属性文件a.properties
                            in = new BufferedInputStream(new FileInputStream(configProp));
                        }
                    }
                    else
                    {
                        //读取属性文件a.properties
                        in = new BufferedInputStream(new FileInputStream(configProp));
                    }

               }
                //转码
                InputStreamReader iread = new InputStreamReader(in, "UTF-8");
                ResourceBundle resourceBundle = new PropertyResourceBundle(iread);
                if(resourceBundle.containsKey(key))
                {
                    value = resourceBundle.getString(key);
                    Matcher matcher = PATTERN.matcher(value);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        String matcherKey = matcher.group(1);
                        String matchervalue = read(propertyName,matcherKey);
                        if (matchervalue != null) {
                            matcher.appendReplacement(buffer, matchervalue);
                        }
                    }
                    matcher.appendTail(buffer);
                    value = buffer.toString();
                    if (!propertyList.containsKey(propertyName))
                        propertyList.put(propertyName, configProp);
                }
                else
                {
                    value = "";
                }
                in.close();

        }
        catch (Exception e)
        {
            log.error(PropertiesUtil.class.getName(),e);
        }
        finally
        {
            return value;
        }
    }
    /**
     * 读取配置文件配置属性
     * @param propertyName 配置文件名
     * @param key 属性名
     * @return
     */
    public static void write(String propertyName,String key,String value)
    {
        try
        {
            Properties props = new Properties();
            if(propertyList.containsKey(propertyName))
            {
                props.load(new FileReader(propertyList.get(propertyName)));
            }
            props.setProperty(key,value);
            //持久化配置文件
            File file = new File(propertyList.get(propertyName));
            Writer fw = new FileWriter(file);
            props.store(fw,"#PropertiesUtil Config Auto Write");
            fw.close();
        }
        catch (Exception e)
        {
            log.error("",e);
        }
    }
    /**
     * 更新配置文件
     * @param properties 配置文件
     * @param keyname
     * @return
     */
    public static void updateProperty(Properties properties,String filePath,String keyname,String keyvalue)
    {
        try
        {
            properties.setProperty(keyname, keyvalue);
            String path = PropertiesUtil.class.getResource(filePath).getPath();
            FileOutputStream outputFile = new FileOutputStream(path);
            properties.store(outputFile, "modify");
            outputFile.flush();
            outputFile.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
        /**
         * 读取名称为config.properties的配置文件的属性值
         * @param key 属性名
         * @return
         */
    public static String read(String key)
    {
        final String propertyFileName = "config";
        return read(propertyFileName,key);
    }

    public static ResourceBundleExt getResourceProperty(String propertyName)
    {
        String value = new String();
        String configProp = null;
        InputStream in = null;
        try
        {
//            if(propertyMap.containsKey(propertyName))
//            {
//                value = propertyMap.get(propertyName).getString(key);
//            }
//            else
//            {
            if (propertyList.containsKey(propertyName))
            {
                in = new BufferedInputStream(new FileInputStream(propertyList.get(propertyName)));
            }
            else
            {
                File configDir = new File(dir);
                configProp =
                    configDir.getParent() + File.separator + configdir + File.separator + propertyName +
                        ".properties";

                if (!new File(configProp).exists())
                {
                    configProp =
                        configDir.getCanonicalPath() + File.separator + configdir + File.separator + propertyName +
                            ".properties";
                    if (!new File(configProp).exists())
                    {
                        configProp = configDir.getCanonicalPath() + File.separator + propertyName + ".properties";
                        if (!new File(configProp).exists())
                        {
                            in =
                                PropertiesUtil.class.getClassLoader()
                                    .getResourceAsStream(propertyName + ".properties");
                            configProp = PropertiesUtil.class.getClassLoader().getResource(propertyName + ".properties").getPath();
                        }
                        else
                        {
                            //读取属性文件a.properties
                            in = new BufferedInputStream(new FileInputStream(configProp));
                        }

                    }
                    else
                    {
                        //读取属性文件a.properties
                        in = new BufferedInputStream(new FileInputStream(configProp));
                    }
                }
                else
                {
                    //读取属性文件a.properties
                    in = new BufferedInputStream(new FileInputStream(configProp));
                }

            }
            //转码
            InputStreamReader iread = new InputStreamReader(in, "UTF-8");
            ResourceBundleExt resourceBundle = new ResourceBundleExt(iread);
            in.close();
            return resourceBundle;
        }
        catch (Exception e)
        {
            log.error(PropertiesUtil.class.getName(),e);
            return null;
        }
    }
    public static String readdef(String key,String defaultValue)
    {
        try {
            final String propertyFileName = "config";
            String result =read(propertyFileName, key);
            if(!StringUtil.isEmpty(result))
                return result;
        }
        catch (Exception e) {}
        return defaultValue;
    }
    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public static int readInt(String key)
    {
        final String propertyFileName = "config";
        return new Integer(read(propertyFileName,key));
    }
    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public static int readInt(String key,int defaultValue)
    {
        try
        {
            final String propertyFileName = "config";
            return new Integer(read(propertyFileName,key));
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }
    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public static long readLong(String key,long defaultValue)
    {
        try
        {
            final String propertyFileName = "config";
            return new Long(read(propertyFileName,key));
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }
    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public static boolean readBoolean(String key)
    {
        final String propertyFileName = "config";
        return parseBoolean(read(propertyFileName,key));
    }

    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public static boolean readBoolean(String key, boolean defult)
    {
        try
        {

            final String propertyFileName = "config";
            String value=read(propertyFileName, key);
            if(StringUtil.isEmpty(value)){
                return defult;
            }
            return parseBoolean(value);
        }
        catch (Exception e)
        {
            return defult;
        }
    }
    /**
     * 读取名称为config.properties的配置文件的属性值
     * @param key 属性名
     * @return
     */
    public static String readException(String key)
    {
        final String propertyFileName = "exception";
        return read(propertyFileName,key);
    }
}
