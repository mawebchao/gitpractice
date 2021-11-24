package com.project.service;


import com.project.pojo.User;
import com.project.vo.SysResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "psi-system", contextId ="remoteUserService" )
public interface RemoteUserService {
    @GetMapping("/user/login")
    SysResult selectUserByUsername(@RequestBody User user);

    @RequestMapping(value = "/cat/get/getAllInList/{userId}",method = RequestMethod.GET)
    SysResult getUserCategory(@PathVariable("userId") Integer userId);

}

