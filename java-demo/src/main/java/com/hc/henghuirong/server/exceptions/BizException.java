package com.hc.henghuirong.server.exceptions;

import com.hc.henghuirong.server.common.enums.ErrorCode;

/**
 * Created by wenzhiwei on 17-3-15.
 */
public class BizException extends Exception {

    private static final long serialVersionUID = 274419039161329595L;


    private String message;

    private ErrorCode code;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.message = errorCode.getMsg();
        this.code = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
}
