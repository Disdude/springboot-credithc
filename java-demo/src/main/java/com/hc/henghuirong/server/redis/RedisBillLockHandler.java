package com.hc.henghuirong.server.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by hu.cong.cong on 2017/4/13.
 */
@Component
public class RedisBillLockHandler {

    private static final Logger logger = LoggerFactory.getLogger(RedisBillLockHandler.class);
    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待 nanoTime
     */
    private static final int DEFAULT_SINGLE_EXPIRE_TIME = 2 * 1000 * 1000 * 1000;
    private static final int DEFAULT_BATCH_EXPIRE_TIME = 4 * 1000 * 1000 * 1000;
    private static final int DEFAULT__EXPIRE_TIME = 5 * 60;
    @Autowired
    private JedisPool jedisPool;

    /**
     * 获取锁 只抢一次  如果锁可用   立即返回true，  否则返回false
     *
     * @param billIdentify
     * @return
     */
    public synchronized RedisLocked tryLock(IBillIdentify billIdentify) {
        return tryLock(billIdentify, 0L);
    }

    /**
     * 给定时间内抢锁  获取锁成功 返回true， 超时返回false
     *
     * @param billIdentify
     * @param timeout
     * @return
     */
    public synchronized RedisLocked tryLock(IBillIdentify billIdentify, long timeout) {
        String key = billIdentify.uniqueIdentify();
        Jedis jedis = null;
        RedisLocked redisLock = null;
        Long outTime = null;
        try {
            jedis = getResource();
            redisLock = new RedisLocked();
            redisLock.setLocked(false);
            long nano = System.nanoTime();
            do {
                logger.info("try lock key: " + key);
                outTime = System.nanoTime() + DEFAULT_SINGLE_EXPIRE_TIME;
                Long i = jedis.setnx(key, outTime + "");
                if (i == 1) {
                    //上锁
                    jedis.expire(key, DEFAULT__EXPIRE_TIME);
                    logger.info(Thread.currentThread().getName() + " set lock, key: " + key + " , expire in " + outTime + " nano seconds.");
                    redisLock.setLocked(true);
                    redisLock.setOutTime(outTime);
                    return redisLock;
                } else {
                    // 存在锁
                    long keyTime = Long.parseLong(jedis.get(key));
                    long ll = System.nanoTime() - keyTime;
                    //是否过期
                    if (ll > 0) {
                        //监听锁
                        jedis.watch(key);
                        Transaction t = jedis.multi();
                        outTime = System.nanoTime() + DEFAULT_SINGLE_EXPIRE_TIME;
                        t.set(key, outTime + "");
                        if (t.exec() != null) {
                            //重新上锁成功
                            jedis.expire(key, DEFAULT__EXPIRE_TIME);
                            logger.info(Thread.currentThread().getName() + "lock is timeout, set new lock, key: " + key + " , expire in " + outTime + " nano seconds.");
                            redisLock.setLocked(true);
                            redisLock.setOutTime(outTime);
                            return redisLock;
                        } else {
                            logger.info(Thread.currentThread().getName() + "lock is timeout,  but lock locked by another business. key: " + key);

                        }
                        /*outTime = System.nanoTime() + DEFAULT_SINGLE_EXPIRE_TIME;
                        String time = jedis.getSet(key, outTime + "");
                        if(keyTime==Long.parseLong(time)){

                        }
                        else{
                        }*/
                    }
                    if (logger.isInfoEnabled()) {
                        String desc = jedis.get(key);
                        logger.info(Thread.currentThread().getName() + "key: " + key + " locked by another business：" + desc);
                    }
                }
                if (timeout == 0) {
                    break;
                }
                Thread.sleep(300);
            } while ((System.nanoTime() - nano) < TimeUnit.SECONDS.toNanos(timeout));

            return redisLock;
        } catch (JedisConnectionException je) {
            logger.error(je.getMessage(), je);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return redisLock;
    }

    /**
     * 一直抢锁
     * 如果锁空闲立即返回   获取失败 一直等待
     *
     * @param billIdentify
     */
    public synchronized RedisLocked lock(IBillIdentify billIdentify) {
        String key = billIdentify.uniqueIdentify();
        Jedis jedis = null;
        RedisLocked redisLocked = null;
        Long outTime = null;
        try {
            jedis = getResource();
            do {
                logger.info("try lock key: " + key);
                outTime = System.nanoTime() + DEFAULT_SINGLE_EXPIRE_TIME;
                Long i = jedis.setnx(key, outTime + "");
                if (i == 1) {
                    logger.info("get lock, key: " + key + " , expire in " + outTime + "nano seconds.");
                    redisLocked.setLocked(true);
                    redisLocked.setOutTime(outTime);
                    return redisLocked;
                } else {
                    if (logger.isInfoEnabled()) {
                        String desc = jedis.get(key);
                        logger.info("key: " + key + " locked by another business：" + desc);
                    }
                }
                Thread.sleep(300);
            } while (true);
        } catch (JedisConnectionException je) {
            logger.error(je.getMessage(), je);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return redisLocked;
    }

    /**
     * 释放锁
     *
     * @param billIdentify
     */
    public synchronized void unLock(IBillIdentify billIdentify, RedisLocked redisLocked) {
        String key = billIdentify.uniqueIdentify();
        Jedis jedis = null;
        try {
            jedis = getResource();
            long outTime = Long.parseLong(jedis.get(key));
            if (redisLocked.getOutTime() == outTime) {
                jedis.del(key);
                logger.info("release lock, key :" + key);
            } else {
                logger.info("cannot release lock,lock is changed, outTime :" + outTime);
            }
        } catch (JedisConnectionException je) {
            logger.error(je.getMessage(), je);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }


    }

    /**
     * 批量获取锁  如果全部获取   立即返回true, 部分获取失败 返回false
     *
     * @param billIdentifyList
     * @return
     */
    public synchronized boolean tryLock(List<IBillIdentify> billIdentifyList) {
        return tryLock(billIdentifyList, 0L, null);
    }

    /**
     * 锁在给定的等待时间内空闲，则获取锁成功 返回true， 否则返回false
     *
     * @param billIdentifyList
     * @param timeout
     * @param unit
     * @return
     */
    public synchronized boolean tryLock(List<IBillIdentify> billIdentifyList, long timeout, TimeUnit unit) {
        Jedis jedis = null;
        try {
            List<String> needLocking = new CopyOnWriteArrayList<String>();
            List<String> locked = new CopyOnWriteArrayList<String>();
            jedis = getResource();
            long nano = System.nanoTime();
            do {
                // 构建pipeline，批量提交
                Pipeline pipeline = jedis.pipelined();
                for (IBillIdentify identify : billIdentifyList) {
                    String key = identify.uniqueIdentify();
                    needLocking.add(key);
                    //设置超时时间
                    pipeline.setnx(key, System.nanoTime() + DEFAULT_SINGLE_EXPIRE_TIME + "");
                }
                logger.info("try lock keys: " + needLocking);
                // 提交redis执行计数
                List<Object> results = pipeline.syncAndReturnAll();
                for (int i = 0; i < results.size(); ++i) {
                    Long result = (Long) results.get(i);
                    String key = needLocking.get(i);
                    if (result == 1) {  // setnx成功，获得锁
                        locked.add(key);
                    }
                }
                needLocking.removeAll(locked);  // 已锁定资源去除

                if (CollectionUtils.isEmpty(needLocking)) {
                    return true;
                } else {
                    // 部分资源未能锁住
                    logger.info("keys: " + needLocking + " locked by another business：");
                }

                if (timeout == 0) {
                    break;
                }
                Thread.sleep(500);
            } while ((System.nanoTime() - nano) < unit.toNanos(timeout));

            // 得不到锁，释放锁定的部分对象，并返回失败
            if (!CollectionUtils.isEmpty(locked)) {
                jedis.del(locked.toArray(new String[0]));
            }
            return false;
        } catch (JedisConnectionException je) {
            logger.error(je.getMessage(), je);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return true;
    }

    /**
     * 批量释放锁
     *
     * @param billIdentifyList
     */
    public synchronized void unLock(List<IBillIdentify> billIdentifyList) {
        List<String> keys = new CopyOnWriteArrayList<String>();
        for (IBillIdentify identify : billIdentifyList) {
            String key = identify.uniqueIdentify();
            keys.add(key);
        }
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.del(keys.toArray(new String[0]));
            logger.info("release lock, keys :" + keys);
        } catch (JedisConnectionException je) {
            logger.error(je.getMessage(), je);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * @return
     */
    private Jedis getResource() {
        return jedisPool.getResource();
    }

    /**
     * 返还给连接池
     *
     * @param jedis
     */
    private void returnResource(Jedis jedis) {
        if (jedis == null) {
            return;
        }
        try {
            jedis.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


}