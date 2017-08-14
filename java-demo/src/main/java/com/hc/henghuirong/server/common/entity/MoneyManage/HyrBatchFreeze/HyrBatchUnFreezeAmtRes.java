package com.hc.henghuirong.server.common.entity.MoneyManage.HyrBatchFreeze;

import com.hc.henghuirong.server.common.entity.MoneyManage.HyrRes;
import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class HyrBatchUnFreezeAmtRes extends BaseObject {

    //批次号
    private String batchNo;
    //结果明细
    private List<HyrRes<FreezeIdentity>> detail;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public List<HyrRes<FreezeIdentity>> getDetail() {
        return detail;
    }

    public void setDetail(List<HyrRes<FreezeIdentity>> detail) {
        this.detail = detail;
    }
}
