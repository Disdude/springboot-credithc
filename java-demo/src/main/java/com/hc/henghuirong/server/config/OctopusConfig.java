package com.hc.henghuirong.server.config;

import com.github.ltsopensource.core.json.JSON;
import com.hc.henghuirong.server.annotation.Octupus;
import com.hc.henghuirong.server.common.bytecode.Proxy;
import com.hc.henghuirong.server.common.enums.ErrorCode;
import com.hc.henghuirong.server.common.util.RequestUtils;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.octopus.Exception;
import com.hc.henghuirong.server.octopus.MqRequestVo;
import com.hc.henghuirong.server.octopus.OctopusService;
import com.hc.henghuirong.server.octopus.OctopusServiceService;
import com.hc.henghuirong.server.service.FinanceManageProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * octopusConfig 设置
 * Created by wenzhiwei on 17-5-4.
 */
@Configuration
@EnableConfigurationProperties(OctopusProperties.class)
public class OctopusConfig {


    @Autowired
    private OctopusProperties octopusProperties;

    @Bean
    public OctopusService getOctopusService() throws MalformedURLException {

        OctopusServiceService octopusServiceService = new OctopusServiceService(new URL(octopusProperties.getWsdlLocation()));
        OctopusService octopusService = octopusServiceService.getOctopusServicePort();
        return octopusService;

    }

    @Bean
    public FinanceManageProxyService getFinanManageService() {

        return (FinanceManageProxyService) Proxy.getProxy(FinanceManageProxyService.class).newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(null==args || args.length!=1) {
                    throw new BizException(ErrorCode.ERROR);
                }

                MqRequestVo requestVo = RequestUtils.buildOctopusReq(method.getDeclaredAnnotation(Octupus.class).value(),"",octopusProperties.getSystemSign(), JSON.toJSONString(args[0]));

                return getOctopusService().mqSendRtRequest(requestVo);


            }
        });
    }

}
