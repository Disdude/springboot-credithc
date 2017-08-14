package cxfservice;

import com.github.ltsopensource.core.json.JSON;
import com.hc.henghuirong.server.App;
import com.hc.henghuirong.server.common.entity.MoneyManage.*;
import com.hc.henghuirong.server.octopus.Exception_Exception;
import com.hc.henghuirong.server.octopus.MqResponseVo;
import com.hc.henghuirong.server.service.FinanceManageProxyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wenzhiwei on 17-5-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FinanceManageProxyTest {

    @Autowired
    private FinanceManageProxyService financeManageProxyService;

    /**
     * {"jsonResult":"{\"customerId\":\"C_20170504000001\"}","realtime":false,"retCode":"0000","retInfo":"该客户已开过户！"}
     * @throws Exception_Exception
     */
    @Test
    public void testOpenAccount() throws Exception_Exception {
        HyrOpenAccReq hyrOpenAccReq = new HyrOpenAccReq();
        hyrOpenAccReq.setName("文志伟");
        hyrOpenAccReq.setCustomerIdType("1");
        hyrOpenAccReq.setCustomerType("0");
        hyrOpenAccReq.setIdCardNo("360124198901292739");
        hyrOpenAccReq.setMobile("13021027911");
        hyrOpenAccReq.setPassword("123456");
        hyrOpenAccReq.setReferrerNo("");
        hyrOpenAccReq.setRegName("元芳");
        hyrOpenAccReq.setRegNameType("0");
        hyrOpenAccReq.setTradePassword("23456");
        hyrOpenAccReq.setTrusteeBank("0");
        MqResponseVo responseVo = financeManageProxyService.openAccount(hyrOpenAccReq);
        System.out.println(JSON.toJSONString(responseVo));


    }

    /**
     * 交易密码修改
     *  {"realtime":false,"retCode":"0000","retInfo":"设置成功"}
     * @throws Exception_Exception
     */
    @Test
    public void testTradePwdModify() throws Exception_Exception {
        HyrTradePwdModifyReq tradePwdModifyReq = new HyrTradePwdModifyReq();
        tradePwdModifyReq.setCustomerId("C_20170504000001");
        tradePwdModifyReq.setOldTradePassword("23456");
        tradePwdModifyReq.setTradePassword("23456");
        MqResponseVo responseVo = financeManageProxyService.tradePwdModify(tradePwdModifyReq);
        System.out.println(JSON.toJSONString(responseVo));

    }
    /**
     * 交易密码重置
     *  {"realtime":false,"retCode":"0000","retInfo":"设置成功"}
     * @throws Exception_Exception
     */
    @Test
    public void testTradePwdRet() throws Exception_Exception {
        HyrTradePwdResetReq tradePwdResetReq = new HyrTradePwdResetReq();
        tradePwdResetReq.setCustomerId("C_20170504000001");
        tradePwdResetReq.setTradePassword("23456");
        MqResponseVo responseVo = financeManageProxyService.tradePwdReset(tradePwdResetReq);
        System.out.println(JSON.toJSONString(responseVo));

    }

    /**
     * 账户基础信息查询
     * {"jsonResult":"{\"class\":\"com.credithc.basic.original.service.trade.vo.HyrQueryAccInfoVo\",\"customerId\":\"C_20170504000001\",\"customerIdType\":\"null\",\"customerType\":\"0\",\"idCardNo\":\"null\",\"mobile\":\"null\",\"name\":\"文志伟\",\"openAccountTime\":\"2017-05-04 16:45:25\",\"state\":\"1\"}","realtime":false,"retCode":"0000","retInfo":"查询成功"}
     * @throws Exception_Exception
     */
    @Test
    public void testQueryAccInfo() throws Exception_Exception {
        HyrQueryAccInfoReq queryAccInfoReq  = new HyrQueryAccInfoReq();
        queryAccInfoReq.setCustomerId("C_20170504000001");
        //queryAccInfoReq.setBizSystem("");
        MqResponseVo responseVo = financeManageProxyService.queryAccountInfo(queryAccInfoReq);
        System.out.println(JSON.toJSONString(responseVo));

    }

    /**
     * 账户信息修改
     * {"realtime":false,"retCode":"3000","retInfo":"账户信息更新失败，客户名称(userName)是必填项"}
     * @throws Exception_Exception
     */
    @Test
    public void testAccInfoModify() throws Exception_Exception {
        HyrAccInfoModifyReq hyrAccInfoModifyReq  = new HyrAccInfoModifyReq();
        hyrAccInfoModifyReq.setCustomerId("C_20170504000001");
        hyrAccInfoModifyReq.setMobile("123445");
        hyrAccInfoModifyReq.setCustomerIdType("0");
        MqResponseVo responseVo = financeManageProxyService.accInfoModify(hyrAccInfoModifyReq);
        System.out.println(JSON.toJSONString(responseVo));

    }

    /**
     * 余额查询
     * {"jsonResult":"{\"acctBal\":0.00,\"frzBal\":0,\"avlBal\":0.00}","realtime":false,"retCode":"0000","retInfo":"查询所有子账户完成"}
     * @throws Exception_Exception
     */
    @Test
    public void testQueryBalance() throws Exception_Exception {
        HyrQueryBalanceReq queryBalanceReq  = new HyrQueryBalanceReq();
        queryBalanceReq.setCustomerId("C_20170504000001");
        MqResponseVo responseVo = financeManageProxyService.queryBalance(queryBalanceReq);
        System.out.println(JSON.toJSONString(responseVo));

    }

    /**
     * 快捷支付验证码发送
     * @throws Exception_Exception
     */
    @Test
    public void testQuickPayCode() throws Exception_Exception {
        HyrQuickPayCodeReq hyrQuickPayCodeReq  = new HyrQuickPayCodeReq();
        hyrQuickPayCodeReq.setCustomerId("C_20170504000001");
        hyrQuickPayCodeReq.setAmount("");
        hyrQuickPayCodeReq.setBankCardNo("");
        hyrQuickPayCodeReq.setBankId("");
        hyrQuickPayCodeReq.setBizId("");
        hyrQuickPayCodeReq.setCharge("");
        hyrQuickPayCodeReq.setCompanyMainBody("");
        hyrQuickPayCodeReq.setMobile("18605676236");
        MqResponseVo responseVo = financeManageProxyService.quickPayCodeSend(hyrQuickPayCodeReq);
        System.out.println(JSON.toJSONString(responseVo));

    }

    /**
     * 快捷支付确认
     * @throws Exception_Exception
     */
    @Test
    public void testHyrQuickPay() throws Exception_Exception {
        HyrQuickPayReq hyrQuickPayReq  = new HyrQuickPayReq();
        hyrQuickPayReq.setCustomerId("C_20170504000001");
        hyrQuickPayReq.setBizId("");
        hyrQuickPayReq.setBankCardNo("");
        hyrQuickPayReq.setAmount("");
        hyrQuickPayReq.setOrderNo("");
        MqResponseVo responseVo = financeManageProxyService.quickPay(hyrQuickPayReq);
        System.out.println(JSON.toJSONString(responseVo));

    }

    /**
     * 卡bin信息查询
     * @throws Exception_Exception
     */
    @Test
    public void testHyrQueryCardInfo() throws Exception_Exception {
        HyrQueryCardInfoReq hyrQueryCardInfoReq  = new HyrQueryCardInfoReq();
        hyrQueryCardInfoReq.setBizId("");
        hyrQueryCardInfoReq.setBankCardNo("");
        hyrQueryCardInfoReq.setCompanyMainBody("");
        MqResponseVo responseVo = financeManageProxyService.queryCardInfo(hyrQueryCardInfoReq);
        System.out.println(JSON.toJSONString(responseVo));
    }



    //*********************************************  分界线 *************************************





}
