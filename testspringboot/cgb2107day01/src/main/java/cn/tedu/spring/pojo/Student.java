package cn.tedu.spring.pojo;

import org.springframework.stereotype.Component;

@Component
public class Student {
    public void read(){
        System.out.println("学生正在学习");
    }
}
