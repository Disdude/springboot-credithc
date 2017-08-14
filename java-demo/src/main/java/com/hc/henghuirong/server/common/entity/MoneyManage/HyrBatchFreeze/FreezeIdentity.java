package com.hc.henghuirong.server.common.entity.MoneyManage.HyrBatchFreeze;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class FreezeIdentity extends BaseObject {

    //客户编号
    private String customerId;

    //冻结编号
    private String freezeId;

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
}
