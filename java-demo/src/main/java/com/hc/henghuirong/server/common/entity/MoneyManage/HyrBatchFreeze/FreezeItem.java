package com.hc.henghuirong.server.common.entity.MoneyManage.HyrBatchFreeze;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 解冻明细条目
 */
public class FreezeItem extends BaseObject {

    //流水号
    private String flowId;
    //客户编号
    private String customerId;
    //冻结编号
    private String freezeId;
    //解冻金额 金额格式为###.00
    private String money;
    //备注
    private String remark;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFreezeId() {
        return freezeId;
    }

    public void setFreezeId(String freezeId) {
        this.freezeId = freezeId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
