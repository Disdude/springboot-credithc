package com.hc.henghuirong.server.common.entity.MoneyManage.HyrBatchFreeze;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 批量解冻/冻结
 */
public class HyrBatchFreezeAmtReq extends BaseObject {

    //批次号
    private String batchNo;

    //批量冻结明细
    private List<FreezeItem> detail;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public List<FreezeItem> getDetail() {
        return detail;
    }

    public void setDetail(List<FreezeItem> detail) {
        this.detail = detail;
    }
}
