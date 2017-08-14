package com.hc.henghuirong.server.listners;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 上下文context创建完成
 * Created by wenzhiwei on 17-3-31.
 */
public class ApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        System.out.println(getClass().getSimpleName());
    }

}
