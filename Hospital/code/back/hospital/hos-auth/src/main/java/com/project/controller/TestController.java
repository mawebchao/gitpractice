package com.project.controller;

import com.project.pojo.User;
import com.project.service.RemoteUserService;
import com.project.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
    @Autowired
    private RemoteUserService remoteUserService;

    @PostMapping("/login")
    public SysResult login(@RequestBody User user){
        return  SysResult.success(remoteUserService.selectUserByUsername(user));
    }

    @GetMapping("/permission")
    public SysResult permission( Integer userId){
        return  SysResult.success(remoteUserService.getUserCategory(userId));
    }

}
