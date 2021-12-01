package com.project.controller;

import com.project.pojo.Category;
import com.project.service.CatgoryService;
import com.project.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CatgoryService categoryService;

    @PostMapping("/add")
    public SysResult add(@RequestBody Category category){
        return SysResult.success(categoryService.add(category));
    }
    @PostMapping("/update")
    public SysResult update(@RequestBody Category category){
        return SysResult.success(categoryService.update(category));
    }

    @GetMapping("/get/all/{userId}")
    public SysResult getAll(@PathVariable("userId") Integer userId){
        List<Category> categoryList=categoryService.getAllAppendByChildren(userId);
        return SysResult.success(categoryList==null?"无任何权限":categoryList);
    }

    @GetMapping("/get/getAllInList/{userId}")
    public SysResult getAllInList(@PathVariable("userId") Integer userId){
        List<Category> categoryList=categoryService.getAll(userId);
        return SysResult.success(categoryList==null?"无任何权限":categoryList);
    }
}
