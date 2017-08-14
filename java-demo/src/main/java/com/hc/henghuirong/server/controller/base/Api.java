package com.hc.henghuirong.server.controller.base;

import com.hc.henghuirong.server.exceptions.BizException;

/**
 * Api 调用模板
 * Created by wenzhiwei on 17-3-15.
 */
public abstract class Api<T> {

    public abstract T process() throws BizException;

}
