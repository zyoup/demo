package com.zyp.p2p.commons.redis.utils;

import redis.clients.jedis.Jedis;

public interface RedisClientInterface {
    Jedis getJedis();

    /**
     * 添加字符串内容
     * @param key
     * @param value
     * @return
     */
    String set(String key,String value,Jedis jedis);

    /**
     *获取内容
     * @param key
     * @return
     */
    String get(String key,Jedis jedis);

    /**
     * 向hash中存放一个属性
     * @param key
     * @param filed
     * @param value
     * @return
     */
    Long hSet(String key,String filed,String value,Jedis jedis);

    /**
     * 向redis中存放一个对象
     * @param key
     * @param obj
     * @return
     */
    String hSet(String key,Object obj,Jedis jedis);

    /**
     *设置有效期
     * @param key
     * @param time
     */
    void expire(String key,int time,Jedis jedis);

    /**
     * 删除指定的key
     * @param jedis
     * @param key
     * @return
     */
    Long del(Jedis jedis,String... key);
}
