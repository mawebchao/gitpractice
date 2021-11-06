package com.project.service;

import com.project.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "psi-system", contextId ="remoteUserService" )
public interface RemoteUserService {
    @GetMapping("/user/login/{username}")
    User selectUserByUsername(@PathVariable("username") String username);

}

