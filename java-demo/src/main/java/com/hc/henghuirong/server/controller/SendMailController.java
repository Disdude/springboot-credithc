package com.hc.henghuirong.server.controller;

import com.hc.henghuirong.server.common.model.Result;
import com.hc.henghuirong.server.controller.base.RestApi;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hu.cong.cong on 2017/4/19.
 */
@RestController
public class SendMailController {
    private static final Logger logger = LoggerFactory.getLogger(SendMailController.class);
    @Autowired
    MailService mailServiceImpl;

    @RequestMapping("mailAtt")
    public Result sendMailAtt() {
        String sendTo = "751283482@qq.com";
        String subject = "spring-boot-mail";
        String text = "sakamoto";

        return new RestApi<String>() {
            @Override
            public String process() throws BizException {

                boolean send = mailServiceImpl.sendAttachment(subject,text,"src/main/resources/static/ddd.txt","doc.txt",sendTo);

                if (send) {
                    return "send success";

                }
                return "failed to send email";
            }
        }.execute();

    }
    @RequestMapping("mail")
    public Result sendMail() {
        String sendTo = "751283482@qq.com";
        String subject = "spring-boot-mail";
        String text = "sakamoto";

        return new RestApi<String>() {
            @Override
            public String process() throws BizException {

                boolean send = mailServiceImpl.send(subject, text,sendTo);

                if (send) {
                    return "send success";

                }
                return "failed to send email";
            }
        }.execute();

    }


}
