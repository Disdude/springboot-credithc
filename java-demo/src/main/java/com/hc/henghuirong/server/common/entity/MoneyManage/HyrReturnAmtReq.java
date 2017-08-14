package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 批量返现
 */
public class HyrReturnAmtReq extends BaseObject {

    //返现业务编号
    private String bizId;

    //返现时间
    private String cashbackTime;

    private List detailList;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCashbackTime() {
        return cashbackTime;
    }

    public void setCashbackTime(String cashbackTime) {
        this.cashbackTime = cashbackTime;
    }

    public List getDetailList() {
        return detailList;
    }

    public void setDetailList(List detailList) {
        this.detailList = detailList;
    }
}
