package com.jw.mockdata.generator.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.KeyValue;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Slf4j
public class exportTool
{
    /**
     * 导出Csv格式
     *
     * @param
     * @param
     * @author djw
     * @return
     */
    public static ByteArrayOutputStream exportCsv(String category, List<Map<String, String>> columns, List<Map<String, Object>> datas){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;

        try {
            //out.write(new byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
            osw = new OutputStreamWriter(out, "GB2312");//UTF-8
            bw =new BufferedWriter(osw);
            for (int i = 0; i < columns.size(); i++)
            {
                bw.append("\"").append(columns.get(i).get("title")).append("\"");
                if((i+1)<columns.size())
                {
                    bw.append(",");
                }
            }
            bw.append("\r\n");
            for (int rownum = 0; rownum < datas.size(); rownum++)
            {
                for (int cellnum = 0; cellnum < columns.size(); cellnum++)
                {
                    String filed = columns.get(cellnum).get("field");
                    try
                    {
                        Object ob = datas.get(rownum).get(filed);
                        String result = exportCsv4Obj(ob);
                        bw.append("\"").append(result).append("\"");
                        if((cellnum+1)<columns.size())
                        {
                            bw.append(",");
                        }
                    }
                    catch (ClassCastException e)
                    {
                        e.printStackTrace();
                        log.error("",e);
                        //SimpleLog.outErr("导出表格强转错误" + "列名" + ":" + filed);
                    }
                }
                bw.append("\r\n");
            }
        } catch (Exception e) {
            //SimpleLog.outException(e);
            log.error("",e);
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return out;
    }


    /**
     * 导出Csv格式
     *
     * @param
     * @param
     * @author djw
     * @return
     */
    public static ByteArrayOutputStream exportCsv4DT(String category, List<KeyValue<String, String>> columns, List<Map<String, String>> datas){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;

        try {
            //out.write(new byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
            osw = new OutputStreamWriter(out, "GB2312");//UTF-8
            bw =new BufferedWriter(osw);
            for (int i = 0; i < columns.size(); i++)
            {
                bw.append("\"").append(columns.get(i).getValue()).append("\"");
                if((i+1)<columns.size())
                {
                    bw.append(",");
                }
            }
            bw.append("\r\n");
            for (int rownum = 0; rownum < datas.size(); rownum++)
            {
                for (int cellnum = 0; cellnum < columns.size(); cellnum++)
                {
//                    String filed = columns.get(cellnum).get("field");
                    try
                    {
                        Object ob = datas.get(rownum).get(columns.get(cellnum).getKey());
                        String result = exportCsv4Obj(ob);
                        bw.append("\"").append(result).append("\"");
                        if((cellnum+1)<columns.size())
                        {
                            bw.append(",");
                        }
                    }
                    catch (ClassCastException e)
                    {
                        e.printStackTrace();
                        log.error("导出表格强转错误" + "rownum" + ":" + rownum+";cellnum:"+cellnum);
                    }
                }
                bw.append("\r\n");
            }
        } catch (Exception e) {
            log.error("",e);
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return out;
    }

    /**
     * Csv中对象转String格式转换
     * @param ob
     * @return
     */
    private static String exportCsv4Obj(Object ob )
    {
        String result ="";
        if(ob == null)
        {
            result = "";
        }
        else if (ob instanceof Timestamp||ob instanceof Date)
        {
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Timestamp ts = (Timestamp)ob;
            result = sdf.format(ob);
        }
        else if (ob instanceof BigDecimal)
        {
            BigDecimal v = ((BigDecimal)ob);
            result = String.valueOf(v);
        }else if (ob instanceof Double)
        {
            Double v = ((Double)ob);
            result =  String.valueOf(v);
        }else if (ob instanceof Integer)
        {
            Integer v = ((Integer)ob);
            result =  String.valueOf(v);
        }
        else
        {
            if(StringUtil.isNumeric((String)ob)&&((String)ob).length()>11)
            {
                result = ((String)ob).replaceAll("\"", "\"\"")+"\t";
            }
            else
            {
                result = ((String)ob).replaceAll("\"", "\"\"");
            }
        }
        return result;
    }
}
