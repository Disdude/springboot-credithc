package com.hc.henghuirong.server.common.entity.MoneyManage;

import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * Created by wenzhiwei on 17-4-28.
 */
public class HyrRes<T> extends BaseObject {

    //响应消息
    private String retInfo;

    //响应吗
    private String retCode;

    //返回结果
    private T jsonResult;

    public T getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(T jsonResult) {
        this.jsonResult = jsonResult;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }
}
