package com.project.service;

import com.project.pojo.Role;

import java.util.List;

public interface RoleService {

    Integer add(Role role);

    Integer update(Role role);

    List<Role> getAllInList(Integer userId);

    List<Role> getAllInList();
}
