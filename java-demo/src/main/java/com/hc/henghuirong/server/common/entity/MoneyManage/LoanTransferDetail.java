package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.Base64;

/**
 * 受让详情
 * Created by wenzhiwei on 17-5-2.
 */
public class LoanTransferDetail extends BaseObject {

    //受让人客户编号
    private String customerId;

    //受让金额
    private String amount;

    //红包出让金额
    private String bonusAmt;

    //红包编号
    private String bonusNo;

    //转让合同编号
    private String docNo;

    //冻结编号
    private String freezeId;

    //合同生效时间
    private String transferTime;

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

    public String getBonusAmt() {
        return bonusAmt;
    }

    public void setBonusAmt(String bonusAmt) {
        this.bonusAmt = bonusAmt;
    }

    public String getBonusNo() {
        return bonusNo;
    }

    public void setBonusNo(String bonusNo) {
        this.bonusNo = bonusNo;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getFreezeId() {
        return freezeId;
    }

    public void setFreezeId(String freezeId) {
        this.freezeId = freezeId;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }
}
