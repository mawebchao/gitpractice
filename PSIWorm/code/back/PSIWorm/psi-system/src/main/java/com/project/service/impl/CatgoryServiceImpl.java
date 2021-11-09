package com.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.mapper.CategoryMapper;
import com.project.mapper.RoleMapper;
import com.project.mapper.UserMapper;
import com.project.pojo.Category;
import com.project.pojo.Role;
import com.project.pojo.User;
import com.project.service.CatgoryService;
import com.project.utils.StringListUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CatgoryServiceImpl implements CatgoryService {
    private CategoryMapper categoryMapper;
    private UserMapper userMapper;
    private RoleMapper roleMapper;

    @Override
    public Integer add(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Integer update(Category category) {
        return categoryMapper.updateById(category);
    }

    @Override
    public List<Category> getAll(Integer userId) {
        try {
            User user = userMapper.selectById(userId);
            QueryWrapper<Role> qw= new QueryWrapper<>();
            qw.in("id", StringListUtils.convertIntStringToIntegerList(user.getRoleIds()));
            List<Integer> integercatidList=new ArrayList<>();
            for (Role role:roleMapper.selectList(qw)
            ) {
                integercatidList.addAll( StringListUtils.convertIntStringToIntegerList(role.getCategoryIds()));
            }
            qw.clear();
            QueryWrapper<Category> categoryqw= new QueryWrapper<>();
            categoryqw.in("id", integercatidList);
            return categoryMapper.selectList(categoryqw);
        }catch (RuntimeException runtimeException){
            return null;
        }


    }
}
