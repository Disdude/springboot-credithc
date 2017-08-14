package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 订单支付状态查询
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrQueryPayStateReq extends BaseObject {


    //订单号
    private String bizId;

    //支付交易订单号
    private String payBizId;

    //交易类型 0：快捷支付1：网关支付3：单笔代收4：批量代收5：单笔代付6：批量代付
    private String payType;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getPayBizId() {
        return payBizId;
    }

    public void setPayBizId(String payBizId) {
        this.payBizId = payBizId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
