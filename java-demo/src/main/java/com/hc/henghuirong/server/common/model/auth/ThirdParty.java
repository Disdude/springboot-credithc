package com.hc.henghuirong.server.common.model.auth;

import com.hc.henghuirong.server.common.model.BaseObject;

import java.util.Date;

/**
 * Created by wenzhiwei on 17-3-30.
 */
public class ThirdParty extends BaseObject{


    private long id;

    private String thirdId;

    private String desc;

    private String secretKey;

    private int status;

    private Date createTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
