package com.project.service;

import com.project.utils.QueueConnectionFactoryUtils;
import com.project.vo.OutPatientDoctorVO;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class OutPatientDoctorService {
    public OutPatientDoctorVO registerDoctor(String queue_name, String name) throws IOException, TimeoutException {
        Channel ch = QueueConnectionFactoryUtils.getQueueChannel();

        ch.queueDeclare(queue_name, true, false, false, null);
        System.out.println(queue_name + "科室的医生等待接收数据");
        OutPatientDoctorVO outPatientDoctorVO=new OutPatientDoctorVO();
        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody(), "UTF-8");
                System.out.println("收到: " + msg);
                QueueConnectionFactoryUtils.addOutPatientQueueAckInvoker(() -> {
                    ch.basicAck(message.getEnvelope().getDeliveryTag(), false);

                });
                outPatientDoctorVO.setName(msg);
            }
        };

        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        };
        ch.basicQos(1); //一次只接收一条消息
        ch.basicConsume(queue_name, false, callback, cancel);
        //缓存channel
        QueueConnectionFactoryUtils.addChannel(name, ch);
        return outPatientDoctorVO;
    }


    public void nextPatient(String queue_name, String name) throws IOException {
        QueueConnectionFactoryUtils.getFirstOutPatientQueueAckInvoker().invoke();
    }

    public void logoutDoctor(String queue_name, String name) throws IOException {
        Channel channel = QueueConnectionFactoryUtils.removeChannel(name);
        //关闭通道
        QueueConnectionFactoryUtils.close(channel.getConnection());

    }
}
