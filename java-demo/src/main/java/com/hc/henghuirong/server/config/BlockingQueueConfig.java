package com.hc.henghuirong.server.config;

import com.hc.henghuirong.server.annotation.EnableUid;
import com.hc.henghuirong.server.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Wu.Kang on 2017/4/25.
 */
@Configuration
@ConditionalOnBean(annotation = EnableUid.class)
@EnableConfigurationProperties(IdQueueProperties.class)
public class BlockingQueueConfig {

    @Autowired
    private IdQueueProperties idQueueProperties;

    @Bean
    BlockingQueue<Long> idQueue()
    {
        BlockingQueue blockingQueue = new LinkedBlockingQueue<>(idQueueProperties.getSize());
        return blockingQueue;
    }
}
