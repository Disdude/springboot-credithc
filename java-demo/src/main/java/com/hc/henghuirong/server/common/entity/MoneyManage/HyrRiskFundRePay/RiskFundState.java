package com.hc.henghuirong.server.common.entity.MoneyManage.HyrRiskFundRePay;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class RiskFundState extends BaseObject {

    //流水号
    private String tradeFlowId;

    //响应码
    private String retCode;

    //响应消息
    private String retInfo;

    public String getTradeFlowId() {
        return tradeFlowId;
    }

    public void setTradeFlowId(String tradeFlowId) {
        this.tradeFlowId = tradeFlowId;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }
}
