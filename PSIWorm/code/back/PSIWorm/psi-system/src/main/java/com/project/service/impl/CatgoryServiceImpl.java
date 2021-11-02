package com.project.service.impl;
import com.project.mapper.CategoryMapper;
import com.project.pojo.Category;
import com.project.service.CatgoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatgoryServiceImpl implements CatgoryService {
    @Autowired
    private CategoryMapper categoryMapper;
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
        return null;
    }
}
