package com.huju.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huju on 2020/5/2.
 */
@Configuration
@Slf4j
public class ApplacationContextConfig {

    @Bean
    @LoadBalanced        // 开启负载均衡
    public RestTemplate getRestTemplate() {
        log.info("********** 获取 RestTemplate *********");
        return new RestTemplate();
    }
}
