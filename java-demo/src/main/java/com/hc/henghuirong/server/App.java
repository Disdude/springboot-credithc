package com.hc.henghuirong.server;


import com.github.ltsopensource.spring.boot.annotation.EnableJobClient;
import com.github.ltsopensource.spring.boot.annotation.EnableTaskTracker;
import com.google.common.base.Stopwatch;
import com.hc.henghuirong.server.annotation.EnableDisraptor;
import com.hc.henghuirong.server.annotation.EnableRabbitMq;
import com.hc.henghuirong.server.annotation.EnableRedis;
import com.hc.henghuirong.server.annotation.EnableUid;
import com.hc.henghuirong.server.listners.ApplicationEnvironmentPreparedListener;
import com.hc.henghuirong.server.listners.ApplicationFailedListener;
import com.hc.henghuirong.server.listners.ApplicationPreparedListener;
import com.hc.henghuirong.server.listners.ApplicationStartedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by wenzhiwei on 17-3-14.
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//开启spring对Aspectj的支持
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@EnableJobClient
@EnableTaskTracker
@EnableDisraptor
@EnableRabbitMq
@EnableRedis
@EnableUid
public class App {

    public static void main(String[] args) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        SpringApplication application = new SpringApplication(App.class);
        application.addListeners(new ApplicationEnvironmentPreparedListener());
        application.addListeners(new ApplicationFailedListener());
        application.addListeners(new ApplicationPreparedListener());
        application.addListeners(new ApplicationStartedListener());
        ApplicationContext ctx = application.run(App.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();

        Environment env = (Environment) ctx.getBean("environment");
        System.out.println("端口号:" + env.getProperty("local.server.port") + " 启动耗时:" + stopwatch.elapsed(TimeUnit.SECONDS) + "秒");
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }


}
