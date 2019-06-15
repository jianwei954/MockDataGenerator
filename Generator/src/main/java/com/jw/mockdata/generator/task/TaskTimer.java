package com.jw.mockdata.generator.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jw.mockdata.generator.dto.BaseDAO;
import com.jw.mockdata.generator.model.ResourceBundleExt;
import com.jw.mockdata.generator.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: create by djw
 * @version: v1.0
 * @description: com.jw.mockdata.generator.task
 * @date:2019/5/24
 */
@Slf4j
public class TaskTimer extends TimerTask
{
    private ResourceBundleExt resourceBundleExt;
    private BaseDAO baseDAO;
    @Override
    public void run()
    {
        try
        {
            String datasource =  resourceBundleExt.getString("datasource.preflix");
            String datasourceType =  resourceBundleExt.getString("datasource.type");
            if(!datasourceType.equals("hbase"))
            {
                Map<String, Object> paramMap = new HashMap<>();
                for(int sqlIndex = 0;sqlIndex<5;sqlIndex++)
                {
                    String preflix = "sql" + sqlIndex+".";
                    if(sqlIndex==0)
                    {
                        preflix = "";
                    }
                    String sql = resourceBundleExt.getString("sql" + sqlIndex);
                    if(StringUtil.isEmpty(sql))
                    {
                        return;
                    }
                    int countNum = StringUtil.countChar(sql, '?');
                    baseDAO = new BaseDAO(datasource);
                    PreparedStatement ps = null;
                    try
                    {
                        ps = baseDAO.getConn().prepareStatement(sql);
                        Random random = new Random();
                        for (int i = 0; i < countNum; i++)
                        {
                            String param = resourceBundleExt.getString(preflix+"param" + i);
                            if (param.equals("${data}"))
                            {
                                java.sql.Date date = new java.sql.Date(new Date().getTime());
                                ps.setObject(i + 1, date);
                                paramMap.put("param" + i, date);
                            }
                            else if (param.equals("${timestamp}"))
                            {
                                java.sql.Timestamp date = new java.sql.Timestamp(new Date().getTime());
                                ps.setObject(i + 1, date);
                                paramMap.put("param" + i, date);
                            }
                            else if (param.equals("${timestamp.longValue}"))
                            {
                                java.sql.Timestamp date = new java.sql.Timestamp(new Date().getTime());
                                ps.setObject(i + 1, date.getTime());
                                paramMap.put("param" + i, date.getTime());
                            }
                            else if (param.startsWith("${gps"))
                            {
                                param = param.substring(2, param.length() - 1);
                                String[] paramChild = param.split(",");
                                float initLngLat = Float.parseFloat(paramChild[1]);
                                float randomRange = Float.parseFloat(paramChild[2]);
                                if (paramChild[0].equals("gps.lng"))
                                {
                                    if (random.nextBoolean())
                                    {
                                        float lng = initLngLat - random.nextFloat() * randomRange;
                                        ps.setObject(i + 1, lng);
                                        paramMap.put("param" + i, lng);
                                    }
                                    else
                                    {
                                        float lng = initLngLat + random.nextFloat() * randomRange;
                                        ps.setObject(i + 1, lng);
                                        paramMap.put("param" + i, lng);
                                    }
                                }
                                else if (paramChild[0].equals("gps.lngstr"))
                                {
                                    if (random.nextBoolean())
                                    {
                                        String lng = (initLngLat - random.nextFloat() * randomRange) + "";
                                        paramMap.put("param" + i, lng);
                                        ps.setObject(i + 1, lng);
                                    }
                                    else
                                    {
                                        String lng = (initLngLat + random.nextFloat() * randomRange) + "";
                                        paramMap.put("param" + i, lng);
                                        ps.setObject(i + 1, lng);
                                    }
                                }
                                else if (paramChild[0].equals("gps.lat"))
                                {
                                    if (random.nextBoolean())
                                    {
                                        float lat = initLngLat - random.nextFloat() * randomRange;
                                        paramMap.put("param" + i, lat);
                                        ps.setObject(i + 1, lat);
                                    }
                                    else
                                    {
                                        float lat = initLngLat + random.nextFloat() * randomRange;
                                        paramMap.put("param" + i, lat);
                                        ps.setObject(i + 1, lat);
                                    }
                                }
                                else if (paramChild[0].equals("gps.latstr"))
                                {
                                    if (random.nextBoolean())
                                    {
                                        String lat = initLngLat - random.nextFloat() * randomRange + "";
                                        paramMap.put("param" + i, lat);
                                        ps.setObject(i + 1, lat);
                                    }
                                    else
                                    {
                                        String lat = initLngLat + random.nextFloat() * randomRange + "";
                                        paramMap.put("param" + i, lat);
                                        ps.setObject(i + 1, lat);
                                    }
                                }
                                else
                                {
                                    log.error("无效的参数类型" + param);
                                }
                            }
                            else if (param.startsWith("${float"))
                            {
                                param = param.substring(2, param.length() - 1);
                                String[] paramChild = param.split(",");
                                if (paramChild[0].equals("float.random"))
                                {
                                    int anInt = random.nextInt(360);
                                    paramMap.put("param" + i, anInt);
                                    ps.setObject(i + 1, anInt);
                                }
                                else
                                {
                                    float anInt = Float.parseFloat(paramChild[1]);
                                    paramMap.put("param" + i, anInt);
                                    ps.setObject(i + 1, anInt);
                                }
                            }
                            else if (param.startsWith("${int"))
                            {
                                param = param.substring(2, param.length() - 1);
                                String[] paramChild = param.split(",");
                                if (paramChild[0].equals("int.random"))
                                {
                                    int anInt = random.nextInt(new Integer(paramChild[1]));
                                    paramMap.put("param" + i, anInt);
                                    ps.setObject(i + 1, anInt);
                                }
                                else
                                {
                                    int anInt = Integer.parseInt(paramChild[1]);
                                    paramMap.put("param" + i, anInt);
                                    ps.setObject(i + 1, anInt);
                                }
                            }
                            else if (param.startsWith("${string"))
                            {
                                param = param.substring(2, param.length() - 1);
                                String[] paramChild = param.split(",");
                                paramMap.put("param" + i, paramChild[1]);
                                ps.setString(i + 1, paramChild[1]);
                            }
                            else if (param.startsWith("$."))
                            {
                                ps.setObject(i + 1, paramMap.get(param.substring(2)));
                            }
                            else
                            {
                                ps.setObject(i + 1, param);
                            }

                        }
                        Boolean result = ps.execute();
                        log.info(sql);
                        log.info(result.toString());
                    }
                    catch (SQLException e)
                    {
                        if (!e.getMessage().contains("ORA-00001"))
                        {
                            log.error("", e);
                        }
                    }
                    catch (Exception e)
                    {
                        log.error("", e);
                    }
                    finally
                    {
                        try
                        {
                            if (ps != null)
                            {
                                ps.close();
                            }
                        }
                        catch (SQLException e)
                        {
                            log.error("", e);
                        }
                    }
                }
//                jdbcTemplate =baseDAO.getJdbcTemplate();
            }
            else if(datasourceType.equals("hbase"))
            {

            }
        }
        catch (Exception e)
        {

        }
    }

    public ResourceBundleExt getResourceBundleExt()
    {
        return resourceBundleExt;
    }

    public void setResourceBundleExt(ResourceBundleExt resourceBundleExt)
    {
        this.resourceBundleExt = resourceBundleExt;
    }
}
