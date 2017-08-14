package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 账户基础信息查询
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQueryAccInfoRes extends BaseObject {

    //客户编号
    private String customerId;

    //客户类型  普通个人：0
    private String customerType;

    //客户姓名
    private String name;

    //身份证号码
    private String idCardNo;

    //手机号 （非必填）
    private String mobile;

    //开户时间   格式：yyyy-MM-dd HH:mm:ss
    private String openAccountTime;

    //客户身份类型  1:出借人、0:借款人
    private String customerIdType;

    //账户状态  0:冻结，1: 正常
    private String state;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(String openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public String getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(String customerIdType) {
        this.customerIdType = customerIdType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
