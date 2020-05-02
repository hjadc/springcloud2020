package com.huju.springcloud.service.impl;

import com.huju.springcloud.dao.PaymentDao;
import com.huju.springcloud.entities.Payment;
import com.huju.springcloud.service.PaymenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huju on 2020/4/6.
 */
@Service
public class PaymenServiceImpl implements PaymenService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
