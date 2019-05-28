package com.jw.mockdata.generator.dto.sys;

import com.jw.mockdata.generator.comparator.PermissionMenuComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 
 */
public class PermissionMenuDTO extends PermissionMenu {

    private  boolean ischeck=false;

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
    /**
     * 子类
     */
    private List<PermissionMenuDTO> permissionList=new ArrayList<>();

    public List<PermissionMenuDTO> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionMenuDTO> permissionList) {
        this.permissionList = permissionList;
    }

    public  static Map<String,String> toidList(Set<PermissionMenuDTO> list){
        Map<String,String> resultList= new HashMap<String,String>();
        for(PermissionMenuDTO item :list)
        {
            //if(null!=item.getfStat() && item.getfStat())
                resultList.put(item.getId()+"",item.getId()+"");
        }
        return resultList;
    }

    public static List<PermissionMenuDTO> toTreeList(Set<PermissionMenuDTO> list){

        List<PermissionMenuDTO> resultList = new ArrayList<PermissionMenuDTO>();
        for (PermissionMenuDTO item : list) {
            if (item.getDeep() == 1 || item.getStatus() != 1) {
                continue;
            } else if (item.getDeep() == 2) {
                recList(item, list);
                resultList.add(item);

            }
        }
        return resultList;
    }

    private static void recList(PermissionMenuDTO parentMenu, Set<PermissionMenuDTO> list){
        if (parentMenu.getPermissionList() == null) {
            parentMenu.setPermissionList(new ArrayList<PermissionMenuDTO>());
        }
        for (PermissionMenuDTO item : list) {
            if (item.getDeep() == parentMenu.getDeep() + 1 && item.getParentId() != null && item.getParentId().compareTo(parentMenu.getId())==0) {
                recList(item, list);
                parentMenu.getPermissionList().add(item);
            }
        }
        Collections.sort(parentMenu.getPermissionList(), PermissionMenuComparator.COMPARATOR);
    }

    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        } else if (o != null && o instanceof PermissionMenuDTO) {
            PermissionMenuDTO obj = (PermissionMenuDTO) o;
            if (Integer.parseInt(getSort()) <= Integer.parseInt(obj.getSort())) {
                return -1;
            } else  if (Integer.parseInt(getSort()) >= Integer.parseInt(obj.getSort())){
                return 1;
            }else{
                if (getId().compareTo(obj.getId())==-1) {
                    return -1;
                } else if(getId().compareTo(obj.getId())==1){
                    return 1;
                }else{
                    return 0;
                }
            }
        } else {
            return -1;
        }
    }
}