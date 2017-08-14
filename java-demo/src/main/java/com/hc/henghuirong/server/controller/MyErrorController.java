package com.hc.henghuirong.server.controller;

import com.hc.henghuirong.server.common.model.Result;
import com.hc.henghuirong.server.controller.base.RestApi;
import com.hc.henghuirong.server.exceptions.BizException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wenzhiwei on 17-3-21.
 */
@RestController
@RequestMapping("error")
@Api("错误提示")
public class MyErrorController {

    @RequestMapping("info")
    @ApiOperation("错误信息")
    public Result myError() {
        return new RestApi<String>() {
            @Override
            public String process() throws BizException {
                return "访问异常，请联系工程师wenzhiwei170313@creditch.com.";
            }
        }.execute();
    }

}
