package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    /**
     * 配置令牌的存储策略,对于oauth2规范中提供了这样的几种策略
     * 1)JdbcTokenStore(这里是要将token存储到关系型数据库)
     * 2)RedisTokenStore(这是要将token存储到redis数据库-key/value)
     * 3)JwtTokenStore(这里是将产生的token信息存储客户端，并且token
     * 中可以以自包含的形式存储一些用户信息)
     * 4)....
     */
    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    /**
     * 配置JWT令牌创建和解析对象
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter=
                new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
    //这里的签名key将来可以写到配置中心
    private static final String SIGNING_KEY="auth";
}
