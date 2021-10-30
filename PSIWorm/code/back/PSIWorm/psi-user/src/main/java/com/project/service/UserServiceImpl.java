package com.project.service;

import com.project.mapper.UserMapper;
import com.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer register(User user) {
        System.out.println(user);
        return userMapper.insert(user);
    }
}
