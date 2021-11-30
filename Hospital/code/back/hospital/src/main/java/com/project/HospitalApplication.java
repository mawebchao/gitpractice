package com.project;

import com.project.provider.WorkSender;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
<<<<<<< HEAD
import java.util.Scanner;
=======
>>>>>>> 526aaa343fc7940d75b0bec9944bdd5397317896

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class,args);
    }
<<<<<<< HEAD
    @Autowired
    WorkSender workSender;

=======
    //服务器启动的时候，自动加载所有可能存在的队列
    //目前先两个队列
    //内科队列
    @Bean
    public Queue hospital_neike() {
        // 这个构造方法创建的队列参数为: 持久,非排他,非自动删除
        return new Queue("hospital_nk");
    }
    //内科队列
>>>>>>> 526aaa343fc7940d75b0bec9944bdd5397317896
    @Bean
    public Queue hospital_pfk() {
        // 这个构造方法创建的队列参数为: 持久,非排他,非自动删除
        return new Queue("hospital_pfk");
    }
    @PostConstruct
    public void test() {
        // 在新线程中执行自己的运算，不阻塞 spring 主线程执行
        new Thread(() -> {
            workSender.send();
        }).start();

    }
}
