package com.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.mapper.UserMapper;
import com.project.pojo.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private  User user;
    @Override
    public Integer register(User user) {
        System.out.println(user);
        return userMapper.insert(user);
    }

    @Override
    public List<User> login(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        return userMapper.selectList(qw);
    }

    @Override
    public boolean isAdmin(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        return userMapper.selectCount(qw) == 1;
    }

    @Override
//    @Transactional
    public void testAddUsers() {
        List<User> userList=new ArrayList<>();
        System.out.println(user.getId());
        userList.add(new User().setUsername("mawebchao").setPassword("123"));
        userList.add(new User().setUsername("mawebchao").setPassword("123"));
//        userList.add(new User().setUsername("mawebchao").setPassword("123"));
//        userList.add(new User().setUsername("mawebchao").setPassword("123"));
//        userList.add(new User().setUsername("mawebchao").setPassword("123"));

        for (int i = 0; i < userList.size(); i++) {
            try {
                userMapper.insert(userList.get(i));
                if(i%2==0){
                    System.out.println(1/0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    @Override
    public void testAddUsers2() {
        System.out.println("testAddUsers2方法执行了");
    }
}
