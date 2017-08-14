package com.hc.henghuirong.server.controller;

import com.hc.henghuirong.server.common.model.Result;
import com.hc.henghuirong.server.common.model.req.SignReq;
import com.hc.henghuirong.server.common.model.res.SignRes;
import com.hc.henghuirong.server.controller.base.RestApi;
import com.hc.henghuirong.server.exceptions.BizException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sign 签名
 * Created by wenzhiwei on 17-3-16.
 */
@RestController
@RequestMapping("henghr")
@Api(value = "签名", description = "对外服务", tags = "签名服务")
public class SignController {

    private static final Logger logger = LoggerFactory.getLogger(SignController.class);

    @RequestMapping("sign")
    @ApiOperation(value = "php签名", httpMethod = "POST", notes = "签名")
    public Result sign(@RequestBody SignReq req) {
        return new RestApi<SignRes>() {
            @Override
            public SignRes process() throws BizException {

                logger.info("signReq:{}", req);
                return new SignRes();
            }
        }.execute();
    }

}
