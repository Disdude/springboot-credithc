package com.hc.henghuirong.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Wu.Kang on 2017/4/25.
 */
@ConfigurationProperties(prefix = "server.idQueue")
public class IdQueueProperties {
    private int size;
    private int threshHold;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getThreshHold() {
        return threshHold;
    }

    public void setThreshHold(int threshHold) {
        this.threshHold = threshHold;
    }
}
