package com.project.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

public class QueueConnectionFactoryUtils {

    private static Queue<OutPatientQueueInvoker> outPatientQueueAckInvokerQueue=new LinkedList<>();

    private static Queue<OutPatientQueueInvoker> outPatientDoctorLogoutInvokerQueue=new LinkedList<>();

    private static Map<String,Channel> channelMap=new ConcurrentHashMap<>();
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
    public static void addOutPatientQueueAckInvoker(OutPatientQueueInvoker outPatientQueueAckInvoker){
        outPatientQueueAckInvokerQueue.offer(outPatientQueueAckInvoker);
    }
    public static void addChannel(String doctorName, Channel channel){
        channelMap.put(doctorName,channel);
    }
    public static Channel removeChannel(String doctorName){
        return channelMap.remove(doctorName);
    }
    public static OutPatientQueueInvoker getFirstOutPatientQueueAckInvoker(){
        return outPatientQueueAckInvokerQueue.poll();
    }

    public static OutPatientQueueInvoker getFirstOutPatientDoctorLogoutInvoker() {
        return outPatientDoctorLogoutInvokerQueue.poll();
    }
}
