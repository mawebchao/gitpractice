package com.project.service.impl;

import com.project.mapper.RoleMapper;
import com.project.pojo.Role;
import com.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Integer add(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public Integer update(Role role) {
        return roleMapper.updateById(role);
    }
}
