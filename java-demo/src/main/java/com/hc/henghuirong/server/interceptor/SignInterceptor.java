package com.hc.henghuirong.server.interceptor;

import com.alibaba.fastjson.JSON;
import com.hc.henghuirong.server.common.enums.ErrorCode;
import com.hc.henghuirong.server.common.model.BaseObject;
import com.hc.henghuirong.server.common.model.auth.ThirdParty;
import com.hc.henghuirong.server.common.model.req.SignReq;
import com.hc.henghuirong.server.common.util.SignUtils;
import com.hc.henghuirong.server.config.Md5Properties;
import com.hc.henghuirong.server.controller.base.RestApi;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.auth.ThirdPartyService;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Wu.Kang on 2017/3/24.
 */
@Aspect
@Component
public class SignInterceptor implements Ordered{
    private static final Logger logger = LoggerFactory.getLogger(SignInterceptor.class);
    private final String signFieldName = "sign";
    private final String thirdIdFieldName = "thirdId";
    @Autowired
    Md5Properties propertiesConfig;

    @Autowired
    ThirdPartyService thirdPartyService;

    @Pointcut("@annotation(com.hc.henghuirong.server.annotation.VerySign)")
    public void requestSignCheckPointcut() {
    }

    @Around("requestSignCheckPointcut()")
    public Object checkSign(ProceedingJoinPoint jointPoint)
    {
        Object result = null;
        try {
            MethodSignature signature = (MethodSignature)jointPoint.getSignature();
            Method method = signature.getMethod();
            Object[] args = jointPoint.getArgs();
            if(args != null && args.length > 0 &&
                    !(args[0] instanceof HttpServletRequest)
                    && !(args[0] instanceof HttpServletResponse))
            {
                if(!supportSign(args[0]))
                {
                    result = jointPoint.proceed();
                }
                else {
                    Map<String, String> fieldMap = getAllFields(args[0]);
                    String key = getKey(fieldMap.get(thirdIdFieldName));
                    if (StringUtils.isEmpty(key) || !SignUtils.checkSign(fieldMap, key)) {
                        logger.info("method:{}|class:{}|param:{} sign verification failed.",
                                method.getName(),signature.getDeclaringType().getSimpleName(),
                                JSON.toJSONString(fieldMap));
                        result = new RestApi<String>() {
                            @Override
                            public String process() throws BizException {
                                throw new BizException(ErrorCode.SIGNVERIFYERROR);
                            }
                        }.execute();
                    } else {
                        logger.info("method:{}|class:{}|param:{} sign verification success.",
                                method.getName(),signature.getDeclaringType().getSimpleName(),
                                JSON.toJSONString(fieldMap));
                        result = jointPoint.proceed();
                    }
                }
            }

        }catch (Exception e) {
            logger.error("check sign error!",e);
        }finally {
            return result;
        }
    }

    //将对象转换成map
    private Map<String, String> getAllFields(Object object) throws IllegalAccessException
    {
        Map<String,String> fieldMap = new HashMap<>();
        Class<?> clazz = object.getClass();
        Field[] fields = null;
        if(clazz != null)
        {
            while (true) {
                if (clazz == null || clazz == BaseObject.class) {
                    break;
                } else {
                    fields = clazz.getDeclaredFields();
                    for(Field field: fields)
                    {
                        field.setAccessible(true);
                        fieldMap.put(field.getName(),
                                field.get(object) == null? "":field.get(object).toString());
                    }
                    clazz = clazz.getSuperclass();
                }
            }
        }
        return fieldMap;
    }

    //检查该请求是否支持验签
    boolean supportSign(Object request)
    {
        if(request == null)
        {
            return false;
        }
        return request.getClass().getSuperclass() == SignReq.class;
    }

    //根据第三方id获取key
    private String getKey(String thirdId)
    {
        if(!StringUtils.isEmpty(thirdId))
        {
            ThirdParty thirdParty = thirdPartyService.getByThirdId(thirdId);
            if(thirdParty != null && !StringUtils.isEmpty(thirdParty.getSecretKey()))
            {
                return thirdParty.getSecretKey();
            }
        }
        return Strings.EMPTY;
    }
    @Override
    public int getOrder()
    {
        return 1;
    }
}
