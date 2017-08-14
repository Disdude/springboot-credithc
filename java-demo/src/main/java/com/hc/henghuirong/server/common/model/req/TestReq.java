package com.hc.henghuirong.server.common.model.req;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * Created by Wu.Kang on 2017/3/24.
 * 对外接口只支持string类型参数
 */
public class TestReq extends SignReq {


    private String id;
    private String state;
    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setSign(String sign)
    {
        super.setSign(sign);
    }

    public String getSign(String sign)
    {
        return super.getSign();
    }

    public static void main(String[] args) {
        TestReq testReq = new TestReq();
        testReq.setSign("MD%#%d(**!@dFDFREG");
        testReq.setAmount("1000");
        testReq.setId("28");
        testReq.setState("success");
        testReq.setRequestTime(new Date().toString());
        System.out.println(JSON.toJSONString(testReq));
    }
}
