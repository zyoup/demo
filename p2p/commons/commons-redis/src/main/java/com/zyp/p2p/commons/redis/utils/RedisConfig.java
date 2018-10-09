package com.zyp.p2p.commons.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${jedis.host}")
    private String host;

    @Value("${jedis.port}")
    private int port;

    @Value("${jedis.maxTotal}")
    private int maxTotal;

    @Value("${jedis.maxIdle}")
    private int maxIdle;

    @Value("${jedis.minIdle}")
    private int minIdle;

    @Value("${jedis.maxTime}")
    private int maxTime;

    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Bean
    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port);
        return jedisPool;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxTime);
        return jedisPoolConfig;
    }
}
