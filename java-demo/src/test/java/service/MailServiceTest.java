package service;

import com.hc.henghuirong.server.App;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wenzhiwei on 17-4-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = App.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendMailTest() throws BizException {


        mailService.send("文本","这是文本","wenzhiwei170313@credithc.com");

        mailService.sendHtml("html","<font color=red>html</font>","wenzhiwei170313@credithc.com");

    }
}
