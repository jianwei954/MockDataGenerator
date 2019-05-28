package com.jw.mockdata.generator.model;

/**
 * 日志类型
 * Created by dell on 2017/11/8.
 */
public class LogType {
    /**
     * 登陆
     */
    public static int LOGIN = 1100;
    /**
     * 性能
     */
    public static int PERFORMANCE = 1000;
    /**
     * 异常
     */
    public static int EXCEPTION = 1001;
    /**
     * 操作
     */
    public static int OPERATE = 1002;

    /**
     * 系统日志
     */
    public static int SYSTEM_NORMAL_LOG = 10000;

    /**
     * 系统异常日志
     */
    public static int SYSTEM_EXCEPTION_LOG = 99999;

    /**
     * 轨迹分析
     */
    public static int LOCUS_LOG = 10100;

    /**
     * 车辆卡口
     */

    public static int CAR_LOG = 10200;

    /**
     * Wifi日志
     */
    public static int WIFI_LOG = 10300;

    /**
     * 热点名查询
     */
    public static int CONNECT_HOTSPOT_NAME_QUERY_LOG = 10401;

    /**
     * 终端连接
     */
    public static int CONNECT_PHONE_LOG = 10402;

    /**
     * 热点连接
     */
    public static int CONNECT_HOTSPOT_LOG = 10403;

    /**
     * 围栏
     */
    public static int FENCE_LOG = 10500;

    /**
     * 临控记录
     */
    public static int CONTROL = 10600;

    /**
     * 高级分析
     */
    public static int DATA_COMPARISON_LOG = 10700;

    /**
     * rtt
     */
    public static int SERCRET_LOG = 110110;

    /**
     * 统计分析
     */
    public static int STATISTICS_LOG = 110120;

    /**
     * 基础信息管理
     */
    public static int EXT_LOG = 110130;

    /**
     * 热点基础信息管理
     */
    public static int EXT_LOGBY_ESSID = 110130;

    /**
     * 手机采集
     */
    public static int COLLECT_LOG = 110150;

    /**
     * 案情比对
     */
    public static int CASE_INFO_LOG = 110160;

    /**
     * 案情比对
     */
    public static int QIANKE_LOG = 110170;
}
