package com.hc.henghuirong.server.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 返回结果
 * Created by wenzhiwei on 17-3-15.
 */
@ApiModel("发挥结果对象")
public class Result<T> extends BaseObject {

    @ApiModelProperty("状态码码")
    private int code;

    @ApiModelProperty("接口状态信息")
    private String message;

    @ApiModelProperty("接口返回数据")
    private T data;

    @ApiModelProperty("服务器返回时间")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
