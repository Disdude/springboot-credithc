package com.hc.henghuirong.server.controller.inner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 前端静态、js处理相关
 * Created by wenzhiwei on 17-3-15.
 */
@ApiIgnore
@Controller
@RequestMapping("inner/fe")
public class FeController {

    private static final Logger logger = LoggerFactory.getLogger(FeController.class);

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "index";
    }

}
