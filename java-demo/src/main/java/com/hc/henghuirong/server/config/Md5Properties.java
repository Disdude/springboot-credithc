package com.hc.henghuirong.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dell-3020 on 2017/3/22.
 */
@Configuration
@ConfigurationProperties( prefix = "md5")
public class Md5Properties {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
