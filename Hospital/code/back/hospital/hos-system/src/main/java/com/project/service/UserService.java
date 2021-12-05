package com.project.service;

import com.project.pojo.User;
import com.project.vo.UserVO;

import java.util.List;

public interface UserService{

    Integer register(User user);

    List<User> login(User user);

    boolean isAdmin(User user);

    void testAddUsers();

    void testAddUsers2();

    UserVO getUserByUsername(String username);

    UserVO getUserByUserId(Integer userId);
}
