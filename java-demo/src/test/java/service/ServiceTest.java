package service;

import com.hc.henghuirong.server.App;
import com.hc.henghuirong.server.common.model.res.SignRes;
import com.hc.henghuirong.server.config.AmqpConfig;
import com.hc.henghuirong.server.config.RabbitProperties;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.SendMessageService;
import com.hc.henghuirong.server.service.auth.ThirdPartyService;
import com.hc.henghuirong.server.service.impl.CxfServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Wu.Kang on 2017/4/1.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = App.class)
@Transactional
public class ServiceTest {
    @Autowired
    ThirdPartyService thirdPartyService;

    @Autowired
    CxfServiceImpl cxfService;

    @Autowired
    RabbitProperties rabbitProperties;

    @Autowired
    SendMessageService sendMessageService;

    @Test
    public void testUpdateStatus()
    {
        Assert.assertEquals(1, thirdPartyService.updateStatus(18,2));
    }

    @Test
    public void testGetInfo() throws BizException
    {
        SignRes signRes= cxfService.getInfo(12);
        Assert.assertEquals("12", signRes.getSign());
    }

    @Test
    public void testSendMsg()
    {
        sendMessageService.sendMessage(rabbitProperties.getExchange(),rabbitProperties.getRoutineKey(),"hello,world");
    }

}
