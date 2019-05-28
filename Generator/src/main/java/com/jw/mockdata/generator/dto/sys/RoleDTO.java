package com.jw.mockdata.generator.dto.sys;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author 
 */
public class RoleDTO extends Role implements Serializable {
    Map<String,String> areaData;
    Set<PermissionMenu> premissionData;

    public Map<String, String> getAreaData() {
        return areaData;
    }

    public void setAreaData(Map<String, String> areaData) {
        this.areaData = areaData;
    }

    public Set<PermissionMenu> getPremissionData() {
        return premissionData;
    }

    public void setPremissionData(Set<PermissionMenu> premissionData) {
        this.premissionData = premissionData;
    }
}