package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 换卡
 */
public class ChangeCardReq extends BaseObject {

    //订单号
    private String bizId;

    //客户姓名
    private String name;

    //身份证号
    private String idCardNo;

    //客户编号
    private String customerId;

    //新卡绑定手机号
    private String mobile;

    //新银行卡开户省
    private String provinceId;

    //新卡银行编码
    private String bankId;

    //新卡开户市
    private String cityId;

    //新卡开户行名称
    private String openBankName;

    //新卡银行卡号
    private String nBankCardNo;

    //新卡绑卡类型
    private String bankCardType;

    //原银行卡号
    private String oBankCardNo;

    //公司主体 HCLT：恒昌利通；HSZY：恒盛致远；DLJR：多乐金融；
    private String companyMainBody;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public String getnBankCardNo() {
        return nBankCardNo;
    }

    public void setnBankCardNo(String nBankCardNo) {
        this.nBankCardNo = nBankCardNo;
    }

    public String getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getoBankCardNo() {
        return oBankCardNo;
    }

    public void setoBankCardNo(String oBankCardNo) {
        this.oBankCardNo = oBankCardNo;
    }

    public String getCompanyMainBody() {
        return companyMainBody;
    }

    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody;
    }
}
