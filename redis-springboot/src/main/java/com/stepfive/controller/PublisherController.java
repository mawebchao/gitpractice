package com.stepfive.controller;

import com.stepfive.save.Publisher;
import com.stepfive.save.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class PublisherController {
    @Autowired
    private Publisher publisher;
    @Autowired
    private Subscriber subscriber;


    @PostMapping("/publish/message")
    public String publishMessage(String channel, String msg) {
        publisher.pub(channel, msg);
        return "发布消息成功";
    }

    @PostMapping("/subscribe/next")
    public  String next(String channel,String clientId){
        String msg=subscriber.next(channel,clientId);
        return msg+"channel="+channel;
    }
    @PostMapping("/subscribe/logout")
    public String subscriberLogout(String channel,String clientId){
        subscriber.logout(channel,clientId);
        return "接收方下线了";
    }
}
