package com.hc.henghuirong.server.controller;

import com.hc.henghuirong.server.annotation.VerySign;
import com.hc.henghuirong.server.common.model.Result;
import com.hc.henghuirong.server.common.model.req.TestReq;
import com.hc.henghuirong.server.common.util.SignUtils;
import com.hc.henghuirong.server.config.Md5Properties;
import com.hc.henghuirong.server.controller.base.RestApi;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.auth.ThirdPartyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell-3020 on 2017/3/23.
 */

@RestController
@RequestMapping("check")
@Api(value = "验签", description = "对外服务", tags = "签名服务")
public class CheckSignController {
    private static final Logger logger = LoggerFactory.getLogger(SignController.class);

    @Autowired
    Md5Properties propertiesConfig;

    @Autowired
    ThirdPartyService thirdPartyService;


    @RequestMapping("sign")
    @ApiOperation(value = "请求签名", httpMethod = "POST", notes = "签名")
    @VerySign
    public Result<Integer> sign(TestReq testReq) {
        return new RestApi<Integer>() {
            @Override
            public Integer process() throws BizException {
                return 1;
                //return thirdPartyService.updateKeyAndDesc(id, key, desc);
            }
        }.execute();
    }

    public static void main(String[] args)
    {
        Map<String, String> map =new HashMap<>();
        map.put("id","12");
        map.put("state", "normal");
        map.put("amount", "1.43");
        logger.info("sign:{}", SignUtils.getSign(map,"123456ADSEF"));
    }

}
