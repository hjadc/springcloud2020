package com.huju.springcloid.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by huju on 2020/5/2.
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
