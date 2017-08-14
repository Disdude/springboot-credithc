package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 批量代收
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrBatchReceiptReq extends BaseObject {

    //批次号
    private String bizId;

    private List<BatchReceiptDetail> detail;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public List<BatchReceiptDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<BatchReceiptDetail> detail) {
        this.detail = detail;
    }
}
