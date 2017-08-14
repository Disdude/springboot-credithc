package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 风险金代偿
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrRiskFundPayDetail extends BaseObject {

    //交易订单号 唯一
    private String bizId;

    //补偿的客户编号  出借人客户编号
    private String lenCustomerId;

    //借款人客户编号
    private String borCustomerId;

    //补偿金额   补偿金额 = 复投+可取现+服务费
    private String amount;

    //出借冻结编号  出借编号
    private String lenFreezeId;

    //借款冻结编号  借款编号
    private String borFreezeId;

    //出借复投金额
    private String reAmount;

    //出借可取现金额
    private String takeAmount;

    //补偿的合同编号  借款协议编号
    private String docNo;

    //操作标识 0-风险金补偿
    private String operFlag;

    //服务费
    private String serviceAmt;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getLenCustomerId() {
        return lenCustomerId;
    }

    public void setLenCustomerId(String lenCustomerId) {
        this.lenCustomerId = lenCustomerId;
    }

    public String getBorCustomerId() {
        return borCustomerId;
    }

    public void setBorCustomerId(String borCustomerId) {
        this.borCustomerId = borCustomerId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getLenFreezeId() {
        return lenFreezeId;
    }

    public void setLenFreezeId(String lenFreezeId) {
        this.lenFreezeId = lenFreezeId;
    }

    public String getBorFreezeId() {
        return borFreezeId;
    }

    public void setBorFreezeId(String borFreezeId) {
        this.borFreezeId = borFreezeId;
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

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getOperFlag() {
        return operFlag;
    }

    public void setOperFlag(String operFlag) {
        this.operFlag = operFlag;
    }

    public String getServiceAmt() {
        return serviceAmt;
    }

    public void setServiceAmt(String serviceAmt) {
        this.serviceAmt = serviceAmt;
    }
}
