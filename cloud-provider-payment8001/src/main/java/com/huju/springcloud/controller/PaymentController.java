package com.huju.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.huju.springcloud.entities.CommonResult;
import com.huju.springcloud.entities.Payment;
import com.huju.springcloud.service.PaymenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huju on 2020/4/6.
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymenService paymenService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("****** 插入数据:{}", payment.toString());
        int result = paymenService.create(payment);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功!", result);
        } else {
            return new CommonResult(300, "插入数据失败!", result);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymenService.getPaymentById(id);
        log.info("****** 当前服务端口号:{},查询结果:{}", serverPort, payment);
        if (null != payment) {
            return new CommonResult(200, "当前服务端口号:" + serverPort + " 查询成功!", payment);
        } else {
            return new CommonResult(300, "没有对应记录!");
        }
    }

    /**
     * 获取服务清单列表
     * 注意; 得开启 @EnableDiscoveryClient 注解才行
     *
     * @return
     */
    @GetMapping("/discovery")
    public Object discovery() {
        // 获取所有的服务名称
        List<String> services = discoveryClient.getServices();
        log.info("******* 服务名称清单:{}", services);

        // 根据服务名称,获取该名称的所有节点
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        log.info("******** 服务[CLOUD-PAYMENT-SERVICE],已找到的所有节点:{}", JSONObject.toJSONString(instances));

        return services;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
