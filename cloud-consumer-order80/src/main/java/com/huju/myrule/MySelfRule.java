package com.huju.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义访问某个服务时ribbon为随机算法
 * 注意:
 * 1.一定不要@ComponentScan(主启动类同级及子级)能扫描到的地方,否则会变成全局的了
 * 2.需要在启动类上加上注解才生效 @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
 * Created by huju on 2020/5/2.
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 定义ribbon为随机算法 默认为轮询
        return new RandomRule();
    }
}
