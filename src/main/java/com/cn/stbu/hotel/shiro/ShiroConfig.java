package com.cn.stbu.hotel.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: Shiro配置类
 * Datetime:    2020/4/2 0002   21:52
 * Author:  IDEA
 * @Qualifier 获取在spring容器中的bean
 */
@Configuration
public class ShiroConfig {
    /*
    * 创建一个 ShiroFiterFactoryBean
    * */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        /**
         * shiro内置过滤器 ，可以实现权限相关的拦截器
         *  常用的过滤器：
         *  anon:   无需认证（登录），可以访问
         *  authc:  必须认证才可以访问
         *  user: 如果使用Remember-Me功能，可以直接访问
         *  perms: 该资源必须资源权限才可以访问
         *  role: 该资源必须得到角色权限才可以访问
        */
        Map<String ,String > filterMap = new LinkedHashMap<String ,String >();
//        //anon   不认证通过
//        filterMap.put("/test","anon");   //test无需认证     这个要放在前面
//        //perms  授权过滤器
//        filterMap.put("/add","perms[user:add]");    //perms的内容是自定义的
//        filterMap.put("/update","perms[user:update]");

        filterMap.put("/text/login","anon");   //login无需认证     这个要放在前面
        filterMap.put("/text/register","anon");
        filterMap.put("/text/toRegister","anon");
        filterMap.put("/text/admin/**","roles[admin]");
        filterMap.put("/text/user/**","roles[user]");
        filterMap.put("/text/v/**","roles[vip]");
        //authc  认证通过       当授权拦截发生时，会自动跳转到一个指定提示页面
        filterMap.put("/text/**","authc");    //所有的页面认证

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //配置登录页面    当处理请求时，服务器检查是否需要登录，如果要但是没有登录的话就要自动跳转到 登录页面
        shiroFilterFactoryBean.setLoginUrl("/text/toLogin");
        //配置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/text/unAuth");
        return shiroFilterFactoryBean;
    }
    /*
     * 创建一个 defaultWebSecurityManager  安全管理器
     *
     * */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userealm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }
    /*
     * 创建Realm
     * */

    @Bean
    public UserRealm userealm(){
        UserRealm userealm = new UserRealm();
        //设置认证密码算法以及迭代复杂度
        userealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userealm;
    }
    /**
     *  凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理）
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(ShiroKit.hashIterations);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        System.out.println("md5");
        return hashedCredentialsMatcher;
    }

    /**
     *
     * 配置ShiroDialect，用于thymeleaf 和 shiro配合使用
     * */
    @Bean
    public ShiroDialect getshiroDialect(){
        return  new ShiroDialect();
    }

    @Bean
    public EnterpriseCacheSessionDAO sessionDAO(){
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        //会话Id生成器 默认为JavaUuidSessionIdGenerator  通过java.util.UUID生成
        sessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        return sessionDAO;
    }
    /**
     * 会话管理器
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO());
        //全局会话超时时间
        sessionManager.setGlobalSessionTimeout(1000000);//1000s
        //删除失效的session
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }
}
