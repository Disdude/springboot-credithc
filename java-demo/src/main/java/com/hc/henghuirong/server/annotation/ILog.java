package com.hc.henghuirong.server.annotation;

import java.lang.annotation.*;

/**
 * Created by Wu.Kang on 2017/3/22.
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ILog {
}