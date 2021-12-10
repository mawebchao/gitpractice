package com.stepfive.save;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Publisher {
    private Jedis jedis;
    public Publisher(String host,int port){
        jedis = new Jedis(host,port);
    }
//    private void put(String message){
//        Set<String> subClients = jedis.smembers(CONSTANT_CLIENTSET );
//        for(String clientKey:subClients){
//            jedis.rpush(clientKey, message);
//        }
//    }
//    public void pub(String channel,String message){
//        Long txid = jedis.incr("MAXID");
//        String content = txid+"/"+message;
//        this.put(content);
//        jedis.publish(channel, message);
//    }

    //保存到redis
    public void pub(String channel,String message){
        //生成messageId
        Long msgid = jedis.incr("AUTOID");
        //存入messages
        jedis.rpush(channel, String.valueOf(msgid));
        //messageContent
        jedis.hset("messageContent", String.valueOf(msgid),message);
        //messageStatus
        jedis.hset("messageStatus", String.valueOf(msgid),"ready");
//        jedis.publish(channel, message);
    }
}