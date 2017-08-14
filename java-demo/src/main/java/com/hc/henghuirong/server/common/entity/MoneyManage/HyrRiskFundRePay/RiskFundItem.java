package com.hc.henghuirong.server.common.entity.MoneyManage.HyrRiskFundRePay;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class RiskFundItem extends BaseObject {

    //本手方客户编号
    private String customerId;

    //本手方子账户类型
    private String subType;

    //本手方子账户编号
    private String bizId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(String tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    //交易金额
    private String tradeAmt;

}
