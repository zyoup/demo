package com.zyp.p2p.commons.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class RedisClient implements RedisClientInterface {
    @Autowired
    private JedisPool jedisPool;
    @Value("${jedis.password}")
    private String password;

    @Override
    public Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        if(password!=null){
            jedis.auth(password);
        }
        return jedis;
    }

    @Override
    public String set(String key, String value,Jedis jedis) {
        //Jedis jedis = getJedis();
        return jedis.set(key,value);
    }

    @Override
    public String get(String key,Jedis jedis) {
        //Jedis jedis = getJedis();
        return jedis.get(key);
    }

    @Override
    public Long hSet(String key, String filed, String value,Jedis jedis) {
        //getJedis();
        return jedis.hset(key,filed,value);
    }

    @Override
    public String hSet(String key, Object obj,Jedis jedis) {
        //Jedis jedis = getJedis();
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            SkipRedis skipRedis = field.getAnnotation(SkipRedis.class);
            if(skipRedis!=null){
                continue;
            }
            //破坏封装性不推荐使用，
//            field.setAccessible(true);
//            field.get(obj);
            String name = field.getName();
            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name,aClass);
                if(propertyDescriptor!=null){
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if(readMethod!=null){
                        Object invoke = readMethod.invoke(obj, null);
                        jedis.set("key",name,invoke==null?null:invoke.toString());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(jedis!=null){
            jedis.close();
        }
        return null;
    }

    @Override
    public void expire(String key, int time,Jedis jedis) {
        jedis.expire(key,time);
    }

    @Override
    public Long del(Jedis jedis, String... key) {
            return jedis.del(key);
    }


}
