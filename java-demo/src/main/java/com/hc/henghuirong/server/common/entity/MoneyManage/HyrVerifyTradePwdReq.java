package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 交易密码验证
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrVerifyTradePwdReq extends BaseObject {

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
