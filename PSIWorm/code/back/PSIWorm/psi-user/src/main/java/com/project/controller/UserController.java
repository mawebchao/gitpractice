package com.project.controller;

import com.project.pojo.User;
import com.project.service.UserService;
import com.project.vo.SysResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public SysResult login(User user) {
        if (user.getUsername().equals("mawebchao") && user.getPassword().equals("123123")) {
            return SysResult.success("登陆成功");
        }
        return SysResult.fail();
    }

    @PostMapping("/register")
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "张三",required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123123", required = true)
    }
    )
    public SysResult register(@RequestBody User user) {
        userService.register(user);
        return SysResult.success("注册成功");
    }
}
