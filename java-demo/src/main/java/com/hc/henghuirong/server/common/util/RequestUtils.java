package com.hc.henghuirong.server.common.util;

import com.alibaba.fastjson.JSON;
import com.hc.henghuirong.server.common.enums.ErrorCode;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.octopus.MqRequestVo;
import com.hc.henghuirong.server.octopus.MqResponseVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wenzhiwei on 17-3-27.
 */
public class RequestUtils {

    private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * 封装octopus 请求对象
     * @param destInterface
     * @param callBackInterface
     * @param identifier
     * @param jsonParam
     * @return
     */
    public static MqRequestVo buildOctopusReq(String destInterface,String callBackInterface,String identifier,String jsonParam) {

        MqRequestVo vo = new MqRequestVo();
        vo.setCallbackInterface(callBackInterface);
        vo.setDestInterface(destInterface);
        vo.setDestSystemSign(identifier);
        vo.setSystemSign(identifier);
        vo.setSignInfo(identifier);
        vo.setJsonParam(jsonParam);
        return vo;
    }

    /**
     * 获取octopus 返回结果
     * @param responseVo
     * @param cl
     * @param <T>
     * @return
     */
    public static <T> T getOctopusResponse(MqResponseVo responseVo,Class<T> cl) {

        if(null==responseVo || !responseVo.getRetCode().equals("0000")) {
            return null;
        }
        try {
            return JSON.parseObject(responseVo.getJsonResult(), cl);
        } catch (Exception e) {
            logger.error("getOctopusResponse error",e);
            return null;
        }

    }

    /**
     * 获取ip
     * @param request
     * @return
     */
    public static String getIp2(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 获取头信息
     * @param request
     * @param key
     * @return
     * @throws BizException
     */
    public static String getHeaderValue(HttpServletRequest request,String key) throws BizException {

        if(null==request || StringUtils.isEmpty(key)) {
            throw new BizException(ErrorCode.ERROR);
        }

        return request.getHeader(key);

    }

    /**
     * 获取User-Agent
     * @param request
     * @return
     * @throws BizException
     */
    public static String getUserAgent(HttpServletRequest request) throws BizException {
        return getHeaderValue(request,"User-Agent");
    }

    /**
     * 获取Referer
     * @param request
     * @return
     * @throws BizException
     */
    public static String getReferer(HttpServletRequest request) throws BizException {
        return getHeaderValue(request,"Referer");
    }

    /**
     * 获得请求路径
     * @param request
     * @return
     */
    public static String getRequestPath(HttpServletRequest request) {
        String requestPath = request.getRequestURI() + "?" + request.getQueryString();
        if (requestPath.indexOf("?") > -1) {// 去掉其他参数
            requestPath = requestPath.substring(0, requestPath.indexOf("?"));
        }
        requestPath = requestPath.substring(request.getContextPath().length());// 去掉项目路径
        return requestPath;
    }

}
