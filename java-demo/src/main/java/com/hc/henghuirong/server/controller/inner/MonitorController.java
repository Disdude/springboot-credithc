package com.hc.henghuirong.server.controller.inner;

import com.alibaba.fastjson.JSONObject;
import com.hc.henghuirong.server.common.model.Result;
import com.hc.henghuirong.server.controller.base.RestApi;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.InnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 监控类
 * Created by wenzhiwei on 17-3-15.
 */
@ApiIgnore
@RestController
@RequestMapping("inner")
public class MonitorController {

    private static final Logger logger = LoggerFactory.getLogger(MonitorController.class);

    @Autowired
    private InnerService innerService;

    public Result<JSONObject> healthCheck() {
        return new RestApi<JSONObject>() {
            @Override
            public JSONObject process() throws BizException {

                //TODO heathCheck
                return null;
            }
        }.execute();
    }


}
