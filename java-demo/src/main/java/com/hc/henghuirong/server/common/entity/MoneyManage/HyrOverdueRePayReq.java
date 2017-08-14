package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 逾期还款
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrOverdueRePayReq extends BaseObject {

    //交易订单号 唯一
    private String bizId;

    //detail
    private List<HyrOverdueRePayDetail> detail;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public List<HyrOverdueRePayDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<HyrOverdueRePayDetail> detail) {
        this.detail = detail;
    }
}
