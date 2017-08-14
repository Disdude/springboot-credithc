package com.hc.henghuirong.server.common.entity.MoneyManage.HyrBatchFreeze;

/**
 * Created by Wu.Kang on 2017/5/2.
 */
public class Balance extends FreezeIdentity {

    //当前余额 现金户余额
    private String balance;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
