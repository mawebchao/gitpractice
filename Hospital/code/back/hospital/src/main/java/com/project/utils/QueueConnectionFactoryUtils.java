package com.project.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class QueueConnectionFactoryUtils {
    private static Channel channel;

    public static Channel getQueueChannel() throws IOException, TimeoutException {
        if (channel == null) {
            synchronized (QueueConnectionFactoryUtils.class) {
                if (channel == null) {
                    ConnectionFactory f = new ConnectionFactory();
                    f.setHost("49.235.237.120");
                    f.setUsername("machao");
                    f.setPassword("mawebchao");
                    Connection c = f.newConnection();
                    channel = c.createChannel();
                }
            }
        }
        return channel;
    }

    public static void close(Connection connection) throws IOException {
        connection.close();
    }
}
