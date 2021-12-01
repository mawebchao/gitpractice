package com.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class TestJdbcTemplate {


    //    @Autowired
//    @Qualifier("jt1")
    @Autowired
    @Qualifier("jt")
    private JdbcTemplate jt;

    @Test
    public void method() {
        System.out.println(jt);
        System.out.println((JdbcTemplate) (new ClassPathXmlApplicationContext("testJdbcTemplate.xml").getBean("jt")));
    }

}
