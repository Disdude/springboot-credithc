package com.hc.henghuirong.server.controller.admin;

import com.hc.henghuirong.server.common.model.auth.IpPathControl;
import com.hc.henghuirong.server.service.auth.IpPathCtrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dell-3020 on 2017/3/24.
 */
@Controller
@RequestMapping("ip")
public class IpPathController {
    @Autowired
    private IpPathCtrService ipPathCtrService;


    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", ipPathCtrService.getAllIpPathControl());
        return "ippath/list";
    }
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public String create(IpPathControl ipPathControl){
        ipPathCtrService.create(ipPathControl);
        return "redirect:/ip";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") Integer id, IpPathControl ipPathControl) {
        ipPathControl.setId(id);
        ipPathCtrService.modify(ipPathControl);
        return "redirect:/ip";
    }

    @RequestMapping(value = "/{id}/status",method = RequestMethod.PUT)
    @ResponseBody
    public void switchPathStatus(@PathVariable("id") Integer id, @RequestParam(value = "status",required = false) boolean status,@RequestParam(value = "name",required = false) String name){
        if("pathEnabled".equals(name)){
            ipPathCtrService.switchPathStatus(id,status);
        }
        if("qpmEnabled".equals(name)){
            ipPathCtrService.switchQpmStatus(id,status);
        }
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id")Integer id){
        ipPathCtrService.deleteById(id);
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String toform(@RequestParam(name = "id",required = false)Integer id, Model model){
        String api="/ip/add";
        if(id!=null){
            model.addAttribute("ipPathControl",ipPathCtrService.getIpPathControlById(id));
            api="/ip/"+id+"/modify";
        }
        model.addAttribute("api",api);
        return "ippath/form";
    }


}
