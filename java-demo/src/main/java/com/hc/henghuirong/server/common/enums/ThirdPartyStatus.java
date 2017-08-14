package com.hc.henghuirong.server.common.enums;

import com.hc.henghuirong.server.common.model.auth.ThirdParty;

/**
 * Created by wenzhiwei on 17-3-30.
 */
public enum  ThirdPartyStatus {

    DISABLED(-1,"不可用"),
    AVAILABLE(1,"可用"),
    DELETED(2,"已删除");


    private int status;

    private String desc;

    ThirdPartyStatus(int status,String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static ThirdPartyStatus of(int status) {
        for(ThirdPartyStatus s:ThirdPartyStatus.values()) {
            if(s.status==status) {
                return s;
            }
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
