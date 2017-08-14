package com.hc.henghuirong.server.controller.admin;

import com.hc.henghuirong.server.service.auth.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author wenzhiwei
 */
@Controller
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    protected SysLogService sysLogService;


    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void clear() {
        sysLogService.clear();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", sysLogService.list());
        return "/syslog/list";
    }


}
