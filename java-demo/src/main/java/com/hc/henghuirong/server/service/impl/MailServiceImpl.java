package com.hc.henghuirong.server.service.impl;

import com.hc.henghuirong.server.config.EmailProperties;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.MailService;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * Created by hu.cong.cong on 2017/4/19.
 */
@Service
public class MailServiceImpl implements MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
    @Autowired
    JavaMailSenderImpl mailSender;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Autowired
    private EmailProperties emailProperties;

    @Override
    public boolean send(String title, String msg, String... to) throws BizException {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailProperties.getUsername());
            message.setTo(to);
            message.setSubject(title);
            message.setText(msg);
            mailSender.setPort(emailProperties.getPort());
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            logger.info("发送失败", e);
            return false;
        }
    }

    /**
     * 发送html
     *
     * @param to
     * @param title
     * @param html  HTML格式的字符串
     * @return
     * @throws BizException
     */
    @Override
    public boolean sendHtml(String title, String html, String... to) throws BizException {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailProperties.getUsername());
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(html, true);
            mailSender.setPort(emailProperties.getPort());
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            logger.info("发送失败", e);
            return false;
        }
    }

    /**
     * 发送附件
     *
     * @param to
     * @param title
     * @param msg
     * @param fileResource 文件位置
     * @param fileName     文件重命名
     * @return
     * @throws BizException
     */
    @Override
    public boolean sendAttachment(String title, String msg, String fileResource, String fileName, String... to) throws BizException {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailProperties.getUsername());
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(msg);
            //注意项目路径问题，自动补用项目路径
            FileSystemResource file = new FileSystemResource(new File(fileResource));
            //加入邮件
            helper.addAttachment(fileName, file);
            mailSender.setPort(emailProperties.getPort());
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            logger.info("发送失败", e);
            return false;
        }
    }

    /**
     * 发送模板文件
     *
     * @param to
     * @param title
     * @param model
     * @param modelHtml html模板名称  默认在resource/templates下
     * @return
     * @throws BizException
     */
    @Override
    public boolean sendTemplateMail(String title, Map<String, Object> model, String modelHtml, String... to) throws BizException {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailProperties.getUsername());
            helper.setTo(to);
            helper.setSubject(title);
            //读取 html 模板
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(modelHtml);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);
            mailSender.setPort(emailProperties.getPort());
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            logger.info("发送失败", e);
            return false;
        }
    }
}
