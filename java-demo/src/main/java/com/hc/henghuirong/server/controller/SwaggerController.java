package com.hc.henghuirong.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by wenzhiwei on 17-3-21.
 */
@ApiIgnore
@Controller
@RequestMapping("swagger")
public class SwaggerController {


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "redirect:/swagger-ui.html";
    }

}
