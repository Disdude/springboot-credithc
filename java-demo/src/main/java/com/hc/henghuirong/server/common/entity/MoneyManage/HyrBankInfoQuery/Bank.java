package com.hc.henghuirong.server.common.entity.MoneyManage.HyrBankInfoQuery;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/5/2.
 * 银行信息
 */
public class Bank extends BaseObject {

    //银行编码
    private int bankCode;

    //中文名称(URLEncoder UTF-8编码)
    private String caBankname;

    //中文简称(URLEncoder UTF-8编码)
    private String caBankNameBrief;

    //英文名称
    private String enBankName;

    //英文简称
    private String enBankNameBreif;

    //是否支持鉴权(0:否,1:是)
    private int isAuthSupport;

    //是否支持快捷(0:否,1:是)
    private int isEtcPay;

    //快捷日限额(单位:元, 无限额:-1)
    private int etcPayDailyLimit;

    //快捷单笔限额(单位:元, 无限额:-1)
    private int etcPaySingleLimit;

    //快捷日限次(无限次:-1)
    private int etcPayDailyLimitTimes;

    //是否支持提现（提现卡） 0：否 1：是
    private int isCash;

    //提现单日限额 (单位:元, 无限额:-1)
    private int drawPayDailyLimit;

    //提现单日单笔限额 (单位:元, 无限额:-1)
    private int drawPaySingleLimit;

    //提现单日限制次数(单位:元, 无限额:-1)
    private int drawPayDailyLimitTimes;

    //是否支持单笔代收 0：否 1：是
    private int isSingleReceipt;

    //单笔代收日限额 (单位:元, 无限额:-1)
    private int singleReceiptDailyLimit;

    //单笔代收单笔限额 (单位:元, 无限额:-1)
    private int singleReceiptSingleLimit;

    //单笔代收日限次(无限次:-1)
    private int singleReceiptDailyLimitTimes;

    //是否支持网关(0:否,1:是)
    private int isGatewayPay;

    //支付url跳转
    private String payUrl;

    //网关限额List
    private List<GateWayPay> gatewayPayList;

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getCaBankname() {
        return caBankname;
    }

    public void setCaBankname(String caBankname) {
        this.caBankname = caBankname;
    }

    public String getCaBankNameBrief() {
        return caBankNameBrief;
    }

    public void setCaBankNameBrief(String caBankNameBrief) {
        this.caBankNameBrief = caBankNameBrief;
    }

    public String getEnBankName() {
        return enBankName;
    }

    public void setEnBankName(String enBankName) {
        this.enBankName = enBankName;
    }

    public String getEnBankNameBreif() {
        return enBankNameBreif;
    }

    public void setEnBankNameBreif(String enBankNameBreif) {
        this.enBankNameBreif = enBankNameBreif;
    }

    public int getIsAuthSupport() {
        return isAuthSupport;
    }

    public void setIsAuthSupport(int isAuthSupport) {
        this.isAuthSupport = isAuthSupport;
    }

    public int getIsEtcPay() {
        return isEtcPay;
    }

    public void setIsEtcPay(int isEtcPay) {
        this.isEtcPay = isEtcPay;
    }

    public int getEtcPayDailyLimit() {
        return etcPayDailyLimit;
    }

    public void setEtcPayDailyLimit(int etcPayDailyLimit) {
        this.etcPayDailyLimit = etcPayDailyLimit;
    }

    public int getEtcPaySingleLimit() {
        return etcPaySingleLimit;
    }

    public void setEtcPaySingleLimit(int etcPaySingleLimit) {
        this.etcPaySingleLimit = etcPaySingleLimit;
    }

    public int getEtcPayDailyLimitTimes() {
        return etcPayDailyLimitTimes;
    }

    public void setEtcPayDailyLimitTimes(int etcPayDailyLimitTimes) {
        this.etcPayDailyLimitTimes = etcPayDailyLimitTimes;
    }

    public int getIsCash() {
        return isCash;
    }

    public void setIsCash(int isCash) {
        this.isCash = isCash;
    }

    public int getDrawPayDailyLimit() {
        return drawPayDailyLimit;
    }

    public void setDrawPayDailyLimit(int drawPayDailyLimit) {
        this.drawPayDailyLimit = drawPayDailyLimit;
    }

    public int getDrawPaySingleLimit() {
        return drawPaySingleLimit;
    }

    public void setDrawPaySingleLimit(int drawPaySingleLimit) {
        this.drawPaySingleLimit = drawPaySingleLimit;
    }

    public int getDrawPayDailyLimitTimes() {
        return drawPayDailyLimitTimes;
    }

    public void setDrawPayDailyLimitTimes(int drawPayDailyLimitTimes) {
        this.drawPayDailyLimitTimes = drawPayDailyLimitTimes;
    }

    public int getIsSingleReceipt() {
        return isSingleReceipt;
    }

    public void setIsSingleReceipt(int isSingleReceipt) {
        this.isSingleReceipt = isSingleReceipt;
    }

    public int getSingleReceiptDailyLimit() {
        return singleReceiptDailyLimit;
    }

    public void setSingleReceiptDailyLimit(int singleReceiptDailyLimit) {
        this.singleReceiptDailyLimit = singleReceiptDailyLimit;
    }

    public int getSingleReceiptSingleLimit() {
        return singleReceiptSingleLimit;
    }

    public void setSingleReceiptSingleLimit(int singleReceiptSingleLimit) {
        this.singleReceiptSingleLimit = singleReceiptSingleLimit;
    }

    public int getSingleReceiptDailyLimitTimes() {
        return singleReceiptDailyLimitTimes;
    }

    public void setSingleReceiptDailyLimitTimes(int singleReceiptDailyLimitTimes) {
        this.singleReceiptDailyLimitTimes = singleReceiptDailyLimitTimes;
    }

    public int getIsGatewayPay() {
        return isGatewayPay;
    }

    public void setIsGatewayPay(int isGatewayPay) {
        this.isGatewayPay = isGatewayPay;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public List<GateWayPay> getGatewayPayList() {
        return gatewayPayList;
    }

    public void setGatewayPayList(List<GateWayPay> gatewayPayList) {
        this.gatewayPayList = gatewayPayList;
    }
}
