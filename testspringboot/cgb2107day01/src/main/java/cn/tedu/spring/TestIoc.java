package cn.tedu.spring;

import cn.tedu.spring.pojo.Hello;
import cn.tedu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
    @Test
    public void method() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Hello h= (Hello) ac.getBean("hello");
        h.hi();
    }

    @Test
    public void method2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Student stu=(Student) ac.getBean("student");
        stu.read();
    }
}
