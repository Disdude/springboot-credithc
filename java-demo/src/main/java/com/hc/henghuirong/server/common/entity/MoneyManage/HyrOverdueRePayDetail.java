package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 逾期还款
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrOverdueRePayDetail extends BaseObject {

    //借款编号  会作为冻结编号使用
    private String borrowId;

    //借款人客户编号
    private String customerId;

    //还款总额
    private String totalAmount;

    //逾期还款本金
    private String borrowAmount;

    //逾期还款利息
    private String borrowInterest;

    //违约金
    private String wyAmount;

    //罚息金
    private String fxAmount;

    //催收服务费
    private String serviceAmt;

    //借款协议编号
    private String docNo;

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(String borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public String getBorrowInterest() {
        return borrowInterest;
    }

    public void setBorrowInterest(String borrowInterest) {
        this.borrowInterest = borrowInterest;
    }

    public String getWyAmount() {
        return wyAmount;
    }

    public void setWyAmount(String wyAmount) {
        this.wyAmount = wyAmount;
    }

    public String getFxAmount() {
        return fxAmount;
    }

    public void setFxAmount(String fxAmount) {
        this.fxAmount = fxAmount;
    }

    public String getServiceAmt() {
        return serviceAmt;
    }

    public void setServiceAmt(String serviceAmt) {
        this.serviceAmt = serviceAmt;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }
}
