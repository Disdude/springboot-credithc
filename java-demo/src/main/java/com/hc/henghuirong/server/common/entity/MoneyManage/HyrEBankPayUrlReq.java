package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 网银支付地址获取
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrEBankPayUrlReq extends BaseObject {

    //交易流水号（唯一）
    private String bizId;

    //客户编号
    private String customerId;

    //银行编码
    private String bankId;

    //支付金额 包含手续费金额
    private String amount;

    //前台通知地址
    private String pickupUrl;

    //购买产品名称 此名称会在支付页面显示
    private String productName;

    //支付类型 1：银行直连
    private String payFlag;

    //手续费 多乐融必填
    private String charge;

    //公司主体：HCLT：恒昌利通；HSZY：恒盛致远；DLJR：多乐金融；
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPickupUrl() {
        return pickupUrl;
    }

    public void setPickupUrl(String pickupUrl) {
        this.pickupUrl = pickupUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
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
