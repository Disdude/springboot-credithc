package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 散标放款
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrBorrowLoanDetail extends BaseObject {

    //出借人客户编号
    private String customerId;

    //现金出借金额
    private String amount;

    //红包出借金额 默认值：0
    private String bonusAmt;

    //红包编号
    private String bonusNo;

    //借款协议编号
    private String docNo;

    //冻结编号 出借编号
    private String freezeId;

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
}
