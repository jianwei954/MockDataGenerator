package com.jw.mockdata.generator.model;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {

    嫌疑人基本信息("SuspectsBasicInfo", "嫌疑人基本信息"),
    嫌疑人基本信息old("SuspectsBasicInfoold", "嫌疑人基本信息"),
    手机基本信息("PhoneBaseInfo", "手机基本信息"),
    手机照片("PhonePhoto", "手机照片"),
    手机录像("PhoneVideo", "手机录像"),
    手机音频("PhoneAudio", "手机音频"),
    通讯录("Contacts", "通讯录"),
    通讯录明细("ContactsDetail", "通讯录明细"),
    短信("SMS", "短信"),
    短信统计("SMSCOUNT", "短信统计"),
    通话记录("CallRecords", "通话记录"),
    通话记录统计("CallRecordCount", "通话记录统计"),
    历史记录("WebCookie", "历史记录"),
    车辆基本信息("CarBaseInfo", "车辆基本信息"),
    案件基本信息("Case-BasicInfo", "案件基本信息"),
    案件多媒体("Case-Media", "案件多媒体"),
    案件Wifi("Case-Wifi", "案件Wifi"),
    基站信息("BaseStationInfo", "基站信息"),
    周边无线("PeripheralWireless", "周边无线"),//COLLECT_BaseInfo_Wifi
    银行卡基本信息("BankBasicInfo", "银行卡基本信息"),
    餐饮订餐("BookDinner", "餐饮订餐"),
    汽摩维修("CarRepair", "汽摩维修"),
    经营户("Company", "经营户"),
    二手手机交易("OldPhoneTrade", "二手手机交易"),
    地图标注("MapMark", "地图标注"),
    线索("Clues", "线索"),
    微信("Wechat", "微信"),
    微信好友("WechatFriends", "微信好友"),
    微信信息表("WechatMessages", "微信信息表"),
    QQ账号("QQ", "QQ账号"),
    QQ好友("QQFriends", "QQ好友"),
    QQ信息("QQMessages", "QQ信息"),
    备忘录("Memo", "备忘录"),
    日历("Calendar", "日历"),
    语音邮箱("VoiceMail", "语音邮箱"),
    Wifi("Wifi", "Wifi"),
    蓝牙("Bluetooth", "蓝牙"),
    应用("Application", "应用"),
    行业员工("IndustryEmployee", "行业员工"),
    行业信息("IndustryRecord", "行业信息"),
    作假信息("MsssInfo", "作假信息"),


    core_seo_qx_1("core_seo_qx_1", "轨迹查询"),
    core_seo_qx_2("core_seo_qx_2", "终端链接"),
    core_seo_qx_3("core_seo_qx_3", "历史链接缓存"),
    core_seo_qx_4("core_seo_qx_4", "虚拟日志"),
    core_seo_qx_5("core_seo_qx_5", "虚拟身份"),
    core_seo_qx_6("core_seo_qx_6", "手机核采"),

    essid_essid_query("essid_essid_query", "热点名查询"),

    ext_device_queryqx_1("ext_device_queryqx_1", "终端轨迹"),
    ext_device_queryqx_2("ext_device_queryqx_2", "终端连接"),
    ext_device_queryqx_3("ext_device_queryqx_3", "历史连接缓存"),
    ext_device_queryqx_4("ext_device_queryqx_4", "虚拟日志"),

    connect_query("connect_query", "终端连接"),
    connect_query_dev("connect_query_dev", "热点连接"),
    connect_his_query("connect_his_query", "终端历史链接"),
    connect_his_essid_query("connect_his_essid_query", "热点历史连接"),

    datacomparison_lookdata("datacomparison_lookdata", "切块分析"),
    datacomparison_divquery("datacomparison_divquery", "切块统计"),
    hisrelation_look("hisrelation_look", "历史连接关系"),
    awith_look("awith_lookdata", "同行分析"),


    deivece_query("deivece_query", "设备列表"),

    core_fence_qx_0("core_fence_qx_0", "关联查询"),
    core_fenceonly_qx_0("core_fenceonly_qx_0", "围栏查询"),
    core_wifi_qx_0("core_wifi_qx_0", "wifi轨迹"),

    core_fence_device_queryqx("core_fence_device_queryqx", "围栏设备查询"),

    clzk("clzk", "车辆卡口"),
    ;

    public static CategoryEnum toCategoryEnum(String value) {
        return codeMap.get(value);
    }

    public static String getNameByCode(String value) {
        CategoryEnum unitcode = codeMap.get(value);
        if (unitcode != null) {
            return unitcode.getName();
        }
        return "未知状态";
    }

    private static Map<String, CategoryEnum> codeMap;
    private static Map<String, CategoryEnum> nameMap;

    static {
        codeMap = new HashMap<String, CategoryEnum>();
        nameMap = new HashMap<String, CategoryEnum>();
        for (CategoryEnum categoryid : CategoryEnum.values()) {
            codeMap.put(categoryid.getId(), categoryid);
            nameMap.put(categoryid.getName(), categoryid);
        }
    }

    private String categoryid;
    private String name;

    private CategoryEnum(String categoryid, String name) {
        this.categoryid = categoryid;
        this.name = name;
    }

    public String getId() {
        return categoryid;
    }

    public String getName() {
        return name;
    }

    public static Map<String, CategoryEnum> getNameMap() {
        return nameMap;
    }

    public String toString() {
        return this.getId() + "-" + this.getName();
    }

    public CategoryEnum getNextCategoryId() {
        return null;
    }

    public static void main(String[] args) {
        for (CategoryEnum status : CategoryEnum.values()) {
            System.out.println(CategoryEnum.core_seo_qx_1);
        }
    }
}
