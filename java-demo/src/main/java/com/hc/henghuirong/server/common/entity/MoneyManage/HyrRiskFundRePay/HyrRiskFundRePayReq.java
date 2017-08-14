package com.hc.henghuirong.server.common.entity.MoneyManage.HyrRiskFundRePay;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class HyrRiskFundRePayReq extends BaseObject {

    //唯一流水号(订单号)
    private String tradeFlowId;

    private List<RiskFundItem> detail;

    public String getTradeFlowId() {
        return tradeFlowId;
    }

    public void setTradeFlowId(String tradeFlowId) {
        this.tradeFlowId = tradeFlowId;
    }

    public List<RiskFundItem> getDetail() {
        return detail;
    }

    public void setDetail(List<RiskFundItem> detail) {
        this.detail = detail;
    }
}
