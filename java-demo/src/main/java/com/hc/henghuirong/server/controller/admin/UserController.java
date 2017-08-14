package com.hc.henghuirong.server.controller.admin;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.hc.henghuirong.server.common.model.auth.User;
import com.hc.henghuirong.server.common.model.auth.vo.ProfileCommand;
import com.hc.henghuirong.server.common.model.auth.vo.UserCommond;
import com.hc.henghuirong.server.common.util.SecurityUtils;
import com.hc.henghuirong.server.service.auth.MenuService;
import com.hc.henghuirong.server.service.auth.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wenzhiwei
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected MenuService menuService;

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String create(UserCommond user) {

        User addUser = new User();
        BeanUtils.copyProperties(user, addUser);

        userService.create(addUser);
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") String id, UserCommond user) {

        User addUser = new User();
        BeanUtils.copyProperties(user, addUser);
        addUser.setId(id);
        userService.modify(addUser);
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
    @ResponseBody
    public void switchStatus(@PathVariable("id") String id, @RequestParam("disable") boolean disable) {
        userService.switchStatus(id, disable);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(@RequestParam(value = "id", required = false) String id, Model model) {
        String api = "/user/add";
        if (StringUtils.isNotBlank(id)) {
            model.addAttribute("acount", userService.get(id));
            api = "/user/" + id + "/modify";
        }
        model.addAttribute("api", api);
        return "user/form";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", userService.list());
        return "user/list";
    }

    @RequestMapping(value = "/{id}/grant-role", method = RequestMethod.POST)
    public String grantRole(@PathVariable("id") String id, String[] rid) {
        if (rid == null) {
            rid = new String[0];
        }
        userService.grantRole(id, Lists.newArrayList(rid));
        return "redirect:/user";
    }


    @RequestMapping(value = "/{id}/select-role", method = RequestMethod.GET)
    public String selectRole(@PathVariable("id") String id, Model model) {
        model.addAttribute("list", userService.selectRoles(id));
        model.addAttribute("api", "/user/" + id + "/grant-role");
        return "user/grant-role";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String myinfo() {
        return "user/profile";
    }

    @RequestMapping(value = "/modify-profile", method = RequestMethod.POST)
    public String modifyProfile(ProfileCommand myInfo) {
        User uUser = new User();
        BeanUtils.copyProperties(myInfo, uUser);
        uUser.setId(SecurityUtils.getUid());
        this.userService.modify(uUser);
        SecurityUtils.getUser().setEmail(myInfo.getEmail());
        return "user/profile";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.setAttribute("SPRING_SECURITY_LAST_EXCEPTION", "true");

        Cookie ck = new Cookie("remember-me", "");
        ck.setPath("/");// 路径一定要正确，否则可能会删错对象
        ck.setMaxAge(0);
        response.addCookie(ck);

        Cookie sc = new Cookie("SESSION", "");
        sc.setPath("/");// 路径一定要正确，否则可能会删错对象
        sc.setMaxAge(0);
        response.addCookie(sc);

        return "login";
    }

    @RequestMapping(value = "/selectusername", method = RequestMethod.GET)
    @ResponseBody
    public String selectusername(String username) throws IOException {
        logger.debug("username:{}", username);
        boolean result = false;
        List<User> listuser = userService.getUserByUname(username);
        if (listuser.size() < 1) {
            result = true;
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    @RequestMapping(value = "/selectuseremail", method = RequestMethod.GET)
    @ResponseBody
    public String selectuseremail(String email) throws IOException {
        logger.debug("email:{}", email);
        boolean result = false;
        List<User> listuser = userService.getUserByEmail(email);
        if (listuser.size() < 1) {
            result = true;
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }


}
