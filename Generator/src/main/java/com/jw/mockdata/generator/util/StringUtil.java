package com.jw.mockdata.generator.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串String相关处理工具类
 * Created by djw on 2017/2/20.
 */
public class StringUtil
{
    /**
     * 是否为空字符串
     * @param str 需要验证的字符串对象
     * @return str为null或者长度等于0时返回true；否则返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }
    /**
     * 是否不为空字符串（只包含空格也算空串）
     * @param str 需要验证的字符串对象
     * @return 空串返回True
     */
    public static boolean isBlank(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 取字符串中在分隔符（separator）前的字符串
     * 如果字符串中不包含分隔符，则返回整个字符串str
     * 不区分大小写
     * @param str 字符串
     * @param separator 分隔符。为空时将返回未空字符串
     * @return 返回分隔符前的字符串
     */
    public static String substringBefore(String str, String separator) {
        if(!isEmpty(str) && separator != null) {
            if(separator.length() == 0) {
                return "";
            } else {
                int pos = str.toUpperCase().indexOf(separator.toUpperCase());
                return pos == -1 ? str : str.substring(0, pos);
            }
        } else {
            return str;
        }
    }
    /**
     * 全角转半角
     *
     * @param QJstr 字符串
     * @return 转换后的字符串
     */
    @Deprecated
    public static String full2HalfChange(String QJstr)
        throws UnsupportedEncodingException
    {
        StringBuffer outStrBuf = new StringBuffer("");
        String Tstr = "";
        byte[] b = null;

        for (int i = 0; i < QJstr.length(); i++) {
            Tstr = QJstr.substring(i, i + 1);

            // 全角空格转换成半角空格
            if (Tstr.equals("　")) {
                outStrBuf.append(" ");
                continue;
            }
            // 得到 unicode 字节数据
            b = Tstr.getBytes("unicode");

            if (b[2] == -1) {
                // 表示全角
                b[3] = (byte) (b[3] + 32);
                b[2] = 0;
                outStrBuf.append(new String(b, "unicode"));
            } else {
                outStrBuf.append(Tstr);
            }
        } // end for.

        return outStrBuf.toString();
    }
    public static boolean isNumber(String str)
    {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    public static boolean isPhoneNumber(String str)
    {
        Pattern pattern = Pattern.compile("[+86|86]{0,1}[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    /**
     * 全角转半角并去不可见字符     *
     * @param QJstr 原始字符
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String full2HalfChange2(String QJstr) {
        StringBuffer outStrBuf = new StringBuffer("");
        for (int m = 0; m < QJstr.length(); m++) {
            char ch = QJstr.charAt(m);
            int chi = (int) ch;
            if (chi > 0) {
                if (Character.isSpaceChar(chi))
                    ch = ' ';
                else if (chi > 65279) {
                    byte b0 = (byte) chi;
                    ch = (char) (byte) (b0 + 32);
                }
                outStrBuf.append(ch);
            }
        }
        return outStrBuf.toString();
    }

    /**
     * 根据字符编码取最大长度
     * 字符编码<128的算一个字节长度
     * 字符编码>2048的算三个字节长度
     * 其他默认算两个字节长度
     * @param s
     * @param maxlength
     * @return
     */
    public static String cutstringbyUTF8byte(String s, int maxlength)
    {
        if(s==null || s.length()*3 <=  maxlength)
        {
            return s;
        }
        else
        {
            int index = -1;
            int current = 0;
            for(int j = 0; j < s.length(); j++)
            {
                if(s.charAt(j) < 128)
                {
                    current = current + 1;
                }
                else if (s.charAt(j) >= 2048)
                {
                    current = current + 3;
                }
                else
                {
                    current = current + 2;
                }
                if(current > maxlength)
                {
                    break;
                }
                else
                {
                    index ++;
                }
            }
            return s.substring(0, index+1);
        }
    }

    /**
     * 替换字符
     * @param str
     * @param searchChars
     * @param replaceChars
     * @return
     */
    public static String replaceChars(String str, String replaceChars, String... searchChars) {
        if(!isEmpty(str)) {
            for(String sc :searchChars)
            {
                str = str.replace(sc,replaceChars);
            }
        }
        return str;
    }
    /**
     * 替换字符
     * @param str
     * @param searchChars
     * @param replaceChars
     * @return
     */
    public static String replaceChars(String str, String searchChars, String replaceChars) {
        if(!isEmpty(str) && !isEmpty(searchChars)) {
            if(replaceChars == null) {
                replaceChars = "";
            }

            boolean modified = false;
            int replaceCharsLength = replaceChars.length();
            int strLength = str.length();
            StringBuffer buf = new StringBuffer(strLength);

            for(int i = 0; i < strLength; ++i) {
                char ch = str.charAt(i);
                int index = searchChars.indexOf(ch);
                if(index >= 0) {
                    modified = true;
                    if(index < replaceCharsLength) {
                        buf.append(replaceChars.charAt(index));
                    }
                } else {
                    buf.append(ch);
                }
            }

            if(modified) {
                return buf.toString();
            } else {
                return str;
            }
        } else {
            return str;
        }
    }
    /**
     * listToString 的反向操作
     *
     * @param str
     * @param split
     * @return
     */
    public static List<String> stringToList(String str, String split) {
        List<String> codes = new ArrayList<String>();
        if (null == str)
            return codes;
        String[] temp = str.trim().split(split, -1);
        return Arrays.asList(temp);
    }

    public static String listToString(Collection<String> str, String split) {
        if (CollectionUtil.isEmpty(str))
            return null;
        StringBuilder bu = new StringBuilder();
        int pos = 0;
        for (String temp : str) {
            pos++;
            if (temp != null && !temp.equals(""))
                bu.append(temp.trim());
            if (pos < str.size())
                bu.append(split);
        }
        return bu.toString();
    }
    /**
     * 对字符串用 符号token进行分离字符，保存在数组中，默认下不会返回分隔符。
     * 比如1,2,3,4的字符，分隔后的结果是{1,2,3,4}
     *
     * @param s
     * @param token
     * @return
     */
    public static String[] split(String s, String token) {
        if (s == null) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(s, token);
        int size = st.countTokens();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = st.nextToken();
        }

        return result;
    }
    public static String subString(String str,int start,int end)
    {
        if(str.length()>end)
        {
            return str.substring(start,end);
        }
        else
        {
            return str.substring(start,str.length());
        }
    }
    public static String arrayToString(String[] content,String splid) {

        String res = "";
        if(content!=null) {
            for (String item : content) {
                res += splid + item;
            }
            return res.substring(splid.length());
        }
        else {
            return "全部";
        }
    }
    /**
     * 判断是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if(StringUtil.isBlank(str))
            return false;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 统计字符串中某字符出现的次数
     *
     * @param str
     * @return
     */
    public static int countChar(String str,char c) {
        if(StringUtil.isBlank(str))
            return 0;
        int count=0;
        for(char cstr:str.toCharArray())
        {
            if(cstr==c)
            {
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("deprecation")
    public static String encryptPassword2(String password) {
        if (!StringUtil.isBlank(password))
            return DigestUtils.shaHex(password);
        else
            return password;
    }
    public static String filter(String content) {
        return content == null ? "" : content;
    }

    /**
     * MAC是否只包含F和0（只包含空格也算空串）
     * @param str 需要验证的字符串对象
     * @return 空串返回false /只包含F或0 返回true
     */
    public static boolean isMacAll0orF(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            String o2 = str.replaceAll("F","")
                    .replaceAll("f","")
                    .replaceAll("0","");
            if(o2.length()>0)
                return false;
            return true;
        } else {
            return false;
        }
    }
    /**
     * MAC去标识  转大写
     */
    public static String isMacGSH(String value) {
        return  value.replaceAll("[^a-z^A-Z^0-9]", "").toUpperCase();
    }
}
