package com.project.service;

import com.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService{

    Integer register(User user);

    List<User> login(User user);

    boolean isAdmin(User user);
}
