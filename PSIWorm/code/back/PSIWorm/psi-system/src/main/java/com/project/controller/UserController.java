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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public String testAddUsers(){
        userService.testAddUsers();
        return "testAddUsers OK!";
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "mawebchao", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123123", required = true)
    })
    public SysResult login(@RequestBody User user) {
        List<User> userlist=userService.login(user);
        if (userlist.size()==1) {
            return SysResult.success(userlist.get(0));
        }
        return SysResult.fail();
    }

    @PostMapping("/register")
    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户Obj", defaultValue = "{username:'mawebchao',password:'123123'}", required = true)
    }
    )
    public SysResult register(@RequestBody User user) {
        List<String> roleidlist = new ArrayList<String>();
        roleidlist.add("1");
        roleidlist.add("2");
        user.setRoleIds(roleidlist.toString());
        userService.register(user);
        return SysResult.success("注册成功");
    }

    @PostMapping("/check/admin")
    @ApiOperation("查询是否是系统管理员")
    public SysResult isAdmin(@RequestBody User user) {
        return SysResult.success(userService.isAdmin(user));
    }

//    @GetMapping("/test/post")
//    public String testPost(){
//        return "测试成功";
//    }
}
