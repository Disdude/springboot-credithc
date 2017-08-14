package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 批量提现
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HryBatchWithdrawDetail extends BaseObject {

    //订单号 交易流水号（唯一）
    private String bizId;

    //客户编号
    private String customerId;

    //总额  包含手续费金额
    private String amount;

    //提现手续费  手续费（多乐融必填），手续费会从取现总额中扣除
    private String poundageAmt;

    //交易密码
    private String tradePassword;

    //银行编码
    private String bankId;

    //银行卡号
    private String bankCardNo;

    //客户姓名
    private String name;

    //账户属性  账户属性：0私人，1公司
    private String accountProp;

    //公司主体  公司主体：HCLT：恒昌利通；HSZY：恒盛致远；DLJR：多乐金融；
    private String companyMainBody;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPoundageAmt() {
        return poundageAmt;
    }

    public void setPoundageAmt(String poundageAmt) {
        this.poundageAmt = poundageAmt;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountProp() {
        return accountProp;
    }

    public void setAccountProp(String accountProp) {
        this.accountProp = accountProp;
    }

    public String getCompanyMainBody() {
        return companyMainBody;
    }

    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody;
    }
}
