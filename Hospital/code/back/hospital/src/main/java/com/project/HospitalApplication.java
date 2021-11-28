package com.project;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class,args);
    }
    @Bean
    public Queue task_queue() {
        // 这个构造方法创建的队列参数为: 持久,非排他,非自动删除
        return new Queue("hospital_register");
    }
}
