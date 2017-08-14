package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 卡bin查询
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQueryCardInfoRes extends BaseObject {

    //订单号 请求时的订单号
    private String bizId;

    //银行编码 请对照字典
    private String bankId;

    //银行名称
    private String bankName;

    //银行卡类型 0:储蓄卡
    private String cardType;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
