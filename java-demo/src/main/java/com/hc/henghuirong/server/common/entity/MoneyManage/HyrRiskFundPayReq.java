package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 风险金代偿
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrRiskFundPayReq extends BaseObject {

    //批次订单号
    private String bizId;

    //detail
    private List<HyrRiskFundPayDetail> detail;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public List<HyrRiskFundPayDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<HyrRiskFundPayDetail> detail) {
        this.detail = detail;
    }
}
