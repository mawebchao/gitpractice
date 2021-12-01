package com.project.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

public class QueueConnectionFactoryUtils {

    private static Queue<OutPatientQueueAckInvoker> outPatientQueueAckInvokerQueue=new LinkedList<>();

    public static Channel getQueueChannel() throws IOException, TimeoutException {
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("49.235.237.120");
        f.setUsername("machao");
        f.setPassword("mawebchao");
        Connection c = f.newConnection();
        return c.createChannel();
    }

    public static void close(Connection connection) throws IOException {
        connection.close();
    }
    public static void addOutPatientQueueAckInvoker(OutPatientQueueAckInvoker outPatientQueueAckInvoker){
        outPatientQueueAckInvokerQueue.offer(outPatientQueueAckInvoker);
    }
    public static OutPatientQueueAckInvoker getOutPatientQueueAckInvoker(){
        return outPatientQueueAckInvokerQueue.poll();
    }
}
