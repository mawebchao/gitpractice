package com.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.mapper.UserMapper;
import com.project.pojo.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer register(User user) {
        System.out.println(user);
        return userMapper.insert(user);
    }

    @Override
    public Integer login(User user) {
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        qw.eq("password", user.getPassword());
        return userMapper.selectCount(qw);
    }

    @Override
    public boolean isAdmin(User user) {
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        return userMapper.selectCount(qw)==1;
    }
}
