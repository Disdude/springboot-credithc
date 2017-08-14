package com.hc.henghuirong.server.common.entity.MoneyManage.HyrBankInfoQuery;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 网关限额
 */
public class GateWayPay extends BaseObject {

    //客户类型
    private String customerType;
    //卡类型
    private String cardType;

    //网关日限额
    private int gatewayPayDailyLimit;

    //网关单笔限额
    private int gatewaySingleLimit;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getGatewayPayDailyLimit() {
        return gatewayPayDailyLimit;
    }

    public void setGatewayPayDailyLimit(int gatewayPayDailyLimit) {
        this.gatewayPayDailyLimit = gatewayPayDailyLimit;
    }

    public int getGatewaySingleLimit() {
        return gatewaySingleLimit;
    }

    public void setGatewaySingleLimit(int gatewaySingleLimit) {
        this.gatewaySingleLimit = gatewaySingleLimit;
    }
}
