package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 批量代收
 * Created by wenzhiwei on 17-5-2.
 */
public class BatchReceiptDetail extends BaseObject {

    //流水号
    private String bizId;

    //客户编号
    private String customerId;

    //银行编号
    private String bankId;

    //银行卡号
    private String bankCardNo;

    //金额
    private String amount;

    //账户属性  0私人，1公司
    private String accountProp;

    //手机号
    private String mobile;

    //备注
    private String remark;

    //划扣类型
    private String deductType;

    //身份证号
    private String identity;

    //手续费 手续费（多乐融必填），手续费会从充值总额中扣除
    private String charge;

    //公司主机 公司主体：HCLT：恒昌利通；HSZY：恒盛致远；DLJR：多乐金融；
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

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
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

    public String getAccountProp() {
        return accountProp;
    }

    public void setAccountProp(String accountProp) {
        this.accountProp = accountProp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeductType() {
        return deductType;
    }

    public void setDeductType(String deductType) {
        this.deductType = deductType;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
