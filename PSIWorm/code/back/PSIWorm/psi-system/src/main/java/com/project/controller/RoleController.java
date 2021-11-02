package com.project.controller;

import com.project.pojo.Role;
import com.project.vo.SysResult;
import com.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/add")
    public SysResult add( Role role){
        return SysResult.success(roleService.add(role));
    }
    @PostMapping("/update")
    public SysResult update( Role role){
        return SysResult.success(roleService.update(role));
    }
}
