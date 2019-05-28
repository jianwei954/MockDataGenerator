package com.jw.mockdata.generator.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 15-10-14.
 */
public enum UserLogEnum
{
    /**
     * 系统日志
     */
    SystemNormalLog(10000,"系统日志"),
    /**
     * 系统异常日志
     */
    SystemExceptionLog(99999,"系统异常日志"),
    /**
     * 轨迹分析
     */
    LocusLog(10100,"轨迹分析"),
    /**
     * 车辆卡口
     */

    CarLog(10200,"车辆卡口"),
    /**
     * Wifi日志
     */
    WifiLog(10300,"Wifi日志"),
    /**
     * 热点名查询
     */
    Connect_HotspotNameQueryLog(10401,"热点名查询"),
    /**
     * 终端连接
     */
    Connect_PhoneLog(10402,"终端连接"),
    /**
     *热点连接
     */
    Connect_HotspotLog(10403,"热点连接"),
    /**
     *围栏
     */
    FenceLog(10500,"围栏"),
	  /**
	   * 我的临控记录
	   */
		Control(10600,"临控"),
    /**
     * 高级分析
     */
    datacomparisonLog(10700,"高级分析"),
    /**
     * rtt
     */
    sercretLog(110110,"其他数据"),
    /**
     * 统计分析
     */
    statisticsLog(110120,"统计分析"),
    /**
     * 基础信息管理
     */
    extLog(110130,"基础信息管理"),
    /**
     * 热点基础信息管理
     */
    extLogByEssid(110130,"基础信息管理"),
    /**
     * 手机采集
     */
    collectLog(110150,"手机采集"),
    /**
     * 案情比对
     */
    CaseInfoLog(110160,"案情比对"),
    /**
     * 案情比对
     */
    QianKeLog(110170,"前科管理");


	
    private int logid;
    private String val;
    private UserLogEnum(int logid, String v)
    {
        this.logid = logid;
        this.val = v;
    }

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public static Map<String,String> getAllUserLogMap()
    {
        Map<String,String> map = new HashMap<>();
        for(UserLogEnum item:UserLogEnum.values())
        {
            map.put(item.getLogid()+"",item.getVal());
        }
        return map;
    }
    public static String getValByLogid(int logid)
    {
        for(UserLogEnum item:UserLogEnum.values())
        {
            if(item.getLogid() == logid)
            {
                return item.getVal();
            }
        }
        return "未知的类型";
    }
}
