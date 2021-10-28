package com.project.controller;

import com.project.pojo.User;
import com.project.vo.SysResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @GetMapping("/login")
    public SysResult login(User user){
        if(user.getUsername().equals("mawebchao")&&user.getPassword().equals("123123")){
            System.out.println(1/0);
            return SysResult.success("登陆成功");
        }
        return SysResult.fail();
    }
}
