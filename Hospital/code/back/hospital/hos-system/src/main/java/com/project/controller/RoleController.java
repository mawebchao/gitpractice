package com.project.controller;

import com.project.pojo.Role;
import com.project.vo.SysResult;
import com.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/add")
    public SysResult add(@RequestBody Role role){
        return SysResult.success(roleService.add(role));
    }
    @PostMapping("/update")
    public SysResult update( Role role){
        return SysResult.success(roleService.update(role));
    }
    @GetMapping("/get/getAllInList/{userId}")
    public SysResult getAllInList(@PathVariable("userId") Integer userId){
        List<Role> roleList=roleService.getAllInList(userId);
        return SysResult.success(roleList==null?"无任何权限":roleList);
    }
    @GetMapping("/get/getAllInList")
    public SysResult getAllInList(){
        List<Role> roleList=roleService.getAllInList();
        return SysResult.success(roleList==null?"无任何权限":roleList);
    }
}
