package com.hc.henghuirong.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Wu.Kang on 2017/4/21.
 */
@ConfigurationProperties(prefix = "server.rabbitmq")
public class RabbitProperties {
    private String exchange;
    private String routineKey;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutineKey() {
        return routineKey;
    }

    public void setRoutineKey(String routineKey) {
        this.routineKey = routineKey;
    }
}
