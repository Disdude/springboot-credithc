package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 正常/提前还款
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrBorrowerRePayLenDetail extends BaseObject {

    //借款协议编号
    private String docNo;

    //出借人客户编号
    private String customerId;

    //回款金额
    private String amount;

    //复投金额
    private String reAmount;

    //可取现金额
    private String takeAmount;

    //冻结编号  出借编号
    private String freezeId;

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReAmount() {
        return reAmount;
    }

    public void setReAmount(String reAmount) {
        this.reAmount = reAmount;
    }

    public String getTakeAmount() {
        return takeAmount;
    }

    public void setTakeAmount(String takeAmount) {
        this.takeAmount = takeAmount;
    }

    public String getFreezeId() {
        return freezeId;
    }

    public void setFreezeId(String freezeId) {
        this.freezeId = freezeId;
    }
}
