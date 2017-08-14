package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 批量提现
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HryBatchWithdrawReq extends BaseObject {

    //批次号
    private String batchNo;

    //批量冻结明细
    private List<HryBatchWithdrawDetail> detail;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public List<HryBatchWithdrawDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<HryBatchWithdrawDetail> detail) {
        this.detail = detail;
    }
}
