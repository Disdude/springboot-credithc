package com.hc.henghuirong.server.config;

import com.hc.henghuirong.server.annotation.EnableUid;
import com.hc.henghuirong.server.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Wu.Kang on 2017/4/25.
 */
@Configuration
@ConditionalOnBean(annotation = EnableUid.class)
@EnableConfigurationProperties(IdQueueProperties.class)
public class IdQueueConfig {

    @Autowired
    private IdService idService;

    @Autowired
    BlockingQueue idQueue;

    @Autowired
    private IdQueueProperties idQueueProperties;

    @PostConstruct
    public void BlockingQueueConfig(){
        IdProducer idProducer = new IdProducer();
        idProducer.setIdService(idService);
        idProducer.setIdQueue(idQueue);
        idProducer.setQueueSize(idQueueProperties.getSize());
        idProducer.setThreshHold(idQueueProperties.getThreshHold());
        new Thread(idProducer).start();
    }
}
