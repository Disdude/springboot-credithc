package com.hc.henghuirong.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * disraptor 配置
 * Created by wenzhiwei on 17-4-14.
 */
@ConfigurationProperties(prefix = "server.disraptor")
public class DisraptorProperties {

    private Integer poolSize;

    private String ringBufferSize;

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public String getRingBufferSize() {
        return ringBufferSize;
    }

    public void setRingBufferSize(String ringBufferSize) {
        this.ringBufferSize = ringBufferSize;
    }
}
