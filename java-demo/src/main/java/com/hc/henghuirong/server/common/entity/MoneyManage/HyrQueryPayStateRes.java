package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 订单支付状态
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrQueryPayStateRes extends BaseObject {

    private String payBizId;

    //订单支付状态 0000：成功、2002：处理中、3000失败 3090 未支付
    private String orderRetCode;

    //订单状态信息
    private String orderRetInfo;

    //订单完成时间 yyyyMMddHHmmss
    private String finishTime;

    public String getPayBizId() {
        return payBizId;
    }

    public void setPayBizId(String payBizId) {
        this.payBizId = payBizId;
    }

    public String getOrderRetCode() {
        return orderRetCode;
    }

    public void setOrderRetCode(String orderRetCode) {
        this.orderRetCode = orderRetCode;
    }

    public String getOrderRetInfo() {
        return orderRetInfo;
    }

    public void setOrderRetInfo(String orderRetInfo) {
        this.orderRetInfo = orderRetInfo;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
