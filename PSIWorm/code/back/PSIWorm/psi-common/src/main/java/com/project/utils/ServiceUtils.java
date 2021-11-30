package com.project.utils;


import com.project.mapper.UserMapper;
import com.project.pojo.User;

//@Component
public class ServiceUtils {
//    @Autowired
    private UserMapper userMapper;
//    @Transactional
    public void insert(User user){
        userMapper.insert(user);
        if(user.getId()%2==0)
            System.out.println(1/0);
    }
}
