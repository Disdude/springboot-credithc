package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 开户
 * Created by wenzhiwei on 17-4-28.
 */
public class HyrOpenAccReq extends BaseObject {

    //注册名
    private String regName;

    //登录密码
    private String password;

    //姓名
    private String name;

    //身份证号 支持18/15位身份证号
    private String idCardNo;

    //客户类型 0 普通个人
    private String customerType;

    //注册名 类型 用户名：0、手机号:1、邮箱:2、qq:3、微博:4、身份证:5
    private String regNameType;

    //交易密码
    private String tradePassword;

    //托管行 0：广发（微服可不填）
    private String trusteeBank;

    //手机号
    private String mobile;

    // 客户身份类型 1:出借人、0:借款人、2:在职员工、3：离职员工
    private String customerIdType;

    //推荐人编号
    private String referrerNo;

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getRegNameType() {
        return regNameType;
    }

    public void setRegNameType(String regNameType) {
        this.regNameType = regNameType;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public String getTrusteeBank() {
        return trusteeBank;
    }

    public void setTrusteeBank(String trusteeBank) {
        this.trusteeBank = trusteeBank;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(String customerIdType) {
        this.customerIdType = customerIdType;
    }

    public String getReferrerNo() {
        return referrerNo;
    }

    public void setReferrerNo(String referrerNo) {
        this.referrerNo = referrerNo;
    }
}
