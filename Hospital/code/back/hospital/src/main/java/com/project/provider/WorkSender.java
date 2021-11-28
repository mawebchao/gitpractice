package com.project.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class WorkSender {
    @Autowired
    AmqpTemplate t;

    public void send() {
        while (true) {
            System.out.print("输入:");
            String s = new Scanner(System.in).nextLine();

            //spring 默认将消息的 DeliveryMode 设置为 PERSISTENT 持久化,
            t.convertAndSend("hospital_register", s);
        }
    }
}
