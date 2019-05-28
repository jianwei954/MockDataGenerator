package com.jw.mockdata.generator.comparator;


import com.jw.mockdata.generator.dto.sys.PermissionMenuDTO;

import java.util.Comparator;

/**
 * Created by xyd on 2017/3/23.
 */
public class PermissionMenuComparator
{
    public static final Comparator<PermissionMenuDTO> COMPARATOR = new Comparator<PermissionMenuDTO>() {
        public int compare(PermissionMenuDTO o1, PermissionMenuDTO o2) {
            return o1.compareTo(o2);
        }
    };
}
