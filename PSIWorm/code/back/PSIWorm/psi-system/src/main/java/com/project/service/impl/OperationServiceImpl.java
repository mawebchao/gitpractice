package com.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.j2objc.annotations.AutoreleasePool;
import com.project.mapper.CategoryMapper;
import com.project.mapper.OperationMapper;
import com.project.mapper.RoleMapper;
import com.project.pojo.Category;
import com.project.pojo.Operation;
import com.project.pojo.Role;
import com.project.service.CatgoryService;
import com.project.service.OperationService;
import com.project.utils.StringListUtils;
import com.project.vo.CategoryOperationVO;
import com.project.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CatgoryService categoryService;

    @Override
    public List<Operation> getOperationWithRoleAndCat(Integer roleId, Integer catId) {
        QueryWrapper<Operation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleId", roleId);
        queryWrapper.eq("catId", catId);
        return operationMapper.selectList(queryWrapper);
    }

    @Override
    public List<CategoryOperationVO> getOperationWithRoleId(Integer roleId) {
        System.out.println("roleId=" + roleId);
        QueryWrapper<Operation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleId", roleId);
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        List<CategoryOperationVO> categoryOperationVOList = new ArrayList<>();
        //获取catlist
        List<Category> catlist = categoryService.getAllByRoleId(roleId);
        //获取operationList
        for (Category cat : catlist
        ) {
            queryWrapper.eq("catId", cat.getId());
            if (cat.getParentId() != -1) {
                List<Operation> operations = operationMapper.selectList(queryWrapper);
//                System.out.println("operations="+operations);
                if (operations.size() == 0) {
                    categoryQueryWrapper.eq("id", cat.getId());
                    String roleName = categoryMapper.selectOne(categoryQueryWrapper).getName();
                    categoryOperationVOList.add(new CategoryOperationVO().setName(roleName).setOperationList(new ArrayList<>()).setCatId(cat.getId()));
                } else {
                    categoryQueryWrapper.eq("id", cat.getId());
                    String roleName = categoryMapper.selectOne(categoryQueryWrapper).getName();
                    categoryOperationVOList.add(new CategoryOperationVO().setId(operations.get(0).getId()).setName(roleName).setOperationList(StringListUtils.convertStringToStringList(operations.get(0).getOperations())).setCatId(cat.getId()));
                }
                categoryQueryWrapper.clear();
            }
            queryWrapper.clear();


        }
        return categoryOperationVOList;
    }

    @Override
    public Integer batchAdd(List<CategoryOperationVO> operationVOList, Integer roleId) {
        Integer result=0;
        for (CategoryOperationVO categoryVO:operationVOList
             ) {
            if(categoryVO.getId()==null){
                operationMapper.insert(new Operation().setCatId(categoryVO.getCatId()).setOperations(categoryVO.getOperationList().toString()).setRoleId(roleId));
            }else{
                System.out.println("categoryVO.getOperationList().toString()="+categoryVO.getOperationList().toString().replace(" ", ""));

                operationMapper.updateById(new Operation().setCatId(categoryVO.getCatId()).setOperations(categoryVO.getOperationList().toString().replace(" ", "")).setId(categoryVO.getId()).setRoleId(roleId));
            }
            result++;
        }
        return result;
    }
}
