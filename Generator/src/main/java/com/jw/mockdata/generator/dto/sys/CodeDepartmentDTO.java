package com.jw.mockdata.generator.dto.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/2/27.
 */
public class CodeDepartmentDTO extends CodeDepartment implements Serializable {

    private CodeDepartment codeDepartmentDTO;

    private List<CodeDepartment> codeDepartmentDTOList = new ArrayList<>();

    public CodeDepartment getCodeDepartmentDTO() {
        return codeDepartmentDTO;
    }

    public void setCodeDepartmentDTO(CodeDepartment codeDepartmentDTO) {
        this.codeDepartmentDTO = codeDepartmentDTO;
    }

    public List<CodeDepartment> getCodeDepartmentDTOList() {
        return codeDepartmentDTOList;
    }

    public void setCodeDepartmentDTOList(List<CodeDepartment> codeDepartmentDTOList) {
        this.codeDepartmentDTOList = codeDepartmentDTOList;
    }
}
