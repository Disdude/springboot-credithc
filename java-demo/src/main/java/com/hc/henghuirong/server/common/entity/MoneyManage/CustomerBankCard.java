package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class CustomerBankCard extends BaseObject {

    //绑卡时间
    private String bindCardTime;

    //客户姓名
    private String customerName;

    //手机号码
    private String phone;

    //开户银行
    private String bankId;

    //开户省
    private String provinceId;

    //开户市
    private String cityId;

    //卡号
    private String accountNo;

    //备注
    private String remark;

    public String getBindCardTime() {
        return bindCardTime;
    }

    public void setBindCardTime(String bindCardTime) {
        this.bindCardTime = bindCardTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
