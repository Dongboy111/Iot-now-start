package com.ydh.iotauto.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import com.ydh.iotauto.realm.LoginRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.Hashtable;
import java.util.Map;


@Configuration
//@EnableWebFlux
public class ShiroConfig {



    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean() ;
        factoryBean.setSecurityManager(defaultWebSecurityManager);

        //权限设置
        Map<String,String> map = new Hashtable<>() ;
        map.put("/test/test1","authc") ;
        map.put("/test/test2","perms[manage]") ;
        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/test/login");
        System.out.println("DefaultWebSecurityManager 过滤器注册完成");
        return factoryBean ;
    }


    @Bean
    public DefaultWebSecurityManager SecurityManager(@Qualifier("loginRealm") LoginRealm loginRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager() ;
        manager.setRealm(loginRealm);
        System.out.println("DefaultWebSecurityManager 安全管理器注册完成 ");
        return manager ;
    }

    @Bean
    public LoginRealm loginRealm(){

//        修改凭证校验匹配器
        LoginRealm loginRealm = new LoginRealm() ;

        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher() ;
//        设置加密算法为md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        loginRealm.setCredentialsMatcher(credentialsMatcher);
        return loginRealm ;
    }




}
