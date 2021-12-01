package com.project.service;

import com.project.utils.QueueConnectionFactoryUtils;
import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//自动注入一个register信息的发送者
@Component
public class RegisterSenderService {

    public void send(String queue_name,String msg) throws IOException, TimeoutException {
        Channel ch= QueueConnectionFactoryUtils.getQueueChannel();
        ch.queueDeclare(queue_name, true,false,false,null);
        //使用默认交换机
        ch.basicPublish("", queue_name, MessageProperties.PERSISTENT_BASIC, msg.getBytes());
        System.out.println("消息已发送: "+msg);
        QueueConnectionFactoryUtils.close(ch.getConnection());
    }
}
