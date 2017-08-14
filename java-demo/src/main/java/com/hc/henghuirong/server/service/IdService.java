package com.hc.henghuirong.server.service;

/**
 * 全局id生成器
 * Created by wenzhiwei on 17-4-21.
 */
public interface IdService {

    long getId();

    long generateNewIds(int batchCount);
}
