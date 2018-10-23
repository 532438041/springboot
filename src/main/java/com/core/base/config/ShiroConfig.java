package com.core.base.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/7/9 10:10
 */
//@Configuration
public class ShiroConfig {

    private Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Value("${server.servlet.path}")
    private String serverPath;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        logger.info("ShiroConfig.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 注意过滤器配置顺序 不能颠倒
        // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        filterChainDefinitionMap.put("/**/logout", "logout");
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/**/static/**", "anon");
        filterChainDefinitionMap.put("/**/login", "anon");
        filterChainDefinitionMap.put("/**/test/**", "anon");

        //不拦截swagger-ui
//        filterChainDefinitionMap.put("/**/swagger-ui.html", "anon");
//        filterChainDefinitionMap.put("/**/webjars/**", "anon");

        filterChainDefinitionMap.put("/**", "authc");
        // 配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl(serverPath + "/unauth");
        // 登录成功后要跳转的链接
        // shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面;
        // shiroFilterFactoryBean.setUnauthorizedUrl(serverPath + "/unauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
