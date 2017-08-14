package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class BalanceDetail extends BaseObject {

    //交易前金额
    private String beginAmount;

    //交易后金额
    private String endAmount;

    //本手方子账户类型
    private String subType;

    //本手方子账户编号
    private String bizId;

    //客户编号
    private String customerId;

    //客户姓名
    private String userName;

    //交易金额
    private String amount;

    //账务方向
    private String accountDir;

    //对手方交易前金额
    private String rivalBeginAmount;

    //对手方交易后金额
    private String rivalEndAmount;

    //对手方子账户类型
    private String rivalSubType;

    //对手方子账户编号=
    private String rivalBizId;

    //对手方客户编号
    private String rivalCustomerId;

    //对手方客户姓名
    private String rivalUserName;

    //业务系统订单号
    private String tradeFlowId;

    //创建时间
    private String createTime;

    //交易时间
    private String tradeTime;

    //备注
    private String remark;

    public String getBeginAmount() {
        return beginAmount;
    }

    public void setBeginAmount(String beginAmount) {
        this.beginAmount = beginAmount;
    }

    public String getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(String endAmount) {
        this.endAmount = endAmount;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountDir() {
        return accountDir;
    }

    public void setAccountDir(String accountDir) {
        this.accountDir = accountDir;
    }

    public String getRivalBeginAmount() {
        return rivalBeginAmount;
    }

    public void setRivalBeginAmount(String rivalBeginAmount) {
        this.rivalBeginAmount = rivalBeginAmount;
    }

    public String getRivalEndAmount() {
        return rivalEndAmount;
    }

    public void setRivalEndAmount(String rivalEndAmount) {
        this.rivalEndAmount = rivalEndAmount;
    }

    public String getRivalSubType() {
        return rivalSubType;
    }

    public void setRivalSubType(String rivalSubType) {
        this.rivalSubType = rivalSubType;
    }

    public String getRivalBizId() {
        return rivalBizId;
    }

    public void setRivalBizId(String rivalBizId) {
        this.rivalBizId = rivalBizId;
    }

    public String getRivalCustomerId() {
        return rivalCustomerId;
    }

    public void setRivalCustomerId(String rivalCustomerId) {
        this.rivalCustomerId = rivalCustomerId;
    }

    public String getRivalUserName() {
        return rivalUserName;
    }

    public void setRivalUserName(String rivalUserName) {
        this.rivalUserName = rivalUserName;
    }

    public String getTradeFlowId() {
        return tradeFlowId;
    }

    public void setTradeFlowId(String tradeFlowId) {
        this.tradeFlowId = tradeFlowId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
