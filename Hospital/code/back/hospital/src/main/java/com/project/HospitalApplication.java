package com.project;

import com.project.provider.WorkSender;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class,args);
    }
    @Autowired
    WorkSender workSender;

    @Bean
    public Queue task_queue() {
        // 这个构造方法创建的队列参数为: 持久,非排他,非自动删除
        return new Queue("hospital_register");
    }
    @PostConstruct
    public void test() {
        // 在新线程中执行自己的运算，不阻塞 spring 主线程执行
        new Thread(() -> {
            workSender.send();
        }).start();

    }
}
