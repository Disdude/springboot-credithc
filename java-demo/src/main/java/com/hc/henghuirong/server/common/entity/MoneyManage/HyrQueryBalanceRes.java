package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 余额查询
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrQueryBalanceRes extends BaseObject {

    //总金额
    private String acctBal;

    //现金余额
    private String avlBal;

    //冻结金额
    private String frzBal;

    public String getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(String acctBal) {
        this.acctBal = acctBal;
    }

    public String getAvlBal() {
        return avlBal;
    }

    public void setAvlBal(String avlBal) {
        this.avlBal = avlBal;
    }

    public String getFrzBal() {
        return frzBal;
    }

    public void setFrzBal(String frzBal) {
        this.frzBal = frzBal;
    }
}
