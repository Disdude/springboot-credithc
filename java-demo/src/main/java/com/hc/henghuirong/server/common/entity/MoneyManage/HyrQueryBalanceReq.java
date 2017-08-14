package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 余额查询
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQueryBalanceReq extends BaseObject {

    //客户编号
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
