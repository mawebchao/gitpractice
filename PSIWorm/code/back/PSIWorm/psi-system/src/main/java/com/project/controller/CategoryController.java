package com.project.controller;

import com.project.pojo.Category;
import com.project.service.CatgoryService;
import com.project.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/all")
    public SysResult getAll(Integer userId){
        return SysResult.success(categoryService.getAll(userId));
    }
}
