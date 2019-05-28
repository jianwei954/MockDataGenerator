package com.jw.mockdata.generator.util;

import com.jw.mockdata.generator.dto.sys.UserDTO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dell on 2017/4/28.
 */
public class FinalUtil
{
    //用户Cookie名称
    public static final String TOKENID = "TOKENID";
    //数据存储数据库类型
    public static final String DATABASE_ORCL = "orcl";
    //配置文件指向的数据库
    public static final String DATABASE_TYPE = PropertiesUtil.read("databasetype");
    //当前平台操作系统
    private static String OS_TYPE = "LINUX";

    //索引表数据，Hbase相关表数据
    public static final String COLUMN_FAMILY="info";
    public static final byte[] COLUMN_FAMILY_BYTES = "info".getBytes();
    public static final String COLUMN_ID2GID_FAMILY_AP="ap";
    //索引表数据，Hbase相关表数据,wifi:mobilemsg_rel表使用,统计常去点位
    public static final String COLUMN_FAMILY_STATS_DEVICE="dev";
    //索引表数据，Hbase相关表数据,wifi:mobilemsg_rel表使用,统计24小时活动规律
    public static final String COLUMN_FAMILY_STATS_24HOUR="day";
    //索引表数据，Hbase相关表数据,wifi:mobilemsg_rel表使用,统计月活动规律
    public static final String COLUMN_FAMILY_STATS_DAYINMONTH="month";
    //索引表数据，Hbase相关表数据
    public static final String COLUMN_FAMILY_IDX="idx";
    //索引表数据，Hbase相关表数据
    public static final String TABLE_IDS2GID="wifi:id2gid";
    //APMSG表数据，Hbase相关表数据
    public static final String TABLE_WIFI_APMSG="wifi:apmsg";
    //MOBILECOMAP表数据，Hbase相关表数据
    public static final String TABLE_WIFI_MOBILECOMAP="wifi:mobileconap";
    //MOBILEESSID表数据，Hbase相关表数据
    public static final String TABLE_WIFI_MOBILEESSID  ="wifi:mobileessid";
    //MOBILEMSG表数据，Hbase相关表数据
    public static final String TABLE_WIFI_MOBILEMSG  ="wifi:mobilemsg";
    //MOBILEMSG表数据，Hbase相关表数据
    public static final String TABLE_WIFI_MOBILEMSG_REL  ="wifi:mobilemsg_rel";
    //PHONEDATA表数据，Hbase相关表数据
    public static final String TABLE_WIFI_PHONEDATA="wifi:phonedata";
    //PHONEDATA表数据，Hbase相关表数据
    public static final String TABLE_WIFI_PHONEDATA_REL="wifi:phonedata_rel";
    public static final byte[] TABLE_WIFI_PHONEDATA_REL_BYTES = TABLE_WIFI_PHONEDATA_REL.getBytes();
    //PHONEDATA表数据，Hbase相关表数据
    public static final String TABLE_WIFI_INTERNETID="wifi:internetId";
    //索引表数据，Hbase相关表数据
    public static final String TABLE_WIFI_INTERNETIDINDEX="wifi:internetIdIndex";
    //同网关系表数据，Hbase相关表数据
    public static final String TABLE_WIFI_MOBILECONAP_REL="wifi:mobileconap_rel";
    //历史连接 表数据，Hbase相关表数据
    public static final String TABLE_WIFI_MOBILEESSID_REL="wifi:mobileessid_rel";
    //APMAC-热点名 表数据，Hbase相关表数据
    public static final String TABLE_WIFI_APMSG_REL="wifi:apmsg_rel";

    public static final byte[] QUALIFY_INTIME = "intime".getBytes();
    public static final byte[] QUALIFY_UPTIME = "uptime".getBytes();
    public static final byte[] QUALIFY_MAC = "mac".getBytes();
    public static final byte[] QUALIFY_COUNT = "count".getBytes();
    public static final byte[] QUALIFY_APPID = "appid".getBytes();
    public static final byte[] QUALIFY_USERID = "userid".getBytes();
    public static final byte[] QUALIFY_USERNAME = "username".getBytes();
    /**
     * 数据是否存储在Oracle
     * @return
     */
    public static final Boolean IS_ORCL_DATABASE(){
        return DATABASE_ORCL.toUpperCase().equals(DATABASE_TYPE.toUpperCase());
    }

