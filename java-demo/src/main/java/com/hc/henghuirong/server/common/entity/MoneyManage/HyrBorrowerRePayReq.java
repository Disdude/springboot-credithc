package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 正常/提前还款
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrBorrowerRePayReq extends BaseObject {

    //批次订单号
    private String bizId;

    //detail
    private List<HyrBorrowerRePayDetail> detail;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public List<HyrBorrowerRePayDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<HyrBorrowerRePayDetail> detail) {
        this.detail = detail;
    }
}
