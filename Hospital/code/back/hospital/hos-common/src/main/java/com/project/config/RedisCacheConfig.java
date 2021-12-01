package com.project.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.cache.interceptor.KeyGenerator;
import java.time.Duration;

@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {
    /**
     * 定义缓存key生成器，不定义也可以使用默认的。
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (o, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName()); // 类目
            sb.append("::");
            sb.append(method.getName()); // 方法名
            for (Object param : params) {
                sb.append(param.toString());
            }
            return sb.toString();
        };
    }
    /**
     * 自定义Cache管理器对象，不定义也可以，有默认的，但假如希望基于AOP
     * 方式实现Redis的操作时，按照指定的序列化方式进行序列化，
     * 可以对CacheManager进行自定义。
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(600)) // 60s缓存失效
                // 设置key的序列化方式
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                // 设置value的序列化方式
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(
                                new Jackson2JsonRedisSerializer<Object>(Object.class)))
                // 不缓存null值
                .disableCachingNullValues();
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
    }


}