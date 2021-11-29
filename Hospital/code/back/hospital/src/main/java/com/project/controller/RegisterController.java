package com.project.controller;

import com.project.service.RegisterSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterSenderService registerSenderService;

    @PostMapping
    public String register(String queue_name, String msg) throws IOException, TimeoutException {
        registerSenderService.send(queue_name, msg);
        return "发送队列消息成功！";
    }
}
