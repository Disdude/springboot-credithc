package com.hc.henghuirong.server.redis;

/**
 * Created by hu.cong.cong on 2017/4/13.
 */
public class IBillIdentify {
    private String key;

    public String getKey() {
        return key;
    }

    public IBillIdentify() {
    }

    public IBillIdentify(String key) {

        this.key = key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String uniqueIdentify() {
        return this.key+".lock";
    }
}
