package com.huju.springcloid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 该模块所有的配置bean
 * Created by huju on 2020/5/1.
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced // 开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
