package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 账户基础信息查询
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQueryAccInfoReq extends BaseObject {

    //系统
    private String bizSystem;

    //客户编号
    private String customerId;

    public String getBizSystem() {
        return bizSystem;
    }

    public void setBizSystem(String bizSystem) {
        this.bizSystem = bizSystem;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
