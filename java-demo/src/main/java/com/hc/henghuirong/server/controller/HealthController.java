package com.hc.henghuirong.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hu.cong.cong on 2017/4/5.
 */

@RestController
@RequestMapping("/health")
public class HealthController {

     @RequestMapping("")
    public  Map<String,Object> getHealth() {

        Map<String,Object> hashMap = new HashMap<String,Object>();
        MemoryMXBean mm=(MemoryMXBean) ManagementFactory.getMemoryMXBean();
        ThreadMXBean tm=(ThreadMXBean)ManagementFactory.getThreadMXBean();
        ClassLoadingMXBean cl = ManagementFactory.getClassLoadingMXBean();
        OperatingSystemMXBean osm = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
         hashMap.put("系统内存总量",Runtime.getRuntime().totalMemory()/1024+"kb");
         hashMap.put("系统空闲内存量",Runtime.getRuntime().freeMemory()/1024+"kb");
         hashMap.put("系统最大内存量",+Runtime.getRuntime().maxMemory()/1024+"kb");
         hashMap.put("可用处理器数量",osm.getAvailableProcessors()+"个");
         hashMap.put("存活的线程数", tm.getThreadCount()+"个");
         hashMap.put("当前线程占用CPU时间",tm.getCurrentThreadCpuTime()+"ms");
         hashMap.put("当前加载类数量",cl.getLoadedClassCount()+"个");
         hashMap.put("已加载类数量",cl.getTotalLoadedClassCount()+"个");
         hashMap.put("初始化堆内存量",mm.getHeapMemoryUsage().getInit()/1024+"kb");
         hashMap.put("已提交的堆内存量",mm.getHeapMemoryUsage().getCommitted()/1024+"kb");
         hashMap.put("已使用堆内存量",mm.getHeapMemoryUsage().getUsed()/1024+"kb");

        return hashMap;
    }
}
