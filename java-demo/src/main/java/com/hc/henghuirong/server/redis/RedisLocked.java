package com.hc.henghuirong.server.redis;

/**
 * Created by hu.cong.cong on 2017/4/17.
 */
public class RedisLocked {
    private boolean locked;
    private Long outTime;

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return "RedisLocked{" +
                "locked=" + locked +
                ", outTime=" + outTime +
                '}';
    }
}
