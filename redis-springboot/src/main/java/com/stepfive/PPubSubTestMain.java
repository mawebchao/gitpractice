package com.stepfive;

import com.stepfive.pojo.A;
import com.stepfive.pojo.B;
import com.stepfive.save.Publisher;
import com.stepfive.save.Subscriber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@SpringBootApplication
public class PPubSubTestMain {
    @Value("${subscriber.host}")
    private String HOST;

    @Value("${subscriber.port}")
    private Integer PORT;

    @Bean
    public Publisher pubClient() {
        return new Publisher(HOST, PORT);
    }

    @Bean
    public Subscriber subscriber() {
        return new Subscriber(HOST, PORT);
    }

    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        String host = "192.168.64.101";
//        int port = 6379;
//        String clientId = "myclient";
//        PPubClient pubClient = new PPubClient(host, port);
//        final String channel = "mychannel";
//        final PPSubClient subClient = new PPSubClient(host, port, clientId);
//        Thread subThread = new Thread(new Runnable() {
//            public void run() {
//                System.out.println("------------sub----start------------");
//                subClient.sub(channel);
//                System.out.println("------------sub----end------------");
//            }
//        });
//        subThread.setDaemon(true);
//        subThread.start();
//        int i = 0;
//        while (i < 20) {
//            String message = "message--" + i;
//            pubClient.pub(channel, message);
//            i++;
//            Thread.sleep(100);
//        }
//        subClient.unsubscribe(channel);

//        SpringApplication.run(PPubSubTestMain.class, args);

    //注解方式
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(Configurer.class);
//        applicationContext.refresh();
//        System.out.println(applicationContext.getBean("a", A.class).getB());

    //xml方式
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testab.xml");
        A a = applicationContext.getBean("a", A.class);
        System.out.println(a.getB());
        B b = applicationContext.getBean("b", B.class);
        System.out.println(b.getA());


        }
//    private static void change(StringBuffer str11, StringBuffer str12) {
//        str12 = str11;
//        str11 = new StringBuffer("new world");
//        str12.append("new world");
//    }
//
//    public static void main(String[] args) {
//        StringBuffer str1 = new StringBuffer("good ");
//        StringBuffer str2 = new StringBuffer("bad ");
//        change(str1, str2);
//        System.out.println(str1.toString());
//        System.out.println(str2.toString());
//    }
}
