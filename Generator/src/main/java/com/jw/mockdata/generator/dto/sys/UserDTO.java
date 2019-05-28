package com.jw.mockdata.generator.dto.sys;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户DTO对象
 * @author djw
 */
public class UserDTO extends User implements Serializable {
    private List<PermissionMenuDTO> permissionMenus;//权限菜单
    private Map<String,String> permissionMenuIds;
    private Date  updatetime;//更新时间，用于判断是否过期
    private List<Role> roles;//用户所属角色

    private boolean hasAreaAll = false;

    private boolean isCheck = false;
    private boolean rttCheck = false;
    private boolean hasControlBySenior = false;
    private boolean hasControlAll = false;
    private boolean hasControlrestrict = false;
    private boolean hasControlImport = false;//临控批量导入全新
    private int controlMaxCount = 50; //临空限制的数量
    private boolean hasControlshenpi = false;
    private boolean hasDeviceLog = false;

    private List<String> code_department = new ArrayList<>();

    public Date getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime)
    {
        this.updatetime = updatetime;
    }

    public List<PermissionMenuDTO> getPermissionMenus()
    {
        return permissionMenus;
    }

    public void setPermissionMenus(List<PermissionMenuDTO> permissionMenus)
    {

        if (permissionMenus != null) {

            for (int i = 0; i < permissionMenus.size(); i++) {
                //7001正式部署的以下需要删除不显示 不需要注销
                /*if(permissionMenus.get(i).getId() == 12l)
                {
					for (int j = 0; j < permissionMenus.get(i).getPermissionList().size(); j++)
					{
						if (permissionMenus.get(i).getPermissionList().get(j).getId() == 96L)
						{
							permissionMenus.get(i).getPermissionList().remove(j);
						}

					}
				}
				if(permissionMenus.get(i).getId() == 39l)
				{
					for (int j = 0; j < permissionMenus.get(i).getPermissionList().size(); j++)
					{
						if (permissionMenus.get(i).getPermissionList().get(j).getId() == 85L)
						{
							permissionMenus.get(i).getPermissionList().remove(j);
						}

					}
				}
				if(permissionMenus.get(i).getId() == 70l)
				{
					for (int j = 0; j < permissionMenus.get(i).getPermissionList().size(); j++)
					{
						if (permissionMenus.get(i).getPermissionList().get(j).getId() == 98L)
						{
							permissionMenus.get(i).getPermissionList().remove(j);
						}

					}
				}*/

                ///////////////////////////////////
                if (permissionMenus.get(i).getId().compareTo(new BigDecimal(50)) == 0) {
                    Map<Integer, Integer> ints = new HashMap<Integer, Integer>();
                    for (int j = 0; j < permissionMenus.get(i).getPermissionList().size(); j++) {
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(51)) == 0) {
                            permissionMenus.get(i).getPermissionList().get(j).setMenuUri("/control/list");
                        }
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(89)) == 0) {
                            permissionMenus.get(i).getPermissionList().get(j).setMenuUri("/control/add");
                        }
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(90)) == 0) {
                            permissionMenus.get(i).getPermissionList().get(j).setMenuUri("/control/type/list");
                        }
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(93)) == 0) {
                            permissionMenus.get(i).getPermissionList().get(j).setMenuUri("/control/area/list");
                        }
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(91)) == 0) {
                            //permissionMenus.get(i).getPermissionList().remove(j);
                            ints.put(j, j);
                            hasControlBySenior = true;
//							break;
                        }
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(97)) == 0) {
                            String s = permissionMenus.get(i).getPermissionList().get(j).getIcon();
                            if (s != null && s != "") {
                                controlMaxCount = Integer.parseInt(s);
                            }
                            //permissionMenus.get(i).getPermissionList().remove(j);
                            ints.put(j, j);
                            hasControlrestrict = true;

//							break;
                        }

                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(58)) == 0) {
                            //permissionMenus.get(i).getPermissionList().remove(j);
                            ints.put(j, j);
                            hasControlAll = true;
//							break;
                        }
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(59)) == 0) {
                            hasControlImport = true;
//							break;
                        }
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(57)) == 0) {
                            hasControlshenpi = true;
//							break;
                        }


                    }
                    List<PermissionMenuDTO> permissionMenuList = new ArrayList<PermissionMenuDTO>();
                    for (int j = 0; j < permissionMenus.get(i).getPermissionList().size(); j++) {
                        if (null == ints.get(j)) {
                            permissionMenuList.add(permissionMenus.get(i).getPermissionList().get(j));
                        }
                    }
                    permissionMenus.get(i).setPermissionList(permissionMenuList);
                    //break;
                }
                if (permissionMenus.get(i).getId().compareTo(new BigDecimal(14)) == 0) {
                    Map<Integer, Integer> ints = new HashMap<Integer, Integer>();
                    for (int j = 0; j < permissionMenus.get(i).getPermissionList().size(); j++) {
                        if (permissionMenus.get(i).getPermissionList().get(j).getId().compareTo(new BigDecimal(104)) == 0) {
                            //permissionMenus.get(i).getPermissionList().remove(j);
                            ints.put(j, j);
                            hasDeviceLog = true;
//							break;
                        }
                    }
                    List<PermissionMenuDTO> permissionMenuList = new ArrayList<PermissionMenuDTO>();
                    for (int j = 0; j < permissionMenus.get(i).getPermissionList().size(); j++) {
                        if (null == ints.get(j)) {
                            permissionMenuList.add(permissionMenus.get(i).getPermissionList().get(j));
                        }
                    }
                    permissionMenus.get(i).setPermissionList(permissionMenuList);
                    //break;
                }
               /*if (permissionMenus.get(i).getId() == 120100l) {
                    permissionMenus.remove(i);
                }*/


            }
        }
        this.permissionMenus = permissionMenus;
    }

    public Map<String, String> getPermissionMenuIds()
    {
        return permissionMenuIds;
    }

    public void setPermissionMenuIds(Map<String, String> permissionMenuIds)
    {
        this.permissionMenuIds = permissionMenuIds;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    public boolean isHasAreaAll() {
        return hasAreaAll;
    }

    public void setHasAreaAll(boolean hasAreaAll) {
        this.hasAreaAll = hasAreaAll;
    }

    public List<String> getCode_department() {
        return code_department;
    }

    public void setCode_department(List<String> code_department) {
        this.code_department = code_department;
    }

    public void createCode_department(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (!hasAreaAll) {
                for (String code : list) {
                    if (code.equals("all")) {
                        hasAreaAll = true;
                        code_department.clear();
//                        for (CodeDepartment codeDT : CodeDepartmentCache.getAllList()) {
//                            code_department.add(codeDT.getCode());
//                        }
                        /*if (!code_department.contains("999999999")) {
                            code_department.add("999999999");
                        }*/
                        break;
                    }
                }
                if (!hasAreaAll) {
                    for (String code : list) {
                        if (!code_department.contains(code)) {
                            code_department.add(code);
                        }
//                        Object o = CodeDepartmentCache.getFormCodeDTCache("T_" + code);
//                        if (o != null) {
//                            List<String> l = (List<String>) o;
//                            for (String o_code : l) {
//                                if (!code_department.contains(o_code)) {
//                                    code_department.add(o_code);
//                                }
//                            }
//                        }

                    }
                }
            }
        }
    }

    public List<String> getCode_departmentBy0To6() {
        List<String> temp = new ArrayList<>();
        if (hasAreaAll) {
//            for (CodeDepartment codeDT : CodeDepartmentCache.getAllList()) {
//                temp.add(codeDT.getCode());
//            }
        } else {
            temp = code_department;
        }
        List<String> l = new ArrayList<>();
        for (String s : temp) {
            if (!s.substring(2, 9).equals("0000000")) {
                if (!s.equals("999999999")) {
                    if (!l.contains(s.substring(0, 6) + "000")) {
                        l.add(s.substring(0, 6) + "000");
                    }
                } else {
                    l.add(s);
                }
            }
        }
        return l;
    }


    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public boolean isRttCheck() {
        return rttCheck;
    }

    public void setRttCheck(boolean rttCheck) {
        this.rttCheck = rttCheck;
    }

    public boolean isHasControlBySenior() {
        return hasControlBySenior;
    }

    public void setHasControlBySenior(boolean hasControlBySenior) {
        this.hasControlBySenior = hasControlBySenior;
    }

    public boolean isHasControlAll() {
        return hasControlAll;
    }

    public void setHasControlAll(boolean hasControlAll) {
        this.hasControlAll = hasControlAll;
    }

    public boolean isHasControlrestrict() {
        return hasControlrestrict;
    }

    public void setHasControlrestrict(boolean hasControlrestrict) {
        this.hasControlrestrict = hasControlrestrict;
    }

    public boolean isHasControlImport() {
        return hasControlImport;
    }

    public void setHasControlImport(boolean hasControlImport) {
        this.hasControlImport = hasControlImport;
    }

    public int getControlMaxCount() {
        return controlMaxCount;
    }

    public void setControlMaxCount(int controlMaxCount) {
        this.controlMaxCount = controlMaxCount;
    }

    public boolean isHasControlshenpi() {
        return hasControlshenpi;
    }

    public void setHasControlshenpi(boolean hasControlshenpi) {
        this.hasControlshenpi = hasControlshenpi;
    }

    public boolean isHasDeviceLog() {
        return hasDeviceLog;
    }

    public void setHasDeviceLog(boolean hasDeviceLog) {
        this.hasDeviceLog = hasDeviceLog;
    }
}