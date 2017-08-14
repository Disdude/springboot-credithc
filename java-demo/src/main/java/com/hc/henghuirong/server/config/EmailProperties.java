package com.hc.henghuirong.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hu.cong.cong on 2017/4/21.
 */
@Configuration
@ConfigurationProperties( prefix = "spring.mail")
public class EmailProperties {

    private String username;
    private Integer port;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
