package com.tuling.security.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Auther: lxx
 * @Date: 2023/3/17 14:19
 * @Description:
 */
@Configuration
public class TokenConfig {
    @Bean
    public TokenStore tokenStore() {
//使用基于内存的普通令牌
        return new InMemoryTokenStore();
    }

    private static final String SIGN_KEY="uaa";

    // @Bean
    //  public TokenStore tokenStore() {
    //   return new JwtTokenStore(accessTokenConvert());
    //
    // }

    // @Bean
    // public JwtAccessTokenConverter accessTokenConvert(){
    //     JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    //     converter.setSigningKey(SIGN_KEY);
    //     return converter;
    // }
}
