package com.project.controller;

import com.project.service.OperationService;
import com.project.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/operation")
public class OperationController {
    @Autowired
    private OperationService operationService;
    @GetMapping("/{roleId}/{catId}")
    public SysResult getOperationWithRoleAndCat(Integer roleId,Integer catId){
        return SysResult.success(operationService.getOperationWithRoleAndCat(roleId,catId));
    }
    @GetMapping("/{roleId}")
    public SysResult getOperationWithRoleId(@PathVariable("roleId") Integer roleId){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("das");
        strings.add("das");
        System.out.println(strings);
        return SysResult.success(operationService.getOperationWithRoleId(roleId));
    }
}
