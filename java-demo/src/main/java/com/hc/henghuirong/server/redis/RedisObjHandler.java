package com.hc.henghuirong.server.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by hu.cong.cong on 2017/4/21.
 */
@Component
public class RedisObjHandler<T> {
    private static final Logger logger = LoggerFactory.getLogger(RedisObjHandler.class);

    @Autowired
    JedisPool jedisPool;

    public boolean put(String str, Object obj) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            String s = JSON.toJSONString(obj);
            jedis.set(str, s);
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }

    public T get(String str, Class cls) {
        Jedis jedis = null;
        T t = null;
        try {
            jedis = getResource();
            t = JSON.parseObject(str, (Class<T>) cls);
        } catch (Exception e) {
            logger.error("error", e);
        }
        return t;
    }

    private Jedis getResource() {
        return jedisPool.getResource();
    }

}
