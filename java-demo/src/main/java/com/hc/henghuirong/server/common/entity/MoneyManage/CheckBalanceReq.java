package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 查询调账流水
 */
public class CheckBalanceReq extends BaseObject {

    //业务系统
    /**
     * 账务中心 ACCOUNTING         资产中心 ASSET                核心前置 CAPITAL
     * 纳斯达克 NASDAQ               客户中心 CUSTOMER             交易中心 TRADE
     * 掌上钱庄 PALMPB               恒昌白条 BAITIAO              恒易融   HENGYIRONG
     * 多乐融   QIMING               曙光     HENGCHANG           微服     WEIFU
     */
    private String bizSystem;

    //客户编号
    private String customerId;

    //本手方子账户编号
    private String bizId;

    //本手方子账户类型
    /**
     * 现金账户 0                    红包账户 1 　                 资产账户 2
     * 借款账户 3                    信用账户 4                    银行账户 5
     * 第三方托管账户 6               基金账户 7 　                 冻结账户 8
     */
    private String subType;

    //对手方客户编号
    private String rivalCustomerId;

    //对手方子账户编号
    private String rivalBizId;

    //对手方子账户类型 同subType
    private String rivalSubType;

    //业务系统订单号
    private String tradeFlowId;

    //创建开始时间 账务系统生成该记录的时间
    //格式：yyyy-MM-dd HH:mm:ss
    private String createStartTime;

    //创建结束时间
    private String createEndTime;

    //交易开始时间 支付结算系统交易时间
    //格式：yyyy-MM-dd HH:mm:ss
    private String tradeStartTime;

    //交易结束时间
    private String tradeEndTime;

    public String getBizSystem() {
        return bizSystem;
    }

    public void setBizSystem(String bizSystem) {
        this.bizSystem = bizSystem;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getRivalCustomerId() {
        return rivalCustomerId;
    }

    public void setRivalCustomerId(String rivalCustomerId) {
        this.rivalCustomerId = rivalCustomerId;
    }

    public String getRivalBizId() {
        return rivalBizId;
    }

    public void setRivalBizId(String rivalBizId) {
        this.rivalBizId = rivalBizId;
    }

    public String getRivalSubType() {
        return rivalSubType;
    }

    public void setRivalSubType(String rivalSubType) {
        this.rivalSubType = rivalSubType;
    }

    public String getTradeFlowId() {
        return tradeFlowId;
    }

    public void setTradeFlowId(String tradeFlowId) {
        this.tradeFlowId = tradeFlowId;
    }

    public String getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(String createStartTime) {
        this.createStartTime = createStartTime;
    }

    public String getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(String createEndTime) {
        this.createEndTime = createEndTime;
    }

    public String getTradeStartTime() {
        return tradeStartTime;
    }

    public void setTradeStartTime(String tradeStartTime) {
        this.tradeStartTime = tradeStartTime;
    }

    public String getTradeEndTime() {
        return tradeEndTime;
    }

    public void setTradeEndTime(String tradeEndTime) {
        this.tradeEndTime = tradeEndTime;
    }
}
