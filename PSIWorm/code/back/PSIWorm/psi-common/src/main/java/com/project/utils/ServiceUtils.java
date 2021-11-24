package com.project.utils;


import com.project.mapper.UserMapper;
import com.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class ServiceUtils {
    @Autowired
    private UserMapper userMapper;
//    @Transactional
    public void insert(User user){
        userMapper.insert(user);
        if(user.getId()%2==0)
            System.out.println(1/0);
    }
}
