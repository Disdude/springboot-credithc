package com.hc.henghuirong.server.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


import java.util.concurrent.ExecutorService;

/**
 * Created by wenzhiwei on 17-4-14.
 */
public abstract class AbstractAutoConfiguration implements ApplicationContextAware, InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAutoConfiguration.class);


    protected ApplicationContext applicationContext;

    @Override
    public final void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public final void afterPropertiesSet() throws Exception {
        initExecutorService().submit(getJob());
    }

    @Override
    public final void destroy() throws Exception {
        if(initExecutorService()!=null) {
            initExecutorService().shutdown();
        }
    }


    protected abstract ExecutorService initExecutorService();

    protected abstract Runnable getJob();
}
