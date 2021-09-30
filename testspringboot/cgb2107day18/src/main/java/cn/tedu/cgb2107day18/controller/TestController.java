package cn.tedu.cgb2107day18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("machao")
public class TestController {
    @GetMapping("hi")
    public Object method(){
        long start=System.currentTimeMillis();
        hello();
        long end=System.currentTimeMillis();
        System.out.println("时间差为"+(end-start)+"毫秒");
        return "hi springmvc";

    }
    @GetMapping("hello")
    public Object hello(){
        for(int i=0;i<10000;i++){
            System.out.print("=");
        }
        System.out.println();
        return "访问了hello方法";
    }

}
