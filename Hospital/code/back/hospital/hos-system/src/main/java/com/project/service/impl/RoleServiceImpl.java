package com.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.mapper.RoleMapper;
import com.project.mapper.UserMapper;
import com.project.pojo.Category;
import com.project.pojo.Role;
import com.project.pojo.User;
import com.project.service.RoleService;
import com.project.utils.StringListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer add(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public Integer update(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public List<Role> getAllInList(Integer userId) {
        try {
            User user = userMapper.selectById(userId);
            QueryWrapper<Role> qw= new QueryWrapper<>();
            qw.in("id", StringListUtils.convertIntStringToIntegerList(user.getRoleIds()));
            List<Role> roleList = roleMapper.selectList(qw);
            return roleList;
        }catch (RuntimeException runtimeException){
            return null;

        }
    }
}
