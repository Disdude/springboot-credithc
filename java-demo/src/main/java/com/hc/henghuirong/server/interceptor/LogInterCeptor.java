package com.hc.henghuirong.server.interceptor;

import com.alibaba.fastjson.JSON;
import com.hc.henghuirong.server.common.util.RequestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Wu.Kang on 2017/3/22.
 */

@Component
@Aspect
public class LogInterCeptor implements Ordered {


    private static final Logger logger = LoggerFactory.getLogger(LogInterCeptor.class);

    /**
     * 定义拦截规则：拦截com.hc.henghuirong.server.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.hc.henghuirong.server.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()") //指定拦截器规则
    public Object Interceptor(ProceedingJoinPoint pjp) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        StringBuilder logStr = new StringBuilder();
        Method method = null;
        try {
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            method = signature.getMethod(); //获取被拦截的方法
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            logStr.append("restRequest|");
            logStr.append("uri:" + request.getRequestURI() + "|");
            logStr.append("class:" + getClassName(signature.getDeclaringTypeName(), ".") + "|");
            logStr.append("ip:" + RequestUtils.getIp2(request) + "|");
            logStr.append("requestMethod:" + request.getMethod() + "|");
            logStr.append("queryString:" + request.getQueryString() + "|");
            //获取方法调用参数
            Object[] args = pjp.getArgs();
            for (int i = 0; i < args.length; ++i) {
                //不处理这种类型的参数
                if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse) {
                    continue;
                }
                logStr.append("arg" + i + ":" + JSON.toJSONString(args[i]) + "|");
            }
            logger.info(logStr.toString() + " start!");
            if (result == null) {
                // 一切正常的情况下，继续执行被拦截的方法a
                result = pjp.proceed();
            }
            long costMs = System.currentTimeMillis() - beginTime;
            logStr.append("  end! timecost:" + costMs + "ms|");
        } catch (Throwable e) {

            throw e;
//            logStr.append(e.getMessage() + "|");
//            result = "error";
//            if (method.isAnnotationPresent(org.springframework.web.bind.annotation.ResponseBody.class)) {
//                result = new RestApi<String>() {
//                    @Override
//                    public String process() throws BizException {
//                        return "访问异常，请联系工程师wenzhiwei170313@creditch.com.";
//                    }
//                }.execute();
//            }
        } finally {
            logStr.append("return:" + JSON.toJSONString(result) + "|requestEnd");
            logger.info(logStr.toString());
            return result;
        }
    }

    /**
     * 拦截所有webservice方法和带ILog注解的方法
     */
    @Pointcut("execution(* com.hc.henghuirong.server.service..*(..)))")
    public void serviceMethodPointcut() {
    }

    @Around("serviceMethodPointcut()") //指定拦截器规则
    public Object serviceInterceptor(ProceedingJoinPoint pjp) {
        long beginTime = System.currentTimeMillis();
        MethodSignature sign = (MethodSignature) pjp.getSignature();
        Object result = null;
        //如果不是webservice方法
        if (!isWebServiceMethod(sign)) {
            try {
                result = pjp.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } finally {
                return result;
            }
        }
        //如果是webservice方法
        Method method = sign.getMethod();
        StringBuilder logStr = new StringBuilder();
        logStr.append("requestBegin|type:Soap|");
        try {
            logStr.append("methodName:" + method.getName() + "|");
            logStr.append("class:" + getClassName(sign.getDeclaringTypeName(), ".") + "|");
            Object[] args = pjp.getArgs();
            for (int i = 0; i < args.length; ++i) {
                logStr.append("arg" + i + ":" + JSON.toJSONString(args[i]) + "|");
            }
            logger.info(logStr.toString());
            result = pjp.proceed();
            long costMs = System.currentTimeMillis() - beginTime;
            logStr.delete(0, logStr.length());
            logStr.append("timecost:" + costMs + "ms|");
        } catch (Throwable e) {
            logStr.append(e.getMessage() + "|");
            result = "Error Occured";
        } finally {
            logStr.append("return:" + JSON.toJSONString(result) + "|requestEnd");
            logger.info(logStr.toString());
            return result;
        }
    }

    private String getClassName(String strClass, String delimiter) {
        if (org.springframework.util.StringUtils.isEmpty(delimiter)) {
            delimiter = ",";
        }
        if (!org.springframework.util.StringUtils.isEmpty(strClass)) {
            String[] str = org.springframework.util.StringUtils.tokenizeToStringArray(strClass, delimiter);
            if (str != null && str.length > 0) {
                return str[str.length - 1];
            }
        }
        return "";
    }

    private boolean isWebServiceMethod(MethodSignature methodSignature) {
        Method method = methodSignature.getMethod();
        Class<?> clazz = method.getDeclaringClass();
        //如果是共有方法且方法所在类有@webservice注解
        if (clazz.isAnnotationPresent(javax.jws.WebService.class) &&
                Modifier.isPublic(method.getModifiers())) {
            return true;
        }
        return false;
    }

    @Override
    public int getOrder()
    {
        return 2;
    }

}
