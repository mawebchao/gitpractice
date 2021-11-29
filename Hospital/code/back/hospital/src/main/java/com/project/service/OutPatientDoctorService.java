package com.project.service;

import com.project.utils.QueueConnectionFactoryUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class OutPatientDoctorService {
    public void registerDoctor(String queue_name,String name) throws IOException, TimeoutException {
        Channel ch= QueueConnectionFactoryUtils.getQueueChannel();

        ch.queueDeclare(queue_name,false,false,false,null);
        System.out.println(queue_name+"医生等待接收数据");

        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody(), "UTF-8");
                System.out.println("收到: "+msg);
            }
        };

        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        };

        ch.basicConsume(queue_name, true, callback, cancel);
        QueueConnectionFactoryUtils.close(ch.getConnection());
    }
}
