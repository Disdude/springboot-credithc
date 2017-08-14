package com.hc.henghuirong.server.config;


import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import com.hc.henghuirong.server.interceptor.UserSecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * Created by wenzhiwei on 17-3-27.
 */
@Configuration
public class RequstMappingConfig extends WebMvcConfigurationSupport {
    @Bean
    UserSecurityInterceptor userSecurityInterceptor() {
        return new UserSecurityInterceptor();
    }

    /**
     * 添加IP拦截器，ApiVersion
     * @return
     */
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new ApiVersionRequestMappingHandlerMapping("v");
        handlerMapping.setInterceptors(userSecurityInterceptor());
        return handlerMapping;
    }

    /**
     * 静态资源
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/public/bootstrap/");
        registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/public/dist/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/public/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/public/plugins/");
    }

}
