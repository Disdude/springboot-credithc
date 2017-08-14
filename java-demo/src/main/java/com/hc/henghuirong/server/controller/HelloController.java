package com.hc.henghuirong.server.controller;

import com.hc.henghuirong.server.annotation.ApiVersion;
import com.hc.henghuirong.server.common.enums.ErrorCode;
import com.hc.henghuirong.server.common.model.Result;
import com.hc.henghuirong.server.controller.base.RestApi;
import com.hc.henghuirong.server.exceptions.BizException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by wenzhiwei on 17-3-14.
 */
@RestController
@RequestMapping("hello")
@Api(value = "测试demo", description = "测试", tags = "测试")
public class HelloController {


    @Autowired
    private JedisPool jedisPool;

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    @Qualifier("requestMappingHandlerMapping")
    RequestMappingHandlerMapping handlerMapping;


    @RequestMapping(value = "index", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "helloword", httpMethod = "GET")
    @ApiVersion(12)
    public String index() {
        jedisPool.getResource();
        return "hello";
    }

    @RequestMapping(value = "path", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取所有映射路径", httpMethod = "GET")
    @ApiVersion({11, 13})
    public List index12(HttpServletRequest request) {
        List list = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        Set<Map.Entry<RequestMappingInfo, HandlerMethod>> entries = handlerMethods.entrySet();
        Iterator<Map.Entry<RequestMappingInfo, HandlerMethod>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<RequestMappingInfo, HandlerMethod> next = iterator.next();
            RequestMappingInfo key = next.getKey();
            Set<String> patterns = key.getPatternsCondition().getPatterns();
            Iterator<String> iterator1 = patterns.iterator();
            while (iterator1.hasNext()) {
                String next1 = iterator1.next();
                list.add(next1);
            }
        }
        return list;
    }

    @RequestMapping(value = "getOBj", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取对象", httpMethod = "GET")
    public Result<String> getObj() {
        return new RestApi<String>() {
            @Override
            public String process() throws BizException {
                return null;
            }
        }.execute();
    }

    @RequestMapping(value = "getOBjWithException", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取对象异常", httpMethod = "GET")
    public Result<String> getObjWithException() {
        return new RestApi<String>() {
            @Override
            public String process() throws BizException {
                throw new BizException(ErrorCode.ERROR);
            }
        }.execute();
    }


}
