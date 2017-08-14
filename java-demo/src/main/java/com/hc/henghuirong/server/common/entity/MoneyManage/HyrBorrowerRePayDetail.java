package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 正常/提前还款
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrBorrowerRePayDetail extends BaseObject {

    //交易订单号 唯一
    private String bizId;

    //借款编号
    private String borrowId;

    //借款金额
    private String borrowAmount;

    //借款利息
    private String borrowInterest;

    //借款人客户编号
    private String customerId;

    //还款金额
    private String amount;

    //借款人实际退还服务费
    private String borrowerBackServiceAmt;

    //退还服务费
    private String backServiceAmt;

    //收取服务费 实际退还给借款人可提现的金额
    private String takeServiceAmt;

    //补偿金 新增补偿金接口
    private String compensationAmt;

    // 正常/提前还款标识  1:提前还款 0：正常还款  非必填
    private String earlyRepayFlag;

    //交易订单号
    private List<HyrBorrowerRePayLenDetail> lenDetail;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
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

    public String getBorrowerBackServiceAmt() {
        return borrowerBackServiceAmt;
    }

    public void setBorrowerBackServiceAmt(String borrowerBackServiceAmt) {
        this.borrowerBackServiceAmt = borrowerBackServiceAmt;
    }

    public String getBackServiceAmt() {
        return backServiceAmt;
    }

    public void setBackServiceAmt(String backServiceAmt) {
        this.backServiceAmt = backServiceAmt;
    }

    public String getTakeServiceAmt() {
        return takeServiceAmt;
    }

    public void setTakeServiceAmt(String takeServiceAmt) {
        this.takeServiceAmt = takeServiceAmt;
    }

    public String getCompensationAmt() {
        return compensationAmt;
    }

    public void setCompensationAmt(String compensationAmt) {
        this.compensationAmt = compensationAmt;
    }

    public String getEarlyRepayFlag() {
        return earlyRepayFlag;
    }

    public void setEarlyRepayFlag(String earlyRepayFlag) {
        this.earlyRepayFlag = earlyRepayFlag;
    }

    public List<HyrBorrowerRePayLenDetail> getLenDetail() {
        return lenDetail;
    }

    public void setLenDetail(List<HyrBorrowerRePayLenDetail> lenDetail) {
        this.lenDetail = lenDetail;
    }
}
