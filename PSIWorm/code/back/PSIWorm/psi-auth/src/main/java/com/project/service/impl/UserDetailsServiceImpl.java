package com.project.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pojo.Category;
import com.project.service.RemoteUserService;
import com.project.vo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 基于用户名获取数据库中的用户信息
     *
     * @param username 这个username来自客户端
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        log.info("123456加密后：",new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().encode("123123"));
        //基于feign方式获取远程数据并封装
        //1.基于用户名获取用户信息
        SysResult sysResult =
                remoteUserService.selectUserByUsername(new com.project.pojo.User().setUsername(username));
        LinkedHashMap<String, Object> userdata = (LinkedHashMap<String, Object>) sysResult.getData();
        if (userdata == null)
            throw new UsernameNotFoundException("用户不存在");
        //2.基于用于id查询用户权限
        SysResult categoryListResult =
                remoteUserService.getUserCategory(Integer.parseInt(userdata.get("id")+""));
        List<String> permissions=new ArrayList<>();
        List<LinkedHashMap<String, Object>> catdata = (List<LinkedHashMap<String, Object>>) categoryListResult.getData();
        for (LinkedHashMap<String,Object> cat: catdata
             ) {
            permissions.add(cat.get("name")+"");
        }
        log.info("permissions {}", permissions);
        log.info("password {}", userdata.get("password"));
        //3.对查询结果进行封装并返回
        org.springframework.security.core.userdetails.User userInfo = new User(username,
                userdata.get("password")+"",
                AuthorityUtils.createAuthorityList(permissions.toArray(new String[]{})));
        //......
        return userInfo;
    }
}