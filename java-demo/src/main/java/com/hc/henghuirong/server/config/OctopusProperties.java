package com.hc.henghuirong.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * octopus 配置
 * Created by wenzhiwei on 17-5-4.
 */
@ConfigurationProperties(prefix = "server.octopus")
public class OctopusProperties {

    private String wsdlLocation;

    private String systemSign;

    public String getSystemSign() {
        return systemSign;
    }

    public void setSystemSign(String systemSign) {
        this.systemSign = systemSign;
    }

    public String getWsdlLocation() {
        return wsdlLocation;
    }

    public void setWsdlLocation(String wsdlLocation) {
        this.wsdlLocation = wsdlLocation;
    }
}
