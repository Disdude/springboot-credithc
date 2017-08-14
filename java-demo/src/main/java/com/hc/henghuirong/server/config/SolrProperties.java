package com.hc.henghuirong.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hu.cong.cong on 2017/6/14.
 */
@ConfigurationProperties(prefix = "server.solr")
public class SolrProperties {

    private String host;
    private String zkHost;
    private String defaultCollection;


    public String getDefaultCollection() {
        return defaultCollection;
    }
    public void setDefaultCollection(String defaultCollection) {
        this.defaultCollection = defaultCollection;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getZkHost() {
        return zkHost;
    }
    public void setZkHost(String zkHost) {
        this.zkHost = zkHost;
    }


}
