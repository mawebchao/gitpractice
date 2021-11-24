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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
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
            log.debug(String.valueOf(integercatidList));
            return categoryMapper.selectList(categoryqw);
        }catch (RuntimeException runtimeException){
            return null;

        }


    }
    private Category getById(Integer id,List<Category> categoryList){
        for (Category cat: categoryList
             ) {
            if(cat.getId().equals(id)){
                return  cat;
            }
        }
        log.debug("没有找到");
        return  null;
    }
    @Override
    public List<Category> getAllAppendByChildren(Integer userId) {
        List<Category> categoryList=getAll(userId);
        List<Category> returnCategotyLsit=new ArrayList<>();
        //遍历一次就行，因为最多只有两层目录（遍历二级目录）
        categoryList.stream().filter(c -> c.getParentId() != -1).forEach(category -> {
            Integer pid=category.getParentId();
            log.debug(String.valueOf(pid));
            Category parent=getById(pid,categoryList);
            List<Category> oldChildren = parent.getChildren()==null?new ArrayList<>(): parent.getChildren();
            oldChildren.add(category);
            parent.setChildren(oldChildren);
        });
        //遍历一级目录
        categoryList.stream().filter(c -> c.getParentId() == -1).forEach(category -> {
            returnCategotyLsit.add(category);
        });
        return returnCategotyLsit;
    }
}
