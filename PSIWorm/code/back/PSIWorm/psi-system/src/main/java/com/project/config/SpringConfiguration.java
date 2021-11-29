package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringConfiguration {
    @Bean("jt")
    public JdbcTemplate jdbcTemplate(){
        return (JdbcTemplate) (new ClassPathXmlApplicationContext("testJdbcTemplate.xml").getBean("jt"));
    }
}
