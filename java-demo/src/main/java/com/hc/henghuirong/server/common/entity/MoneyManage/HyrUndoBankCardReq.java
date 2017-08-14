package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 解绑
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrUndoBankCardReq extends BaseObject {

    //客户编号
    private String customerId;

    //银行卡号
    private String bankCardNo;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
}
