package com.hc.henghuirong.server.common.entity.MoneyManage;

import java.util.List;

/**
 * 散标放款
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrBorrowLoanReq {

    //订单号 交易流水号（唯一）
    private String bizId;

    //借款编号
    private String borrowId;

    //借款人客户编号
    private String customerId;

    //借款金额 借款合同金额
    private String amount;

    //借款日期  格式：yyyyMMdd
    private String borrowDate;

    //借款到期日 格式：yyyyMMdd
    private String borrowExpireDate;

    //还款日 格式：dd
    private String repaymentDate;

    //还款期数 两位数字
    private String repayPeriod;

    //借款利率 小数
    private String lendRate;

    //保险费 金额 没有传0
    private String safeAmt;

    //服务费 金额 没有传0
    private String serviceAmt;

    //detail
    private List<HyrBorrowLoanDetail> detail;

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

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBorrowExpireDate() {
        return borrowExpireDate;
    }

    public void setBorrowExpireDate(String borrowExpireDate) {
        this.borrowExpireDate = borrowExpireDate;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getRepayPeriod() {
        return repayPeriod;
    }

    public void setRepayPeriod(String repayPeriod) {
        this.repayPeriod = repayPeriod;
    }

    public String getLendRate() {
        return lendRate;
    }

    public void setLendRate(String lendRate) {
        this.lendRate = lendRate;
    }

    public String getSafeAmt() {
        return safeAmt;
    }

    public void setSafeAmt(String safeAmt) {
        this.safeAmt = safeAmt;
    }

    public String getServiceAmt() {
        return serviceAmt;
    }

    public void setServiceAmt(String serviceAmt) {
        this.serviceAmt = serviceAmt;
    }

    public List<HyrBorrowLoanDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<HyrBorrowLoanDetail> detail) {
        this.detail = detail;
    }
}