    //Hbase相关表数据
    public static final String MOBILE_MSG_SERVICE_IMPL_HBASE="MobileMsgServiceImplHbase";
    public static final String CONNECT_SERVICE_IMPL_HBASE="ConnectServiceImplHbase";
    public static final String PHONEDATA3_SERVICE_IMPL_HBASE="PhoneData3ServiceImplHbase";
    public static final String ESSID_SERVICE_IMPL_HBASE="EssidServiceImplHbase";
    public static final String STATISTIC_DEDUPLICATION_SERVICE_IMPL_HBASE="StatisticDeduplicationServiceImplHbase";
    public static final String STATISTIC_SERVICE_IMPL_HBASE="StatisticServiceImplHbase";

    //Orcl相关表数据
    public static final String MOBILE_MSG_SERVICE_IMPL_ORCL="MobileMsgServiceImplOrcl";
    public static final String CONNECT_SERVICE_IMPL_ORCL="ConnectServiceImplOrcl";
    public static final String PHONEDATA3_SERVICE_IMPL_ORCL="PhoneData3ServiceImplOrcl";
    public static final String ESSID_SERVICE_IMPL_ORCL="EssidServiceImplOrcl";
    public static final String STATISTIC_DEDUPLICATION_SERVICE_IMPL_ORCL="StatisticDeduplicationServiceImplOrcl";
    public static final String STATISTIC_SERVICE_IMPL_ORCL="StatisticServiceImplOrcl";

    public  static String MOBILE_MSG_SERVICE_IMPL;
    static {
        if(IS_ORCL_DATABASE())
            MOBILE_MSG_SERVICE_IMPL=MOBILE_MSG_SERVICE_IMPL_ORCL;
        else
            MOBILE_MSG_SERVICE_IMPL=MOBILE_MSG_SERVICE_IMPL_HBASE;
    }
    public  static String CONNECT_SERVICE_IMPL;
    static {
        if(IS_ORCL_DATABASE())
            CONNECT_SERVICE_IMPL=CONNECT_SERVICE_IMPL_ORCL;
        else
            CONNECT_SERVICE_IMPL=CONNECT_SERVICE_IMPL_HBASE;
    }
    public  static String PHONEDATA3_SERVICE_IMPL;
    static {
        if(IS_ORCL_DATABASE())
            PHONEDATA3_SERVICE_IMPL=PHONEDATA3_SERVICE_IMPL_ORCL;
        else
            PHONEDATA3_SERVICE_IMPL=PHONEDATA3_SERVICE_IMPL_HBASE;
    }
    public  static String ESSID_SERVICE_IMPL;
    static {
        if(IS_ORCL_DATABASE())
            ESSID_SERVICE_IMPL=ESSID_SERVICE_IMPL_ORCL;
        else
            ESSID_SERVICE_IMPL=ESSID_SERVICE_IMPL_HBASE;
    }

    public  static String STATISTIC_DEDUPLICATION_SERVICE_IMPL;
    static {
        if(IS_ORCL_DATABASE())
            STATISTIC_DEDUPLICATION_SERVICE_IMPL=STATISTIC_DEDUPLICATION_SERVICE_IMPL_ORCL;
        else
            STATISTIC_DEDUPLICATION_SERVICE_IMPL=STATISTIC_DEDUPLICATION_SERVICE_IMPL_HBASE;
    }
    public  static String STATISTIC_SERVICE_IMPL;
    static {
        if(IS_ORCL_DATABASE())
            STATISTIC_SERVICE_IMPL=STATISTIC_SERVICE_IMPL_ORCL;
        else
            STATISTIC_SERVICE_IMPL=STATISTIC_SERVICE_IMPL_HBASE;
    }

    /**
     * 已登录usermap
     */
    public static Map<String, UserDTO> USER_MAP = new ConcurrentHashMap<>();
    public static int TOKEN_TIMEOUT(){
        return PropertiesUtil.readInt("TOKEN_TIMEOUT",60);
    }

    public static String getOsType() {
        return OS_TYPE;
    }

    public static void setOsType(String osType) {
        OS_TYPE = osType;
    }
}
