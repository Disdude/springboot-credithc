package com.hc.henghuirong.server.common.model.res;

import com.hc.henghuirong.server.common.model.BaseObject;
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
@ApiModel("返回对象")
public class SignRes extends BaseObject {

    @ApiModelProperty("签名")
    private String sign;
    @ApiModelProperty("数据map")
    private Map data;

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
