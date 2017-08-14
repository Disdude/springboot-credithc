package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class HyrCompensateReq extends BaseObject {

    //提现金额
    private String takeAmount;

    //补偿时间
    private String cashbackTime;

    //补偿业务编号
    private String bizId;

    //客户编号
    private String customerId;

    //补偿金额
    private String amount;

    public String getTakeAmount() {
        return takeAmount;
    }

    public void setTakeAmount(String takeAmount) {
        this.takeAmount = takeAmount;
    }

    public String getCashbackTime() {
        return cashbackTime;
    }

    public void setCashbackTime(String cashbackTime) {
        this.cashbackTime = cashbackTime;
    }

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
