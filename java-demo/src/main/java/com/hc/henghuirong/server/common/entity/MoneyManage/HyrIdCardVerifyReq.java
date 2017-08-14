package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * 实名认证
 * Created by wenzhiwei on 17-5-2.
 */
public class HyrIdCardVerifyReq extends BaseObject {

    //姓名
    private String name;

    //身份证号 支持18/15位身份证号
    private String idCardNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
}
