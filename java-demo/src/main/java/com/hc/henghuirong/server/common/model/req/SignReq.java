package com.hc.henghuirong.server.common.model.req;

import com.hc.henghuirong.server.common.model.BaseObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenzhiwei on 17-3-16.
 */
@ApiModel("请求对象")
public abstract class SignReq extends BaseObject {
    @ApiModelProperty(value = "请求参数签名",notes = "所有参数签名")
    private String sign;

    private String requestTime;

    private String thirdId;

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }
}
