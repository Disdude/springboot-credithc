package com.hc.henghuirong.server.config;

import com.hc.henghuirong.server.interceptor.UrlSecurityInterceptor;
import com.hc.henghuirong.server.service.auth.UserSecurityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.util.RedirectUrlBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenzhiwei on 17-3-16.
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected UserSecurityService userSecurityService;


    @Autowired
    protected Md5PasswordEncoder md5PasswordEncoder;


    private String key = "wenzhwiei";

    private static final String[] ignorePathMatchers = new String[]{"/check/sign",
            "/henghr/*", "/to-login", "/assets/css/*", "/assets/img/*", "/assets/js/*", "/soap/*"
            , "/**/*.js", "/**/*.js.map", "/**/*.ts", "/**/*.css", "/**/*.css.map", "/**/*.png",
            "/**/*.gif", "/**/*.jpg", "/**/*.fco", "/**/*.woff","/**/*.jpeg","/**/*.woff2",
            "/**/*.font", "/**/*.svg", "/**/*.ttf", "/**/*.pdf", "/*.ico",
            "/admin/api/**", "/404", "/401", "/403", "/error","/sign/check","/cxf/**"};


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable();
        //http.headers().disable();
        http.jee().disable();
        http.x509().disable();
        http.servletApi().disable();
        http.anonymous().disable();
        http.requestCache().disable();
        http.csrf().disable();
        http.rememberMe().userDetailsService(userSecurityService).key(key).useSecureCookie(true).alwaysRemember(false);
        http.addFilterAt(urlSecurityInterceptor(), FilterSecurityInterceptor.class);//处理自定义的权限
        //http.authorizeRequests();//对应FilterSecurityInterceptor，不配置就不会加入FilterSecurityInterceptor
        http.formLogin().loginProcessingUrl("/login").loginPage("/login").defaultSuccessUrl("/").successHandler(new AuthenticationSuccessHandler());
        http.logout().logoutSuccessHandler(new LogoutSuccessHandler());
        http.exceptionHandling().authenticationEntryPoint(new MyAuthenticationEntryPoint()).accessDeniedHandler(new MyAccessDeniedHandler());
    }


    @Bean
    public UrlSecurityInterceptor urlSecurityInterceptor() {
        return new UrlSecurityInterceptor();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(md5PasswordEncoder);
        provider.setUserDetailsService(userSecurityService);
        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("getSalt");
        provider.setSaltSource(saltSource);
        auth.authenticationProvider(provider);

    }

    @Bean
    protected AccessDecisionManager accessDecisionManager() {
        RoleVoter roleVoter = new RoleVoter();
        roleVoter.setRolePrefix("");
        List voters = new ArrayList<>();
        voters.add(roleVoter);
        AccessDecisionManager accessDecisionManager = new AffirmativeBased(voters);
        return accessDecisionManager;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(ignorePathMatchers);
    }

    //由于springboot默认会将所要的servlet,filter,listenr等标准servlet组件自动加入到servlet的过滤器链中，自定义的UrlSecurityInterceptor只希望加入security的过滤器链，中，所以这里配置不向servlet容器中注册
    @Bean
    public FilterRegistrationBean registration(UrlSecurityInterceptor filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    protected boolean isAjax(HttpServletRequest request) {
        return StringUtils.isNotBlank(request.getHeader("X-Requested-With"));
    }


    private class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication)
                throws ServletException, IOException {

            clearAuthenticationAttributes(request);

            String ru = (String) request.getSession().getAttribute("ru");
            request.getSession().removeAttribute("ru");

            if (StringUtils.isNotEmpty(ru)) {
                response.sendRedirect(ru);
            }

            if (!isAjax(request)) {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        }
    }

    private class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest request,
                                    HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {

            if (!isAjax(request)) {
                super.onLogoutSuccess(request, response, authentication);
            }
        }
    }

    private class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request,
                             HttpServletResponse response,
                             AuthenticationException authException) throws IOException, ServletException {
            String returnUrl = buildHttpReturnUrlForRequest(request);
            request.getSession().setAttribute("ru", returnUrl);

            response.setCharacterEncoding("utf-8");
            if (isAjax(request)) {
                response.getWriter().println("请登录");
            } else {
                response.sendRedirect("/login");
            }

        }
    }

    protected String buildHttpReturnUrlForRequest(HttpServletRequest request)
            throws IOException, ServletException {


        RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();
        urlBuilder.setScheme("http");
        urlBuilder.setServerName(request.getServerName());
        urlBuilder.setPort(request.getServerPort());
        urlBuilder.setContextPath(request.getContextPath());
        urlBuilder.setServletPath(request.getServletPath());
        urlBuilder.setPathInfo(request.getPathInfo());
        urlBuilder.setQuery(request.getQueryString());

        return urlBuilder.getUrl();
    }

    private class MyAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
            response.setCharacterEncoding("utf-8");
            if (isAjax(request)) {
                response.getWriter().println("您无权访问");
            } else {
                response.sendRedirect("/403");
            }

        }
    }

}
