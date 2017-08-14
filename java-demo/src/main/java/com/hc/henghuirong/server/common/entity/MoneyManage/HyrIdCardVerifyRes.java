package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 实名认证
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrIdCardVerifyRes extends BaseObject {

    //认证结果
    private String compResult;

    //实名认证状态 一致
    private String compStatus;

    public String getCompResult() {
        return compResult;
    }

    public void setCompResult(String compResult) {
        this.compResult = compResult;
    }

    public String getCompStatus() {
        return compStatus;
    }

    public void setCompStatus(String compStatus) {
        this.compStatus = compStatus;
    }
}
