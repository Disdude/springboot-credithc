package com.hc.henghuirong.server.service;

/**
 * Created by B4360 on 2017/4/14.
 */
public interface SendMessageService {
    void sendMessage(String exchange, String routineKey, String content);
}
