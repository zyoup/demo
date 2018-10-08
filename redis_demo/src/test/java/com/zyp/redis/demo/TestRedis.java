package com.zyp.redis.demo;

import org.junit.Test;
import redis.clients.jedis.*;

public class TestRedis {
    @Test
    public void test1(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123");
        String result = jedis.set("hh", "dudu");
        jedis.close();
        System.out.println(result);
    }

    @Test
    public void test2(){
        HostAndPort hostAndPort=new HostAndPort("127.0.0.1",6379);
        JedisCluster jedisCluster = new JedisCluster(hostAndPort);
        //TODO 测试集群
    }

    @Test
    public void test3(){
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("123");
        String result = jedis.set("ve", "122");
        jedis.expire("ve",100);//时间为秒
        System.out.println(result);
    }

    @Test
    public void test4(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(50);
        jedisPoolConfig.setMaxIdle(512);
        jedisPoolConfig.setMaxTotal(1024);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379,100,"123");
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set("key1", "123");
        String key1 = jedis.get("key1");
        System.out.println(key1);
    }
}
