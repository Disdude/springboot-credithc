package com.hc.henghuirong.server.listners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring boot启动开始时执行的事件
 * Created by wenzhiwei on 17-3-31.
 */
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(getClass().getSimpleName());
    }

}
