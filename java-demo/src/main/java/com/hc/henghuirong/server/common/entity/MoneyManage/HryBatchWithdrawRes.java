package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 批量提现   jsonResult
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HryBatchWithdrawRes extends BaseObject {

    //订单号
    private String bizId;

    //响应码
    private String retCode;

    //响应信息
    private String retInfo;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
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
