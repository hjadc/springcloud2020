package com.huju.springcloud.service;

import com.huju.springcloud.entities.Payment;

/**
 * Created by huju on 2020/4/6.
 */
public interface PaymenService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
