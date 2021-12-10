package com.stepfive;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        JedisPoolConfig cfg = new JedisPoolConfig();
        cfg.setMaxTotal(500);
        cfg.setMaxIdle(20);

        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("192.168.64.181", 7000));
        shards.add(new JedisShardInfo("192.168.64.181", 7001));
        shards.add(new JedisShardInfo("192.168.64.181", 7002));

        ShardedJedisPool pool = new ShardedJedisPool(cfg, shards);

        ShardedJedis j = pool.getResource();
        for (int i = 0; i < 100; i++) {
            j.set("key"+i, "value"+i);
        }

        pool.close();
    }
}
