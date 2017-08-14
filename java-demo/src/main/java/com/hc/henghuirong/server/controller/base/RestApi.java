package com.hc.henghuirong.server.controller.base;

import com.alibaba.fastjson.JSON;
import com.hc.henghuirong.server.common.util.ResultUtils;
import com.hc.henghuirong.server.common.model.Result;
import com.hc.henghuirong.server.exceptions.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wenzhiwei on 17-3-15.
 */
public abstract class RestApi<T> extends Api<T> {

    private static final Logger logger = LoggerFactory.getLogger(RestApi.class);

    public abstract T process() throws BizException;

    public Result<T> execute() {

        try {

            T result = process();

            logger.info("result:{}", JSON.toJSONString(result));
            //业务成功
            return ResultUtils.ok(result);

        } catch (BizException e) {
            //业务异常
            return ResultUtils.failWithMsg(e.getCode());

        } catch (Exception e) {
            //其他异常
            return ResultUtils.fail();
        }
    }

}
