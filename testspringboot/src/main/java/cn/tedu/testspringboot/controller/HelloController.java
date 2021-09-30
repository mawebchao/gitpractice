package cn.tedu.testspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("machao")
public class HelloController {
    @RequestMapping("hi")
    public String hi(){
        return "给他然后他";
    }
}
