package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 批量补偿退还
 */
public class HyrUnCompensateReq extends BaseObject {

    //补偿业务编号
    private String bizId;

    //补偿时间
    private String cashbackTime;

    private List<UnCompensateItem> detailList;

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

    public List<UnCompensateItem> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<UnCompensateItem> detailList) {
        this.detailList = detailList;
    }
}
