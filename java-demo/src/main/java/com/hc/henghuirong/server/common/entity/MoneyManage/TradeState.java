package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class TradeState extends BaseObject {

    //交易流水号/批次号
    private String bizId;

    //状态（0：成功，1：失败，2：无数据，3：处理中）
    private String state;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
