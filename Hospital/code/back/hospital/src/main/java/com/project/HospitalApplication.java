package com.project;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class,args);
    }
    //服务器启动的时候，自动加载所有可能存在的队列
    //目前先两个队列
    //内科队列
    @Bean
    public Queue hospital_neike() {
        // 这个构造方法创建的队列参数为: 持久,非排他,非自动删除
        return new Queue("hospital_nk");
    }
    //内科队列
    @Bean
    public Queue hospital_pfk() {
        // 这个构造方法创建的队列参数为: 持久,非排他,非自动删除
        return new Queue("hospital_pfk");
    }
}
