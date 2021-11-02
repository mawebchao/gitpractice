package com.project.service;

import com.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService{

    Integer register(User user);

    Integer login(User user);
}
