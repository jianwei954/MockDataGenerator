package com.jw.mockdata.generator.dto.sys;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * SYS_ROLE_PERMISSION_MENU
 * @author 
 */
public class SysRolePermissionMenu implements Serializable {
    private BigDecimal roleId;

    private BigDecimal permissionMenuId;

    private static final long serialVersionUID = 1L;

    public BigDecimal getRoleId() {
        return roleId;
    }

    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }

    public BigDecimal getPermissionMenuId() {
        return permissionMenuId;
    }

    public void setPermissionMenuId(BigDecimal permissionMenuId) {
        this.permissionMenuId = permissionMenuId;
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
        SysRolePermissionMenu other = (SysRolePermissionMenu) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getPermissionMenuId() == null ? other.getPermissionMenuId() == null : this.getPermissionMenuId().equals(other.getPermissionMenuId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getPermissionMenuId() == null) ? 0 : getPermissionMenuId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionMenuId=").append(permissionMenuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}