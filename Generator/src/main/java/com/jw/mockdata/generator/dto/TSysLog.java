package com.jw.mockdata.generator.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TSysLog implements Serializable {
    /**
     * 自增编号
     */
    private Long fId;

    /**
     * 创建时间
     */
    private Date fCtime;

    /**
     * 用户名
     */
    private String fLoginname;

    /**
     * 日志类型
     */
    private Integer fLogtype;

    /**
     * 日志内容
     */
    private String fContent;

    /**
     * 用户IP
     */
    private String fIp;

    /**
     * 备注
     */
    private String fRmk;

    /**
     * 持续时长
     */
    private Integer fDuration;

    /**
     * 关键字
     */
    private String fKey;

    private static final long serialVersionUID = 1L;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Date getfCtime() {
        return fCtime;
    }

    public void setfCtime(Date fCtime) {
        this.fCtime = fCtime;
    }

    public String getfLoginname() {
        return fLoginname;
    }

    public void setfLoginname(String fLoginname) {
        this.fLoginname = fLoginname;
    }

    public Integer getfLogtype() {
        return fLogtype;
    }

    public void setfLogtype(Integer fLogtype) {
        this.fLogtype = fLogtype;
    }

    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    public String getfIp() {
        return fIp;
    }

    public void setfIp(String fIp) {
        this.fIp = fIp;
    }

    public String getfRmk() {
        return fRmk;
    }

    public void setfRmk(String fRmk) {
        this.fRmk = fRmk;
    }

    public Integer getfDuration() {
        return fDuration;
    }

    public void setfDuration(Integer fDuration) {
        this.fDuration = fDuration;
    }

    public String getfKey() {
        return fKey;
    }

    public void setfKey(String fKey) {
        this.fKey = fKey;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TSysLog other = (TSysLog) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfCtime() == null ? other.getfCtime() == null : this.getfCtime().equals(other.getfCtime()))
            && (this.getfLoginname() == null ? other.getfLoginname() == null : this.getfLoginname().equals(other.getfLoginname()))
            && (this.getfLogtype() == null ? other.getfLogtype() == null : this.getfLogtype().equals(other.getfLogtype()))
            && (this.getfContent() == null ? other.getfContent() == null : this.getfContent().equals(other.getfContent()))
            && (this.getfIp() == null ? other.getfIp() == null : this.getfIp().equals(other.getfIp()))
            && (this.getfRmk() == null ? other.getfRmk() == null : this.getfRmk().equals(other.getfRmk()))
            && (this.getfDuration() == null ? other.getfDuration() == null : this.getfDuration().equals(other.getfDuration()))
            && (this.getfKey() == null ? other.getfKey() == null : this.getfKey().equals(other.getfKey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfCtime() == null) ? 0 : getfCtime().hashCode());
        result = prime * result + ((getfLoginname() == null) ? 0 : getfLoginname().hashCode());
        result = prime * result + ((getfLogtype() == null) ? 0 : getfLogtype().hashCode());
        result = prime * result + ((getfContent() == null) ? 0 : getfContent().hashCode());
        result = prime * result + ((getfIp() == null) ? 0 : getfIp().hashCode());
        result = prime * result + ((getfRmk() == null) ? 0 : getfRmk().hashCode());
        result = prime * result + ((getfDuration() == null) ? 0 : getfDuration().hashCode());
        result = prime * result + ((getfKey() == null) ? 0 : getfKey().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fCtime=").append(fCtime);
        sb.append(", fLoginname=").append(fLoginname);
        sb.append(", fLogtype=").append(fLogtype);
        sb.append(", fContent=").append(fContent);
        sb.append(", fIp=").append(fIp);
        sb.append(", fRmk=").append(fRmk);
        sb.append(", fDuration=").append(fDuration);
        sb.append(", fKey=").append(fKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}