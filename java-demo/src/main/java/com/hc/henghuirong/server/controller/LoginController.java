package com.hc.henghuirong.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by wenzhiwei on 17-3-16.
 */
@ApiIgnore
@Controller
@RequestMapping("login")
public class LoginController {


    @RequestMapping("")
    public String login() {
        return "login";
    }




}
