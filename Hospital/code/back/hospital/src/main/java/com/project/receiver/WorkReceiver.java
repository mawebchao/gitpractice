package com.project.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkReceiver {
//    @RabbitListener(queues="hospital_register")
    public void receive1(String s) throws Exception {
        System.out.println("receiver1 - 收到: "+s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                Thread.sleep(1000);
            }
        }
    }

//    @RabbitListener(queues="hospital_register")
    public void receive2(String s) throws Exception {
        System.out.println("receiver2 - 收到: "+s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
