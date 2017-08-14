package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 快捷支付验证码发送
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQuickPayCodeReq extends BaseObject {

    //订单号 交易流水号（唯一）
    private String bizId;

    //客户编号
    private String customerId;

    //银行卡号
    private String bankCardNo;

    //金额
    private String amount;

    //银行编码
    private String bankId;

    //手机号
    private String mobile;

    //手续费  多乐融必填
    private String charge;

    //公司主体 公司主体：HCLT：恒昌利通；HSZY：恒盛致远；DLJR：多乐金融
    private String companyMainBody;

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

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getCompanyMainBody() {
        return companyMainBody;
    }

    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody;
    }
}
