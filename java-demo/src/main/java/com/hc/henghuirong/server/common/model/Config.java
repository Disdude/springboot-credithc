package com.hc.henghuirong.server.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzhiwei on 17-3-23.
 */
@ConfigurationProperties(prefix = "my")
@Component
public class Config {

    private String name;
    private Integer port;
    private List<String> servers = new ArrayList<String>();

    public String geName() {
        return this.name;
    }

    public Integer gePort() {
        return this.port;
    }

    public List<String> getServers() {
        return this.servers;
    }
}
