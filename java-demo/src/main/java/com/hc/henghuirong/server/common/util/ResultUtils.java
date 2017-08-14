package com.hc.henghuirong.server.common.util;

import com.hc.henghuirong.server.common.enums.ErrorCode;
import com.hc.henghuirong.server.common.model.Result;

import java.util.Date;

/**
 * 返回结果处理工具
 * Created by wenzhiwei on 17-3-15.
 */
public class ResultUtils {

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static Result ok(Object data) {

        Result result = new Result();
        result.setCode(ErrorCode.SUCCESS.getCode());
        result.setMessage(ErrorCode.SUCCESS.getMsg());
        result.setData(data);
        result.setDate(new Date());
        return result;

    }

    /**
     * 失败
     *
     * @return
     */
    public static Result fail() {

        Result result = new Result();
        result.setCode(ErrorCode.ERROR.getCode());
        result.setMessage(ErrorCode.ERROR.getMsg());
        result.setData(null);
        result.setDate(new Date());
        return result;

    }

    /**
     * 错误返回
     *
     * @return
     */
    public static Result failWithMsg(ErrorCode errorCode) {

        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getMsg());
        result.setData(null);
        result.setDate(new Date());
        return result;

    }


}
