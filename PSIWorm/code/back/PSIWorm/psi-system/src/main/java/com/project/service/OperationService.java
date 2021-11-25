package com.project.service;


import com.project.pojo.Operation;
import com.project.vo.CategoryOperationVO;
import com.project.vo.SysResult;

import java.util.List;

public interface OperationService {

    List<Operation> getOperationWithRoleAndCat(Integer roleId, Integer catId);

    List<CategoryOperationVO> getOperationWithRoleId(Integer roleId);
}
