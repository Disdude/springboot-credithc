package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 快捷支付验证码发送 jsonResult
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQuickPayCodeRes extends BaseObject {

    //订单号 交易流水号（唯一）
    private String bizId;

    //渠道标示
    private String channel;

    //充值订单号
    private String orderNo;

    //验证码 （不为空，需要业务系统发送该验证码；为空则不必发送）
    private String checkCode;

    //第三方返回信息
    private String thirdRetInfo;

    //第三方返回码
    private String thirdRetCode;

    //系统来源ID
    private String systemSourceId;

    //备注 (非必填)
    private String remark;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getThirdRetInfo() {
        return thirdRetInfo;
    }

    public void setThirdRetInfo(String thirdRetInfo) {
        this.thirdRetInfo = thirdRetInfo;
    }

    public String getThirdRetCode() {
        return thirdRetCode;
    }

    public void setThirdRetCode(String thirdRetCode) {
        this.thirdRetCode = thirdRetCode;
    }

    public String getSystemSourceId() {
        return systemSourceId;
    }

    public void setSystemSourceId(String systemSourceId) {
        this.systemSourceId = systemSourceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
