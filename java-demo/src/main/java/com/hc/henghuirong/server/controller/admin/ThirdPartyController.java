package com.hc.henghuirong.server.controller.admin;

import com.hc.henghuirong.server.common.model.auth.ThirdParty;
import com.hc.henghuirong.server.service.auth.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hu.cong.cong on 2017/3/30.
 */
@Controller
@RequestMapping("third")
public class ThirdPartyController {

    @Autowired
    private ThirdPartyService thirdPartyService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", thirdPartyService.getList());
        return "thirdparty/list";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public String create(ThirdParty thirdParty){
        thirdPartyService.insertThirdParty(thirdParty);
        return "redirect:/third";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") Integer id, ThirdParty thirdParty) {
        thirdPartyService.updateKeyAndDesc(thirdParty.getId(),thirdParty.getSecretKey(),thirdParty.getDesc());
        return "redirect:/third";
    }

    @RequestMapping(value = "/{id}/status",method = RequestMethod.PUT)
    @ResponseBody
    public void switchPathStatus(@PathVariable("id") Integer id, @RequestParam(value = "status",required = false) Integer status){
            thirdPartyService.updateStatus(id,status);
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id")Integer id){
        thirdPartyService.updateStatus(id,2);
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String toform(@RequestParam(name = "id",required = false)Integer id, Model model){
        String api="/third/add";
        if(id!=null){
            model.addAttribute("ThirdParty",thirdPartyService.getById(id));
            api="/third/"+id+"/modify";
        }
        model.addAttribute("api",api);

        return "thirdparty/form";
    }

}
