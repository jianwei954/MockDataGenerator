package com.jw.mockdata.generator.dto.sys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class UserLog implements Serializable {
    private BigDecimal id;

    private Date dbInsdate;

    private String userid;

    private BigDecimal logtype;

    private String content;

    private String userip;

    private String remarks;

    private BigDecimal queryduration;

    private String key;

    private String chineseName;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getDbInsdate() {
        return dbInsdate;
    }

    public void setDbInsdate(Date dbInsdate) {
        this.dbInsdate = dbInsdate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getLogtype() {
        return logtype;
    }

    public void setLogtype(BigDecimal logtype) {
        this.logtype = logtype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getQueryduration() {
        return queryduration;
    }

    public void setQueryduration(BigDecimal queryduration) {
        this.queryduration = queryduration;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public UserLog init(String userId, String userIp)
    {
        userid = userId;
        userip = userIp;
        return this;
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
        UserLog other = (UserLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDbInsdate() == null ? other.getDbInsdate() == null : this.getDbInsdate().equals(other.getDbInsdate()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getLogtype() == null ? other.getLogtype() == null : this.getLogtype().equals(other.getLogtype()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getUserip() == null ? other.getUserip() == null : this.getUserip().equals(other.getUserip()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getQueryduration() == null ? other.getQueryduration() == null : this.getQueryduration().equals(other.getQueryduration()))
            && (this.getKey() == null ? other.getKey() == null : this.getKey().equals(other.getKey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDbInsdate() == null) ? 0 : getDbInsdate().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getLogtype() == null) ? 0 : getLogtype().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getUserip() == null) ? 0 : getUserip().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getQueryduration() == null) ? 0 : getQueryduration().hashCode());
        result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dbInsdate=").append(dbInsdate);
        sb.append(", userid=").append(userid);
        sb.append(", logtype=").append(logtype);
        sb.append(", content=").append(content);
        sb.append(", userip=").append(userip);
        sb.append(", remarks=").append(remarks);
        sb.append(", queryduration=").append(queryduration);
        sb.append(", key=").append(key);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}