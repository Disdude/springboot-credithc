package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 快捷支付确认
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQuickPayReq extends BaseObject {

    //订单号 交易流水号（唯一）
    private String bizId;

    //客户编号
    private String customerId;

    //验证码
    private String checkCode;

    //总额 包含手续费金额
    private String amount;

    //充值订单号 发送验证码时返回的
    private String orderNo;

    //银行卡号
    private String bankCardNo;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
}
