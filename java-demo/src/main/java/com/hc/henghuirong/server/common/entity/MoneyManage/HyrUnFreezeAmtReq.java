package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 资金解冻
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrUnFreezeAmtReq extends BaseObject {

    //交易流水号
    private String bizId;

    //客户编号
    private String customerId;

    //冻结金额
    private String money;

    //冻结id
    private String freezeId;

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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getFreezeId() {
        return freezeId;
    }

    public void setFreezeId(String freezeId) {
        this.freezeId = freezeId;
    }
}
