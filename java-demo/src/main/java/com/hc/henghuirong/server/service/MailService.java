package com.hc.henghuirong.server.service;

import com.hc.henghuirong.server.exceptions.BizException;

import java.util.Map;

/**
 * Created by wenzhiwei on 17-4-19.
 */
public interface MailService {

    boolean send(String title,String msg,String... to) throws BizException;
    boolean sendHtml(String title,String msg,String... to) throws BizException;
    boolean sendAttachment(String title,String msg,String fileResource,String fileName,String... to) throws BizException;
    boolean sendTemplateMail(String title, Map<String, Object> model,String modelHtml,String... to) throws BizException;

}
