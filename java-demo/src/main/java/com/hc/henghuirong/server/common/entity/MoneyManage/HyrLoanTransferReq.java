package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * 债权转让
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrLoanTransferReq extends BaseObject {

    //交易流水
    private String bizId;


    //投资编号 原出借编号
    private String investId;


    //转让客户编号
    private String customerId;


    //转账金额
    private String amount;

    //原借款合同编号
    private String contractNo;

    //服务费
    private String serviceAmt;

    private List<LoanTransferDetail> detail;

    public List<LoanTransferDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<LoanTransferDetail> detail) {
        this.detail = detail;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getInvestId() {
        return investId;
    }

    public void setInvestId(String investId) {
        this.investId = investId;
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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getServiceAmt() {
        return serviceAmt;
    }

    public void setServiceAmt(String serviceAmt) {
        this.serviceAmt = serviceAmt;
    }
}
