package com.tuling.security.distributed.salary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;


/**
 * @Auther: lxx
 * @Date: 2023/3/17 21:40
 * @Description:
 */
@Configuration
@EnableAuthorizationServer//启用资源服务
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启注解形式控制
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_SALARY = "salary"; //与授权客户端resourceId一致

    // @Autowired
    // private TokenStore tokenStore;

    /**
     * 配置资源服务安全
     * 用户及权限等信息从 tokenStore 读取，及异常处理
     *
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
            throws Exception {
        resources.resourceId(RESOURCE_SALARY) //资源ID
                .tokenServices(tokenServices()) //使用远程服务验证令牌的服务
                //使用jwt令牌,就不用调用远程验证服务了
               // .tokenStore(tokenStore)
                .stateless(true); //无状态模式
    }

    /**
     * 配置接口访问策略信息
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //校验请求
                .antMatchers("/order/**") // 路径匹配规则。
                .access("#oauth2.hasScope('all')") // 需要匹配scope
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //配置access_token远程验证策略。//auth/check_token
    // 使用JWT后就不需要了
    public ResourceServerTokenServices tokenServices(){
// DefaultTokenServices services = new DefaultTokenServices();
        RemoteTokenServices services = new RemoteTokenServices();
        services.setCheckTokenEndpointUrl("http://localhost:53020/uaa/oauth/check_token");
        services.setClientId("c1");
        services.setClientSecret("secret");
        return services;
    }


}
