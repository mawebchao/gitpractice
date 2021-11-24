package com.project.controller;

import com.project.vo.SysResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ResourceController {
    @GetMapping("/sys/management")
    public SysResult getSystemManagementAuthorization(){
        return SysResult.success("您可以访问系统管理页面");
    }
}
