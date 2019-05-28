package com.jw.mockdata.generator.model;


import com.jw.mockdata.generator.util.PropertiesUtil;

import java.io.Serializable;

/**
 * Created by dell on 2017/3/19.
 */
public class Result implements Serializable
{
    public Result()
    {
    }

    public Result(int code)
    {
        this.setCode(code);
        this.setMsg(PropertiesUtil.readException(code + ""));
    }
    public Result(int code,boolean success)
    {
        this.setCode(code);
        this.setSuccess(success);
        this.setMsg(PropertiesUtil.readException(code + ""));
    }
    public Result(boolean success,Object obj)
    {
        this.success = success;
        this.obj = obj;
    }
    public Result(boolean success,Object obj,String msg)
    {
        this.success = success;
        this.obj = obj;
        this.msg = msg;
    }
    private String msg;
    private boolean success = true;
    private Object obj;
    private int code;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }
}
