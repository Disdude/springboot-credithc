package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 绑卡
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrBindBankCardReq extends BaseObject {

    //订单号 系统统一标示
    private String bizId;

    //客户编号
    private String customerId;

    //持卡人姓名
    private String name;

    //持卡人手机号
    private String mobile;

    //持卡人银行卡号
    private String bankCardNo;

    //持卡人身份证号 18/15为身份证号
    private String idCardNo;

    //银行编码
    private String bankId;

    //绑卡类型 0：附属卡、1：主卡
    private String bankCardType;

    //公司主体 公司主体：HCLT：恒昌利通；HSZY：恒盛致远；DLJR：多乐金融；
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getCompanyMainBody() {
        return companyMainBody;
    }

    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody;
    }
}
