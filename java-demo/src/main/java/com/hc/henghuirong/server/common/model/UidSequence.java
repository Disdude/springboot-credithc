package com.hc.henghuirong.server.common.model;

/**
 * Created by Wu.Kang on 2017/4/24.
 */
public class UidSequence extends BaseObject{
    private int id;
    private long maxId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }
}
