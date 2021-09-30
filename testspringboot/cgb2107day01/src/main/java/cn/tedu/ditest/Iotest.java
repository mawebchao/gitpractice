package cn.tedu.ditest;

import cn.tedu.ditest.pojo.Dept;
import cn.tedu.ditest.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Iotest {
    @Test
    public void method1(){
        ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("spring-config.xml");
        Dept dept= (Dept)spring.getBean("dept");
        dept.setName("财务部");
        User user=(User)spring .getBean("user");
        System.out.println(user);
    }
}
