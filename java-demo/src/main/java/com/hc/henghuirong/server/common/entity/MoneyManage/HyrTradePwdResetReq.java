package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 交易密码重置
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrTradePwdResetReq extends BaseObject {
    //客户编号
    private String customerId;

    //交易密码
    private String tradePassword;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }
}
