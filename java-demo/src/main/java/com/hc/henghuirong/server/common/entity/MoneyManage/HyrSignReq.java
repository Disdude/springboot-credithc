package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 单笔代收签约
 */
public class HyrSignReq extends BaseObject{

    //唯一订单号
    private String bizId;

    //签约协议号
    private String docNo;

    //客户编号
    private String customerId;

    //客户姓名
    private String name;

    //银行编码
    private String bankId;

    //银行卡号
    private String bankCardNo;

    //协议到期日格式
    private String docEndDate;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getDocEndDate() {
        return docEndDate;
    }

    public void setDocEndDate(String docEndDate) {
        this.docEndDate = docEndDate;
    }
}
