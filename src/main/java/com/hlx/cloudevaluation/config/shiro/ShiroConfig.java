package com.hlx.cloudevaluation.config.shiro;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: shiro配置类
 * @author: hlx 2018-08-19
 **/
@Configuration
public class ShiroConfig {

    // 注册管理器
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(AuthService authService) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //设置自定义认证服务
        manager.setRealm(authService);
        //使用容器的session(之后被spring-session拦截)
        manager.setSessionManager(new ServletContainerSessionManager());
        //关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        manager.setSubjectDAO(subjectDAO);
        manager.setSubjectFactory(new DefaultWebSubjectFactory() {
            @Override
            public Subject createSubject(SubjectContext context) {
                context.setSessionCreationEnabled(false);
                return super.createSubject(context);
            }
        });
        return manager;
    }

    // 注册拦截器
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 添加自定义的拦截器authFilter,用于自定义登录处理逻辑
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("authFilter", new AuthFilter());
        filterMap.put("corsFilter", new CORSFilter());
        factoryBean.setFilters(filterMap);
        factoryBean.setSecurityManager(securityManager);
        Map<String, String> filterRuleMap = new HashMap<>();

        // cors
        filterRuleMap.put("/**", "corsFilter");

        // 匿名访问接口
        filterRuleMap.put("/user/register", "anon");
        filterRuleMap.put("/user/login", "anon");

        // swagger-ui匿名访问
        filterRuleMap.put("/swagger-resources/**", "anon");
        filterRuleMap.put("/v2/api-docs", "anon");
        filterRuleMap.put("/swagger-ui.html", "anon");
        filterRuleMap.put("/webjars/**", "anon");

        // 静态资源
        filterRuleMap.put("/page/static/**", "anon");
        filterRuleMap.put("/page/**", "anon");

        // 测试
        filterRuleMap.put("/connect/test", "anon");

        // 需要登录的接口
        filterRuleMap.put("/**", "authFilter");
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }

    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
