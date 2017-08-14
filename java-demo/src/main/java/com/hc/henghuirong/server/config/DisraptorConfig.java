package com.hc.henghuirong.server.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wenzhiwei on 17-4-14.
 */
//@Configuration
//@ConditionalOnBean(annotation = EnableDisraptor.class)
//@EnableConfigurationProperties(DisraptorProperties.class)
public class DisraptorConfig extends AbstractAutoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(DisraptorConfig.class);

    @Autowired
    private DisraptorProperties disraptorProperties;

    private static Runnable disraptorTask = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000l);
                    logger.info("disraptor is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected ExecutorService initExecutorService() {
        return executorService;
    }

    @Override
    protected Runnable getJob() {
        return disraptorTask;
    }


}
