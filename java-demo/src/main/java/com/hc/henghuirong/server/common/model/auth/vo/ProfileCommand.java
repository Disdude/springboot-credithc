package com.hc.henghuirong.server.common.model.auth.vo;


import com.hc.henghuirong.server.common.model.BaseObject;

/**
 * @author Jonsy
 */
public class ProfileCommand extends BaseObject {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
