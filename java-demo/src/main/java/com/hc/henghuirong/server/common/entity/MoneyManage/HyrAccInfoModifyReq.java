package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 账户信息修改
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrAccInfoModifyReq extends BaseObject {

    //客户编号
    private String customerId;

    //客户身份类型  1:出借人、0:借款人
    private String customerIdType;

    //手机号
    private String mobile;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(String customerIdType) {
        this.customerIdType = customerIdType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
