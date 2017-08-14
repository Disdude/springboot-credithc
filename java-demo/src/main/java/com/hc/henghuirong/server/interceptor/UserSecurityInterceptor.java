package com.hc.henghuirong.server.interceptor;


import com.hc.henghuirong.server.common.util.RequestUtils;
import com.hc.henghuirong.server.service.auth.IpPathCtrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by wu.kang on 2017/3/16.
 */
public class UserSecurityInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterCeptor.class);

    @Autowired
    private IpPathCtrService ipPathCtrService;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String path = RequestUtils.getRequestPath(request);
        String addr = RequestUtils.getIp2(request);
        boolean pass = ipPathCtrService.pass(addr, path, 500);
        if(!pass){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().write("<center>没有权限，请联系管理员!</center>");
        }

        logger.info("acccsstrol:{}|{}|{}",addr,path,pass?"release":"forbidden");

        return pass;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }



}
