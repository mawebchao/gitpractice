package com.project.service;

import com.project.pojo.Category;

import java.util.List;

public interface CatgoryService {
    Integer add(Category category);

    Integer update(Category category);

    List<Category> getAll(Integer userId);

    List<Category> getAllAppendByChildren(Integer userId);

    List<Category> getAllByRoleId(Integer roleId);
}
