package com.project.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

public class QueueConnectionFactoryUtils {
    private static Map<String,Object> outPatientDoctorNowPatientMap=new HashMap<>();
//    private static Queue<OutPatientQueueInvoker> outPatientQueueAckInvokerQueue=new LinkedList<>();

    private static Map<String,Queue<QueueAckInvoker>> outPatientDoctorInvokerQueueMap=new HashMap<>();

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
    public static void addOutPatientQueueAckInvoker(String queue_name,QueueAckInvoker outPatientQueueAckInvoker){
        if(outPatientDoctorInvokerQueueMap.get(queue_name)==null){
            outPatientDoctorInvokerQueueMap.put(queue_name,new LinkedList<>());
        }
        outPatientDoctorInvokerQueueMap.get(queue_name).offer(outPatientQueueAckInvoker);
    }
    public static void addChannel(String doctorName, Channel channel){
        channelMap.put(doctorName,channel);
    }
    public static Channel removeChannel(String doctorName){
        return channelMap.remove(doctorName);
    }
    public static QueueAckInvoker getFirstOutPatientQueueAckInvoker(String queue_name){
        return outPatientDoctorInvokerQueueMap.get(queue_name).poll();
    }


    public static void updateNowPatientMap(String doctorName,Object patientInfo){
        outPatientDoctorNowPatientMap.put(doctorName,patientInfo);
    }
    public static Object getNewPatient(String doctorName){
        return outPatientDoctorNowPatientMap.remove(doctorName);
    }
}
