package com.hc.henghuirong.server.annotation;

import java.lang.annotation.*;

/**
 * Created by wenzhiwei on 17-4-21.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableRabbitMq {
}
