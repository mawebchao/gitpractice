package com.stepfive.save;


import lombok.Data;
import redis.clients.jedis.Jedis;

@Data
public class Subscriber {
    private Jedis jedis;
    String host;
    Integer port;
    public Subscriber(String host, Integer port) {
        this.host=host;
        this.port= port;
        this.jedis = new Jedis(host,port);
    }


    public String next(String channel,String clientId) {
        //删除客户Id中的这个消息Id
        String ackedMsgId = jedis.lpop(clientId);
        if(ackedMsgId!=null){
            //messageStatus中删除这个messageId
            jedis.hdel("messageStatus",ackedMsgId);
            //messageContent中删除这个messageId
            jedis.hdel("messageContent",ackedMsgId);
        }


        //获取msgId
        String msgId=jedis.lpop(channel);
        //根据msgId获取msg内容
        String msgContent=jedis.hget("messageContent", msgId);
        //在客户Id表中添加这个消息的Id
        jedis.rpush(clientId, msgId);
        //把messageInfo表中这条消息的装填改成unacked
        jedis.hset("messageStatus", msgId, "unacked");
        return msgContent;

    }

    public void logout(String channel,String clientId) {
        //删除客户Id中的这个消息Id
        String unackedMsgId = jedis.lpop(clientId);
        //从messageIds中lpush这个消息Id
        jedis.lpush(channel,unackedMsgId);
        //改变messageInfo中这个消息的状态为ready
        jedis.hset("messageStatus", unackedMsgId, "ready");
    }
}
