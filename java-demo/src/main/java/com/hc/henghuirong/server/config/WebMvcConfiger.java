package com.hc.henghuirong.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.GET})
@Configuration
public class WebMvcConfiger extends WebMvcConfigurerAdapter {

//    @Bean
//    UserSecurityInterceptor userSecurityInterceptor() {
//        return new UserSecurityInterceptor();
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(userSecurityInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }

}
