package com.jw.mockdata.generator.dto.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class User implements Serializable {
    private BigDecimal id;

    private String loginName;

    private String password;

    private String chineseName;

    private String dept;

    private String idcard;

    private String sex;

    private String tel;

    private Short status;

    private String description;

    private Date creationDate;

    private String ipAddress;

    private String macAddress;

    private String browser;

    private Date lastloginDate;

    private String department;

    private String departmentChinese;

    private Date fDeadline;

    private Date fAuditDate;

    private String fAuditor;

    private Short nspStatus;

    private String deptChinese;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Date getLastloginDate() {
        return lastloginDate;
    }

    public void setLastloginDate(Date lastloginDate) {
        this.lastloginDate = lastloginDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentChinese() {
        return departmentChinese;
    }

    public void setDepartmentChinese(String departmentChinese) {
        this.departmentChinese = departmentChinese;
    }

    public Date getfDeadline() {
        return fDeadline;
    }

    public void setfDeadline(Date fDeadline) {
        this.fDeadline = fDeadline;
    }

    public Date getfAuditDate() {
        return fAuditDate;
    }

    public void setfAuditDate(Date fAuditDate) {
        this.fAuditDate = fAuditDate;
    }

    public String getfAuditor() {
        return fAuditor;
    }

    public void setfAuditor(String fAuditor) {
        this.fAuditor = fAuditor;
    }

    public Short getNspStatus() {
        return nspStatus;
    }

    public void setNspStatus(Short nspStatus) {
        this.nspStatus = nspStatus;
    }

    /**
     * 区县部门中文代码
     *
     * @return
     */
    public String getDeptChinese() {

        if (deptChinese == null) {
//            deptChinese = DicCache.get(DicConstant.QX, dept);
        }
        return deptChinese;
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getChineseName() == null ? other.getChineseName() == null : this.getChineseName().equals(other.getChineseName()))
            && (this.getDept() == null ? other.getDept() == null : this.getDept().equals(other.getDept()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreationDate() == null ? other.getCreationDate() == null : this.getCreationDate().equals(other.getCreationDate()))
            && (this.getIpAddress() == null ? other.getIpAddress() == null : this.getIpAddress().equals(other.getIpAddress()))
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
            && (this.getBrowser() == null ? other.getBrowser() == null : this.getBrowser().equals(other.getBrowser()))
            && (this.getLastloginDate() == null ? other.getLastloginDate() == null : this.getLastloginDate().equals(other.getLastloginDate()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getDepartmentChinese() == null ? other.getDepartmentChinese() == null : this.getDepartmentChinese().equals(other.getDepartmentChinese()))
            && (this.getfDeadline() == null ? other.getfDeadline() == null : this.getfDeadline().equals(other.getfDeadline()))
            && (this.getfAuditDate() == null ? other.getfAuditDate() == null : this.getfAuditDate().equals(other.getfAuditDate()))
            && (this.getfAuditor() == null ? other.getfAuditor() == null : this.getfAuditor().equals(other.getfAuditor()))
            && (this.getNspStatus() == null ? other.getNspStatus() == null : this.getNspStatus().equals(other.getNspStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getChineseName() == null) ? 0 : getChineseName().hashCode());
        result = prime * result + ((getDept() == null) ? 0 : getDept().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreationDate() == null) ? 0 : getCreationDate().hashCode());
        result = prime * result + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
        result = prime * result + ((getBrowser() == null) ? 0 : getBrowser().hashCode());
        result = prime * result + ((getLastloginDate() == null) ? 0 : getLastloginDate().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getDepartmentChinese() == null) ? 0 : getDepartmentChinese().hashCode());
        result = prime * result + ((getfDeadline() == null) ? 0 : getfDeadline().hashCode());
        result = prime * result + ((getfAuditDate() == null) ? 0 : getfAuditDate().hashCode());
        result = prime * result + ((getfAuditor() == null) ? 0 : getfAuditor().hashCode());
        result = prime * result + ((getNspStatus() == null) ? 0 : getNspStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", chineseName=").append(chineseName);
        sb.append(", dept=").append(dept);
        sb.append(", idcard=").append(idcard);
        sb.append(", sex=").append(sex);
        sb.append(", tel=").append(tel);
        sb.append(", status=").append(status);
        sb.append(", description=").append(description);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", macAddress=").append(macAddress);
        sb.append(", browser=").append(browser);
        sb.append(", lastloginDate=").append(lastloginDate);
        sb.append(", department=").append(department);
        sb.append(", departmentChinese=").append(departmentChinese);
        sb.append(", fDeadline=").append(fDeadline);
        sb.append(", fAuditDate=").append(fAuditDate);
        sb.append(", fAuditor=").append(fAuditor);
        sb.append(", nspStatus=").append(nspStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}