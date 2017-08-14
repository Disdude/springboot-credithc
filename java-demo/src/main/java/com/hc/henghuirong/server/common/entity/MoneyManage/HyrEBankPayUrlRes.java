package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 网银支付地址获取 jsonResult
 * Created by hu.cong.cong on 2017/5/2.
 */
public class HyrEBankPayUrlRes extends BaseObject {

    //客户端需要请求的url
    private String url;

    //第三方返回信息
    private String thirdRetInfo;

    //第三方返回码
    private String thirdRetCode;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
