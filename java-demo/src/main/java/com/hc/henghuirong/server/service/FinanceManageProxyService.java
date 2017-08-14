package com.hc.henghuirong.server.service;

import com.hc.henghuirong.server.annotation.Octupus;
import com.hc.henghuirong.server.common.entity.MoneyManage.*;
import com.hc.henghuirong.server.common.entity.MoneyManage.HyrBankInfoQuery.HyrBankInfoQueryReq;
import com.hc.henghuirong.server.octopus.MqResponseVo;

/**
 * 存管 资金管理 webservice 服务代理层
 * Created by wenzhiwei on 17-5-4.
 */
public interface FinanceManageProxyService {

    /**
     * 开户
     * @param openAccReq
     * @return 结果对象
     */
    @Octupus("HyrOpenAcc")
    MqResponseVo openAccount(HyrOpenAccReq openAccReq);

    /**
     * 实名认证
     * @param idCardVerifyReq
     * @return 结果对象
     */
    @Octupus("HyrIdCardVerify")
    MqResponseVo cardVerify(HyrIdCardVerifyReq idCardVerifyReq);

    /**
     * 绑卡
     * @param bindBankCardReq
     * @return
     */
    @Octupus("HyrBindBankCard")
    MqResponseVo bindBankCard(HyrBindBankCardReq bindBankCardReq);

    /**
     * 解绑
     * @param undoBankCardReq
     * @return
     */
    @Octupus("HyrUndoBankCard")
    MqResponseVo undoBankCard(HyrUndoBankCardReq undoBankCardReq);

    /**
     * 订单支付状态查询
     * @param queryPayStateReq
     * @return
     */
    @Octupus("HyrQueryPayState")
    MqResponseVo queryPayStatus(HyrQueryPayStateReq queryPayStateReq);

    /**
     * 债券转让
     * @param loanTransferReq
     * @return
     */
    @Octupus("HyrLoanTransfer")
    MqResponseVo loanTransfer(HyrLoanTransferReq loanTransferReq);


    /**
     * 交易密码验证
     * @param verifyTradePwdReq
     * @return
     */
    @Octupus("HyrVerifyTradePwd")
    MqResponseVo verifyTradePwd(HyrVerifyTradePwdReq verifyTradePwdReq);

    /**
     * 交易密码修改
     * @param tradePwdModifyReq
     * @return
     */
    @Octupus("HyrTradePwdModify")
    MqResponseVo tradePwdModify(HyrTradePwdModifyReq tradePwdModifyReq);


    /**
     * 交易密码重置
     * @param tradePwdResetReq
     * @return
     */
    @Octupus("HyrTradePwdReset")
    MqResponseVo tradePwdReset(HyrTradePwdResetReq tradePwdResetReq);

    /**
     * 账户基础信息查询
     * @param queryAccInfoReq
     * @return
     */
    @Octupus("HyrQueryAccInfo")
    MqResponseVo queryAccountInfo(HyrQueryAccInfoReq queryAccInfoReq);


    /**
     * 余额查询
     * @param queryBalanceReq
     * @return
     */
    @Octupus("HyrQueryBalance")
    MqResponseVo queryBalance(HyrQueryBalanceReq queryBalanceReq);

    /**
     * 快捷支付手机验证码发送
     * @param quickPayCodeReq
     * @return
     */
    @Octupus("HyrQuickPayCode")
    MqResponseVo quickPayCodeSend(HyrQuickPayCodeReq quickPayCodeReq);


    /**
     * 快捷支付确认
     * @param quickPayReq
     * @return
     */
    @Octupus("HyrQuickPay")
    MqResponseVo quickPay(HyrQuickPayReq quickPayReq);


    /**
     * 网银支付地址获取
     * @param eBankPayUrlReq
     * @return
     */
    @Octupus("HyrEBankPayUrl")
    MqResponseVo eBankPayUrl(HyrEBankPayUrlReq eBankPayUrlReq);

    /**
     * 卡bin信息查询
     * @param queryCardInfoReq
     * @return
     */
    @Octupus("HyrQueryCardInfo")
    MqResponseVo queryCardInfo(HyrQueryCardInfoReq queryCardInfoReq);

    /**
     * 账户信息修改
     * @param accInfoModifyReq
     * @return
     */
    @Octupus("HyrAccInfoModify")
    MqResponseVo  accInfoModify(HyrAccInfoModifyReq accInfoModifyReq);


    /**
     * 银行列表查询
     * @param bankInfoQueryReq
     * @return
     */
    @Octupus("HyrBankInfoQuery")
    MqResponseVo queryBankList(HyrBankInfoQueryReq bankInfoQueryReq);

    /**
     * 绑卡信息查询
     * @param queryBankCardByCustomerIdReq
     * @return
     */
    @Octupus("QueryBankCardByCustomerId")
    MqResponseVo BankCardByCustomerId(QueryBankCardByCustomerIdReq queryBankCardByCustomerIdReq);

}
