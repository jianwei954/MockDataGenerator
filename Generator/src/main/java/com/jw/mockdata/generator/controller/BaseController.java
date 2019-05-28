package com.jw.mockdata.generator.controller;

import com.jw.mockdata.generator.dto.sys.UserDTO;
import com.jw.mockdata.generator.dto.sys.UserLog;
import com.jw.mockdata.generator.enums.UserLogEnum;
import com.jw.mockdata.generator.util.FinalUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jw.mockdata.generator.util.PropertiesUtil;
import com.jw.mockdata.generator.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/19.
 * <p>
 * 主要是getRequest，和getResponse获取Request和Response，然后进行一系列操作
 */
public class BaseController {


    private static Log logger = LogFactory.getLog(BaseController.class);
    /**
     * 超时时间
     */
    private Long session_time_out = 1000 * 60 * 60 * 1L;

    /**
     * 账号中心根据COOKIE拿取token
     *
     * @return
     */
    //根据res获取cookie
    public String getCookie(String cookiekey) {
        Cookie[] cookies = getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookiekey)) {
                    String token = cookie.getValue();
                    return token;
                }
            }
        }
        return "";
    }

    //获取request
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
    }

    //获取response
    protected HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }


    protected String getIP() {

        String fromSource = "X-Real-IP";
        String ip = getRequest().getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("X-Forwarded-For");
            fromSource = "X-Forwarded-For";
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("Proxy-Client-IP");
            fromSource = "Proxy-Client-IP";
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("WL-Proxy-Client-IP");
            fromSource = "WL-Proxy-Client-IP";
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getRemoteAddr();
            fromSource = "request.getRemoteAddr";
        }
        if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                logger.error(e);
            }
        }
        return ip;
    }

    /**
     * 获取页面前端js过来的json对象
     *
     * @return
     */
    protected Map<String, Object> getJsonMap() {
        try {
            //使用jackson
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap =
                    //把json格式转成Map
                    objectMapper.readValue(
                            //req.getParameter获取页面传过来的数据
                            URLDecoder.decode(getRequest().getParameter("json"), "utf-8"), Map.class);
            return jsonMap;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取页面前端js过来的json对象
     *
     * @return
     */
    //获取json数据中的prop
    protected Object getJsonProp(String prop) {
        try {
            return getJsonMap().get(prop);
        } catch (Exception e) {
            return null;
        }
    }

    protected Boolean getJsonPropBoolean(String prop) {
        try {
            if (getJsonMap().get(prop) != null)
                return new Boolean(getJsonMap().get(prop).toString());
            else
                return false;
        } catch (Exception e) {
            return null;
        }
    }

    protected Boolean getJsonPropBoolean(String prop, boolean defualt) {
        try {
            if (getJsonMap().get(prop) != null)
                return new Boolean(getJsonMap().get(prop).toString());
            else
                return false;
        } catch (Exception e) {
            return defualt;
        }
    }

    /**
     * 获取页面前端js过来的json对象
     *
     * @return
     */
    //获取prop中的值，转成Integer类型
    protected Integer getJsonPropInt(String prop) {
        try {
            if (getJsonMap().get(prop) != null)
                return new Integer(getJsonMap().get(prop).toString());
            else
                return -1;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取页面前端js过来的json对象
     *
     * @return
     */
    //获取prop中的值，转成Integer类型
    protected Long getJsonPropLong(String prop) {
        try {
            if (getJsonMap().get(prop) != null)
                return new Long(getJsonMap().get(prop).toString());
            else
                return -1L;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取页面前端js过来的json对象
     *
     * @return
     */
    //获取prop中的值，转成Integer类型
    protected Integer getJsonPropInt(String prop, Integer defualt) {
        try {
            if (getJsonMap().get(prop) != null)
                return new Integer(getJsonMap().get(prop).toString());
            else
                return -1;
        } catch (Exception e) {
            return defualt;
        }
    }

    /**
     * 获取页面前端js过来的json对象
     *
     * @return
     */
    //获取prop中的值，转成Short类型
    protected Short getJsonPropShort(String prop) {
        try {
            if (getJsonMap().get(prop) != null)
                return new Short(getJsonMap().get(prop).toString());
            else
                return -1;
        } catch (Exception e) {
            return null;
        }
    }

    protected Integer getPageIndex() {
        return getJsonPropInt("p", 1);
    }

    protected Integer getPagePerSize(int defualt) {
        return getJsonPropInt("s", defualt);
    }

    /**
     * 获取页面前端js过来的json对象
     *
     * @return
     */
    //获取prop中的值，转成String类型
    protected String getJsonPropString(String prop) {
        try {
            if (getJsonMap().get(prop) != null)
                return getJsonMap().get(prop).toString();
            else
                return "";
        } catch (Exception e) {
            return null;
        }
    }
    protected void putJsonPropString(String prop,Object val) {
        try {
            if (getJsonMap() != null)
                getJsonMap().put(prop,val);
        } catch (Exception e) {
        }
    }

    protected String toJson(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return null;
        }
    }

    protected <T> T JsontoObject(String json, Class<T> t) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            return mapper.readValue(json, t);
        } catch (Exception e) {
            return null;
        }
    }

    protected <T> T JsontoArray(String json, TypeReference<T> jsonTypeReference) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            return (T)mapper.readValue(json,jsonTypeReference);
        } catch (Exception e) {
            return null;
        }
    }

    //存入usermap中
    public void putUsermap(String token, UserDTO user) {
        user.setUpdatetime(new Date());
        FinalUtil.USER_MAP.put(token, user);
    }

    public UserDTO getUserbycookie() {
        UserDTO tSysUserDTO =getUserByTokenID(getCookie(FinalUtil.TOKENID));
        if(null!=tSysUserDTO)
        {
            tSysUserDTO.setUpdatetime(new Date());
        }
        return tSysUserDTO;
    }

    public UserDTO getUserByTokenID(String tokenid){
        UserDTO tSysUserDTO = FinalUtil.USER_MAP.get(tokenid);
        if(tSysUserDTO!=null)
        {
            //计算区间毫秒数
            Duration d = new Duration(new DateTime(tSysUserDTO.getUpdatetime()),DateTime.now());
            long thour = d.getStandardMinutes();
            if(thour>=FinalUtil.TOKEN_TIMEOUT())
            {
                FinalUtil.USER_MAP.remove(tokenid);
                return null;
            }
        }
        return tSysUserDTO;
    }

    /**
     * 获取当前登录用户用户名
     *
     * @return
     */
    protected String getUserName() {
        if (getUserbycookie() != null) {
            return getUserbycookie().getChineseName();
        } else {
            return null;
        }
    }

    /**
     * 查询一条日志
     *
     * @return
     */
    protected UserLog logSch(String loginName,String content,int logType) {
//        Page page = PageHelper.startPage(1, 1, false);
//        UserLogExample userLogExample = new UserLogExample();
//        userLogExample.createCriteria().andUseridEqualTo(loginName).andContentEqualTo(content).andLogtypeEqualTo(BigDecimal.valueOf(logType));
//        userLogExample.setOrderByClause("DB_INSDATE DESC");
//        List<UserLog> list = userLogMapper.selectByExample(userLogExample);
//        if( list!=null&&list.size()>0)
//        {
//            return list.get(0);
//        }
//        else
            return null;
    }
    /**
     * 插入一条日志
     *
     * @return
     */
    protected void logIns(String content, String remark,Double queryduration,int logType) {
        logIns(getUserbycookie().getLoginName(),content,remark,queryduration,logType);
    }
    /**
     * 插入一条日志
     *
     * @return
     */
    protected void logIns(String remark,int logType) {
        logIns(getUserbycookie().getLoginName(),"",remark,0.0,logType);
    }
    /**
     * 插入一条日志
     *
     * @return
     */
    protected void logIns(String content, String remark,int logType) {
        logIns(getUserbycookie().getLoginName(),content,remark,0.0,logType);
    }
    /**
     * 插入一条日志
     *
     * @return
     */
    protected void logIns(String loginName,String content,String remark,Double queryduration, int logType) {
        try {
            UserLog userLog = new UserLog();
            userLog.setUserid(loginName);
            userLog.setUserip(getIP());

            userLog.setLogtype(new BigDecimal(logType));
            userLog.setQueryduration(new BigDecimal(queryduration));
            userLog.setRemarks (remark);
            userLog.setContent(content);
            userLog.setDbInsdate(new Date());

//            userLogMapper.insert(userLog);
        } catch (Exception e) {
            logger.error("【保存日志失败】" + logType + ":" + logType);
        }
    }
    /**
     * 保存用户操作日志
     *
     * @param content       json格式参数
     * @param remarks       页面显示参数
     * @param queryduration 时长
     * @param userLogEnum   类别
     */
    protected void saveUserLog(String content, String remarks, Double queryduration,
                               UserLogEnum userLogEnum, String... key) {

        try {
            UserLog userLog = new UserLog();
            UserDTO user = getUserbycookie();
            if(user==null)
            {
                return;
            }
            userLog.init(user.getLoginName(), getIP());
            userLog.setLogtype(new BigDecimal(userLogEnum.getLogid()));
            userLog.setQueryduration(new BigDecimal(queryduration));
            userLog.setContent(content);
            userLog.setRemarks(remarks);
            userLog.setDbInsdate(new Date());
            if (key.length > 0)
                userLog.setKey(key[0]);
//            userLogMapper.insert(userLog);

        } catch (Exception err) {
            //logger.trace(err);
            logger.error(err);
        }
    }

    public static boolean isNumber(String value) {

        return isInteger(value) || isDoubble(value);
    }

    public static boolean isInteger(String value) {

        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            try {
                Long.parseLong(value);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }

    public static boolean isDoubble(String value) {

        try {
            Double.parseDouble(value);
            if (value.contains(".")){
                String[] strs = value.split("\\.");
                if(strs.length==2){
                    if(isInteger(strs[0]) && isInteger(strs[1])){
                        return true;
                    }
                }
            }
            return false;

        } catch (NumberFormatException e) {
            return false;
        }
    }
    public double testf_lngr2(double distance, double f_lng, double f_lat) {
        distance =distance/1000;

        MyLatLng getMyLatLng = getMyLatLng(new MyLatLng(f_lng,f_lat),distance,90);

        return getMyLatLng.m_Longitude - f_lng;

    }
    public static MyLatLng getMyLatLng(MyLatLng A,double distance,double angle){

        angle = 90;
        double dx = distance*1000*Math.sin(Math.toRadians(angle));
        double dy = distance*1000*Math.cos(Math.toRadians(angle));

        double bjd=(dx/A.Ed+A.m_RadLo)*180./Math.PI;
        double bwd=(dy/A.Ec+A.m_RadLa)*180./Math.PI;
        return new MyLatLng(bjd, bwd);
    }

    static class MyLatLng {
        final static double Rc=6378137;
        final static double Rj=6356725;
        double m_LoDeg,m_LoMin,m_LoSec;
        double m_LaDeg,m_LaMin,m_LaSec;
        double m_Longitude,m_Latitude;
        double m_RadLo,m_RadLa;
        double Ec;
        double Ed;
        public MyLatLng(double longitude,double latitude){
            m_LoDeg=(int)longitude;
            m_LoMin=(int)((longitude-m_LoDeg)*60);
            m_LoSec=(longitude-m_LoDeg-m_LoMin/60.)*3600;

            m_LaDeg=(int)latitude;
            m_LaMin=(int)((latitude-m_LaDeg)*60);
            m_LaSec=(latitude-m_LaDeg-m_LaMin/60.)*3600;

            m_Longitude=longitude;
            m_Latitude=latitude;
            m_RadLo=longitude*Math.PI/180.;
            m_RadLa=latitude*Math.PI/180.;
            Ec=Rj+(Rc-Rj)*(90.-m_Latitude)/90.;
            Ed=Ec*Math.cos(m_RadLa);
        }
    }


    /**
     * 插入一条日志
     *
     * @return
     */
//    protected void logNewIns(Integer operate_type, String operate_result, String operate_name, String operate_condition, String bz2, int logType) {
//        try {
//            TSysLog tSysLog = new TSysLog();
//            tSysLog.setfId(null);
//            tSysLog.setfContent(msg.toString());
//            tSysLog.setfDuration(0);
//            tSysLog.setfLogtype(logType);
//            tSysLog.setfIp(getIP());
//            tSysLog.setfLoginname(getUserName());
//            tSysLog.setfCtime(new Date());
//            tSysLogMapper.insert(tSysLog);
//        } catch (Exception e) {
//            Logger.exception("【保存日志失败】" + logType + ":" + msg);
//        }
//    }


    /**
     * 获得定制的权限菜单的id map
     *
     * @return
     */
    public Map<Long, Long> getCustomizedPermissionMenu() {
        Map<Long, Long> cpmMap = new HashMap<Long, Long>();
        //获得 有哪些 定制的模块
        String customized = PropertiesUtil.read("customized");
        if (null != customized && !"".equals(customized)) {
            String[] customizeds = customized.split(",");
            if (null != customizeds && customized.length() > 0) {
                for (String customized_key : customizeds) {
                    //获得 该定制模块的权限菜单id
                    String customized_val = PropertiesUtil.read(customized_key);
                    if (null != customized_val && !"".equals(customized_val) && !"0".equals(customized_val)) {
                        String[] pmIds = customized_val.split(",");
                        for (String pmId : pmIds) {
                            cpmMap.put(Long.parseLong(pmId), Long.parseLong(pmId));
                        }
                    }
                }
            }
        }
        return cpmMap;
    }

    /**
     * 获得定制的权限菜单的id 数组
     *
     * @return
     */
    public List<BigDecimal> getCustomizedPermissionMenus() {
        Map<Long, Long> cpmMap = getCustomizedPermissionMenu();
        List<BigDecimal> cpmids = new ArrayList<>();
        int i = 0;
        for (Long id : cpmMap.keySet()) {
            cpmids.add(BigDecimal.valueOf(id));
            i++;
        }
        return cpmids;
    }
    /**
     * 限制i长度加省略号
     *
     * @return
     */
    public String setEllipsis(String str,Integer num) {
        String ret = "";
        if(null==num || num<0)
            num = 5;
        if(!StringUtil.isBlank(str)) {
            ret = str;
            if(str.length()>num){
                ret=str.substring(0,num)+"...";
            }
        }
        return ret;
    }
}
